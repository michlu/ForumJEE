package com.info.nowin.forum.serwlety;

import com.info.nowin.forum.dao.TematyDAO;
import com.info.nowin.forum.dao.WpisyDAO;
import com.info.nowin.forum.encje.Temat;
import com.info.nowin.forum.encje.Uzytkownik;
import com.info.nowin.forum.encje.Wpis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Michlu
 * @sience 2017-01-29
 */
@WebServlet(name = "/temat")
public class TematSerwlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tresc = request.getParameter("tresc");
        String stringId = request.getParameter("id");
        if(tresc!= null && stringId != null){
            int id = Integer.parseInt(stringId);
            WpisyDAO wpisyDAO = (WpisyDAO)request.getAttribute("wpisyDAO");
            TematyDAO tematyDAO = (TematyDAO)request.getAttribute("tematyDAO");
            Uzytkownik zalogowany = (Uzytkownik) request.getSession().getAttribute("uzytkownik");
            Temat temat = tematyDAO.pobierzTemat(id);
            Wpis wpis = new Wpis();
            wpis.setData(new Timestamp(new Date().getTime()));
            wpis.setTresc(tresc);
            wpis.setUzytkownik(zalogowany);
            wpis.setTemat(temat);
            wpisyDAO.dodajWpis(wpis);
        }
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringId = request.getParameter("id");
        if(stringId != null){
            int id = Integer.parseInt(stringId);
            TematyDAO dao = (TematyDAO) request.getAttribute("tematyDAO");
            Temat t = dao.pobierzTemat(id);
            request.setAttribute("temat", t);
            request.getRequestDispatcher("WEB-INF/widok/temat.jsp").forward(request, response);
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
