package com.ryliu.j2ee.lab01;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Servlet implementation class GetSourceServlet
 */
public class GetSourceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSourceServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String className = request.getParameter("class");
        String fileName = request.getParameter("file");
        if (null != className && null == fileName || null == className && null != fileName) {
            String url;
            if (className != null) {
                url = "src" + File.separator + className.replace(".", File.separator) + ".java";
                request.setAttribute("title", className);
            } else {
                url = "WebRoot" + File.separator + fileName;
                request.setAttribute("title", fileName);
            }
            InputStream inputStream = GetSourceServlet.class.getClassLoader().getResourceAsStream(url);
            if (inputStream == null) {
                request.setAttribute("code", "No such file!");
            } else {
                String content = IOUtils.toString(inputStream, "UTF-8");
                if (fileName != null) {
                    content = StringEscapeUtils.escapeHtml(content);
                }
                request.setAttribute("code", content);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/show_code.jsp");
            dispatcher.forward(request, response);
        } else {
            response.setContentType("plain/text;charset=UTF-8");
            response.getWriter().println("Wrong parameters!");
        }
    }

}
