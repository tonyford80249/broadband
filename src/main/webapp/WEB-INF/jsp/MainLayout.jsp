<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Cache-Control" content="must-revalidate"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<TITLE><tiles:getAsString name="page-title" />
</TITLE>
<link type="text/css" rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/static/css/subweb_template_style.css">
<link type="text/css" rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/static/css/FedPrograms_Home_template_style.css">
<link type="text/css" rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/static/css/equal.css">
<link type="text/css" rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/static/css/demo_table.css">
<link rel="stylesheet" type="text/css" media="print" href="${pageContext.request.contextPath}/static/css/subweb_print_style.css">
<c:if test="${not empty pageCss}">
  <link type="text/css" rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/static/css/${pageCss}.css">  
</c:if>

<!--Script and CSS includes for YUI dependencies on this page-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/jquery/jquery-datatables-1.7.4/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/jquery/jquery-ui-1.8.17.custom/js/jquery-ui-1.8.17.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/shared/FormValidation.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/jquery/jquery-ext.js"></script>

</head>


<body>

	<div id="page">
		<tiles:insertAttribute name="page-header"/>
		<tiles:insertAttribute name="page-menu"/>
		<tiles:insertAttribute name="page-content"/>
		<tiles:insertAttribute name="page-footer"/>
		<div id="ajaxIndicator" style="visibility: hidden; position: absolute;">
			<div class="bd">
				<img src="${pageContext.request.contextPath}/static/images/ajax-loader.gif" alt="Loading..." border="0">
			</div>
		</div>
	</div>
</body>
</html>
