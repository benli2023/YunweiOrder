<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=StockRecord.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="stockrecord"  >
		<input type="button" value="返回列表" onclick="window.location='${ctx}/stockrecord'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="stockOperationId" name="stockOperationId" value="${stockRecord.stockOperationId}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=StockRecord.ALIAS_STOCK_OPERATION_NAME%></td>	
				<td><c:out value='${stockRecord.stockOperationName}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockRecord.ALIAS_DEPT_ID%></td>	
				<td><c:out value='${stockRecord.deptId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockRecord.ALIAS_STAFF_ID%></td>	
				<td><c:out value='${stockRecord.staffId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockRecord.ALIAS_OPER_TYPE%></td>	
				<td><c:out value='${stockRecord.operType}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockRecord.ALIAS_CUST_ID%></td>	
				<td><c:out value='${stockRecord.custId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockRecord.ALIAS_OPER_DATE%></td>	
				<td><c:out value='${stockRecord.operDateString}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockRecord.ALIAS_APPROVAL_STATUS%></td>	
				<td><c:out value='${stockRecord.approvalStatus}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockRecord.ALIAS_APPROVAL_ID%></td>	
				<td><c:out value='${stockRecord.approvalId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockRecord.ALIAS_STOCK_ID%></td>	
				<td><c:out value='${stockRecord.stockId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockRecord.ALIAS_TO_STOCK_ID%></td>	
				<td><c:out value='${stockRecord.toStockId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockRecord.ALIAS_REMARK%></td>	
				<td><c:out value='${stockRecord.remark}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>