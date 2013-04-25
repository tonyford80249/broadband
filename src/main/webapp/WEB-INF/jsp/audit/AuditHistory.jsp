
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

<style>
.scrollableArea { 
	width: 1130px;
	height:  420px;
	padding: 10px;
	border-style: solid;
	border-width: 1;
	overflow: auto;
}
</style>
<div id="mainContent">
	<form:form commandName="auditFpcForm"
		action="${pageContext.request.contextPath}/secure/AudTracking/save"
		method="post">


		<!-- Main outer table -->
		<h2>
			Audit Tracking History
		</h2>
		
		<TABLE width="100%">
			<TR>
				<TD>
				     <div class="formBlock boxShadow3 radius10">
					<TABLE>

						<TR>
							<TD>
							<select
								name="status">
								<option>Choose Audit</option>
							</select>
							</TD>
							<td>
							<input type="Submit" value="Retrieve Audit History"/>
							</TD>
						</TR>
					</TABLE>
					</div>
				
				   <TABLE width="100%">
						<TR>
							<TD>
								<div id="auditTrackingGrid" align="center"
									style="border: 5px groove #ccc;"
									class="scrollableArea boxShadow3 radius10">
									<table id="auditTrackingGrid" class="display">
										<thead>
											<tr>
												<th width="4%">Type</th>
												<th width="4%">Code</th>

												<th width="16%">Name</th>

												<th width="6%">Status</th>

												<th width="6%">Status Date</th>

												<th width="12%">Lead Auditor</th>

												<th width="12%">Support Auditor</th>

												<th width="16%">Progress</th>

												<th width="6%">Audit Frequency</th>

												<th width="16%">Most Recent Year Audited</th>

												<th width="12%">Alert</th>

												<th width="6%">Total Audit Liability</th>

											</tr>
										</thead>

										<tbody>

											<!-- c:forEach var="capitalOutlayGrid"
												items="${auditFpcForm.noNameGridList}"
												varStatus="idx" -->


											<tr>
												<td width="6%">District</td>
												<td width="6%">1137</td>

												<td width="16%"><a href="${pageContext.request.contextPath}/secure/AudSumUpdate">Academy 20</a></td>

												<td width="4%">Open</td>

												<td width="6%">09/22/2012</td>

												<td width="16%">Scott Abbey</td>

												<td width="16%">Rebecca McRee</td>

												<td width="16%">Draft report Issued</td>

												<td width="6%">2 years</td>


												<td width="6%">20112012</td>

												<td width="16%">Draft report Issued</td>
												<td width="6%">21000</td>


											</tr>
											<tr>
											
											<td width="6%">District</td>
											<td width="6%">1137</td>

											<td width="16%"><a href="${pageContext.request.contextPath}/secure/AudSumUpdate">Academy 20</a></td>

											<td width="4%">Closed</td>

											<td width="6%">09/22/2011</td>

											<td width="16%">Scott Abbey</td>

											<td width="16%">Rebecca Sony</td>

											<td width="16%">Draft report Issued</td>

											<td width="6%">2 years</td>

											
											<td width="6%">20102011</td>
											
											<td width="16%">Draft report Pending</td>

											<td width="16%">26,264</td>


											</tr>
											<tr>
											    <td> District </td>
												<td width="6%">1307</td>

												<td width="16%"><a href="${pageContext.request.contextPath}/secure/AudSumUpdate">Academy 20</a></td>

												<td width="4%">Closed</td>

												<td width="6%">01/22/2012</td>

												<td width="16%">Scott Abbey</td>

												<td width="16%">Rebecca McRee</td>

												<td width="16%">Data Migration Issued</td>

												<td width="6%">1 years</td>

											
												<td width="6%">20112012</td>
												
												<td width="16%">Draft report Rejected</td>

												<td width="16%">23,214</td>


											</tr>
										

											<!-- /c:forEach -->
										</tbody>
									</table>

									<script type="text/javascript">
									<!--
										$(document)
												.ready(
														function() {
															$(
																	"table#auditTrackingGrid")
																	.dataTable(
																			{
																				"bPaginate" : false,
																				"bSort" : true,
																				"bFilter" : true,
																				"bInfo" : true,
																				"bLengthChange" : true,
																				"bAutoWidth" : true
																			});
														});
									//-->
									</script>

								</div>

							</TD>
						</TR>
					</TABLE>
					<TABLE>
						<TR>
							<TD width="30%" />
							<TD><input type="button" id="" value="Create Audit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" 
																onclick="parent.location='${pageContext.request.contextPath}/secure/CreateAudit'"/></TD>
							<TD><input type="button" id=""
								value="Generate Audit Report in Excel" /></TD>
							<TD><input type="button" id=""
								value="Generate Audit Report in PDF" /></TD>
						</TR>
					</TABLE>
				</TD>
			</TR>
		</TABLE>
	</form:form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/AudTracking.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>