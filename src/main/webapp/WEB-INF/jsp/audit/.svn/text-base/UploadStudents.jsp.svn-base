
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
<form:form commandName="auditTrackingForm"
	action="${pageContext.request.contextPath}/secure/UploadStudents/save"
	method="post">
	<!-- Main outer table -->
	<h3>State Equal Exceptions Upload Students</h3>
	<TABLE CLASS="ContentTable">
		<TR>
			<TD>
				<div class="formBlock boxShadow3 radius10">
				<TABLE>

					<TR>
						<TD ALIGN="right"><LABEL FOR="">Fiscal Year</LABEL></TD>
						<TD><form:input id="" path="" />&nbsp;&nbsp;&nbsp;&nbsp</TD>

						<TD ALIGN="right"><LABEL FOR="">District Code</LABEL></TD>
						<TD><form:input id="" path="" />&nbsp;&nbsp;&nbsp;&nbsp</TD>

						<TD ALIGN="right"><LABEL FOR="">District Name </LABEL></TD>
						<TD><form:input id="" path="" />&nbsp;&nbsp;&nbsp;&nbsp</TD>
					</TR>

				</TABLE>
				</div>
				 </BR>
				<TABLE width="100%">
					<TR>

						<TD ALIGN="right" colspan="2"><h3>
								<LABEL FOR="">Browse to upload file of SASIDs</LABEL>
							</h3></TD>
					</TR>
				</table>
				<table>
					<TR>
						<TD WIDTH="10%" />
						<TD><form:input id="" type="file" path="" /></TD>
					</TR>
				</TABLE> </BR>
				<TABLE  width="100%">

					<TR>
						<TD><h3> Manually Enter up to 10 SASIDs to upload</h3></TD>
					</TR>
				</TABLE>
				<TABLE>
				    
					<TR>
						<TD WIDTH="10%" />
						<TD>
							<TABLE>
								<TR>
								   
				    				<TD>SASID</TD>
				    				<TD WIDTH="10%" >Remove from Membership</TD>
				    				<TD>Funding</TD>
				    				<TD WIDTH="10%"/>
				    				<TD>Free Lunch</TD>
				    				<TD WIDTH="10%"/>
				    				<TD>Pupil Exception</TD>
				    				<TD WIDTH="10%"/>
				    				<TD>At Risk Exception</TD>
				    			</TR>
								<%
									for (int i = 0; i < 10; i++) {
								%>
								<TR>
									
									<TD><form:input id="" path="" /></TD>
									<TD WIDTH="10%"><form:input type="checkbox" id="membership" path=""/></TD>
									<TD WIDTH="10%"><form:select id="funding" path="">
										<option>01</option>
										<option>02</option>
										</form:select>
									</TD>
									<TD WIDTH="10%"/>
									<TD WIDTH="10%"><form:select id="freeLunch" path="">
										<option>01</option>
										<option>02</option>
										</form:select>
									</TD>
									<TD WIDTH="10%"/>
									<TD WIDTH="10%"><form:select id="pupilException" path="">
										<option>01</option>
										<option>02</option>
										</form:select>
									</TD>
									<TD WIDTH="10%"/>
									<TD WIDTH="10%"><form:select id="atRiskException" path="">
										<option>01</option>
										<option>02</option>
										</form:select>
									</TD>
									

									<%
										}
									%>
								</TR>
								<TR>
									<TD><input type="Submit" id=""
										value="Submit SASIDs"/></TD>
									<TD><input type="Submit" id=""
										value="Audit Adjustment Status" /></TD>
									
								</TR>
							</TABLE>
						</TD>

					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE>
</form:form>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/AuditSummary.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>