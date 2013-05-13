package com.ryliu.j2ee.lab02.fm.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ryliu.j2ee.lab02.fm.service.Guessnum;

/**
 * Servlet implementation class Control
 */
public class Control extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Control() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/lab02/guessnum.jsp");
        Guessnum guessnum = (Guessnum) getServletContext().getAttribute("guessnum");
        if (guessnum.getTimes() <= 0) {
            request.setAttribute("message", "你已经没有机会再猜了！");
            dispatcher.forward(request, response);
            return;
        }
        String valueString = request.getParameter("value");
        int value = 0;
        boolean error = false;
        try {
            value = Integer.valueOf(valueString);
        } catch (NumberFormatException e) {
            error = true;
        }

        if (error || value < 40 || value > 160) {
            request.setAttribute("message", "请输入一个40到160之间的数字！");
            dispatcher.forward(request, response);
            return;
        }

        if (guessnum.guess(value)) {
            request.setAttribute("message", "你猜对了！");
        } else {
            request.setAttribute("message", "猜错了, 再猜一次！还有" + guessnum.getTimes() + "次机会！");
        }
        dispatcher.forward(request, response);
    }
}
