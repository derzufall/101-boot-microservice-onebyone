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
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;
/**
 *
 * @author nbreest
 */
@Entity
public class Department1 extends AbstractEntity implements Serializable, HasEmployee1List {
    
    @NotNull
    @Size(min = 1, max = 255)
    @Column(unique=true, nullable = false)
    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    @Basic(optional = false)
    @ManyToOne
    private Company1 company;
    
    public Company1 getCompany() {
        return company;
    }

    public void setCompany(Company1 company) {
        this.company = company;
    }
    
    
    @ManyToOne
    private Employee1 manager;
    
    public Employee1 getManager() {
        return manager;
    }
    public void setManager(Employee1 manager) {
        this.manager = manager;
    }

    
    @Basic(optional = true)
    @OneToMany(mappedBy = "department", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Employee1> employees;    

    public List<Employee1> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee1> employees) {
        // TODO: Modifying things here might cause problems with orphans :-(
        // decouple all employees of this department.
        this.employees.stream()
                .forEach((emp) -> {
                    emp.setDepartment(null);
                });

        // (Re)establish a link with all given employees.
        employees.stream()
                .forEach((emp) -> {
                    emp.setDepartment(this);
                });

        this.employees = employees;
    }
    
    
    @ManyToOne
    private Department1 parentDepartment;
    
    @Basic(optional = true)
    @OneToMany(mappedBy = "parentDepartment", orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Department1> subDepartments;
    
    
    public Department1 getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(Department1 parentDepartment) {
        this.parentDepartment = parentDepartment;
    }
    
    public List<Department1> getSubDepartments() {
        return subDepartments;
    }

    public void setSubDepartments(List<Department1> subDepartments) {
        // TODO: Modifying things here might cause problems with orphans :-(
        
        /*// decouple all subdepartments of this department.
        this.subDepartments.stream()
                .forEach((subdep) -> {
                    subdep.setParentDepartment(null);
                });

        // (Re)establish a link with all given subdepartments with this dep. as parent.
        subDepartments.stream()
                .forEach((subdep) -> {
                    subdep.setParentDepartment(this);
                });
        */
        this.subDepartments = subDepartments;
    }

    
    
}