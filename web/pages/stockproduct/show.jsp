<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=StockProduct.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="stockproduct"  >
		<input type="button" value="返回列表" onclick="window.location='${ctx}/stockproduct'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="stockProductId" name="stockProductId" value="${stockProduct.stockProductId}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=StockProduct.ALIAS_STOCK_ID%></td>	
				<td><c:out value='${stockProduct.stockId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockProduct.ALIAS_PRODUCT_ID%></td>	
				<td><c:out value='${stockProduct.productId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockProduct.ALIAS_QUANTITY%></td>	
				<td><c:out value='${stockProduct.quantity}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockProduct.ALIAS_FIRST_ENTER_DATE%></td>	
				<td><c:out value='${stockProduct.firstEnterDateString}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockProduct.ALIAS_OUTER_DATE%></td>	
				<td><c:out value='${stockProduct.outerDateString}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockProduct.ALIAS_PRICE%></td>	
				<td><c:out value='${stockProduct.price}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>