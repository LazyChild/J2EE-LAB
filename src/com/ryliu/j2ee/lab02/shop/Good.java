package com.ryliu.j2ee.lab02.shop;

import javax.servlet.http.HttpServletRequest;

public class Good {
    private Long id;

    private String name;

    private Double price;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Good)) {
            return false;
        }
        Good good = (Good) obj;
        return id == null ? good.id == null : id.equals(good.id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public static Good getGoodFromRequest(HttpServletRequest request) {
        Long id = null;
        try {
            id = Long.valueOf(request.getParameter("id"));
        } catch (NumberFormatException e) {
            // ignore
        }
        String name = request.getParameter("name");
        Double price = null;
        try {
            price =Double.valueOf(request.getParameter("price"));
        } catch (NumberFormatException e) {
            // ignore
        }

        Good good = new Good();
        good.id = id;
        good.name = name;
        good.price = price;
        return good;
    }
}
