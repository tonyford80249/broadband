
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

<script language="javascript" type="text/javascript">
<!-- script language="javascript" type="text/javascript"-->
	$(document)
			.ready(
					function() {
						if ('${electionForm.electionHeld}' == "false") {
							document.getElementById('electionHeldFalse').checked = true;
						} 
						
						if ('${electionForm.electionHeld}' == "true") {
							document.getElementById('electionHeldTrue').checked = true;
						}
					
						/*for ( var j = 0; j < 9; j++) {
							document.getElementById('categoryHeldTrue' + j).checked = false;
							document.getElementById('categoryHeldFalse' + j).checked = true;
						}*/

						$('#districtCodeList')
								.change(
										function() {
											var varDistrictNumber = $('#districtCodeList option:selected').val();
											var varFiscalYear = $('#fiscalYear').val();
											$
													.getJSON(
															'${pageContext.request.contextPath}/secure/Elections/json',
															{
																districtNumber : varDistrictNumber,
																fiscalYear : varFiscalYear
															},

															function(json) {
																//clearAll();
																
																if (json.electionForm.electionHeld == "false") {
																  document.getElementById('electionHeldFalse').checked = true;
																  $('#electionItemGridList*').attr('disabled', 'disabled');
																} else	if (json.electionForm.electionHeld == "true") {
																  document.getElementById('electionHeldTrue').checked = true;
																} else {
																	document.getElementById('electionHeldFalse').checked = false;
																    document.getElementById('electionHeldTrue').checked = false;
																}

																$('input#districtNameField').val(json.electionForm.districtName);
	                                                            if ( json.electionForm.ballotUploaded == "true") {
																	document.getElementById('displayFile').disabled = false;
																	$('#displayFile').removeAttr('disabled');
																}
																for ( var j = 0; j < json.electionForm.size; j++) {
																	document.getElementById('categoryHeldTrue'+ j).value = json.electionForm.electionItemGridList[j].categoryHeld;
																	if (json.electionForm.electionItemGridList[j].categoryHeld == "true") {
																		document.getElementById('categoryHeldTrue'+ j).checked = true;
																	} else {
																		document.getElementById('categoryHeldFalse'+ j).checked = true;
																	}
																	document.getElementById('electionItemGridList'+ j + '.forVoteCount').value = json.electionForm.electionItemGridList[j].forVoteCount;
																	document.getElementById('electionItemGridList'+ j + '.againstVoteCount').value = json.electionForm.electionItemGridList[j].againstVoteCount;
																	document.getElementById('electionItemGridList'+ j + '.categoryAmount').value = json.electionForm.electionItemGridList[j].categoryAmount;
																	document.getElementById('electionItemGridList'+ j + '.ballotQuestion').value = json.electionForm.electionItemGridList[j].ballotQuestion;
																	document.getElementById('electionItemGridList'+ j + '.id').value = json.electionForm.electionItemGridList[j].id;
																	
																}
																//document.getElementById('typeOfOtherElection').value = json.electionForm.typeOfOtherElection;
																$('#MessageFont').html(json.electionForm.errorMessage);
															});
										});

						$('#UploadFile').on('blur', function(event) {
							$('#confirmUpload').removeAttr('disabled');
						});
						
						//$('#confirmUpload').on('blur', function(event) {
						//	$('#displayFile').attr('disabled','disabled');
						//});
						if ('${electionForm.ballotUploaded}' == "true") {
							document.getElementById('displayFile').disabled = false;
							$('#confirmUpload').removeAttr('disabled');
						}
					});

	function clearAll() {

		for ( var j = 0; j < 9; j++) {

			document.getElementById('categoryHeldTrue' + j).checked = false;
			document.getElementById('electionItemGridList' + j + '.forVoteCount').value = 0;
			document.getElementById('electionItemGridList' + j + '.againstVoteCount').value = 0;
			document.getElementById('electionItemGridList' + j + '.categoryAmount').value = 0.00;
			document.getElementById('electionItemGridList' + j + '.ballotQuestion').value = '';
		}
		//document.getElementById('typeOfOtherElection').value = '';
		if (document.getElementById('Message') != null)
			document.getElementById('Message').value = '';
	}
</script>
<%-- Wrap the entire JSP in a try/catch block so that runtime exceptions
    in the JSP can be caught and reported. --%>
