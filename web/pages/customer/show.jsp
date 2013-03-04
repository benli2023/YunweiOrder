<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=Customer.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="customer"  method="post">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/customer'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="custId" name="custId" value="${customer.custId}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_CUST_NAME%></td>	
				<td><c:out value='${customer.custName}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_SHORT_NAME%></td>	
				<td><c:out value='${customer.shortName}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_CUST_CODE%></td>	
				<td><c:out value='${customer.custCode}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_CONTACT_NAME%></td>	
				<td><c:out value='${customer.contactName}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_CONTRY_CODE%></td>	
				<td><c:out value='${customer.contryCode}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_PROV_CODE%></td>	
				<td><c:out value='${customer.provCode}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_CITY_CODE%></td>	
				<td><c:out value='${customer.cityCode}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_ADDRESS%></td>	
				<td><c:out value='${customer.address}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_CONTACT%></td>	
				<td><c:out value='${customer.contact}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_TELEPHONE%></td>	
				<td><c:out value='${customer.telephone}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_FAX%></td>	
				<td><c:out value='${customer.fax}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_EMAIL%></td>	
				<td><c:out value='${customer.email}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_WEBSITE%></td>	
				<td><c:out value='${customer.website}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_BANK%></td>	
				<td><c:out value='${customer.bank}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_BANK_ACCOUNT%></td>	
				<td><c:out value='${customer.bankAccount}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_BANK_ACCOUNT_NAME%></td>	
				<td><c:out value='${customer.bankAccountName}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_TAX_ID%></td>	
				<td><c:out value='${customer.taxId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_BUSINESS_PEOPLE%></td>	
				<td><c:out value='${customer.businessPeople}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_COLLECTION_PEOPLE%></td>	
				<td><c:out value='${customer.collectionPeople}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_CTIME%></td>	
				<td><c:out value='${customer.ctimeString}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Customer.ALIAS_REMARK%></td>	
				<td><c:out value='${customer.remark}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>