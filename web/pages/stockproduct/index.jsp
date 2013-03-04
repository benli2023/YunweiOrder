<%@page import="com.yunwei.order.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=StockProduct.TABLE_ALIAS%> 维护</title>
	
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
					<td class="tdLabel"><%=StockProduct.ALIAS_STOCK_ID%></td>		
					<td>
						<input value="${query.stockId}" id="stockId" name="stockId" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=StockProduct.ALIAS_PRODUCT_ID%></td>		
					<td>
						<input value="${query.productId}" id="productId" name="productId" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=StockProduct.ALIAS_QUANTITY%></td>		
					<td>
						<input value="${query.quantity}" id="quantity" name="quantity" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=StockProduct.ALIAS_FIRST_ENTER_DATE%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.firstEnterDateBegin}' pattern='<%=StockProduct.FORMAT_FIRST_ENTER_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=StockProduct.FORMAT_FIRST_ENTER_DATE%>'})" id="firstEnterDateBegin" name="firstEnterDateBegin"   />
						<input value="<fmt:formatDate value='${query.firstEnterDateEnd}' pattern='<%=StockProduct.FORMAT_FIRST_ENTER_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=StockProduct.FORMAT_FIRST_ENTER_DATE%>'})" id="firstEnterDateEnd" name="firstEnterDateEnd"   />
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=StockProduct.ALIAS_OUTER_DATE%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.outerDateBegin}' pattern='<%=StockProduct.FORMAT_OUTER_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=StockProduct.FORMAT_OUTER_DATE%>'})" id="outerDateBegin" name="outerDateBegin"   />
						<input value="<fmt:formatDate value='${query.outerDateEnd}' pattern='<%=StockProduct.FORMAT_OUTER_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=StockProduct.FORMAT_OUTER_DATE%>'})" id="outerDateEnd" name="outerDateEnd"   />
					</td>
					<td class="tdLabel"><%=StockProduct.ALIAS_PRICE%></td>		
					<td>
						<input value="${query.price}" id="price" name="price" maxlength="10"  class="validate-integer "/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/stockproduct'"/>
			<input type="button" class="stdButton" style="width:80px" value="新增" onclick="window.location = '${ctx}/stockproduct/new'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="doRestBatchDelete('${ctx}/stockproduct','items',document.forms.queryForm)"/>
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
				<th sortColumn="stock_id" ><%=StockProduct.ALIAS_STOCK_ID%></th>
				<th sortColumn="product_id" ><%=StockProduct.ALIAS_PRODUCT_ID%></th>
				<th sortColumn="quantity" ><%=StockProduct.ALIAS_QUANTITY%></th>
				<th sortColumn="first_enter_date" ><%=StockProduct.ALIAS_FIRST_ENTER_DATE%></th>
				<th sortColumn="outer_date" ><%=StockProduct.ALIAS_OUTER_DATE%></th>
				<th sortColumn="price" ><%=StockProduct.ALIAS_PRICE%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.stockProductId}"></td>
				
				<td><c:out value='${item.stockId}'/>&nbsp;</td>
				<td><c:out value='${item.productId}'/>&nbsp;</td>
				<td><c:out value='${item.quantity}'/>&nbsp;</td>
				<td><c:out value='${item.firstEnterDateString}'/>&nbsp;</td>
				<td><c:out value='${item.outerDateString}'/>&nbsp;</td>
				<td><c:out value='${item.price}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/stockproduct/${item.stockProductId}">查看</a>&nbsp;&nbsp;
					<a href="${ctx}/stockproduct/${item.stockProductId}/edit">修改</a>&nbsp;&nbsp;
					<a href="${ctx}/stockproduct/${item.stockProductId}" onclick="doRestDelete(this,'你确认删除?');return false;">删除</a>
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
