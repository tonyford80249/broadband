
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
<script language="javascript" type="text/javascript">
$(document).ready(function() {
		/*
		 *  Attached function to dropdown's onchange event.
		 */
		$('#auditId').blur(function() {
			var varAuditId = $('#auditId').val();
                        
                        var result = parseInt(varAuditId);
                        
                        if (result) {
                        
			 $.ajax({
				type: "GET",
				url: "${pageContext.request.contextPath}/secure/Ajax/lookupAudit/" + varAuditId,
				async:false,
				success:function(result) {                                  
				 $('#orgCodeField').val(result);                                  
				}
			 });
                        }
                         else {
                          $('#orgCodeField').val("N/A");
                         }
		 });
	});
</script>
<div id="mainContent">
	<h3>
		<spring:message
			code="ImportAudits.StaticText.importPriorYearAuditedPupilAndLunchCountsStaticText" />
	</h3>
               
		<!-- Main outer table -->
		<table>
			<tr>
				<td>
					<table>
                                             <form:form commandName="importAuditsForm"
		action="${pageContext.request.contextPath}/secure/ImportAudits/upload"
		method="post">
						<tr>
							<td><b>Upload Audits</b></td>
						</tr>
						<tr>
						<td>
	
						<div id="auditEqualGrid" align="center"
							style="margin : 50px;border: 5px groove #ccc;">
                                                    
                                                      <div style="height: 375px; width: 600px; overflow: auto;">
							<table id="auditEqualGrid" class="display">
								<thead>
									<tr>
                                                                                <th>Audit ID</th>
										<th>Organization Code</th>
										<th>Organization Name</th>
										<th>Date Available As Of</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="importAuditsRow"
										items="${importAuditsForm.importAuditsGrid}">
										<tr>                                                                                        
                                                                                        <td><c:out value="${importAuditsRow.auditId}"/></td>
											<td><c:out value="${importAuditsRow.organizationCode}"/></td>
											<td><c:out value="${importAuditsRow.organizationName}"/></td>
											<td><c:out value="${importAuditsRow.completedDate}"/></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
                                                      </div>    
							<script type="text/javascript">
							<!--
								$(document).ready(function() {
									$("table#auditEqualGrid").dataTable({
										"bPaginate" : false,
										"bSort" : true,
										"bFilter" : false,
										"bInfo" : false,
										"bLengthChange" : false,
										"bAutoWidth" : false
									});
								});
							//-->
							</script>
						</div>

						</td>
						</tr>
					   <tr>
					      <td><input type="submit" id="uploadAuditButton" value="Upload"/>
					      </td>
					   </tr>
                                            </form:form>
					</table>
                                   
					</td>
				<td valign="top">
	<form:form commandName="resetAuditsForm"
		action="${pageContext.request.contextPath}/secure/ImportAudits/reset"
		method="post">
				    <div class="formBlock boxShadow3 radius10">
                                        
					<table>
						<tr align="left">
							<td colspan="2" align="center"><b>Reset Audits</b></td>
						</tr>
						<tr>
							<td><b>Audit ID:</b></td>
							<td><form:input path="resetAuditId" id="auditId"/></td>
						</tr>
						<tr>
							<td align="left"><b>Organization Code:</b></td>
							<TD><form:input class="input.requiredControl" id="orgCodeField" readonly="true"
								path="resetOrganizationCode" /></TD>
						</tr>
						<tr>
							<td colspan="2" align="center"><b><input type="submit"
								value="Reset" /></b></td>
						</tr>
					</table>
                                         
					</div>
					</form:form>
				</td>
			</tr>
			<TR>
				<TD><spring:message
						code="ImportAudits.StaticText.noteAuditsShouldNotShowOnceUploadedStaticText" />
				</TD>
			</TR>
		</TABLE>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/ImportAudits.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>