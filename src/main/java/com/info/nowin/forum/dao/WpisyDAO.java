package com.info.nowin.forum.dao;

import com.info.nowin.forum.encje.Wpis;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * @author Michlu
 * @sience 2017-01-28
 */
public class WpisyDAO {
    private EntityManager em;
    public WpisyDAO(EntityManager em){
        this.em = em;
    }

    public boolean dodajWpis(Wpis w){
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(w);
            et.commit();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            et.rollback();
            return false;
        }
    }
}
