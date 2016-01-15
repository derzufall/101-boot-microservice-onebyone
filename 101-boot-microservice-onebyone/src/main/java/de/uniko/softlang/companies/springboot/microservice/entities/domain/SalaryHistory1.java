/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniko.softlang.companies.springboot.microservice.entities.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.uniko.softlang.companies.springboot.microservice.absgeneric.AbstractEntity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.rest.core.annotation.RestResource;
/**
 *
 * @author nbreest
 */

@Entity
public class SalaryHistory1 extends AbstractEntity implements Serializable {
       
    @OneToOne
    private Employee1 employee;
    
    //http://stackoverflow.com/questions/24426644/spring-data-rest-detected-multiple-association-links-with-same-relation-type
    @OneToOne
    private Department1 department;
    
    @OneToOne
    private Company1 company;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    // This approach should not be used for auditing purposes.
    // The time saved to the DB actually deviates a bit from reality.
    // It will be a tiny bit earlier than the actual creation in the DB.
    // Still, this approach will fit the needs HERE in terms of business context.
    Date date;
    
    @NotNull
    @Basic(optional = false)
    private long amount = 0;

    public Employee1 getEmployee() {
        return employee;
    }

    public Department1 getDepartment() {
        return department;
    }

    public Company1 getCompany() {
        return company;
    }

    public Date getDate() {
        return date;
    }

    public long getAmount() {
        return amount;
    }

    public void removeCompany() {
        this.company = null;
    }
    
    public void removeDepartment() {
        this.department = null;
    }
        
    public void removeEmployee() {
        this.employee = null;
    }

    public SalaryHistory1(Employee1 employee, long amount) {
        this.employee = employee;
        this.department = employee.getDepartment();
        this.company = employee.getCompany();
        this.amount = amount;
        this.date = new Date();
    }

    public SalaryHistory1() {
    }
    
    @PostPersist
    private void px() {
        System.out.println("SALARY PERSISTEDDDD.");
    }
    
    
}
