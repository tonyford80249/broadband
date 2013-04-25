
<%--
(ref: jsp/jsp.jsp.et.jsp)
-------------------------------------
$Revision:   $
$Date:  $1
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

<%-- Wrap the entire JSP in a try/catch block so that runtime exceptions
    in the JSP can be caught and reported. --%>
<%@include file="/WEB-INF/jsp/JspTry.inc"%>


<%
    String prevFiscalYear = DateUtil.getPrevFiscalYear();
	String formattedFiscalYear = DateUtil.getFiscalYearFormattedLong(prevFiscalYear);
	HashMap<String, String> districtsMap = (HashMap<String, String>) session.getAttribute("districtsMap");
%>


<style>
.scrollableArea {
	width: 1130px;
	height: 420px;
	padding: 10px;
	border-style: solid;
	border-width: 1;
	overflow: auto;
}
</style>
<script type="text/javascript">
/*document.ready(function() {
   $("transportationGridList*.select*").click(function() {
     $("transportationGridList1.operTran").removeAttr("disabled");
   })

})*/

function checkSelectedRows() {
   //alert("Inside");
   //alert("${transportationForm.transportationGridList}.length");
}

function enableDisableDistrictData(index) {
   
   if (document.getElementById('transportationGridList' + index + '.select1').checked == true) {
       
        document.getElementById('operTran' + index).removeAttribute("readonly",0);

        document.getElementById('regDMiles'  + index).removeAttribute("readonly",0);
        document.getElementById('schoolDays'  + index).removeAttribute("readonly",0);
		
		document.getElementById('boardTran'  + index).removeAttribute("readonly",0);
		document.getElementById('pupilTran'  + index).removeAttribute("readonly",0);
		document.getElementById('actMiles'  + index).removeAttribute("readonly",0);
		document.getElementById('totalMiles'  + index).removeAttribute("readonly",0);
		document.getElementById('capOutTran'  + index).removeAttribute("readonly",0);
		document.getElementById('reimTranLy'  + index).removeAttribute("readonly",0);
		document.getElementById('advPay'  + index).removeAttribute("readonly",0);
		
   //enable the fields
   
   } else {
     //disable the fields
        document.getElementById('operTran' + index).readOnly = true;
        
		//document.getElementById('operTran' + index).setAttribute("disabled", true)
        document.getElementById('regDMiles' + index).readOnly = true;
		//document.getElementById('regDMiles' + index).setAttribute("disabled", true)
        document.getElementById('schoolDays' + index).readOnly = true;
		//document.getElementById('schoolDays' + index).setAttribute("disabled", true)
		
		document.getElementById('boardTran'  + index).readOnly = true;
		//document.getElementById('boardTran'  + index).setAttribute("disabled", true)
		document.getElementById('pupilTran'  + index).readOnly = true;
		//document.getElementById('pupilTran'  + index).setAttribute("disabled", true)
		document.getElementById('actMiles'  + index).readOnly = true;
		//document.getElementById('actMiles'  + index).setAttribute("disabled", true)
		document.getElementById('totalMiles'  + index).readOnly = true;
		//document.getElementById('totalMiles'  + index).setAttribute("disabled", true)
		document.getElementById('capOutTran'  + index).readOnly = true;
		//document.getElementById('capOutTran'  + index).setAttribute("disabled", true)
		document.getElementById('reimTranLy'  + index).readOnly = true;
		//cument.getElementById('reimTranLy'  + index).setAttribute("disabled", true)
		document.getElementById('advPay'  + index).readOnly = true;
		//cument.getElementById('advPay'  + index).setAttribute("disabled", true)
		
		 
   }
   
   return true;
}
</script>
<div id="mainbody">
	<div id="contentarea">
		<div id="pagecontent">
			<form:form commandName="transportationForm"
				action="${pageContext.request.contextPath}/secure/Cde40Summary/save"
				method="post">
				<input type="hidden" name="rowKey" id="rowKey" />
				<form:hidden path="id" />
				<h2>
					<spring:message
						code="Cde40Summary.StaticText.cde40SummaryStaticText" />
					for Fiscal Year
					<%= formattedFiscalYear %></h2>

				<fieldset class='boxShadow3 radius10'
					style='background-color: #fafafa; border: 1px solid #ddd; padding: 0.5em 1em; margin: 2em 0;'>
					<legend
						style='display: none; padding: 5px 10px; font-size: 14px; background-color: #fafafa; border: 1px solid #ddd; border-bottom: 0; position: relative; top: -13px;'>LEGEND</legend>
					<h3 style='margin: 0.5em; font-size: 1.1em;'>
						Legend:
						</h2>
						<ol class='left' style='margin-top: 0px;'>
							<li>District Code</li>
							<li>District Name</li>
							<li>Current Operating Expenditure</li>
							<li>Mileage Scheduled for Regular Pupil Transport</li>
							<li>Days School was in Session</li>
							<li>Room and Board: Days Paid</li>
						</ol>
						<ol start='7' class='left' style='margin-top: 0px;'>
							<li>Pupils Scheduled to be Transported</li>
							<li>Activity Miles</li>
							<li>Total Miles Traveled for Any Purpose</li>
							<li>Capital Outlay</li>
							<!-- li>Fees Collected from Individuals</li> -->
							<li>Calculated Reimbursement Entitlement (Previous Year)</li>
							<li>Advance Reimbursement Entitlement (Current Entitlement
								Period)</li>
						</ol>
				</fieldset>
				<font color="red"><c:out id="Message"
						value="${transportationForm.message}" /></font>
				<div id="transportationGrid"
					class="scrollableArea boxShadow3 radius10">
					<table id="transportationGrid" class="display">
						<thead>
							<tr>
								<th><span title='Select'>Sel</span></th>
								<th><span title='District Code'>1.Dist Cd</span></th>
								<th><span title='District Name'>2. Dist Name</span></th>
								<th><span title='Net Current Oper Expenditure'>3.
										COE</span></th>
								<th><span
									title='Mileage Scheduled for Regular Pupil Transport'>4.
										Reg Miles</span></th>
								<th><span title='Days School was in Session'>5. Schl
										Days</span></th>
								<th><span
									title='Days Room and Board was Paid for Pupils in Lieu of Transport'>6.
										Board</span></th>
								<th><span
									title='Pupils Scheduled to be Transported at Public Expense'>7.
										Pupil Sched</span></th>
								<th><span title='Actual Miles Traveled for Trips'>8.
										Act Miles</span></th>
								<th><span title='Actual Miles Traveled for Any Purpose'>9.
										Tot Miles</span></th>
								<th><span title='Capital Outlay'>10. Cap Out</span></th>
								<!-- th <span title='Fees Collected from Individuals'>12</span></th> -->
								<th><span
									title='Calculated Reimbursement Entitlement (Previous Year)'>11.
										Calc Riem</span></th>
								<th><span
									title='Advance Reimbursement Entitlement (Current Entitlement Period)'>12
										Adv Riem</span></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<c:forEach var="transportationGrid"
									items="${transportationForm.transportationGridList}"
									varStatus="idx">
									<td><form:hidden
											path="transportationGridList[${idx.index}].id" /> 
											<form:checkbox
											value="true"
											path="transportationGridList[${idx.index}].select"
											onclick="enableDisableDistrictData(${idx.index})" /></td>
									<td style='white-space: nowrap;'><form:hidden
											path="transportationGridList[${idx.index}].districtNumber" />
										<c:out
											value="${transportationForm.transportationGridList[idx.index].districtNumber}" />
									</td>
									<td style='white-space: nowrap;'><form:hidden
											path="transportationGridList[${idx.index}].districtName" />
										<c:out
											value="${transportationForm.transportationGridList[idx.index].districtName}" />
									</td>
									<td><form:input size="8" id="operTran${idx.index}"
											path="transportationGridList[${idx.index}].operTran"
											readonly="true"
											onBlur="checkAndFormatAmount('operTran${idx.index}')" />
									</td>
									<td><form:input size="5" id="regDMiles${idx.index}"
											path="transportationGridList[${idx.index}].regDMiles"
											readonly="true"
											onBlur="formatMileageField('regDMiles${idx.index}')" /></td>
									<td><form:input size="5" id="schoolDays${idx.index}"
											readonly="true"
											path="transportationGridList[${idx.index}].schoolDays" /></td>
									<td><form:input size="4" id="boardTran${idx.index}"
											readonly="true"
											path="transportationGridList[${idx.index}].boardTran" /></td>
									<td><form:input size="6" id="pupilTran${idx.index}"
											readonly="true"
											path="transportationGridList[${idx.index}].pupilTran" /></td>
									<td><form:input size="6" id="actMiles${idx.index}"
											readonly="true"
											path="transportationGridList[${idx.index}].actMiles"
											onBlur="formatMileageField('actMiles${idx.index}')" /></td>
									<td><form:input size="8" readonly="true"
											id="totalMiles${idx.index}"
											path="transportationGridList[${idx.index}].totalMiles"
											onBlur="formatMileageField('totalMiles${idx.index}')" /></td>
									<td><form:input size="6" readonly="true"
											id="capOutTran${idx.index}"
											path="transportationGridList[${idx.index}].capOutTran"
											onBlur="checkAndFormatAmount('capOutTran${idx.index}')" /></td>
									<td><form:input size="8" id="reimTranLy${idx.index}"
											readonly="true"
											path="transportationGridList[${idx.index}].reimTranLy"
											onBlur="checkAndFormatAmount('reimTranLy${idx.index}')" /></td>
									<td><form:input size="8" id="advPay${idx.index}"
											readonly="true"
											path="transportationGridList[${idx.index}].advPay"
											onBlur="checkAndFormatAmount('advPay${idx.index}')" /></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					<!-- transportationGrid -->
					<script type="text/javascript">						$(document).ready(function() {
							$("table#transportationGrid").dataTable({
								"bPaginate" : false,
								"bSort" : true,
								"bFilter" : true,
								"bInfo" : true,
								"bLengthChange" : true,
								"bAutoWidth" : true,
								"aoColumns": [
								null,
								null,
								null,
								{ "sSortDataType": "dom-text" },
								{ "sSortDataType": "dom-text" },
								{ "sSortDataType": "dom-text" },
								{ "sSortDataType": "dom-text" },
								{ "sSortDataType": "dom-text" },
								{ "sSortDataType": "dom-text" },
								{ "sSortDataType": "dom-text" }
					]
							});
						});
					</script>
				</div>
				<div style='margin: 1em 0;' align="center">

					<input type="Submit" id="saveButton" name="saveButton"
						value="Save Changes" onclick="checkSelectedRows()" /> 
					<input type="Submit" id="rejectDistrict" name="rejectDistrict"
						value="Reject District" />
				   <input type="Button" id="downLoadToExcel" name="downLoadToExcel"
						onclick="window.open('${pageContext.request.contextPath}/dynamic/report/cde40SummaryPayment.xls?fiscalYear=${transportationForm.fiscalYear}');"
						value="Download this Report to Excel" />
				</div>
			</form:form>
		</div>
		<!-- pagecontent -->
	</div>
	<!-- contentarea -->
</div>
<!-- mainbody -->


<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/Cde40Summary.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>