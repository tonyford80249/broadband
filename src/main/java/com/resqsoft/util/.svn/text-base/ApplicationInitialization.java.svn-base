package com.resqsoft.util;

import org.apache.commons.lang.exception.ExceptionUtils;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * The purpose of this class is to perform application initialization and
 * shutdown functions. This class implements ServletContextListener and is
 * capable of receiving events indicating the application initialization or
 * shutdown phase. This class was introduced as a replacement of
 * CommonStartupServlet that is now deprecated. Startup servlets should not be
 * used for this purpose as servlet specification does not strictly define their
 * lifecycle. Startup servlets are guaranteed to be loaded at the application
 * startup but they are not guaranteed to be kept in memory for the whole
 * application's lifespan. Container may remove a servlet's instance at any time
 * and call its destroy method. So it is possible that Startup servlet's
 * destroy() method may be called but this does not necessarily mean the
 * application is about to be shutdown.
 *
 * @version 1.0
 * @author ResQSoft Engineer
 *
 */
public class ApplicationInitialization implements ServletContextListener {
    protected static final org.apache.log4j.Logger APP_LOG = org.apache.log4j.Logger.getLogger(ApplicationInitialization.class);
    public static ServletContext SERVLET_CONTEXT;
    protected boolean loggingInitialized;

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent contextEv) {
        ServletContext context = contextEv.getServletContext();
        SERVLET_CONTEXT = context;

        String logFileName = context.getInitParameter("LogFileName");

        try {
            this.initBuildProperties(context);
        } catch (Exception e) {
            e.printStackTrace();
            APP_LOG.error(ExceptionUtils.getFullStackTrace(e));
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent contextEv) {
        SERVLET_CONTEXT = null;
    }

    private void initBuildProperties(ServletContext context)
        throws SecurityException, IOException {
        String buildPropertiesFilePath = "/WEB-INF/buildinfo/build.properties";

        //Get build properties file
        InputStream stream = new FileInputStream(context.getRealPath(
                    buildPropertiesFilePath));

        BuildInfo.init(stream);
    }

    public boolean isLoggingInitialized() {
        return loggingInitialized;
    }
}