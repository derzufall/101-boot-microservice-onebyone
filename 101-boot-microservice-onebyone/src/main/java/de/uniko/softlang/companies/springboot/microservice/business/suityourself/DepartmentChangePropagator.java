/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniko.softlang.companies.springboot.microservice.business.suityourself;

import de.uniko.softlang.companies.springboot.microservice.entities.actions.TotavgUnit;
import de.uniko.softlang.companies.springboot.microservice.entities.domain.Department;
import de.uniko.softlang.companies.springboot.microservice.entities.domain.Employee;
import de.uniko.softlang.companies.springboot.microservice.rest.services.TotavgUnitRepository;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;

/**
 * Shall propagate changes made to a Department to all relating Entities.
 *
 * @author nbreest
 */
public class DepartmentChangePropagator {

    @Inject
    private static TotavgUnitRepository totalUnitRepo;

    public static Department newDepartment(Department d) {

        return makeTotal(d);
    }

    private static Department makeTotal(Department d) {

        long total;
        long average;
        long numEmployees;

        long subTotal;
        long subAverage;
        long subNumEmployees;

        total = d.getEmployeeList().stream()
                .mapToLong(a -> a.getSalary())
                .sum(); // Java8 way of summing

        numEmployees = d.getEmployeeList().size();
        average = total / numEmployees;

        List<Employee> allSubEmployees = d.getDepartmentList().stream()
                .map(Department::getEmployeeList)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        allSubEmployees.addAll(d.getEmployeeList());

        subTotal = allSubEmployees.stream()
                .mapToLong(a -> a.getSalary())
                .sum(); // Java8 way of summing

        subNumEmployees = allSubEmployees.size();
        subAverage = subTotal / subNumEmployees;

        TotavgUnit newTotal = new TotavgUnit();
        newTotal.setDepartmentId(d);
        newTotal.setCompanyName(d.getCompanyId().getName());
        newTotal.setCreated(new Date());
        newTotal.setTotal(total);
        newTotal.setAvg(average);
        newTotal.setSubTotal(subTotal);
        newTotal.setSubAvg(subAverage);

        totalUnitRepo.save(newTotal);

        return d;
    }
}
