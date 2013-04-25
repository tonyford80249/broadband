
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
	<form:form commandName="crosswalkCollectionForm"
		action="${pageContext.request.contextPath}/secure/CrosswalkCollectionData/upload"
		method="post">

		<!-- Main outer table -->
		<h3>
			<spring:message
				code="CrosswalkCollectionData.StaticText.crosswalkCollectionDataStaticText" />
		</h3>
		<TABLE>
			<TR>
				<TD><font color="red"><c:out id="Message"
							value="${crosswalkCollectionForm.message}" /></font>
					<div class="formBlock boxShadow3 radius10">
						<TABLE>


							<TR>
								<TD><LABEL FOR="FiscalYear"><spring:message
											code="CrosswalkCollectionData.StaticText.fiscalYearStaticText" /></LABEL>
								</TD>
								<TD><form:select cssClass="requiredControl" id="FiscalYear"
										path="fiscalYear" items="${fiscalYearList}" /><font
									color="red"><b>*</b></font></TD>
							</TR>
							<TR />
							<TR>
								<TD><LABEL FOR=""><spring:message
											code="CrosswalkCollectionData.StaticText.collectionTypeStaticText" /></LABEL>
								</TD>
								<TD><form:select cssClass="requiredControl"
										id="collectionType" path="collectionType"
										items="${collectionTypeList}" /><font color="red"><b>*</b></font>
								</TD>
							</TR>
							<TR />
							<TR>
								<TD><input type="submit" id="view" name="view"
									value="View Proposed Import" style="width: 241px;" /></TD>
								<TD><input type="submit" id="save" name="save"
									value="Save Data" />
								<TD><input type="submit" id="cancel" name="cancel"
									value="<spring:message code="CrosswalkCollectionData.Button.cancelButton" />" />
								</TD>
							</TR>
						</TABLE>
					</div></TD>
			</TR>
		</TABLE>
		<div id="crossWalkDataGrid" align="center"
			class="formBlock boxShadow3 radius10">
			<table id="crossWalkDataTable" class="display">
				<thead>
					<tr>
						<c:forEach var="headerCol"
							items="${crosswalkCollectionForm.crossWalkDataGrid.columnHeaders}">
							<th><c:out value="${headerCol}" /></th>
						</c:forEach>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="varRow"
						items="${crosswalkCollectionForm.crossWalkDataGrid.rowStringGrid}">
						<tr>
							<!-- td><c:out value="${varRow.key}" /></td -->
							<c:forEach var="varCol" items="${varRow.value}" varStatus="idx">
								<c:choose>
									<c:when test="${!fn:containsIgnoreCase(varCol, '.')}">
										<!-- c:when test="${fn:containsIgnoreCase(varCol, 'K') || fn:containsIgnoreCase(varCol, 'C') 
												|| fn:containsIgnoreCase(varCol, 'T') || fn:containsIgnoreCase(varCol, 'P') ||
												!fn:containsIgnoreCase(varCol, '.')}"-->

										<td align="right"><c:out value="${varCol}" /></td>
									</c:when>
									<c:otherwise>
										<td align="right"><fmt:formatNumber type="number"
												pattern="###,###,##0.0" value="${varCol}" /></td>
									</c:otherwise>
								</c:choose>

							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:choose>
			<c:when test="${fn:containsIgnoreCase(crosswalkCollectionForm.collectionType, 'Student October') 
							|| fn:containsIgnoreCase(crosswalkCollectionForm.collectionType, 'CSI')}">
				<script type="text/javascript">
					$(document).ready(function() {
						$("table#crossWalkDataTable").dataTable({
							"bPaginate" : false,
							"bSort" : true,
							"sScrollY" : 240,
							"sScrollX" : 1120,
							"bFilter" : true,
							"bInfo" : true,
							"bLengthChange" : false,
							"bAutoWidth" : false
						});
					});
				</script>
				</c:when>
				<c:otherwise>
					<script type="text/javascript">
					$(document).ready(function() {
						$("table#crossWalkDataTable").dataTable({
							"bPaginate" : false,
							"bSort" : true,
							"sScrollY" : 240,
							"sScrollX" : 620,
							"bFilter" : true,
							"bInfo" : true,
							"bLengthChange" : false,
							"bAutoWidth" : false
						});
					});
				</script>
				</c:otherwise>
			</c:choose>
			<TABLE>
			<TR>
			   
				<TD><c:choose>
						<c:when test="${fn:containsIgnoreCase(crosswalkCollectionForm.collectionType, 'Student October')}">
							<input type="Button" id="downLoadToExcel"
							name="downLoadToExcel"
							onclick="window.open('${pageContext.request.contextPath}/dynamic/report/fteByGradeUpload.xls?fiscalYear=${crosswalkCollectionForm.fiscalYear}');"
							value="Download this Report to Excel" />
						</c:when>
						<c:when test="${fn:containsIgnoreCase(crosswalkCollectionForm.collectionType, 'Ascent')}">
						    <input type="Button" id="downLoadToExcel"
							name="downLoadToExcel"
							onclick="window.open('${pageContext.request.contextPath}/dynamic/report/ascentTotalUpload.xls?fiscalYear=${crosswalkCollectionForm.fiscalYear}');"
							value="Download this Report to Excel" />
						</c:when>
						<c:when test="${fn:containsIgnoreCase(crosswalkCollectionForm.collectionType, 'Charter School Count')}">
						    <input type="Button" id="downLoadToExcel"
							name="downLoadToExcel"
							onclick="window.open('${pageContext.request.contextPath}/dynamic/report/charterCountUpload.xls?fiscalYear=${crosswalkCollectionForm.fiscalYear}');"
							value="Download this Report to Excel" />
						</c:when>
						
						<c:when test="${fn:containsIgnoreCase(crosswalkCollectionForm.collectionType, 'Online')}">
						    <input type="Button" id="downLoadToExcel"
							name="downLoadToExcel"
							onclick="window.open('${pageContext.request.contextPath}/dynamic/report/onlineUpload.xls?fiscalYear=${crosswalkCollectionForm.fiscalYear}');"
							value="Download this Report to Excel" />
						</c:when>
						<c:when test="${fn:containsIgnoreCase(crosswalkCollectionForm.collectionType, 'SOT')}">
						    <input type="Button" id="downLoadToExcel"
							name="downLoadToExcel"
							onclick="window.open('${pageContext.request.contextPath}/dynamic/report/sotUpload.xls?fiscalYear=${crosswalkCollectionForm.fiscalYear}');"
							value="Download this Report to Excel" />
						</c:when>
						<c:when test="${fn:containsIgnoreCase(crosswalkCollectionForm.collectionType, 'ESL')}">
						    <input type="Button" id="downLoadToExcel"
							name="downLoadToExcel"
							onclick="window.open('${pageContext.request.contextPath}/dynamic/report/eslUpload.xls?fiscalYear=${crosswalkCollectionForm.fiscalYear}');"
							value="Download this Report to Excel" />
						</c:when>
						<c:when test="${fn:containsIgnoreCase(crosswalkCollectionForm.collectionType, 'CSI')}">
						    <input type="Button" id="downLoadToExcel"
							name="downLoadToExcel"
							onclick="window.open('${pageContext.request.contextPath}/dynamic/report/csiUpload.xls?fiscalYear=${crosswalkCollectionForm.fiscalYear}');"
							value="Download this Report to Excel" />
						</c:when>
						<c:when test="${fn:containsIgnoreCase(crosswalkCollectionForm.collectionType, 'Free Lunch')}">
						    <input type="Button" id="downLoadToExcel"
							name="downLoadToExcel"
							onclick="window.open('${pageContext.request.contextPath}/dynamic/report/freeLunchUpload.xls?fiscalYear=${crosswalkCollectionForm.fiscalYear}');"
							value="Download this Report to Excel" />
						</c:when>
					</c:choose>
				</TD>
			</TR>
		</TABLE>
		</div>
		
	</form:form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/CrosswalkCollectionData.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>