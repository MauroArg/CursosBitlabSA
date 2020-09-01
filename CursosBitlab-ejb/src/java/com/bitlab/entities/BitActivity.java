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
@Table(name = "bit_activity", catalog = "bd_bitlab", schema = "")
@NamedQueries({
    @NamedQuery(name = "BitActivity.findAll", query = "SELECT b FROM BitActivity b")
    , @NamedQuery(name = "BitActivity.findByActId", query = "SELECT b FROM BitActivity b WHERE b.actId = :actId")
    , @NamedQuery(name = "BitActivity.findByActScore", query = "SELECT b FROM BitActivity b WHERE b.actScore = :actScore")
    , @NamedQuery(name = "BitActivity.findByActName", query = "SELECT b FROM BitActivity b WHERE b.actName = :actName")
    , @NamedQuery(name = "BitActivity.findByADateCreate", query = "SELECT b FROM BitActivity b WHERE b.aDateCreate = :aDateCreate")
    , @NamedQuery(name = "BitActivity.findByAUserCreate", query = "SELECT b FROM BitActivity b WHERE b.aUserCreate = :aUserCreate")
    , @NamedQuery(name = "BitActivity.findByADateChange", query = "SELECT b FROM BitActivity b WHERE b.aDateChange = :aDateChange")
    , @NamedQuery(name = "BitActivity.findByAUserChange", query = "SELECT b FROM BitActivity b WHERE b.aUserChange = :aUserChange")})
public class BitActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "act_id", nullable = false)
    private Integer actId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "act_score", nullable = false)
    private long actScore;
    @Size(max = 100)
    @Column(name = "act_name", length = 100)
    private String actName;
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
    @JoinColumn(name = "cou_id", referencedColumnName = "cou_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BitCourse couId;

    public BitActivity() {
    }

    public BitActivity(Integer actId) {
        this.actId = actId;
    }

    public BitActivity(Integer actId, long actScore, Date aDateCreate, String aUserCreate, Date aDateChange, String aUserChange) {
        this.actId = actId;
        this.actScore = actScore;
        this.aDateCreate = aDateCreate;
        this.aUserCreate = aUserCreate;
        this.aDateChange = aDateChange;
        this.aUserChange = aUserChange;
    }

    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    public long getActScore() {
        return actScore;
    }

    public void setActScore(long actScore) {
        this.actScore = actScore;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
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

    public BitCourse getCouId() {
        return couId;
    }

    public void setCouId(BitCourse couId) {
        this.couId = couId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actId != null ? actId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitActivity)) {
            return false;
        }
        BitActivity other = (BitActivity) object;
        if ((this.actId == null && other.actId != null) || (this.actId != null && !this.actId.equals(other.actId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.BitActivity[ actId=" + actId + " ]";
    }
    
}
