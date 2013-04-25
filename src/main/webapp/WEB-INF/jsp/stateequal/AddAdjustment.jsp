
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
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.cdoe.ui.*"%>
<%@ page import="com.cdoe.biz.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script language="javascript" type="text/javascript">
	$(document).ready(function() {
		/*
		 *  Attached function to dropdown's onchange event.
		 */
		$('#districtNumberList').change(function() {
			var varDistrictNumber = $('#districtNumberList option:selected').val();
			$.ajax({
				type: "GET",
				url: "${pageContext.request.contextPath}/secure/Ajax/lookup/" + varDistrictNumber,
				async:false,
				success:function(result) {
					$('#districtNameField').val(result);
				}
			});
		 });
		$('#districtNumberList2').change(function() {
			var varDistrictNumber = $('#districtNumberList2 option:selected').val();
			$.ajax({
				type: "GET",
				url: "${pageContext.request.contextPath}/secure/Ajax/lookup/" + varDistrictNumber,
				async:false,
				success:function(result) {
					$('#districtNameField2').val(result);
				}
			});
		 });
		 var auditMessage = '${auditMessage}';
		 if (auditMessage != '') {
		 	$('#saveAdjustmentMessage').val(auditMessage);
		 };
		 var otherMessage = '${otherMessage}';
		 if (otherMessage != '') {
		 	$('#saveOtherMessage').val(otherMessage);
		 };
		 var auditDistrictNumber = '${auditAdjustmentForm.districtNumber}';
		 if( auditDistrictNumber != '') {
			$.ajax({
				type: "GET",
				url: "${pageContext.request.contextPath}/secure/Ajax/lookup/" + auditDistrictNumber,
				async:false,
				success:function(result) {
					$('#districtNameField').val(result);
				}
			});
		 };
		 var otherDistrictNumber = '${otherAdjustmentForm.districtNumber}';
		 if( otherDistrictNumber != '') {
			$.ajax({
				type: "GET",
				url: "${pageContext.request.contextPath}/secure/Ajax/lookup/" + otherDistrictNumber,
				async:false,
				success:function(result) {
					$('#districtNameField2').val(result);
				}
			});
		 };
		 $('#amount1, #amount2').blur(function() {
		 	$(this).val(this.value.formatMoney());
		 });
	});
</script>
<%-- Wrap the entire JSP in a try/catch block so that runtime exceptions
    in the JSP can be caught and reported. --%>
