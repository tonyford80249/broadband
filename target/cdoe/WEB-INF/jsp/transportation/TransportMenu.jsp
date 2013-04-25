
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
<%@ page import="com.cdoe.util.UserInfo" %>


<script type="text/javascript">
	/** sfHover = function() {
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
		window.attachEvent("onload", sfHover);*/
</script>
<%
	UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");
	Boolean isCapitalOutlay = (Boolean) session.getAttribute("isCapitalOutlay");
%>


<%-- Wrap the entire JSP in a try/catch block so that runtime exceptions
    in the JSP can be caught and reported. --%>
<%@include file="/WEB-INF/jsp/JspTry.inc"%>
	<div id="topNavbar" class='navBar'>
		<ul>
			<li>
			  <a href="#" class="cdehome"><span>Transportation&nbsp;Home</span></a>
			  <ul class="bottom-radius10">
				<li>
				   <c:url value="CDE-40 Transportation Reimbursement Form" var="link"/>
                     <a id="" href="Cde40TransReimbForm"><span>CDE-40 Transportation Reimbursement Form</span></a>
                </li>  
                <% if (isCapitalOutlay != null && isCapitalOutlay) {
                 %> 
                 <li>
                   <c:url value="COFRS Upload" var="link"/>
                   <a id="" href="${pageContext.request.contextPath}/secure/CapitalOutlay"><span>Capital Outlay</span></a>
                </li> 
                <% } %>   
                <% 
				  if (userInfo.isTransportationUser() && userInfo.isAdminUser()) { 
				 %>          				
				<li>
                   <c:url value="Distribution Amounts" var="link"/>
                   <a id="" href="${pageContext.request.contextPath}/secure/DistributionAmounts"><span>Distribution Amounts</span></a>
                </li>           
				<li>
                   <c:url value="District Payment Report" var="link"/>
                   <a id="" href="${pageContext.request.contextPath}/secure/DistrictPaymentReport"><span>District Payment Report</span></a>
                </li>           
				<li>
                   <c:url value="COFRS Upload" var="link"/>
                   <a id="" href="${pageContext.request.contextPath}/secure/CoforsUpload"><span>COFRS Upload</span></a>
                </li>           
				<li>
                   <c:url value="CDE-40 Summary" var="link"/>
                   <a id="" href="${pageContext.request.contextPath}/secure/Cde40Summary"><span>CDE-40 Summary</span></a>
                </li>
				<li>
                   <c:url value="Calculation Worksheet" var="link"/>
                   <a id="" href="${pageContext.request.contextPath}/secure/PaymentWorkSheet"><span>Payment Calculation Worksheet</span></a>
                </li>
                <% } %>
			  </ul><!-- bottom-radius10 -->
			</li>
		</ul>
	</div>

  
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>