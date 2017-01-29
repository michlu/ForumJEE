package com.info.nowin.forum.serwlety;

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
@WebServlet(name = "/wyloguj")
public class WylogujSerwlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("uzytkownik", null);
        request.logout();
        response.sendRedirect(request.getContextPath() + "/index");
    }
}
