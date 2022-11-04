package com.example.gestuon_promotions_marjan.filtre;

import com.example.gestuon_promotions_marjan.helpers.Enum;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebFilter("AuthenticationFilter")
@WebFilter(filterName = "AuthenticationFilter", value = "/AdminStore/*")

public class AuthenticationFilter implements Filter {
    ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
        this.servletContext.log("AuthenticationFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
//        String z = req.();
//        System.out.println(uri);
        String uri = req.getRequestURI();
        this.servletContext.log("Requested Resource::" + uri);

        HttpSession session = req.getSession(false);

        if (session == null || (session.getAttribute("role") == null)) {
            this.servletContext.log("Unauthorized access request");
            res.sendRedirect("/Auth");

        } else {
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
