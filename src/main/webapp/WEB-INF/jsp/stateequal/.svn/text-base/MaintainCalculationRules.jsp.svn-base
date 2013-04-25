
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
              <hr width="100%" id="">
            </TD>
            <TD>
            </TD>
          </TR>
          <TR>
            <TD>
              <fmt:message key="MaintainCalculationRules.StaticText.stateEqualOptionsStaticText" />
            </TD>
            <TD>
              <fmt:message key="MaintainCalculationRules.StaticText.districtOptionsStaticText" />
            </TD>
          </TR>
          <TR>
            <TD>
              <hr width="100%" id="">
            </TD>
            <TD>
            </TD>
          </TR>
          <TR>
            <TD COLSPAN="2">
              <fmt:message key="MaintainCalculationRules.StaticText.mainCalculationRulesStaticText" />
            </TD>
          </TR>
          <TR>
            <TD>
              <hr width="100%" id="">
            </TD>
            <TD>
            </TD>
          </TR>
        </TABLE>
        <TABLE>
          <TR>
            <TD>
              <c:url value="Rules Menu" var="link"/>
              <a id="" href="${link}">Rules Menu</a>
            </TD>
          </TR>
          <TR>
            <TD>
              <c:url value="Add Rules" var="link"/>
              <a id="" href="${link}">Add Rules</a>
            </TD>
          </TR>
          <TR>
            <TD>
              <c:url value="Edit Rules" var="link"/>
              <a id="" href="${link}">Edit Rules</a>
            </TD>
          </TR>
          <TR>
            <TD>
              <c:url value="Search and Delete Rules" var="link"/>
              <a id="" href="${link}">Search and Delete Rules</a>
            </TD>
          </TR>
          <TR>
            <TD>
              <c:url value="Validate and Test Existing Rules" var="link"/>
              <a id="" href="${link}">Validate and Test Existing Rules</a>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/screen/MaintainCalculationRules.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>