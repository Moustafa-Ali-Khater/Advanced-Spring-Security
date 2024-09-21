package com.spring.springsecurity.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilrerBefore implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Inside Filter Before");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
