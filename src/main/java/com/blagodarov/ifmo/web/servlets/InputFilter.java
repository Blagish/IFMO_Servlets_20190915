package com.blagodarov.ifmo.web.servlets;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(
        filterName = "EquationInput",
        urlPatterns = {"/calc/equation"}
)

public class InputFilter implements Filter {
    @Override
    public void init(FilterConfig con) {
        //pass
    }

    @Override
    public void doFilter (ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        String equation = req.getReader().readLine().replace(" ", "");
        req.getReader().reset();

        if (equation.indexOf('*') == -1 && equation.indexOf('/') == -1 && equation.indexOf('+') == -1 && equation.indexOf('-') == -1)
            ((HttpServletResponse)resp).setStatus(400);
        else
            chain.doFilter(req,resp);
    }

    @Override
    public void destroy(){
        //pass
    }

} 