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
    
	$(document)
			.ready(
					function() {
                                             //disable input
                                             $('input.disabled').attr('disabled', true);
                                                                                          
                                             $('input#printAllReport').click(
                                              function() {//json
                                                
                                                            window.open("${pageContext.request.contextPath}/secure/PaymentWorkSheet/report/allPaymentWorksheets.pdf?"
								+ "fiscalYear="
								+ $('input#fiscalYearId').val()
                                                            );								
							}
                                                );
                                              

						/*
						 *  Attached function to dropdown's onchange event.
						 *
						 */
						$('select#districtNumber')
								.change(
										function() {
											var varDistrictNumber = "";
											$(
													"select#districtNumber option:selected")
													.each(
															function() {
																varDistrictNumber += $(
																		this)
																		.text();
															});

											$
													.getJSON(
															'${pageContext.request.contextPath}/secure/PaymentWorkSheet/json',
															{
																districtNumber : varDistrictNumber,
																fiscalYear : $(
																		'input#fiscalYearId')
																		.val()
															},
															function(json) {
																if (json.transportationForm.valid) {

																	$(
																			'input#DistrictName')
																			.val(
																					json.transportationForm.districtName);
																	$(
																			'input#pupilTran')
																			.val(
																					json.transportationForm.pupilTran);
																	$(
																			'input#totalCurrentOperatingExp')
																			.val(
																					json.transportationForm.operTran);
																	$(
																			'input#capitalOutlayExpense')
																			.val(
																					json.transportationForm.capOutTran);
																	$(
																			'input#netCurrentOperExpense')
																			.val(
																					json.transportationForm.netCurrentOperExpend);
																	$(
																			'input#migrationMiles')
																			.val(
																					json.transportationForm.migMiles);
																	$(
																			'input#regularDailyMiles')
																			.val(
																					json.transportationForm.regDMiles);
																	$(
																			'input#schoolDays')
																			.val(
																					json.transportationForm.schoolDays)
																	$(
																			'input#totalMiles')
																			.val(
																					json.transportationForm.totalMiles);
                													$(
																			'input#totalRegMiles')
																			.val(
																					json.transportationForm.totalRegMiles);																					
																					
																	$(
																			'input#totalReimMileage')
																			.val(
																					json.transportationForm.totalReimMileage);
																	$(
																			'input#mileageEntitlement')
																			.val(
																					json.transportationForm.mileageEntitlement);
																	$(
																			'input#excessCosts')
																			.val(
																					json.transportationForm.exCosts);
																	$(
																			'input#expenseReimbursement')
																			.val(
																					json.transportationForm.exReim);
																	$(
																			'input#mileageEntitlement')
																			.val(
																					json.transportationForm.mileageEntitlement);
																	$(
																			'input#mileagePlusCostEntitlement')
																			.val(
																					json.transportationForm.mileagePlusCostEntitlement);				
																	$(
																			'input#maxReimEntitlement')
																			.val(
																					json.transportationForm.maxReimEntitlement);
																	$(
																			'input#reimbursementTranportation')
																			.val(
																					json.transportationForm.reimTran);
																	$(
																			'input#reimbursementTranportationLastYear')
																			.val(
																					json.transportationForm.reimTranLy);
																	$(
																			'input#reimEntitlement')
																			.val(
																					json.transportationForm.reimEntitlement);
																	$(
																			'input#boardTran')
																			.val(
																					json.transportationForm.boardTran);
																	$(
																			'input#totalReimEntitlement')
																			.val(
																					json.transportationForm.totalReimEntitlement);
																	$(
																			'input#advancePayLastYear')
																			.val(
																					json.transportationForm.advPayLy);
																	$(
																			'input#finalReimEntitlement')
																			.val(
																					json.transportationForm.finalReimEntitlement);
																	$(
																			'input#finalReimProrated')
																			.val(
																					json.transportationForm.finalReimProrated);
																		$(
																			'input#totalDistribution')
																			.val(
																					json.transportationForm.districtDistribution);
															
																	$(
																			'input#advPay')
																			.val(
																					json.transportationForm.advPay);
																	$(
																			'input#desegReim')
																			.val(
																					json.transportationForm.desegReim);
																	$(
																			'input#actualMiles')
																			.val(
																					json.transportationForm.actMiles);
																	$(
																			'input#totalMiles')
																			.val(
																					json.transportationForm.totalMiles);
                                                                                                                                        $('input#printOneReport').unbind();
																	$(
																			'input#printOneReport')
																			.click(
																					function() {
																						window.open("${pageContext.request.contextPath}/secure/PaymentWorkSheet/report/paymentWorksheet.pdf?districtNumber="
																								+ json.transportationForm.districtNumber
																								+ "&fiscalYear="
																								+ json.transportationForm.fiscalYear);
																					});
																			formatPage();

																} else {
																	$(
																			'input#DistrictName')
																			.val(
																					json.transportationForm.districtName);
																	$(
																			'input#pupilTran')
																			.val(
																					0);
																	$(
																			'input#totalCurrentOperatingExp')
																			.val(
																					0.00);
																	$(
																			'input#capitalOutlayExpense')
																			.val(
																					0.00);
																	$(
																			'input#netCurrentOperExpense')
																			.val(
																					0.00);
																	$(
																			'input#migrationMiles')
																			.val(
																					0.0);
																	$(
																			'input#regularDailyMiles')
																			.val(
																					0.0);
																	$(
																			'input#schoolDays')
																			.val(
																					0);
																	$(
																			'input#regularMiles')
																			.val(
																					0.0);
																	$(
																			'input#totalReimMileage')
																			.val(
																					0.0);
																	$(
																			'input#mileageEntitlement')
																			.val(
																					0.0);
																	$(
																			'input#excessCosts')
																			.val(
																					0.00);
																	$(
																			'input#expenseReimbursement')
																			.val(
																					0.00);
																	$(
																			'input#mileageEntitlement')
																			.val(
																					0.0);
																	$(
																			'input#maxReimEntitlement')
																			.val(
																					0.0);
																	$(
																			'input#reimbursementTranportation')
																			.val(
																					0.0);
																	$(
																			'input#reimbursementTranportationLastYear')
																			.val(
																					0.0);
																	$(
																			'input#reimEntitlement')
																			.val(
																					0.0);
																	$(
																			'input#boardTran')
																			.val(
																					0.0);
																	$(
																			'input#totalReimEntitlement')
																			.val(
																					0.0);
																	$(
																			'input#advancePayLastYear')
																			.val(
																					0.0);
																	$(
																			'input#finalReimEntitlement')
																			.val(
																					0.0);
																	$(
																			'input#finalReimProrated')
																			.val(
																					0.0);
																	$(
																			'input#advPay')
																			.val(
																					0.0);
																	$(
																			'input#desegReim')
																			.val(
																					0.0);
																	$(
																			'input#actualMiles')
																			.val(
																					0.0);
																	$(
																			'input#totalMiles')
																			.val(
                																					0.0);
																	$(
																			'input#totalRegMiles')
																			.val(
																					0.0);																					
																	$('input#printOneReport').unbind();
																	$(
																			'input#printOneReport')
																			.click(
																					function() {
																						window.location = "${pageContext.request.contextPath}/secure/PaymentWorkSheet/";
																					});
																}

																formatPage();
															})
										})
					})
