
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
<form:form commandName="auditSasidExceptionForm"
		action="${pageContext.request.contextPath}/secure/UpdateStudents/save"
		method="post">
		<input type="hidden" name="rowKey" id="rowKey" />



	<!-- Main outer table -->
	<h3>State Equal Exceptions: Update (Step 4)</h3>
	<TABLE CLASS="ContentTable">
		<TR>
			<TD>
				<TABLE>
					<TR>
						<TD ALIGN="right"><LABEL FOR=""><b>Fiscal Year</b></LABEL></TD>
						<TD><form:input id="" path="" value="2011-2012" />
						<TD ALIGN="right"><LABEL FOR=""><b>District Code</b></LABEL></TD>
						<TD><form:input id="" path="" value="3120" />
						<TD ALIGN="right"><LABEL FOR=""><b>District Name</b></LABEL></TD>
						<TD><form:input id="" path="" value="Broomfield" />
					</TR>

				</TABLE>
				</br>
				<TABLE>
					<TR>
					   <span><font size="2">
					     <TD/>
					     
						<TD><h3>SASID</h3></TD>
						<TD><h3>School</h3></TD>
						<TD><h3>Grade</h3></TD>
						<TD><h3>Last Name</h3></TD>
						<TD><h3>First Name
						</h3></TD>
						<TD><h3>Orig Funding
						</h3></TD>
						<TD><h3>New Funding
						</h3></TD>
						<TD><h3><font size="2">Orig Free Lunch</font>
						</h3></TD>
						<TD><h3><font size="2">New Free Lunch</font>
						</h3></TD>
						<TD><h3>Attend</h3></TD>
						<TD><h3>Post Sec</h3></TD>
						<TD  font size="2"><h3>Pupil Exception
						</h3></TD>
						<TD  font size="2"><h3>At Risk Exception</h3>
						</TD>
						</font>
						</span>
					</TR>
					 <%for (int i = 0; i < 10; i++) {%>
					<TR>
						<TD><input type="checkbox"/></TD>
						<TD>NNNNNNNNNN</TD>
						<TD>NNNNNN</TD>
						<TD>6</TD>
						<TD>Spencer</TD>
						<TD>Jonathan</TD>
						<TD>
							SourceFed
						</TD>
						<TD>
							<select>
							 <option>New Src</option>
							</select>
						</TD>
						<td>Chipole</TD>
						<TD><select>
							 <option>New lunch</option>
							</select></TD>
						<TD>Attend</TD>
						<TD>
							Post Sec
						</TD>
						<td><select>
							 <option>New Select</option>
							</select>
						</TD>
						<TD>
							<select>
							 <option>Select value</option>
							</select>
						</TD>
					</TR>
					<% } %>
				</TABLE>
				<TABLE>
					<TR>
					    <TD WIDTH="40%"/>
						<TD><input type="button" id="" value="Save Changes" /></TD>
						<TD><input type="button" id=""
							value="Add Additional SASID(s)" /></TD>
						<TD><input type="button" id=""
							value="Delete Selected Students" /></TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE>
</form:form >
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/SEExceptionStep4Update.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>