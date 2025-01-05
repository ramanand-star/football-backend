package com.example.beverage.filter;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.Logger;

public class RateLimiterFilter implements Filter {

    private static final Logger logger = Logger.getLogger(RateLimiterFilter.class.getName());
    private final Bucket bucket;

    public RateLimiterFilter() {
        Bandwidth limit = Bandwidth.classic(10, Refill.greedy(10, Duration.ofMinutes(1)));
        this.bucket = Bucket.builder().addLimit(limit).build();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("RateLimiterFilter: doFilter method called");
        if (bucket.tryConsume(1)) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setStatus(429); // HTTP status code for Too Many Requests
            httpResponse.getWriter().write("Too many requests");
            logger.warning("RateLimiterFilter: Too many requests");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("RateLimiterFilter: init method called");
    }

    @Override
    public void destroy() {
        logger.info("RateLimiterFilter: destroy method called");
    }
}