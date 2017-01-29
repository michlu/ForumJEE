package com.info.nowin.forum.serwlety;

import com.info.nowin.forum.dao.UzytkownicyDAO;
import com.info.nowin.forum.encje.Uzytkownik;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Michlu
 * @sience 2017-01-29
 */
@WebServlet(name = "/rejestruj")
public class RejestrujSerwlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String haslo = request.getParameter("haslo");
        String haslo2 = request.getParameter("haslo2");
        if(login != null && haslo != null && haslo2 != null && haslo.equals(haslo2) && !"".equals(haslo)) {
            UzytkownicyDAO dao = (UzytkownicyDAO) request.getAttribute("uzytkownicyDAO");
            try{
                dao.pobierzPoLoginie(login);
                request.setAttribute("error", "Taki login juz istnieje!");
                doGet(request, response);
            }
            catch (NoResultException nre){
                Uzytkownik u = new Uzytkownik();
                u.setLogin(login);
                u.setHaslo(haslo);
                if (dao.dodajUzytkownika(u))
                    response.sendRedirect(request.getContextPath() + "/index");
                else
                    request.setAttribute("error", "Nie udalo sie zakonczyc rejestracji");
            }
        }
        else{
            request.setAttribute("error", "Blad nadnych logowania");
            doGet(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/widok/rejestracja.jsp").forward(request, response);
    }
}
