/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.session;

import com.bitlab.entities.BitStudent;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Maury
 */
@Stateless
public class BitStudentFacade extends AbstractFacade<BitStudent> {

    @PersistenceContext(unitName = "CursosBitlab-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BitStudentFacade() {
        super(BitStudent.class);
    }
    
    public BitStudent getStudentByUser(int id)
    {
        try {
            System.out.println("ValidateUser");
            System.out.println(id);
            Query q = em.createQuery("SELECT b FROM BitStudent b WHERE b.usr_id = :id");
            q.setParameter("id", id);
            BitStudent stu = (BitStudent) q.getSingleResult();
        return  stu;
        } catch (Exception e) {
            System.out.println("Error in validate");
            return null;
        }
    }
    
}
