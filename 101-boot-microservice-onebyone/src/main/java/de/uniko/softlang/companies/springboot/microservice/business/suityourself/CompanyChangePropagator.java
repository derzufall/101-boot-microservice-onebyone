/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniko.softlang.companies.springboot.microservice.business.suityourself;

import de.uniko.softlang.companies.springboot.microservice.entities.actions.TotavgCompany;
import de.uniko.softlang.companies.springboot.microservice.entities.domain.Company;
import de.uniko.softlang.companies.springboot.microservice.rest.services.TotavgCompanyRepository;
import java.util.Date;
import javax.inject.Inject;

/**
 * Shall propagate changes made to a Company to all relating Entities.
 *
 * @author nbreest
 */
public class CompanyChangePropagator {
    
    @Inject
    private static TotavgCompanyRepository companyTotalsRepo;
    
    public static Company newCompany(Company c) {
        return c;
    }
    
    public static Company saveCompany(Company c) {
        return makeTotal(c);
    }
    
    private static Company makeTotal(Company c) {
        long total;
        long numEmployees;
        long average;
        
        numEmployees = c.getEmployeeList().size();
        total = c.getEmployeeList().stream().mapToLong(a -> a.getSalary()).sum(); // Java8 way of summing
        average = total / numEmployees;
        
        TotavgCompany newTotal = new TotavgCompany();
        newTotal.setAvg(average);
        newTotal.setTotal(total);
        newTotal.setCompanyId(c);
        newTotal.setCreated(new Date());
        
        companyTotalsRepo.save(newTotal);
        
        return c;
    }
    
}
