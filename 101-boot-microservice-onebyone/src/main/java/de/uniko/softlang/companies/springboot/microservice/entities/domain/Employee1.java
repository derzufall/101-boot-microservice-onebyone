/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniko.softlang.companies.springboot.microservice.entities.domain;

import de.uniko.softlang.companies.springboot.microservice.absgeneric.AbstractEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author nbreest
 */
// "Employee names are unique across companies."
//                  = Every company may have their own "Joe"
@Table(
        uniqueConstraints
        = @UniqueConstraint(columnNames = {"name", "company_id"})
)
@Entity
public class Employee1 extends AbstractEntity implements Serializable {

    @NotNull
    @Column(nullable = false)
    @Size(min = 1, max = 255)
    private String name;

    
    
    @NotNull
    @ManyToOne(optional = false)
    private Company1 company;

    @NotNull
    @ManyToOne(optional = false)
    private Department1 department;

    
    
    @OneToMany(mappedBy = "manager")
    private List<Department1> manages;

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company1 getCompany() {
        return company;
    }

    public void setCompany(Company1 company) {
        this.company = company;
    }

    public Department1 getDepartment() {
        return department;
    }

    public void setDepartment(Department1 department) {
        this.department = department;
    }

    public List<Department1> getManages() {
        return manages;
    }

    public void setManages(List<Department1> manages) {
        /* Theres a bug in SpringDataRest2.4.0 that doesnt allow 
         the owned(Many) side of a OneToMany relation to be altered.
         However, this setter gets called correctly, 
         so we can use this as a workaround: */

        // Unlink all departments from this employee as manager.
        this.manages.stream()
                //.filter(currentManagedDeps -> !manages.contains(currentManagedDeps))
                .forEach((dep) -> {
                    System.out.println("oldDEPARTMENT: " + dep.getName());
                    dep.setManager(null);
                });

        // (Re)establish a link with all given departments.
        manages.stream()
                // Filter to select all departments, that this employee does not manage
                //.filter(newManagedDeps -> !newManagedDeps.getManager().equals(this))
                .forEach((dep) -> {
                    System.out.println("newDEPARTMENT: " + dep.getName());
                    dep.setManager(this);
                });

        //manages.toString();
        this.manages = manages;
    }
}
