<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=SaleOrder.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="saleorder"  method="post">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/saleorder'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="orderId" name="orderId" value="${saleOrder.orderId}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=SaleOrder.ALIAS_ORDER_NO%></td>	
				<td><c:out value='${saleOrder.orderNo}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SaleOrder.ALIAS_STAFF_ID%></td>	
				<td><c:out value='${saleOrder.staffId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SaleOrder.ALIAS_CUST_ID%></td>	
				<td><c:out value='${saleOrder.custId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SaleOrder.ALIAS_ORDER_DATE%></td>	
				<td><c:out value='${saleOrder.orderDateString}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SaleOrder.ALIAS_PAYMENT_MODE%></td>	
				<td><c:out value='${saleOrder.paymentMode}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SaleOrder.ALIAS_INVOICE_NO%></td>	
				<td><c:out value='${saleOrder.invoiceNo}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SaleOrder.ALIAS_DESCRIPTION%></td>	
				<td><c:out value='${saleOrder.description}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SaleOrder.ALIAS_ACCOUNTING_DEPT_ID%></td>	
				<td><c:out value='${saleOrder.accountingDeptId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SaleOrder.ALIAS_CURRENCY%></td>	
				<td><c:out value='${saleOrder.currency}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SaleOrder.ALIAS_DELIVERY_METHOD%></td>	
				<td><c:out value='${saleOrder.deliveryMethod}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SaleOrder.ALIAS_DELIVERY_DATE%></td>	
				<td><c:out value='${saleOrder.deliveryDateString}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SaleOrder.ALIAS_ADDITIONAL_TEXT%></td>	
				<td><c:out value='${saleOrder.additionalText}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SaleOrder.ALIAS_IS_AVAILABLE%></td>	
				<td><c:out value='${saleOrder.isAvailable}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SaleOrder.ALIAS_UPDATOR%></td>	
				<td><c:out value='${saleOrder.updator}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SaleOrder.ALIAS_UTIME%></td>	
				<td><c:out value='${saleOrder.utimeString}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SaleOrder.ALIAS_CTIME%></td>	
				<td><c:out value='${saleOrder.ctimeString}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=SaleOrder.ALIAS_CREATOR_ID%></td>	
				<td><c:out value='${saleOrder.creatorId}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>