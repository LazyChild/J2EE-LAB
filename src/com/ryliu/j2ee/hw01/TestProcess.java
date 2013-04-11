package com.ryliu.j2ee.hw01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestProcess
 */
public class TestProcess extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // set encoding
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=UTF-8");

        // calculate score
        int score = 0;
        if ("杨玉良".equals(request.getParameter("name"))) {
            score += 25;
        }
        if ("zhangjiang".equals(request.getParameter("campus"))) {
            score += 25;
        }
        String[] values = request.getParameterValues("techs");
        if (contains(values, "servlet") && contains(values, "jsp") && !contains(values, "java_bean")
                && !contains(values, "java_mail")) {
            score += 25;
        }
        if ("T".equals(request.getParameter("judge"))) {
            score += 25;
        }
        PrintWriter writer = response.getWriter();
        writer.println("你的分数： " + score);
    }

    private static boolean contains(String[] values, String str) {
        if (values == null || str == null)
            return false;
        for (String value : values) {
            if (str.equals(value))
                return true;
        }
        return false;
    }

}
