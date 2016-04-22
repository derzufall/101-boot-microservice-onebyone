/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniko.softlang.companies.springboot.microservice.rest.eventhandlers;

import de.uniko.softlang.companies.springboot.microservice.business.suityourself.DepartmentChangePropagator;
import de.uniko.softlang.companies.springboot.microservice.entities.domain.Department;
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
public class DepartmentEvents {

    @HandleBeforeCreate
    public void beforeCreate(Department entity) {
        // Before create:

    }

    @HandleAfterCreate
    public void afterCreate(Department entity) {
        // After create:
        //  - make new totavg of the department
        DepartmentChangePropagator.newDepartment(entity);
    }

    @HandleBeforeSave
    public void beforeSave(Department entity) {

    }

    @HandleAfterSave
    public void afterSave(Department entity) {

    }

    @HandleBeforeDelete
    public void beforeDelete(Department entity) {

    }

    @HandleAfterDelete
    public void afterDelete(Department entity) {

    }
}
