<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=StockHouse.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<form:form modelAttribute="stockhouse"  >
		<input type="button" value="返回列表" onclick="window.location='${ctx}/stockhouse'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<input type="hidden" id="stockId" name="stockId" value="${stockHouse.stockId}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=StockHouse.ALIAS_STAFF_ID%></td>	
				<td><c:out value='${stockHouse.staffId}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockHouse.ALIAS_STOCK_NAME%></td>	
				<td><c:out value='${stockHouse.stockName}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockHouse.ALIAS_ADDRESS%></td>	
				<td><c:out value='${stockHouse.address}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockHouse.ALIAS_PHONE%></td>	
				<td><c:out value='${stockHouse.phone}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StockHouse.ALIAS_CTIME%></td>	
				<td><c:out value='${stockHouse.ctimeString}'/></td>
			</tr>
		</table>
	</form:form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>