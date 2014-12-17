package org.sevenup.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * Filter for CORS
 * about CORS details go further research
 * @author steven.xu
 *
 */
@Component
public class CORSFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) 
		   throws IOException, ServletException {
					HttpServletResponse theResponse = (HttpServletResponse) response;
					theResponse.setHeader("Access-Control-Allow-Origin", "*");
					//define what origin method the server can accept
					theResponse.setHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
					theResponse.setHeader("Access-Control-Max-Age", "3600");
					//this is important for CROS : define what header the server can accept
					theResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
					chain.doFilter(request, response);
				}
	public void init(FilterConfig filterConfig) {
    	
    }
	public void destroy() {
    	
    }
	
}