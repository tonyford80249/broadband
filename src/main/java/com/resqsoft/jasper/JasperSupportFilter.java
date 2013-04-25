/**
 * 
 */
/*
 *  Copyright ResQSoft, Inc. 2011
 *
 *  ref: Engineer Static Repository File
 */

package com.resqsoft.jasper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * When HTML output is used for Jasper Report generation, Jasper Reports introduces a dependency on "px" GIF file
 * used for spacing within the HTML code. This filter is used to serve that file so that changes to the HTML code
 * would be unnecessary.
 * @author ResQSoft Engineer
 *
 */
public final class JasperSupportFilter implements Filter {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {

    }
    
    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        if (request.getRequestURI().endsWith(".html_files/px")) {
            response.setContentType("image/gif");
            OutputStream os = null;
            InputStream is = null;
            try {
                os = response.getOutputStream();
                is = getClass().getResourceAsStream("/com/resqsoft/jasper/px.gif");
                IOUtils.copy(is, os);
                os.flush();
            }
            finally {
                IOUtils.closeQuietly(os);
                IOUtils.closeQuietly(is);
            }
        }
        else {
            fc.doFilter(req, res);
        }
    }
    
    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig arg0) throws ServletException {

    }
    
}
