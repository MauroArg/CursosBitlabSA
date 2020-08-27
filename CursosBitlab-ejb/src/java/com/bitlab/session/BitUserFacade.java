/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.session;

import com.bitlab.entities.BitUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Maury
 */
@Stateless
public class BitUserFacade extends AbstractFacade<BitUser> {

    @PersistenceContext(unitName = "CursosBitlab-ejbPU")
    private EntityManager em;
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BitUserFacade() {
        super(BitUser.class);
    }
    
    public BitUser validarUsuario(String email)
    {
        Query q = getEntityManager().createQuery("SELECT b FROM BitUser b WHERE b.usrEmail = :email");
        q.setParameter("email", email);
        return (BitUser) q.getSingleResult();
    }
    
}
