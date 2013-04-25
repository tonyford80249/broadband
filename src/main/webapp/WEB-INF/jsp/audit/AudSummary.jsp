
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
<div id="mainContent">
	<form:form commandName="auditEqualForm"
		action="${pageContext.request.contextPath}/secure/AudSumUpdate/save"
		method="post">

		<!-- Main outer table -->
		<h2>
			<spring:message
				code="AudSumUpdate.StaticText.auditSummaryUpdateStaticText" />
		</h2>
		<h3>
			Audit Organization Information
		</h3>
		<TABLE>
			<TR>

				<TD>

					<TABLE>


						<TR>
							<TD><LABEL FOR=""><spring:message
										code="AudSumUpdate.StaticText.auditIdStaticText" /></LABEL></TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<TR>
							<TD><LABEL FOR="">Organization Type</TD>
							<TD><form:input id="" path="" /></TD>
						</TR>
						<TR>
							<TD><LABEL FOR="">Organization Number</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<TR>
							<TD><LABEL FOR="">Organization Name</TD>
							<TD><form:input id="" path="" /> <form:errors path="" /></td>
						</tr>
						<TR>
							<TD><LABEL FOR=""><spring:message
										code="AudSumUpdate.StaticText.typeStaticText" /></LABEL></TD>
							<TD><form:input id="" path="" />
						<TR>
							<TD><LABEL FOR="">Lead Auditor</LABEL></TD>
							<TD><form:input id="" path="" /> <form:errors path="" /></td>
						</tr>

						<TR>
							<TD><LABEL FOR="">Support Auditor</LABEL></TD>
							<TD><form:input id="" path="" /> <form:errors path="" /></td>

						</tr>

					</table>

				</TD>
				<TD colspan="3">
					<table>
						<TR>
							<TD>Supervisor Comments</TD>
						</TR>
						<TR>
							<TD colspan="6"><form:textarea id="" path="" rows="5"
									cols="68" /></TD>
						</TR>

						<tr>

							<TD>Auditors Comments</TD>
						</tr>
						<tr>
							<TD colspan="6"><form:textarea id="" path="" rows="5"
									cols="68" /></TD>
						</tr>
					</table>
				</TD>
			</TR>
		</TABLE>
		<TABLE>
			<TR></TR>
			<TR>
				<TD COLSPAN="2"><h3>Milestone Dates</h3></TD>
				<TD COLSPAN="4"><h3>Contacts</h3></TD>
			</TR>
			<tr>
				<td>
					<TABLE>
						<TR>

							<TD>Audit Created</TD>

							<TD><form:input id="" path="" /></td>
						</tr>


						<tr>
							<TD><LABEL FOR="">Organization Engaged </TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<tr>
							<TD><LABEL FOR="">Documents Received </TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<tr>
							<TD>Field Work Started</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<tr>
							<TD>Field Work Completed</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
					</TABLE>
				</TD>
				<TD>
					<TABLE>
						<tr>
							<TD><LABEL FOR=""><spring:message
										code="AudSumUpdate.StaticText.dateDraftReportCompletedStaticText" /></LABEL>
							</TD>
							<TD><form:input id="" path="" /></td>
						</tr>

						<tr>
							<TD>Draft Report Issued</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<tr>
							<TD>Issued By</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<tr>
							<TD>Report Finalized</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<tr>
							<TD>Finalized By</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
					</TABLE>
				</TD>
				<TD>
					<table>

						<tr>
							<TD>Pupil Contact</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<tr>
							<TD>Pupil Email</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<tr>
							<TD>Pupil Phone</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<tr>
							<TD>At Risk Count</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<tr>
							<TD>At Risk Email</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<tr>
							<TD>At Risk Phone</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
					</TABLE>
				</TD>
				<TD>
					<TABLE>
						<TR>
							<TD>Transportation Contact</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<tr>
							<TD>Transportation Email</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<tr>
							<TD>Transportation Phone</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<tr>
							<TD>Superintendent Count</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<tr>
							<TD>Superintendent Email</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<tr>
							<TD>Superintendent Phone</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
					</TABLE>
				</TD>
			</TR>
		</TABLE>
		<TABLE>
			<TR>
				<TD colspan="6" WIDTH="1200px"><H3>Audit Hours</H3></TD>
			</tr>

			<tr>
				<td colspan="6">

					<table>
						<TR>

							<TD><LABEL FOR=""><spring:message
										code="AudSumUpdate.StaticText.pupilCountStaticText" /></LABEL></TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<TR>
							<TD><LABEL FOR=""><spring:message
										code="AudSumUpdate.StaticText.atRiskStaticText" /></LABEL></TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<tr>

							<TD><LABEL FOR=""><spring:message
										code="AudSumUpdate.StaticText.transportationStaticText" /></LABEL></TD>
							<TD><form:input id="" path="" /> <form:errors path="" /></td>
						</tr>

						<tr>

							<TD><LABEL FOR=""><spring:message
										code="AudSumUpdate.StaticText.elpaStaticText" /></LABEL></TD>
							<TD><form:input id="" path="" /> <form:errors path="" /></td>
						</tr>
						<tr>

							<TD><LABEL FOR="">Billing</LABEL></TD>
							<TD><form:input id="" path="" /> <form:errors path="" /></td>
						</tr>
						<tr>
							<TD colspan="2">___________________________________</TD>
						</tr>
						<tr>
							<TD>Total</TD>
							<TD><form:input id="" path="" /></TD>
						</tr>
					</table>
				</TD>
			</tr>
		</TABLE>
		<TABLE>
			<TR>
				<TD colspan="6" width="1200px"><h3>Audit Liability By Program</h3></TD>
			</TR>

			<TR>
				<TD width="1200px">
					<TABLE>
						<TR>
							<TD><h3>Programs</h3></TD>
							<TD width="22%"><h3>Fiscal Years</h3></TD>
							<TD width="20%"><h3>Organization</h3></TD>
							<TD width="10%"><h3>Audit</h3></TD>
							<TD width="18%"><h3>Difference</h3></TD>
						</TR>
						<TR>
							<TD><b>State Equal</b></TD>
						</TR>
						<TR>
							<TD />
							<TD align="rgiht">2008-2009</TD>
							<TD>3,300,000</TD>
							<TD>3,320,000</TD>
							<TD>20,000</TD>
						</TR>
						<TR>
							<TD>Transportation</TD>
						<TR>
							<TD />
							<TD align="rgiht">2008-2009</TD>
							<TD>1,300,000</TD>
							<TD>1,320,000</TD>
							<TD>20,000</TD>
						</TR>
						<TR>
							<TD>ELPA</TD>
						</TR>
						<TR>
							<TD />
							<TD align="rgiht">2008-2009</TD>
							<TD>1,300,000</TD>
							<TD>1,320,000</TD>
							<TD>20,000</TD>
						</TR>

					<!-- /TABLE>
				</TD>
			</TR>
			<TR>
				<TD width="1200px">
					<TABLE -->
						<TR>
							<TD><h3>Programs</h3></TD>
							<TD width="22%"><h3>Fiscal Years</h3></TD>
							<TD width="22%"><h3>Exception Type</h3></TD>
							<TD colspan="2"><h3>Total FTE Adjustments</h3></TD>
						</TR>
						<TR>
							<TD><b>Pupil Count</b></TD>

						</TR>
						<TR>
							<TD />
							<TD>2008-2009</TD>
							<TD/>
							<TD>Total FTE Adjustments  - 6.5</TD>
						</TR>
						<TR>
							<TD />
							<TD />
							<TD>Student did not meet the attendance criteria</TD>
						<TR>
						<TR>
							<TD />
							<TD />
							<TD>Student did not meet the general criteria</TD>
						<TR>
							<TD><b>At Risk Count</b></TD>
						</TR>
						<TR>
							<TD/>
							<TD>2008-2009</TD>
							<TD/>
							<TD>Total Count Adjustments  - 6.0</TD>
						</TR>
						<TR>
							<TD />
							<TD />
							<TD>Student did not meet the at Risk criteria</TD>
						<TR>
						<TR>
							<TD />
							<TD />
							<TD>Student did not meet the general criteria</TD>
						<TR>
					</TABLE>
				</TD>
			</TR>
		</TABLE>
		<TABLE>
			<TR>
				<TD width="33%" />
				<TD><input type="button" id="" value="Print Audit Summary" /></TD>
				<TD width="480px"><input type="button" id=""
					value="Save Changes" align="left" /></TD>
			</TR>
		</table>

		</TABLE>
	</form:form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/AudSumUpdate.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>