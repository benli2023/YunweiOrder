<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="stockOperDetailId" name="stockOperDetailId" value="${stockRecordLine.stockOperDetailId}"/>

	<tr>	
		<td class="tdLabel">
			<%=StockRecordLine.ALIAS_STOCK_OPERATION_ID%>:
		</td>		
		<td>
		<yun:button-edit name="stockOperationIdTxt" hiddenName="stockOperationId" id="stockRecordLine_stockOperationId" txtVal="${stockRecordLine.stockOperationIdTxt}"  hiddenVal="${stockRecordLine.stockOperationId}" width="130"  profileId="stock_record_line"/> 
	
		<font color='red'><form:errors path="stockOperationId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecordLine.ALIAS_PRODUCT_ID%>:
		</td>		
		<td>
		<yun:button-edit name="productIdTxt" hiddenName="productId" id="stockRecordLine_productId" txtVal="${stockRecordLine.productIdTxt}"  hiddenVal="${stockRecordLine.productId}" width="130"  profileId="stock"/> 
	
		<font color='red'><form:errors path="productId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecordLine.ALIAS_PRICE%>:
		</td>		
		<td>
		<form:input path="price" id="price" cssClass="validate-number " maxlength="10" />
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
		<form:select path="haveInvoice" id="haveInvoice">
			<form:option value="1" >有</form:option>
			<form:option value="0" >没有</form:option>
		</form:select>
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
	
		