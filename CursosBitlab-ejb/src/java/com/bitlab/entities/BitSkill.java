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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "bit_skill", catalog = "bd_bitlab", schema = "")
@NamedQueries({
    @NamedQuery(name = "BitSkill.findAll", query = "SELECT b FROM BitSkill b")
    , @NamedQuery(name = "BitSkill.findBySkiId", query = "SELECT b FROM BitSkill b WHERE b.skiId = :skiId")
    , @NamedQuery(name = "BitSkill.findBySkiName", query = "SELECT b FROM BitSkill b WHERE b.skiName = :skiName")
    , @NamedQuery(name = "BitSkill.findByADateCreate", query = "SELECT b FROM BitSkill b WHERE b.aDateCreate = :aDateCreate")
    , @NamedQuery(name = "BitSkill.findByAUserCreate", query = "SELECT b FROM BitSkill b WHERE b.aUserCreate = :aUserCreate")
    , @NamedQuery(name = "BitSkill.findByADateChange", query = "SELECT b FROM BitSkill b WHERE b.aDateChange = :aDateChange")
    , @NamedQuery(name = "BitSkill.findByAUserChange", query = "SELECT b FROM BitSkill b WHERE b.aUserChange = :aUserChange")})
public class BitSkill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ski_id", nullable = false)
    private Integer skiId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ski_name", nullable = false, length = 50)
    private String skiName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skiId", fetch = FetchType.LAZY)
    private List<BitDetail> bitDetailList;
    @JoinColumn(name = "env_id", referencedColumnName = "env_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BitEnvironment envId;

    public BitSkill() {
    }

    public BitSkill(Integer skiId) {
        this.skiId = skiId;
    }

    public BitSkill(Integer skiId, String skiName, Date aDateCreate, String aUserCreate, Date aDateChange, String aUserChange) {
        this.skiId = skiId;
        this.skiName = skiName;
        this.aDateCreate = aDateCreate;
        this.aUserCreate = aUserCreate;
        this.aDateChange = aDateChange;
        this.aUserChange = aUserChange;
    }

    public Integer getSkiId() {
        return skiId;
    }

    public void setSkiId(Integer skiId) {
        this.skiId = skiId;
    }

    public String getSkiName() {
        return skiName;
    }

    public void setSkiName(String skiName) {
        this.skiName = skiName;
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

    public List<BitDetail> getBitDetailList() {
        return bitDetailList;
    }

    public void setBitDetailList(List<BitDetail> bitDetailList) {
        this.bitDetailList = bitDetailList;
    }

    public BitEnvironment getEnvId() {
        return envId;
    }

    public void setEnvId(BitEnvironment envId) {
        this.envId = envId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skiId != null ? skiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitSkill)) {
            return false;
        }
        BitSkill other = (BitSkill) object;
        if ((this.skiId == null && other.skiId != null) || (this.skiId != null && !this.skiId.equals(other.skiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.BitSkill[ skiId=" + skiId + " ]";
    }
    
}