</script>

<script language="javascript" type="text/javascript">
	function formatPage() {

		formatMileageField('migrationMiles');
		formatMileageField('regularDailyMiles');
		formatMileageField('totalMiles');
		formatMileageField('regularMiles');
		formatMileageField('totalReimMileage');
		formatMileageField('mileageEntitlement');
		formatMileageField('actMiles');
		formatMileageField('totalRegMiles');

		checkAndFormatAmount('totalCurrentOperatingExp');
		checkAndFormatAmount('advPay');
		checkAndFormatAmount('netCurrentOperExpense');
		checkAndFormatAmount('finalReimProrated');
		checkAndFormatAmount('totalReimEntitlement');
		checkAndFormatAmount('desegReim');
		checkAndFormatAmount('finalReimEntitlement');
		checkAndFormatAmount('districtDistribution');
		checkAndFormatAmount('reimEntitlement');
		checkAndFormatAmount('excessCosts');
		checkAndFormatAmount('capitalOutlayExpense');
		checkAndFormatAmount('expenseReimbursement');
		checkAndFormatAmount('advancePayLastYear');
		checkAndFormatAmount('netCurrentOperExpend');
		checkAndFormatAmount('reimbursementTranportation');
		checkAndFormatAmount('maxReimEntitlement');
		checkAndFormatAmount('mileageEntitlement');
		checkAndFormatAmount('mileagePlusCostEntitlement');
		checkAndFormatAmount('totalDistribution');
		checkAndFormatAmount('reimTranLy');
	}
</script>

