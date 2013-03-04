<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="orderId" name="orderId" value="${saleOrder.orderId}"/>

	<div class="formRow">
				<label for="orderNo"><%=SaleOrder.ALIAS_ORDER_NO%></label>
				<form:input path="orderNo" id="orderNo" cssClass="input-text " maxlength="16" />
	
	</div>
	
	
	<div class="formRow">
		<label for="staffId"><%=SaleOrder.ALIAS_STAFF_ID%></label>
		<form:input path="staffId" id="staffId" cssClass="input-text small" maxlength="19" />
		<input id="staffId1" name="staffId1" type="hidden" class="userIDHidden"/>
	</div>
	
	
	<div class="formRow">
		<label for="custId"><%=SaleOrder.ALIAS_CUST_ID%></label>
		<form:input path="custId" id="custId" cssClass="input-text small" maxlength="19" />
		<input id="custId1" name="custId1" type="hidden" class="userIDHidden"/>
	</div>
	
	<div class="formRow">
		<label for="orderDateString"><%=SaleOrder.ALIAS_ORDER_DATE%></label>
		<input value="" name="orderDateString" id="orderDateString" class="input-text small" maxlength="16"  />
	</div>
	
	<div class="formRow">
		<label for="paymentMode"><%=SaleOrder.ALIAS_PAYMENT_MODE%></label>
		<form:input path="paymentMode" id="paymentMode" cssClass="input-text " maxlength="16" />
	</div>
	
	<div class="formRow form-field error">
		<label for="invoiceNo"><%=SaleOrder.ALIAS_INVOICE_NO%></label>
		<form:input path="invoiceNo" id="invoiceNo" cssClass="input-text " maxlength="16" />
		<small><form:errors path="invoiceNo"/></small>
	</div>
	
	<div class="formRow form-field error">
		<label for="description"><%=SaleOrder.ALIAS_DESCRIPTION%></label>
		<textarea rows="1" cols="1" id="description" name="description"></textarea>
		<small><form:errors path="description"/></small>
	</div>

	<div class="formRow">
		<label for="accountingDeptId"><%=SaleOrder.ALIAS_ACCOUNTING_DEPT_ID%></label>
		<form:input path="accountingDeptId" id="accountingDeptId" cssClass="input-text " maxlength="19" />
		<input id="accountingDeptId1" name="accountingDeptId1" type="hidden" class="userIDHidden"/>
	</div>
	
	<div class="formRow">
			<label for="currency"><%=SaleOrder.ALIAS_CURRENCY%></label>
			<select id="currency" name="currency">
				<option value=""> --- Please Select --- </option>
				<option value="option_1">CNY</option>
				<option value="option_2">USD</option>
				<option value="option_3">GBP</option>
			</select>
	</div>
	
	<div class="formRow">
			<label for="deliveryMethod"><%=SaleOrder.ALIAS_DELIVERY_METHOD%></label>
			<select id="deliveryMethod" name="deliveryMethod">
				<option value=""> --- Please Select --- </option>
				<option value="option_1">CNY</option>
				<option value="option_2">USD</option>
				<option value="option_3">GBP</option>
			</select>
	</div>

	<div class="formRow">
			<label for="orderDateString"><%=SaleOrder.ALIAS_DELIVERY_DATE%></label>
			<form:input path="deliveryDateString" id="deliveryDateString" cssClass="input-text small" maxlength="16" />
	</div>
	
	<div class="formRow">
		<label for="additionalText"><%=SaleOrder.ALIAS_ADDITIONAL_TEXT%></label>
		<textarea rows="1" cols="1" id="additionalText" name="additionalText"></textarea>
	</div>
	
	<div class="formRow">
		<p><%=SaleOrder.ALIAS_IS_AVAILABLE%></p>
		<div class="row">
			<div class="three columns">
				<label for="nice_radio1"><input type="radio" id="nice_radio1" name="isAvailable" value="1"> 是</label>
			</div>
			<div class="three columns">
				<label for="nice_radio2"><input type="radio" id="nice_radio2" name="isAvailable"	value="0">否</label>
			</div>
			<div class="six columns">
			</div>

		</div>
	</div>
	



	
		