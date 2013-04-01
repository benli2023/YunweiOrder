<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<form:errors />
	<input type="hidden" id="stockOperationId" name="stockOperationId" value="${stockRecord.stockOperationId}"/>
	<input type="hidden" name="jsonData" id="product_json_data" />
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_STOCK_OPERATION_NAME%>:
		</td>		
		<td>
		<form:input path="stockOperationName" id="stockOperationName" cssClass="" maxlength="256" />
		<font color='red'><form:errors path="stockOperationName"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_DEPT_ID%>:
		</td>		
		<td>
		<yun:button-edit name="deptIdTxt" hiddenName="deptId" id="stockRecord_deptId" txtVal="${stockRecord.deptIdTxt}"  hiddenVal="${stockRecord.deptId}" width="130"  profileId="dept"/> 
	
		<font color='red'><form:errors path="deptId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_STAFF_ID%>:
		</td>		
		<td>
		<yun:button-edit name="staffIdTxt" hiddenName="staffId" id="stockRecord_staffId" txtVal="${stockRecord.staffIdTxt}"  hiddenVal="${stockRecord.staffId}" width="130"  profileId="staff"/> 
	
		<font color='red'><form:errors path="staffId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_OPER_TYPE%>:
		</td>		
		<td>
		<form:select path="operType" id="operType">
			<!-- <form:option value="1" >出库</form:option> -->
			<form:option value="2" >入库</form:option>
			<!-- 
			<form:option value="3" >退货</form:option>
			<form:option value="4" >转存</form:option>
			 -->
		</form:select>
		<font color='red'><form:errors path="operType"/></font>
		</td>
	</tr>	
	
	<!--  
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_CUST_ID%>:
		</td>		
		<td>
		<yun:button-edit name="custIdTxt" hiddenName="custId" id="stockRecord_custId" txtVal="${stockRecord.custIdTxt}"  hiddenVal="${stockRecord.custId}" width="130"  profileId="stock"/> 
	
		<font color='red'><form:errors path="custId"/></font>
		</td>
	</tr>	
	-->
	
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
		<form:select path="approvalStatus" id="approvalStatus">
			<form:option value="1" >待审核</form:option>
			<form:option value="2" >审核通过</form:option>
			<form:option value="3" >审核未通过</form:option>
		</form:select>
		<font color='red'><form:errors path="approvalStatus"/></font>
		</td>
	</tr>	
	
	<!-- 
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_APPROVAL_ID%>:
		</td>		
		<td>
		<yun:button-edit name="approvalIdTxt" hiddenName="approvalId" id="stockRecord_approvalId" txtVal="${stockRecord.approvalIdTxt}"  hiddenVal="${stockRecord.approvalId}" width="130"  profileId="staff"/> 
	
		<font color='red'><form:errors path="approvalId"/></font>
		</td>
	</tr>	
	 -->
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_STOCK_ID%>:
		</td>		
		<td>
		<yun:button-edit name="stockIdTxt" hiddenName="stockId" id="stockRecord_stockId" txtVal="${stockRecord.stockIdTxt}"  hiddenVal="${stockRecord.stockId}" width="130"  profileId="stockRecord"/> 
	
		<font color='red'><form:errors path="stockId"/></font>
		</td>
	</tr>	
	
	<!--  
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_TO_STOCK_ID%>:
		</td>		
		<td>
		<yun:button-edit name="toStockIdTxt" hiddenName="toStockId" id="stockRecord_toStockId" txtVal="${stockRecord.toStockIdTxt}"  hiddenVal="${stockRecord.toStockId}" width="130"  profileId="stockRecord"/> 
	
		<font color='red'><form:errors path="toStockId"/></font>
		</td>
	</tr>	
	-->
	<tr>	
		<td class="tdLabel">
			<%=StockRecord.ALIAS_REMARK%>:
		</td>		
		<td>
		<form:input path="remark" id="remark" cssClass="" maxlength="512" />
		<font color='red'><form:errors path="remark"/></font>
		</td>
	</tr>	
	
	
	
		