<%@include file="/WEB-INF/jsp/JspTry.inc"%>
<div id="mainbody">
	<div id="contentarea">
		<div id="pagecontent">
			<form:form commandName="transportationForm"
				action="${pageContext.request.contextPath}/secure/PaymentWorkSheet/save"
				method="post">
				<script onLoad="formatPage()" type="text/javascript">
					
				</script>
				<h2>
					<spring:message
						code="PaymentWorkSheet.StaticText.paymentWorksheetStaticText" />
				</h2>

				<!-- Main outer table ${ districtNumber} pupilTran-->
				<div class="formBlock boxShadow3 radius10">
					<TABLE>
						<TR>
							<TD>School District Number&nbsp;&nbsp;&nbsp;&nbsp;</TD>
							<TD><form:select id="districtNumber" path="districtNumber">
									<form:option value="NONE" label="-- Select --" />
									<form:options items="${districtNumbers}"></form:options>
								</form:select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</TD>
							<TD>School District Name&nbsp;&nbsp;&nbsp;&nbsp;</TD>
							<TD><form:input cssClass="disabled" id="DistrictName"
									path="districtName" size="26" maxlength="26" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</TD>
							<TD><spring:message
									code="PaymentWorkSheet.StaticText.fiscalYearStaticText" />&nbsp;&nbsp;&nbsp;&nbsp;</TD>
							<TD><form:input cssClass="disabled" id="fiscalYearId"
									path="fiscalYear" size="8" maxlength="8" /></TD>
						</TR>

					</TABLE>
				</div>
				<div class="formBlock boxShadow3 radius10">
					<TABLE>

						<TR>
							<TD width="84%"><spring:message
									code="PaymentWorkSheet.StaticText.numberOfPupilsStaticText" /></TD>
							<TD>&nbsp;&nbsp;<form:input cssClass="disabled"
									id="pupilTran" path="pupilTran" /></TD>
						</TR>

					</TABLE>
				</div>
				<TABLE>
					<TR>
						<TD><spring:message
								code="PaymentWorkSheet.StaticText.$1TotalCurrentOperatingExpendituresForPupilTransportationLine1cFromCde40StaticText" />
						</TD>
						<TD><form:input cssClass="disabled"
								id="totalCurrentOperatingExp" path="operTran" /></TD>
					</TR>
					<TR>
						<TD><spring:message
								code="PaymentWorkSheet.StaticText.$2CapitalOutlayExclusionForPupilTransportationForIndependentContractorsAsCalculatedByCdeStaticText" />
						</TD>
						<TD><form:input cssClass="disabled" id="capitalOutlayExpense"
								path="capOutTran" /></TD>
					</TR>
					<TR>
						<TD><spring:message
								code="PaymentWorkSheet.StaticText.$3NetCurrentOperatingExpendituresLine1MinusLine2StaticText" />
						</TD>
						<TD><form:input cssClass="disabled"
								id="netCurrentOperExpense" path="netCurrentOperExpend" /></TD>
					</TR>
					<TR>
						<TD><spring:message
								code="PaymentWorkSheet.StaticText.$5MileageTraveledForRegularPupilTransportationOnTheMileageCountDateLine3Cde40NearestToOctober1StaticText" />
						</TD>
						<TD><form:input cssClass="disabled" id="regularDailyMiles"
								path="regDMiles" /></TD>
					</TR>
					<TR>
						<TD><spring:message
								code="PaymentWorkSheet.StaticText.$6DaysOfSchoolHeldWhenPupilsWereTransportedIn20102011FiscalYearSchoolTermLine4Cde40StaticText" />
						</TD>
						<TD><form:input cssClass="disabled" id="schoolDays"
								path="schoolDays" /></TD>
					</TR>
					<TR>
						<TD>6. Regular education pupil transportation mileage (line 4
							times line 5)</TD>
						<TD><form:input id="totalRegMiles" cssClass="disabled"
								path="totalRegMiles" /></TD>
					</TR>
					<TR>
						<TD>7. Total reimbursable mileage (line 6)</TD>
						<TD><form:input id="totalReimMileage" cssClass="disabled"
								path="totalReimMileage" /></TD>
					</TR>
					<TR>
						<TD>8. Mileage entitlement (Line 7 times .3787)</TD>
						<TD><form:input id="mileageEntitlement" cssClass="disabled"
								path="mileageEntitlement" /></TD>
					</TR>
					<TR>
						<TD>9. Excess costs (line 3 less line 8)</TD>
						<TD><form:input id="excessCosts" cssClass="disabled"
								path="exCosts" /></TD>
					</TR>
					<TR>
						<TD>10. Excess cost entitlement (line 9 times .3387)</TD>
						<TD><form:input id="expenseReimbursement" cssClass="disabled"
								path="exReim" /></TD>
					</TR>
					<TR>
						<TD>11. Mileage entitlement plus excess cost entitlement
							(line 8 plus line 10)</TD>
						<TD><form:input id="mileagePlusCostEntitlement"
								cssClass="disabled" path="mileagePlusCostEntitlement" /></TD>
					</TR>
					<TR>
						<TD>12. Maximum reimbursement entitlement (line 3 times .90)
						</TD>
						<TD><form:input id="maxReimEntitlement" cssClass="disabled"
								path="maxReimEntitlement" /></TD>
					</TR>
					<TR>
						<TD>13. Calculated reimbursement entitlement for current
							fiscal year entitlement period (lesser of line 11 or line 12)</TD>
						<TD><form:input id="reimbursementTranportation"
								cssClass="disabled" path="reimTran" /></TD>
					</TR>
					<TR>
						<TD>14. Calculated reimbursement entitlement for previous
							fiscal year entitlement period</TD>
						<TD><form:input id="reimbursementTranportationLastYear"
								cssClass="disabled" path="reimTranLy" /></TD>
					</TR>

					<TR>
						<TD>15. Reimbursement entitlement for current fiscal year
							entitlement period not including financial aid for providing
							board (greater of line 13 or line 14)</TD>
						<TD><form:input id="reimEntitlement" cssClass="disabled"
								path="reimEntitlement" /></TD>
					</TR>
					<TR>
						<TD>16. Financial aid for providing board (number of days for
							which board was paid for pupils in lieu of transportation times
							$1)</TD>
						<TD><form:input id="boardTran" cssClass="disabled"
								path="boardTran" /></TD>
					</TR>
					<TR>
						<TD>17. Reimbursement entitlement for current fiscal year
							(line 15 plus line 16)</TD>
						<TD><form:input id="totalReimEntitlement" cssClass="disabled"
								path="totalReimEntitlement" /></TD>
					</TR>
					<TR>
						<TD>18. Advance reimbursement entitlement for current fiscal
							year entitlement period</TD>
						<TD><form:input id="advancePayLastYear" cssClass="disabled"
								path="advPayLy" /></TD>
					</TR>
					<TR>
						<TD>19. Final reimbursement entitlement for current fiscal
							year entitlement period (line 17 less line 18)</TD>
						<TD><form:input id="finalReimEntitlement"
								path="finalReimEntitlement" cssClass="disabled" /></TD>
					</TR>

					<TR>
						<TD>20. Final reimbursement entitlement prorated (line 19
							times .51718479)</TD>
						<TD><form:input id="finalReimProrated" cssClass="disabled"
								path="finalReimProrated" /></TD>
					</TR>

					<TR>
						<TD>21. Advance reimbursement entitlement for current fiscal
							year entitlement period (line 17 times 0.2)</TD>
						<TD><form:input id="advPay" path="advPay" cssClass="disabled" /></TD>
					</TR>
					<TR>
						<TD>22. Total Payment for current fiscal year entitlement
							period (line 20 plus line 21)</TD>
						<TD><form:input id="totalDistribution"
								path="districtDistribution" cssClass="disabled" /></TD>
					</TR>
					<TR>
						<TD>23. Total actual miles traveled for activity trips, field
							trips, athletic trips, etc. for current fiscal year</TD>
						<TD><form:input id="actualMiles" path="actMiles"
								cssClass="disabled" /></TD>
					</TR>
					<TR>
						<TD>24. Total actual miles traveled for any purpose in
							2010-2011 (excluding transportation support vehicles)</TD>
						<TD><form:input id="totalMiles" path="totalMiles"
								cssClass="disabled" /></TD>
					</TR>
				</TABLE>
				</br>
				<div style='text-align: center; margin: 1em 0;'>
					<TABLE>
						<TR>
							<TD width="40%" />
							<TD><c:if test="${transportationForm.valid}">
									<input type="Button" id="printOneReport" name="printOneReport"
										onclick="window.open('${pageContext.request.contextPath}/secure/PaymentWorkSheet/report/paymentWorksheet.pdf?districtNumber=' + ${transportationForm.districtNumber} + '&fiscalYear=' + ${transportationForm.fiscalYear});"
										value="Print Current Report" />
								</c:if> <c:if test="${!transportationForm.valid}">
									<input type="Button" id="printOneReport" name="printOneReport"
										value="Print Current Report" />
								</c:if></TD>
							<TD><input type="Button" id="printAllReport"
								name="printAllReport" value="Print All Reports" /></TD>
							<TD><input type="Submit" id="uploadToWeb" name="uploadToWeb"
								value="Upload Reports To Web" /></TD>
						</TR>
					</TABLE>
				</div>
				<!--  div-->
			</form:form>
		</div>
	</div>
</div>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/PaymentWorkSheet.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>