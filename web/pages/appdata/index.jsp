<%@page import="com.yunwei.order.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=AppData.TABLE_ALIAS%> 维护</title>
	
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
					<td class="tdLabel"><%=AppData.ALIAS_DATA_CODE%></td>		
					<td>
						<input value="${query.dataCode}" id="dataCode" name="dataCode" maxlength="8"  class=""/>
					</td>
					<td class="tdLabel"><%=AppData.ALIAS_DATA_VALUE%></td>		
					<td>
						<input value="${query.dataValue}" id="dataValue" name="dataValue" maxlength="256"  class=""/>
					</td>
					<td class="tdLabel"><%=AppData.ALIAS_DATA_VALUE_TEXT%></td>		
					<td>
						<input value="${query.dataValueText}" id="dataValueText" name="dataValueText" maxlength="65535"  class=""/>
					</td>
					<td class="tdLabel"><%=AppData.ALIAS_DISPLAY_NAME%></td>		
					<td>
						<input value="${query.displayName}" id="displayName" name="displayName" maxlength="256"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=AppData.ALIAS_SHORT_NAME%></td>		
					<td>
						<input value="${query.shortName}" id="shortName" name="shortName" maxlength="64"  class=""/>
					</td>
					<td class="tdLabel"><%=AppData.ALIAS_DATA_TYPE%></td>		
					<td>
						<input value="${query.dataType}" id="dataType" name="dataType" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=AppData.ALIAS_IS_AVAILABLE%></td>		
					<td>
						<input value="${query.isAvailable}" id="isAvailable" name="isAvailable" maxlength="1"  class=""/>
					</td>
					<td class="tdLabel"><%=AppData.ALIAS_CTIME%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.ctimeBegin}' pattern='<%=AppData.FORMAT_CTIME%>'/>" onclick="WdatePicker({dateFmt:'<%=AppData.FORMAT_CTIME%>'})" id="ctimeBegin" name="ctimeBegin"   />
						<input value="<fmt:formatDate value='${query.ctimeEnd}' pattern='<%=AppData.FORMAT_CTIME%>'/>" onclick="WdatePicker({dateFmt:'<%=AppData.FORMAT_CTIME%>'})" id="ctimeEnd" name="ctimeEnd"   />
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/appdata'"/>
			<input type="button" class="stdButton" style="width:80px" value="新增" onclick="window.location = '${ctx}/appdata/new'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="doRestBatchDelete('${ctx}/appdata','items',document.forms.queryForm)"/>
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
				<th sortColumn="data_code" ><%=AppData.ALIAS_DATA_CODE%></th>
				<th sortColumn="data_value" ><%=AppData.ALIAS_DATA_VALUE%></th>
				<th sortColumn="data_value_text" ><%=AppData.ALIAS_DATA_VALUE_TEXT%></th>
				<th sortColumn="display_name" ><%=AppData.ALIAS_DISPLAY_NAME%></th>
				<th sortColumn="short_name" ><%=AppData.ALIAS_SHORT_NAME%></th>
				<th sortColumn="data_type" ><%=AppData.ALIAS_DATA_TYPE%></th>
				<th sortColumn="is_available" ><%=AppData.ALIAS_IS_AVAILABLE%></th>
				<th sortColumn="cTime" ><%=AppData.ALIAS_CTIME%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.appDataId}"></td>
				
				<td><c:out value='${item.dataCode}'/>&nbsp;</td>
				<td><c:out value='${item.dataValue}'/>&nbsp;</td>
				<td><c:out value='${item.dataValueText}'/>&nbsp;</td>
				<td><c:out value='${item.displayName}'/>&nbsp;</td>
				<td><c:out value='${item.shortName}'/>&nbsp;</td>
				<td><c:out value='${item.dataType}'/>&nbsp;</td>
				<td><c:out value='${item.isAvailable}'/>&nbsp;</td>
				<td><c:out value='${item.ctimeString}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/appdata/${item.appDataId}">查看</a>&nbsp;&nbsp;
					<a href="${ctx}/appdata/${item.appDataId}/edit">修改</a>&nbsp;&nbsp;
					<a href="${ctx}/appdata/${item.appDataId}" onclick="doRestDelete(this,'你确认删除?');return false;">删除</a>
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
