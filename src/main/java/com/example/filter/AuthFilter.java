package com.example.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter(urlPatterns = {
        "/user/*"
})

public class AuthFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
            return;
        } else {
            chain.doFilter(request, response);
        }
    }

}