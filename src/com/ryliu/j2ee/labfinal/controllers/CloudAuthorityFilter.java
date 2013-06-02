package com.ryliu.j2ee.labfinal.controllers;

import com.ryliu.j2ee.labfinal.models.Role;
import com.ryliu.j2ee.labfinal.models.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The cloud authority filter.
 */
public class CloudAuthorityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String url = request.getRequestURI();
        String basePath = request.getContextPath() + "/cloud/";
        HttpSession session = request.getSession(false);
        boolean failed = false;
        if (url.startsWith(basePath + "user")) {
            if (checkUser(session) == null) {
                if (request.getParameter("edit") != null) {
                    failed = true;
                }
            }
        } else if (url.startsWith(basePath + "file")) {
            User user = checkUser(session);
            if (user == null) {
                if (request.getParameter("list") != null) {
                    failed = true;
                }
            } else if (user.getRole() != Role.ADMIN) {
                if (request.getParameter("manage") != null) {
                    failed = true;
                }
            }
        }
        if (failed) {
            response.sendRedirect(request.getContextPath() + "/cloud/login.jsp");
        } else {
            chain.doFilter(req, resp);
        }
    }

    private User checkUser(HttpSession session) {
        return session == null ? null : (User) session.getAttribute("user");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
