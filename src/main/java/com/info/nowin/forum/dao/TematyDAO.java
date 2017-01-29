package com.info.nowin.forum.dao;

import com.info.nowin.forum.encje.Temat;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * @author Michlu
 * @sience 2017-01-28
 */
public class TematyDAO {
    private EntityManager em;

    public TematyDAO(EntityManager em){
        this.em = em;
    }

    public List<Temat> pobierzTematy(){
        List<Temat> tematy = this.em.createQuery("SELECT t from Temat t").getResultList();
        return tematy;
    }

    public Temat pobierzTemat(int id){
        this.em.clear();
        return  this.em.find(Temat.class, id);
    }

    public boolean dodajTemat(Temat t){
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(t);
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
