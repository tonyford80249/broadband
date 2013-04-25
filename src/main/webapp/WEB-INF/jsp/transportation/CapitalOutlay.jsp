
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
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	String prevFiscalYear = DateUtil.getPrevFiscalYear();
	String formattedFiscalYear = DateUtil.getFiscalYearFormattedLong(prevFiscalYear);
	HashMap<String, String> districtsMap = (HashMap<String, String>) session
			.getAttribute("districtsMap");
%>

<style>
.scrollableArea {
	padding: 1em;
	margin: 1em 0;
	border: 1px solid #A6C9E2;
	overflow: auto;
}
</style>

<script type="text/javascript">
   function calculateTotalPurchaseRelatedFields(index) {
	  		var i = 0;
	  		
	  		var val = parseFloat((document.getElementById('totalPurchasePrice' + index).value).replace(/[^0-9-.]/g, ''));
	  		if (!isFloat(val)) {
	  			 alert("Please enter numeric value only");
			     return;
	  		}	
	  		
		   document.getElementById('totalPurchasePrice' + index).value =  val.formatMoney();
		   document.getElementById('depreciationCycleValue' + index).value = (val/10).formatMoney();
		   document.getElementById('capitalOutlayGridList' + index + '.prevDepreciatedAmt').value = ((val/10)*(9 - index)).formatMoney();;
		   var remainingAmount = val - (val/10)*(9 - index) ;
		   document.getElementById('capitalOutlayGridList' + index + '.remainingAmt').value =  parseFloat(remainingAmount).formatMoney();
		   if (remainingAmount <= 0) {
			   document.getElementById('capitalOutlayGridList' + index + '.depreciationPy').value = 0.00;
		   }
		   else {
		   	   document.getElementById('capitalOutlayGridList' + index + '.depreciationPy').value = (val/10).formatMoney();
		   }
		   if (document.getElementById('capitalOutlayGridList' + index + '.depreciationPy') != null)
		      calculateCapitalOutlayFields(index);
		   document.getElementById('capitalOutlayGridList' + index + '.contractorMiles').focus();
		   
	}

   function calculateCapitalOutlayFields(index) {
	  
	   		var val1 = parseFloat(document.getElementById('capitalOutlayGridList' + index + '.contractorMiles').value.replace(/[^0-9-.]/g, ''));
	   		var val2 = parseFloat(document.getElementById('capitalOutlayGridList' + index + '.depreciationPy').value.replace(/[^0-9-.]/g, ''));
 		   var exclVal = parseFloat((val1 * val2) / 100);
		   document.getElementById('capitalOutlayGridList' + index + '.outlayExclusion').value = exclVal.formatMoney();
		   
		   var totalFunding =  0;
		   for (var j=0; j <10; j++)
		   	  totalFunding += parseFloat(document.getElementById('capitalOutlayGridList' + j + '.outlayExclusion').value.replace(/[^0-9-.]/g, ''));
	       document.getElementById('capitalOutlayTotalFunding').value =  parseFloat(totalFunding).formatMoney();
	       if (index < 9 )
	         index = index + 1;
	         document.getElementById('capitalOutlayGridList' + index + '.totalPurchasePrice').focus();
	         //document.getElementById('totalPurchasePrice' + index).focus();*/
	 }
	 
	 
	 function displayAlertMessage() {
	
	    alert("Your CDE-40 Form will be submitted. If the form is valid it will be saved and considered as completed. A pdf copy of the CDE-40 and Capital Outlay will be emailed to the email address provided on this form. If any changes need to be made to this CDE-40 Form, please contact the Colorado Department of Education: 303-866-6843");
	 }
   
 </script>


