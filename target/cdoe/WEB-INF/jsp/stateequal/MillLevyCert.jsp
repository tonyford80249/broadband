
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
<script type="text/javascript" src="/equal/static/scripts/jquery/jquery.format-1.2/jquery.format-1.2.js"></script>
<script type="text/javascript" src="/equal/static/scripts/shared/formatter.js"></script>
<script type="text/javascript">
    
    function recomputeAll() {
      if (isPopulated('entrAssessedAbatementField')) {
        computeAbatement();  
      }
      if (isPopulated('entrOther')) {
        computeOther();  
      }
      if (isPopulated('entrKindergartenField')) {
       computeFullDayKindergarten()  
      }
      if (isPopulated('entrSpecialFundField')) {
       computeTechnologyFund();  
      }
      if (isPopulated('entrTransportationFundField')) {
        computeTransportationFund();  
      }
      if (isPopulated('entrBondRedemptionField')) {
        computeBondRedemption();  
      }
      if (isPopulated('entrVoterApprovedField')) {
        computeVoterAprroved(); 
      }
      
      certSumLines1Thru4();
      
      certSumLines5Thru10();
      
      formatMillLevy();
    }
    
    function computeAbatement() {   
        computeMillLevy('entrAssessedAbatementField', 'entrNetAssessedField', 'certAbatementField', $('input#calcAbatementField').val());
    }
    
    function computeOther() {   
        computeMillLevy('entrOther', 'entrNetAssessedField', 'certOther', $('input#calcOther').val());
    }
    
    function computeFullDayKindergarten() {   
        computeMillLevy('entrKindergartenField', 'entrNetAssessedField', 'certKindergartenField', $('input#calcKindergartenField').val());
    }
    
    function computeTechnologyFund() {   
        computeMillLevy('entrSpecialFundField', 'entrNetAssessedField', 'certSpecialFundField', $('input#calcSpecialFundField').val());
    }
    
    function computeTransportationFund() {   
        computeMillLevy('entrTransportationFundField', 'entrNetAssessedField', 'certTransportationFundField', $('input#calcTransportationFundField').val());
    }
    
    function computeBondRedemption() {   
        computeMillLevy('entrBondRedemptionField', 'entrNetAssessedField', 'certBondRedemptionField', $('input#calcBondRedemptionField').val());
    }
    
    function computeTotalGeneralFund() {   
        computeMillLevy('entrGeneralFundField', 'entrNetAssessedField', 'certGeneralFundField', $('input#calcGeneralFundField').val());
    }
    
    function computeVoterAprroved() {   
        computeMillLevy('entrVoterApprovedField', 'entrNetAssessedField', 'certVoterApprovedField', $('input#calcVoterApprovedField').val());
    }

    function isPopulated(field) {
      var amount = toDouble($('input#' + field).val());  
      
       if (!isNaN(amount) && amount > 1) {
         return true;  
       }
       
       return false;
    }

    function computeMillLevy(dividend, divisor, variable, defaultValue) {
        var amount = toDouble($('input#' + dividend).val());
        var netAmount = toDouble($('input#' + divisor).val());
 
        if (!isNaN(amount)  && !isNaN(netAmount ) && amount > 1 && netAmount > 1) {

            var computedMill = amount/netAmount * 1000;

            $('input#' + variable).val(computedMill);

            checkAndFormatMillLevy(variable);                        
        }
         else {
          $('input#' + variable).val(defaultValue);

            checkAndFormatMillLevy(variable);   
         }

    }

    function toDouble(strAmount) {
        return parseFloat(strAmount.replace(/[$,]+/g,"")) + 0.005;        
    }
    
       
    function certSumLines1Thru4() {
     $('input#certGeneralFundField').val(sum(['certTotalProgramField','certCategoricalBuyoutField','certVoterApprovedField','certHoldHarmlessField','certExcessHoldField','certAbatementField']));  
     
     checkAndFormatMillLevy('certGeneralFundField');
    }
    
    function certSumLines5Thru10() {
     $('input#certTotal2Field').val(sum(['certGeneralFundField','certBondRedemptionField','certTransportationFundField','certSpecialFundField','certKindergartenField','certOther']));  
     
      checkAndFormatMillLevy('certTotal2Field');     
    }
    
    function recomputeNetAssessedValuation() {
     $('input#entrNetAssessedField').val(sum(['entrGrossAssessedField','entrTaxincreamentField']));     
    }
    
    function sum(values) {
     var result = 0.0;
     
     for (var i = 0; i < values.length; i++) {
      var value= toDouble($('input#' + values[i]).val());
      
      if (!isNaN(value)) {
       result += value;
      }
     }
     
     return result;
    }

    function formatMillLevy() {
        checkAndFormatAmount('entrVoterApprovedField');    
        checkAndFormatAmount('entrAbatementField');            
        checkAndFormatAmount('entrBondRedemptionField');    
        checkAndFormatAmount('entrTransportationFundField');    
        checkAndFormatAmount('entrSpecialFundField');    
        checkAndFormatAmount('entrKindergartenField');    
        checkAndFormatAmount('entrOther');  
     
        checkAndFormatAmount('entrStateFundingField');    
        checkAndFormatAmount('entrMillLevyField');    
        checkAndFormatAmount('entrAssessedAbatementField');    
        checkAndFormatAmount('entrNetAssessedField');  
        checkAndFormatAmount('entrTaxincreamentField');  
        checkAndFormatAmount('entrGrossAssessedField');  
     
        checkAndFormatAmount('calcStateFundingField');    
        checkAndFormatAmount('calcAssessedAbatementField');    
        checkAndFormatAmount('calcNetAssessed');    
        checkAndFormatAmount('calcTaxIncreamentField');  
        checkAndFormatAmount('calcGrossAssessedField');  
     
        checkUSPhone('phoneField');
    
     
        checkAndFormatMillLevy('calcTotalProgramField');
        checkAndFormatMillLevy('calcCategoricalBuyoutField');
        checkAndFormatMillLevy('calcVoterApprovedField');
        checkAndFormatMillLevy('calcHoldHarmlessField');
        checkAndFormatMillLevy('calcExcessHoldField');
        checkAndFormatMillLevy('calcAbatementField');
        checkAndFormatMillLevy('calcGeneralFundField');
        checkAndFormatMillLevy('calcBondRedemptionField');
        checkAndFormatMillLevy('calcTransportationFundField');
        checkAndFormatMillLevy('calcSpecialFundField');
        checkAndFormatMillLevy('calcKindergartenField');
        checkAndFormatMillLevy('calcOther');
        checkAndFormatMillLevy('sumLines5Thru10Field');
        checkAndFormatMillLevy('calcMillLevyField');
        
        
        checkAndFormatMillLevy('certTotalProgramField');
        checkAndFormatMillLevy('certCategoricalBuyoutField');
        checkAndFormatMillLevy('certVoterApprovedField');
        checkAndFormatMillLevy('certHoldHarmlessField');
        checkAndFormatMillLevy('certExcessHoldField');
        checkAndFormatMillLevy('certAbatementField');
        checkAndFormatMillLevy('certGeneralFundField');
        checkAndFormatMillLevy('certBondRedemptionField');
        checkAndFormatMillLevy('certTransportationFundField');
        checkAndFormatMillLevy('certSpecialFundField');
        checkAndFormatMillLevy('certKindergartenField');
        checkAndFormatMillLevy('certOther');
        checkAndFormatMillLevy('certTotal2Field');
        checkAndFormatMillLevy('entrMillLevyField');
                                    
    }
    
    $(document).ready(function() {
        
        formatMillLevy();
        
        
        $('input#viewMillLevy').click(
                    function() {
                        window.open("${pageContext.request.contextPath}/secure/MillLevyCert/report/millLevyCert.pdf?districtNumber=${pageInfo.districtNumber}&taxYear=${pageInfo.taxYear}");
                    });
                
                          
        /*
         *  Attached function to dropdown's onchange event.
         */
        $('#districtCodeList').change(function() {
            var varDistrictNumber = $('#districtCodeList option:selected').val();
            var varCalendarYear = $('#taxYearField option:selected').val();
            
            
            
            $.getJSON('${pageContext.request.contextPath}/secure/MillLevyCert/json',
            {
                districtNumber : varDistrictNumber,
                fiscalYear : varCalendarYear
            },
            function(json) {
                if (json.millLevyForm.valid) {
                    $('input#districtNameField').val(json.millLevyForm.districtName);   
                    $('input#countyField').val(json.millLevyForm.county);   
                    $('input#completedByField').val(json.millLevyForm.entrCompletedBy);   
                    $('input#phoneField').val(json.millLevyForm.entrPhoneNumber);   
                    $('input#calcTotalProgramField').val(json.millLevyForm.calcTotalProgram);   
                    $('input#calcCategoricalBuyoutField').val(json.millLevyForm.calcCategoricalBuyout);   
                    $('input#calcVoterApprovedField').val(json.millLevyForm.calcVoterApproved);   
                    $('input#calcHoldHarmlessField').val(json.millLevyForm.calcHoldHarmless);   
                    $('input#calcExcessHoldField').val(json.millLevyForm.calcExcessHold);   
                    $('input#calcAbatementField').val(json.millLevyForm.calcAbatement);   
                    $('input#calcGeneralFundField').val(json.millLevyForm.sumLines1Thru4); 
                    $('input#calcBondRedemptionField').val(json.millLevyForm.calcBondRedemption);   
                    $('input#calcTransportationFundField').val(json.millLevyForm.calcTransportationFund);   
                    $('input#calcSpecialFundField').val(json.millLevyForm.calcSpecialFund);   
                    $('input#calcKindergartenField').val(json.millLevyForm.calcKindergarten);  
                    $('input#calcOther').val(json.millLevyForm.calcOther);   
                    $('input#sumLines5Thru10Field').val(json.millLevyForm.sumLines5Thru10);   
                    $('input#calcGrossAssessedField').val(json.millLevyForm.calcGrossAssessed);   
                    $('input#calcTaxIncreamentField').val(json.millLevyForm.calcTaxIncreament);   
                    $('input#calcNetAssessed').val(json.millLevyForm.calcNetAssessed);   
                    $('input#calcAssessedAbatementField').val(json.millLevyForm.calcAssessedAbatement);   
                    $('input#calcMillLevyField').val(json.millLevyForm.calcMillLevy); 
                    $('input#calcStateFundingField').val(json.millLevyForm.calcStateFunding);   
                  
                  
                    $('input#certTotalProgramField').val(json.millLevyForm.certTotalProgram);   
                    $('input#certCategoricalBuyoutField').val(json.millLevyForm.certCategoricalBuyout);   
                    $('input#certVoterApprovedField').val(json.millLevyForm.certVoterApproved);   
                    $('input#certHoldHarmlessField').val(json.millLevyForm.certHoldHarmless);   
                    $('input#certExcessHoldField').val(json.millLevyForm.certExcessHold);   
                    $('input#certAbatementField').val(json.millLevyForm.certAbatement);   
                    $('input#certGeneralFundField').val(json.millLevyForm.certTotal1);
                    $('input#certBondRedemptionField').val(json.millLevyForm.certBondRedemption);   
                    $('input#certTransportationFundField').val(json.millLevyForm.certTransportationFund);   
                    $('input#certSpecialFundField').val(json.millLevyForm.certSpecialFund);   
                    $('input#certKindergartenField').val(json.millLevyForm.certKindergarten);   
                    $('input#certOther').val(json.millLevyForm.certOther);                     
                    $('input#certTotal2Field').val(json.millLevyForm.certTotal2);   
                  
                  
                    $('input#entrGrossAssessedField').val(json.millLevyForm.calcGrossAssessed);   
                    $('input#entrTaxincreamentField').val(json.millLevyForm.calcTaxIncreament);   
                    $('input#entrNetAssessedField').val(json.millLevyForm.calcNetAssessed);   
                    $('input#entrAssessedAbatementField').val(json.millLevyForm.calcAssessedAbatement);   
                    $('input#entrMillLevyField').val(json.millLevyForm.calcMillLevy); 
                    $('input#entrStateFundingField').val(json.millLevyForm.calcStateFunding);   
                                    
                  
                    $('span#calcAssessedValuationDateField').html(json.millLevyForm.formattedCalcAssessedValuationDate);
                    $('span#certAssessedValuationDateField').html(json.millLevyForm.formattedCertAssessedValuationDate);
                  
                  
                    $('input#entrVoterApprovedField').val(0.0);   
                    $('input#entrAbatementField').val(0.0);   
                    $('input#entrGeneralFundField').val(0.0);   
                    $('input#entrBondRedemptionField').val(0.0);   
                    $('input#entrTransportationFundField').val(0.0); 
                    $('input#entrSpecialFundField').val(0.0);   
                    $('input#entrKindergartenField').val(0.0);   
                    $('input#entrOther').val(0.0);   
                  
                  
                    $('input#viewMillLevy').unbind();
                    $('input#viewMillLevy').click(
                    function() {
                        window.open("${pageContext.request.contextPath}/secure/MillLevyCert/report/millLevyCert.pdf?districtNumber="+ json.millLevyForm.districtNumber + "&taxYear=" + json.millLevyForm.taxYear);
                    });
                 
                    formatMillLevy();                                                                           
                }
            }
                                                                        
        );
        });
    });
