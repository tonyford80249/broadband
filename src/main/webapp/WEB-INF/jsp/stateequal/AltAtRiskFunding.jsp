
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
    $(document).ready(
    function() {
        /*
         *  Attached function to dropdown's onchange event.
         *
         */
        $('select#districtNumber')
        .change(
        function() {
            var varDistrictNumber = "";
            $("#messagePanel").html("");
                                                                                        
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
            '${pageContext.request.contextPath}/secure/AltAtRiskFunding/json',
            {
                districtNumber : varDistrictNumber,
                fiscalYear : $(
                'input#fiscalYearId')
                .val()
            },
            function(json) {
                if (json.stateEqualPaymentForm.valid) {

                    $(
                    'input#DistrictName')
                    .val(
                    json.stateEqualPaymentForm.districtName);
																	

                } else {
                    $('input#DistrictName').val(json.stateEqualPaymentForm.districtName);
																	
                }
            })
        })
    })
</script>


<%@include file="/WEB-INF/jsp/JspTry.inc"%>

<c:if test="${errorMessage != null}">
    <div id="messagePanel" style="color:red; font-weight:bold "><c:out value="${errorMessage}" /></div>
</c:if>
<div id="mainbody">
    <div id="contentarea">
        <div id="pagecontent">
            <form:form commandName="stateEqualPaymentForm"
                       action="${pageContext.request.contextPath}/secure/AltAtRiskFunding/report/altatriskcalc.xls"
                       method="post">				
                </br>
                <h3>
                    Alternate At Risk Funding Calculation
                </h3>

                                <!-- Main outer table ${ districtNumber} pupilTran-->
                <div class="formBlock boxShadow3 radius10">
                    <TABLE>                                                
                        <TR>
                            <TD>District Code:&nbsp;&nbsp;&nbsp;&nbsp;</TD>
                            <TD>


                                <c:choose>
                                    <c:when test="${districtNumbers != null}">

                                        <form:select id="districtNumber" path="districtNumber">
                                            <form:option value="NONE" label="-- Select --" />
                                            <form:options items="${districtNumbers}"></form:options>
                                        </form:select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                                    </c:when>
                                    <c:otherwise>
                                        <form:input id="District Number:"
                                                    path="districtNumber" size="12" maxlength="12"
                                                    cssClass="disabled" readonly="true" />
                                    </c:otherwise>
                                </c:choose>
                            </TD>
                            <TD>District Name&nbsp;&nbsp;&nbsp;&nbsp;</TD>
                            <TD><form:input id="DistrictName" path="districtName"
                                        size="26" maxlength="26" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</TD>
                            <TD><spring:message
                                    code="PaymentWorkSheet.StaticText.fiscalYearStaticText" />&nbsp;&nbsp;&nbsp;&nbsp;</TD>
                            <TD><form:input readonly="readonly" id="fiscalYearId" path="fiscalYear" size="8"
                                        maxlength="8" /></TD>
                            <TD><input type="Submit" id="downloadXls" name="download" value="Download Worksheet" /></TD>
                        </TR>

                    </TABLE>
                </div>

            </form:form>
        </div>
    </div>
</div>


<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>