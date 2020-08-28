/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.managed;

import com.bitlab.entities.BitStudent;
import com.bitlab.entities.BitUser;
import com.bitlab.session.BitStudentFacade;
import com.bitlab.session.BitUserFacade;
import com.bitlab.util.Encryption;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Maury
 */
@ManagedBean
@SessionScoped
public class BitSessionUser implements Serializable
{
    @EJB
    private BitUserFacade userFacade;
    private BitStudentFacade studentFacade;
    private BitUser session;
    private BitUser tempSession;
    private BitUserController uc;
    private BitStudent student;
    private boolean isStudent; 

    public BitSessionUser() {
    }

    public BitUserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(BitUserFacade userFacade) {
        this.userFacade = userFacade;
    }
    
    public BitStudentFacade getStudentFacade() {
        return studentFacade;
    }
    
    public BitUser getSession() {
        return session;
    }

    public void setSession(BitUser session) {
        this.session = session;
    }

    public BitSessionUser(BitUser session, BitUserController uc) {
        this.session = session;
        this.uc = uc;
    }

    public BitUser getTempSession() {
        return tempSession;
    }

    public void setTempSession(BitUser tempSession) {
        this.tempSession = tempSession;
    }

    public BitUserController getUc() {
        return uc;
    }

    public void setUc(BitUserController uc) {
        this.uc = uc;
    }

    public boolean isIsStudent() {
        return isStudent;
    }

    public void setIsStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }

    public BitStudent getStudent() {
        return student;
    }

    public void setStudent(BitStudent student) {
        this.student = student;
    }
    
    
    @PostConstruct
    public void inicializar()
    {
        session = new BitUser();
        tempSession = new BitUser();
        uc = new BitUserController();
    }
    
    public void validateUser()
    {
        
        BitUser usr = new BitUser();
        boolean isNotValidUser = true;
        
        try{
            usr = userFacade.validateUser(tempSession.getUsrEmail());
            
            System.out.println("Pass: " + usr.getUsrPassword());
            System.out.println("Mail: " + usr.getUsrEmail());
        }catch(Exception ex){
            usr = null;
        }
        
        if (usr != null) 
        {
            Encryption enc = new Encryption();
            if (tempSession.getUsrPassword().equals(usr.getUsrPassword())) 
            {
                tempSession.setUsrId(usr.getUsrId());
                tempSession.setRolId(usr.getRolId());
                tempSession.setUsrEmail(usr.getUsrEmail());
                
                session = tempSession;
                
                
            
                student = new  BitStudent();
                student = getStudentByUser(session);
                
                isNotValidUser = false;
                System.out.println("Nombre: " + student.getStuName());
                sendRedirect("resources/views/estudiante.bitlab");
                if(session.getRolId().getRolId()==1){
                    
                }
            }
        }
        
        if (isNotValidUser) 
        {
            System.out.println("IS NOT VALID USER");
        }
    }
    
    public BitStudent getStudentByUser(int id)
    {
        return getStudentFacade().getStudentByUser(id);
    }
    
    
    public void validarSesion()
    {
        System.out.println("Validando Sesion");
        if (session.getRolId() == null) 
        {
            System.out.println("No permitido");
        }
    }
    
    public void sendRedirect(String url){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
