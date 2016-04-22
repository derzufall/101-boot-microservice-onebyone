/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniko.softlang.companies.springboot.microservice.rest.services;

import de.uniko.softlang.companies.springboot.microservice.entities.domain.SalaryHist;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author nbreest
 */
@RepositoryRestResource(collectionResourceRel = "salaries", path = "salaries")
public interface SalaryRepository extends JpaRepository<SalaryHist, Long> {

    @Override
    @RestResource(exported = false)
    void deleteAll();

    @Override
    @RestResource(exported = false)
    void deleteAllInBatch();

    @Override
    @RestResource(exported = false)
    void delete(SalaryHist entity);

    @Override
    @RestResource(exported = false)
    void delete(Long ID);

    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends SalaryHist> ent);

    @Override
    @RestResource(exported = false)
    public void deleteInBatch(Iterable<SalaryHist> entities);

    @Override
    @RestResource(exported = false)
    public <S extends SalaryHist> S save(S entity);

    @Override
    @RestResource(exported = false)
    public <S extends SalaryHist> List<S> save(Iterable<S> arg0);

    @Override
    @RestResource(exported = false)
    public <S extends SalaryHist> S saveAndFlush(S entity);

}
