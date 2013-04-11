package com.ryliu.j2ee.hw01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // set encoding
        response.setContentType("text/plain;charset=UTF-8");

        // output info
        PrintWriter writer = response.getWriter();
        writer.println("我的第一个Java Servlet");
        writer.println("11300240061 刘仁宇");
        writer.println("欢迎使用本系统。");
    }

}
