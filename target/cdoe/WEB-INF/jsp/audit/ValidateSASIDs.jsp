
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
<form:form commandName="auditSasidExceptionForm"
	action="${pageContext.request.contextPath}/secure/SEExceptionStep3Upload/save"
	method="post">
	<input type="hidden" name="rowKey" id="rowKey" />


	<!-- Main outer table -->
	<h3>State Equal Exceptions: Validate SASIDS (Step 3)</h3>
	
	<TABLE CLASS="ContentTable" width="100%">
		<TR>
			<TD>
				<TABLE>
					<TR>
						<TD ALIGN="right"><LABEL FOR="">Fiscal Year</LABEL></TD>
						<TD><form:input id="" path="" value="2011-2012" />
						<TD ALIGN="right"><LABEL FOR="">District Code</LABEL></TD>
						<TD><form:input id="" path="" value="3120"/>
						<TD ALIGN="right"><LABEL FOR="">District Name</LABEL></TD>
						<TD><form:input id="" path="" value="Broomfield"/>
					</TR>
				</table>
			</TD>
		</TR>
		<TR></TR>
		<TR></TR>
		<TR>
			<TD COLSPAN="6">
				<div id="auditSasidExceptionGrid" align="center"
					style="border: 5px groove #ccc;">
					<table id="auditSasidExceptionGrid" class="display">
						<thead>
							<tr>
								<th>Org Type</th>
								<th>Org Code</th>
								
								<th>Last Name</th>

								<th>First Name</th>

								<th>Middle Name</th>
								
								<th>School</th>

								<th>Grade</th>


								<th>Funding</th>

								<th>Free Lunch</th>

								<th>Comments</th>


							</tr>
						</thead>
						<tbody>
							<tr>
								<td>3120</td>
								<td>450024</td>
								<td>Spencer</td>
								<td>John</td>
								<td>Herberg</td>
								<td>Ace Academy</td>
								<td>6th</td>
								<td>Yes</td>
								<td>Regular</td>
								<td>None</td>

							</tr>
							<tr>
								<td>3120</td>
								<td>450024</td>
								<td>Robinson</td>
								<td>Danielle</td>
								<td>Herberg</td>
								<td>Star Academy</td>
								<td>7th</td>
								<td>Yes</td>
								<td>Regular</td>
								<td>None</td>

							</tr>
							<tr>
								<td>3120</td>
								<td>450024</td>
								<td>Spencer</td>
								<td>John</td>
								<td>Herberg</td>
								<td>Ace Academy</td>
								<td>6th</td>
								<td>Yes</td>
								<td>Regular</td>
								<td>None</td>

							</tr>
							
							<!--c:forEach-->
						</tbody>
					</table>
					<script type="text/javascript">
						$(document).ready(function() {
							$("table#auditSasidExceptionGrid").dataTable({
								"bPaginate" : true,
								"bSort" : true,
								"bFilter" : false,
								"bInfo" : true,
								"bLengthChange" : false,
								"bAutoWidth" : true
							});
						});
					</script>
				</div>
			</TD>
		</TR>
	</TABLE>
	<TABLE>
		<TR>
		    <TD WIDTH="50%"/>
			<TD><input type="button" id=""
				value="Add Selected Student Records to list" onclick="parent.location='${pageContext.request.contextPath}/secure/AuditTrackingAuditor'"/></TD>
		</TR>
	</TABLE>
	</TD>
	</TR>
	</TABLE>
</form:form>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/SEExceptionStep3Upload.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>