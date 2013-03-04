<%@page import="com.yunwei.order.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=OrderGoods.TABLE_ALIAS%> 维护</title>
	
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
					<td class="tdLabel"><%=OrderGoods.ALIAS_GOODS_CODE%></td>		
					<td>
						<input value="${query.goodsCode}" id="goodsCode" name="goodsCode" maxlength="256"  class=""/>
					</td>
					<td class="tdLabel"><%=OrderGoods.ALIAS_PRODUCT_ID%></td>		
					<td>
						<input value="${query.productId}" id="productId" name="productId" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=OrderGoods.ALIAS_ORDER_ID%></td>		
					<td>
						<input value="${query.orderId}" id="orderId" name="orderId" maxlength="19"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=OrderGoods.ALIAS_UNIT%></td>		
					<td>
						<input value="${query.unit}" id="unit" name="unit" maxlength="8"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=OrderGoods.ALIAS_UNIT_PRICE%></td>		
					<td>
						<input value="${query.unitPrice}" id="unitPrice" name="unitPrice" maxlength="10"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=OrderGoods.ALIAS_QUANTITY%></td>		
					<td>
						<input value="${query.quantity}" id="quantity" name="quantity" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=OrderGoods.ALIAS_HANDED_QUANTITY%></td>		
					<td>
						<input value="${query.handedQuantity}" id="handedQuantity" name="handedQuantity" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=OrderGoods.ALIAS_UNTAXED_AMOUNT%></td>		
					<td>
						<input value="${query.untaxedAmount}" id="untaxedAmount" name="untaxedAmount" maxlength="10"  class="validate-integer "/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=OrderGoods.ALIAS_TAX_RATE%></td>		
					<td>
						<input value="${query.taxRate}" id="taxRate" name="taxRate" maxlength="8"  class="validate-number "/>
					</td>
					<td class="tdLabel"><%=OrderGoods.ALIAS_OUTPUT_TAX_AMOUNT%></td>		
					<td>
						<input value="${query.outputTaxAmount}" id="outputTaxAmount" name="outputTaxAmount" maxlength="10"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=OrderGoods.ALIAS_TAX_AMOUNT%></td>		
					<td>
						<input value="${query.taxAmount}" id="taxAmount" name="taxAmount" maxlength="10"  class="validate-integer "/>
					</td>
					<td class="tdLabel"><%=OrderGoods.ALIAS_MODEL%></td>		
					<td>
						<input value="${query.model}" id="model" name="model" maxlength="8"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=OrderGoods.ALIAS_REMARK%></td>		
					<td>
						<input value="${query.remark}" id="remark" name="remark" maxlength="512"  class=""/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/ordergoods'"/>
			<input type="button" class="stdButton" style="width:80px" value="新增" onclick="window.location = '${ctx}/ordergoods/new'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="doRestBatchDelete('${ctx}/ordergoods','items',document.forms.queryForm)"/>
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
				<th sortColumn="goods_code" ><%=OrderGoods.ALIAS_GOODS_CODE%></th>
				<th sortColumn="product_id" ><%=OrderGoods.ALIAS_PRODUCT_ID%></th>
				<th sortColumn="order_id" ><%=OrderGoods.ALIAS_ORDER_ID%></th>
				<th sortColumn="unit" ><%=OrderGoods.ALIAS_UNIT%></th>
				<th sortColumn="unit_price" ><%=OrderGoods.ALIAS_UNIT_PRICE%></th>
				<th sortColumn="quantity" ><%=OrderGoods.ALIAS_QUANTITY%></th>
				<th sortColumn="handed_quantity" ><%=OrderGoods.ALIAS_HANDED_QUANTITY%></th>
				<th sortColumn="untaxed_amount" ><%=OrderGoods.ALIAS_UNTAXED_AMOUNT%></th>
				<th sortColumn="tax_rate" ><%=OrderGoods.ALIAS_TAX_RATE%></th>
				<th sortColumn="output_tax_amount" ><%=OrderGoods.ALIAS_OUTPUT_TAX_AMOUNT%></th>
				<th sortColumn="tax_amount" ><%=OrderGoods.ALIAS_TAX_AMOUNT%></th>
				<th sortColumn="model" ><%=OrderGoods.ALIAS_MODEL%></th>
				<th sortColumn="remark" ><%=OrderGoods.ALIAS_REMARK%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.goodsId}"></td>
				
				<td><c:out value='${item.goodsCode}'/>&nbsp;</td>
				<td><c:out value='${item.productId}'/>&nbsp;</td>
				<td><c:out value='${item.orderId}'/>&nbsp;</td>
				<td><c:out value='${item.unit}'/>&nbsp;</td>
				<td><c:out value='${item.unitPrice}'/>&nbsp;</td>
				<td><c:out value='${item.quantity}'/>&nbsp;</td>
				<td><c:out value='${item.handedQuantity}'/>&nbsp;</td>
				<td><c:out value='${item.untaxedAmount}'/>&nbsp;</td>
				<td><c:out value='${item.taxRate}'/>&nbsp;</td>
				<td><c:out value='${item.outputTaxAmount}'/>&nbsp;</td>
				<td><c:out value='${item.taxAmount}'/>&nbsp;</td>
				<td><c:out value='${item.model}'/>&nbsp;</td>
				<td><c:out value='${item.remark}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/ordergoods/${item.goodsId}">查看</a>&nbsp;&nbsp;
					<a href="${ctx}/ordergoods/${item.goodsId}/edit">修改</a>&nbsp;&nbsp;
					<a href="${ctx}/ordergoods/${item.goodsId}" onclick="doRestDelete(this,'你确认删除?');return false;">删除</a>
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
