<%
} catch (Throwable e) {
    org.apache.log4j.Logger APP_LOG =
        org.apache.log4j.Logger.getLogger(getClass());
	APP_LOG.error(org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e));
	throw new JspException(e);
}
%>