<%@include file="/WEB-INF/jsp/JspTry.inc"%>
<div>

	<form:form commandName="electionForm"
		action="${pageContext.request.contextPath}/secure/Elections/submit"
		method="post" enctype="multipart/form-data">

		<!-- Main outer table -->
		<h2>
			<spring:message
				code="Elections.StaticText.reportOfCurrentYearElectionResultsStaticText" />
		</h2>
		<font id="MessageFont" color="red"><c:out id="Message" value="${electionForm.errorMessage}" /></font>
		<div class="formBlock boxShadow3 radius10">
			<TABLE>
				<TR>
					<form:hidden path="fiscalYear" />
					<form:hidden path="id" />
					<TD>District Code:&nbsp;&nbsp;&nbsp;&nbsp;<form:select
							id="districtCodeList" path="districtCode" size="1">
							<form:options items="${districtCodeList}"></form:options>
						</form:select> &nbsp;&nbsp;&nbsp;&nbsp;<LABEL FOR="">District Name:</LABEL> <form:input
							id="districtNameField" path="districtName"></form:input>
					</TD>
				</TR>
				<TR />

				<TR>
					<TD COLSPAN="6"><b><spring:message
								code="Elections.StaticText.pleaseIndicateWhetherOrNotTheBoardOfEducationOfTheAboveDistrictHeldOneOrMoreOfTheFollowingElectionsInNovember2011StaticText" /></b>
					</TD>
				</TR>
				<TR>
					<TD><form:input type="radio" name="electionHeld" id="electionHeldTrue" path="electionHeld" value="true"/>Yes&nbsp;&nbsp;&nbsp;&nbsp; 
					    <form:input type="radio" name="electionHeld" id="electionHeldFalse" path="electionHeld" value="false"/>No&nbsp;&nbsp;&nbsp;&nbsp; 
					</TD>
				</TR> 
				<TR>
					<TD>
						<LABEL FOR=""><b>If you check 'no', please click 'Save Information' at the bottom of the screen.</b></LABEL>
				</TD>
				</TR>
				<TR>
					<TD><b>If you check 'yes',  please provide the following information below in the appropriate boxes provided, for each category for which an election was held</b></TD>
				</TR>
					<TR><TD><b>-	type of ballot question(s)</b></TD></TR>
					<TR><TD><b>-	 the votes for and against </b></TD></TR>
					<TR><TD><b>-	the dollar amount requested</b></TD></TR>
					<TR><TD><b>-	-	include a copy of the ballot language (copy and paste or upload)   </b></TD></TR>
					<TR><TD><b>Then click 'Save Information' at the bottom of the screen</b></TD></TR>
			</TABLE>
		</div>
		<TABLE>
			<c:forEach var="electionItemGrid"
				items="${electionForm.electionItemGridList}" varStatus="idx">
				<TR/>
				<TR width="1200px">
					<!-- TD width="1200px" COLSPAN="12"><b><form:input
								path="electionItemGridList[${idx.index}].electionTopic"
								size="200" /></b></TD-->
					<form:hidden path="electionItemGridList[${idx.index}].electionTopic" />
					<TD COLSPAN="12"><b><c:out value="${electionItemGrid.electionTopic}" /></b>
					</TD>


				</TR>
				<TR>

					<TD><form:hidden path="electionItemGridList[${idx.index}].electionCategory" /> 
					    <form:hidden path="electionItemGridList[${idx.index}].id" /> 
					    <span>&nbsp;&nbsp;
							<form:input type="radio" id="categoryHeldTrue${idx.index}"
								path="electionItemGridList[${idx.index}].categoryHeld"
								value="true" /> <span class="text">Yes</span>
					    </span>
					</TD>
					<TD><form:input type="radio"
							id="categoryHeldFalse${idx.index}"
							path="electionItemGridList[${idx.index}].categoryHeld" value="false" /> <span class="text">No</span>
					</TD>
					<TD ALIGN="left"><LABEL FOR="">Indicate the number of votes</LABEL>&nbsp;&nbsp;For:&nbsp;&nbsp; 
					        <form:input path="electionItemGridList[${idx.index}].forVoteCount" size="6" maxlength="10" /> &nbsp;&nbsp;Against:&nbsp;&nbsp; 
							<form:input path="electionItemGridList[${idx.index}].againstVoteCount" size="6" maxlength="10" />
					</TD>

					<TD>Amount:&nbsp;&nbsp; <form:input
							path="electionItemGridList[${idx.index}].categoryAmount"
							size="10" maxlength="10" />
					</TD>
				</TR>
				<tr>
					<td colspan="2">Ballot Question:</td>
					<td colspan="6"><form:textarea rows="2" cols="102"
							path="electionItemGridList[${idx.index}].ballotQuestion"></form:textarea>
					</td>
				</TR>
			</c:forEach>
			<!--TR>
				<TD COLSPAN="2"><LABEL FOR=""><b><spring:message
								code="Elections.StaticText.typeOfOtherElectionStaticText" /></b></LABEL></TD>
				<TD COLSPAN="6"><form:input id="typeOfOtherElection" path="typeOfOtherElection" size="150" maxlength="250" />
				</TD>
			</TR-->
			<TR>
				<TD COLSPAN="10">
					<TABLE>
						<TR>
							<td><spring:message
									code="Elections.StaticText.ifAnyElectionWasHeldAttachAnOfficialSampleBallotInWhichIsStatedTheQuestionSSubmittedToTheElectorsOrACopyOfTheOfficialBallotQuestionLanguageAsCertifiedToTheCountyClerkForACoordinatedElectionStaticText" />

							</TD>
							<TD><form:input type="file" path="file" id="UploadFile" value="Upload File" /> 
								<form:input type="submit" path="" id="confirmUpload" name="confirmUpload" disabled="disabled" value="Upload Ballot" />
								<form:input type="submit" path=""
									id="displayFile" name="displayFile" 
									value="Display Ballot" />
							 </TD>
							
						</TR>
					</TABLE>
				</td>
			</TR>
		</TABLE>
		<TABLE>
			<TR />
			<TR>
				<TD width="50%" />
				<TD width="100%" colspan="4" align="center"><input
					type="submit" id="save" name="save"
					value="Save Election Information" /></TD>
			</TR>
		</TABLE>
	</form:form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/Elections.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>