/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniko.softlang.companies.springboot.microservice.rest.services;

import de.uniko.softlang.companies.springboot.microservice.entities.domain.SalaryHistory1;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author nbreest
*/
@RepositoryRestResource(collectionResourceRel = "salaries", path = "salaries")
public interface Salary1Repository extends JpaRepository<SalaryHistory1, Long> {
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
    
    @Override
    @RestResource(exported = false)
    void deleteAllInBatch();
    
    @Override
    @RestResource(exported = false)
    void delete(SalaryHistory1 entity);
    
    @Override
    @RestResource(exported = false)
    void delete(Long ID);
    
    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends SalaryHistory1> ent);
    
    @Override
    @RestResource(exported = false)
    public void deleteInBatch(Iterable<SalaryHistory1> entities);    
    
    @Override
    @RestResource(exported = false)
    public <S extends SalaryHistory1> S save(S entity);
    
    @Override
    @RestResource(exported = false)
    public <S extends SalaryHistory1> List<S> save(Iterable<S> arg0);

    @Override
    @RestResource(exported = false)
    public <S extends SalaryHistory1> S saveAndFlush(S entity);
    
    
}
