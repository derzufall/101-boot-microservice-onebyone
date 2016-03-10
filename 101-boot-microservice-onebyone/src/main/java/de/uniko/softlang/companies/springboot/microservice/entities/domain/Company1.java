/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniko.softlang.companies.springboot.microservice.entities.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.uniko.softlang.companies.springboot.microservice.absgeneric.AbstractEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 *
 * @author nbreest
 */

@Entity
public class Company1 extends AbstractEntity implements Serializable, HasEmployee1List {
    
    @Size(min = 1, max = 255)
    @Basic(optional = false)
    @NotNull
    @Column(unique=true, nullable = false)
    private String name;
      
    // sadly with SpringDataRest you cannot interact so well with the owned side of an assoc. (yet)
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Department1> departments;
    
    // sadly with SpringDataRest you cannot interact so well with the owned side of an assoc. (yet)
    @OneToMany(mappedBy = "company")
    private List<Employee1> employees;

    
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department1> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department1> departments) {
        // TODO: Modifying things here might cause problems with orphans :-(
        this.departments = departments;
    }

    @Override
    public List<Employee1> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee1> employees) {
        // TODO: Modifying things here might cause problems with orphans :-(
        // decouple all employees of this company.
        this.employees.stream()
                .forEach((emp) -> {
                    emp.setCompany(null);
                });

        // (Re)establish a link with all given company.
        employees.stream()
                .forEach((emp) -> {
                    emp.setCompany(this);
                });

        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company1{" + "name=" + name + '}';
    }
    
    
 
}
