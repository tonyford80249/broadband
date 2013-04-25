/*
 * Copyright ResQSoft, Inc. 2011
 */

package com.cdoe;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.resqsoft.util.AppContextUtils;
import com.resqsoft.util.ApplicationInitialization;



/*
 * ref: misc/applicationlifecyclelistener.class.et.jsp
 */

/**
 * A class that is invoked on system startup in order to perform Web application's
 * initialization processing. This includes initializing the logging framework,
 * preparing the cache, starting the memory monitor (if needed) and reading information
 * from the /WEB-INF/BuildInfo/build.properties file.
 * This listener will also handle application shutdown event to perform the clean-up:
 * shut down logging, database connections and other.
 */
public final class ApplicationLifecycleListener extends
        ApplicationInitialization {

    // absolute path to the web app deployment directory
    // may be null if deployed as war file for example.
    public static String appPath;

    /**
     * Handles Web application's initialization event. This includes initializing the logging framework,
     * preparing the cache, starting the memory monitor (if needed) and reading information
     * from the /WEB-INF/BuildInfo/build.properties file.
     *
     * @param event
     *            ServletContextEvent
     */
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);


        ServletContext context = event.getServletContext();
        appPath = context.getRealPath("/");

        ApplicationContext appContext = null;
        try {
            appContext = WebApplicationContextUtils
                    .getRequiredWebApplicationContext(ApplicationInitialization.SERVLET_CONTEXT);
        }
        catch (final RuntimeException e) {
            e.printStackTrace();
        }
        AppContextUtils.setApplicationContext(appContext);
    }




     /**
     * Handles Web application's shutdown event: shut down logging, database connections and other.
     *
     * @param event
     *            ServletContextEvent
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        super.contextDestroyed(arg0);

    }
}