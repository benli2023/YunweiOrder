<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=Category.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="category"  >
		<input type="button" value="返回列表" onclick="window.location='${ctx}/category'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="cateId" name="cateId" value="${category.cateId}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=Category.ALIAS_PARENT_ID%></td>	
				<td><c:out value='${category.parentId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Category.ALIAS_CATE_NAME%></td>	
				<td><c:out value='${category.cateName}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Category.ALIAS_IS_AVAILABLE%></td>	
				<td><c:out value='${category.isAvailable}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Category.ALIAS_CTIME%></td>	
				<td><c:out value='${category.ctimeString}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Category.ALIAS_ADMIN%></td>	
				<td><c:out value='${category.admin}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>