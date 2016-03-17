/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniko.softlang.companies.springboot.microservice.entities.actions;

import de.uniko.softlang.companies.springboot.microservice.entities.domain.SalaryHist;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nbreest
 */
@Entity
@Table(name = "cut")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cut.findAll", query = "SELECT c FROM Cut c"),
    @NamedQuery(name = "Cut.findById", query = "SELECT c FROM Cut c WHERE c.id = :id"),
    @NamedQuery(name = "Cut.findByReason", query = "SELECT c FROM Cut c WHERE c.reason = :reason")})
public class Cut implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(max = 255)
    @Column(name = "reason", length = 255)
    private String reason;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cutId", fetch = FetchType.EAGER)
    private List<CutsPending> cutsPendingList;
    @OneToMany(mappedBy = "cutId", fetch = FetchType.EAGER)
    private List<SalaryHist> salaryHistList;

    public Cut() {
    }

    public Cut(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @XmlTransient
    public List<CutsPending> getCutsPendingList() {
        return cutsPendingList;
    }

    public void setCutsPendingList(List<CutsPending> cutsPendingList) {
        this.cutsPendingList = cutsPendingList;
    }

    @XmlTransient
    public List<SalaryHist> getSalaryHistList() {
        return salaryHistList;
    }

    public void setSalaryHistList(List<SalaryHist> salaryHistList) {
        this.salaryHistList = salaryHistList;
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
        if (!(object instanceof Cut)) {
            return false;
        }
        Cut other = (Cut) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.uniko.softlang.companies.springboot.microservice.entities.generated.Cut[ id=" + id + " ]";
    }

}
