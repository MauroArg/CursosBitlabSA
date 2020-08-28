/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.session;

import com.bitlab.entities.BitRequest;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Maury
 */
@Stateless
public class BitRequestFacade extends AbstractFacade<BitRequest> {

    @PersistenceContext(unitName = "CursosBitlab-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BitRequestFacade() {
        super(BitRequest.class);
    }
    
    public List<BitRequest> getRequestByStudent(int estudiante)
    {
        try {
            System.out.println("Request");
            System.out.println(estudiante);
            Query q = em.createQuery("SELECT b FROM BitRequest b WHERE b.stuId.stuId = :estudiante");
            q.setParameter("estudiante", estudiante);
            List<BitRequest> req = (List<BitRequest>) q.getResultList();
        return  req;
        } catch (Exception e) {
            System.out.println("Error in validate");
            return null;
        }
    }
    
}