<div id="mainbody">
	<div id="contentarea">
		<div id="pagecontent">

			<h2>
				<spring:message
					code="CapitalOutlay.StaticText.capitalOutlayReimbursementYearStaticText" />
				&nbsp;<%=formattedFiscalYear%>
			</h2>
			
			<form:form commandName="capitalOutlayForm"
				action="${pageContext.request.contextPath}/secure/CapitalOutlay/save"
				method="post">
				<input type="hidden" name="rowKey" id="rowKey" />
				
				<div class="formBlock boxShadow3 radius10">
					<h3>Contact information of the person preparing the report</h3>
					<form:hidden path="fiscalYear" />
					<form:hidden path="baseYear" />
					<div style='float: left;'>
						<span class="field" style='width: 100px;'><label
							for="preparerName">Name</label></span> <span class="bodyText"
							style='width: 350px;'> <form:input id=""
								path="preparerName" size="25" maxlength="100" readonly="true"/>
						</span> <br /> <span class="field" style='width: 100px;'><LABEL
							FOR=""><spring:message
									code="CapitalOutlay.StaticText.emailAddressStaticText" /></LABEL> </span> <span
							class="bodyText" style='width: 350px;'> <form:input id="" readonly="true"
								path="preparerEmailId" size="40" maxlength="100"
								onBlur="validateEmail('preparerEmailId')" />
						</span> <br /> <span class="field" style='width: 100px;'><label
							for="preparerPhoneNos">Phone</label></span> <span class="bodyText"
							style='width: 350px;'> <form:input id="" readonly="true"
								path="preparerPhoneNos" size="16" maxlength="16"
								onBlur="validatePhoneNos('preparerPhoneNos')" />
						</span>
					</div>
					<div
						style='float: left; background-color: #fafafa; border: 1px solid #ddd; padding: 0.5em 1em;'
						class='radius5'>
						<span class="field" style='width: 120px;'><label
							for="districtNumber">District Number</label></span> <span
							class="bodyText"> <form:input id="DistrictNumber" readonly="true"
								path="districtNumber" size="12" maxlength="12" />
						</span> <br /> <span class="field" style='width: 120px;'><label
							for="districtName">District Name</label></span> <span class="bodyText">
							<form:input id="DistrictName" path="districtName" size="26" readonly="true"
								maxlength="26" />
						</span>
					</div>
					<div style='clear: both;'></div>
				</div>
				<font color="red"><c:out id="Message" value="${capitalOutlayForm.message}"/></font>
				<div id="capitalOutlayGrid"
					class="scrollableArea boxShadow3 radius10">
					<table id="capitalOutlayGrid" class="display">
						<thead>
							<tr>
								<th width="2%">Fiscal Year</th>
								<th width="6%">Total Purchase Price for all Vehicles for
									Year</th>
								<th width="6%">10 Year Depreciation Cycle</th>
								<th width="6%">Previously Depreciated Amount</th>
								<th width="6%">Remaining Amount to be Depreciated</th>
								<th width="6%">Amount Depreciated from the Previous Year</th>
								<th width="6%">Percentage of Contractor Miles for the
									District</th>
								<th width="6%">Capital Outlay Exclusion Amount</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="capitalOutlayGrid"
								items="${capitalOutlayForm.capitalOutlayGridList}"
								varStatus="idx">
								<tr>
									<!-- td width="6%"><input id="capitalOutlayGridList0.fiscalYear" name="capitalOutlayGridList[0].fiscalYear" type="text" value="" size="10" maxlength="10"/></td-->
									<td width="4%"><form:hidden
											path="capitalOutlayGridList[${idx.index}].id" /> <form:hidden
											path="capitalOutlayGridList[${idx.index}].relatedYear" /> <c:out
											value="${capitalOutlayForm.capitalOutlayGridList[idx.index].relatedYear}" />
									</td>
									<td width="6%"><form:input style="background-color:yellow"
											size="10" maxlength="10"
											path="capitalOutlayGridList[${idx.index}].totalPurchasePrice"
											id="totalPurchasePrice${idx.index}"
											onBlur="calculateTotalPurchaseRelatedFields(${idx.index})" /></td>

									<td width="6%"><form:input readonly="true" size="10"
											maxlength="10" id="depreciationCycleValue${idx.index}"
											path="capitalOutlayGridList[${idx.index}].depreciationCycle" /></td>


									<td width="6%"><form:input readonly="true" size="10"
											maxlength="10"
											path="capitalOutlayGridList[${idx.index}].prevDepreciatedAmt" /></td>

									<td width="6%"><form:input readonly="true" size="10"
											maxlength="10"
											path="capitalOutlayGridList[${idx.index}].remainingAmt" /></td>

									<td width="6%"><form:input size="8" maxlength="8"
											readonly="true"
											path="capitalOutlayGridList[${idx.index}].depreciationPy" /></td>

									<td width="6%"><form:input size="8" maxlength="8"
											style="background-color:yellow"
											path="capitalOutlayGridList[${idx.index}].contractorMiles"
											onBlur="calculateCapitalOutlayFields(${idx.index})" /></td>

									<td width="6%"><form:input size="8" maxlength="8"
											readonly="true"
											path="capitalOutlayGridList[${idx.index}].outlayExclusion" /></td>


								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div style='text-align: right' margin: 10em;'>
					<LABEL FOR=""><spring:message
							code="CapitalOutlay.StaticText.capitalOutlayTotalFundingStaticText" /></LABEL>
					<form:input id="capitalOutlayTotalFunding"
						path="capitalOutlayTotalFunding" size="10" maxlen="10" readonly="true"/>
				</div>
				<font color="red"><c:out id="Message" value="${transportationForm.message}"/></font>
				</br>

				<div style='text-align: center; margin: 1em 0;'>
					<input type="Submit" id="saveButton" onClick="displayAlertMessage()"
						value="Save/Electronic Signature" />
				</div>
			</form:form>
			<!-- transportationForm -->

		</div>
		<!-- pagecontent -->
	</div>
	<!-- contentarea -->
</div>
<!-- mainbody -->


<%-- Wrap the entire JSP in a try/catch block so that runtime exceptions
    in the JSP can be caught and reported. --%>
<%@include file="/WEB-INF/jsp/JspTry.inc"%>





<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/CapitalOutlay.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>