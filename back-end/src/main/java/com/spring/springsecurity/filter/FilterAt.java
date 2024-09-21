package com.spring.springsecurity.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterAt implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Inside Filter At");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
