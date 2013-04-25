
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
<script language="javascript" type="text/javascript">
	$(document).ready(function() {
	
	    calculateOverrideCalculationFields();
		/*
		 *  Attached function to dropdown's onchange event.
		 */
		$('#districtCodeList').change(function() {
			var varDistrictNumber = $('#districtCodeList option:selected').val();
			var propertyTaxYear   = $('#propertyTaxYearList option:selected').val();
	
		
			$
			  .getJSON('${pageContext.request.contextPath}/secure/MillLevyOverrideWorksheet/json',
			   {	districtNumber : varDistrictNumber,
			    	propertyTaxYear : propertyTaxYear
				},
			  
				function(json) {
				    //if (json.millLevyOverrideForm.valid) {
				       $('input#districtNameField').val(json.millLevyOverrideForm.districtName);
				       $('#grandTotalProg').val(json.millLevyOverrideForm.grandTotalProg);
				       $('#costOfLiving').val(json.millLevyOverrideForm.costOfLiving);
				       calculateOverrideCalculationFields();
				//}
			})
			
		})
		
		})
		
		function calculateOverrideCalculationFields() {
	  		checkAndFormatAmount('grandTotalProg');
	  		var val = parseFloat((document.getElementById('grandTotalProg').value).replace(/[^0-9-.]/g, ''));
	  		if (!isFloat(val)) {
	  			 alert("Please enter numeric value only");
			     return;
	  		}	
	  		document.getElementById('quarterOfTotalProg').value = (val/4).formatMoney();
	  		if (val > 200000) {
	  			document.getElementById('allowableOverride').value = document.getElementById('quarterOfTotalProg').value;
	  		} else {
	  		    document.getElementById('allowableOverride').value = document.getElementById('minOverrideAllowed').value;
	  		}
	  	
	  		
	  		var costOfLiving = parseFloat((document.getElementById('costOfLiving').value).replace(/[^0-9-.]/g, ''));
	  		var allowableOverride = parseFloat((document.getElementById('allowableOverride').value).replace(/[^0-9-.]/g, ''));
	  		var totalProgramFunding = parseFloat((document.getElementById('grandTotalProg').value).replace(/[^0-9-.]/g, ''));
	  		
	  		if (!isFloat(costOfLiving)) {
	  			 alert("Please enter numeric value only");
			     return;
	  		}	
	  		document.getElementById('totalOverrideAllowed').value = (costOfLiving + allowableOverride).formatMoney();
	  		document.getElementById('remainingBalance').value = (totalProgramFunding - (costOfLiving + allowableOverride)).formatMoney();
	  	}
	  	
	  	
