package com.ryliu.j2ee.lab02.shop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveControl
 */
public class RemoveControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveControl() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Good good = Good.getGoodFromRequest(request);
        Chart chart = Chart.getChartFromSession(request.getSession(true));

        chart.removeGood(good);
        response.sendRedirect(request.getContextPath() + "/lab02/chart.jsp");
    }

}
