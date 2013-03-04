<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="stockOperDetailId" name="stockOperDetailId" value="${stockRecordLine.stockOperDetailId}"/>

	<tr>	
		<td class="tdLabel">
			<%=StockRecordLine.ALIAS_STOCK_OPERATION_ID%>:
		</td>		
		<td>
		<form:input path="stockOperationId" id="stockOperationId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="stockOperationId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecordLine.ALIAS_PRODUCT_ID%>:
		</td>		
		<td>
		<form:input path="productId" id="productId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="productId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecordLine.ALIAS_PRICE%>:
		</td>		
		<td>
		<form:input path="price" id="price" cssClass="validate-integer " maxlength="10" />
		<font color='red'><form:errors path="price"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecordLine.ALIAS_QUANTITY%>:
		</td>		
		<td>
		<form:input path="quantity" id="quantity" cssClass="validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="quantity"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecordLine.ALIAS_HAVE_INVOICE%>:
		</td>		
		<td>
		<form:input path="haveInvoice" id="haveInvoice" cssClass="" maxlength="1" />
		<font color='red'><form:errors path="haveInvoice"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecordLine.ALIAS_INVOICE_NUMBER%>:
		</td>		
		<td>
		<form:input path="invoiceNumber" id="invoiceNumber" cssClass="" maxlength="32" />
		<font color='red'><form:errors path="invoiceNumber"/></font>
		</td>
	</tr>	
	
		