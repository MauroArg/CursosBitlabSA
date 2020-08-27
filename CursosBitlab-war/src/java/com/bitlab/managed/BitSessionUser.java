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
    private BitUser session;
    private BitUser tempSession;
    private BitUserFacade uc;

    public BitSessionUser() {
    }

    
    
    public BitUser getSession() {
        return session;
    }

    public void setSession(BitUser session) {
        this.session = session;
    }

    public BitSessionUser(BitUser session, BitUserFacade uc) {
        this.session = session;
        this.uc = uc;
    }

    public BitUser getTempSession() {
        return tempSession;
    }

    public void setTempSession(BitUser tempSession) {
        this.tempSession = tempSession;
    }

    public BitUserFacade getUc() {
        return uc;
    }

    public void setUc(BitUserFacade uc) {
        this.uc = uc;
    }
    
    
    @PostConstruct
    public void inicializar()
    {
        session = new BitUser();
        tempSession = new BitUser();
        uc = new BitUserFacade();
    }
    
    public void validateUser()
    {
        BitUser usr = new BitUser();
        boolean isNotValidUser = true;
        
        System.out.println(tempSession.getUsrEmail());
        System.out.println(tempSession.getUsrPassword());
        try{
            usr = uc.validarUsuario(tempSession.getUsrEmail());
            
            System.out.println(usr.getUsrPassword());
            System.out.println(usr.getUsrEmail());
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
