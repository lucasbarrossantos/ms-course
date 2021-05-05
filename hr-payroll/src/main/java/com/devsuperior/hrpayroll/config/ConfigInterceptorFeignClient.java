package com.devsuperior.hrpayroll.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class ConfigInterceptorFeignClient implements RequestInterceptor, Filter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private String token;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(AUTHORIZATION_HEADER, this.token);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        this.token = req.getHeader("Authorization");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
