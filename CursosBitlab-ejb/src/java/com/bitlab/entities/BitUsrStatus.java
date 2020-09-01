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
@Table(name = "bit_usr_status", catalog = "bd_bitlab", schema = "")
@NamedQueries({
    @NamedQuery(name = "BitUsrStatus.findAll", query = "SELECT b FROM BitUsrStatus b")
    , @NamedQuery(name = "BitUsrStatus.findByUssId", query = "SELECT b FROM BitUsrStatus b WHERE b.ussId = :ussId")
    , @NamedQuery(name = "BitUsrStatus.findByUssStatusName", query = "SELECT b FROM BitUsrStatus b WHERE b.ussStatusName = :ussStatusName")
    , @NamedQuery(name = "BitUsrStatus.findByADateCreate", query = "SELECT b FROM BitUsrStatus b WHERE b.aDateCreate = :aDateCreate")
    , @NamedQuery(name = "BitUsrStatus.findByAUserCreate", query = "SELECT b FROM BitUsrStatus b WHERE b.aUserCreate = :aUserCreate")
    , @NamedQuery(name = "BitUsrStatus.findByADateChange", query = "SELECT b FROM BitUsrStatus b WHERE b.aDateChange = :aDateChange")
    , @NamedQuery(name = "BitUsrStatus.findByAUserChange", query = "SELECT b FROM BitUsrStatus b WHERE b.aUserChange = :aUserChange")})
public class BitUsrStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uss_id", nullable = false)
    private Integer ussId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "uss_status_name", nullable = false, length = 50)
    private String ussStatusName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ussId", fetch = FetchType.LAZY)
    private List<BitUser> bitUserList;

    public BitUsrStatus() {
    }

    public BitUsrStatus(Integer ussId) {
        this.ussId = ussId;
    }

    public BitUsrStatus(Integer ussId, String ussStatusName, Date aDateCreate, String aUserCreate, Date aDateChange, String aUserChange) {
        this.ussId = ussId;
        this.ussStatusName = ussStatusName;
        this.aDateCreate = aDateCreate;
        this.aUserCreate = aUserCreate;
        this.aDateChange = aDateChange;
        this.aUserChange = aUserChange;
    }

    public Integer getUssId() {
        return ussId;
    }

    public void setUssId(Integer ussId) {
        this.ussId = ussId;
    }

    public String getUssStatusName() {
        return ussStatusName;
    }

    public void setUssStatusName(String ussStatusName) {
        this.ussStatusName = ussStatusName;
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

    public List<BitUser> getBitUserList() {
        return bitUserList;
    }

    public void setBitUserList(List<BitUser> bitUserList) {
        this.bitUserList = bitUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ussId != null ? ussId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitUsrStatus)) {
            return false;
        }
        BitUsrStatus other = (BitUsrStatus) object;
        if ((this.ussId == null && other.ussId != null) || (this.ussId != null && !this.ussId.equals(other.ussId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.BitUsrStatus[ ussId=" + ussId + " ]";
    }
    
}
