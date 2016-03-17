/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniko.softlang.companies.springboot.microservice.entities.actions;

import de.uniko.softlang.companies.springboot.microservice.entities.domain.Department;
import java.io.Serializable;
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
@Table(name = "totavg_unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TotavgUnit.findAll", query = "SELECT t FROM TotavgUnit t"),
    @NamedQuery(name = "TotavgUnit.findById", query = "SELECT t FROM TotavgUnit t WHERE t.id = :id"),
    @NamedQuery(name = "TotavgUnit.findByCompanyName", query = "SELECT t FROM TotavgUnit t WHERE t.companyName = :companyName"),
    @NamedQuery(name = "TotavgUnit.findByCreated", query = "SELECT t FROM TotavgUnit t WHERE t.created = :created"),
    @NamedQuery(name = "TotavgUnit.findByTotal", query = "SELECT t FROM TotavgUnit t WHERE t.total = :total"),
    @NamedQuery(name = "TotavgUnit.findByAvg", query = "SELECT t FROM TotavgUnit t WHERE t.avg = :avg"),
    @NamedQuery(name = "TotavgUnit.findBySubTotal", query = "SELECT t FROM TotavgUnit t WHERE t.subTotal = :subTotal"),
    @NamedQuery(name = "TotavgUnit.findBySubAvg", query = "SELECT t FROM TotavgUnit t WHERE t.subAvg = :subAvg")})
public class TotavgUnit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(max = 255)
    @Column(name = "company_name", length = 255)
    private String companyName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total", nullable = false)
    private long total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "avg", nullable = false)
    private long avg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_total", nullable = false)
    private long subTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_avg", nullable = false)
    private long subAvg;
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Department departmentId;

    public TotavgUnit() {
    }

    public TotavgUnit(Long id) {
        this.id = id;
    }

    public TotavgUnit(Long id, Date created, long total, long avg, long subTotal, long subAvg) {
        this.id = id;
        this.created = created;
        this.total = total;
        this.avg = avg;
        this.subTotal = subTotal;
        this.subAvg = subAvg;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getAvg() {
        return avg;
    }

    public void setAvg(long avg) {
        this.avg = avg;
    }

    public long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(long subTotal) {
        this.subTotal = subTotal;
    }

    public long getSubAvg() {
        return subAvg;
    }

    public void setSubAvg(long subAvg) {
        this.subAvg = subAvg;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
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
        if (!(object instanceof TotavgUnit)) {
            return false;
        }
        TotavgUnit other = (TotavgUnit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.uniko.softlang.companies.springboot.microservice.entities.generated.TotavgUnit[ id=" + id + " ]";
    }

}
