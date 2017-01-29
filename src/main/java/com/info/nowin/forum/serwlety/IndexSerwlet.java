package com.info.nowin.forum.serwlety;

import com.info.nowin.forum.dao.TematyDAO;
import com.info.nowin.forum.encje.Temat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Michlu
 * @sience 2017-01-29
 */
@WebServlet(name = "/index")
public class IndexSerwlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TematyDAO dao = (TematyDAO) request.getAttribute("tematyDAO");
        List<Temat> tematy = dao.pobierzTematy();
        request.setAttribute("tematy", tematy);
        request.getRequestDispatcher("/WEB-INF/widok/index.jsp").forward(request, response);
    }
}
