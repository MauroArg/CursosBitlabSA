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
@Table(name = "bit_environment", catalog = "bd_bitlab", schema = "")
@NamedQueries({
    @NamedQuery(name = "BitEnvironment.findAll", query = "SELECT b FROM BitEnvironment b")
    , @NamedQuery(name = "BitEnvironment.findByEnvId", query = "SELECT b FROM BitEnvironment b WHERE b.envId = :envId")
    , @NamedQuery(name = "BitEnvironment.findByEnvName", query = "SELECT b FROM BitEnvironment b WHERE b.envName = :envName")
    , @NamedQuery(name = "BitEnvironment.findByADateCreate", query = "SELECT b FROM BitEnvironment b WHERE b.aDateCreate = :aDateCreate")
    , @NamedQuery(name = "BitEnvironment.findByAUserCreate", query = "SELECT b FROM BitEnvironment b WHERE b.aUserCreate = :aUserCreate")
    , @NamedQuery(name = "BitEnvironment.findByADateChange", query = "SELECT b FROM BitEnvironment b WHERE b.aDateChange = :aDateChange")
    , @NamedQuery(name = "BitEnvironment.findByAUserChange", query = "SELECT b FROM BitEnvironment b WHERE b.aUserChange = :aUserChange")})
public class BitEnvironment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "env_id", nullable = false)
    private Integer envId;
    @Size(max = 50)
    @Column(name = "env_name", length = 50)
    private String envName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "envId", fetch = FetchType.LAZY)
    private List<BitSkill> bitSkillList;

    public BitEnvironment() {
    }

    public BitEnvironment(Integer envId) {
        this.envId = envId;
    }

    public BitEnvironment(Integer envId, Date aDateCreate, String aUserCreate, Date aDateChange, String aUserChange) {
        this.envId = envId;
        this.aDateCreate = aDateCreate;
        this.aUserCreate = aUserCreate;
        this.aDateChange = aDateChange;
        this.aUserChange = aUserChange;
    }

    public Integer getEnvId() {
        return envId;
    }

    public void setEnvId(Integer envId) {
        this.envId = envId;
    }

    public String getEnvName() {
        return envName;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
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

    public List<BitSkill> getBitSkillList() {
        return bitSkillList;
    }

    public void setBitSkillList(List<BitSkill> bitSkillList) {
        this.bitSkillList = bitSkillList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (envId != null ? envId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitEnvironment)) {
            return false;
        }
        BitEnvironment other = (BitEnvironment) object;
        if ((this.envId == null && other.envId != null) || (this.envId != null && !this.envId.equals(other.envId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.BitEnvironment[ envId=" + envId + " ]";
    }
    
}
