<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="stockOperationId" name="stockOperationId" value="${stockRecord.stockOperationId}"/>

	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_DEPT_ID%>:
		</td>		
		<td>
		<form:input path="deptId" id="deptId" cssClass="validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="deptId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_STAFF_ID%>:
		</td>		
		<td>
		<form:input path="staffId" id="staffId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="staffId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_OPER_TYPE%>:
		</td>		
		<td>
		<form:input path="operType" id="operType" cssClass="validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="operType"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_CUST_ID%>:
		</td>		
		<td>
		<form:input path="custId" id="custId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="custId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_OPER_DATE%>:
		</td>		
		<td>
		<input value="${stockRecord.operDateString}" onclick="WdatePicker({dateFmt:'<%=StockRecord.FORMAT_OPER_DATE%>'})" id="operDateString" name="operDateString"  maxlength="0" class="" />
		<font color='red'><form:errors path="operDate"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_APPROVAL_STATUS%>:
		</td>		
		<td>
		<form:input path="approvalStatus" id="approvalStatus" cssClass="validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="approvalStatus"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_APPROVAL_ID%>:
		</td>		
		<td>
		<form:input path="approvalId" id="approvalId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="approvalId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_STOCK_ID%>:
		</td>		
		<td>
		<form:input path="stockId" id="stockId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="stockId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_TO_STOCK_ID%>:
		</td>		
		<td>
		<form:input path="toStockId" id="toStockId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="toStockId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_REMARK%>:
		</td>		
		<td>
		<form:input path="remark" id="remark" cssClass="" maxlength="512" />
		<font color='red'><form:errors path="remark"/></font>
		</td>
	</tr>	
	
		