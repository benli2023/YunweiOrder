<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="appDataId" name="appDataId" value="${appData.appDataId}"/>

	<tr>	
		<td class="tdLabel">
			<span class="required">*</span><%=AppData.ALIAS_DATA_CODE%>:
		</td>		
		<td>
		<form:input path="dataCode" id="dataCode" cssClass="required " maxlength="8" />
		<font color='red'><form:errors path="dataCode"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=AppData.ALIAS_DATA_VALUE%>:
		</td>		
		<td>
		<form:input path="dataValue" id="dataValue" cssClass="" maxlength="256" />
		<font color='red'><form:errors path="dataValue"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=AppData.ALIAS_DATA_VALUE_TEXT%>:
		</td>		
		<td>
		<form:input path="dataValueText" id="dataValueText" cssClass="" maxlength="65535" />
		<font color='red'><form:errors path="dataValueText"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=AppData.ALIAS_DISPLAY_NAME%>:
		</td>		
		<td>
		<form:input path="displayName" id="displayName" cssClass="" maxlength="256" />
		<font color='red'><form:errors path="displayName"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=AppData.ALIAS_SHORT_NAME%>:
		</td>		
		<td>
		<form:input path="shortName" id="shortName" cssClass="" maxlength="64" />
		<font color='red'><form:errors path="shortName"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=AppData.ALIAS_DATA_TYPE%>:
		</td>		
		<td>
		<form:input path="dataType" id="dataType" cssClass="validate-integer max-value-2147483647" maxlength="10" />
		<font color='red'><form:errors path="dataType"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=AppData.ALIAS_IS_AVAILABLE%>:
		</td>		
		<td>
		<form:input path="isAvailable" id="isAvailable" cssClass="" maxlength="1" />
		<font color='red'><form:errors path="isAvailable"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=AppData.ALIAS_CTIME%>:
		</td>		
		<td>
		<input value="${appData.ctimeString}" onclick="WdatePicker({dateFmt:'<%=AppData.FORMAT_CTIME%>'})" id="ctimeString" name="ctimeString"  maxlength="0" class="" />
		<font color='red'><form:errors path="ctime"/></font>
		</td>
	</tr>	
	
		