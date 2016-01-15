/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniko.softlang.companies.springboot.microservice.entities.actions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.uniko.softlang.companies.springboot.microservice.absgeneric.AbstractEntity;
import de.uniko.softlang.companies.springboot.microservice.entities.domain.Company1;
import de.uniko.softlang.companies.springboot.microservice.entities.domain.Department1;
import de.uniko.softlang.companies.springboot.microservice.entities.domain.Employee1;
import de.uniko.softlang.companies.springboot.microservice.entities.domain.HasEmployee1List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * <ul> This is used to Cut <br/>
 * <li>a list of employees
 * <li>a single company
 * <li>a single department
 * <li>or any combination of the above</ul>
 * @author nbreest
 */
@Entity
public class Cut1 extends AbstractEntity implements Serializable {

    @Size(min = 1)
    @NotNull
    private String reason;
    
    @OneToMany
    @Column(updatable = false)
    private List<Employee1> employees = new ArrayList();

    // Its actually sad we "have" to do it this way in order to get the possibility
    // to work with bigger constructs and just use a single Cut Entity for it...
    @JoinColumn(updatable = false)
    @OneToOne
    private Department1 department;

    // Its actually sad we "have" to do it this way in order to get the possibility
    // to work with bigger constructs and just use a single Cut Entity for it...
    @JoinColumn(updatable = false)
    @OneToOne
    private Company1 company;

    public List<Employee1> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee1> employees) {
        this.employees.addAll(employees);
    }

    public Department1 getDepartment() {
        return department;
    }

    public void setDepartment(Department1 department) {
        //this.department = null; // this is the sad part, but we dont want any refrencing to these entities
        this.employees.addAll(department.getEmployees());
    }

    public Company1 getCompany() {
        return company;
    }

    public void setCompany(Company1 company) {
        //this.company = null; // this is the sad part, but we dont want any refrencing to these entities
        this.employees.addAll(company.getEmployees());
    }

    public Cut1() {
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
