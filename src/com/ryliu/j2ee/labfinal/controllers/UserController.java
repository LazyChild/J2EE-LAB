package com.ryliu.j2ee.labfinal.controllers;

import com.ryliu.j2ee.labfinal.models.User;
import com.ryliu.j2ee.labfinal.services.UserDAO;
import com.ryliu.j2ee.utils.Helper;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * The user controller.
 */
public class UserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("login") != null) {
            login(request, response);
        } else if (request.getParameter("register") != null) {
            register(request, response);
        } else if (request.getParameter("edit") != null) {
            editPost(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("edit") != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/labfinal/edit.jsp");
            dispatcher.forward(request, response);
        } else if (request.getParameter("logout") != null) {
            HttpSession session = request.getSession();
            session.removeAttribute("user");
            response.sendRedirect(request.getContextPath() + "/cloud");
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        String email = request.getParameter("email");
        String password = DigestUtils.md5Hex(request.getParameter("password"));
        User user = null;
        boolean error = false;
        try {
            user = dao.getByEmail(email);
            if (user.getEmail() == null || !user.getPassword().equals(password)) {
                error = true;
            }
        } catch (SQLException e) {
            error = true;
        }
        if (error) {
            request.setAttribute("message", "用户名或密码错误!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/labfinal/message.jsp");
            dispatcher.forward(request, response);
        } else {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(-1);
            response.sendRedirect(request.getContextPath() + "/cloud");
        }
    }

    /**
     * Perform the register action.
     *
     * @param request the HTTP servlet request
     * @param response the HTTP servlet response
     * @throws ServletException if any issue occurred
     * @throws IOException if any IO issue occurred
     */
    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserDAO dao = new UserDAO();
            User user = dao.generateFromRequest(request);
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(-1);
            response.sendRedirect(request.getContextPath() + "/cloud");
        } catch (SQLException e) {
            request.setAttribute("message", "用户注册失败！请检查是否重复注册。");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/labfinal/message.jsp");
            dispatcher.forward(request, response);
        }
    }

    /**
     * Perform the edit.
     *
     * @param request the HTTP servlet request
     * @param response the HTTP servlet response
     * @throws ServletException if any issue occurred
     * @throws IOException if any IO issue occurred
     */
    private void editPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        try {
            dao.update(user.getId(), Helper.getParameter(request, "name"), Helper.getParameter(request, "address"));
            session.setAttribute("user", dao.get(user.getId()));
        } catch (SQLException e) {
            throw new ServletException("SQL error occurred.", e);
        }
        response.sendRedirect(request.getContextPath() + "/cloud");
    }
}