</script>
<%@include file="/WEB-INF/jsp/JspTry.inc"%>
<div id="mainContent">

    <form:form commandName="pageInfo" action="${pageContext.request.contextPath}/secure/MillLevyCert/save"  method="post">

        <!-- Main outer table -->
        <h3>
            <spring:message
                code="MillLevyCert.StaticText.millLevyCertiicationStaticText" />
        </h3>
        <div>
            <TABLE>
                <TR>
                    <TD>
                        <div class="formBlock boxShadow3 radius10" style="margin: 20px; ">
                            <TABLE>

                                <TR>
                                    <TD>District Number:</TD>
                                    <TD><form:select id="districtCodeList" path="districtNumber"  size="1">
                                            <form:option value="NONE" label="-- Select --" />
                                            <form:options items="${districtCodeList}"></form:options>
                                        </form:select></TD>
                                    <TD>District Name:</TD>
                                    <TD><form:input id="districtNameField" path="districtName" size="26" maxlength="26" /></TD>
                                    <TD><LABEL FOR=""><spring:message  code="MillLevyCert.StaticText.countyStaticText" /></LABEL></TD>
                                    <TD><form:input id="countyField" path="county" size="25"  maxlength="128" /></TD>
                                    <TD><LABEL FOR=""><spring:message       code="MillLevyCert.StaticText.propertyTaxYearStaticText" /></LABEL></TD>
                                    <TD><form:select id="taxYearField" path="taxYear" items="${taxYears}" /></TD>
                                </TR>

                                <TR>
                                    <TD><LABEL FOR=""><spring:message
                                                code="MillLevyCert.StaticText.nameStaticText" /></LABEL></TD>
                                    <TD><form:input id="completedByField" path="entrCompletedBy" size="25"
                                                maxlength="128" /></TD>
                                    <TD><LABEL FOR=""><spring:message
                                                code="MillLevyCert.StaticText.phoneStaticText" /></LABEL></TD>
                                    <TD><form:input id="phoneField" path="entrPhoneNumber" size="25" onblur="checkUSPhone('phoneField');"
                                                maxlength="128" /></TD>
                                </TR>
                                <TR>
                                    <TD colspan="8">
                                        <div style="margin-left: 12px; padding: 12px;">
                                            <table id="certMillLevyForm" cellpadding="0" cellspacing="3" border="0" >
                                                <thead>
                                                    <tr>
                                                        <th>Mill Levy Category</th>                        
                                                        <th>CDE Preliminary Mill Levy</th>              
                                                        <th>Voter Approved Dollar Amounts</th>
                                                        <th>District Certified Final Mill </th>
                                                    </tr>
                                                </thead>                                                
                                                <tbody>
                                                    <tr id="millLevyTotalProgram" id="row1">
                                                        <td class="col1" WIDTH="250">1.  Total Program</td>
                                                        <td class="col2" colspan="2"><form:input id="calcTotalProgramField" class="floatingPointType" type="text" path="calcTotalProgram" readonly="true"/></td>                        
                                                        <td class="col4"><form:input id="certTotalProgramField" class="floatingPointType" type="text" path="certTotalProgram" readonly="true" /></td>                        
                                                    </tr>
                                                    <tr id="row2">
                                                        <td class="col1">  2.  Categorical Buyout</td>
                                                        <td class="col2" colspan="2"><form:input id="calcCategoricalBuyoutField" class="floatingPointType" type="text" path="calcCategoricalBuyout" readonly="true" /></td>
                                                        <td class="col4"><form:input id="certCategoricalBuyoutField" class="floatingPointType" type="text" path="certCategoricalBuyout" readonly="true" /></td>                        
                                                    </tr>
                                                    <tr id="row3">
                                                        <td class="col1" colspan="3"> 3.  Overrides:</td>                        
                                                    </tr>
                                                    <tr class="row4">
                                                        <td class="col1"><div style="margin-left: 20px;">a.  Voter-approved</div></td>
                                                        <td class="col2"><form:input id="calcVoterApprovedField" class="floatingPointType" type="text" path="calcVoterApproved" readonly="true" /></td>
                                                        <td class="col3"><form:input id="entrVoterApprovedField" class="moneyType" type="text" path="entrVoterApproved" onblur="computeVoterAprroved();certSumLines1Thru4();certSumLines5Thru10();checkAndFormatAmount('entrVoterApprovedField');" /></td>
                                                        <td class="col4"><form:input id="certVoterApprovedField" class="floatingPointType" type="text" path="certVoterApproved" readonly="true" /></td>    
                                                    </tr>
                                                    <tr id="row5">
                                                        <td class="col1"><div style="margin-left: 20px;">b.  Hold harmless</div></td>
                                                        <td class="col2" colspan="2"><form:input id="calcHoldHarmlessField" class="floatingPointType" type="text"  path="calcHoldHarmless" readonly="true" /></td>                        
                                                        <td class="col4"><form:input id="certHoldHarmlessField" class="floatingPointType" type="text" path="certHoldHarmless" readonly="true" /></td> 
                                                    </tr>
                                                    <tr  id="row6">
                                                        <td class="col1"><div style="margin-left: 20px;">c.  Excess hold harmless</div></td>
                                                        <td class="col2" colspan="2"><form:input id="calcExcessHoldField" class="floatingPointType" type="text" path="calcExcessHold" readonly="true"/></td>
                                                        <td class="col4"><form:input id="certExcessHoldField" class="floatingPointType" type="text" path="certExcessHold" readonly="true" /></td> 
                                                    </tr>
                                                    <tr id="row7">
                                                        <td class="col1">4.  Abatement</td>
                                                        <td class="col2" colspan="2"><form:input id="calcAbatementField" class="floatingPointType" type="text" path="calcAbatement" readonly="true" /></td>                        
                                                        <td class="col4"><form:input id="certAbatementField" class="floatingPointType" type="text" path="certAbatement" readonly="true" /></td> 
                                                    </tr>
                                                    <tr  id="row8">
                                                        <td class="col1">5.  Total General Fund</td>
                                                        <td class="col2" colspan="2"><form:input id="calcGeneralFundField" class="floatingPointType" type="text" path="sumLines1Thru4"  readonly="true" /></td>                                                                                
                                                        <td class="col4"><form:input id="certGeneralFundField" class="floatingPointType" type="text" path="certTotal1"  readonly="true"/></td>
                                                    </tr>
                                                    <tr id="row9">
                                                        <td class="col1">6.  Bond Redemption Fund</td>
                                                        <td class="col2"><form:input id="calcBondRedemptionField" class="floatingPointType" type="text" path="calcBondRedemption" readonly="true" /></td>
                                                        <td class="col3"><form:input id="entrBondRedemptionField" class="moneyType" type="text" path="entrBondRedemption" onblur="computeBondRedemption();certSumLines5Thru10();checkAndFormatAmount('entrBondRedemptionField')"/></td>
                                                        <td class="col4"><form:input id="certBondRedemptionField" class="floatingPointType" type="text" path="certBondRedemption"  readonly="true"/></td>
                                                    </tr>
                                                    <tr id="row10">
                                                        <td class="col1">7.  Transportation Fund</td>
                                                        <td class="col2"><form:input id="calcTransportationFundField" class="floatingPointType" type="text" path="calcTransportationFund" readonly="true"/></td>
                                                        <td class="col3"><form:input id="entrTransportationFundField" class="moneyType" type="text" path="entrTransportationFund" onblur="computeTransportationFund();certSumLines5Thru10();checkAndFormatAmount('entrTransportationFundField')"/></td>
                                                        <td class="col4"><form:input id="certTransportationFundField" class="floatingPointType" type="text" path="certTransportationFund" readonly="true" /></td>
                                                    </tr>
                                                    <tr id="row11">
                                                        <td class="col1">8.  Special Building and Technology Fund</td>
                                                        <td class="col2"><form:input id="calcSpecialFundField" class="floatingPointType" type="text" path="calcSpecialFund" readonly="true"/></td>
                                                        <td class="col3"><form:input id="entrSpecialFundField" class="moneyType" type="text" path="entrSpecialFund" onblur="computeTechnologyFund();certSumLines5Thru10();checkAndFormatAmount('entrSpecialFundField')"/></td>
                                                        <td class="col4"><form:input id="certSpecialFundField" class="floatingPointType" type="text" path="certSpecialFund"  readonly="true"/></td>
                                                    </tr>
                                                    <tr id="row12">
                                                        <td class="col1">9.  Full Day Kindergarten Fund</td>
                                                        <td class="col2"><form:input id="calcKindergartenField" class="floatingPointType" type="text" path="calcKindergarten" readonly="true" /></td>
                                                        <td class="col3"><form:input id="entrKindergartenField" class="moneyType" type="text" path="entrKindergarten" onblur="computeFullDayKindergarten();certSumLines5Thru10();checkAndFormatAmount('entrKindergartenField')"/></td>
                                                        <td class="col4"><form:input id="certKindergartenField" class="floatingPointType" type="text" path="certKindergarten" readonly="true" /></td>
                                                    </tr>
                                                    <tr id="row13">
                                                        <td class="col1">10.  Other (Loan, Charter School)</td>
                                                        <td class="col2"><form:input id="calcOther" type="text" class="floatingPointType" path="calcOther" readonly="true" /></td>
                                                        <td class="col3"><form:input id="entrOther" type="text" class="moneyType" path="entrOther" onblur="computeOther();certSumLines5Thru10();checkAndFormatAmount('entrOther')"/></td>
                                                        <td class="col4"><form:input id="certOther" type="text" class="floatingPointType" path="certOther" readonly="true" /></td>
                                                    </tr>
                                                    <tr id="row14">
                                                        <td class="col1">11.  Total</td>
                                                        <td class="col2" colspan="2"><form:input id="sumLines5Thru10Field" class="floatingPointType" type="text" path="sumLines5Thru10" readonly="true" /></td>
                                                        <td class="col4"><form:input id="certTotal2Field" class="floatingPointType" type="text" path="certTotal2" readonly="true" /></td>
                                                    </tr>
                                                    <tr id="row15">
                                                        <td class="col1"><b style="font-size: 14pt; font-weight: bolder; margin-top: 24px; margin-bottom: 24px;">Assessed Valuation</b></td>
                                                        <td class="col2" colspan="2">As of &nbsp; &nbsp; <span id="calcAssessedValuationDateField" style="font-size: 12pt; font-weight: bolder;"><fmt:formatDate pattern="MM/dd/yyyy" value="${pageInfo.calcAssessedValuationDate}" /></span> </td>
                                                        <td class="col4">As of &nbsp; &nbsp; <span id="certAssessedValuationDateField" style="font-size: 12pt; font-weight: bolder;"><fmt:formatDate pattern="MM/dd/yyyy" value="${pageInfo.certAssessedValuationDate}" /> </span></td>                        
                                                    </tr>
                                                    <tr id="row16">
                                                        <td class="col1"><div style="margin-left: 20px;">Gross Assessed Valuation</div></td>
                                                        <td class="col2" colspan="2"><form:input id="calcGrossAssessedField" class="moneyType" type="text" path="calcGrossAssessed"  readonly="true"/></td>
                                                        <td class="col4"><form:input id="entrGrossAssessedField" class="moneyType" type="text" path="entrGrossAssessed" onblur="recomputeNetAssessedValuation();recomputeAll();checkAndFormatAmount('entrGrossAssessedField')"/></td>
                                                    </tr>
                                                    <tr id="row17">
                                                        <td class="col1"><div style="margin-left: 20px;">Tax Increment Financing</div></td>
                                                        <td class="col2" colspan="2"><form:input id="calcTaxIncreamentField" class="moneyType" type="text" path="calcTaxIncreament" readonly="true" /></td>
                                                        <td class="col4"><form:input id="entrTaxincreamentField" class="moneyType" type="text" path="entrTaxincreament" onblur="recomputeNetAssessedValuation();recomputeAll();checkAndFormatAmount('entrTaxincreamentField')"/></td>
                                                    </tr>
                                                    <tr  id="row18">
                                                        <td class="col1"><div style="margin-left: 20px;">Net Assessed Valuation</div></td>
                                                        <td class="col2" colspan="2"><form:input id="calcNetAssessed" class="moneyType" type="text" path="calcNetAssessed" readonly="true" /></td>
                                                        <td class="col4"><form:input id="entrNetAssessedField" class="moneyType" type="text" path="entrNetAssessed" onblur="checkAndFormatAmount('entrNetAssessedField')" readonly="true"/></td>
                                                    </tr>
                                                    <tr id="row19">
                                                        <td class="col1"><div style="margin-left: 20px;">Abatements (Total across all counties)</div></td>
                                                        <td class="col2" colspan="2"><form:input id="calcAssessedAbatementField" class="moneyType" type="text" path="calcAssessedAbatement" readonly="true"/></td>
                                                        <td class="col4"><form:input id="entrAssessedAbatementField" class="moneyType" type="text" path="entrAssessedAbatement" onblur=" computeAbatement();certSumLines1Thru4();certSumLines5Thru10();checkAndFormatAmount('entrAssessedAbatementField')"/></td>
                                                    </tr>                    
                                                    <tr  id="row20">
                                                        <td class="col1" colspan="3"><b style="font-size: 14pt; font-weight: bolder; margin-top: 24px; margin-bottom: 24px;"> Information for certification to county treasurer: </b></td>                        
                                                    </tr>
                                                    <tr  id="row21">
                                                        <td class="col1"><div style="margin-left: 20px;">Full Funding mill levy</div></td>
                                                        <td class="col2" colspan="2"><form:input id="calcMillLevyField" class="floatingPointType" type="text" path="calcMillLevy" readonly="true" /></td>
                                                        <td class="col4"><form:input id="entrMillLevyField" class="floatingPointType" type="text" path="entrMillLevy" onblur="checkAndFormatAmount('entrMillLevyField')" readonly="true" /></td>
                                                    </tr>
                                                    <tr  id="row22">
                                                        <td class="col1"><div style="margin-left: 20px;">Funding received from state</div></td>
                                                        <td class="col2"  colspan="2"><form:input id="calcStateFundingField" class="moneyType" type="text" path="calcStateFunding" readonly="true" /></td>
                                                        <td class="col4"><form:input id="entrStateFundingField" class="moneyType" type="text" path="entrStateFunding" onblur="checkAndFormatAmount('entrStateFundingField')" readonly="true" /></td>
                                                    </tr>


                                                </tbody>
                                            </table>
                                        </div>
                                    </TD>
                                </TR>
                                <TR>
                                    <TD>&nbsp;&nbsp;</TD>
                                </TR>
                                <TR>  
                                    <td></td>                                    
                                    <TD colspan="2"><input type="Submit" id="approveMilllevy" value="Approve as Final" onclick='$("form").attr("action", "${pageContext.request.contextPath}/secure/MillLevyCert/save"); return true;'/></TD>
                                    <TD colspan="2" align="center"><input type="Button" id="viewMillLevy"   value="View Report" /></TD>
                                </TR>
                            </table>
                        </div>

                    </TD>
                </TR>
            </TABLE>
        </div>                                              

    </form:form>
</div>
<script type="text/javascript"
src="${pageContext.request.contextPath}/static/scripts/screen/MillLevyCert.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>