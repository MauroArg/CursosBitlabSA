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
@Table(name = "bit_cou_status", catalog = "bd_bitlab", schema = "")
@NamedQueries({
    @NamedQuery(name = "BitCouStatus.findAll", query = "SELECT b FROM BitCouStatus b")
    , @NamedQuery(name = "BitCouStatus.findByCosId", query = "SELECT b FROM BitCouStatus b WHERE b.cosId = :cosId")
    , @NamedQuery(name = "BitCouStatus.findByCosStatusName", query = "SELECT b FROM BitCouStatus b WHERE b.cosStatusName = :cosStatusName")
    , @NamedQuery(name = "BitCouStatus.findByADateCreate", query = "SELECT b FROM BitCouStatus b WHERE b.aDateCreate = :aDateCreate")
    , @NamedQuery(name = "BitCouStatus.findByAUserCreate", query = "SELECT b FROM BitCouStatus b WHERE b.aUserCreate = :aUserCreate")
    , @NamedQuery(name = "BitCouStatus.findByADateChange", query = "SELECT b FROM BitCouStatus b WHERE b.aDateChange = :aDateChange")
    , @NamedQuery(name = "BitCouStatus.findByAUserChange", query = "SELECT b FROM BitCouStatus b WHERE b.aUserChange = :aUserChange")})
public class BitCouStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cos_id", nullable = false)
    private Integer cosId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cos_status_name", nullable = false, length = 50)
    private String cosStatusName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cosId", fetch = FetchType.LAZY)
    private List<BitCourse> bitCourseList;

    public BitCouStatus() {
    }

    public BitCouStatus(Integer cosId) {
        this.cosId = cosId;
    }

    public BitCouStatus(Integer cosId, String cosStatusName, Date aDateCreate, String aUserCreate, Date aDateChange, String aUserChange) {
        this.cosId = cosId;
        this.cosStatusName = cosStatusName;
        this.aDateCreate = aDateCreate;
        this.aUserCreate = aUserCreate;
        this.aDateChange = aDateChange;
        this.aUserChange = aUserChange;
    }

    public Integer getCosId() {
        return cosId;
    }

    public void setCosId(Integer cosId) {
        this.cosId = cosId;
    }

    public String getCosStatusName() {
        return cosStatusName;
    }

    public void setCosStatusName(String cosStatusName) {
        this.cosStatusName = cosStatusName;
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

    public List<BitCourse> getBitCourseList() {
        return bitCourseList;
    }

    public void setBitCourseList(List<BitCourse> bitCourseList) {
        this.bitCourseList = bitCourseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cosId != null ? cosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitCouStatus)) {
            return false;
        }
        BitCouStatus other = (BitCouStatus) object;
        if ((this.cosId == null && other.cosId != null) || (this.cosId != null && !this.cosId.equals(other.cosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.BitCouStatus[ cosId=" + cosId + " ]";
    }
    
}
