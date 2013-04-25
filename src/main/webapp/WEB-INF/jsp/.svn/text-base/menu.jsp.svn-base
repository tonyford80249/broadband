
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<%
	String userName = (String) session.getAttribute("userName");
		String userType = "stateEqualUser";
		if (userName != null && "districtUser".equals(userName))
			userType = "districtUser";
%>

<div id="menuContent">
	<table>
		<tr>
			
			<td>
				<ul id="nav">
					<%
						if ("stateEqualUser".equals(userType)) {
					%>
					<li><a href="#">State Equal Options</a>
						<ul>
							<li><a href="${pageContext.request.contextPath}/secure/MaintainCalculationRules">Maintain Calculation Rules</a></li>
							<li><a href="${pageContext.request.contextPath}/secure/UploadVariables">Variables
									and Adjustments</a></li>
							<li><a href="${pageContext.request.contextPath}/secure/CalculateEntitlements">Calculate
									Entitlements</a></li>
							<li><a href="${pageContext.request.contextPath}/secure/Reports">Reports</a></li>
                                                        
                                                        <li><a href="${pageContext.request.contextPath}/secure/AltAtRiskFunding">Alternate At Risk Funding Calculation</a></li>
						</ul>
					</li>
					<% } else  { %>

					<li><a href="#">District Options</a>
						<ul>
							<li><a href="${pageContext.request.contextPath}/secure/MillLevyCert">Mill Levy
									Certification</a></li>
							<li><a href="${pageContext.request.contextPath}/secure/MillLevyOverrideWorksheet">Override
									Limit Calculation Worksheet</a></li>
							<li><a href="${pageContext.request.contextPath}/secure/AltAtRiskFunding">Alternate At Risk
									Calculations</a></li>
							<li><a href="${pageContext.request.contextPath}/secure/Elections">Election
									Reporting/Issues</a></li>
						</ul>
					</li>
					<% } %>
				</ul>
			</td>
		</tr>
	</table>
</div>
