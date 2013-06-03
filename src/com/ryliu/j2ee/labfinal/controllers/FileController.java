package com.ryliu.j2ee.labfinal.controllers;

import com.ryliu.j2ee.labfinal.models.Role;
import com.ryliu.j2ee.labfinal.models.UploadFile;
import com.ryliu.j2ee.labfinal.models.User;
import com.ryliu.j2ee.labfinal.services.UploadFileDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * The file controller.
 */
public class FileController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UploadFileDAO dao = new UploadFileDAO(getServletContext());
            UploadFile file = dao.generateFromRequest(request);
            request.setAttribute("file", file);
            request.getRequestDispatcher("/WEB-INF/jsp/labfinal/upload.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("message", "文件过大！");
            request.getRequestDispatcher("/WEB-INF/jsp/labfinal/message.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("download") != null) {
            download(request, response);
        } else if (request.getParameter("list") != null) {
            list(request, response);
        } else if (request.getParameter("delete") != null) {
            delete(request, response);
        } else if (request.getParameter("manage") != null) {
            manage(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/cloud");
        }
    }

    private void manage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UploadFileDAO dao = new UploadFileDAO(getServletContext());
            List<UploadFile> list = dao.listAll();
            request.setAttribute("list", list);
            Long sum = 0L;
            for (UploadFile file : list) {
                sum += file.getFileSize();
            }
            request.setAttribute("sum", sum);
            request.getRequestDispatcher("/WEB-INF/jsp/labfinal/manage.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("SQL issue occurred.", e);
        }
    }

    /**
     * Perform the delete action.
     *
     * @param request  the HTTP servlet request
     * @param response the HTTP servlet response
     * @throws ServletException if any issue occurred.
     * @throws IOException      if any IO issue occurred.
     */
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            UploadFileDAO dao = new UploadFileDAO(getServletContext());
            Integer id = Integer.valueOf(request.getParameter("id"));
            UploadFile file = dao.get(id);
            if (user.getRole() != Role.ADMIN && file.getOwnerId() != user.getId()) {
                request.setAttribute("message", "你没有权限删除该文件！");
                request.getRequestDispatcher("/WEB-INF/jsp/labfinal/message.jsp").forward(request, response);
            } else {
                dao.delete(id);
                response.sendRedirect(request.getHeader("Referer"));
            }
        } catch (SQLException e) {
            throw new ServletException("SQL issue occurred.", e);
        }
    }

    /**
     * Perform the download action.
     *
     * @param request  the HTTP servlet request
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

    /**
     * Perform the list action.
     *
     * @param request  the HTTP servlet request
     * @param response the HTTP servlet response
     * @throws ServletException if any issue occurred.
     * @throws IOException      if any IO issue occurred.
     */
    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UploadFileDAO dao = new UploadFileDAO(getServletContext());
            HttpSession session = request.getSession(true);
            User user = (User) session.getAttribute("user");
            List<UploadFile> list = dao.list(user.getId());
            request.setAttribute("list", list);
            Long sum = 0L;
            for (UploadFile file : list) {
                sum += file.getFileSize();
            }
            request.setAttribute("sum", sum);
            request.getRequestDispatcher("/WEB-INF/jsp/labfinal/list.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("SQL issue occurred.", e);
        }
    }
}
