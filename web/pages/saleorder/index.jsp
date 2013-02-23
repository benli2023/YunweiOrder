<%@page import="com.yunwei.order.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=SaleOrder.TABLE_ALIAS%> 维护</title>
	
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
					<td class="tdLabel"><%=SaleOrder.ALIAS_ORDER_NO%></td>		
					<td>
						<input value="${query.orderNo}" id="orderNo" name="orderNo" maxlength="16"  class=""/>
					</td>
					<td class="tdLabel"><%=SaleOrder.ALIAS_STAFF_ID%></td>		
					<td>
						<input value="${query.staffId}" id="staffId" name="staffId" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=SaleOrder.ALIAS_CUST_ID%></td>		
					<td>
						<input value="${query.custId}" id="custId" name="custId" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=SaleOrder.ALIAS_ORDER_DATE%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.orderDateBegin}' pattern='<%=SaleOrder.FORMAT_ORDER_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=SaleOrder.FORMAT_ORDER_DATE%>'})" id="orderDateBegin" name="orderDateBegin"   />
						<input value="<fmt:formatDate value='${query.orderDateEnd}' pattern='<%=SaleOrder.FORMAT_ORDER_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=SaleOrder.FORMAT_ORDER_DATE%>'})" id="orderDateEnd" name="orderDateEnd"   />
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=SaleOrder.ALIAS_PAYMENT_MODE%></td>		
					<td>
						<input value="${query.paymentMode}" id="paymentMode" name="paymentMode" maxlength="8"  class=""/>
					</td>
					<td class="tdLabel"><%=SaleOrder.ALIAS_INVOICE_NO%></td>		
					<td>
						<input value="${query.invoiceNo}" id="invoiceNo" name="invoiceNo" maxlength="128"  class=""/>
					</td>
					<td class="tdLabel"><%=SaleOrder.ALIAS_DESCRIPTION%></td>		
					<td>
						<input value="${query.description}" id="description" name="description" maxlength="512"  class=""/>
					</td>
					<td class="tdLabel"><%=SaleOrder.ALIAS_ACCOUNTING_DEPT_ID%></td>		
					<td>
						<input value="${query.accountingDeptId}" id="accountingDeptId" name="accountingDeptId" maxlength="19"  class="validate-integer "/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=SaleOrder.ALIAS_CURRENCY%></td>		
					<td>
						<input value="${query.currency}" id="currency" name="currency" maxlength="8"  class=""/>
					</td>
					<td class="tdLabel"><%=SaleOrder.ALIAS_DELIVERY_METHOD%></td>		
					<td>
						<input value="${query.deliveryMethod}" id="deliveryMethod" name="deliveryMethod" maxlength="8"  class=""/>
					</td>
					<td class="tdLabel"><%=SaleOrder.ALIAS_DELIVERY_DATE%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.deliveryDateBegin}' pattern='<%=SaleOrder.FORMAT_DELIVERY_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=SaleOrder.FORMAT_DELIVERY_DATE%>'})" id="deliveryDateBegin" name="deliveryDateBegin"   />
						<input value="<fmt:formatDate value='${query.deliveryDateEnd}' pattern='<%=SaleOrder.FORMAT_DELIVERY_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=SaleOrder.FORMAT_DELIVERY_DATE%>'})" id="deliveryDateEnd" name="deliveryDateEnd"   />
					</td>
					<td class="tdLabel"><%=SaleOrder.ALIAS_ADDITIONAL_TEXT%></td>		
					<td>
						<input value="${query.additionalText}" id="additionalText" name="additionalText" maxlength="65535"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=SaleOrder.ALIAS_IS_AVAILABLE%></td>		
					<td>
						<input value="${query.isAvailable}" id="isAvailable" name="isAvailable" maxlength="1"  class=""/>
					</td>
					<td class="tdLabel"><%=SaleOrder.ALIAS_UPDATOR%></td>		
					<td>
						<input value="${query.updator}" id="updator" name="updator" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=SaleOrder.ALIAS_UTIME%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.utimeBegin}' pattern='<%=SaleOrder.FORMAT_UTIME%>'/>" onclick="WdatePicker({dateFmt:'<%=SaleOrder.FORMAT_UTIME%>'})" id="utimeBegin" name="utimeBegin"   />
						<input value="<fmt:formatDate value='${query.utimeEnd}' pattern='<%=SaleOrder.FORMAT_UTIME%>'/>" onclick="WdatePicker({dateFmt:'<%=SaleOrder.FORMAT_UTIME%>'})" id="utimeEnd" name="utimeEnd"   />
					</td>
					<td class="tdLabel"><%=SaleOrder.ALIAS_CTIME%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.ctimeBegin}' pattern='<%=SaleOrder.FORMAT_CTIME%>'/>" onclick="WdatePicker({dateFmt:'<%=SaleOrder.FORMAT_CTIME%>'})" id="ctimeBegin" name="ctimeBegin"   />
						<input value="<fmt:formatDate value='${query.ctimeEnd}' pattern='<%=SaleOrder.FORMAT_CTIME%>'/>" onclick="WdatePicker({dateFmt:'<%=SaleOrder.FORMAT_CTIME%>'})" id="ctimeEnd" name="ctimeEnd"   />
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=SaleOrder.ALIAS_CREATOR_ID%></td>		
					<td>
						<input value="${query.creatorId}" id="creatorId" name="creatorId" maxlength="19"  class="validate-integer "/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/saleorder'"/>
			<input type="button" class="stdButton" style="width:80px" value="新增" onclick="window.location = '${ctx}/saleorder/new'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="doRestBatchDelete('${ctx}/saleorder','items',document.forms.queryForm)"/>
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
				<th sortColumn="order_no" ><%=SaleOrder.ALIAS_ORDER_NO%></th>
				<th sortColumn="staff_id" ><%=SaleOrder.ALIAS_STAFF_ID%></th>
				<th sortColumn="cust_id" ><%=SaleOrder.ALIAS_CUST_ID%></th>
				<th sortColumn="order_date" ><%=SaleOrder.ALIAS_ORDER_DATE%></th>
				<th sortColumn="payment_mode" ><%=SaleOrder.ALIAS_PAYMENT_MODE%></th>
				<th sortColumn="invoice_no" ><%=SaleOrder.ALIAS_INVOICE_NO%></th>
				<th sortColumn="description" ><%=SaleOrder.ALIAS_DESCRIPTION%></th>
				<th sortColumn="accounting_deptId" ><%=SaleOrder.ALIAS_ACCOUNTING_DEPT_ID%></th>
				<th sortColumn="currency" ><%=SaleOrder.ALIAS_CURRENCY%></th>
				<th sortColumn="delivery_method" ><%=SaleOrder.ALIAS_DELIVERY_METHOD%></th>
				<th sortColumn="delivery_date" ><%=SaleOrder.ALIAS_DELIVERY_DATE%></th>
				<th sortColumn="additional_text" ><%=SaleOrder.ALIAS_ADDITIONAL_TEXT%></th>
				<th sortColumn="is_available" ><%=SaleOrder.ALIAS_IS_AVAILABLE%></th>
				<th sortColumn="updator" ><%=SaleOrder.ALIAS_UPDATOR%></th>
				<th sortColumn="uTime" ><%=SaleOrder.ALIAS_UTIME%></th>
				<th sortColumn="cTime" ><%=SaleOrder.ALIAS_CTIME%></th>
				<th sortColumn="creator_Id" ><%=SaleOrder.ALIAS_CREATOR_ID%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.orderId}"></td>
				
				<td><c:out value='${item.orderNo}'/>&nbsp;</td>
				<td><c:out value='${item.staffId}'/>&nbsp;</td>
				<td><c:out value='${item.custId}'/>&nbsp;</td>
				<td><c:out value='${item.orderDateString}'/>&nbsp;</td>
				<td><c:out value='${item.paymentMode}'/>&nbsp;</td>
				<td><c:out value='${item.invoiceNo}'/>&nbsp;</td>
				<td><c:out value='${item.description}'/>&nbsp;</td>
				<td><c:out value='${item.accountingDeptId}'/>&nbsp;</td>
				<td><c:out value='${item.currency}'/>&nbsp;</td>
				<td><c:out value='${item.deliveryMethod}'/>&nbsp;</td>
				<td><c:out value='${item.deliveryDateString}'/>&nbsp;</td>
				<td><c:out value='${item.additionalText}'/>&nbsp;</td>
				<td><c:out value='${item.isAvailable}'/>&nbsp;</td>
				<td><c:out value='${item.updator}'/>&nbsp;</td>
				<td><c:out value='${item.utimeString}'/>&nbsp;</td>
				<td><c:out value='${item.ctimeString}'/>&nbsp;</td>
				<td><c:out value='${item.creatorId}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/saleorder/${item.orderId}">查看</a>&nbsp;&nbsp;
					<a href="${ctx}/saleorder/${item.orderId}/edit">修改</a>&nbsp;&nbsp;
					<a href="${ctx}/saleorder/${item.orderId}" onclick="doRestDelete(this,'你确认删除?');return false;">删除</a>
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
