
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
<div id="mainContent">
<form>

  <!-- Main outer table -->
  <TABLE CLASS="ContentTable">
    <TR>
      <TD>
        <TABLE>
         
          <TR>
            <TD COLSPAN="2">
              <fmt:message key="AdvanceAndEntitlementReport.StaticText.priorYearAdvancementAndEntitlementReportStaticText" />
            </TD>
          </TR>
          <TR>
            <TD ALIGN="right">
              <LABEL FOR=""><fmt:message key="AdvanceAndEntitlementReport.StaticText.reimbursementYearStaticText" /></LABEL>
            </TD>
            <TD>
              <input  path="reimbursementYearTextbox" id="" />
            </TD>
          </TR>
        </TABLE>
        <TABLE>
          <TR>
            <TD>
              <fmt:message key="AdvanceAndEntitlementReport.StaticText.districCodeStaticText" />
            </TD>
            <TD>
              <fmt:message key="AdvanceAndEntitlementReport.StaticText.andNameStaticText" />
            </TD>
            <TD>
              <fmt:message key="AdvanceAndEntitlementReport.StaticText.calculateReimbursementStaticText" />
            </TD>
            <TD>
              <fmt:message key="AdvanceAndEntitlementReport.StaticText.advanceReimbursementStaticText" />
            </TD>
          </TR>
        </TABLE>
        <TABLE>
          <TR>
            <TD>
              <fmt:message key="AdvanceAndEntitlementReport.StaticText.entitlementStaticText" />
            </TD>
            <TD>
              <fmt:message key="AdvanceAndEntitlementReport.StaticText.entitlementStaticText_2" />
            </TD>
          </TR>
        </TABLE>
        <TABLE>
          <TR>
            
            <TD>
              <fmt:message key="AdvanceAndEntitlementReport.StaticText.staticText_2" />
            </TD>
            <TD>
              <fmt:message key="AdvanceAndEntitlementReport.StaticText.staticText_3" />
            </TD>
          </TR>
        </TABLE>
        <TABLE>
          <TR>
            <TD>
              <span>
              </span>
            </TD>
            <TD>
              <input  path="textbox1386Textbox" id="" />
            </TD>
            <TD>
              <input  path="textbox1387Textbox" id="" />
            </TD>
          </TR>
        </TABLE>
        <TABLE>
          <TR>
            <TD>
              <input type="button" id="" value="Download to Excel"/>
            </TD>
          </TR>
        </TABLE></TD>
    </TR>
  </TABLE>
</form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/screen/AdvanceAndEntitlementReport.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>