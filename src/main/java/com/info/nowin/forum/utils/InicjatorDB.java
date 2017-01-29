package com.info.nowin.forum.utils;

import com.info.nowin.forum.dao.TematyDAO;
import com.info.nowin.forum.dao.UzytkownicyDAO;
import com.info.nowin.forum.dao.WpisyDAO;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Michlu
 * @sience 2017-01-28
 */
@WebListener
public class InicjatorDB implements ServletRequestListener {


    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        EntityManager em = DBConfig.createEntityManager();
        UzytkownicyDAO uzytkownicyDAO = new UzytkownicyDAO(em);
        TematyDAO tematyDAO = new TematyDAO(em);
        WpisyDAO wpisyDAO = new WpisyDAO(em);
        ServletRequest request = sre.getServletRequest();
        request.setAttribute("wpisyDAO", wpisyDAO);
        request.setAttribute("tematyDAO", tematyDAO);
        request.setAttribute("uzytkownicyDAO", uzytkownicyDAO);
    }
}
