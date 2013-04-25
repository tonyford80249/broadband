
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%-- Wrap the entire JSP in a try/catch block so that runtime exceptions
    in the JSP can be caught and reported. --%>
<%@include file="/WEB-INF/jsp/JspTry.inc"%>
<div>
	<form:form commandName="calculateEntitlementsForm"
		action="${pageContext.request.contextPath}/secure/CalculateEntitlements/calculateEntitlements"
		method="post">

		<!-- Main outer table -->
		<h2>
			<fmt:message
				key="CalculateEntitlements.StaticText.calculateDistrictEntitlementsMonthlyMidYearEndOfYearStaticText" />
		</h2>
		<TABLE>
			<TR>
				<TD>
					<div class="formBlock boxShadow3 radius10">
						<TABLE>
							<TR>
								<TD ALIGN="right"><LABEL FOR=""><fmt:message
											key="CalculateEntitlements.StaticText.fiscalYearStaticText" /></LABEL>
								</TD>
								<TD><form:select id="fiscalYearList" path="fiscalYear"
										size="1">
										<form:option value="NONE" label="-- Select --" />
										<form:options items="${fiscalYearList}"></form:options>
										<font color="red"><b>*</b></font>
									</form:select></TD>
								<TD>
								<TD ALIGN="right"><LABEL FOR=""><fmt:message
											key="CalculateEntitlements.StaticText.monthStaticText" /></LABEL></TD>
								<TD><form:select class="list.requiredControl"
										id="fiscalMonthList" path="fiscalMonth" size="1">
										<form:option value="NONE" label="-- Select --" />
										<form:options items="${fiscalMonthList}" />
										<font color="red"><b>*</b></font>
									</form:select></TD>
							</TR>
							<TR>
								
							</TR>
							<TR>
							<TD ><LABEL FOR="">Choose Calculation Type</LABEL>
							</TD>
							<TD><form:select Class="list.requiredControl" id="calculationTypeDropdownList" path="calculationType"
									items="${calculationTypeDropdownList}" size="1">
									<form:option value="NONE" label="-- Select --" />
									<form:options items="${calculationTypeDropdownList}" />
								</form:select>
								<font color="red"></font> 
							</TD>
						</TR>
						</TABLE>
					</div>
					<TABLE>
						<TR>
							<TD><input type="Submit" id="calculate" name="viewReportButton"
								value="Calculate" />
							</TD>
							<TD><input type="Submit" id="" name="saveButton"
								value="Approve/Save" />
							</TD>
							<TD><input type="reset" id="" name="restoreButton"
								value="Restore" />
							</TD>
						</TR>
					</TABLE>
					<font color="red"><c:out id="Message" value="${calculateEntitlementsForm.message}"/></font>
				</TD>
			</TR>
		</TABLE>
	</form:form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/CalculateEntitlements.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>