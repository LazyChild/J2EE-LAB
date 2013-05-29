package com.ryliu.j2ee.labfinal.controllers;

import com.ryliu.j2ee.labfinal.services.UploadFileDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * The file controller.
 */
public class FileController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UploadFileDAO dao = new UploadFileDAO();
        dao.setRepository((File) getServletContext().getAttribute("javax.servlet.context.tempdir"));
        dao.generateFromRequest(request);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        index(request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/labfinal/index.jsp");
        dispatcher.forward(request, response);
    }
}
