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
@Table(name = "bit_test", catalog = "bd_bitlab", schema = "")
@NamedQueries({
    @NamedQuery(name = "BitTest.findAll", query = "SELECT b FROM BitTest b")
    , @NamedQuery(name = "BitTest.findByTesId", query = "SELECT b FROM BitTest b WHERE b.tesId = :tesId")
    , @NamedQuery(name = "BitTest.findByTesName", query = "SELECT b FROM BitTest b WHERE b.tesName = :tesName")
    , @NamedQuery(name = "BitTest.findByTesPercentage", query = "SELECT b FROM BitTest b WHERE b.tesPercentage = :tesPercentage")
    , @NamedQuery(name = "BitTest.findByTesDate", query = "SELECT b FROM BitTest b WHERE b.tesDate = :tesDate")
    , @NamedQuery(name = "BitTest.findByADateCreate", query = "SELECT b FROM BitTest b WHERE b.aDateCreate = :aDateCreate")
    , @NamedQuery(name = "BitTest.findByAUserCreate", query = "SELECT b FROM BitTest b WHERE b.aUserCreate = :aUserCreate")
    , @NamedQuery(name = "BitTest.findByADateChange", query = "SELECT b FROM BitTest b WHERE b.aDateChange = :aDateChange")
    , @NamedQuery(name = "BitTest.findByAUserChange", query = "SELECT b FROM BitTest b WHERE b.aUserChange = :aUserChange")})
public class BitTest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tes_id", nullable = false)
    private Integer tesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tes_name", nullable = false, length = 100)
    private String tesName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tes_percentage", nullable = false)
    private long tesPercentage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tes_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tesDate;
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
    @JoinColumn(name = "tyt_id", referencedColumnName = "tyt_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BitTestType tytId;
    @JoinColumn(name = "req_id", referencedColumnName = "req_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BitRequest reqId;

    public BitTest() {
    }

    public BitTest(Integer tesId) {
        this.tesId = tesId;
    }

    public BitTest(Integer tesId, String tesName, long tesPercentage, Date tesDate, Date aDateCreate, String aUserCreate, Date aDateChange, String aUserChange) {
        this.tesId = tesId;
        this.tesName = tesName;
        this.tesPercentage = tesPercentage;
        this.tesDate = tesDate;
        this.aDateCreate = aDateCreate;
        this.aUserCreate = aUserCreate;
        this.aDateChange = aDateChange;
        this.aUserChange = aUserChange;
    }

    public Integer getTesId() {
        return tesId;
    }

    public void setTesId(Integer tesId) {
        this.tesId = tesId;
    }

    public String getTesName() {
        return tesName;
    }

    public void setTesName(String tesName) {
        this.tesName = tesName;
    }

    public long getTesPercentage() {
        return tesPercentage;
    }

    public void setTesPercentage(long tesPercentage) {
        this.tesPercentage = tesPercentage;
    }

    public Date getTesDate() {
        return tesDate;
    }

    public void setTesDate(Date tesDate) {
        this.tesDate = tesDate;
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

    public BitTestType getTytId() {
        return tytId;
    }

    public void setTytId(BitTestType tytId) {
        this.tytId = tytId;
    }

    public BitRequest getReqId() {
        return reqId;
    }

    public void setReqId(BitRequest reqId) {
        this.reqId = reqId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tesId != null ? tesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitTest)) {
            return false;
        }
        BitTest other = (BitTest) object;
        if ((this.tesId == null && other.tesId != null) || (this.tesId != null && !this.tesId.equals(other.tesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.BitTest[ tesId=" + tesId + " ]";
    }
    
}
