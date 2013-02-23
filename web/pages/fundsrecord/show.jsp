<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=FundsRecord.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="fundsrecord"  method="post">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/fundsrecord'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="fundsId" name="fundsId" value="${fundsRecord.fundsId}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=FundsRecord.ALIAS_APPROVAL_ID%></td>	
				<td><c:out value='${fundsRecord.approvalId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=FundsRecord.ALIAS_STAFF_ID%></td>	
				<td><c:out value='${fundsRecord.staffId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=FundsRecord.ALIAS_ORDER_ID%></td>	
				<td><c:out value='${fundsRecord.orderId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=FundsRecord.ALIAS_CUST_ID%></td>	
				<td><c:out value='${fundsRecord.custId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=FundsRecord.ALIAS_FUNDS_TYPE%></td>	
				<td><c:out value='${fundsRecord.fundsType}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=FundsRecord.ALIAS_AMOUNT%></td>	
				<td><c:out value='${fundsRecord.amount}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=FundsRecord.ALIAS_PAID_AMOUNT%></td>	
				<td><c:out value='${fundsRecord.paidAmount}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=FundsRecord.ALIAS_APPROVAL_STATUS%></td>	
				<td><c:out value='${fundsRecord.approvalStatus}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=FundsRecord.ALIAS_APPROVAL_DATE%></td>	
				<td><c:out value='${fundsRecord.approvalDateString}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=FundsRecord.ALIAS_STATUS%></td>	
				<td><c:out value='${fundsRecord.status}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=FundsRecord.ALIAS_PAYMENT_MODE%></td>	
				<td><c:out value='${fundsRecord.paymentMode}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=FundsRecord.ALIAS_REMARK%></td>	
				<td><c:out value='${fundsRecord.remark}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>