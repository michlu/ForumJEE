package com.info.nowin.forum.dao;

import com.info.nowin.forum.encje.Rola;
import com.info.nowin.forum.encje.Uzytkownik;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigInteger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Michlu
 * @sience 2017-01-28
 */
public class UzytkownicyDAO {
    private EntityManager em;
    public UzytkownicyDAO(EntityManager em){
        this.em = em;
    }

    public Uzytkownik pobierzPoLoginie(String login) {
        Uzytkownik u = (Uzytkownik)em.createQuery("SELECT u from Uzytkownik u WHERE u.login = :login").setParameter("login", login).getSingleResult();
        return u;
    }

    public boolean dodajUzytkownika(Uzytkownik u) {
        u.setHaslo(this.pobierzMD5(u.getHaslo()));
        Rola r = new Rola();
        r.setLogin(u.getLogin());
        r.setRola("uzytkownik");
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(u);
            em.persist(r);
            et.commit();
            return true;
        }
        catch (Exception e){
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }

    private String pobierzMD5(String dane){
        MessageDigest md5;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }
        md5.update(dane.getBytes());
        BigInteger hasz = new BigInteger(1, md5.digest());
        String gotowy = hasz.toString(16);
        if(gotowy.length()==31)
            gotowy = "0" + gotowy;
            return gotowy;
    }
}
