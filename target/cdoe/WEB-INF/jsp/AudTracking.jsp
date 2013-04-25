
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
<%@ page language="java" %>
<%@ page import="com.cdoe.ui.*" %>
<%@ page import="com.cdoe.biz.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- Wrap the entire JSP in a try/catch block so that runtime exceptions
    in the JSP can be caught and reported. --%>
<%@include file="/WEB-INF/jsp/JspTry.inc"%>

<div id="mainContent">
<form:form commandName="auditFpcForm" action="${pageContext.request.contextPath}/secure/AudTracking/save" method="post">


  <!-- Main outer table -->
   <h3><spring:message code="AudTracking.StaticText.auditTrackingAllDistrictsStaticText" /></h3>
  <TABLE>
    <TR>
      <TD>
        <TABLE>
          
          <TR>
            <TD COLSPAN="4">
              <spring:message code="AudTracking.StaticText.searchCriteriaStaticText" />
            </TD>
          </TR>
          <TR>
            <TD ALIGN="right">
              <LABEL FOR=""><spring:message code="AudTracking.StaticText.auditorStaticText" /></LABEL>
            </TD>
            <TD>
              <form:select  id="" 
              path=""  items="${List}" /><form:errors path=""/>

            </TD>
            <TD ALIGN="right">
              <LABEL FOR=""><spring:message code="AudTracking.StaticText.statusStaticText" /></LABEL>
            </TD>
            <TD>
              <form:select  id="" 
              path=""  items="${List}" /><form:errors path=""/>

            </TD>
          </TR>
        </TABLE>
        <TABLE>
          <TR>
            <TD ALIGN="right">
              <LABEL FOR=""><spring:message code="AudTracking.StaticText.districtNameStaticText" /></LABEL>
            </TD>
            <TD>
              <form:select  id="" 
              path="districtNumber"  items="${districtNumberList}" /><form:errors path="districtNumber"/>
            </TD>
            <TD ALIGN="right">
              <LABEL FOR=""><spring:message code="AudTracking.StaticText.districtNumberStaticText" /></LABEL>
            </TD>
            <TD>
              <form:select  id="" 
              path=""  items="${List}" /><form:errors path=""/>

            </TD>
          </TR>
          <TR>
            <TD COLSPAN="4">
              <div id="noNameGrid" align="center" style="border: 5px groove #ccc;">
              	<table id="noNameGrid" class="display">
              		<thead>
              			<tr>
              			</tr>
              		</thead>
              		<tbody>
              		<c:forEach var="noNameGrid" items="${auditFpcForm.noNameGridList}" varStatus="idx">
              			<tr>
              			</tr>
              		</c:forEach>
              		</tbody>
              	</table>
              	<script type="text/javascript">
              	<!--
              	$(document).ready(function() {
              		$("table#noNameGrid").dataTable({
                          "bPaginate": true,
                			"bSort": false,
                			"bFilter": false,
                			"bInfo": false,
                			"bLengthChange": false,
                			"bAutoWidth": false
              		});
              	});
              	//-->
              	</script>	
              </div>
            </TD>
          </TR>
        </TABLE>
        <TABLE>
          <TR>
            <TD>
              <input type="button" id="" value="Print Audit Tracking in Excel format"/>
            </TD>
            <TD>
              <input type="button" id="" value="Print Audit Tracking in PDF format"/>
            </TD>
          </TR>
        </TABLE></TD>
    </TR>
  </TABLE>
</form:form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/screen/AudTracking.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>