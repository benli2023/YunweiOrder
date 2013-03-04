<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=ProductSupplier.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="productsupplier"  method="post">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/productsupplier'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="productSupplierId" name="productSupplierId" value="${productSupplier.productSupplierId}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=ProductSupplier.ALIAS_PRODUCT_ID%></td>	
				<td><c:out value='${productSupplier.productId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=ProductSupplier.ALIAS_CUST_ID%></td>	
				<td><c:out value='${productSupplier.custId}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>