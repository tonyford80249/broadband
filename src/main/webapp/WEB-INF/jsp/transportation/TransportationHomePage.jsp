
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
<%@ page import="com.cdoe.util.UserInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="com.cdoe.util.UserInfo" %>


<%-- Wrap the entire JSP in a try/catch block so that runtime exceptions
    in the JSP can be caught and reported. --%>
<%@include file="/WEB-INF/jsp/JspTry.inc"%>
<style>
.ui-icon { float: left; margin: 5px 10px 0 0; }
ol.menu { margin: 1em 3em; font-size: 1.2em; list-style-type: none; }
ol.menu li { line-height: 1.5em; padding: 0.5em; margin: 0.1em; color: #1C7EAC; }
ol.menu li a { text-decoration: none; color: #1C7EAC; }
ol.menu li a:hover { font-weight: bold; }
</style>
<script type='text/javascript' src='${pageContext.request.contextPath}/static/scripts/jquery/jquery-1.8.2.min.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/static/scripts/jquery/jquery-ui-1.8.24.custom.min.js'></script>
</head>

<%
	UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");
%>

<div id="mainbody">
		<div id="contentarea">
			<div id="pagecontent">
				<h2>Transportation Main Menu</h2>
 
				<ol class='menu'>
				  <li><span class='ui-icon ui-icon-carat-1-e'></span><a href='${pageContext.request.contextPath}/secure/Cde40TransReimbForm'>CDE-40 Transportation Reimbursement Form</a></li>
			     <% 
				  //if (userInfo != null && userInfo.isTransportationUser() && userInfo.isAdminUser()) { 
				 %>     
				  <li><span class='ui-icon ui-icon-carat-1-e'></span><a href="${pageContext.request.contextPath}/secure/DistributionAmounts">Distribution Amounts</a></li>
				  <li><span class='ui-icon ui-icon-carat-1-e'></span><a href="${pageContext.request.contextPath}/secure/DistrictPaymentReport">District Payment Report</a></li>
				  <li><span class='ui-icon ui-icon-carat-1-e'></span><a href="${pageContext.request.contextPath}/secure/CoforsUpload">COFRS Upload</a></li>
				  <li><span class='ui-icon ui-icon-carat-1-e'></span><a href='${pageContext.request.contextPath}/secure/Cde40Summary'>CDE-40 Summary</a></li>
				  <li><span class='ui-icon ui-icon-carat-1-e'></span><a href="${pageContext.request.contextPath}/secure/PaymentWorkSheet">Payment Calculation Worksheet</a></li>
				 <% //} %>
				</ol>
		    </div><!-- pagecontent -->
		</div><!-- contentarea -->
	</div><!-- mainbody -->

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/TransMenu.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>