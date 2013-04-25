/*
 *  Copyright ResQSoft, Inc. 2011
 *
 *  ref: Engineer Static Repository File
 */

package com.resqsoft.biz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.resqsoft.util.MessageUtils;


/**
 *
 * @author ResQSoft Engineer
 */
public class ValidationException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 4303493927736690852L;
    private ErrorList errorList = new ErrorList();

    public ValidationException(String message) {
        super(message);
    }

    /**
     * Construct a validation exception with a given error list.
     */
    public ValidationException(String message, ErrorList errorList) {
        super(message);
        this.errorList = errorList;
    }

	/**
	 * A convenience constructor that creates a MessageList object
	 * for the given errorKey and single error message argument for
	 * use when processing should halt after the first error.
	 *
	 * @param message
	 * @param errorKey
	 * @see J2EE Best Practices, p. 99
	 */
    public ValidationException(String message, String errorKey) {
        super(message);
        ErrorList messageList = new ErrorList();
        messageList.addError(errorKey);
        this.errorList = messageList;
    }

	/**
	 * A convenience constructor that creates a MessageList object
	 * for the given errorKey and multiple error message argument for
	 * use when processing should halt after the first error.
	 *
	 * @param message
	 * @param errorKey
	 * @param args
	 * @see J2EE Best Practices, p. 99
	 */
    public ValidationException(String message, String errorKey, String[] args) {
        super(message);
        ErrorList messageList = new ErrorList();
        messageList.addError(errorKey, args);
        this.errorList = messageList;
    }

    /**
     * Return the list of BusinessMessage objects that caused this
     * validation exception.
     *
     * @return list of BusinessMessage objects
     */
    public ErrorList getErrorList() {
        return errorList;
    }
    
    /**
     * Returns all error messages contained in this exception as a {@link Collection} of {@link String}s.
     * @return
     */
    public Collection<String> getErrorMessages() {
        List<String> list = new ArrayList<String>();
        final Iterator<BusinessMessage> iterator = errorList.iterator();
        while (iterator.hasNext()) {
            final BusinessMessage msg = iterator.next();
            if ((msg.getArguments() != null) && (msg.getArguments().length > 0)) {
                String str = MessageUtils.getMessage(msg.getMessageKey(), msg.getArguments());
                list.add(str);
            }
            else {
                String str = MessageUtils.getMessage(msg.getMessageKey());
                list.add(str);
            }
        }       
        return list;
    }

}
