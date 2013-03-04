<%@page import="com.yunwei.order.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=StockRecord.TABLE_ALIAS%> 维护</title>
	
	<script src="${ctx}/scripts/rest.js" ></script>
	<link href="<c:url value="/widgets/simpletable/simpletable.css"/>" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="<c:url value="/widgets/simpletable/simpletable.js"/>"></script>
	
	<script type="text/javascript" >
		$(document).ready(function() {
			// 分页需要依赖的初始化动作
			window.simpleTable = new SimpleTable('queryForm',${page.thisPageNumber},${page.pageSize},'${pageRequest.sortColumns}');
		});
	</script>
</rapid:override>

<rapid:override name="content">
	<form id="queryForm" name="queryForm" method="get" style="display: inline;">
	<div class="queryPanel">
		<fieldset>
			<legend>搜索</legend>
			<table>
				<tr>	
					<td class="tdLabel"><%=StockRecord.ALIAS_DEPT_ID%></td>		
					<td>
						<input value="${query.deptId}" id="deptId" name="deptId" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=StockRecord.ALIAS_STAFF_ID%></td>		
					<td>
						<input value="${query.staffId}" id="staffId" name="staffId" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=StockRecord.ALIAS_OPER_TYPE%></td>		
					<td>
						<input value="${query.operType}" id="operType" name="operType" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=StockRecord.ALIAS_CUST_ID%></td>		
					<td>
						<input value="${query.custId}" id="custId" name="custId" maxlength="19"  class="validate-integer "/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=StockRecord.ALIAS_OPER_DATE%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.operDateBegin}' pattern='<%=StockRecord.FORMAT_OPER_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=StockRecord.FORMAT_OPER_DATE%>'})" id="operDateBegin" name="operDateBegin"   />
						<input value="<fmt:formatDate value='${query.operDateEnd}' pattern='<%=StockRecord.FORMAT_OPER_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=StockRecord.FORMAT_OPER_DATE%>'})" id="operDateEnd" name="operDateEnd"   />
					</td>
					<td class="tdLabel"><%=StockRecord.ALIAS_APPROVAL_STATUS%></td>		
					<td>
						<input value="${query.approvalStatus}" id="approvalStatus" name="approvalStatus" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=StockRecord.ALIAS_APPROVAL_ID%></td>		
					<td>
						<input value="${query.approvalId}" id="approvalId" name="approvalId" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=StockRecord.ALIAS_STOCK_ID%></td>		
					<td>
						<input value="${query.stockId}" id="stockId" name="stockId" maxlength="19"  class="validate-integer "/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=StockRecord.ALIAS_TO_STOCK_ID%></td>		
					<td>
						<input value="${query.toStockId}" id="toStockId" name="toStockId" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=StockRecord.ALIAS_REMARK%></td>		
					<td>
						<input value="${query.remark}" id="remark" name="remark" maxlength="512"  class=""/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/stockrecord'"/>
			<input type="button" class="stdButton" style="width:80px" value="新增" onclick="window.location = '${ctx}/stockrecord/new'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="doRestBatchDelete('${ctx}/stockrecord','items',document.forms.queryForm)"/>
		<div>
	
	</div>
	
	<div class="gridTable">
	
		<simpletable:pageToolbar page="${page}">
		显示在这里是为了提示你如何自定义表头,可修改模板删除此行
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="gridBody">
		  <thead>
			  
			  <tr>
				<th style="width:1px;"> </th>
				<th style="width:1px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="dept_id" ><%=StockRecord.ALIAS_DEPT_ID%></th>
				<th sortColumn="staff_id" ><%=StockRecord.ALIAS_STAFF_ID%></th>
				<th sortColumn="oper_type" ><%=StockRecord.ALIAS_OPER_TYPE%></th>
				<th sortColumn="cust_id" ><%=StockRecord.ALIAS_CUST_ID%></th>
				<th sortColumn="oper_date" ><%=StockRecord.ALIAS_OPER_DATE%></th>
				<th sortColumn="approval_status" ><%=StockRecord.ALIAS_APPROVAL_STATUS%></th>
				<th sortColumn="approval_id" ><%=StockRecord.ALIAS_APPROVAL_ID%></th>
				<th sortColumn="stock_id" ><%=StockRecord.ALIAS_STOCK_ID%></th>
				<th sortColumn="to_stock_id" ><%=StockRecord.ALIAS_TO_STOCK_ID%></th>
				<th sortColumn="remark" ><%=StockRecord.ALIAS_REMARK%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.stockOperationId}"></td>
				
				<td><c:out value='${item.deptId}'/>&nbsp;</td>
				<td><c:out value='${item.staffId}'/>&nbsp;</td>
				<td><c:out value='${item.operType}'/>&nbsp;</td>
				<td><c:out value='${item.custId}'/>&nbsp;</td>
				<td><c:out value='${item.operDateString}'/>&nbsp;</td>
				<td><c:out value='${item.approvalStatus}'/>&nbsp;</td>
				<td><c:out value='${item.approvalId}'/>&nbsp;</td>
				<td><c:out value='${item.stockId}'/>&nbsp;</td>
				<td><c:out value='${item.toStockId}'/>&nbsp;</td>
				<td><c:out value='${item.remark}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/stockrecord/${item.stockOperationId}">查看</a>&nbsp;&nbsp;
					<a href="${ctx}/stockrecord/${item.stockOperationId}/edit">修改</a>&nbsp;&nbsp;
					<a href="${ctx}/stockrecord/${item.stockOperationId}" onclick="doRestDelete(this,'你确认删除?');return false;">删除</a>
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar page="${page}">
		显示在这里是为了提示你如何自定义表头,可修改模板删除此行
		</simpletable:pageToolbar>
		
	</div>
	</form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>
