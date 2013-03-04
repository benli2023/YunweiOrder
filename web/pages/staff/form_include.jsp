<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="staffId" name="staffId" value="${staff.staffId}"/>

	<tr>	
		<td class="tdLabel">
			<%=Staff.ALIAS_DEPT_ID%>:
		</td>		
		<td>
		<form:input path="deptId" id="deptId" cssClass="validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="deptId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Staff.ALIAS_STAFF_NAME%>:
		</td>		
		<td>
		<form:input path="staffName" id="staffName" cssClass="" maxlength="128" />
		<font color='red'><form:errors path="staffName"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Staff.ALIAS_LOGIN_NAME%>:
		</td>		
		<td>
		<form:input path="loginName" id="loginName" cssClass="" maxlength="64" />
		<font color='red'><form:errors path="loginName"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Staff.ALIAS_LOGIN_PASSWORD%>:
		</td>		
		<td>
		<form:input path="loginPassword" id="loginPassword" cssClass="" maxlength="128" />
		<font color='red'><form:errors path="loginPassword"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Staff.ALIAS_POSITION%>:
		</td>		
		<td>
		<form:input path="position" id="position" cssClass="" maxlength="8" />
		<font color='red'><form:errors path="position"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Staff.ALIAS_GENDER%>:
		</td>		
		<td>
		<form:input path="gender" id="gender" cssClass="validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="gender"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Staff.ALIAS_BIRTH_DATE%>:
		</td>		
		<td>
		<input value="${staff.birthDateString}" onclick="WdatePicker({dateFmt:'<%=Staff.FORMAT_BIRTH_DATE%>'})" id="birthDateString" name="birthDateString"  maxlength="0" class="" />
		<font color='red'><form:errors path="birthDate"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Staff.ALIAS_HIRE_DATE%>:
		</td>		
		<td>
		<input value="${staff.hireDateString}" onclick="WdatePicker({dateFmt:'<%=Staff.FORMAT_HIRE_DATE%>'})" id="hireDateString" name="hireDateString"  maxlength="0" class="" />
		<font color='red'><form:errors path="hireDate"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Staff.ALIAS_MATURE_DATE%>:
		</td>		
		<td>
		<input value="${staff.matureDateString}" onclick="WdatePicker({dateFmt:'<%=Staff.FORMAT_MATURE_DATE%>'})" id="matureDateString" name="matureDateString"  maxlength="0" class="" />
		<font color='red'><form:errors path="matureDate"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Staff.ALIAS_IDENTITY_CARD%>:
		</td>		
		<td>
		<form:input path="identityCard" id="identityCard" cssClass="" maxlength="32" />
		<font color='red'><form:errors path="identityCard"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Staff.ALIAS_ADDRESS%>:
		</td>		
		<td>
		<form:input path="address" id="address" cssClass="" maxlength="256" />
		<font color='red'><form:errors path="address"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Staff.ALIAS_PHONE%>:
		</td>		
		<td>
		<form:input path="phone" id="phone" cssClass="" maxlength="32" />
		<font color='red'><form:errors path="phone"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Staff.ALIAS_EMAIL%>:
		</td>		
		<td>
		<form:input path="email" id="email" cssClass="validate-email " maxlength="128" />
		<font color='red'><form:errors path="email"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Staff.ALIAS_CTIME%>:
		</td>		
		<td>
		<input value="${staff.ctimeString}" onclick="WdatePicker({dateFmt:'<%=Staff.FORMAT_CTIME%>'})" id="ctimeString" name="ctimeString"  maxlength="0" class="" />
		<font color='red'><form:errors path="ctime"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Staff.ALIAS_ADMIN_ID%>:
		</td>		
		<td>
		<form:input path="adminId" id="adminId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="adminId"/></font>
		</td>
	</tr>	
	
		