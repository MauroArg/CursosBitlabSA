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
@Table(name = "bit_user", catalog = "bd_bitlab", schema = "")
@NamedQueries({
    @NamedQuery(name = "BitUser.findAll", query = "SELECT b FROM BitUser b")
    , @NamedQuery(name = "BitUser.findByUsrId", query = "SELECT b FROM BitUser b WHERE b.usrId = :usrId")
    , @NamedQuery(name = "BitUser.findByUsrUsername", query = "SELECT b FROM BitUser b WHERE b.usrUsername = :usrUsername")
    , @NamedQuery(name = "BitUser.findByUsrEmail", query = "SELECT b FROM BitUser b WHERE b.usrEmail = :usrEmail")
    , @NamedQuery(name = "BitUser.findByUsrPassword", query = "SELECT b FROM BitUser b WHERE b.usrPassword = :usrPassword")
    , @NamedQuery(name = "BitUser.findByADateCreate", query = "SELECT b FROM BitUser b WHERE b.aDateCreate = :aDateCreate")
    , @NamedQuery(name = "BitUser.findByAUserCreate", query = "SELECT b FROM BitUser b WHERE b.aUserCreate = :aUserCreate")
    , @NamedQuery(name = "BitUser.findByADateChange", query = "SELECT b FROM BitUser b WHERE b.aDateChange = :aDateChange")
    , @NamedQuery(name = "BitUser.findByAUserChange", query = "SELECT b FROM BitUser b WHERE b.aUserChange = :aUserChange")})
public class BitUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usr_id", nullable = false)
    private Integer usrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usr_username", nullable = false, length = 50)
    private String usrUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "usr_email", nullable = false, length = 60)
    private String usrEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usr_password", nullable = false, length = 100)
    private String usrPassword;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId", fetch = FetchType.LAZY)
    private List<BitCourse> bitCourseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId", fetch = FetchType.LAZY)
    private List<BitStudent> bitStudentList;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BitRol rolId;
    @JoinColumn(name = "uss_id", referencedColumnName = "uss_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BitUsrStatus ussId;

    public BitUser() {
    }

    public BitUser(Integer usrId) {
        this.usrId = usrId;
    }

    public BitUser(Integer usrId, String usrUsername, String usrEmail, String usrPassword, Date aDateCreate, String aUserCreate, Date aDateChange, String aUserChange) {
        this.usrId = usrId;
        this.usrUsername = usrUsername;
        this.usrEmail = usrEmail;
        this.usrPassword = usrPassword;
        this.aDateCreate = aDateCreate;
        this.aUserCreate = aUserCreate;
        this.aDateChange = aDateChange;
        this.aUserChange = aUserChange;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrUsername() {
        return usrUsername;
    }

    public void setUsrUsername(String usrUsername) {
        this.usrUsername = usrUsername;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
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

    public List<BitCourse> getBitCourseList() {
        return bitCourseList;
    }

    public void setBitCourseList(List<BitCourse> bitCourseList) {
        this.bitCourseList = bitCourseList;
    }

    public List<BitStudent> getBitStudentList() {
        return bitStudentList;
    }

    public void setBitStudentList(List<BitStudent> bitStudentList) {
        this.bitStudentList = bitStudentList;
    }

    public BitRol getRolId() {
        return rolId;
    }

    public void setRolId(BitRol rolId) {
        this.rolId = rolId;
    }

    public BitUsrStatus getUssId() {
        return ussId;
    }

    public void setUssId(BitUsrStatus ussId) {
        this.ussId = ussId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrId != null ? usrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitUser)) {
            return false;
        }
        BitUser other = (BitUser) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entities.BitUser[ usrId=" + usrId + " ]";
    }
    
}
