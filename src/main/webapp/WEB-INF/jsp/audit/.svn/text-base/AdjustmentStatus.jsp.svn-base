
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
<%
	ArrayList<String[]> iData = new ArrayList<String[]>();
		String[] a = { "2010-2011",
				"Audit adjustments entered 08/10/2012" };
		iData.add(0, a);
		String[] b = { "2009-2010", "No audit adjustments found" };
		iData.add(0, b);
		String[] c = { "2008-2009", "Audit adjustment needed" };
		iData.add(0, c);
%>
<form:form commandName="auditSasidExceptionForm"
	action="${pageContext.request.contextPath}/secure/AdjustmentStatus/save"
	method="post">

	<!-- Main outer table -->
	<h3>Audit Adjustment Status</h3>
	<TABLE>
		<TR>
			<TD>
				<div class="formBlock boxShadow3 radius10">
				<TABLE>

					<TR>
						<TD><LABEL FOR="">Organization Code</LABEL></TD>
						<TD><form:input id="" path=""  value="1040"/> <form:errors path="" /></td>

						<TD><LABEL FOR="">Organization Name</LABEL></TD>
						<TD><form:input id="" path="" value = "Academy 24"/> <form:errors path="" /></td>
					</tr>
				</table>
				</div>
			</TD>
		</TR>
	</TABLE>
	</br>
	<TABLE>
		<TR>
		    <TD width="12%"><h3>Fiscal Year</h3></TD>
			<TD width="24%"><h3>State Equal Audit Required?</h3></TD>
			<TD width="24%"><h3>Adjustment Status</h3></TD>
			<TD width="16%"><h3>Status Date Time</h3></TD>
			<TD width="27%" colspan="2"><h3>Actions</h3></TD>
		</TR>

		<%
			int length = iData.size();
					for (int i = length - 1; i >= 0; i--) {
		%>
		<tr>
		    <td width="12%"><%=(iData.get(i))[0]%></td>
			<TD width="26%">
				<TABLE>
					<tr>
						<td align="left"><input type="radio" name="selectNo" + <%=i%>></input></td>
						<TD>No</TD>
						<td align="left"><input type="radio" name="selectNo" + <%=i%>></input></td>
						<TD>Yes</TD>
					</tr>
				</TABLE>
			</TD>
			<td width="26%"><%=(iData.get(i))[1]%></td>
			<TD/>
			<TD><input type="button" id="" value="Upload SASIds" /></TD>
			<TD><input type="button" id="" value="Pending Validations" /></TD>
			<TD><input type="button" id="" value="Update Student Exceptions" />
			</TD>
		</TR>
		<%
			}
		%>
	</TABLE>
	<TABLE>
		<TR>
		    <TD width="12%"><h3>Fiscal Year</h3></TD>
			<TD width="24%"><h3>Transportation Audit Required?</h3></TD>
			<TD width="24%"><h3> Adjustment Status</h3></TD>
			<TD width="16%"><h3>Status Date Time</h3></TD>
		
			<TD width="27%" colspan="2"><h3>Actions</h3></TD>
		</TR>
		<%
			length = iData.size();
					for (int i = length - 3; i >= 0; i--) {
		%>
		<tr>
			<td width="12%"><%=(iData.get(i))[0]%></td>
			<TD width="26%">
				<TABLE>
					<tr>
						<td align="left"><input type="radio" name="selectNo" + <%=i%>></input></td>
						<TD>No</TD>
						<td align="left"><input type="radio" name="selectNo" + <%=i%>></input></td>
						<TD>Yes</TD>
					</tr>
				</TABLE>
			</TD>
			
			<td width="26%"><%=(iData.get(i))[1]%></td>
			<TD/>
			<TD><input type="button" id="" value="Upload SASIds" /></TD>
			<TD><input type="button" id="" value="Pending Validations" /></TD>
			<TD><input type="button" id="" value="Update Student Exceptions" />
			</TD>
		</TR>
		<%
			}
		%>
	</TABLE>	
	</br>
	</br>
	<TABLE width="100%">
		<TR>
		    <TD width="40%"/>
			<TD width="60%" align="left"><input type="button" id="" value="Run Reports" /></TD>
		</TR>
	</TABLE>
	</TD>
	</TR>
	</TABLE>
	</br>
	</br>
</form:form>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/AdjustmentStatus.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>