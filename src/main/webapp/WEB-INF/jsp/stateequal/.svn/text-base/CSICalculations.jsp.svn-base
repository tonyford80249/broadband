
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
	<form>

		<!-- Main outer table -->
		<h3>
			<fmt:message
				key="CSICalculations.StaticText.csiCalculationsStaticText" />
		</h3>
		<TABLE>
			<TR>
				<TD>
					<TABLE>
						<TR>
							<TD>District Number:</TD>
							<TD><input id="" path="textbox1077Textbox"
									size="12" maxlength="12" /></TD>
							<TD>District Name:</TD>
							<TD><input id=""  path="textbox1077Textbox"
									size="26" maxlength="26" /></TD>
						</TR>
					</TABLE>
					<TABLE>
						<TR>
							<TD width="50%"><h3>
									<fmt:message
										key="CSICalculations.StaticText.calculationElementsStaticText" />
								</h3></TD>
							<TD><h3>
									<fmt:message
										key="CSICalculations.StaticText.districtStaticText" />
								</h3></TD>
							<TD width="20%"><h3>
									Charter School Totals
								</h3></TD>
							<TD><h3>
								School #1
								</h3></TD>
							<TD><h3>
									School #2
								</h3></TD>
						</TR>
						<TR>
							<TD  width="50%"><fmt:message
									key="CSICalculations.StaticText.$1FundedPupilCountStaticText" />
							</TD>
							<TD><input path="textbox1061Textbox" id="" /></TD>
							<TD><input path="textbox1062Textbox" id="" /></TD>
							<TD><input path="textbox1063Textbox" id="" /></TD>
							<TD><input path="textbox1064Textbox" id="" /></TD>
						</TR>
						<TR>
							<TD width="50%"><fmt:message
									key="CSICalculations.StaticText.$2LessCharterSchoolCountStaticText" />
							</TD>
							<TD><input path="textbox1065Textbox" id="" /></TD>
							<TD><input path="textbox1066Textbox" id="" /></TD>
							<TD><input path="textbox1067Textbox" id="" /></TD>
							<TD><input path="textbox1068Textbox" id="" /></TD>
						</TR>
						<TR>
							<TD width="50%"><fmt:message
									key="CSICalculations.StaticText.$3DistrictAdjustedPupilCountStaticText" />
							</TD>
							<TD><input path="textbox1069Textbox" id="" /></TD>
							<TD><input path="textbox1070Textbox" id="" /></TD>
							<TD><input path="textbox1071Textbox" id="" /></TD>
							<TD><input path="textbox1072Textbox" id="" /></TD>
						</TR>
						<TR>
							<TD  width="50%"><fmt:message
									key="CSICalculations.StaticText.$4TotalFormulaPerPupilFundingStaticText" />
							</TD>
							<TD><input path="textbox1073Textbox" id="" /></TD>
							<TD><input path="textbox1074Textbox" id="" /></TD>
							<TD><input path="textbox1075Textbox" id="" /></TD>
							<TD><input path="textbox1076Textbox" id="" /></TD>
						</TR>
						<TR>
							<TD  width="50%"><fmt:message
									key="CSICalculations.StaticText.$5AtRiskPupilCountStaticText" />
							</TD>
							<TD><input path="textbox1077Textbox" id="" /></TD>
							<TD><input path="textbox1078Textbox" id="" /></TD>
							<TD><input path="textbox1079Textbox" id="" /></TD>
							<TD><input path="textbox1080Textbox" id="" /></TD>
						</TR>
						<TR >
							<TD width="50%"><fmt:message
									key="CSICalculations.StaticText.$6TotalAtRiskFundingStaticText" />
							</TD>
							<TD><input path="textbox1081Textbox" id="" /></TD>
							<TD><input path="textbox1082Textbox" id="" /></TD>
							<TD><input path="textbox1083Textbox" id="" /></TD>
							<TD><input path="textbox1084Textbox" id="" /></TD>
						</TR>
						<TR >
							<TD width="50%"><LABEL FOR=""><fmt:message
										key="CSICalculations.StaticText.$7DistrictPerPupilAtRiskFundingStaticText" /></LABEL>
							</TD>
							<TD><input path="$7DistrictPerPupilAtRiskFundingTextbox"
								id="" /></TD>
							<TD><input path="textbox1086Textbox" id="" /></TD>
							<TD><input path="textbox1087Textbox" id="" /></TD>
							<TD><input path="textbox1088Textbox" id="" /></TD>
						</TR>
						<TR>
							<TD  width="50%"><fmt:message
									key="CSICalculations.StaticText.$8K12MembershipStaticText" />
							</TD>
							<TD><input path="textbox1090Textbox" id="" /></TD>
							<TD><input path="textbox1091Textbox" id="" /></TD>
							<TD><input path="textbox1092Textbox" id="" /></TD>
							<TD><input path="textbox1093Textbox" id="" /></TD>
						</TR>
						<TR>
							<TD><fmt:message
									key="CSICalculations.StaticText.$9PercentageOfPupilsEligibleStaticText" />
							</TD>
							<TD><input path="textbox1097Textbox" id="" /></TD>
							<TD><input path="textbox1098Textbox" id="" /></TD>
							<TD><input path="textbox1099Textbox" id="" /></TD>
							<TD><input path="textbox1100Textbox" id="" /></TD>
						</TR>
						<TR>
							<TD><LABEL FOR=""><fmt:message
										key="CSICalculations.StaticText.$10AdjustedAtRiskPerPupilFundingStaticText" /></LABEL>
							</TD>
							<TD><input path="$10AdjustedAtRiskPerPupilFundingTextbox"
								id="" /></TD>
							<TD><input path="textbox1101Textbox" id="" /></TD>
							<TD><input path="textbox1102Textbox" id="" /></TD>
							<TD><input path="textbox1103Textbox" id="" /></TD>
						</TR>
						<TR>
							<TD><fmt:message
									key="CSICalculations.StaticText.$11TotalProgramFundingStaticText" />
							</TD>
							<TD><input path="textbox1104Textbox" id="" /></TD>
							<TD><input path="textbox1105Textbox" id="" /></TD>
							<TD><input path="textbox1106Textbox" id="" /></TD>
							<TD><input path="textbox1107Textbox" id="" /></TD>
						</TR>
						<TR>
							<TD><fmt:message
									key="CSICalculations.StaticText.$12NegativeFactorTotalPerPupilStaticText" />
							</TD>
							<TD><input path="textbox511Textbox" id="" /></TD>
							<TD><input path="textbox1108Textbox" id="" /></TD>
							<TD><input path="textbox1109Textbox" id="" /></TD>
							<TD><input path="textbox1110Textbox" id="" /></TD>
						</TR>
						<TR>
							<TD><fmt:message
									key="CSICalculations.StaticText.$13RevisedTotalProgramFundingStaticText" />
							</TD>
							<TD><input path="textbox1111Textbox" id="" /></TD>
							<TD><input path="textbox1112Textbox" id="" /></TD>
							<TD><input path="textbox1113Textbox" id="" /></TD>
							<TD><input path="textbox1114Textbox" id="" /></TD>
						</TR>
						<TR>
							<TD><fmt:message
									key="CSICalculations.StaticText.$14DistrictPerPupilRevenueStaticText" />
							</TD>
							<TD><input path="textbox521Textbox" id="" /></TD>
							<TD><input path="textbox1115Textbox" id="" /></TD>
							<TD><input path="textbox1116Textbox" id="" /></TD>
							<TD><input path="textbox1117Textbox" id="" /></TD>
						</TR>
						<TR>
							<TD ><LABEL FOR=""><fmt:message
										key="CSICalculations.StaticText.$15AdjustedCharterPerPupilRevenueStaticText" /></LABEL>
							</TD>
							<TD><input path="$15AdjustedCharterPerPupilRevenueTextbox"
								id="" /></TD>
							<TD><input path="textbox1118Textbox" id="" /></TD>
							<TD><input path="textbox1119Textbox" id="" /></TD>
							<TD><input path="textbox1120Textbox" id="" /></TD>
						</TR>
						<TR>
							<TD ><LABEL FOR=""><fmt:message
										key="CSICalculations.StaticText.$16AdjustedDistrictPerPupilRevenueStaticText" /></LABEL>
							</TD>
							<TD><input path="$16AdjustedDistrictPerPupilRevenueTextbox"
								id="" /></TD>
							<TD><input path="textbox1122Textbox" id="" /></TD>
							<TD><input path="textbox1123Textbox" id="" /></TD>
							<TD><input path="textbox1124Textbox" id="" /></TD>
						</TR>
						<TR>
							<TD><fmt:message
									key="CSICalculations.StaticText.$17CharterTotalProgramAdjustedStaticText" />
							</TD>
							<TD><input path="textbox1125Textbox" id="" /></TD>
							<TD><input path="textbox1126Textbox" id="" /></TD>
							<TD><input path="textbox1127Textbox" id="" /></TD>
							<TD><input path="textbox1128Textbox" id="" /></TD>
						</TR>
						<TR>
							<TD ><LABEL FOR=""><fmt:message
										key="CSICalculations.StaticText.$18CharterTotalProgramUnadjustedStaticText" /></LABEL>
							</TD>
							<TD><input path="$18CharterTotalProgramUnadjustedTextbox"
								id="" /></TD>
							<TD><input path="textbox1129Textbox" id="" /></TD>
							<TD><input path="textbox1130Textbox" id="" /></TD>
							<TD><input path="textbox1131Textbox" id="" /></TD>
						</TR>
						<TR>
							<TD><LABEL FOR=""><fmt:message
										key="CSICalculations.StaticText.$19AtRiskFundingToFromCharterStaticText" /></LABEL>
							</TD>
							<TD><input path="$19AtRiskFundingToFromCharterTextbox" id="" />
							</TD>
							<TD><input path="textbox1134Textbox" id="" /></TD>
							<TD><input path="textbox1135Textbox" id="" /></TD>
							<TD><input path="textbox1136Textbox" id="" /></TD>
						</TR>
						<TR>
							<TD><fmt:message
									key="CSICalculations.StaticText.$20TotalProgramStaticText" />
							</TD>
							<TD><input path="textbox1137Textbox" id="" /></TD>
							<TD><input path="textbox1138Textbox" id="" /></TD>
							<TD><input path="textbox1139Textbox" id="" /></TD>
							<TD><input path="textbox1150Textbox" id="" /></TD>
						</TR>
					</TABLE>
					<TABLE>
						<TR>
							<TD width="60%"/>
							<TD><input type="button" id="" value="Calculate" align="center"/></TD>
							<TD><input type="button" id="" value="Save" /></TD>
							<TD><input type="button" id="" value="Print" align="left"/></TD>
						</TR>

					</TABLE>
				</TD>
			</TR>
		</TABLE>
	</form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/screen/CSICalculations.js"></script>
<%-- End of try/catch around complete JSP in order to log and display
     runtime exceptions that occur in the JSP. --%>
<%@include file="/WEB-INF/jsp/JspCatch.inc"%>