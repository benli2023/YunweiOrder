<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=OrderGoods.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="ordergoods"  method="post">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/ordergoods'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="goodsId" name="goodsId" value="${orderGoods.goodsId}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=OrderGoods.ALIAS_GOODS_CODE%></td>	
				<td><c:out value='${orderGoods.goodsCode}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=OrderGoods.ALIAS_PRODUCT_ID%></td>	
				<td><c:out value='${orderGoods.productId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=OrderGoods.ALIAS_ORDER_ID%></td>	
				<td><c:out value='${orderGoods.orderId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=OrderGoods.ALIAS_UNIT%></td>	
				<td><c:out value='${orderGoods.unit}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=OrderGoods.ALIAS_UNIT_PRICE%></td>	
				<td><c:out value='${orderGoods.unitPrice}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=OrderGoods.ALIAS_QUANTITY%></td>	
				<td><c:out value='${orderGoods.quantity}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=OrderGoods.ALIAS_HANDED_QUANTITY%></td>	
				<td><c:out value='${orderGoods.handedQuantity}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=OrderGoods.ALIAS_UNTAXED_AMOUNT%></td>	
				<td><c:out value='${orderGoods.untaxedAmount}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=OrderGoods.ALIAS_TAX_RATE%></td>	
				<td><c:out value='${orderGoods.taxRate}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=OrderGoods.ALIAS_OUTPUT_TAX_AMOUNT%></td>	
				<td><c:out value='${orderGoods.outputTaxAmount}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=OrderGoods.ALIAS_TAX_AMOUNT%></td>	
				<td><c:out value='${orderGoods.taxAmount}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=OrderGoods.ALIAS_MODEL%></td>	
				<td><c:out value='${orderGoods.model}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=OrderGoods.ALIAS_REMARK%></td>	
				<td><c:out value='${orderGoods.remark}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>