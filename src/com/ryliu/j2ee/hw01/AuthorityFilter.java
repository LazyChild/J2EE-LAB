package com.ryliu.j2ee.hw01;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthorityFilter
 */
public class AuthorityFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthorityFilter() {
    	// empty
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// empty
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		if (request.getRequestURI().startsWith(request.getContextPath() + "/login")) {
			chain.doFilter(request, response);
		} else {
			HttpSession session = request.getSession(false);
			if (null == session || session.getAttribute("accessToken") == null
					|| !"je1124061".equals(session.getAttribute("accessToken"))) {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			} else {
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// empty
	}

}
