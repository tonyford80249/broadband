/**
 * 
 */
/*
 *  Copyright ResQSoft, Inc. 2011
 *
 *  ref: Engineer Static Repository File
 */

package com.resqsoft.util;

import org.springframework.context.MessageSource;

/*
 * * Helper methods to work with resource bundle.
 * @author ResQSoft Engineer
 */
public final class MessageUtils {
    
    /**
     * Gets the message by key.
     * @param key
     * @return
     */
    public static String getMessage(String key) {

        return ((MessageSource) AppContextUtils.getBean("messageSource")).getMessage(key, null,
                null);
    }
    
    /**
     * Gets the message by key.
     * @param key
     * @return
     */
    public static String getMessage(String key, String... values) {

        return ((MessageSource) AppContextUtils.getBean("messageSource")).getMessage(key, values,
                null);
    }
    
    
}
