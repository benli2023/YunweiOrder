<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=AppData.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="appdata"  method="post">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/appdata'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="appDataId" name="appDataId" value="${appData.appDataId}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=AppData.ALIAS_DATA_CODE%></td>	
				<td><c:out value='${appData.dataCode}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=AppData.ALIAS_DATA_VALUE%></td>	
				<td><c:out value='${appData.dataValue}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=AppData.ALIAS_DATA_VALUE_TEXT%></td>	
				<td><c:out value='${appData.dataValueText}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=AppData.ALIAS_DISPLAY_NAME%></td>	
				<td><c:out value='${appData.displayName}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=AppData.ALIAS_SHORT_NAME%></td>	
				<td><c:out value='${appData.shortName}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=AppData.ALIAS_DATA_TYPE%></td>	
				<td><c:out value='${appData.dataType}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=AppData.ALIAS_IS_AVAILABLE%></td>	
				<td><c:out value='${appData.isAvailable}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=AppData.ALIAS_CTIME%></td>	
				<td><c:out value='${appData.ctimeString}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>