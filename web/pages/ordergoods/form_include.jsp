<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="goodsId" name="goodsId" value="${orderGoods.goodsId}"/>

	<tr>	
		<td class="tdLabel">
			<%=OrderGoods.ALIAS_GOODS_CODE%>:
		</td>		
		<td>
		<form:input path="goodsCode" id="goodsCode" cssClass="" maxlength="256" />
		<font color='red'><form:errors path="goodsCode"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=OrderGoods.ALIAS_PRODUCT_ID%>:
		</td>		
		<td>
		<form:input path="productId" id="productId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="productId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=OrderGoods.ALIAS_ORDER_ID%>:
		</td>		
		<td>
		<form:input path="orderId" id="orderId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="orderId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=OrderGoods.ALIAS_UNIT%>:
		</td>		
		<td>
		<form:input path="unit" id="unit" cssClass="" maxlength="8" />
		<font color='red'><form:errors path="unit"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=OrderGoods.ALIAS_UNIT_PRICE%>:
		</td>		
		<td>
		<form:input path="unitPrice" id="unitPrice" cssClass="validate-integer " maxlength="10" />
		<font color='red'><form:errors path="unitPrice"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=OrderGoods.ALIAS_QUANTITY%>:
		</td>		
		<td>
		<form:input path="quantity" id="quantity" cssClass="validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="quantity"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=OrderGoods.ALIAS_HANDED_QUANTITY%>:
		</td>		
		<td>
		<form:input path="handedQuantity" id="handedQuantity" cssClass="validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="handedQuantity"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=OrderGoods.ALIAS_UNTAXED_AMOUNT%>:
		</td>		
		<td>
		<form:input path="untaxedAmount" id="untaxedAmount" cssClass="validate-integer " maxlength="10" />
		<font color='red'><form:errors path="untaxedAmount"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=OrderGoods.ALIAS_TAX_RATE%>:
		</td>		
		<td>
		<form:input path="taxRate" id="taxRate" cssClass="validate-number " maxlength="8" />
		<font color='red'><form:errors path="taxRate"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=OrderGoods.ALIAS_OUTPUT_TAX_AMOUNT%>:
		</td>		
		<td>
		<form:input path="outputTaxAmount" id="outputTaxAmount" cssClass="validate-integer " maxlength="10" />
		<font color='red'><form:errors path="outputTaxAmount"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=OrderGoods.ALIAS_TAX_AMOUNT%>:
		</td>		
		<td>
		<form:input path="taxAmount" id="taxAmount" cssClass="validate-integer " maxlength="10" />
		<font color='red'><form:errors path="taxAmount"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=OrderGoods.ALIAS_MODEL%>:
		</td>		
		<td>
		<form:input path="model" id="model" cssClass="" maxlength="8" />
		<font color='red'><form:errors path="model"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=OrderGoods.ALIAS_REMARK%>:
		</td>		
		<td>
		<form:input path="remark" id="remark" cssClass="" maxlength="512" />
		<font color='red'><form:errors path="remark"/></font>
		</td>
	</tr>	
	
		