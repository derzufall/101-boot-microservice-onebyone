/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniko.softlang.companies.springboot.microservice.entities.actions;

import de.uniko.softlang.companies.springboot.microservice.entities.domain.Company;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nbreest
 */
@Entity
@Table(name = "totavg_company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TotavgCompany.findAll", query = "SELECT t FROM TotavgCompany t"),
    @NamedQuery(name = "TotavgCompany.findById", query = "SELECT t FROM TotavgCompany t WHERE t.id = :id"),
    @NamedQuery(name = "TotavgCompany.findByCreated", query = "SELECT t FROM TotavgCompany t WHERE t.created = :created"),
    @NamedQuery(name = "TotavgCompany.findByTotal", query = "SELECT t FROM TotavgCompany t WHERE t.total = :total"),
    @NamedQuery(name = "TotavgCompany.findByAvg", query = "SELECT t FROM TotavgCompany t WHERE t.avg = :avg")})
public class TotavgCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
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
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Company companyId;

    public TotavgCompany() {
    }

    public TotavgCompany(Long id) {
        this.id = id;
    }

    public TotavgCompany(Long id, Date created, long total, long avg) {
        this.id = id;
        this.created = created;
        this.total = total;
        this.avg = avg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
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
        if (!(object instanceof TotavgCompany)) {
            return false;
        }
        TotavgCompany other = (TotavgCompany) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.uniko.softlang.companies.springboot.microservice.entities.generated.TotavgCompany[ id=" + id + " ]";
    }

}
