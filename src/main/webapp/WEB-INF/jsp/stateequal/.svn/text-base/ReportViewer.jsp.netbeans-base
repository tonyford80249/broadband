<%-- 
    Document   : ReportViewer
    Created on : Nov 23, 2012, 8:41:16 AM
    Author     : Tony Ford
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
               action="${pageContext.request.contextPath}/secure/ViewReports/viewer"
               method="post">

        <div id="rptSelect">

            <h1>View Monthly Reports</h1>

            <div class="formBlock boxShadow3 radius10">
                <span>
                    <form:select id="years" path="year">
                        <form:option value="NONE" label="-- Choose Year --" />
                        <form:options items="${pageInfo.availableYears}"></form:options>
                    </form:select>
                </span>
                <span>
                    <form:select id="months" path="month">
                        <form:option value="NONE" label="-- Choose Month --" />
                        <form:options items="${pageInfo.availableMonths}"></form:options>
                    </form:select> 
                </span>
                <span>
                    <form:select id="rptType" path="reportType">
                        <form:option value="NONE" label="-- Choose Report Type--" />
                        <form:options items="${pageInfo.reportTypes}"></form:options>
                    </form:select>
                </span>                
                <span>
                    <input id="viewReports" type="Submit" onclick='$("form").attr("action", "${pageContext.request.contextPath}/secure/ViewReports/viewer");' value="View Reports" />
                </span>
            </div>
        </div>
        <div id="rptHeader">
            <h3>Generated Reports Ready For Viewing, Upload and Printing</h3>
        </div>
        <div style="margin : 25px;">
            <input type="Button" onclick="$('input.report').prop('checked', true);" value="Sellect All"/>
            <input type="Button" onclick="$('input.report').prop('checked', false);" value="Unselect All" />
        </div>
        <div id="rptListing"  class="formBlock boxShadow3 radius10" style="margin : 25px; height: 250px; width: 1100px;">
            <div style="margin : 25px; height: 200px; width: 1000px; overflow: auto;">            
            <table cellpadding="8" cellspacing="0" border="0">
                <thead>
                    <tr>
                        <th colspan="2">Column(1)</th>
                        <th colspan="2">Column(2)</th>
                        <th colspan="2">Column(3)</th>
                        <th colspan="2">Column(4)</th>
                        <th colspan="2">Column(5)</th>
                        <th colspan="2">Column(6)</th>
                        <th colspan="2">Column(7)</th>
                        <th colspan="2">Column(8)</th>                        
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th colspan="2">Column(1)</th>
                        <th colspan="2">Column(2)</th>
                        <th colspan="2">Column(3)</th>
                        <th colspan="2">Column(4)</th>
                        <th colspan="2">Column(5)</th>
                        <th colspan="2">Column(6)</th>
                        <th colspan="2">Column(7)</th>
                        <th colspan="2">Column(8)</th>                      
                    </tr>
                </tfoot>
                <tbody>
                    <c:forEach items="${pageInfo.generatedReports}" var="report">
                        <c:if test="${report.sequence % 8 == 0}" >
                            <c:if test="${report.sequence > 0}">
                                </tr>
                            </c:if> 
                            <tr class="rptRow">
                        </c:if>
                        <c:choose>
                            <c:when test="${report.published}">
                                <td><input id="view${report.id}" class="publishedreport" type="checkbox" name="reports" value="${report.id}" disabled /></td> <td> <a href="${pageContext.request.contextPath}${report.url}">  <c:out value="${report.name}" /> </a>  </td>        
                            </c:when>
                            <c:otherwise>
                                <td><input id="view${report.id}" class="report" type="checkbox" name="reports" value="${report.id}"/></td> <td> <a href="${pageContext.request.contextPath}${report.url}">  <c:out value="${report.name}" /> </a>  </td>       
                            </c:otherwise>
                        </c:choose>        
                                
                    </c:forEach>
                    <c:if test="${not empty pageInfo.generatedReports}">
                        </tr>                               
                    </c:if>                                 
                </tbody>      
            </table>
            </div>     
        </div>
        <div style="margin : 25px; alignment-adjust: central">            
            <input type="Submit" onclick='$("form").attr("action", "${pageContext.request.contextPath}/secure/ViewReports/upload");' value="Publish Report(s) to CDE Website" />                         
        </div>
    </form:form>
</div>

<script type="text/javascript"
src="${pageContext.request.contextPath}/static/scripts/screen/Reports.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>