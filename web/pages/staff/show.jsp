<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=Staff.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="staff"  method="post">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/staff'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="staffId" name="staffId" value="${staff.staffId}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=Staff.ALIAS_DEPT_ID%></td>	
				<td><c:out value='${staff.deptId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Staff.ALIAS_STAFF_NAME%></td>	
				<td><c:out value='${staff.staffName}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Staff.ALIAS_LOGIN_NAME%></td>	
				<td><c:out value='${staff.loginName}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Staff.ALIAS_LOGIN_PASSWORD%></td>	
				<td><c:out value='${staff.loginPassword}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Staff.ALIAS_POSITION%></td>	
				<td><c:out value='${staff.position}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Staff.ALIAS_GENDER%></td>	
				<td><c:out value='${staff.gender}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Staff.ALIAS_BIRTH_DATE%></td>	
				<td><c:out value='${staff.birthDateString}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Staff.ALIAS_HIRE_DATE%></td>	
				<td><c:out value='${staff.hireDateString}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Staff.ALIAS_MATURE_DATE%></td>	
				<td><c:out value='${staff.matureDateString}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Staff.ALIAS_IDENTITY_CARD%></td>	
				<td><c:out value='${staff.identityCard}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Staff.ALIAS_ADDRESS%></td>	
				<td><c:out value='${staff.address}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Staff.ALIAS_PHONE%></td>	
				<td><c:out value='${staff.phone}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Staff.ALIAS_EMAIL%></td>	
				<td><c:out value='${staff.email}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Staff.ALIAS_CTIME%></td>	
				<td><c:out value='${staff.ctimeString}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Staff.ALIAS_ADMIN_ID%></td>	
				<td><c:out value='${staff.adminId}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>