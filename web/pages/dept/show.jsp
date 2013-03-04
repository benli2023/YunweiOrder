<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=Dept.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="dept"  method="post">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/dept'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="deptId" name="deptId" value="${dept.deptId}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=Dept.ALIAS_DEPT_NAME%></td>	
				<td><c:out value='${dept.deptName}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Dept.ALIAS_PARENT_ID%></td>	
				<td><c:out value='${dept.parentId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Dept.ALIAS_REMARK%></td>	
				<td><c:out value='${dept.remark}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>