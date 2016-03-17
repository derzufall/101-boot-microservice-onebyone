/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniko.softlang.companies.springboot.microservice.entities.domain;

import de.uniko.softlang.companies.springboot.microservice.entities.actions.Cut;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nbreest
 */
@Entity
@Table(name = "salary_hist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalaryHist.findAll", query = "SELECT s FROM SalaryHist s"),
    @NamedQuery(name = "SalaryHist.findById", query = "SELECT s FROM SalaryHist s WHERE s.id = :id"),
    @NamedQuery(name = "SalaryHist.findByCompanyName", query = "SELECT s FROM SalaryHist s WHERE s.companyName = :companyName"),
    @NamedQuery(name = "SalaryHist.findByDepartmentName", query = "SELECT s FROM SalaryHist s WHERE s.departmentName = :departmentName"),
    @NamedQuery(name = "SalaryHist.findByCreated", query = "SELECT s FROM SalaryHist s WHERE s.created = :created"),
    @NamedQuery(name = "SalaryHist.findByAmount", query = "SELECT s FROM SalaryHist s WHERE s.amount = :amount")})
public class SalaryHist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(max = 255)
    @Column(name = "company_name", length = 255)
    private String companyName;
    @Size(max = 255)
    @Column(name = "department_name", length = 255)
    private String departmentName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "amount")
    private BigInteger amount;
    @JoinColumn(name = "cut_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cut cutId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Employee employeeId;

    public SalaryHist() {
    }

    public SalaryHist(Long id) {
        this.id = id;
    }

    public SalaryHist(Long id, Date created) {
        this.id = id;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public Cut getCutId() {
        return cutId;
    }

    public void setCutId(Cut cutId) {
        this.cutId = cutId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalaryHist)) {
            return false;
        }
        SalaryHist other = (SalaryHist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.uniko.softlang.companies.springboot.microservice.entities.generated.SalaryHist[ id=" + id + " ]";
    }

}
