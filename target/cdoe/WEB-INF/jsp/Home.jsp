
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
<%@ page language="java" %>
<%@ page import="com.cdoe.ui.*" %>
<%@ page import="com.cdoe.biz.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- Wrap the entire JSP in a try/catch block so that runtime exceptions
    in the JSP can be caught and reported. --%>
<%@include file="/WEB-INF/jsp/JspTry.inc"%>
<form>

  <!-- Main outer table -->
  <TABLE CLASS="ContentTable">
    <TR>
      <TD>
        <TABLE>
          <TR>
            <TD>
              <fmt:message key="HomePage.StaticText.stateEqualOptionsStaticText" />
            </TD>
            <TD>
            </TD>
            <TD COLSPAN="2">
              <fmt:message key="HomePage.StaticText.districtOptionsStaticText" />
            </TD>
          </TR>
          <TR>
            <TD>
              <hr width="100%" id="">
            </TD>
            <TD>
            </TD>
            <TD>
            </TD>
            <TD>
            </TD>
          </TR>
          <TR>
            <TD COLSPAN="4">
              <fmt:message key="HomePage.StaticText.stateShareProcessingStaticText" />
            </TD>
          </TR>
          <TR>
            <TD>
              <hr width="100%" id="">
            </TD>
            <TD>
            </TD>
            <TD>
            </TD>
            <TD>
            </TD>
          </TR>
          <TR>
            <TD ALIGN="right">
              <LABEL FOR=""><fmt:message key="HomePage.StaticText.lastPaymentProcessedStaticText" /></LABEL>
            </TD>
            <TD>
              <input  path="lastPaymentProcessedTextbox" id="" />
            </TD>
            <TD ALIGN="right">
              <LABEL FOR=""><fmt:message key="HomePage.StaticText.nextPaymentProcessingStaticText" /></LABEL>
            </TD>
            <TD>
              <select  id=""
              	list="{}" 
              	path="nextPaymentProcessingDropdownList" size="1"/>

            </TD>
          </TR>
          <TR>
            <TD>
              <hr width="100%" id="">
            </TD>
            <TD>
            </TD>
            <TD>
            </TD>
            <TD>
            </TD>
          </TR>
          <TR>
            <TD COLSPAN="4">
              <fmt:message key="HomePage.StaticText.maintenanceTasksStaticText" />
            </TD>
          </TR>
          <TR>
            <TD>
              <hr width="100%" id="">
            </TD>
            <TD>
            </TD>
            <TD>
            </TD>
            <TD>
            </TD>
          </TR>
        </TABLE>
        <TABLE>
          <TR>
            <TD>
              <c:url value="Create and Maintain Calculation Rules" var="link"/>
              <a id="" href="${pageContext.request.contextPath}">Create and Maintain Calculation Rules</a>
            </TD>
          </TR>
          <TR>
            <TD>
              <c:url value="Upload Variables/Adjustments" var="link"/>
              <a id="" href="${pageContext.request.contextPath}">Upload Variables/Adjustments</a>
            </TD>
          </TR>
          <TR>
            <TD>
              <c:url value="Enter/Update Single District Variables" var="link"/>
              <a id="" href="${pageContext.request.contextPath}">Enter/Update Single District Variables</a>
            </TD>
          </TR>
          <TR>
            <TD>
              <c:url value="Import Prior Year Audited Pupil and Lunch Counts" var="link"/>
              <a id="" href="${pageContext.request.contextPath}">Import Prior Year Audited Pupil and Lunch Counts</a>
            </TD>
          </TR>
          <TR>
            <TD>
              <c:url value="Enter/Update Monthly Adjustments" var="link"/>
              <a id="" href="${pageContext.request.contextPath}">Enter/Update Monthly Adjustments</a>
            </TD>
          </TR>
          <TR>
            <TD>
              <c:url value="Crosswalk Collection Data" var="link"/>
              <a id="" href="${pageContext.request.contextPath}">Crosswalk Collection Data</a>
            </TD>
          </TR>
          <TR>
            <TD>
              <c:url value="Enter/Review Comments" var="link"/>
              <a id="" href="${pageContext.request.contextPath}">Enter/Review Comments</a>
            </TD>
          </TR>
        </TABLE>
        <TABLE>
          <TR>
            <TD>
              <hr width="100%" id="">
            </TD>
          </TR>
          <TR>
            <TD>
              <fmt:message key="HomePage.StaticText.processingTasksStaticText" />
            </TD>
          </TR>
          <TR>
            <TD>
              <hr width="100%" id="">
            </TD>
          </TR>
        </TABLE>
        <TABLE>
          <TR>
            <TD>
              <c:url value="Calculate Entitlements - Monthly, Mid-Year, End-of-Year" var="link"/>
              <a id="" href="${pageContext.request.contextPath}">Calculate Entitlements - Monthly, Mid-Year, End-of-Year</a>
            </TD>
          </TR>
          <TR>
            <TD>
              <c:url value="Process Monthly Payments and upload to COFRS" var="link"/>
              <a id="" href="${pageContext.request.contextPath}">Process Monthly Payments and upload to COFRS</a>
            </TD>
          </TR>
          <TR>
            <TD>
              <c:url value="Reports" var="link"/>
              <a id="" href="${pageContext.request.contextPath}">Reports</a>
            </TD>
          </TR>
        </TABLE>
        <TABLE>
          <TR>
            <TD>
              <hr width="100%" id="">
            </TD>
          </TR>
          <TR>
            <TD>
              <fmt:message key="HomePage.StaticText.stateEqualProcessingHelpStaticText" />
            </TD>
          </TR>
          <TR>
            <TD>
              <hr width="100%" id="">
            </TD>
          </TR>
        </TABLE>
        <TABLE>
          <TR>
            <TD>
              <c:url value="July Processing" var="link"/>
              <a id="" href="${pageContext.request.contextPath}">July Processing</a>
            </TD>
          </TR>
          <TR>
            <TD>
              <c:url value="August to November Processing" var="link"/>
              <a id="" href="${pageContext.request.contextPath}">August to November Processing</a>
            </TD>
          </TR>
          <TR>
            <TD>
              <c:url value="December Processing" var="link"/>
              <a id="" href="${pageContext.request.contextPath}">December Processing</a>
            </TD>
          </TR>
          <TR>
            <TD>
              <c:url value="January to May Processing" var="link"/>
              <a id="" href="${pageContext.request.contextPath}">January to May Processing</a>
            </TD>
          </TR>
          <TR>
            <TD>
              <c:url value="June Processing" var="link"/>
              <a id="" href="${pageContext.request.contextPath}">June Processing</a>
            </TD>
          </TR>
        </TABLE>
        <TABLE>
          <TR>
            <TD>
              <hr width="100%" id="">
            </TD>
          </TR>
          <TR>
            <TD>
              <fmt:message key="HomePage.StaticText.administrationStaticText" />
            </TD>
          </TR>
          <TR>
            <TD>
              <hr width="100%" id="">
            </TD>
          </TR>
        </TABLE>
        <TABLE>
          <TR>
            <TD>
              <c:url value="Review Comments" var="link"/>
              <a id="" href="${pageContext.request.contextPath}/Comments">Review Comments</a>
            </TD>
          </TR>
        </TABLE>
        <TABLE>
          <TR>
            <TD>
              <hr width="100%" id="">
            </TD>
          </TR>
        </TABLE></TD>
    </TR>
  </TABLE>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/screen/HomePage.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>