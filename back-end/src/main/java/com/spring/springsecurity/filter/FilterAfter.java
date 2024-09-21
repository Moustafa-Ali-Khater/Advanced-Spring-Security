package com.spring.springsecurity.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterAfter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Inside Filter After");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
