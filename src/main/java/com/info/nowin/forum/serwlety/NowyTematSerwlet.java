package com.info.nowin.forum.serwlety;

import com.info.nowin.forum.dao.TematyDAO;
import com.info.nowin.forum.encje.Temat;
import com.info.nowin.forum.encje.Uzytkownik;

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
@WebServlet(name = "/nowyTemat")
public class NowyTematSerwlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tytul = request.getParameter("tytul");
        String tresc = request.getParameter("tresc");
        if(!"".equals(tytul) && !"".equals(tresc)){
            Timestamp t = new Timestamp(new Date().getTime());
            Uzytkownik zalogowany = (Uzytkownik) request.getSession().getAttribute("uzytkownik");
            TematyDAO dao = (TematyDAO) request.getAttribute("tematyDAO");
            Temat temat = new Temat();
            temat.setData(t);
            temat.setTresc(tresc);
            temat.setTytul(tytul);
            temat.setUzytkownik(zalogowany);
            if(dao.dodajTemat(temat))
                response.sendRedirect(request.getContextPath() + "/temat?id=" + temat.getId());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/widok/nowyTemat.jsp").forward(request, response);
    }
}
