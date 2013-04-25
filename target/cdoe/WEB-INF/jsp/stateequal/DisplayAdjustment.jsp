
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

<script language="javascript" type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#DistrictNumber')
								.change(
										function() {
											var varDistrictNumber = $(
													'#DistrictNumber option:selected')
													.val();
											$
													.ajax({
														type : "GET",
														url : "${pageContext.request.contextPath}/secure/Ajax/lookup/"
																+ varDistrictNumber,
														async : false,
														success : function(
																result) {
															$('#DistrictName')
																	.val(result);
														}
													});
										});
						var message = '${message}';
						if (message != '') {
							$('#messageCell').val(message);
						}
					});
</script>
<%-- Wrap the entire JSP in a try/catch block so that runtime exceptions
    in the JSP can be caught and reported. --%>
<%@include file="/WEB-INF/jsp/JspTry.inc"%>
<div>
	<form:form commandName="displayAdjustmentForm"
		action="${pageContext.request.contextPath}/secure/DisplayAdjustment/save"
		method="post">
		<!-- Main outer table -->
		<h3>
			View Adjustments
		</h3>
		<div class="formBlock boxShadow3 radius10"  width="60%">
			<TABLE width="66%">
				<TR>

					<TD colspan="2">District Code:</TD>
					<TD><form:select id="DistrictNumber" path="districtCode" size="1" >
							<form:option value="NONE" label="-- Select --" />
							<form:options items="${districtCodeNameDropdownList}" /><font color="red"><b>*</b></font>
						</form:select><font color="red"><b>*</b></font>
					</TD>
					<TD>District Name:</TD>
					<TD colspan="1"><form:input id="DistrictName" type="text" readonly="true" size="40"
							path="districtName" /></TD>
				</TR>
				<TR>
					<TD colspan="2"><LABEL FOR=""><fmt:message
								key="DisplayAdjustment.StaticText.fiscalMonthStaticText" /></LABEL></TD>
					<TD><form:select id="fiscalMonthList" path="fiscalMonth"
							items="${fiscalMonthList}" size="1" /><font color="red"><b>*</b></font></TD>
					<TD><LABEL FOR=""><fmt:message
								key="DisplayAdjustment.StaticText.fiscalYearStaticText" /></LABEL></TD>
					<TD><form:select id="fiscalYearList" path="fiscalYear"
							items="${fiscalYearList}" size="1" /><font color="red"><b>*</b></font></TD>
				</TR>
				<TR>
					<TD colspan="2"><LABEL FOR=""><fmt:message
								key="DisplayAdjustment.StaticText.typeStaticText" /></LABEL></TD>
					<TD><form:select id="adjustmentTypeList" path="adjustmentType"
							items="${adjustmentTypeList}" size="1" /><font color="red"><b>*</b></font></TD>
				</TR>


				<TR>
					<TD />
					<TD><input type="submit"
						value="<fmt:message key="DisplayAdjustment.Button.searchButton" />" />
					</TD>
					<TD colspan="4">
						<input type="text" id="messageCell" readonly="readonly" size="140"/>
					</TD>
				</TR>
			</TABLE>
		</div>
		<table>
			<TR>
				<TD COLSPAN="6">
					<div id="displayAdjustmentGrid" align="center">
						<!-- class="formBlock boxShadow3 radius10"-->
						<table id="displayAdjustmentGrid" class="display">
							<thead>
								<tr>
									<th>District Code</th>
									<th>District Name</th>
									<th>Adjustment</th>
									<th>Frequency</th>
									<th>Begin Month/Year</th>
									<th>End Month/Year</th>
									<th>Amount</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="displayAdjustmentGrid"
									items="${displayAdjustmentForm.displayAdjustmentGridList}">
									<tr>
										<td><c:if
												test="${displayAdjustmentGrid.adjustmentType != 'AUDIT'}">
												<a
													href="${pageContext.request.contextPath}/secure/AddAdjustment/otherAdjustment/${displayAdjustmentGrid.adjustmentType}/${displayAdjustmentGrid.id}">
													<c:out value="${displayAdjustmentGrid.districtCode}" />
												</a>
											</c:if> <c:if
												test="${displayAdjustmentGrid.adjustmentType == 'AUDIT'}">
												<a
													href="${pageContext.request.contextPath}/secure/AddAdjustment/auditAdjustment/${displayAdjustmentGrid.id}">
													<c:out value="${displayAdjustmentGrid.districtCode}" />
												</a>
											</c:if></td>
										<td align="left"><c:out value="${displayAdjustmentGrid.districtName}" /></td>
										<td align="left"><c:out
												value="${displayAdjustmentGrid.adjustmentType}" /></td>
										<td align="left" ><c:out value="${displayAdjustmentGrid.frequency}" /></td>
										<td align="left"><c:out
												value="${displayAdjustmentGrid.beginFiscalYearMonth}" /></td>
										<td align="left"><c:out
												value="${displayAdjustmentGrid.endFiscalYearMonth}" /></td>
										<td align="right"><fmt:formatNumber type="number"
												pattern="$###,###,##0.00"
												value="${displayAdjustmentGrid.amount}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<script type="text/javascript">
						<!--
							$(document).ready(function() {
								$("table#displayAdjustmentGrid").dataTable({
									"bPaginate" : false,
									"bSort" : true,
									"bFilter" : true,
									"bInfo" : false,
									"bLengthChange" : false,
									"bAutoWidth" : false,
								});
							});
						//-->
						</script>
					</div>
				</TD>
			</TR>
		</TABLE>
</form:form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/DisplayAdjustment.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>