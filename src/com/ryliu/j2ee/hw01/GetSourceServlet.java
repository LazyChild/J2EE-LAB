package com.ryliu.j2ee.hw01;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

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
	        String classPath = "src" + File.separator + className.replace(".", File.separator) + ".java";
	        InputStream inputStream = GetSourceServlet.class.getClassLoader().getResourceAsStream(classPath);
	        String content = IOUtils.toString(inputStream, "UTF-8");
	        response.setContentType("text/plain;charset=UTF-8");
	        response.getWriter().println(content);
	    } else if (null == className && null != fileName) {
	        String classPath = "WebRoot" + File.separator + fileName;
	        InputStream inputStream = GetSourceServlet.class.getClassLoader().getResourceAsStream(classPath);
            String content = IOUtils.toString(inputStream, "UTF-8");
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().println(content);
	    } else {
	        response.setContentType("plain/text;charset=UTF-8");
	        response.getWriter().println("Wrong parameters!");
	    }
	}

}
