package com.info.nowin.forum.utils;

import com.info.nowin.forum.dao.UzytkownicyDAO;
import com.info.nowin.forum.encje.Uzytkownik;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Michlu
 * @sience 2017-01-29
 */
@WebFilter(filterName = "/*")
public class FiltrZalogowany implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        request.setCharacterEncoding("UTF-8");

        String login = request.getRemoteUser();
        if(login != null){
            Uzytkownik u = (Uzytkownik)request.getSession().getAttribute("uzytkownik");
            if(u == null){
                UzytkownicyDAO dao = (UzytkownicyDAO) request.getAttribute("uzytkownicyDAO");
                u = dao.pobierzPoLoginie(login);
                request.getSession().setAttribute("uzytkownik", u);
            }
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
