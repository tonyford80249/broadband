
<%--
(ref: jsp/jsp.jsp.et.jsp)
-------------------------------------
$Revision:   $
$Date:  $
$Author:   $
$Modtime: $

Version History:
-------------------------------------
$Log:$
--%>
<%@ page language="java"%>
<%@ page import="com.cdoe.ui.*"%>
<%@ page import="com.cdoe.biz.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%-- Wrap the entire JSP in a try/catch block so that runtime exceptions
    in the JSP can be caught and reported. --%>
<%@include file="/WEB-INF/jsp/JspTry.inc"%>

<%
	session.setAttribute("moduleName", null);
%>
<div id="menuContent">
	<form:form commandName="vHeaderForm"
		action="${pageContext.request.contextPath}/secure/SSOLogin/save"
		method="post">

		<!-- Main outer table -->
		<TABLE>
			<TR>
				<TD>


					<TABLE>

						<TR>
							<TD>
								<h3>
									<a id="" href="http://www.cde.state.co.us/">CDE Home</a>
								</h3>
							</TD>
							<TD>
								<h3>
									<a id="" href="http://www.cde.state.co.us/index_educator.asp">For
										Educators</a>
								</h3>
							</TD>
							<TD><c:url
									value="http://www.cde.state.co.us/index_Administrator.asp"
									var="link" />
								<h3>
									<a id=""
										href="http://www.cde.state.co.us/index_parentstudent.htm">For
										Administrators</a>
								</h3></TD>
							<TD><c:url
									value="${pageContext.request.contextPath}/For Parents and Students"
									var="link" />
								<h3>
									<a id=""
										href="http://www.cde.state.co.us/index_parentstudent.htm">For
										Parents and Students</a>
								</h3></TD>
						</TR>

					</TABLE>
					<TABLE>
						<TR>
							<TD><c:url
									value="${pageContext.request.contextPath}/For CDE Access Management>"
									var="link" /> <a id="" href="${link}">For CDE Access
									Management></a></TD>
						</TR>
					</TABLE>
					<TABLE>

						<TR>
							<TD>
								<h3>
									<spring:message
										code="SSOLogin.StaticText.coloradoDepartmentOfEducationSingleSignOnStaticText" />
								</h3>
							</TD>
						</TR>

						<TR>
							<TD><LABEL FOR=""><spring:message
										code="SSOLogin.StaticText.userNameStaticText" /></LABEL></TD>
						</TR>
						<TR>
							<TD><form:input id="" path="vUsername" size="25"
									maxlength="40" /></TD>
						</TR>
						<TR>
							<TD><LABEL FOR=""><spring:message
										code="SSOLogin.StaticText.passwordStaticText" /></LABEL></TD>
						</TR>
						<TR>
							<TD><form:password path="password" size="20" maxlength="40" />
							</TD>
						</TR>
						<TR>
							<TD><input type="submit" id=""
								value="<spring:message code="SSOLogin.Button.loginButton" />" />
							</TD>
						</TR>
						<TR>
							<TD><c:url
									value="${pageContext.request.contextPath}/I forgot my password"
									var="link" /> <a id="" href="${link}">I forgot my password</a>
							</TD>
						</TR>
					</TABLE>
					<TABLE>
						<TR>
							<TD width="71%">WARNING: This computer system may be
								accessed only by authorized personnel and used only for official
								state business. Unauthorized access or use of this computer
								system may subject violators to criminal, civil, and/or
								administrative action. Inappropriate use may subject violators
								to criminal, civil, and/or administrative action. All use
								subject to monitoring.</TD>
						</TR>
						<TR>
							<TD><spring:message
									code="SSOLogin.StaticText.anyQuestionsOrCommentsOnTheOrganizationOrOperationOfThisSiteStaticText" />
							</TD>
							<TD><c:url
									value="${pageContext.request.contextPath}/Please contact the CDE Identity Manager."
									var="link" /> <a id="" href="${link}">Please contact the
									CDE Identity Manager.</a></TD>
						</TR>
					</TABLE>
				</TD>
			</TR>
		</TABLE>
	</form:form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/SSOLogin.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>