<%@include file="/WEB-INF/jsp/JspTry.inc"%>
<div id="mainContent">
	<h3>
		<fmt:message
			key="AddAdjustment.StaticText.aEnterUpdateAuditRepaymentAdjustmentStaticText" />
	</h3>
		<!-- Main outer table -->
		<TABLE>
			<TR>
				<TD>
					<form:form commandName="auditAdjustmentForm" 
			   				   action="${pageContext.request.contextPath}/secure/AddAdjustment/saveAudit"
			   				   method="POST">
					<TABLE>
						<TR>
							<TD><fmt:message
									key="AddAdjustment.StaticText.allowsDistrictToPayBackAuditFindingByCdeWithholdingAnAdjustmentAmountFromTheirStateShareStaticText" />
							</TD>
						</TR>
					</TABLE>
					<div class="formBlock boxShadow3 radius10">
					<TABLE>
						<TR>
							
							<TD><form:hidden id="recordId" path="id" />
								<LABEL FOR=""><fmt:message
										key="AddAdjustment.StaticText.districtCodeNameStaticText" /></LABEL>
							</TD>
							<TD><form:select class="list.requiredControl" id="districtNumberList" 
								path="districtNumber" size="1">
								<form:option value="NONE" label="-- Select --" />
								<form:options items="${districtCodeNameDropdownList}" /><font color="red"><b>*</b></font>
								</form:select>
								</TD>
							<TD>District Name: <input type="text" id="districtNameField" readonly="readonly"/>
							</TD>
						</TR>
						<TR>
							<TD><LABEL FOR=""><fmt:message
										key="AddAdjustment.StaticText.beginningFiscalYearStaticText" /></LABEL>
							</TD>
							<TD><form:select class="list.requiredControl" id="fiscalYearList#start"
								path="beginFiscalYear" size="1" items="${fiscalYearDropdownList}" /><font color="red"><b>*</b></font></TD>
							<TD><LABEL FOR=""><fmt:message
										key="AddAdjustment.StaticText.endingFiscalYearStaticText" /></LABEL>
							</TD>
							<TD><form:select class="list.requiredControl" id="fiscalYearList#end"
								path="endFiscalYear" size="1" items="${fiscalYearDropdownList}" /><font color="red"><b>*</b></font></TD>
						</TR>
						<TR>
							<TD ><LABEL FOR=""><fmt:message
										key="AddAdjustment.StaticText.beginningFiscalMonthStaticText" /></LABEL>
							</TD>
							<TD><form:select class="list.requiredControl" id="monthList#start"
								path="beginFiscalMonth" size="1" items="${monthDropdownList}" /><font color="red"><b>*</b></font></TD>
							<TD ><LABEL FOR=""><fmt:message
										key="AddAdjustment.StaticText.endingFiscalMonthStaticText" /></LABEL>
							</TD>
							<TD><form:select class="list.requiredControl" id="monthList#end"
								path="endFiscalMonth" size="1" items="${monthDropdownList}" /><font color="red"><b>*</b></font></TD>
						</TR>
						<TR>
							<TD><LABEL FOR=""><fmt:message
										key="AddAdjustment.StaticText.frequencyStaticText" /></LABEL></TD>
							<TD><form:select class="list.requiredControl" id="frequencyList"
								path="frequency" size="1" items="${frequencyList}" /><font color="red"><b>*</b></font></TD>
						</TR>
						<TR>
							<TD><fmt:message
									key="AddAdjustment.StaticText.typeStaticText" /></TD>
							<TD>Audit</TD>
						</TR>
						<TR>
							<TD><LABEL FOR=""><fmt:message
										key="AddAdjustment.StaticText.amountStaticText" /></LABEL></TD>
							<TD>$<form:input cssClass="input.requiredControl" path="amount" id="amount1"
								  onBlur="checkAndFormatAmount('amount1')" /> <form:errors path="amount" cssClass="validationError"/><font color="red"><b>*</b></font>
							</TD>
						</TR>
					</TABLE>
					</div>
					<TABLE>
						<TR>
							 <TD><input type="submit" id="saveAdjustmentButton"
								value="<fmt:message key="AddAdjustment.Button.saveAdjustmentButton" />" />
							</TD>							
							<td><font color="red"><input type="text" id="saveAdjustmentMessage" readonly="readonly" size="140"/></font>
							</td>
						</TR>
					</TABLE>
					</form:form>
					
				 	<form:form commandName="otherAdjustmentForm" 
			   				   action="${pageContext.request.contextPath}/secure/AddAdjustment/saveOther"
			   				   method="POST"
			   		>
					<h3><fmt:message
									key="AddAdjustment.StaticText.bEnterUpdateOtherStateShareAdjustmentsNonCdeAuditFindingsStaticText" /></h3>
				
					<div class="formBlock boxShadow3 radius10">
						<TABLE>
							<TR>
								<td>
									<table>
										<TR>

											<TD><LABEL FOR=""><fmt:message
														key="AddAdjustment.StaticText.districtCodeNameStaticText_2" /></LABEL>
											</TD>
											<TD><form:select class="list.requiredControl"
													id="districtNumberList2" path="districtNumber" size="1">
													<form:option value="NONE" label="-- Select --" />
													<form:options items="${districtCodeNameDropdownList}" /><font color="red"><b>*</b></font>
													</form:select></TD>

										</TR>
										<TR>
											<TD><LABEL FOR=""><fmt:message
														key="AddAdjustment.StaticText.fiscalYearStaticText" /></LABEL></TD>
											<TD><form:select class="list.requiredControl"
													id="fiscalYearList" path="fiscalYear" size="1"
													items="${fiscalYearDropdownList}" /><font color="red"><b>*</b></font></TD>
										</TR>
										<TR>
											<TD><LABEL FOR=""><fmt:message
														key="AddAdjustment.StaticText.monthStaticText" /></LABEL></TD>
											<TD><form:select class="list.requiredControl"
													id="monthList" path="month" size="1"
													items="${monthDropdownList}" /><font color="red"><b>*</b></font></TD>

										</TR>
										<TR>
											<TD><LABEL FOR=""><fmt:message
														key="AddAdjustment.StaticText.typeStaticText_2" /></LABEL></TD>
											<TD><form:select class="list.requiredControl"
													id="adjustmentsList" path="adjustmentType" size="1"
													items="${adjustmentsList}" /><font color="red"><b>*</b></font></TD>
											<TD></TD>
										</TR>
										<TR>
											<TD><LABEL FOR=""><fmt:message
														key="AddAdjustment.StaticText.amountStaticText_2" /></LABEL></TD>
											<TD>$<form:input cssClass="input.requiredControl"
													path="amount" id="input#2" onBlur="checkAndFormatAmount('input#2')"/><font color="red"><b>*</b></font></TD>
											<TD></TD>
										</TR>
									</table>
								</td>
								<TD>
									<TABLE>
										<tr>
											<TD>District Name: <input type="text" id="districtNameField2" readonly="readonly"/>
										</tr>
										<TR />
										<tr>
											<TD><LABEL FOR=""><fmt:message
														key="AddAdjustment.StaticText.adjustmentNotesIEReasonStaticText" /></LABEL>
											</TD>
										</tr>
										<TR>
											<TD><form:textarea id="" path="adjustmentNotes"
													cols="60" rows="6" /></TD>
										</TR>
									</TABLE>
								</TD>
							</TR>
						</TABLE>
					</div>
					<TABLE>
						<TR>
							<TD><input type="submit" id=""
								value="<fmt:message key="AddAdjustment.Button.saveAdjustmentButton_2" />" />
							</TD>
							
								<td><span><font color="red"><input type="text" id="saveOtherMessage" readonly="readonly" size="140"/></font></span>	</td>
												
						</TR>
					</TABLE>
					</form:form>
				</TD>
			</TR>
		</TABLE>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/AddAdjustment.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>