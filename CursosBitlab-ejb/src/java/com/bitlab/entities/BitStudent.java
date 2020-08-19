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
@Table(name = "bit_student", catalog = "bd_bitlab", schema = "")
@NamedQueries({
    @NamedQuery(name = "BitStudent.findAll", query = "SELECT b FROM BitStudent b")
    , @NamedQuery(name = "BitStudent.findByStuId", query = "SELECT b FROM BitStudent b WHERE b.stuId = :stuId")
    , @NamedQuery(name = "BitStudent.findByStuName", query = "SELECT b FROM BitStudent b WHERE b.stuName = :stuName")
    , @NamedQuery(name = "BitStudent.findByStuLastName", query = "SELECT b FROM BitStudent b WHERE b.stuLastName = :stuLastName")
    , @NamedQuery(name = "BitStudent.findByStuDui", query = "SELECT b FROM BitStudent b WHERE b.stuDui = :stuDui")
    , @NamedQuery(name = "BitStudent.findByStuPhone", query = "SELECT b FROM BitStudent b WHERE b.stuPhone = :stuPhone")
    , @NamedQuery(name = "BitStudent.findByStuImg", query = "SELECT b FROM BitStudent b WHERE b.stuImg = :stuImg")
    , @NamedQuery(name = "BitStudent.findByStuCv", query = "SELECT b FROM BitStudent b WHERE b.stuCv = :stuCv")
    , @NamedQuery(name = "BitStudent.findByStuAddress", query = "SELECT b FROM BitStudent b WHERE b.stuAddress = :stuAddress")
    , @NamedQuery(name = "BitStudent.findByStuBornDate", query = "SELECT b FROM BitStudent b WHERE b.stuBornDate = :stuBornDate")
    , @NamedQuery(name = "BitStudent.findByADateCreate", query = "SELECT b FROM BitStudent b WHERE b.aDateCreate = :aDateCreate")
    , @NamedQuery(name = "BitStudent.findByAUserCreate", query = "SELECT b FROM BitStudent b WHERE b.aUserCreate = :aUserCreate")
    , @NamedQuery(name = "BitStudent.findByADateChange", query = "SELECT b FROM BitStudent b WHERE b.aDateChange = :aDateChange")
    , @NamedQuery(name = "BitStudent.findByAUserChange", query = "SELECT b FROM BitStudent b WHERE b.aUserChange = :aUserChange")})
public class BitStudent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stu_id", nullable = false)
    private Integer stuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "stu_name", nullable = false, length = 100)
    private String stuName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "stu_last_name", nullable = false, length = 100)
    private String stuLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "stu_dui", nullable = false, length = 15)
    private String stuDui;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "stu_phone", nullable = false, length = 15)
    private String stuPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "stu_img", nullable = false, length = 300)
    private String stuImg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "stu_cv", nullable = false, length = 300)
    private String stuCv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "stu_address", nullable = false, length = 300)
    private String stuAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stu_born_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date stuBornDate;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stuId", fetch = FetchType.LAZY)
    private List<BitRequest> bitRequestList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stuId", fetch = FetchType.LAZY)
    private List<BitDetail> bitDetailList;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BitUser usrId;
    @JoinColumn(name = "sts_id", referencedColumnName = "sts_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BitStuStatus stsId;
    @JoinColumn(name = "sch_id", referencedColumnName = "sch_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BitScholarship schId;
    @JoinColumn(name = "eng_id", referencedColumnName = "eng_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BitEnglish engId;

    public BitStudent() {
    }

    public BitStudent(Integer stuId) {
        this.stuId = stuId;
    }

    public BitStudent(Integer stuId, String stuName, String stuLastName, String stuDui, String stuPhone, String stuImg, String stuCv, String stuAddress, Date stuBornDate, Date aDateCreate, String aUserCreate, Date aDateChange, String aUserChange) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuLastName = stuLastName;
        this.stuDui = stuDui;
        this.stuPhone = stuPhone;
        this.stuImg = stuImg;
        this.stuCv = stuCv;
        this.stuAddress = stuAddress;
        this.stuBornDate = stuBornDate;
        this.aDateCreate = aDateCreate;
        this.aUserCreate = aUserCreate;
        this.aDateChange = aDateChange;
        this.aUserChange = aUserChange;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuLastName() {
        return stuLastName;
    }

    public void setStuLastName(String stuLastName) {
        this.stuLastName = stuLastName;
    }

    public String getStuDui() {
        return stuDui;
    }

    public void setStuDui(String stuDui) {
        this.stuDui = stuDui;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getStuImg() {
        return stuImg;
    }

    public void setStuImg(String stuImg) {
        this.stuImg = stuImg;
    }

    public String getStuCv() {
        return stuCv;
    }

    public void setStuCv(String stuCv) {
        this.stuCv = stuCv;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public Date getStuBornDate() {
        return stuBornDate;
    }

    public void setStuBornDate(Date stuBornDate) {
        this.stuBornDate = stuBornDate;
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

    public List<BitDetail> getBitDetailList() {
        return bitDetailList;
    }

    public void setBitDetailList(List<BitDetail> bitDetailList) {
        this.bitDetailList = bitDetailList;
    }

    public BitUser getUsrId() {
        return usrId;
    }

    public void setUsrId(BitUser usrId) {
        this.usrId = usrId;
    }

    public BitStuStatus getStsId() {
        return stsId;
    }

    public void setStsId(BitStuStatus stsId) {
        this.stsId = stsId;
    }

    public BitScholarship getSchId() {
        return schId;
    }

    public void setSchId(BitScholarship schId) {
        this.schId = schId;
    }

    public BitEnglish getEngId() {
        return engId;
    }

    public void setEngId(BitEnglish engId) {
        this.engId = engId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stuId != null ? stuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitStudent)) {
            return false;
        }
        BitStudent other = (BitStudent) object;
        if ((this.stuId == null && other.stuId != null) || (this.stuId != null && !this.stuId.equals(other.stuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.BitStudent[ stuId=" + stuId + " ]";
    }
    
}
