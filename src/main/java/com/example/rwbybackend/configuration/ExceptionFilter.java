package com.example.rwbybackend.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter
public class ExceptionFilter implements Filter {

	private static final Logger LOG = LoggerFactory.getLogger(ExceptionFilter.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		try {
			chain.doFilter(request, response);
		} catch (Exception e) {
			LOG.error("found ex", e);
			throw e;
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
