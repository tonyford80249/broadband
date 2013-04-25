
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


<div id="mainContent">
    <form:form commandName="pageInfo"
               action="${pageContext.request.contextPath}/secure/Reports/generate"
               method="post">
        <input type="hidden" name="rowKey" id="rowKey" />


        <!-- Main outer table -->
        <p id="adjustmentFormInstructions">
        <h3>&nbsp;&nbsp;&nbsp;&nbsp;Reports</h3>
    </p>
    <div class="formBlock boxShadow3 radius10">
    <table>      
        <c:if test="${errors != null}">
            <tr>
                <td>
                    
                    <ul> 
                        <c:forEach var="error" items="${errors.allErrors}"> 
                            <div style="color:red; font-weight: bold">  
                                <c:out value="${error.defaultMessage}"/>
                            </div>
                        </c:forEach> 
                    </ul> 
               
                </td>
            </tr>        
        </c:if>   
        <tr>

            <td align="left"><b>Generate monthly reports for processing
                    date:</b></td>
            <td align="left">
                <form:select id="months" path="month">
                    <form:option value="NONE" label="-- Choose Month --" />
                    <form:options items="${pageInfo.availableMonths}"></form:options>
                </form:select>
            </td>
            <td align="left">
                <form:select id="years" path="year">
                    <form:option value="NONE" label="-- Choose Year --" />
                    <form:options items="${pageInfo.availableYears}"></form:options>
                </form:select>                                    
            </td>
        </tr>
    </table>
    </div>
    <table>
        <h3>
            <tr align="left">

                <td><h3>Select</h3></td>
                <td><h3>Report Name</h3></td>
                <td><h3>Description</h3></td>
                <td><h3>District Code&nbsp;&nbsp;&nbsp;&nbsp;</h3></td>
                </td>

            </tr>
        </h3>

        <c:forEach items="${pageInfo.availableReports}" var="report">                                                    
            <tr>
                <td align="left">
                    <input id="checkboxFor${report.reportId}" type="checkbox" name="reports" value="${report.reportId}"></input>
                </td>
                <td><a id="linkFor${report.reportId}"><c:out value="${report.reportName}" /></a></td>
                <td><c:out value="${report.reportDescription}" /></td>

                <c:if test="${report.districtSelectionEnabled}">                                                                    
                    <td>
                        <form:select id="districtNumberFor${report.reportId}" path="${report.reportId}DistrictNumber">
                            <form:option value="NONE" label="-- Select --" />
                            <form:options items="${districtNumbers}"></form:options>
                        </form:select>

                    </td>
                </c:if>
                <c:if test="${report.extraMonthSelectionEnabled}">                                                                    
                    <td>
                       <form:select id="anotherMonth" path="extraMonth">
                          <form:option value="NONE" label="-- Choose Month --" />
                          <form:options items="${pageInfo.availableMonths}"></form:options>
                       </form:select>
                    </td>
                </c:if>

                    

            </tr>
        </c:forEach>


        <tr>
            <td align="right" colspan="12"><h4>
                    <b> 
                        <input type="Submit" id="generateReports" onclick='$("form").attr("action", "${pageContext.request.contextPath}/secure/Reports/generate"); return true;' value="Generate Reports"/>
                        <input type="Submit" id="viewReport"  onclick='$("form").attr("action", "${pageContext.request.contextPath}/secure/ViewReports/viewany");'  value="View Reports"/>
                        <input type="Submit" id="generateAndViewReport"  onclick='$("form").attr("action", "${pageContext.request.contextPath}/secure/Reports/print");'  value="Generate & View Report"/>                        
                    </b>
                </h4></td>

        </tr>

    </table>
</form:form>
</div>
<script type="text/javascript"
src="${pageContext.request.contextPath}/static/scripts/screen/Reports.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>