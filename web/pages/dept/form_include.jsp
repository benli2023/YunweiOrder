<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="deptId" name="deptId" value="${dept.deptId}"/>

	<tr>	
		<td class="tdLabel">
			<%=Dept.ALIAS_DEPT_NAME%>:
		</td>		
		<td>
		<form:input path="deptName" id="deptName" cssClass="" maxlength="32" />
		<font color='red'><form:errors path="deptName"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Dept.ALIAS_PARENT_ID%>:
		</td>		
		<td>
		<yun:button-edit name="parentIdTxt" hiddenName="parentId" id="dept_parentId" txtVal="${dept.parentIdTxt}"  hiddenVal="${dept.parentId}" width="130"  profileId="dept"/> 
	
		<font color='red'><form:errors path="parentId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Dept.ALIAS_REMARK%>:
		</td>		
		<td>
		<form:input path="remark" id="remark" cssClass="" maxlength="256" />
		<font color='red'><form:errors path="remark"/></font>
		</td>
	</tr>	
	
		