<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.cdoe.util.*"%>

<%
	String formattedDate = DateUtil
			.getFormattedDate("EEEE, MMMM dd, yyyy");

	String userName = (String) session.getAttribute("userName");
	if ( userName == null || "".equals( userName))
		userName = "default Username";
		
	String screenName = request.getParameter("pageName");
	System.out.println("screenName" +  screenName);
	
	boolean homePage = false;
	
	if ("StateEqual".equalsIgnoreCase(screenName) ||
	    "Transportation".equalsIgnoreCase(screenName) ||
	    "Auditor".equalsIgnoreCase(screenName))
	    homePage=true;
%>

<div id="header">
	<table>
		<tr>
			<td><img
				src="${pageContext.request.contextPath}/static/images/cdelogo.png" /></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td align="center"><h2>Transportation</h2></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td align="left">
				<table>
					<tr>
						<td><font size="3"><a href="TransMenu"><b>Home</b></a></font></td>
						<td><font size="3"><a href="TransMenu"><b>(Transportation Menu)</b></a></font></td>
                    </tr>
                    <% if (homePage) { %> 
                    <tr>
						<td><font size="3"> <a href="home.htm"><b>Home</b></a></font></td>
						<td><font size="3" color="blue"> <a href="home.htm">
									(Go to Main Menu)</a></font></td>
						<td></td>
					</tr>
                    <% } %>
					<tr>
						<td><font size="3"> <a href="SSOLogin"><b>Logout</b></a></font></td>
						<td></td>
					</tr>
					<tr>
						<td><font size="3"><b> Date:</b></font></td>
						<td colspan="3"><font size="3" color="blue"><%=formattedDate%></font></td>
					</tr>
					<tr>
						<td><font size="3"><b> User&nbsp;Name: </b></font></td>
						<td colspan="3"><font size="3" color="blue"><%=userName%></font></td>
					</tr>
				</table>
			</td>
	</table>
</div>
