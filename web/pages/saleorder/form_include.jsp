<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
	<form:errors />
	<input type="hidden" id="orderId" name="orderId" value="${saleOrder.orderId}"/>
	<input type="hidden" name="jsonData" id="product_json_data" />
	<tr>	
		<td class="tdLabel">
			<span class="required">*</span><%=SaleOrder.ALIAS_ORDER_NO%>:
		</td>		
		<td>
		<form:input path="orderNo" id="orderNo" cssClass="required " maxlength="16" />
		<font color='red'><form:errors path="orderNo"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=SaleOrder.ALIAS_STAFF_ID%>:
		</td>		
		<td>
		<yun:button-edit name="staffIdTxt" hiddenName="staffId" id="saleOrder_staffId" txtVal="${saleOrder.staffIdTxt}"  hiddenVal="${saleOrder.staffId}" width="130"  profileId="staff"/> 
	
		<font color='red'><form:errors path="staffId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=SaleOrder.ALIAS_CUST_ID%>:
		</td>		
		<td>
		<yun:button-edit name="custIdTxt" hiddenName="custId" id="saleOrder_custId" txtVal="${saleOrder.custIdTxt}"  hiddenVal="${saleOrder.custId}" width="130"  profileId="stock"/> 
	
		<font color='red'><form:errors path="custId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=SaleOrder.ALIAS_ORDER_DATE%>:
		</td>		
		<td>
		<input value="${saleOrder.orderDateString}" onclick="WdatePicker({dateFmt:'<%=SaleOrder.FORMAT_ORDER_DATE%>'})" id="orderDateString" name="orderDateString"  maxlength="0" class="" />
	
		<font color='red'><form:errors path="orderDate"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=SaleOrder.ALIAS_PAYMENT_MODE%>:
		</td>		
		<td>
		<form:select path="paymentMode" id="paymentMode">
			<form:option value="1" >支票</form:option>
			<form:option value="0" >现金</form:option>
		</form:select>
		<font color='red'><form:errors path="paymentMode"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=SaleOrder.ALIAS_INVOICE_NO%>:
		</td>		
		<td>
		<form:input path="invoiceNo" id="invoiceNo" cssClass="" maxlength="128" />
		<font color='red'><form:errors path="invoiceNo"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=SaleOrder.ALIAS_DESCRIPTION%>:
		</td>		
		<td>
		<form:textarea path="description" id="description" cssClass="" maxlength="512" />
		<font color='red'><form:errors path="description"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=SaleOrder.ALIAS_ACCOUNTING_DEPT_ID%>:
		</td>		
		<td>
		<yun:button-edit name="accountingDeptIdTxt" hiddenName="accountingDeptId" id="saleOrder_accountingDeptId" txtVal="${saleOrder.accountingDeptIdTxt}"  hiddenVal="${saleOrder.accountingDeptId}" width="130"  profileId="dept"/> 
	
		<font color='red'><form:errors path="accountingDeptId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=SaleOrder.ALIAS_CURRENCY%>:
		</td>		
		<td>
		<form:select path="currency" id="currency">
			<form:option value="1" >美元</form:option>
			<form:option value="0" >人民币</form:option>
		</form:select>
		<font color='red'><form:errors path="currency"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=SaleOrder.ALIAS_DELIVERY_METHOD%>:
		</td>		
		<td>
		<form:select path="deliveryMethod" id="deliveryMethod">
			<form:option value="1" >快递</form:option>
			<form:option value="0" >货运</form:option>
		</form:select>
		<font color='red'><form:errors path="deliveryMethod"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=SaleOrder.ALIAS_DELIVERY_DATE%>:
		</td>		
		<td>
		<input value="${saleOrder.deliveryDateString}" onclick="WdatePicker({dateFmt:'<%=SaleOrder.FORMAT_DELIVERY_DATE%>'})" id="deliveryDateString" name="deliveryDateString"  maxlength="0" class="" />
	
		<font color='red'><form:errors path="deliveryDate"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=SaleOrder.ALIAS_ADDITIONAL_TEXT%>:
		</td>		
		<td>
		<form:textarea path="additionalText" id="additionalText" cssClass="" maxlength="65535" />
		<font color='red'><form:errors path="additionalText"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=SaleOrder.ALIAS_IS_AVAILABLE%>:
		</td>		
		<td>
		<form:select path="isAvailable" id="isAvailable">
			<form:option value="1" >是</form:option>
			<form:option value="0" >否</form:option>
		</form:select>
		<font color='red'><form:errors path="isAvailable"/></font>
		</td>
	</tr>	
	
	
	<!--  
	<tr>	
		<td class="tdLabel">
			<%=SaleOrder.ALIAS_UPDATOR%>:
		</td>		
		<td>
		<form:input path="updator" id="updator" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="updator"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=SaleOrder.ALIAS_UTIME%>:
		</td>		
		<td>
		<input value="${saleOrder.utimeString}" onclick="WdatePicker({dateFmt:'<%=SaleOrder.FORMAT_UTIME%>'})" id="utimeString" name="utimeString"  maxlength="0" class="" />
	
		<font color='red'><form:errors path="utime"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=SaleOrder.ALIAS_CTIME%>:
		</td>		
		<td>
		<input value="${saleOrder.ctimeString}" onclick="WdatePicker({dateFmt:'<%=SaleOrder.FORMAT_CTIME%>'})" id="ctimeString" name="ctimeString"  maxlength="0" class="" />
	
		<font color='red'><form:errors path="ctime"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=SaleOrder.ALIAS_CREATOR_ID%>:
		</td>		
		<td>
		<form:input path="creatorId" id="creatorId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="creatorId"/></font>
		</td>
	</tr>	
	-->
		