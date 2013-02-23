<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="productSupplierId" name="productSupplierId" value="${productSupplier.productSupplierId}"/>

	<tr>	
		<td class="tdLabel">
			<%=ProductSupplier.ALIAS_PRODUCT_ID%>:
		</td>		
		<td>
		<form:input path="productId" id="productId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="productId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=ProductSupplier.ALIAS_CUST_ID%>:
		</td>		
		<td>
		<form:input path="custId" id="custId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="custId"/></font>
		</td>
	</tr>	
	
		