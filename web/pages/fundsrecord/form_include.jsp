<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="fundsId" name="fundsId" value="${fundsRecord.fundsId}"/>

	<tr>	
		<td class="tdLabel">
			<%=FundsRecord.ALIAS_APPROVAL_ID%>:
		</td>		
		<td>
		<form:input path="approvalId" id="approvalId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="approvalId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=FundsRecord.ALIAS_STAFF_ID%>:
		</td>		
		<td>
		<form:input path="staffId" id="staffId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="staffId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=FundsRecord.ALIAS_ORDER_ID%>:
		</td>		
		<td>
		<form:input path="orderId" id="orderId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="orderId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=FundsRecord.ALIAS_CUST_ID%>:
		</td>		
		<td>
		<form:input path="custId" id="custId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="custId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=FundsRecord.ALIAS_FUNDS_TYPE%>:
		</td>		
		<td>
		<form:input path="fundsType" id="fundsType" cssClass="validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="fundsType"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=FundsRecord.ALIAS_AMOUNT%>:
		</td>		
		<td>
		<form:input path="amount" id="amount" cssClass="validate-integer " maxlength="10" />
		<font color='red'><form:errors path="amount"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=FundsRecord.ALIAS_PAID_AMOUNT%>:
		</td>		
		<td>
		<form:input path="paidAmount" id="paidAmount" cssClass="validate-integer " maxlength="10" />
		<font color='red'><form:errors path="paidAmount"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=FundsRecord.ALIAS_APPROVAL_STATUS%>:
		</td>		
		<td>
		<form:input path="approvalStatus" id="approvalStatus" cssClass="validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="approvalStatus"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=FundsRecord.ALIAS_APPROVAL_DATE%>:
		</td>		
		<td>
		<input value="${fundsRecord.approvalDateString}" onclick="WdatePicker({dateFmt:'<%=FundsRecord.FORMAT_APPROVAL_DATE%>'})" id="approvalDateString" name="approvalDateString"  maxlength="0" class="" />
		<font color='red'><form:errors path="approvalDate"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=FundsRecord.ALIAS_STATUS%>:
		</td>		
		<td>
		<form:input path="status" id="status" cssClass="validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="status"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=FundsRecord.ALIAS_PAYMENT_MODE%>:
		</td>		
		<td>
		<form:input path="paymentMode" id="paymentMode" cssClass="" maxlength="8" />
		<font color='red'><form:errors path="paymentMode"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=FundsRecord.ALIAS_REMARK%>:
		</td>		
		<td>
		<form:input path="remark" id="remark" cssClass="" maxlength="512" />
		<font color='red'><form:errors path="remark"/></font>
		</td>
	</tr>	
	
		