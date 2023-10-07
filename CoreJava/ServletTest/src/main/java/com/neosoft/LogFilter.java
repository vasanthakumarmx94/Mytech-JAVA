package com.neosoft;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = {"/*"},
	
		initParams = {
				@WebInitParam(name="log-param",value = "Login info..")
		}
		)
public class LogFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		System.out.println(filterConfig.getInitParameter("log-param"));
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//Log some information on console
		System.out.println("New Rwequest Time:"+new Date().toString());
		System.out.println("Remote address:"+request.getRemoteAddr());
		System.out.println("Remote Host:"+request.getRemoteHost());
		System.out.println("Local Name :"+request.getLocalName());
		System.out.println("Local port :"+request.getLocalPort());
		System.out.println("Protocol :"+request.getProtocol());
		
		
		//pass req back down the filter chain
		chain.doFilter(request, response);
		
		
	}
	
	@Override
	public void destroy() {
		
	}

}
