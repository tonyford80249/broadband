/*
 *  Copyright ResQSoft, Inc. 2011
 *
 *  ref: Engineer Static Repository File
 */

package com.resqsoft.biz;

import java.io.Serializable;
import java.util.Arrays;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.resqsoft.util.MessageUtils;

public class BusinessMessage implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String msgKey;

    // Default to standard error.
    private int type = MSG_TYPE_ERROR;

    private String[] msgArguments;

    public final static int MSG_TYPE_INFO = 1;

    public final static int MSG_TYPE_ERROR = 2;

    public final static int MSG_TYPE_CRITICAL = 3;

    public BusinessMessage() {

    }

    public BusinessMessage(String msgKey, String arg1) {

        this.msgKey = msgKey;
        this.msgArguments = new String[1];
        this.msgArguments[0] = arg1;
    }

    public BusinessMessage(String msgKey, String[] args) {

        this.msgKey = msgKey;
        this.msgArguments = args;
    }

    public BusinessMessage(String msgKey) {

        this.msgKey = msgKey;
    }

    public String getMessageKey() {

        return this.msgKey;
    }

    public void setMessageKey(String msgKey) {

        this.msgKey = msgKey;
    }

    public String[] getArguments() {

        return this.msgArguments;
    }

    public void setArguments(String[] msgArguments) {

        this.msgArguments = msgArguments;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(this.msgArguments);
        result = prime * result + ((this.msgKey == null) ? 0 : this.msgKey.hashCode());
        result = prime * result + this.type;
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof BusinessMessage))
            return false;
        BusinessMessage other = (BusinessMessage) obj;
        if (!Arrays.equals(this.msgArguments, other.msgArguments))
            return false;
        if (this.msgKey == null) {
            if (other.msgKey != null)
                return false;
        }
        else if (!this.msgKey.equals(other.msgKey))
            return false;
        if (this.type != other.type)
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this);
    }

    public String getLocalizedString() {

        String str = "";
        if (msgKey != null) {
            str = msgArguments == null ? MessageUtils.getMessage(msgKey) : MessageUtils
                    .getMessage(msgKey, msgArguments);
        }
        return str;
    }

}
