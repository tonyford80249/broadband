                             
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

<script type="text/javascript">
	$(document).ready(function() {
		$('#districtCodeList').change(function() {
			var varDistrictNumber = $('#districtCodeList option:selected').val();
			$.ajax({
				type: "GET",
				url: "${pageContext.request.contextPath}/secure/Ajax/lookup/" + varDistrictNumber,
				async:false,
				success:function(result) {
					$('#districtName').val(result);
				}
			});
		 });
		 if ('${uploadVariablesForm.uploadGrid}' != '') {
		 	$('#confirm').removeAttr('disabled');
		 }
		 var districtNumber = '${saveVariableForm.districtCode}';
		 if( districtNumber != '') {
			$.ajax({
				type: "GET",
				url: "${pageContext.request.contextPath}/secure/Ajax/lookup/" + districtNumber,
				async:false,
				success:function(result) {
					$('#districtName').val(result);
				}
			});
		 };
		 var savedVar = '${saved}';
		 if ( savedVar == 'upload') {
		 	$('#message1').text('The variables were successfully uploaded');
		 	$('#confirm').attr('disabled', 'disabled');
		 }
		 if ( savedVar == 'single') {
		 	$('#message2').text('Your variable was successfully saved');
		 }
		 var messageVar = '${message}';
		 if (messageVar != '') {
		 	$('#message1').text(messageVar);
		 }
		 $('#file').on('blur', function(event) {
		 	$('#display').removeAttr('disabled');
		 });
		 var valid = 'false';
		 $('#value').mouseleave(function(event) {
		 	if ($(this).val() != '') {
		 		if (isNaN($(this).val())) {
		 			$('#message3').text('Invalid number format');
		 		} else {
		 			valid = 'true';
		 		}
		 		if (valid == 'true') {
		 			$('#submit').removeAttr('disabled');
		 			$('#message3').text('');
		 		}
		 	}
		 });
	});
</script>
<%-- Wrap the entire JSP in a try/catch block so that runtime exceptions
    in the JSP can be caught and reported. --%>
<%@include file="/WEB-INF/jsp/JspTry.inc"%>
<div>

	<!-- Main outer table -->
	<h3>
		<spring:message
			code="UploadVariables.StaticText.uploadVariablesAdjustmentsStaticText" />
	</h3>
	<TABLE>
		<TR>
			<TD><form:form commandName="uploadVariablesForm"
					action="${pageContext.request.contextPath}/secure/UploadVariables/upload"
					method="post" enctype="multipart/form-data">
						<TABLE>
							<TR>
								<TD ALIGN="right"><LABEL FOR=""><spring:message
											code="UploadVariables.StaticText.selectFiscalYearStaticText" /></LABEL>
								</TD>
								<TD><form:select id="fiscalYearList" path="fiscalYear"
										items="${fiscalYearList}" /><font color="red"><b>*</b></font></TD>
								<TD ALIGN="right"><LABEL FOR=""><spring:message
											code="UploadVariables.StaticText.chooseFileToUploadStaticText" /></LABEL>
								</TD>
								<TD><form:input id="file" type="file" path="file" /><font color="red"><b>*</b></font></TD>
							</TR>
						</TABLE>
					<TABLE>
						<TR>
							<TD><input type="submit" id="display" name="display" disabled="disabled"
								value="<spring:message code="UploadVariables.Button.displayDataButton" />" />
							</TD>
							<TD><input type="submit" id="confirm" name="confirm" disabled="disabled"
								value="<spring:message code="UploadVariables.Button.confirmUploadDataButton" />" />
							</TD>
							<TD><input type="submit" id="cancel" name="cancel"
								value="<spring:message code="UploadVariables.Button.cancelButton" />" />
							</TD>
				
							<td id="message1"/>
						</TR>
					</TABLE>
					<div id="uploadVariablesGrid" align="center" class="formBlock boxShadow3 radius10">
						<table id="uploadVariablesTable" class="display">
							<thead>
								<tr>
									<c:forEach var="headerCol"
										items="${uploadVariablesForm.uploadGrid.columnHeaders}">
										<th><c:out value="${headerCol}" /></th>
									</c:forEach>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="varRow"
									items="${uploadVariablesForm.uploadGrid.rowGrid}">
									<tr>
										<td>
											<c:out value="${varRow.key}" />
										</td>
										<c:forEach var="varCol" items="${varRow.value}" varStatus="idx">
											<td align="right">
												<fmt:formatNumber type="number"
												pattern="$###,###,##0.00" value="${varCol}" />
											</td>
										</c:forEach>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<script type="text/javascript">
							$(document).ready(function() {
								$("table#uploadVariablesTable").dataTable({
									"bPaginate" : false,
									"bSort" : true,
        							"sScrollY": 200,
        							"sScrollX": 1120,
									"bFilter" : false,
									"bInfo" : false,
									"bLengthChange" : false,
									"bAutoWidth" : false
								});
							});
						</script>
					</div>
				</form:form>
				<h3>
					<spring:message
						code="UploadVariables.StaticText.enterUpdateSingleVariableStaticText" />
				</h3> <form:form commandName="saveVariableForm"
					action="${pageContext.request.contextPath}/secure/UploadVariables/save"
					method="post">
					<div class="formBlock boxShadow3 radius10">
						<TABLE>
							<TR>
								<TD><spring:message
										code="UploadVariables.StaticText.fiscalYearStaticText" /></TD>
								<TD><form:select id="FiscalYear" path="fiscalYear"
										items="${fiscalYearList}" /><font color="red"><b>*</b></font></TD>
							</TR>
							<TR>
								<TD><LABEL><spring:message
											code="UploadVariables.StaticText.districtCodeStaticText" /></LABEL></TD>
								<TD><form:select id="districtCodeList" path="districtCode"
										size="1">
										<form:option value="-- Select --"/>
										<form:options items="${districtCodeList}"/>
									</form:select><font color="red"><b>*</b></font>
								</TD>
								<TD>District Name:</TD>
								<TD><input type="text" id="districtName" readonly="readonly" /></TD>
							</TR>
							<TR>
								<TD><spring:message
										code="UploadVariables.StaticText.dataElementStaticText" /></TD>
								<TD><form:select id="DataElement" path="dataElement"
										items="${dataElementList}" /></TD>
							</TR>
							<TR>
								<TD><spring:message
										code="UploadVariables.StaticText.valueStaticText" /></TD>
								<TD><form:input id="value" path="value" size="25"
										maxlength="50"  onBlur="checkAndFormatAmount('value')"/><font color="red"><b>*</b></font>
								</TD>
								<td id="message3" />
							</TR>
						</TABLE>
					</div>
					<TABLE>
						<TR>
							<TD><input type="submit" id="submit" disabled="disabled"
								value="<spring:message code="UploadVariables.Button.saveVariableButton" />" />
							</TD>
							<TD><input type="reset" id="reset"
								value="<spring:message code="UploadVariables.Button.clearButton" />" />
							</TD>
							<td id="message2"/>
						</TR>
					</TABLE>
				</form:form></TD>
		</TR>
	</TABLE>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/UploadVariables.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>