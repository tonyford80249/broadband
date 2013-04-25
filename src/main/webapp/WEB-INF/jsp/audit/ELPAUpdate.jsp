
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
<div id="mainContent">
	<form:form commandName="auditEqualForm"
		action="${pageContext.request.contextPath}/secure/ChangeBilling/save"
		method="post">
		<input type="hidden" name="rowKey" id="rowKey" />


		<!-- Main outer table -->
		<h3>
			<fmt:message key="ChangeELPA.StaticText.changeElpaStaticText" />
		</h3>
  <TABLE>
    <TR>
      <TD>
         <table>
         
						<TR>
							<TD ALIGN="right"><LABEL FOR="">Fiscal Year</LABEL><TD>
							<TD><form:input id="" path="" value="2011-2012" /><TD>
							<TD ALIGN="right"><LABEL FOR="">District Code</LABEL></TD>
							<TD><form:input id="" path="" value="3120" /><TD>
							<TD ALIGN="right"><LABEL FOR="">District Name</LABEL></TD>
							<TD><form:input id="" path="" value="Broomfield" /></TD>
						</TR>
					</table>
		  </TD>
		  </TR>
		  <TR/>
		  </br>
		  <tr>
		  <table width="100%">
		  <tr>
		    
			<td  width="20%"><h3>&nbsp;</h3></td>
			<td  width="20%"><h3>Fiscal</h3></td>
			<td  width="10%"><h3>District</h3></td>
			<td width="10%"><h3>Audit</h3></td>
			<td width="10%"><h3>Difference</h3></td>
			
		  </tr>
		  <%for (int i = 0; i < 6; i++) {%>
		  <tr>
		  	 <td  width="20%"/>
		     <td width="20%">200<%=(i + 6)%>-200<%=(i + 7)%></td>
		     <td width="10%"> 30<%=(i * 10)%></td>
		     <td width="10%"><input size="10"/></td>
		     <td width="20%"><input  size="10"/></td>
          </TR>
          <%}%>
        </TABLE>
        <TABLE width="60%">
          <TR>
            <td width="50%"/>
            <TD>
              <input type="Submit" id="" value="Save"/>
            </TD>
            <TD>
              <input type="Submit" id="" value="Delete"/>
            </TD>
          </TR>
        </TABLE>

	
	
	
	
	</form:form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/ChangeELPA.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>