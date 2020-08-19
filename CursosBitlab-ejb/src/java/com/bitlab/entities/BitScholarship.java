/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Maury
 */
@Entity
@Table(name = "bit_scholarship", catalog = "bd_bitlab", schema = "")
@NamedQueries({
    @NamedQuery(name = "BitScholarship.findAll", query = "SELECT b FROM BitScholarship b")
    , @NamedQuery(name = "BitScholarship.findBySchId", query = "SELECT b FROM BitScholarship b WHERE b.schId = :schId")
    , @NamedQuery(name = "BitScholarship.findBySchLevelName", query = "SELECT b FROM BitScholarship b WHERE b.schLevelName = :schLevelName")
    , @NamedQuery(name = "BitScholarship.findByADateCreate", query = "SELECT b FROM BitScholarship b WHERE b.aDateCreate = :aDateCreate")
    , @NamedQuery(name = "BitScholarship.findByAUserCreate", query = "SELECT b FROM BitScholarship b WHERE b.aUserCreate = :aUserCreate")
    , @NamedQuery(name = "BitScholarship.findByADateChange", query = "SELECT b FROM BitScholarship b WHERE b.aDateChange = :aDateChange")
    , @NamedQuery(name = "BitScholarship.findByAUserChange", query = "SELECT b FROM BitScholarship b WHERE b.aUserChange = :aUserChange")})
public class BitScholarship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sch_id", nullable = false)
    private Integer schId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "sch_level_name", nullable = false, length = 100)
    private String schLevelName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "a_date_create", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date aDateCreate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "a_user_create", nullable = false, length = 50)
    private String aUserCreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "a_date_change", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date aDateChange;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "a_user_change", nullable = false, length = 50)
    private String aUserChange;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schId", fetch = FetchType.LAZY)
    private List<BitStudent> bitStudentList;

    public BitScholarship() {
    }

    public BitScholarship(Integer schId) {
        this.schId = schId;
    }

    public BitScholarship(Integer schId, String schLevelName, Date aDateCreate, String aUserCreate, Date aDateChange, String aUserChange) {
        this.schId = schId;
        this.schLevelName = schLevelName;
        this.aDateCreate = aDateCreate;
        this.aUserCreate = aUserCreate;
        this.aDateChange = aDateChange;
        this.aUserChange = aUserChange;
    }

    public Integer getSchId() {
        return schId;
    }

    public void setSchId(Integer schId) {
        this.schId = schId;
    }

    public String getSchLevelName() {
        return schLevelName;
    }

    public void setSchLevelName(String schLevelName) {
        this.schLevelName = schLevelName;
    }

    public Date getADateCreate() {
        return aDateCreate;
    }

    public void setADateCreate(Date aDateCreate) {
        this.aDateCreate = aDateCreate;
    }

    public String getAUserCreate() {
        return aUserCreate;
    }

    public void setAUserCreate(String aUserCreate) {
        this.aUserCreate = aUserCreate;
    }

    public Date getADateChange() {
        return aDateChange;
    }

    public void setADateChange(Date aDateChange) {
        this.aDateChange = aDateChange;
    }

    public String getAUserChange() {
        return aUserChange;
    }

    public void setAUserChange(String aUserChange) {
        this.aUserChange = aUserChange;
    }

    public List<BitStudent> getBitStudentList() {
        return bitStudentList;
    }

    public void setBitStudentList(List<BitStudent> bitStudentList) {
        this.bitStudentList = bitStudentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schId != null ? schId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitScholarship)) {
            return false;
        }
        BitScholarship other = (BitScholarship) object;
        if ((this.schId == null && other.schId != null) || (this.schId != null && !this.schId.equals(other.schId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.BitScholarship[ schId=" + schId + " ]";
    }
    
}
