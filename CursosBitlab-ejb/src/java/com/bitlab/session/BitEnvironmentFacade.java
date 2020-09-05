/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.session;

import com.bitlab.entities.BitEnvironment;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.omg.CORBA.Environment;

/**
 *
 * @author Maury
 */
@Stateless
public class BitEnvironmentFacade extends AbstractFacade<BitEnvironment> {

    @PersistenceContext(unitName = "CursosBitlab-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BitEnvironmentFacade() {
        super(BitEnvironment.class);
    }

    public List<BitEnvironment> getEnvironmentFromStudent(int student) {
        List<BitEnvironment> lsEnvironment = null;
        try {
            Query q = em.createQuery("SELECT DISTINCT(e.envId), e.envName FROM BitDetail d JOIN d.skiId s JOIN s.envId e");
            List<Object> lsObj = q.getResultList();

            for (Object object : lsObj) {
                BitEnvironment e = new BitEnvironment((int) object);
                e.setEnvName(object.toString());
                lsEnvironment.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lsEnvironment;
    }

}
