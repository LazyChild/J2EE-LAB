package com.ryliu.j2ee.lab02.shop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuyControl
 */
public class BuyControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyControl() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Good good = Good.getGoodFromRequest(request);
	    Chart chart = Chart.getChartFromSession(request.getSession(true));

	    chart.addGood(good);
	    response.sendRedirect(request.getContextPath() + "/lab02/shop?ok");
	}

}
