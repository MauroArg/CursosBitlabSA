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
@Table(name = "bit_rol", catalog = "bd_bitlab", schema = "")
@NamedQueries({
    @NamedQuery(name = "BitRol.findAll", query = "SELECT b FROM BitRol b")
    , @NamedQuery(name = "BitRol.findByRolId", query = "SELECT b FROM BitRol b WHERE b.rolId = :rolId")
    , @NamedQuery(name = "BitRol.findByRolName", query = "SELECT b FROM BitRol b WHERE b.rolName = :rolName")
    , @NamedQuery(name = "BitRol.findByADateCreate", query = "SELECT b FROM BitRol b WHERE b.aDateCreate = :aDateCreate")
    , @NamedQuery(name = "BitRol.findByAUserCreate", query = "SELECT b FROM BitRol b WHERE b.aUserCreate = :aUserCreate")
    , @NamedQuery(name = "BitRol.findByADateChange", query = "SELECT b FROM BitRol b WHERE b.aDateChange = :aDateChange")
    , @NamedQuery(name = "BitRol.findByAUserChange", query = "SELECT b FROM BitRol b WHERE b.aUserChange = :aUserChange")})
public class BitRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rol_id", nullable = false)
    private Integer rolId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "rol_name", nullable = false, length = 50)
    private String rolName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolId", fetch = FetchType.LAZY)
    private List<BitUser> bitUserList;

    public BitRol() {
    }

    public BitRol(Integer rolId) {
        this.rolId = rolId;
    }

    public BitRol(Integer rolId, String rolName, Date aDateCreate, String aUserCreate, Date aDateChange, String aUserChange) {
        this.rolId = rolId;
        this.rolName = rolName;
        this.aDateCreate = aDateCreate;
        this.aUserCreate = aUserCreate;
        this.aDateChange = aDateChange;
        this.aUserChange = aUserChange;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
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
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitRol)) {
            return false;
        }
        BitRol other = (BitRol) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.BitRol[ rolId=" + rolId + " ]";
    }
    
}