
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
		action="${pageContext.request.contextPath}/secure/CreateAudit/save"
		method="post">

		<!-- Main outer table -->
		<h3>
			<spring:message code="CreateAudit.StaticText.createAuditStaticText" />
		</h3>
		<TABLE>
			<TR>
				<TD>

					<TABLE>
						<TR>
							<TD>Audit Id</TD>
							<TD>1021</TD>
						</TR>
						<TR>
							<TD>Organization Code&nbsp;&nbsp;&nbsp;&nbsp;</TD>
							<TD>1000</TD>
						</tr>
						<TR>
							<TD>Organization Type&nbsp;&nbsp;&nbsp;&nbsp;</TD>
							<TD>District</TD>
						</tr>

						<TR>
							<TD>Organization Name&nbsp;&nbsp;&nbsp;&nbsp;</TD>
							<TD><form:input id="" path="" /></td>
						</tr>
						<TR>
							<TD>Audit Type&nbsp;&nbsp;&nbsp;&nbsp;</TD>
							<TD><form:input id="" path="" />
						<TR>
							<TD>Lead Auditor&nbsp;&nbsp;&nbsp;&nbsp;</LABEL></TD>
							<TD><form:input id="" path="" /> <form:errors path="" /></td>
						</tr>

						<TR>
							<TD>Support Auditor&nbsp;&nbsp;&nbsp;&nbsp;</LABEL></TD>
							<TD><form:input id="" path="" /> <form:errors path="" /></td>

						</tr>

					</TABLE>
				</TD>
				<TD WIDTH="10%" />
				<td>
					<table>

						<TR>
							<TD COLSPAN="10"><h3>
									<spring:message
										code="CreateAudit.StaticText.selectedRangeForFiscalYearsForEachProgramAuditedStaticText" />
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</h3></TD>
						</TR>

						<TR>
							<TD COLSPAN="16"><b>State Equal</TD>
						</TR>

						<TR>
							<TD><form:radiobutton id="" path="" value="true" /></TD>
							<TD><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.naStaticText" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$1YearStaticText" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$2YearStaticText" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$3YearStaticText" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$4YearStaticText" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$5YearStaticText" /></LABEL></TD>
							<TD><span> </span></TD>

						</TR>

						<TR>
							<TD COLSPAN="16"><b><spring:message
										code="CreateAudit.StaticText.transportationStaticText" /></b></TD>
						</TR>

						<TR>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.naStaticText_2" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$1YearStaticText_2" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$2YearStaticText_2" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$3YearStaticText_2" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$4YearStaticText_2" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$5YearStaticText_2" /></LABEL></TD>
							<TD><span> </span></TD>

						</TR>

						<TR>
							<TD COLSPAN="14"><b><spring:message
										code="CreateAudit.StaticText.elpaStaticText" /></b></TD>
						</TR>

						<TR>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.naStaticText_3" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$1YearStaticText_3" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$2YearStaticText_3" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$3YearStaticText_3" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$4YearStaticText_3" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$5YearStaticText_3" /></LABEL></TD>
							<TD><span> </span></TD>
							<TD></TD>
						</TR>

						<TR>
							<TD COLSPAN="14"><b><LABEL FOR=""><spring:message
											code="CreateAudit.StaticText.billingStaticText" /></b></LABEL></TD>
						</TR>

						<TR>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.naStaticText_4" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$1YearStaticText_4" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$2YearStaticText_4" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$3YearStaticText_4" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$4YearStaticText_4" /></LABEL></TD>
							<TD><form:radiobutton id="" path="" value="true" /> <form:errors
									path="" /></TD>
							<TD><LABEL FOR=""><spring:message
										code="CreateAudit.StaticText.$5YearStaticText_4" /></LABEL></TD>
							<TD><span> </span></TD>
						</TR>

					</TABLE>
				</TD>
			</TR>
		</TABLE>
		<TABLE>

			<TR>
				<TD>
					<TABLE>
						<TR>
							<TD ALIGN="right"><b>Supervisor Comments</b></TD>
							<TD><form:textarea id="" path="" rows="6" cols="108" /><b></TD>
						</TR>


						<TR>
							<TD ALIGN="right"><b>Auditors Comments</TD>
							<TD><form:textarea id="" path="" rows="6" cols="108" /></TD>

						</TR>
					</TABLE>
				</TD>
			</TR>
		</TABLE>
		<TABLE>
			<TR>

				<TD COLSPAN="2"><h3>Milestone Dates</h3></TD>
				<TD COLSPAN="4"><h3>Contacts</h3></TD>

			</TR>
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

			<TR>
				<TD align="center"><input type="button" id=""
					value="Create Audit" /></TD>
			</TR>
		</TABLE>
	</form:form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/CreateAudit.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>