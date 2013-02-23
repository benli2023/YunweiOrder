<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=StockRecordLine.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="stockrecordline"  method="post">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/stockrecordline'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="stockOperDetailId" name="stockOperDetailId" value="${stockRecordLine.stockOperDetailId}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=StockRecordLine.ALIAS_STOCK_OPERATION_ID%></td>	
				<td><c:out value='${stockRecordLine.stockOperationId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockRecordLine.ALIAS_PRODUCT_ID%></td>	
				<td><c:out value='${stockRecordLine.productId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockRecordLine.ALIAS_PRICE%></td>	
				<td><c:out value='${stockRecordLine.price}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockRecordLine.ALIAS_QUANTITY%></td>	
				<td><c:out value='${stockRecordLine.quantity}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockRecordLine.ALIAS_HAVE_INVOICE%></td>	
				<td><c:out value='${stockRecordLine.haveInvoice}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockRecordLine.ALIAS_INVOICE_NUMBER%></td>	
				<td><c:out value='${stockRecordLine.invoiceNumber}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>