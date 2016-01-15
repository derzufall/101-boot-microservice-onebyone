/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniko.softlang.companies.springboot.microservice.entities.actions;

import de.uniko.softlang.companies.springboot.microservice.absgeneric.AbstractEntity;
import de.uniko.softlang.companies.springboot.microservice.entities.domain.Employee1;
import de.uniko.softlang.companies.springboot.microservice.entities.domain.HasEmployee1List;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 *
 * @author nbreest
 */
@Entity
public class Cut2 extends AbstractEntity {
  /*  
    @Basic
    private CutStateEnum state;

    public CutStateEnum getState() {
        return state;
    }

    public void setState(CutStateEnum state) {
        this.state = state;
    }

    public List<Employee1> getCutlist() {
        return cutlist;
    }

   /* public void setCutlist(<? extends HasEmployee1List> cutlist) {
        cutlist.stream().forEach(emp -> this.cutlist.addAll(emp.getEmployees()));
    }*/
    /*
    private List<Employee1> cutlist;

    @Override
    public List<Employee1> getEmployees() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
