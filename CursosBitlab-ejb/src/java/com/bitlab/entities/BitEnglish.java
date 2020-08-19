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
@Table(name = "bit_english", catalog = "bd_bitlab", schema = "")
@NamedQueries({
    @NamedQuery(name = "BitEnglish.findAll", query = "SELECT b FROM BitEnglish b")
    , @NamedQuery(name = "BitEnglish.findByEngId", query = "SELECT b FROM BitEnglish b WHERE b.engId = :engId")
    , @NamedQuery(name = "BitEnglish.findByEngLevelName", query = "SELECT b FROM BitEnglish b WHERE b.engLevelName = :engLevelName")
    , @NamedQuery(name = "BitEnglish.findByADateCreate", query = "SELECT b FROM BitEnglish b WHERE b.aDateCreate = :aDateCreate")
    , @NamedQuery(name = "BitEnglish.findByAUserCreate", query = "SELECT b FROM BitEnglish b WHERE b.aUserCreate = :aUserCreate")
    , @NamedQuery(name = "BitEnglish.findByADateChange", query = "SELECT b FROM BitEnglish b WHERE b.aDateChange = :aDateChange")
    , @NamedQuery(name = "BitEnglish.findByAUserChange", query = "SELECT b FROM BitEnglish b WHERE b.aUserChange = :aUserChange")})
public class BitEnglish implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "eng_id", nullable = false)
    private Integer engId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "eng_level_name", nullable = false, length = 100)
    private String engLevelName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "engId", fetch = FetchType.LAZY)
    private List<BitStudent> bitStudentList;

    public BitEnglish() {
    }

    public BitEnglish(Integer engId) {
        this.engId = engId;
    }

    public BitEnglish(Integer engId, String engLevelName, Date aDateCreate, String aUserCreate, Date aDateChange, String aUserChange) {
        this.engId = engId;
        this.engLevelName = engLevelName;
        this.aDateCreate = aDateCreate;
        this.aUserCreate = aUserCreate;
        this.aDateChange = aDateChange;
        this.aUserChange = aUserChange;
    }

    public Integer getEngId() {
        return engId;
    }

    public void setEngId(Integer engId) {
        this.engId = engId;
    }

    public String getEngLevelName() {
        return engLevelName;
    }

    public void setEngLevelName(String engLevelName) {
        this.engLevelName = engLevelName;
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
        hash += (engId != null ? engId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitEnglish)) {
            return false;
        }
        BitEnglish other = (BitEnglish) object;
        if ((this.engId == null && other.engId != null) || (this.engId != null && !this.engId.equals(other.engId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.BitEnglish[ engId=" + engId + " ]";
    }
    
}
