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
@Table(name = "bit_course", catalog = "bd_bitlab", schema = "")
@NamedQueries({
    @NamedQuery(name = "BitCourse.findAll", query = "SELECT b FROM BitCourse b")
    , @NamedQuery(name = "BitCourse.findByCouId", query = "SELECT b FROM BitCourse b WHERE b.couId = :couId")
    , @NamedQuery(name = "BitCourse.findByCouName", query = "SELECT b FROM BitCourse b WHERE b.couName = :couName")
    , @NamedQuery(name = "BitCourse.findByCouImg", query = "SELECT b FROM BitCourse b WHERE b.couImg = :couImg")
    , @NamedQuery(name = "BitCourse.findByCouDescription", query = "SELECT b FROM BitCourse b WHERE b.couDescription = :couDescription")
    , @NamedQuery(name = "BitCourse.findByCouStartDate", query = "SELECT b FROM BitCourse b WHERE b.couStartDate = :couStartDate")
    , @NamedQuery(name = "BitCourse.findByCouEndDate", query = "SELECT b FROM BitCourse b WHERE b.couEndDate = :couEndDate")
    , @NamedQuery(name = "BitCourse.findByADateCreate", query = "SELECT b FROM BitCourse b WHERE b.aDateCreate = :aDateCreate")
    , @NamedQuery(name = "BitCourse.findByAUserCreate", query = "SELECT b FROM BitCourse b WHERE b.aUserCreate = :aUserCreate")
    , @NamedQuery(name = "BitCourse.findByADateChange", query = "SELECT b FROM BitCourse b WHERE b.aDateChange = :aDateChange")
    , @NamedQuery(name = "BitCourse.findByAUserChange", query = "SELECT b FROM BitCourse b WHERE b.aUserChange = :aUserChange")})
public class BitCourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cou_id", nullable = false)
    private Integer couId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cou_name", nullable = false, length = 100)
    private String couName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "cou_img", nullable = false, length = 250)
    private String couImg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "cou_description", nullable = false, length = 300)
    private String couDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cou_start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date couStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cou_end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date couEndDate;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "couId", fetch = FetchType.LAZY)
    private List<BitActivity> bitActivityList;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BitUser usrId;
    @JoinColumn(name = "cos_id", referencedColumnName = "cos_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BitCouStatus cosId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "couId", fetch = FetchType.LAZY)
    private List<BitRequest> bitRequestList;

    public BitCourse() {
    }

    public BitCourse(Integer couId) {
        this.couId = couId;
    }

    public BitCourse(Integer couId, String couName, String couImg, String couDescription, Date couStartDate, Date couEndDate, Date aDateCreate, String aUserCreate, Date aDateChange, String aUserChange) {
        this.couId = couId;
        this.couName = couName;
        this.couImg = couImg;
        this.couDescription = couDescription;
        this.couStartDate = couStartDate;
        this.couEndDate = couEndDate;
        this.aDateCreate = aDateCreate;
        this.aUserCreate = aUserCreate;
        this.aDateChange = aDateChange;
        this.aUserChange = aUserChange;
    }

    public Integer getCouId() {
        return couId;
    }

    public void setCouId(Integer couId) {
        this.couId = couId;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public String getCouImg() {
        return couImg;
    }

    public void setCouImg(String couImg) {
        this.couImg = couImg;
    }

    public String getCouDescription() {
        return couDescription;
    }

    public void setCouDescription(String couDescription) {
        this.couDescription = couDescription;
    }

    public Date getCouStartDate() {
        return couStartDate;
    }

    public void setCouStartDate(Date couStartDate) {
        this.couStartDate = couStartDate;
    }

    public Date getCouEndDate() {
        return couEndDate;
    }

    public void setCouEndDate(Date couEndDate) {
        this.couEndDate = couEndDate;
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

    public List<BitActivity> getBitActivityList() {
        return bitActivityList;
    }

    public void setBitActivityList(List<BitActivity> bitActivityList) {
        this.bitActivityList = bitActivityList;
    }

    public BitUser getUsrId() {
        return usrId;
    }

    public void setUsrId(BitUser usrId) {
        this.usrId = usrId;
    }

    public BitCouStatus getCosId() {
        return cosId;
    }

    public void setCosId(BitCouStatus cosId) {
        this.cosId = cosId;
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
        hash += (couId != null ? couId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitCourse)) {
            return false;
        }
        BitCourse other = (BitCourse) object;
        if ((this.couId == null && other.couId != null) || (this.couId != null && !this.couId.equals(other.couId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.BitCourse[ couId=" + couId + " ]";
    }
    
}
