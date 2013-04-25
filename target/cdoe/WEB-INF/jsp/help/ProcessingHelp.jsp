
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
<script language="javascript" type="text/javascript">
	$(document).ready(function() {
		/*
		 *  Attached function to dropdown's onchange event.
		 */
		$('#districtCodeList').change(function() {
			var varDistrictNumber = $('#districtCodeList option:selected').val();
			$.ajax({
				type: "GET",
				url: "${pageContext.request.contextPath}/secure/Ajax/lookup/" + varDistrictNumber,
				async:false,
				success:function(result) {
					$('#districtNameField').val(result);
				}
			});
		 });
		});
</script>
<div>
	<form:form commandName="helpInfoForm"
		action="${pageContext.request.contextPath}/secure/HelpInfo/save"
		method="post">

		<!-- Main outer table -->
		<h3>
			Enter Comments
		</h3>
		<TABLE CLASS="ContentTable">
		   
			<TR>
			    
				<TD>
				    <font color="red"><c:out id="Message" value="${helpInfoForm.errorMessage}"/></font>
					<div class="formBlock boxShadow3 radius10">
					<TABLE>
						<TR>
							<TD><fmt:message
									key="Comments.StaticText.cdeCommentsStaticText" /></TD>
							<TD><form:textarea id="" path="note" cols="100"
									rows="6"></form:textarea></TD>
						</TR>
					</TABLE>
					<TABLE>
						<TR>
						    <TD width="40%" />
							<TD width="100%" align="center"><input type="Submit" id="addComments" value="ADD Comments" /></TD>
						</TR>
					</TABLE>
					<h3>Display Comments</h3>
					<div id="uploadNotesGrid" align="center"
						class=" scrollableArea formBlock boxShadow3 radius10">
						<table id="uploadNotesTable" class="display">
							<thead>
								<tr>
								    <th  width="6%">Note Id</th>
								    <th  width="6%">District Code</th>
								    <th  width="12%">Fiscal Year/Month</th>
									<th  width="16%">Create Date</th>
									<th  width="10%">Created By</th>
									<th>Comment</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="notesGrid"
									items="${helpInfoForm.commentInfoGrid}">
									<tr>
									    <td width="6%" align="left"><c:out value="${notesGrid.noteId}" /></td>
									    <td width="6%" align="left"><c:out value="${notesGrid.districtCode}" /></td>
									     <td width="12%" align="left"><c:out value="${notesGrid.fiscalYear}" />/<c:out value="${notesGrid.fiscalMonth}" /></td>
										<td width="16%" align="left"><c:out value="${notesGrid.enteredDate}" /></td>
										<td width="10%" align="left"><c:out value="${notesGrid.enteredBy}" /></td>
										<td align="left"><c:out value="${notesGrid.note}" /></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
						<script type="text/javascript">
							$(document).ready(function() {
								$("table#uploadNotesTable").dataTable({
									"bPaginate" : false,
									"bSort" : true,
									"sScrollY" : 200,
									"sScrollX" : 1120,
									"bFilter" : true,
									"bInfo" : true,
									"bLengthChange" : false,
									"bAutoWidth" : false
								});
							});
						</script>
					</div>
				</TD>
			</TR>
		</TABLE>
	</form:form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/Comments.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>