<%@page import="com.yunwei.order.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=FundsRecord.TABLE_ALIAS%> 维护</title>
	
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
					<td class="tdLabel"><%=FundsRecord.ALIAS_APPROVAL_ID%></td>		
					<td>
						<input value="${query.approvalId}" id="approvalId" name="approvalId" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=FundsRecord.ALIAS_STAFF_ID%></td>		
					<td>
						<input value="${query.staffId}" id="staffId" name="staffId" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=FundsRecord.ALIAS_ORDER_ID%></td>		
					<td>
						<input value="${query.orderId}" id="orderId" name="orderId" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=FundsRecord.ALIAS_CUST_ID%></td>		
					<td>
						<input value="${query.custId}" id="custId" name="custId" maxlength="19"  class="validate-integer "/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=FundsRecord.ALIAS_FUNDS_TYPE%></td>		
					<td>
						<input value="${query.fundsType}" id="fundsType" name="fundsType" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=FundsRecord.ALIAS_AMOUNT%></td>		
					<td>
						<input value="${query.amount}" id="amount" name="amount" maxlength="10"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=FundsRecord.ALIAS_PAID_AMOUNT%></td>		
					<td>
						<input value="${query.paidAmount}" id="paidAmount" name="paidAmount" maxlength="10"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=FundsRecord.ALIAS_APPROVAL_STATUS%></td>		
					<td>
						<input value="${query.approvalStatus}" id="approvalStatus" name="approvalStatus" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=FundsRecord.ALIAS_APPROVAL_DATE%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.approvalDateBegin}' pattern='<%=FundsRecord.FORMAT_APPROVAL_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=FundsRecord.FORMAT_APPROVAL_DATE%>'})" id="approvalDateBegin" name="approvalDateBegin"   />
						<input value="<fmt:formatDate value='${query.approvalDateEnd}' pattern='<%=FundsRecord.FORMAT_APPROVAL_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=FundsRecord.FORMAT_APPROVAL_DATE%>'})" id="approvalDateEnd" name="approvalDateEnd"   />
					</td>
					<td class="tdLabel"><%=FundsRecord.ALIAS_STATUS%></td>		
					<td>
						<input value="${query.status}" id="status" name="status" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=FundsRecord.ALIAS_PAYMENT_MODE%></td>		
					<td>
						<input value="${query.paymentMode}" id="paymentMode" name="paymentMode" maxlength="8"  class=""/>
					</td>
					<td class="tdLabel"><%=FundsRecord.ALIAS_REMARK%></td>		
					<td>
						<input value="${query.remark}" id="remark" name="remark" maxlength="512"  class=""/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/fundsrecord'"/>
			<input type="button" class="stdButton" style="width:80px" value="新增" onclick="window.location = '${ctx}/fundsrecord/new'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="doRestBatchDelete('${ctx}/fundsrecord','items',document.forms.queryForm)"/>
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
				<th sortColumn="approval_id" ><%=FundsRecord.ALIAS_APPROVAL_ID%></th>
				<th sortColumn="staff_id" ><%=FundsRecord.ALIAS_STAFF_ID%></th>
				<th sortColumn="order_id" ><%=FundsRecord.ALIAS_ORDER_ID%></th>
				<th sortColumn="cust_id" ><%=FundsRecord.ALIAS_CUST_ID%></th>
				<th sortColumn="funds_type" ><%=FundsRecord.ALIAS_FUNDS_TYPE%></th>
				<th sortColumn="amount" ><%=FundsRecord.ALIAS_AMOUNT%></th>
				<th sortColumn="paid_amount" ><%=FundsRecord.ALIAS_PAID_AMOUNT%></th>
				<th sortColumn="approval_status" ><%=FundsRecord.ALIAS_APPROVAL_STATUS%></th>
				<th sortColumn="approval_date" ><%=FundsRecord.ALIAS_APPROVAL_DATE%></th>
				<th sortColumn="status" ><%=FundsRecord.ALIAS_STATUS%></th>
				<th sortColumn="payment_mode" ><%=FundsRecord.ALIAS_PAYMENT_MODE%></th>
				<th sortColumn="remark" ><%=FundsRecord.ALIAS_REMARK%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.fundsId}"></td>
				
				<td><c:out value='${item.approvalId}'/>&nbsp;</td>
				<td><c:out value='${item.staffId}'/>&nbsp;</td>
				<td><c:out value='${item.orderId}'/>&nbsp;</td>
				<td><c:out value='${item.custId}'/>&nbsp;</td>
				<td><c:out value='${item.fundsType}'/>&nbsp;</td>
				<td><c:out value='${item.amount}'/>&nbsp;</td>
				<td><c:out value='${item.paidAmount}'/>&nbsp;</td>
				<td><c:out value='${item.approvalStatus}'/>&nbsp;</td>
				<td><c:out value='${item.approvalDateString}'/>&nbsp;</td>
				<td><c:out value='${item.status}'/>&nbsp;</td>
				<td><c:out value='${item.paymentMode}'/>&nbsp;</td>
				<td><c:out value='${item.remark}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/fundsrecord/${item.fundsId}">查看</a>&nbsp;&nbsp;
					<a href="${ctx}/fundsrecord/${item.fundsId}/edit">修改</a>&nbsp;&nbsp;
					<a href="${ctx}/fundsrecord/${item.fundsId}" onclick="doRestDelete(this,'你确认删除?');return false;">删除</a>
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
