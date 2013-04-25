
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


<%  String prevFiscalYear = DateUtil.getPrevFiscalYear();
	String formattedFiscalYear = DateUtil.getFiscalYearFormattedLong(prevFiscalYear);
%>

<script type="text/javascript"> 	
$(document).ready(function() {
	  if ('${prorateForm.prorateFactor1stPayment}' != '') {
	      $('#totalPayment1').attr('readonly', 'readonly');
	  	  $('#runFirstPayment').attr('disabled', 'disabled');
	  } 
	  if ('${prorateForm.prorateFactor2ndPayment}' != '') {
	  	  $('#totalPayment2').attr('readonly', 'readonly');
	  	  $('#runSecondPayment').attr('disabled', 'disabled');
	  }
	  if (('${prorateForm.prorateFactor1stPayment}' != 0) && ('${prorateForm.prorateFactor2ndPayment}' != 0)) {
	  	  $('#saveChanges').attr('disabled', 'disabled');
	  }

	$('#totalPayment1, #totalPayment2').blur(function() {
		if ($(this).not('[readonly]')) {
			var thisval = parseFloat(this.value.replace(/[^0-9-.]/g, ''));
	 		if (isNaN(thisval)) {
				alert("Please enter numeric value only");
				$(this).focus();
			}
			if (thisval < 0) {
				alert("Value must be a positive number");
				$(this).focus();
			}
			if ($(this).attr('id') == 'totalPayment1') {
				$('#totalDistribution').val(thisval.formatMoney());
			}
			if ($(this).attr('id') == 'totalPayment2') {
				var totPmt = parseFloat($('#totalDistribution').val().replace(/[^0-9-.]/g, ''));
				totPmt += thisval;
				$('#totalDistribution').val(totPmt.formatMoney());
			}
			// format the numbers
			this.value = thisval.formatMoney();
		}
	});
});
</script>
<%-- Wrap the entire JSP in a try/catch block so that runtime exceptions
    in the JSP can be caught and reported. --%>
<%@include file="/WEB-INF/jsp/JspTry.inc"%>
<div id="mainContent">
	<form:form commandName="prorateForm"
		action="${pageContext.request.contextPath}/secure/DistributionAmounts/save"
		method="post">
		<form:hidden path="fiscalYear" />
		<form:hidden path="id" />
		<h2>
			<spring:message
				code="DistributionAmounts.StaticText.distributionAmountsStaticText" />
			For
			<%=formattedFiscalYear%>
		</h2>
		<!-- Main outer table -->
		<TABLE>
			<TR>
				<TD>
				   <div class="formBlock boxShadow3 radius10">
					<TABLE width="40%">
						<TR>

							<TD align="left"><LABEL FOR=""><spring:message
										code="DistributionAmounts.StaticText.firstDistributionAmountStaticText" /></LABEL>
							</TD>
							
                            <TD><form:input id="totalPayment1" path="totalFirstPayment" />
								<form:errors path="totalFirstPayment" cssClass="validationError" />
							</TD>
						</TR>
						<TR>

							<TD align="left"><spring:message
									code="DistributionAmounts.StaticText.$1StProrationFactorStaticText" />
							</TD>
							<TD><form:input id="prorateFactor1stPayment"
									path="prorateFactor1stPayment" readOnly="true" /></TD>
						</TR>
						<TR>
							<TD align="left"><LABEL FOR=""><spring:message
										code="DistributionAmounts.StaticText.$2NdDistributionAmountStaticText" /></LABEL>
							</TD>
							
							
							<TD>
							   <form:input id="totalPayment2" path="totalSecondPayment"/>
							   <form:errors path="totalSecondPayment" cssClass="validationError" />
							</TD>
						</TR>
						<TR>
							<TD align="left"><spring:message
									code="DistributionAmounts.StaticText.$2NdProrationFactorStaticText" />
							</TD>
							<TD><form:input id="prorateFactor2ndPayment" path="prorateFactor2ndPayment"
									readOnly="true" /></TD>
						</TR>
						<TR>
							<TD align="left"><spring:message
									code="DistributionAmounts.StaticText.totalDistributionStaticText" />
							</TD>

							<TD><form:input id="totalDistribution"
									path="totalDistribution" readOnly="true" /></TD>
						</TR>

					</TABLE>
					</div>
					<TABLE>
						<TR>
							<TD><input type="Submit" id="saveChanges" name="saveChanges"
								value="Save Changes" /></TD>
							<TD><input type="Submit" id="runFirstPayment"
								name="runFirstPayment" value="Run First Payments" /></TD>
							<TD><input type="Submit" id="runSecondPayment"
								name="runSecondPayment" value="Run Second Payments" /></TD>
						</TR>
					</TABLE>
					<TABLE>
						<TR>
							<TD colspan="3" align="right"><h3>
									<spring:message
										code="DistributionAmounts.StaticText.enterAllFundingSourcesOfTotalPaymentStaticText" />
								</h3></TD>
						</TR>
						<TR>
							<TD><form:textarea id="" path="fundingSources" rows="6"
									cols="120" /></TD>
						</TR>
						<TR>
							<TD align="center"><input type="Submit"
								name="saveFundingSources" value="Save Funding Sources" /></TD>
						</TR>
					</TABLE>
				</TD>
			</TR>
		</TABLE>
	</form:form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/DistributionAmounts.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>