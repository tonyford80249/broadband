
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
<%@ page import="java.util.*" %>
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
		String[] a =  {"Audit", "Audit Counts (31 Grid)"};
		iData.add(0,a);
		String[] b =  {"Worksheet", "Auditor Worksheet (32 Grid)"};
		iData.add(0,b);
		String[] c =  {"Ad Hoc", "Ad Hoc Reports"};
		iData.add(0,c);
		
%>
<div id="mainContent">
<form:form commandName="vDataForm"
	action="${pageContext.request.contextPath}/secure/Reports/save"
	method="post">
	<input type="hidden" name="rowKey" id="rowKey" />


	<!-- Main outer table -->
	<p id="adjustmentFormInstructions"><h3>&nbsp;&nbsp;&nbsp;&nbsp;Reports</h3></p>
	<table>
		<tr>
			<td align="left"><input type="checkbox" name="generateReport"
				value="false" onClick="toggle(this)"> </input><b>Generate All
					Monthly Reports&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>



			<td align="left"><b>For Processing Date:</b></td>
			<td align="left"><select name="beginningFiscalMonth">
					<option>Choose Month/Year</option>
					<option>January</option>
					<option>February</option>
					<option>March</option>
					<option>April</option>
					<option>May</option>
					<option>June</option>
					<option>July</option>
					<option>August</option>
					<option>September</option>
					<option>October</option>
					<option>November</option>
					<option>December</option>
			</select></td>
		</tr>
	</table>
	<table>
		<h3><tr align="left">
				<td/>
					<td><h3>Report	Name</h3></td>
					<td><h3>Description</h3></td>
					<td><h3> District Code&nbsp;&nbsp;&nbsp;&nbsp;</h3></td>
					<td><h3>Fiscal Year</h3>
				</td>

		</tr></h3>
		<%
			int length = iData.size();
					for (int i = 0; i < length; i++) {
		%>
		<tr>
			<td align="left"><input type="radio" name="foo"></input></td>
			<td><%=(iData.get(i))[0]%></td>
			<td><%=(iData.get(i))[1]%></td>
			<td><select name="districtCode">
					<option>Choose District Code</option>
					<option>631 - Arapahoe</option>
					<option>632 - Jefferson</option>
			</select></td>

			<td><select name="beginningFiscalYear">
					<option>Choose Year</option>
					<option>2012</option>
					<option>2013</option>
					<option>2014</option>
					<option>2015</option>
					<option>2016</option>
					<option>2017</option>
					<option>2018</option>
					<option>2019</option>
					<option>2020</option>
					<option>2021</option>
			</select></td>
		</tr>
		<%
			}
		%>

		<tr>
			<td align="right" colspan="12"><h4>
					<b> <a href="reviewAdjustments.htm"><button>Generate
								and View Reports</button></a> &nbsp;&nbsp;&nbsp;&nbsp; <a
						href="reviewAdjustments.htm"><button>Save Reports</button></a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a href="reviewAdjustments.htm"><button>Print
								Reports</button></a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="reviewAdjustments.htm"><button>Publish
								Report(s) to CDE Website</button></a> &nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp; <a href="reviewAdjustments.htm"><button>Cancel</button></a>
					</b>
				</h4></td>

		</tr>

	</table>
</form:form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/Reports.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>