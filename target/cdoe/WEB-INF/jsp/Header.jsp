<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.cdoe.util.*"%>

<%
	String formattedDate = DateUtil.getFormattedDate("EEEE, MMMM dd, yyyy");
    String homeUrl= "";
	//String userName = (String) session.getAttribute("userName");
	UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");
	String userName = null;
	if (userInfo != null && !"".equals(userName))
		userName = userInfo.getUserId();
	else
		userName = "Username not set";
		
    String moduleName = request.getParameter("pageName"); 
	
	
	if ((moduleName == null) || "".equals(moduleName) ) {
	    if ( userInfo.isTransportationUser())
	       moduleName = "Transportation";
	    else if (userInfo.isAuditDistrictUser())
	        moduleName = "Audit";
	    else if (userInfo.isStateEqualUser())
	       moduleName = "State Equal";
	    else moduleName = "State Equal Systems";
	}  else {
		
		if ("LandingMenu".equals(moduleName))
			 moduleName = "State Equal Systems";
		else	
			moduleName = moduleName.substring(0, moduleName.length() -  4);
	}  
	session.setAttribute("moduleName", moduleName);
	System.out.println("moduleName" +  moduleName);
	
/* This is the logic for taking to the home page */	
 
   if ("Transportation".equals(moduleName) && userInfo.isAdminUser()) 
      homeUrl = "TransportationHomePage";
   else if ("Auditor".equals(moduleName))
     homeUrl = "AuditorHomePage";
   else if ("State Equal".equalsIgnoreCase(moduleName))
        homeUrl = "StateEqualHomePage";
   else homeUrl = "LandingMenu";
      
%>

		<div id="headcdetext">
	       <p style="width:300px;float:left;">The Colorado Department of Education</p>
	       <p style="text-align:right; padding-right:10px;">
	       Date:&nbsp;<%=formattedDate %>&nbsp;&nbsp;&nbsp;User&nbsp;Name:&nbsp; <%=userName %> &nbsp;&nbsp;&nbsp;
		   <a href="${pageContext.request.contextPath}/secure/<%=homeUrl%>" style="color:#ffffff;">Home</a> | 
		   <a href="${pageContext.request.contextPath}/logout" style="color:#ffffff;">Logout</a>
	       </p>
	    </div>
		<div id="header">
		   <div id="headlogo"><div  style='font-size: 0.5em; height: 17px' align="left"></div>
		     <a href="#"><img src="http://cdenet.cde.state.co.us/images-new/CDELogos/CDE_Logo_Left_White.png" width="223" height="40" alt="CDE Logo" border="0" class="cdeheadlogo"></a>
		     <div id="bannersection" style='font-size: 3em;' align="center"><%=moduleName%>	</div>
		     <div style='font-size: 0.4em; height: 17px' align="center"></div>
		   </div>
		</div>
