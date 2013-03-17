<%@page import="com.yunwei.order.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=StockRecord.TABLE_ALIAS%> 维护</title>
	<%@ include file="../../commons/opera-maskui-dialog-import.jsp" %>
	<link href="<c:url value="${ctx}/scripts/plugins/popup-input/popup-input.css"/>" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${ctx}/scripts/plugins/popup-input/popup_selection.js"></script>
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
					<td class="tdLabel"><%=StockRecord.ALIAS_STOCK_OPERATION_NAME%></td>		
					<td>
						<input value="${query.stockOperationName}" id="stockOperationName" name="stockOperationName" maxlength="256"  class=""/>
					</td>
					<td class="tdLabel"><%=StockRecord.ALIAS_DEPT_ID%></td>		
					<td>
						<yun:button-edit name="deptIdTxt" hiddenName="deptId" id="stockRecord_deptId" txtVal="${query.deptIdTxt}"  hiddenVal="${query.deptId}" width="130"  profileId="dept"/> 
						
					</td>
					<td class="tdLabel"><%=StockRecord.ALIAS_STAFF_ID%></td>		
					<td>
						<yun:button-edit name="staffIdTxt" hiddenName="staffId" id="stockRecord_staffId" txtVal="${query.staffIdTxt}"  hiddenVal="${query.staffId}" width="130"  profileId="staff"/> 
						
					</td>
					<td class="tdLabel"><%=StockRecord.ALIAS_OPER_TYPE%></td>		
					<td>
						<select name="operType">
						    <!--  
							<option value="1" <c:if test="${query.operType==1}">selected</c:if>>出库</option>
							-->
							<option value="2" <c:if test="${query.operType==2}">selected</c:if>>入库</option>
							<!--  
							<option value="3" <c:if test="${query.operType==3}">selected</c:if>>退货</option>
							<option value="4" <c:if test="${query.operType==4}">selected</c:if>>转存</option>
							-->
							<option value="-1" <c:if test="${query.operType==-1}">selected</c:if>>不限</option>
						</select>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=StockRecord.ALIAS_CUST_ID%></td>		
					<td>
						<yun:button-edit name="custIdTxt" hiddenName="custId" id="stockRecord_custId" txtVal="${query.custIdTxt}"  hiddenVal="${query.custId}" width="130"  profileId="stock"/> 
						
					</td>
					<td class="tdLabel"><%=StockRecord.ALIAS_OPER_DATE%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.operDateBegin}' pattern='<%=StockRecord.FORMAT_OPER_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=StockRecord.FORMAT_OPER_DATE%>'})" id="operDateBegin" name="operDateBegin"   />
						<input value="<fmt:formatDate value='${query.operDateEnd}' pattern='<%=StockRecord.FORMAT_OPER_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=StockRecord.FORMAT_OPER_DATE%>'})" id="operDateEnd" name="operDateEnd"   />
					</td>
					<td class="tdLabel"><%=StockRecord.ALIAS_APPROVAL_STATUS%></td>		
					<td>
						<select name="approvalStatus">
							<option value="1" <c:if test="${query.approvalStatus==1}">selected</c:if>>待审核</option>
							<option value="2" <c:if test="${query.approvalStatus==2}">selected</c:if>>审核通过</option>
							<option value="3" <c:if test="${query.approvalStatus==3}">selected</c:if>>审核未通过</option>
							<option value="-1" <c:if test="${query.approvalStatus==-1}">selected</c:if>>不限</option>
						</select>
					</td>
					<!-- 
					<td class="tdLabel"><%=StockRecord.ALIAS_APPROVAL_ID%></td>		
					<td>
						<yun:button-edit name="approvalIdTxt" hiddenName="approvalId" id="stockRecord_approvalId" txtVal="${query.approvalIdTxt}"  hiddenVal="${query.approvalId}" width="130"  profileId="staff"/> 
						
					</td>
					 -->
				</tr>	
				<tr>	
					<td class="tdLabel"><%=StockRecord.ALIAS_STOCK_ID%></td>		
					<td>
						<yun:button-edit name="stockIdTxt" hiddenName="stockId" id="stockRecord_stockId" txtVal="${query.stockIdTxt}"  hiddenVal="${query.stockId}" width="130"  profileId="stockRecord"/> 
						
					</td>
					<!--  
					<td class="tdLabel"><%=StockRecord.ALIAS_TO_STOCK_ID%></td>		
					<td>
						<yun:button-edit name="toStockIdTxt" hiddenName="toStockId" id="stockRecord_toStockId" txtVal="${query.toStockIdTxt}"  hiddenVal="${query.toStockId}" width="130"  profileId="stockRecord"/> 
						
					</td>
					-->
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
				<th sortColumn="stock_operation_name" ><%=StockRecord.ALIAS_STOCK_OPERATION_NAME%></th>
				<th sortColumn="dept_id" ><%=StockRecord.ALIAS_DEPT_ID%></th>
				<th sortColumn="staff_id" ><%=StockRecord.ALIAS_STAFF_ID%></th>
				<th sortColumn="oper_type" ><%=StockRecord.ALIAS_OPER_TYPE%></th>
				<!--  <th sortColumn="cust_id" ><%=StockRecord.ALIAS_CUST_ID%></th>-->
				<th sortColumn="oper_date" ><%=StockRecord.ALIAS_OPER_DATE%></th>
				<th sortColumn="approval_status" ><%=StockRecord.ALIAS_APPROVAL_STATUS%></th>
				<!--  <th sortColumn="approval_id" ><%=StockRecord.ALIAS_APPROVAL_ID%></th>-->
				<th sortColumn="stock_id" ><%=StockRecord.ALIAS_STOCK_ID%></th>
				<!--  <th sortColumn="to_stock_id" ><%=StockRecord.ALIAS_TO_STOCK_ID%></th>-->
				<th sortColumn="remark" ><%=StockRecord.ALIAS_REMARK%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.stockOperationId}"></td>
				
				<td><c:out value='${item.stockOperationName}'/>&nbsp;</td>
				<td><c:out value='${item.deptIdTxt}'/>&nbsp;</td>
				<td><c:out value='${item.staffIdTxt}'/>&nbsp;</td>
				<td><c:choose><c:when test="${item.operType==1}">出库</c:when><c:when test="${item.operType==2}">入库</c:when><c:when test="${item.operType==3}">退货</c:when><c:when test="${item.operType==4}">转存</c:when></c:choose></td>
				<!-- <td><c:out value='${item.custIdTxt}'/>&nbsp;</td> -->
				<td><c:out value='${item.operDateString}'/>&nbsp;</td>
				<td><c:choose><c:when test="${item.approvalStatus==1}">待审核</c:when><c:when test="${item.approvalStatus==2}">审核通过</c:when><c:when test="${item.approvalStatus==3}">审核未通过</c:when></c:choose></td>
				<!--  <td><c:out value='${item.approvalIdTxt}'/>&nbsp;</td>-->
				<td><c:out value='${item.stockIdTxt}'/>&nbsp;</td>
				<!-- <td><c:out value='${item.toStockIdTxt}'/>&nbsp;</td> -->
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
	
	<script type="text/javascript">
	 var popupOption={
		 'stockRecord_deptId': {url:'${ctx}/dept/query',title:'选择部门',textColumn:'dept_name',valueColumn:'deptId'},
		 'stockRecord_staffId': {url:'${ctx}/staff/query',title:'选择创建人',textColumn:'staff_name',valueColumn:'staffId'},
		 'stockRecord_custId': {url:'${ctx}/customer/query',title:'选择客户',textColumn:'cust_name',valueColumn:'custId'},
		 'stockRecord_approvalId': {url:'${ctx}/staff/query',title:'选择创建人',textColumn:'staff_name',valueColumn:'staffId'},
		 'stockRecord_stockId': {url:'${ctx}/stockhouse/query',title:'选择仓库',textColumn:'stock_name',valueColumn:'stockId'}
		 //'stockRecord_toStockId': {url:'${ctx}/stockhouse/query',title:'选择仓库',textColumn:'stock_name',valueColumn:'stockId'}
	 };
	 PopupSelection.initOption(popupOption); 	
	</script>
	  <div id="dialog-modal" title="">
        <iframe frameborder="0" style="width:100%;height:99%;height:100%\9;" src="about:blank"></iframe>
    </div>
	
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>
