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
@Table(name = "bit_request", catalog = "bd_bitlab", schema = "")
@NamedQueries({
    @NamedQuery(name = "BitRequest.findAll", query = "SELECT b FROM BitRequest b")
    , @NamedQuery(name = "BitRequest.findByReqId", query = "SELECT b FROM BitRequest b WHERE b.reqId = :reqId")
    , @NamedQuery(name = "BitRequest.findByReqDateRequest", query = "SELECT b FROM BitRequest b WHERE b.reqDateRequest = :reqDateRequest")
    , @NamedQuery(name = "BitRequest.findByADateCreate", query = "SELECT b FROM BitRequest b WHERE b.aDateCreate = :aDateCreate")
    , @NamedQuery(name = "BitRequest.findByAUserCreate", query = "SELECT b FROM BitRequest b WHERE b.aUserCreate = :aUserCreate")
    , @NamedQuery(name = "BitRequest.findByADateChange", query = "SELECT b FROM BitRequest b WHERE b.aDateChange = :aDateChange")
    , @NamedQuery(name = "BitRequest.findByAUserChange", query = "SELECT b FROM BitRequest b WHERE b.aUserChange = :aUserChange")})
public class BitRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "req_id", nullable = false)
    private Integer reqId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "req_date_request", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date reqDateRequest;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reqId", fetch = FetchType.LAZY)
    private List<BitTest> bitTestList;
    @JoinColumn(name = "cou_id", referencedColumnName = "cou_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BitCourse couId;
    @JoinColumn(name = "stu_id", referencedColumnName = "stu_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BitStudent stuId;
    @JoinColumn(name = "rqs_id", referencedColumnName = "rqs_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BitReqStatus rqsId;

    public BitRequest() {
    }

    public BitRequest(Integer reqId) {
        this.reqId = reqId;
    }

    public BitRequest(Integer reqId, Date reqDateRequest, Date aDateCreate, String aUserCreate, Date aDateChange, String aUserChange) {
        this.reqId = reqId;
        this.reqDateRequest = reqDateRequest;
        this.aDateCreate = aDateCreate;
        this.aUserCreate = aUserCreate;
        this.aDateChange = aDateChange;
        this.aUserChange = aUserChange;
    }

    public Integer getReqId() {
        return reqId;
    }

    public void setReqId(Integer reqId) {
        this.reqId = reqId;
    }

    public Date getReqDateRequest() {
        return reqDateRequest;
    }

    public void setReqDateRequest(Date reqDateRequest) {
        this.reqDateRequest = reqDateRequest;
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

    public List<BitTest> getBitTestList() {
        return bitTestList;
    }

    public void setBitTestList(List<BitTest> bitTestList) {
        this.bitTestList = bitTestList;
    }

    public BitCourse getCouId() {
        return couId;
    }

    public void setCouId(BitCourse couId) {
        this.couId = couId;
    }

    public BitStudent getStuId() {
        return stuId;
    }

    public void setStuId(BitStudent stuId) {
        this.stuId = stuId;
    }

    public BitReqStatus getRqsId() {
        return rqsId;
    }

    public void setRqsId(BitReqStatus rqsId) {
        this.rqsId = rqsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reqId != null ? reqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitRequest)) {
            return false;
        }
        BitRequest other = (BitRequest) object;
        if ((this.reqId == null && other.reqId != null) || (this.reqId != null && !this.reqId.equals(other.reqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.BitRequest[ reqId=" + reqId + " ]";
    }
    
}
