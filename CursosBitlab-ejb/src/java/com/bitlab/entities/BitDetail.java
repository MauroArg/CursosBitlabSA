/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.entities;

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

/**
 *
 * @author Maury
 */
@Entity
@Table(name = "bit_detail", catalog = "bd_bitlab", schema = "")
@NamedQueries({
    @NamedQuery(name = "BitDetail.findAll", query = "SELECT b FROM BitDetail b")
    , @NamedQuery(name = "BitDetail.findByDetId", query = "SELECT b FROM BitDetail b WHERE b.detId = :detId")
    , @NamedQuery(name = "BitDetail.findByADateCreate", query = "SELECT b FROM BitDetail b WHERE b.aDateCreate = :aDateCreate")
    , @NamedQuery(name = "BitDetail.findByAUserCreate", query = "SELECT b FROM BitDetail b WHERE b.aUserCreate = :aUserCreate")
    , @NamedQuery(name = "BitDetail.findByADateChange", query = "SELECT b FROM BitDetail b WHERE b.aDateChange = :aDateChange")
    , @NamedQuery(name = "BitDetail.findByAUserChange", query = "SELECT b FROM BitDetail b WHERE b.aUserChange = :aUserChange")})
public class BitDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "det_id", nullable = false)
    private Integer detId;
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
    @JoinColumn(name = "stu_id", referencedColumnName = "stu_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BitStudent stuId;
    @JoinColumn(name = "ski_id", referencedColumnName = "ski_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BitSkill skiId;

    public BitDetail() {
    }

    public BitDetail(Integer detId) {
        this.detId = detId;
    }

    public BitDetail(Integer detId, Date aDateCreate, String aUserCreate, Date aDateChange, String aUserChange) {
        this.detId = detId;
        this.aDateCreate = aDateCreate;
        this.aUserCreate = aUserCreate;
        this.aDateChange = aDateChange;
        this.aUserChange = aUserChange;
    }

    public Integer getDetId() {
        return detId;
    }

    public void setDetId(Integer detId) {
        this.detId = detId;
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

    public BitStudent getStuId() {
        return stuId;
    }

    public void setStuId(BitStudent stuId) {
        this.stuId = stuId;
    }

    public BitSkill getSkiId() {
        return skiId;
    }

    public void setSkiId(BitSkill skiId) {
        this.skiId = skiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detId != null ? detId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitDetail)) {
            return false;
        }
        BitDetail other = (BitDetail) object;
        if ((this.detId == null && other.detId != null) || (this.detId != null && !this.detId.equals(other.detId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.BitDetail[ detId=" + detId + " ]";
    }
    
}
