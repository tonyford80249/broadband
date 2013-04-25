<%--
Copyright ResQSoft, Inc. 2011
--%>
<%-- ref: jsp/pagelist.jsp.et.jsp --%>
<%@ page language="java" %>
<%@ page import="com.cdoe.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table width=640>
    <tr>
       <td>
            <span class=title>CDOE</span>
            <ul>
            <li>
				<c:url value="/secure/AddAdjustment" var="link"/>
				<a id="AddAdjustment" href="${link}">Add Adjustment</a>
            </li>
            <li>
				<c:url value="/secure/AdvanceAndEntitlementReport" var="link"/>
				<a id="AdvanceAndEntitlementReport" href="${link}">Advance and Entitlement Report</a>
            </li>
            <li>
				<c:url value="/secure/Cde40Summary" var="link"/>
				<a id="Cde40Summary" href="${link}">Cde40Summary</a>
            </li>
            <li>
				<c:url value="/secure/Cde40TransReimbForm" var="link"/>
				<a id="Cde40TransReimbForm" href="${link}">Cde40TransReimbForm</a>
            </li>
            <li>
				<c:url value="/secure/CSICalculations" var="link"/>
				<a id="CSICalculations" href="${link}">CSI Calculations</a>
            </li>
            <li>
				<c:url value="/secure/CalculateEntitlements" var="link"/>
				<a id="CalculateEntitlements" href="${link}">Calculate Entitlements</a>
            </li>
            <li>
				<c:url value="/secure/CapitalOutlay" var="link"/>
				<a id="CapitalOutlay" href="${link}">CapitalOutlay</a>
            </li>
            <li>
				<c:url value="/secure/CoforsUpload" var="link"/>
				<a id="CoforsUpload" href="${link}">CoforsUpload</a>
            </li>
            <li>
				<c:url value="/secure/Comments" var="link"/>
				<a id="Comments" href="${link}">Comments</a>
            </li>
            <li>
				<c:url value="/secure/CrosswalkCollectionData" var="link"/>
				<a id="CrosswalkCollectionData" href="${link}">Crosswalk Collection Data</a>
            </li>
            <li>
				<c:url value="/secure/DisplayAdjustment" var="link"/>
				<a id="DisplayAdjustment" href="${link}">Display Adjustment</a>
            </li>
            <li>
				<c:url value="/secure/DistributionAmounts" var="link"/>
				<a id="DistributionAmounts" href="${link}">Distribution Amounts</a>
            </li>
            <li>
				<c:url value="/secure/DistrictPaymentReport" var="link"/>
				<a id="DistrictPaymentReport" href="${link}">DistrictPaymentReport</a>
            </li>
            <li>
				<c:url value="/secure/Elections" var="link"/>
				<a id="Elections" href="${link}">Elections</a>
            </li>
            <li>
				<c:url value="/secure/Header" var="link"/>
				<a id="Header" href="${link}">Header Include</a>
            </li>
            <li>
				<c:url value="/secure/HomePage" var="link"/>
				<a id="HomePage" href="${link}">Home Page</a>
            </li>
            <li>
				<c:url value="/secure/ImportAudits" var="link"/>
				<a id="ImportAudits" href="${link}">Import Audits</a>
            </li>
            <li>
				<c:url value="/secure/ImportAuditTransData" var="link"/>
				<a id="ImportAuditTransData" href="${link}">ImportAuditTransData</a>
            </li>
            <li>
				<c:url value="/secure/SSOLogin" var="link"/>
				<a id="SSOLogin" href="${link}">Login</a>
            </li>
            <li>
				<c:url value="/secure/MaintainCalculationRules" var="link"/>
				<a id="MaintainCalculationRules" href="${link}">Maintain Calculation Rules</a>
            </li>
            <li>
				<c:url value="/secure/MillLevyCert" var="link"/>
				<a id="MillLevyCert" href="${link}">Mill Levy Certification</a>
            </li>
            <li>
				<c:url value="/secure/MillLevyOverrideWorksheet" var="link"/>
				<a id="MillLevyOverrideWorksheet" href="${link}">Mill Levy Override Worksheet</a>
            </li>
            <li>
				<c:url value="/secure/MonthlyPayments" var="link"/>
				<a id="MonthlyPayments" href="${link}">Monthly Payments</a>
            </li>
            <li>
				<c:url value="/secure/PaymentWorkSheet" var="link"/>
				<a id="PaymentWorkSheet" href="${link}">Payment_Worksheet</a>
            </li>
            <li>
				<c:url value="/secure/Reports" var="link"/>
				<a id="Reports" href="${link}">Reports</a>
            </li>
            <li>
				<c:url value="/secure/LandingMenu" var="link"/>
				<a id="LandingMenu" href="${link}">State Equal Applications</a>
            </li>
            <li>
				<c:url value="/secure/TransMenu" var="link"/>
				<a id="TransMenu" href="${link}">Transport Menu</a>
            </li>
            <li>
				<c:url value="/secure/Comments" var="link"/>
				<a id="Comments" href="${link}">Transportation Comments</a>
            </li>
            <li>
				<c:url value="/secure/UploadVariables" var="link"/>
				<a id="UploadVariables" href="${link}">Upload Variables</a>
            </li>
            </ul>
        </td>
    </tr>
</table>