</script>
<%@include file="/WEB-INF/jsp/JspTry.inc"%>
<div id="mainContent">
	<form:form commandName="millLevyOverrideForm"
		action="${pageContext.request.contextPath}/secure/MillLevyOverrideWorksheet/report"
		method="post">

		<h3>
			<spring:message
				code="MillLevyOverrideWorksheet.StaticText.reportStaticText" />
		</h3>
		<!-- Main outer table -->
		<TABLE>
			<TR>
				<TD>
					<div class="formBlock boxShadow3 radius10">
					    <font color="red"><c:out id="Message" value="${millLevyOverrideForm.errorMessage}"/></font>
						<TABLE>
							<TR>
								<TD><LABEL FOR=""><spring:message
											code="MillLevyOverrideWorksheet.StaticText.propertyTaxYearStaticText" /></LABEL>
								</TD>
								<TD><form:select id="propertyTaxYearList" path="propertyTaxYear" multiple="false" size="1">
										<form:option value="NONE" label="-- Select --" />
										<form:options items="${propertyTaxYearList}"></form:options>
									</form:select></TD>
								<TD />
								<TD><LABEL FOR="">District Code</LABEL></TD>

								<TD><form:select id="districtCodeList" path="districtCode"
										size="1">
										<form:option value="NONE" label="-- Select --" />
										<form:options items="${districtCodeList}"></form:options>
									</form:select></TD>
								<TD />
								<TD><LABEL FOR="">District Name:</LABEL> <form:input
										id="districtNameField" path="districtName"></form:input></TD>
							</TR>
						</table>
					</div>
					<table>
						<TR>
							<TD><b><spring:message
										code="MillLevyOverrideWorksheet.StaticText.allowableOverrideStaticText" /></b>
							</TD>
							<TD><b><spring:message
										code="MillLevyOverrideWorksheet.StaticText.amountStaticText" /></b>
							</TD>
						</TR>
						<TR>
							<TD><LABEL FOR=""><spring:message
										code="MillLevyOverrideWorksheet.StaticText.projectedTotalProgramFormulaFundingStaticText" /></LABEL>
							</TD>
							<TD><form:input id="grandTotalProg" path="grandTotalProg"
									onBlur="calculateOverrideCalculationFields()" /></TD>
						</TR>
						<TR>
							<TD><LABEL FOR=""><spring:message
										code="MillLevyOverrideWorksheet.StaticText.$25TotalProgramStaticText" /></LABEL>
							</TD>
							<TD><form:input id="quarterOfTotalProg" path="quarterOfTotalProg" readonly="true"/></TD>
						</TR>
						<TR>
							<TD><LABEL FOR=""><spring:message
										code="MillLevyOverrideWorksheet.StaticText.minimumOverrideAllowedStaticText" /></LABEL>
							</TD>
							<TD><form:input id="minOverrideAllowed"  readonly="true"
									path="minOverrideAllowed" /></TD>
						</TR>
						<TR>
							<TD><spring:message
									code="MillLevyOverrideWorksheet.StaticText.allowableOverrideStaticText_2" />
							</TD>
						</TR>
						<TR>
							<TD><LABEL FOR="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<spring:message
										code="MillLevyOverrideWorksheet.StaticText.greaterOf25OfTotalProgramOr200000StaticText" /></LABEL>
							</TD>
							<TD><form:input id="allowableOverride" readonly="true"
									path="allowableOverride" /></TD>
						</TR>
						<TR>
							<TD><LABEL FOR=""><spring:message
										code="MillLevyOverrideWorksheet.StaticText.plusCostOfLivingAdjustmentStaticText" /></LABEL>
							</TD>
							<TD><form:input id="costOfLiving" path="costOfLiving" readonly="true"
									onBlur="calculateOverrideCalculationFields()" /></TD>
						</TR>
						<TR>
							<TD><LABEL FOR=""><spring:message
										code="MillLevyOverrideWorksheet.StaticText.totalAllowableOverrideStaticText" /></LABEL>
							</TD>
							<TD><form:input id="totalOverrideAllowed" readonly="true"
									path="totalOverrideAllowed" /></TD>
						</TR>
						<TR>
							<TD><LABEL FOR=""><spring:message
										code="MillLevyOverrideWorksheet.StaticText.totalExisitngOverridePropertyTaxRevenuesStaticText" /></LABEL>
							</TD>
							<TD><form:input id="propertyTaxRevenue" readonly="true"
									path="propertyTaxRevenue" /></TD>
						</TR>
						<TR>
							<TD><LABEL FOR=""><spring:message
										code="MillLevyOverrideWorksheet.StaticText.remainingBalanceAt25LimitStaticText" /></LABEL>
							</TD>
							<TD><form:input id="" path="remainingBalance" readonly="true"/></TD>
						</TR>
					</TABLE>
					<TABLE>
						<TR>
						    <TD width="20%"/>
							<TD><input type="submit" id="" class="show-tooltip" title="Display as PDF Document to save on local machine or print"
								value="Display as PDF Document" />
							</TD>
						</TR>
					</TABLE>
				</TD>
			</TR>
		</TABLE>
	</form:form>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/scripts/screen/MillLevyOverrideWorksheet.js"></script>
	<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
	<%@include file="/WEB-INF/jsp/JspCatch.inc"%>