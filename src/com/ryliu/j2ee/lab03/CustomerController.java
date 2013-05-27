package com.ryliu.j2ee.lab03;

import com.ryliu.j2ee.utils.Helper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CustomerController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("list") != null) {
            list(request, response);
        } else if (request.getParameter("update") != null) {
            update(request, response);
        } else if (request.getParameter("form") != null) {
            form(request, response);
        }
        response.getWriter().println("Invalid request!");
    }

    /**
     * The form control method.
     *
     * @param request the HTTP servlet request
     * @param response the HTTP servlet response
     * @throws ServletException if any issue occurred.
     * @throws IOException if any IO issue occurred.
     */
    private void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (request.getParameter("cid") != null) {
                CustomerDAO dao = new CustomerDAO();
                request.setAttribute("customer", dao.get(request.getParameter("cid")));
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/lab03/form.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("SQL error occurred.", e);
        }
    }

    /**
     * The update control method.
     *
     * @param request the HTTP servlet request
     * @param response the HTTP servlet response
     * @throws ServletException if any issue occurred.
     * @throws IOException if any IO issue occurred.
     */
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CustomerDAO dao = new CustomerDAO();
            Customer customer = Helper.getFromRequest(Customer.class, request);
            dao.update(customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/lab03/list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("SQL error occurred.", e);
        }
    }

    /**
     * The list control method.
     *
     * @param request the HTTP servlet request
     * @param response the HTTP servlet response
     * @throws ServletException if any issue occurred.
     * @throws IOException if any IO issue occurred.
     */
    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CustomerDAO dao = new CustomerDAO();
            request.setAttribute("list", dao.list());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/lab03/list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("SQL error occurred.", e);
        }
    }
}
