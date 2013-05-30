package com.ryliu.j2ee.labfinal.controllers;

import com.ryliu.j2ee.labfinal.models.UploadFile;
import com.ryliu.j2ee.labfinal.services.UploadFileDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * The file controller.
 */
public class FileController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UploadFileDAO dao = new UploadFileDAO(getServletContext());
        UploadFile file = dao.generateFromRequest(request);
        request.setAttribute("file", file);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/labfinal/upload.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("download") != null) {
            download(request, response);
        } else {
            index(request, response);
        }
    }

    /**
     * Render the index page.
     *
     * @param request the HTTP servlet request
     * @param response the HTTP servlet response
     * @throws ServletException if any issue occurred
     * @throws IOException if any IO issue occurred.
     */
    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/labfinal/index.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Perform the download action.
     *
     * @param request the HTTP servlet request
     * @param response the HTTP servlet response
     * @throws ServletException if any issue occurred
     */
    private void download(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            UploadFileDAO dao = new UploadFileDAO(getServletContext());
            dao.download(request, response);
        } catch (SQLException e) {
            throw new ServletException("SQL issue occurred.", e);
        }
    }
}
