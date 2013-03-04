<%@page import="com.yunwei.order.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=StockRecordLine.TABLE_ALIAS%> 维护</title>
	
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
					<td class="tdLabel"><%=StockRecordLine.ALIAS_STOCK_OPERATION_ID%></td>		
					<td>
						<input value="${query.stockOperationId}" id="stockOperationId" name="stockOperationId" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=StockRecordLine.ALIAS_PRODUCT_ID%></td>		
					<td>
						<input value="${query.productId}" id="productId" name="productId" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=StockRecordLine.ALIAS_PRICE%></td>		
					<td>
						<input value="${query.price}" id="price" name="price" maxlength="10"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=StockRecordLine.ALIAS_QUANTITY%></td>		
					<td>
						<input value="${query.quantity}" id="quantity" name="quantity" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=StockRecordLine.ALIAS_HAVE_INVOICE%></td>		
					<td>
						<input value="${query.haveInvoice}" id="haveInvoice" name="haveInvoice" maxlength="1"  class=""/>
					</td>
					<td class="tdLabel"><%=StockRecordLine.ALIAS_INVOICE_NUMBER%></td>		
					<td>
						<input value="${query.invoiceNumber}" id="invoiceNumber" name="invoiceNumber" maxlength="32"  class=""/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/stockrecordline'"/>
			<input type="button" class="stdButton" style="width:80px" value="新增" onclick="window.location = '${ctx}/stockrecordline/new'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="doRestBatchDelete('${ctx}/stockrecordline','items',document.forms.queryForm)"/>
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
				<th sortColumn="stock_operation_id" ><%=StockRecordLine.ALIAS_STOCK_OPERATION_ID%></th>
				<th sortColumn="product_id" ><%=StockRecordLine.ALIAS_PRODUCT_ID%></th>
				<th sortColumn="price" ><%=StockRecordLine.ALIAS_PRICE%></th>
				<th sortColumn="quantity" ><%=StockRecordLine.ALIAS_QUANTITY%></th>
				<th sortColumn="have_invoice" ><%=StockRecordLine.ALIAS_HAVE_INVOICE%></th>
				<th sortColumn="invoice_number" ><%=StockRecordLine.ALIAS_INVOICE_NUMBER%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.stockOperDetailId}"></td>
				
				<td><c:out value='${item.stockOperationId}'/>&nbsp;</td>
				<td><c:out value='${item.productId}'/>&nbsp;</td>
				<td><c:out value='${item.price}'/>&nbsp;</td>
				<td><c:out value='${item.quantity}'/>&nbsp;</td>
				<td><c:out value='${item.haveInvoice}'/>&nbsp;</td>
				<td><c:out value='${item.invoiceNumber}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/stockrecordline/${item.stockOperDetailId}">查看</a>&nbsp;&nbsp;
					<a href="${ctx}/stockrecordline/${item.stockOperDetailId}/edit">修改</a>&nbsp;&nbsp;
					<a href="${ctx}/stockrecordline/${item.stockOperDetailId}" onclick="doRestDelete(this,'你确认删除?');return false;">删除</a>
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
