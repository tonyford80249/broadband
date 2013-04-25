
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
	height: 320px;
	padding: 10px;
	border-style: solid;
	border-width: 1;
	overflow: auto;
}
</style>
<div id="mainContent">
	<form:form commandName="auditEqualForm"
		action="${pageContext.request.contextPath}/secure/ChangeBilling/save"
		method="post">
		<input type="hidden" name="rowKey" id="rowKey" />


		<!-- Main outer table -->
		<h3>
			<spring:message
				code="ChangeBilling.StaticText.changeBillingStaticText" />
		</h3>
		<TABLE>
			<TR>
				<TD>
					<TABLE>
						<TR>
							<TD ALIGN="right"><LABEL FOR="">Fiscal Year</LABEL></TD>
							<TD><form:input id="" path="" value="2011-2012" />
							<TD ALIGN="right"><LABEL FOR="">District Code</LABEL></TD>
							<TD><form:input id="" path="" value="3120" />
							<TD ALIGN="right"><LABEL FOR="">District Name</LABEL></TD>
							<TD><form:input id="" path="" value="Broomfield" />
						</TR>
					</table>
				</TD>
			</TR>
		</TABLE>

		<TABLE>
			<TR>
				<TD>
					<div id="auditEqualGrid" valign="top"
						style="border: 5px groove #ccc;">
						<table id="auditEqualGrid" class="scrollableArea">
							<thead>
								<tr>

									<th valign="top"width="20%">Fiscal Year</th>

									<th valign="top" width="20%">District Number</th>

									<th valign="top">Audit</th>

									<th valign="top">Difference</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="auditEqualGrid"
									items="${auditEqualForm.auditEqualGridList}" varStatus="idx">
									<tr>

										<td width="20%"><form:input size="8"
												path="auditEqualGridList[${idx.index}].fiscalYear" /> <form:errors
												path="auditEqualGridList[${idx.index}].fiscalYear" /></td>

										<td width="20%"><form:input size="34"
												path="auditEqualGridList[${idx.index}].districtNumber" /> <form:errors
												path="auditEqualGridList[${idx.index}].districtNumber" /></td>
										<td><form:input size="8"
												path="auditEqualGridList[${idx.index}].districtNumber" /> <form:errors
												path="auditEqualGridList[${idx.index}].districtNumber" /></td>
										<td><form:input size="8"
												path="auditEqualGridList[${idx.index}].districtNumber" /> <form:errors
												path="auditEqualGridList[${idx.index}].districtNumber" /></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
						<script type="text/javascript">							$(document).ready(function() {
								$("table#auditEqualGrid").dataTable({
									"bPaginate" : false,
									"bSort" : true,
									"bFilter" : true,
									"bInfo" : false,
									"bLengthChange" : false,
									"bAutoWidth" : false
								});
							});
						</script>
					</div>
				</TD>
			</TR>
		</TABLE>
		<TABLE>
			<TR>
				<TD><input type="button" id="" value="Save" /></TD>
				<TD><input type="button" id="" value="Delete" /></TD>
			</TR>
		</TABLE>
		</TD>
		</TR>
		</TABLE>
	</form:form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/ChangeBilling.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>