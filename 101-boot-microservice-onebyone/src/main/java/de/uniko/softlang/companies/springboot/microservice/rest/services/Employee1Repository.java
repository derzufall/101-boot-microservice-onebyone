/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniko.softlang.companies.springboot.microservice.rest.services;

import de.uniko.softlang.companies.springboot.microservice.entities.domain.Employee1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author nbreest
 */
@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface Employee1Repository extends JpaRepository<Employee1, Long> {
    
}
