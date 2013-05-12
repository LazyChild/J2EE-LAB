package com.ryliu.j2ee.hw01;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetSourceServlet
 */
public class GetSourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Represents the code host URL.
	 */
    private static final String HOST = "https://raw.github.com/LazyChild/J2EE-LAB/master/";

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
	    if (null != className && null == fileName) {
	        URL fileURL = GetSourceServlet.class.getClassLoader().getResource(className.replace(".", File.separator) + ".java");
	        File file = new File(fileURL.toString());
	        System.out.println(file.getAbsolutePath());
	        response.sendRedirect(HOST + "src/" + className.replace('.', '/') + ".java");
	    } else if (null == className && null != fileName) {
	        response.sendRedirect(HOST + "WebRoot/" + fileName);
	    } else {
	        response.setContentType("plain/text;charset=UTF-8");
	        response.getWriter().println("≤Œ ˝«Î«Û¥ÌŒÛ£°");
	    }
	}

}
