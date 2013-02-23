<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=Product.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="product"  method="post">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/product'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="productId" name="productId" value="${product.productId}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=Product.ALIAS_CAT_ID%></td>	
				<td><c:out value='${product.catId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Product.ALIAS_PRODUCT_NAME%></td>	
				<td><c:out value='${product.productName}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Product.ALIAS_PRODUCT_CODE%></td>	
				<td><c:out value='${product.productCode}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Product.ALIAS_CEIL_LIMIT%></td>	
				<td><c:out value='${product.ceilLimit}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Product.ALIAS_LOW_LIMIT%></td>	
				<td><c:out value='${product.lowLimit}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Product.ALIAS_PINY_CODE%></td>	
				<td><c:out value='${product.pinyCode}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Product.ALIAS_PRODUCT_SPEC%></td>	
				<td><c:out value='${product.productSpec}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Product.ALIAS_SALE_PRICE%></td>	
				<td><c:out value='${product.salePrice}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Product.ALIAS_PURCHASE_PRICE%></td>	
				<td><c:out value='${product.purchasePrice}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Product.ALIAS_IS_AVAILABLE%></td>	
				<td><c:choose ><c:when test="${product.isAvailable==1}">是</c:when><c:when test="${product.isAvailable==0}">否</c:when></c:choose></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Product.ALIAS_IS_SELLABLE%></td>	
				<td><c:choose ><c:when test="${product.isSellable==1}">是</c:when><c:when test="${product.isSellable==0}">否</c:when></c:choose></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Product.ALIAS_IS_NEGATIVE%></td>	
				<td><c:choose ><c:when test="${product.isNegative==1}">是</c:when><c:when test="${product.isNegative==0}">否</c:when></c:choose></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Product.ALIAS_IS_PURCHASABLE%></td>	
				<td><c:choose ><c:when test="${product.isPurchasable==1}">是</c:when><c:when test="${product.isPurchasable==0}">否</c:when></c:choose></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Product.ALIAS_PRODUCT_IMAGE%></td>	
				
				<td><img id="preview" <c:if test="${! empty product.productImage}">src="${ctx}/${product.productImage}" </c:if>  alt="" style="<c:if test="${ empty product.productImage}">display:none;</c:if> max-width: 160px; max-height: 120px; border: none; width:160px;height:120px"/></td>

			</tr>
			<tr>	
				<td class="tdLabel"><%=Product.ALIAS_MANUFACTURER%></td>	
				<td><c:out value='${product.manufacturer}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Product.ALIAS_ORGINAL_PLACE%></td>	
				<td><c:out value='${product.orginalPlace}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Product.ALIAS_CTIME%></td>	
				<td><c:out value='${product.ctimeString}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%@ include file="base.jsp" %>