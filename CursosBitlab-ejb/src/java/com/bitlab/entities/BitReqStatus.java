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
@Table(name = "bit_req_status", catalog = "bd_bitlab", schema = "")
@NamedQueries({
    @NamedQuery(name = "BitReqStatus.findAll", query = "SELECT b FROM BitReqStatus b")
    , @NamedQuery(name = "BitReqStatus.findByRqsId", query = "SELECT b FROM BitReqStatus b WHERE b.rqsId = :rqsId")
    , @NamedQuery(name = "BitReqStatus.findByRsqStatusName", query = "SELECT b FROM BitReqStatus b WHERE b.rsqStatusName = :rsqStatusName")
    , @NamedQuery(name = "BitReqStatus.findByADateCreate", query = "SELECT b FROM BitReqStatus b WHERE b.aDateCreate = :aDateCreate")
    , @NamedQuery(name = "BitReqStatus.findByAUserCreate", query = "SELECT b FROM BitReqStatus b WHERE b.aUserCreate = :aUserCreate")
    , @NamedQuery(name = "BitReqStatus.findByADateChange", query = "SELECT b FROM BitReqStatus b WHERE b.aDateChange = :aDateChange")
    , @NamedQuery(name = "BitReqStatus.findByAUserChange", query = "SELECT b FROM BitReqStatus b WHERE b.aUserChange = :aUserChange")})
public class BitReqStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rqs_id", nullable = false)
    private Integer rqsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "rsq_status_name", nullable = false, length = 50)
    private String rsqStatusName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rqsId", fetch = FetchType.LAZY)
    private List<BitRequest> bitRequestList;

    public BitReqStatus() {
    }

    public BitReqStatus(Integer rqsId) {
        this.rqsId = rqsId;
    }

    public BitReqStatus(Integer rqsId, String rsqStatusName, Date aDateCreate, String aUserCreate, Date aDateChange, String aUserChange) {
        this.rqsId = rqsId;
        this.rsqStatusName = rsqStatusName;
        this.aDateCreate = aDateCreate;
        this.aUserCreate = aUserCreate;
        this.aDateChange = aDateChange;
        this.aUserChange = aUserChange;
    }

    public Integer getRqsId() {
        return rqsId;
    }

    public void setRqsId(Integer rqsId) {
        this.rqsId = rqsId;
    }

    public String getRsqStatusName() {
        return rsqStatusName;
    }

    public void setRsqStatusName(String rsqStatusName) {
        this.rsqStatusName = rsqStatusName;
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

    public List<BitRequest> getBitRequestList() {
        return bitRequestList;
    }

    public void setBitRequestList(List<BitRequest> bitRequestList) {
        this.bitRequestList = bitRequestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rqsId != null ? rqsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitReqStatus)) {
            return false;
        }
        BitReqStatus other = (BitReqStatus) object;
        if ((this.rqsId == null && other.rqsId != null) || (this.rqsId != null && !this.rqsId.equals(other.rqsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.BitReqStatus[ rqsId=" + rqsId + " ]";
    }
    
}
