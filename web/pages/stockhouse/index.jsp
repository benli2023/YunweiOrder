<%@page import="com.yunwei.order.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=StockHouse.TABLE_ALIAS%> 维护</title>
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
					<td class="tdLabel"><%=StockHouse.ALIAS_STAFF_ID%></td>		
					<td>
						<yun:button-edit name="staffIdTxt" hiddenName="staffId" id="stockHouse_staffId" txtVal="${query.staffIdTxt}"  hiddenVal="${query.staffId}" width="130"  profileId="stock"/> 
						
					</td>
					<td class="tdLabel"><%=StockHouse.ALIAS_STOCK_NAME%></td>		
					<td>
						<input value="${query.stockName}" id="stockName" name="stockName" maxlength="256"  class=""/>
					</td>
					<td class="tdLabel"><%=StockHouse.ALIAS_ADDRESS%></td>		
					<td>
						<input value="${query.address}" id="address" name="address" maxlength="256"  class=""/>
					</td>
					<td class="tdLabel"><%=StockHouse.ALIAS_PHONE%></td>		
					<td>
						<input value="${query.phone}" id="phone" name="phone" maxlength="32"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=StockHouse.ALIAS_CTIME%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.ctimeBegin}' pattern='<%=StockHouse.FORMAT_CTIME_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=StockHouse.FORMAT_CTIME_DATE%>'})" id="ctimeBegin" name="ctimeBegin"   />
						<input value="<fmt:formatDate value='${query.ctimeEnd}' pattern='<%=StockHouse.FORMAT_CTIME_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=StockHouse.FORMAT_CTIME_DATE%>'})" id="ctimeEnd" name="ctimeEnd"   />
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/stockhouse'"/>
			<input type="button" class="stdButton" style="width:80px" value="新增" onclick="window.location = '${ctx}/stockhouse/new'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="doRestBatchDelete('${ctx}/stockhouse','items',document.forms.queryForm)"/>
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
				<th sortColumn="staff_id" ><%=StockHouse.ALIAS_STAFF_ID%></th>
				<th sortColumn="stock_name" ><%=StockHouse.ALIAS_STOCK_NAME%></th>
				<th sortColumn="address" ><%=StockHouse.ALIAS_ADDRESS%></th>
				<th sortColumn="phone" ><%=StockHouse.ALIAS_PHONE%></th>
				<th sortColumn="cTime" ><%=StockHouse.ALIAS_CTIME%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.stockId}"></td>
				
				<td><c:out value='${item.staffIdTxt}'/>&nbsp;</td>
				<td><c:out value='${item.stockName}'/>&nbsp;</td>
				<td><c:out value='${item.address}'/>&nbsp;</td>
				<td><c:out value='${item.phone}'/>&nbsp;</td>
				<td><c:out value='${item.ctimeString}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/stockhouse/${item.stockId}">查看</a>&nbsp;&nbsp;
					<a href="${ctx}/stockhouse/${item.stockId}/edit">修改</a>&nbsp;&nbsp;
					<a href="${ctx}/stockhouse/${item.stockId}" onclick="doRestDelete(this,'你确认删除?');return false;">删除</a>
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
		 'stockHouse_staffId': {url:'${ctx}/staff/query',title:'选择负责人',textColumn:'staff_name',valueColumn:'staffId'}
	 };
	 PopupSelection.initOption(popupOption); 	
	</script>
	  <div id="dialog-modal" title="">
        <iframe frameborder="0" style="width:100%;height:99%;height:100%\9;" src="about:blank"></iframe>
    </div>
	
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>
