
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
<div id="mainbody">
		<div id="contentarea">
			<div id="pagecontent">

<h2>Generate COFRS Payment Report
</h2>
<form:form commandName="transportationForm" action="${pageContext.request.contextPath}/secure/CoforsUpload/save" method="post">
   <input type="hidden" name="rowKey" id="rowKey"/>
   
  <div class="formBlock boxShadow3 radius10">
	<h3>Upload Information
	</h3>
	<div style='float: left;'>
	  <span class="field" style='width: 100px;'> <LABEL FOR=""><spring:message code="CoforsUpload.StaticText.fiscalYearStaticText" /></LABEL>
      </span>
	  <span class="bodyText" style='width: 350px;'>
		<form:input  id="" path="fiscalYear"   size="8" maxlength="8"/>
	  </span>
	  <br/>
	  <span class="field" style='width: 100px;'><LABEL FOR=""><spring:message code="CoforsUpload.StaticText.batchNumberStaticText" /></LABEL>
      </span>
	  <span class="bodyText" style='width: 350px;'>
         <form:input  id="" path="" />
	  </span>
	  <br/>
	  <span class="field" style='width: 100px;'> <LABEL FOR=""><spring:message code="CoforsUpload.StaticText.monthStaticText" /></LABEL></span>
	  <span class="bodyText" style='width: 350px;'>
		<form:select  id="" 
              path=""  items="${List}" />
	  </span>
      <br/>
	  <span class="field" style='width: 100px;'> <LABEL FOR=""> <LABEL FOR=""><spring:message code="CoforsUpload.StaticText.dateToBePaidStaticText" /></LABEL></span>
	  <span class="bodyText" style='width: 350px;'>
		<form:input  id="" path="" />
	  </span>
	</div>	
	<div style='clear:both;'></div>
  </div>

	<div id="capitalOutlayGrid" class="scrollableArea boxShadow3 radius10">
		<table id="transportationGrid" class="display">
			<thead>
				<tr>
					<th>First Payment</th>
					<th>Organization Name</th>
					<th>District Number</th>
				</tr>
			</thead>
			<tbody>
              		<c:forEach var="transportationGrid" items="${transportationForm.transportationGridList}" varStatus="idx">
              			<tr>

              							<td><form:input path="transportationGridList[${idx.index}].firstPayment"/></td>
              						
              							<td><form:input path="transportationGridList[${idx.index}].organizationName"/></td>
              						
              							<td><form:input path="transportationGridList[${idx.index}].districtNumber"/></td>
              						
              			</tr>
              		</c:forEach>
			</tbody>
		</table>
	</div>  
  
  <div style='text-align: center; margin: 1em 0;'>
	  <span class="field" style='width: 100px;'><LABEL FOR=""><spring:message code="CoforsUpload.StaticText.totalAmountToBePaidStaticText" /></LABEL>
      </span>
	  <span class="bodyText" style='width: 350px;'>
          <form:input  id="" path="" />
	  </span>
  </div>
  
  <div style='text-align: center; margin: 1em 0;'>
     <input type="Submit" id="" value="Confirm Send To COFRS"/>
     <input type="Submit" id="" value="Download to Excel"/> 
  </div>
	
</form:form>
    </div><!-- pagecontent -->
		</div><!-- contentarea -->
	</div><!-- mainbody -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/screen/CoforsUpload.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>