
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
<%@page import="javax.jms.Session"%>
<%@ page language="java"%>
<%@ page import="com.cdoe.ui.*"%>
<%@ page import="com.cdoe.biz.*"%>
<%@ page import="com.cdoe.util.*"%>
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
	UserInfo info = (UserInfo) session.getAttribute("USER_INFO");
%>
<div id="mainContent">
	<form>

		<!-- Main outer table -->

		<TABLE>
			<TR>
				<TD width="60%" />
				<TD>
					<TABLE>
						<TR>
							<TD><h2>
									<fmt:message
										key="LandingMenu.StaticText.stateEqualSystemsStaticText" />
								</h2></TD>
						</TR>
						<%
							//if (info.isStateEqualUser()) {
						%>
						<TR>
							<TD align="left"><c:url value="State Equal" var="link" />
								<a id=""
								href="${pageContext.request.contextPath}/secure/StateEqualHomePage?pageName=State&nbsp;EqualHome"><font
									color="black"><b>1. State Equal</font></b></a></TD>
						</TR>
						<TR><TD></TD></TR>
						<%
							//}
						%>
						<!--TR>
							<TD align="left"><c:url value="Transportation" var="link" />
								<a id=""
								href="${pageContext.request.contextPath}/secure/TransportationHomePage?pageName=TransportationHome"><font
									color="black"><b>2. Transportation</b></font></a></TD>
						</TR>
						<TR><TD></TD></TR-->
						<!-- if (info.isAuditSupervisorUser() || info.isAuditDistrictUser()) { %-->
						<TR>
							<TD align="left"><c:url value="Audit" var="link" /> <a
								id=""
								href="${pageContext.request.contextPath}/secure/AuditorHomePage?pageName=AuditHome"><font
									color="black"><b>2. Audit</b></font></a></TD>
						</TR>
						
						<!-- % } %-->
					</TABLE>
				</TD>
			</TR>
		</TABLE>
		</BR>
		</BR>
	</form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/LandingMenu.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>
