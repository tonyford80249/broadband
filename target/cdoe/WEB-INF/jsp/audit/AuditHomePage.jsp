
<%--
(ref: jsp/jsp.jsp.et.jsp)
-------------------------------------
$Revision:   $
$Date:  $
$Author:   Sandeep Sarkar (not created by Engineer)
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
<div id="mainContent">
	<form>

		<!-- Main outer table -->
		<TABLE width="100%">
			<TR>

				<TD>
					<TABLE>
						<TR>
							<TD width="63%" />
							<TD align="left"><h2>Audit Home</h2></TD>
						</TR>
						<TR>
							<TD width="63%" />
							<TD align="left"><a id=""
								href="${pageContext.request.contextPath}/secure/DistrictInformation"><font
									color="black"><b>1. Organization Information</b></font></a></TD>
						</TR>
						<TR><TD></TD></TR>
						<TR>
							<TD width="63%" />
							<TD/>
							<a id=""
								href="${pageContext.request.contextPath}/secure/AuditTracking"><font
								color="black"><b>2. Audit Tracking</b></font></a>
							</TD>
						</TR>
						<TR><TD></TD></TR>
						<TR>
							<TD width="30%" />
							<TD><a id=""
								href="${pageContext.request.contextPath}/secure/AuditTrackingDistrict"><font
									color="black"><b>3. Audit History</b></font><b></a></TD>
						</TR>
						<TR><TD></TD></TR>
						<TR>
							<TD width="30%" />
							<TD><a id=""
								href="${pageContext.request.contextPath}/secure/AuditReports"><font
									color="black"><b>4. Reports</b></a></TD>
						</TR>
						
						<TR>
							<TD width="30%" />
							<TD><a id=""
								href="${pageContext.request.contextPath}/secure/AuditReports"><font
									color="black"><b>5. Data Administration</b></a></TD>
						</TR>
						
					</TABLE>
				</TD>
			</TR>
		</TABLE>
		</BR>
		</BR>
	</form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/TransMenu.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>