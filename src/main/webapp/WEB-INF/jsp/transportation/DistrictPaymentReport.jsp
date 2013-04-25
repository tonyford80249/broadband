
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
	String prevFiscalYear = DateUtil.getPrevFiscalYear();
	String formattedFiscalYear = DateUtil.getFiscalYearFormattedLong(prevFiscalYear);
%>
<style>
.scrollableArea {
	width: 1130px;
	height: 320px;
	padding: 10px;
	border-style: solid;
	border-width: 1;
	overflow: auto;
}
</style>

<div id="mainContent">
	<form:form commandName="prorateForm"
		action="${pageContext.request.contextPath}/dynamic/report/districtPayment.xls"
		method="post">
		<input type="hidden" name="rowKey" id="rowKey" />

		<input type="hidden" name="fiscalYear"
			value="${prorateForm.fiscalYear}" />


		<!-- Main outer table -->
		<h2>
			<spring:message
				code="DistrictPaymentReport.StaticText.districtPaymentReportForReimbursementYearStaticText" />
			&nbsp;<%=formattedFiscalYear%>
			<!--  form:input  id="" path="fiscalYear"   size="8" maxlength="8"/>-->
		</h2>
		<TABLE>
			<TR>
				<TD>
				    <div class="formBlock boxShadow3 radius10">
				    <font size="3">
					<TABLE>
						<TR>
							<TD ALIGN="right"><LABEL FOR="">First Distribution </LABEL>
							</TD>
							<TD><form:input id="" path="totalFirstPayment"
									readOnly="true" /></TD>
							<TD ALIGN="right"><LABEL FOR="">Second Distribution</LABEL>
							</TD>
							<TD><form:input id="" path="totalSecondPayment"
									readOnly="true" /></TD>
							<TD ALIGN="right"><LABEL FOR=""><spring:message
										code="DistrictPaymentReport.StaticText.totalDistributionStaticText" /></LABEL>
							</TD>
							<TD><form:input id="" path="totalDistribution"
									readOnly="true" /></TD>
						</TR>
						<TR>
							<TD ALIGN="right"><LABEL FOR="FirstProration">First Proration</LABEL>
							</TD>
							<TD><form:input id="FirstProration"
									path="prorateFactor1stPayment" readOnly="true" /></TD>
							<TD ALIGN="right"><LABEL FOR="SecondProration">Second Proration</LABEL>
							</TD>
							<TD><form:input id="SecondProration"
									path="prorateFactor2ndPayment" readOnly="true" /></TD>

						</TR>
						</TABLE>
						</font>
						</div>
						
						<table>
						<TR>
							<TD COLSPAN="6">
								<div id="transportationGrid" align="center"
									style="border: 5px groove #ccc;" class="boxShadow3 radius10 scrollableArea">
									<table id="transportationGrid" class="display">
										<thead>
											<tr>
												<th>District Number</th>

												<th>District Name</th>

												<th>First Payment</th>

												<th>Second Payment</th>

												<th>Total Distribution</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach var="prorateTransportationGrid"
												items="${prorateForm.prorateTransportationGridList}"
												varStatus="idx">
												<tr>

													<td><form:hidden
															path="prorateTransportationGridList[${idx.index}].districtNumber" />
														<c:out
															value="${prorateForm.prorateTransportationGridList[idx.index].districtNumber}" /></td>

													<form:hidden
														path="prorateTransportationGridList[${idx.index}].organizationName" />
													<td align="left"><c:out
															value="${prorateForm.prorateTransportationGridList[idx.index].organizationName}" /></td>

													<form:hidden
														path="prorateTransportationGridList[${idx.index}].firstPayment" />
													<td align="right"><fmt:formatNumber type="number" pattern="###,###,##0.00"
															value="${prorateForm.prorateTransportationGridList[idx.index].firstPayment}" /></td>

													<form:hidden
														path="prorateTransportationGridList[${idx.index}].secondPayment" />
													<td align="right"><fmt:formatNumber type="number" pattern="###,###,##0.00"
															value="${prorateForm.prorateTransportationGridList[idx.index].secondPayment}" /></td>

													<form:hidden
														path="prorateTransportationGridList[${idx.index}].districtDistribution" />
													<td align="right"><fmt:formatNumber type="number" pattern="###,###,##0.00"
															value="${prorateForm.prorateTransportationGridList[idx.index].districtDistribution}" /></td>

												</tr>
											</c:forEach>
										</tbody>
									</table>
									<script type="text/javascript">
									<!--
										$(document)
												.ready(
														function() {
															$(
																	"table#transportationGrid")
																	.dataTable(
																			{
																				"bPaginate" : false,
																				"bSort" : true,
																				"bFilter" : true,
																				"bInfo" : true,
																				"bLengthChange" : true,
																				"bAutoWidth" : true,
																				"iDisplayLength": 100 
																			});
														
															
														});
									//-->
									</script>
								</div>
							</TD>
						</TR>
						<TR>
							<TD COLSPAN="6" align="center"><input type="Submit" id=""
								value="Download to Excel" /></TD>
						</TR>
					</TABLE>
				</TD>
			</TR>
		</TABLE>
	</form:form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/DistrictPaymentReport.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>