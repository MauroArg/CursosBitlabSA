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
@Table(name = "bit_stu_status", catalog = "bd_bitlab", schema = "")
@NamedQueries({
    @NamedQuery(name = "BitStuStatus.findAll", query = "SELECT b FROM BitStuStatus b")
    , @NamedQuery(name = "BitStuStatus.findByStsId", query = "SELECT b FROM BitStuStatus b WHERE b.stsId = :stsId")
    , @NamedQuery(name = "BitStuStatus.findByStsStatus", query = "SELECT b FROM BitStuStatus b WHERE b.stsStatus = :stsStatus")
    , @NamedQuery(name = "BitStuStatus.findByADateCreate", query = "SELECT b FROM BitStuStatus b WHERE b.aDateCreate = :aDateCreate")
    , @NamedQuery(name = "BitStuStatus.findByAUserCreate", query = "SELECT b FROM BitStuStatus b WHERE b.aUserCreate = :aUserCreate")
    , @NamedQuery(name = "BitStuStatus.findByADateChange", query = "SELECT b FROM BitStuStatus b WHERE b.aDateChange = :aDateChange")
    , @NamedQuery(name = "BitStuStatus.findByAUserChange", query = "SELECT b FROM BitStuStatus b WHERE b.aUserChange = :aUserChange")})
public class BitStuStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sts_id", nullable = false)
    private Integer stsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sts_status", nullable = false, length = 50)
    private String stsStatus;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stsId", fetch = FetchType.LAZY)
    private List<BitStudent> bitStudentList;

    public BitStuStatus() {
    }

    public BitStuStatus(Integer stsId) {
        this.stsId = stsId;
    }

    public BitStuStatus(Integer stsId, String stsStatus, Date aDateCreate, String aUserCreate, Date aDateChange, String aUserChange) {
        this.stsId = stsId;
        this.stsStatus = stsStatus;
        this.aDateCreate = aDateCreate;
        this.aUserCreate = aUserCreate;
        this.aDateChange = aDateChange;
        this.aUserChange = aUserChange;
    }

    public Integer getStsId() {
        return stsId;
    }

    public void setStsId(Integer stsId) {
        this.stsId = stsId;
    }

    public String getStsStatus() {
        return stsStatus;
    }

    public void setStsStatus(String stsStatus) {
        this.stsStatus = stsStatus;
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
        hash += (stsId != null ? stsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitStuStatus)) {
            return false;
        }
        BitStuStatus other = (BitStuStatus) object;
        if ((this.stsId == null && other.stsId != null) || (this.stsId != null && !this.stsId.equals(other.stsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.BitStuStatus[ stsId=" + stsId + " ]";
    }
    
}
