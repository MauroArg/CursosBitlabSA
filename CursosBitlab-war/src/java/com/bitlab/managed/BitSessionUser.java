/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.managed;

import com.bitlab.entities.BitUser;
import com.bitlab.session.BitUserFacade;
import com.bitlab.util.Encryption;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
    private BitUser session;
    private BitUser tempSession;
    private BitUserController uc;

    public BitSessionUser() {
    }

    public BitUserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(BitUserFacade userFacade) {
        this.userFacade = userFacade;
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
                isNotValidUser = false;
                System.out.println("ENTRO");
            }
        }
        
        if (isNotValidUser) 
        {
            System.out.println("IS NOT VALID USER");
        }
    }
    
    public void validarSesion()
    {
        System.out.println("Validando Sesion");
        if (session.getRolId() == null) 
        {
            System.out.println("No permitido");
        }
    }
    
    
}
