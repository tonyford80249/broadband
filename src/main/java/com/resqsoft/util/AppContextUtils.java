/*
 * Copyright ResQSoft, Inc. 2007
 */
/*
 *  Copyright ResQSoft, Inc. 2011
 *
 *  ref: Engineer Static Repository File
 */

package com.resqsoft.util;

import java.util.Locale;

import org.springframework.context.ApplicationContext;


/**
 * Works with ApplicationInitializationListener 
 * to get Spring Framework Application Context in servlet environment in order 
 * to hide the Spring framework details from the rest of the application.
 *
 */
public class AppContextUtils {
    
    //---------------------------------------------------------------
    // Class variables
    //
    
    /** The singleton. */
    private static AppContextUtils singleton = new AppContextUtils();
    
    /** The app context. */
    protected static ApplicationContext appContext;
    
    //-------------------------------------------------------------------
    // Instance variables
    //
    /** The current locale. */
    protected Locale currentLocale = Locale.getDefault();
    
    //--------------------------------------------------------------------
    // Static methods
    //
    
    /**
     * This method is during testing so that the static methods defined on 
     * this class can return an instance of a test stub implementation of 
     * this class in order to avoid dependencies on Acegi security and the
     * user actually logging in and other things like that. 
     */
    public static void setInstance(final AppContextUtils instance) {

        AppContextUtils.singleton = instance;
    }
    
    /**
     * When used as part of a web application, 
     * the ApplicationLifecycleListener calls this method
     * to provide a reference to the Spring Framework's ApplicationContext
     * object. When used as part of a jUnit based test ran from Ant or from
     * Eclipse, the BaseIntegrationTestCase class uses 
     * the ClassPathXmlApplicationContext class to load the ApplicationContext
     * and calls this method.
     * 
     * @param newAppContext
     */
    public static void setApplicationContext(final ApplicationContext newAppContext) {

        AppContextUtils.appContext = newAppContext;
    }
    
    /**
     * Gets the current locale.
     * 
     * @return the current locale
     */
    public static Locale getCurrentLocale() {

        return AppContextUtils.singleton._getCurrentLocale();
    }
    
    /**
     * _get current locale.
     * 
     * @return the locale
     */
    public Locale _getCurrentLocale() {

        return this.currentLocale;
    }
    
    /**
     * Sets the current locale.
     * 
     * @param locale the current locale
     */
    public static void setCurrentLocale(final Locale locale) {

        AppContextUtils.singleton._setCurrentLocale(locale);
    }
    
    /**
     * Gets the bean.
     * 
     * @param beanName the bean name
     * 
     * @return the bean
     */
    public static Object getBean(final String beanName) {

        return AppContextUtils.singleton._getBean(beanName);
    }
    
    /**
     * Gets the version.
     * 
     * @return the version
     */
    public static String getVersion() {

        return AppContextUtils.singleton._getVersion();
    }
    
    /**
     * Gets the build id.
     * 
     * @return the build id
     */
    public static String getBuildId() {

        return AppContextUtils.singleton._getBuildId();
    }
    
    /**
     * Gets the build date.
     * 
     * @return the build date
     */
    public static String getBuildDate() {

        return AppContextUtils.singleton._getBuildDate();
    }
    
    //------------------------------------------------------
    // Instance methods
    //
    
    /**
     * _get build id.
     * 
     * @return the string
     */
    private String _getBuildId() {

        return BuildInfo.getInstance().getBuildId();
    }
    
    /**
     * _get version.
     * 
     * @return the string
     */
    private String _getVersion() {

        return BuildInfo.getInstance().getVersion();
    }
    
    /**
     * _get build date.
     * 
     * @return the string
     */
    private String _getBuildDate() {

        return BuildInfo.getInstance().getBuildDate();
    }
    
    /**
     * _set current locale.
     * 
     * @param locale the locale
     */
    public void _setCurrentLocale(final Locale locale) {

        this.currentLocale = locale;
    }
    
    /**
     * _get bean.
     * 
     * @param beanName the bean name
     * 
     * @return the object
     */
    public Object _getBean(final String beanName) {

        Object object = this.getApplicationContext().getBean(beanName);
        if (object == null) {
            throw new IllegalStateException("No bean defined for name of: " + beanName);
        }
        return AppContextUtils.appContext.getBean(beanName);
    }
    
    private ApplicationContext getApplicationContext() {

        if (this.appContext == null) {
            throw new IllegalStateException("ApplicationContext is null.");
        }
        return this.appContext;
    }

}
