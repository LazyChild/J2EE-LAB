package com.ryliu.j2ee.labfinal.controllers;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author TCSASSEMBLER
 * @version 1.0
 */
public class CloudAuthorityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
