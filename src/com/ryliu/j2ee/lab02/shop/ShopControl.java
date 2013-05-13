package com.ryliu.j2ee.lab02.shop;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShopControl
 */
public class ShopControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopControl() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("goods", generatedList());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/lab02/shop.jsp");
        dispatcher.forward(request, response);
    }

    private static List<Good> generatedList() {
        Good good1 = new Good();
        good1.setName("Macbook Air 11");
        good1.setPrice(1000.0);

        Good good2 = new Good();
        good2.setName("Macbook Air 13");
        good2.setPrice(2000.0);

        Good good3 = new Good();
        good3.setName("Macbook Pro 13");
        good3.setPrice(3000.0);

        Good good4 = new Good();
        good4.setName("Macbook Pro 15");
        good4.setPrice(4000.0);
        return Arrays.asList(good1, good2, good3, good4);
    }
}
