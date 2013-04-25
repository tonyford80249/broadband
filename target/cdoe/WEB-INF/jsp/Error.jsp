<%@ page language="java" isErrorPage="true"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="org.apache.commons.lang.exception.ExceptionUtils"%>
<%
	Logger logger = Logger.getLogger(getClass());
    if (exception != null) {        
        logger.error(ExceptionUtils.getFullStackTrace(exception));
    }
%>

<TABLE WIDTH="600" ALIGN="center">

	<SPAN CLASS="sectiontext"> A hardware configuration problem or
	software error has occurred, causing this page to be displayed. There
	are many things that can cause an error of this type, such as network
	failures, unexpected reconfigurations, and operating system or machine
	issues, as well as software "bugs". Additional details have been logged
	for technical support to review. Please send an e-mail to <A
		HREF="mailto:tbragg@resqsoft.com?subject=Content Error Condition"
		NAME="ResQSoft Technical Support"> Technical Support </A> noting the
	page name and any details about the sequence of events leading up to
	this error that you feel might be helpful in reproducing and diagnosing
	the problem.
	<P>We are sorry for any inconvenience this may have caused.</P>
	</SPAN>
</TABLE>

