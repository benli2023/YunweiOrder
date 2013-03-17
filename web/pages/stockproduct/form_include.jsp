<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="stockProductId" name="stockProductId" value="${stockProduct.stockProductId}"/>

	<tr>	
		<td class="tdLabel">
			<%=StockProduct.ALIAS_STOCK_ID%>:
		</td>		
		<td>
		<yun:button-edit name="stockIdTxt" hiddenName="stockId" id="stockProduct_stockId" txtVal="${stockProduct.stockIdTxt}"  hiddenVal="${stockProduct.stockId}" width="130"  profileId="stockRecord"/> 
	
		<font color='red'><form:errors path="stockId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockProduct.ALIAS_PRODUCT_ID%>:
		</td>		
		<td>
		<yun:button-edit name="productIdTxt" hiddenName="productId" id="stockProduct_productId" txtVal="${stockProduct.productIdTxt}"  hiddenVal="${stockProduct.productId}" width="130"  profileId="stock"/> 
	
		<font color='red'><form:errors path="productId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockProduct.ALIAS_QUANTITY%>:
		</td>		
		<td>
		<form:input path="quantity" id="quantity" cssClass="validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="quantity"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockProduct.ALIAS_FIRST_ENTER_DATE%>:
		</td>		
		<td>
		<input value="${stockProduct.firstEnterDateString}" onclick="WdatePicker({dateFmt:'<%=StockProduct.FORMAT_FIRST_ENTER_DATE%>'})" id="firstEnterDateString" name="firstEnterDateString"  maxlength="0" class="" />
	
		<font color='red'><form:errors path="firstEnterDate"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockProduct.ALIAS_OUTER_DATE%>:
		</td>		
		<td>
		<input value="${stockProduct.outerDateString}" onclick="WdatePicker({dateFmt:'<%=StockProduct.FORMAT_OUTER_DATE%>'})" id="outerDateString" name="outerDateString"  maxlength="0" class="" />
	
		<font color='red'><form:errors path="outerDate"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockProduct.ALIAS_PRICE%>:
		</td>		
		<td>
		<form:input path="price" id="price" cssClass="validate-integer " maxlength="10" />
		<font color='red'><form:errors path="price"/></font>
		</td>
	</tr>	
	
		