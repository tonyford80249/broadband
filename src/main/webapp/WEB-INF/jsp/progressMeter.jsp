<%-- 
    Document   : progressMeter
    Created on : Dec 27, 2012, 10:07:03 AM
    Author     : dyn-9
--%>

<%@ page language="java"%>
<%@ page import="com.cdoe.ui.*"%>
<%@ page import="com.cdoe.biz.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%-- Wrap the entire JSP in a try/catch block so that runtime exceptions
    in the JSP can be caught and reported. --%>
<%@include file="/WEB-INF/jsp/JspTry.inc"%>

<script type="text/javascript">
    function refresh() {     
     $('#statusPage').submit();  
    }
    
    $(document).ready(function() {
     setInterval('refresh()', 10000);    
    });
</script>

<style>
    .cde-progressbar { background-image: url('${pageContext.request.contextPath}/static/images/pbar-ani.gif'); }
</style>


<div id="mainContent">
    <form:form  id="statusPage" commandName="pageInfo" action="${pageContext.request.contextPath}${statusPage}"   method="get"> 
        <h1>${pageInfo.title}</h1>       
        <table border="1" cellspacing="12" style="margin : 80px; border : 3px solid black;">
            <thead>
                <col width="100">
                <col width="100">
                <col width="500">
                <tr>
                    <th>TASK</th>
                    <th>STATUS</th>
                    <th>PROGRESS</th>
                </tr>
            </thead>     
            <c:forEach items="${pageInfo.progressInfo}" var="meter">          
                <tr>
                    <td>${meter.task}</td>
                    <td>${meter.status}</td>
                    <td><div id="${meter.task}ProgressBar"  class="cde-progressbar" style="color : white; width : <c:out value="${meter.progress}%" />"> <center><c:out value="${meter.progress}%" /></center> </div></td>
                </tr>  
            </c:forEach>
        </table>    
    </form:form>
</div>


<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>