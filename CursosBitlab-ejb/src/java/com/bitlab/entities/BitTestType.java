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
@Table(name = "bit_test_type", catalog = "bd_bitlab", schema = "")
@NamedQueries({
    @NamedQuery(name = "BitTestType.findAll", query = "SELECT b FROM BitTestType b")
    , @NamedQuery(name = "BitTestType.findByTytId", query = "SELECT b FROM BitTestType b WHERE b.tytId = :tytId")
    , @NamedQuery(name = "BitTestType.findByTytTypeTestName", query = "SELECT b FROM BitTestType b WHERE b.tytTypeTestName = :tytTypeTestName")
    , @NamedQuery(name = "BitTestType.findByADateCreate", query = "SELECT b FROM BitTestType b WHERE b.aDateCreate = :aDateCreate")
    , @NamedQuery(name = "BitTestType.findByAUserCreate", query = "SELECT b FROM BitTestType b WHERE b.aUserCreate = :aUserCreate")
    , @NamedQuery(name = "BitTestType.findByADateChange", query = "SELECT b FROM BitTestType b WHERE b.aDateChange = :aDateChange")
    , @NamedQuery(name = "BitTestType.findByAUserChange", query = "SELECT b FROM BitTestType b WHERE b.aUserChange = :aUserChange")})
public class BitTestType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tyt_id", nullable = false)
    private Integer tytId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tyt_type_test_name", nullable = false, length = 100)
    private String tytTypeTestName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tytId", fetch = FetchType.LAZY)
    private List<BitTest> bitTestList;

    public BitTestType() {
    }

    public BitTestType(Integer tytId) {
        this.tytId = tytId;
    }

    public BitTestType(Integer tytId, String tytTypeTestName, Date aDateCreate, String aUserCreate, Date aDateChange, String aUserChange) {
        this.tytId = tytId;
        this.tytTypeTestName = tytTypeTestName;
        this.aDateCreate = aDateCreate;
        this.aUserCreate = aUserCreate;
        this.aDateChange = aDateChange;
        this.aUserChange = aUserChange;
    }

    public Integer getTytId() {
        return tytId;
    }

    public void setTytId(Integer tytId) {
        this.tytId = tytId;
    }

    public String getTytTypeTestName() {
        return tytTypeTestName;
    }

    public void setTytTypeTestName(String tytTypeTestName) {
        this.tytTypeTestName = tytTypeTestName;
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

    public List<BitTest> getBitTestList() {
        return bitTestList;
    }

    public void setBitTestList(List<BitTest> bitTestList) {
        this.bitTestList = bitTestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tytId != null ? tytId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitTestType)) {
            return false;
        }
        BitTestType other = (BitTestType) object;
        if ((this.tytId == null && other.tytId != null) || (this.tytId != null && !this.tytId.equals(other.tytId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.BitTestType[ tytId=" + tytId + " ]";
    }
    
}
