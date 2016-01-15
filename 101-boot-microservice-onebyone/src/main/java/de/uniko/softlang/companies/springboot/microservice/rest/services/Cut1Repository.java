/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniko.softlang.companies.springboot.microservice.rest.services;

import de.uniko.softlang.companies.springboot.microservice.entities.actions.Cut1;
import de.uniko.softlang.companies.springboot.microservice.entities.domain.SalaryHistory1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author nbreest
*/
@RepositoryRestResource(collectionResourceRel = "cuts", path = "cuts")
public interface Cut1Repository extends JpaRepository<Cut1, Long> {
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
    
    @Override
    @RestResource(exported = false)
    void deleteAllInBatch();
    
    @Override
    @RestResource(exported = false)
    void delete(Cut1 entity);
    
    @Override
    @RestResource(exported = false)
    void delete(Long ID);
    
    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends Cut1> ent);
    
    @Override
    @RestResource(exported = false)
    public void deleteInBatch(Iterable<Cut1> entities);    
    
}
