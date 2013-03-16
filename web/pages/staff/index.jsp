<%@page import="com.yunwei.order.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=Staff.TABLE_ALIAS%> 维护</title>
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
					<td class="tdLabel"><%=Staff.ALIAS_DEPT_ID%></td>		
					<td>
						<yun:button-edit name="deptIdTxt" hiddenName="deptId" id="staff_deptId" txtVal="${query.deptIdTxt}"  hiddenVal="${query.deptId}" width="130"  profileId="dept"/> 
						
					</td>
					<td class="tdLabel"><%=Staff.ALIAS_STAFF_NAME%></td>		
					<td>
						<input value="${query.staffName}" id="staffName" name="staffName" maxlength="128"  class=""/>
					</td>
					<td class="tdLabel"><%=Staff.ALIAS_LOGIN_NAME%></td>		
					<td>
						<input value="${query.loginName}" id="loginName" name="loginName" maxlength="64"  class=""/>
					</td>
					<td class="tdLabel"><%=Staff.ALIAS_LOGIN_PASSWORD%></td>		
					<td>
						<input value="${query.loginPassword}" id="loginPassword" name="loginPassword" maxlength="128"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Staff.ALIAS_POSITION%></td>		
					<td>
						<input value="${query.position}" id="position" name="position" maxlength="8"  class=""/>
					</td>
					<td class="tdLabel"><%=Staff.ALIAS_GENDER%></td>		
					<td>
						<select name="gender">
							<option value="1" <c:if test="${query.gender==1}">selected</c:if>>男</option>
							<option value="0" <c:if test="${query.gender==0}">selected</c:if>>女</option>
							<option value="2" <c:if test="${query.gender==2}">selected</c:if>>其他</option>
							<option value="-1" <c:if test="${query.gender==-1}">selected</c:if>>不限</option>
						</select>
					</td>
					<td class="tdLabel"><%=Staff.ALIAS_BIRTH_DATE%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.birthDateBegin}' pattern='<%=Staff.FORMAT_BIRTH_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=Staff.FORMAT_BIRTH_DATE%>'})" id="birthDateBegin" name="birthDateBegin"   />
						<input value="<fmt:formatDate value='${query.birthDateEnd}' pattern='<%=Staff.FORMAT_BIRTH_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=Staff.FORMAT_BIRTH_DATE%>'})" id="birthDateEnd" name="birthDateEnd"   />
					</td>
					<td class="tdLabel"><%=Staff.ALIAS_HIRE_DATE%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.hireDateBegin}' pattern='<%=Staff.FORMAT_HIRE_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=Staff.FORMAT_HIRE_DATE%>'})" id="hireDateBegin" name="hireDateBegin"   />
						<input value="<fmt:formatDate value='${query.hireDateEnd}' pattern='<%=Staff.FORMAT_HIRE_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=Staff.FORMAT_HIRE_DATE%>'})" id="hireDateEnd" name="hireDateEnd"   />
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Staff.ALIAS_MATURE_DATE%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.matureDateBegin}' pattern='<%=Staff.FORMAT_MATURE_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=Staff.FORMAT_MATURE_DATE%>'})" id="matureDateBegin" name="matureDateBegin"   />
						<input value="<fmt:formatDate value='${query.matureDateEnd}' pattern='<%=Staff.FORMAT_MATURE_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=Staff.FORMAT_MATURE_DATE%>'})" id="matureDateEnd" name="matureDateEnd"   />
					</td>
					<td class="tdLabel"><%=Staff.ALIAS_IDENTITY_CARD%></td>		
					<td>
						<input value="${query.identityCard}" id="identityCard" name="identityCard" maxlength="32"  class=""/>
					</td>
					<td class="tdLabel"><%=Staff.ALIAS_ADDRESS%></td>		
					<td>
						<input value="${query.address}" id="address" name="address" maxlength="256"  class=""/>
					</td>
					<td class="tdLabel"><%=Staff.ALIAS_PHONE%></td>		
					<td>
						<input value="${query.phone}" id="phone" name="phone" maxlength="32"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Staff.ALIAS_EMAIL%></td>		
					<td>
						<input value="${query.email}" id="email" name="email" maxlength="128"  class="validate-email "/>
					</td>
					<td class="tdLabel"><%=Staff.ALIAS_CTIME%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.ctimeBegin}' pattern='<%=Staff.FORMAT_CTIME%>'/>" onclick="WdatePicker({dateFmt:'<%=Staff.FORMAT_CTIME%>'})" id="ctimeBegin" name="ctimeBegin"   />
						<input value="<fmt:formatDate value='${query.ctimeEnd}' pattern='<%=Staff.FORMAT_CTIME%>'/>" onclick="WdatePicker({dateFmt:'<%=Staff.FORMAT_CTIME%>'})" id="ctimeEnd" name="ctimeEnd"   />
					</td>
					<td class="tdLabel"><%=Staff.ALIAS_ADMIN_ID%></td>		
					<td>
						<yun:button-edit name="adminIdTxt" hiddenName="adminId" id="staff_adminId" txtVal="${query.adminIdTxt}"  hiddenVal="${query.adminId}" width="130"  profileId="staff"/> 
						
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/staff'"/>
			<input type="button" class="stdButton" style="width:80px" value="新增" onclick="window.location = '${ctx}/staff/new'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="doRestBatchDelete('${ctx}/staff','items',document.forms.queryForm)"/>
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
				<th sortColumn="dept_id" ><%=Staff.ALIAS_DEPT_ID%></th>
				<th sortColumn="staff_name" ><%=Staff.ALIAS_STAFF_NAME%></th>
				<th sortColumn="login_name" ><%=Staff.ALIAS_LOGIN_NAME%></th>
				<th sortColumn="login_password" ><%=Staff.ALIAS_LOGIN_PASSWORD%></th>
				<th sortColumn="position" ><%=Staff.ALIAS_POSITION%></th>
				<th sortColumn="gender" ><%=Staff.ALIAS_GENDER%></th>
				<th sortColumn="birth_date" ><%=Staff.ALIAS_BIRTH_DATE%></th>
				<th sortColumn="hire_date" ><%=Staff.ALIAS_HIRE_DATE%></th>
				<th sortColumn="mature_date" ><%=Staff.ALIAS_MATURE_DATE%></th>
				<th sortColumn="identity_card" ><%=Staff.ALIAS_IDENTITY_CARD%></th>
				<th sortColumn="address" ><%=Staff.ALIAS_ADDRESS%></th>
				<th sortColumn="phone" ><%=Staff.ALIAS_PHONE%></th>
				<th sortColumn="email" ><%=Staff.ALIAS_EMAIL%></th>
				<th sortColumn="cTime" ><%=Staff.ALIAS_CTIME%></th>
				<th sortColumn="adminId" ><%=Staff.ALIAS_ADMIN_ID%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.staffId}"></td>
				
				<td><c:out value='${item.deptIdTxt}'/>&nbsp;</td>
				<td><c:out value='${item.staffName}'/>&nbsp;</td>
				<td><c:out value='${item.loginName}'/>&nbsp;</td>
				<td><c:out value='${item.loginPassword}'/>&nbsp;</td>
				<td><c:out value='${item.position}'/>&nbsp;</td>
				<td><c:choose><c:when test="${item.gender==1}">男</c:when><c:when test="${item.gender==0}">女</c:when><c:when test="${item.gender==2}">其他</c:when></c:choose></td>
				<td><c:out value='${item.birthDateString}'/>&nbsp;</td>
				<td><c:out value='${item.hireDateString}'/>&nbsp;</td>
				<td><c:out value='${item.matureDateString}'/>&nbsp;</td>
				<td><c:out value='${item.identityCard}'/>&nbsp;</td>
				<td><c:out value='${item.address}'/>&nbsp;</td>
				<td><c:out value='${item.phone}'/>&nbsp;</td>
				<td><c:out value='${item.email}'/>&nbsp;</td>
				<td><c:out value='${item.ctimeString}'/>&nbsp;</td>
				<td><c:out value='${item.adminIdTxt}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/staff/${item.staffId}">查看</a>&nbsp;&nbsp;
					<a href="${ctx}/staff/${item.staffId}/edit">修改</a>&nbsp;&nbsp;
					<a href="${ctx}/staff/${item.staffId}" onclick="doRestDelete(this,'你确认删除?');return false;">删除</a>
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
		 'staff_deptId': {url:'${ctx}/dept/query',title:'选择部门',textColumn:'dept_name',valueColumn:'deptId'},
		 'staff_adminId': {url:'${ctx}/staff/query',title:'选择创建人',textColumn:'staff_name',valueColumn:'staffId'}
	 };
	 PopupSelection.initOption(popupOption); 	
	</script>
	  <div id="dialog-modal" title="">
        <iframe frameborder="0" style="width:100%;height:99%;height:100%\9;" src="about:blank"></iframe>
    </div>
	
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>
