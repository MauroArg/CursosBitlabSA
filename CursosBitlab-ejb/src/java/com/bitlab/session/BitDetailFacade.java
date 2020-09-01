/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.session;

import com.bitlab.entities.BitDetail;
import com.bitlab.entities.BitStudent;
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
public class BitDetailFacade extends AbstractFacade<BitDetail> {

    @PersistenceContext(unitName = "CursosBitlab-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BitDetailFacade() {
        super(BitDetail.class);
    }
    
    public List<BitDetail> detailsByStudent(int estudiante){
     try {
            System.out.println("Request");
            System.out.println(estudiante);
            Query q = em.createQuery("SELECT b FROM BitDetail b WHERE b.stuId.stuId = :estudiante");
            q.setParameter("estudiante", estudiante);
            List<BitDetail> req = (List<BitDetail>) q.getResultList();
        return  req;
        } catch (Exception e) {
            System.out.println("Error in validate");
            return null;
        }
   }
    
}
