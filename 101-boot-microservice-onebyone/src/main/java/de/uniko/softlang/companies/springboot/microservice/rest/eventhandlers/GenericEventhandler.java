/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniko.softlang.companies.springboot.microservice.rest.eventhandlers;

import de.uniko.softlang.companies.springboot.microservice.entities.domain.Company;
import de.uniko.softlang.companies.springboot.microservice.entities.domain.Department;
import de.uniko.softlang.companies.springboot.microservice.entities.domain.Employee;
import de.uniko.softlang.companies.springboot.microservice.entities.domain.SalaryHist;
import de.uniko.softlang.companies.springboot.microservice.rest.services.EmployeeRepository;
import de.uniko.softlang.companies.springboot.microservice.rest.services.*;
import java.time.DateTimeException;
import javax.inject.Inject;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author nbreest
 */
@Component // so this is instanciated by the container
@ControllerAdvice // so spring knows exceptionhandling is done in here
@RepositoryEventHandler // eventhandling is done here too, can be narrowed by (Object.class)
public class GenericEventhandler {

    @Inject
    EmployeeRepository employeeRepo;
    @Inject
    SalaryRepository salaryRepo;

    @HandleAfterCreate
    public void handleAfterCreate(Employee entity) {
        //SalaryHist newSalary = new SalaryHist(entity, entity.getSalary());
        //salaryRepo.save(newSalary);
    }

    public void handleAfterCreate(SalaryHist entity) {
        System.out.println("SALARY CREATED");
    }

    @HandleBeforeSave
    public void handleBeforeSave(Employee entity) {

    }

    @HandleBeforeDelete
    public void handleBeforeDelete(Employee entity) {

    }

    @HandleBeforeDelete
    public void handleBeforeDelete(Department entity) {

    }

    @HandleBeforeDelete
    public void handleBeforeDelete(Company entity) {

    }

    /*
    @ExceptionHandler(DateTimeException.class) // handle this exception
    @ResponseStatus(HttpStatus.BAD_REQUEST) // send this response status
    @ResponseBody // this method returns a custom response body
    GenericEntity handleBadDate(final DateTimeException e) {
        return this.e;
    }*//*
    @ExceptionHandler(Exception.class) // handle this exception
    @ResponseStatus(HttpStatus.BAD_REQUEST) // send this response status
    @ResponseBody // this method returns a custom response body
    Exception handleAnyUncaughtException(final Exception e) {
        return e;
    }
    /*
    @ExceptionHandler(Exception.class) // handle this exception
    @ResponseStatus(HttpStatus.BAD_REQUEST) // send this response status
    void handleAnyUncaughtExceptionSilently(final Exception e) {}
     */
}
