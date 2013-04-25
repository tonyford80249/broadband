
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	/* sfHover = function() {
		var sfEls = document.getElementById("nav").getElementsByTagName("li");
		for ( var i = 0; i < sfEls.length; i++) {
			sfEls[i].onmouseover = function() {
				this.className += " sfhover";
			}
			sfEls[i].onmouseout = function() {
				this.className = this.className.replace(new RegExp(
						" sfhover\\b"), "");
			}
		}
	}
	if (window.attachEvent)
		window.attachEvent("onload", sfHover);*/
</script>
<%
	String userName = (String) session.getAttribute("userName");
		String userType = "stateEqualUser";
		if (userName != null && "districtUser".equals(userName))
			userType = "districtUser";
%>

<%@include file="/WEB-INF/jsp/JspTry.inc"%>
<div id="topNavbar" class='navBar'>
	<ul>
		<li><a href="#" class="cdehome"><span>State&nbsp;Equal&nbsp;Options</span></a>
		<%
			if ("stateEqualUser".equals(userType)) {
		%>
			<ul class="bottom-radius10">
			         
				    <li><c:url value="Maintain Calculation Rules" var="link"/>
				         <a id="" href="${pageContext.request.contextPath}/secure/MaintainCalculationRules"><span>Maintain Calculation Rules</span></a>
				     </li>
				    <li>
				    <c:url value="Variables and Adjustments" var="link"/>
				    <a id="" href="${pageContext.request.contextPath}/secure/UploadVariables"><span>Variables and Adjustments</span></a></li>
					<li>
					<c:url value="Calculate Entitlements"  var="link"/>
					<a id="" href="${pageContext.request.contextPath}/secure/CalculateEntitlements"><span>Calculate Entitlements</span></a>
					</li>
					<li>
					<c:url value="Add Adjustments"  var="link"/> 
					<a id="" href="${pageContext.request.contextPath}/secure/AddAdjustment"><span>Add/Edit Adjustments</a>
					</li>
					<li>
					<c:url value="View Adjustments"  var="link"/> 
					<a id="" href="${pageContext.request.contextPath}/secure/DisplayAdjustment"><span>View Adjustments</a>
					</li>
					<li>
					 <c:url value="Reports" var="link"/>
					<a id="" href="${pageContext.request.contextPath}/secure/Reports"><span>Reports</span></a>
					</li>
			</ul><!-- bottom-radius10 -->
		</li>
	</ul>
	<% } %>
	<ul>
		<li><a href="#" class="cdehome"><span>District Options</span></a>
			<ul class="bottom-radius10" >
					<li><a 	href="${pageContext.request.contextPath}/secure/MillLevyCert"><span>Mill Levy Certification</span></a></li>
					<li><a	href="${pageContext.request.contextPath}/secure/MillLevyOverrideWorksheet"><span>Override	Limit Calculation Worksheet</span></a></li>
					<li><a  href="${pageContext.request.contextPath}/secure/AltAtRiskFunding"><span>Alternate At Risk Calculations</span></a></li>
					<li><a  href="${pageContext.request.contextPath}/secure/Elections"><span>Election Issues</span></a></li>
			</ul>
		</li>
	</ul>
</div>

<%@include file="/WEB-INF/jsp/JspCatch.inc"%>
