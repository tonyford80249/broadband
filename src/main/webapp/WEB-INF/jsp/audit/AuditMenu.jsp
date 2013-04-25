
<%--
(ref: jsp/jsp.jsp.et.jsp)
-------------------------------------
$Revision:1.0   $
$Date:  $
$Author:Sandeep Sarkar   $
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


<script type="text/javascript">
	sfHover = function() {
		var sfEls = document.getElementById("nav").getElementsByTagName("li");
		for ( var i = 0; i < sfEls.length; i++) {
			sfEls[i].onmouseover = function() {
				this.className += " sfhover";
			}
			sfEls[i].onmouseout = function() {
				this.className = this.className.replace(new RegExp(" sfhover\\b"), "");
			}
		}
	}
	if (window.attachEvent)
		window.attachEvent("onload", sfHover);
</script>


<%-- Wrap the entire JSP in a try/catch block so that runtime exceptions
    in the JSP can be caught and reported. --%>
<%@include file="/WEB-INF/jsp/JspTry.inc"%>

<%
	String userName = (String) session.getAttribute("userName");
		String userType = "stateEqualUser";
		if (userName != null && "districtUser".equals(userName))
			userType = "districtUser";
%>

	<div id="topNavbar" class='navBar'>
				<ul>
					<li><a href="#">Audits</a>
						<ul>
							<!-- li><a href="rulesMenu.htm">Import Audited Transportation Data</a></li-->
						    <li><a href="${pageContext.request.contextPath}/secure/AuditorHomePage">Audit Home</a></li>
							<li><a href="${pageContext.request.contextPath}/secure/AuditTracking">Audit Tracking</a></li>
							<li><a href="${pageContext.request.contextPath}/secure/DistrictAuditHistory">District Audit History</a></li>
							<li><a href="${pageContext.request.contextPath}/secure/CreateAudit">Create Audit </a></li>
							<li><a href="${pageContext.request.contextPath}/secure/AuditSummary">Audit Summary</a></li>
							<li><a href="${pageContext.request.contextPath}/secure/AudSumUpdate">Audit Summary Update</a></li>
						</ul>
					</li>
					<li></li>
					<li><a href="#">Data</a>
						<ul>
							<!-- li><a href="rulesMenu.htm">Import Audited Transportation Data</a></li-->
						    <li><a href="${pageContext.request.contextPath}/secure/DistrictInformation">District Information</a></li>
						    <li><a href="${pageContext.request.contextPath}/secure/AdjustmentStatus">Adjustment Status</a></li>
						    <li><a href="${pageContext.request.contextPath}/secure/UploadStudents">Upload Students</a></li>
						    <li><a href="${pageContext.request.contextPath}/secure/ValidateSASIDs">Validate SASIDs</a></li>
						    <li><a href="${pageContext.request.contextPath}/secure/UpdateStudents">Update Students</a></li>
							<li><a href="${pageContext.request.contextPath}/secure/ChangeBilling">Change Billing</a></li>
							<li><a href="${pageContext.request.contextPath}/secure/ChangeELPA">Change ELPA</a></li>
							<li><a href="${pageContext.request.contextPath}/secure/AudCDE40TransReimbForm.">Change Transportation data</a></li>
						</ul>
					</li>
					<li></li>
					<li><a href="#">Reports</a>
						<ul>
						<li><a href="${pageContext.request.contextPath}/secure/ChangeELPA">Audit Counts (31 Grid)</a></li>
						<li><a href="${pageContext.request.contextPath}/secure/ChangeELPA">Auditor Worksheet(32 Grid)</a></li>
						<li><a href="${pageContext.request.contextPath}/secure/ChangeELPA">Ad Hoc Reports</a></li>
						</ul>
					</li>
				</ul>
</div>
  
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>