<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="stockId" name="stockId" value="${stockHouse.stockId}"/>

	<tr>	
		<td class="tdLabel">
			<%=StockHouse.ALIAS_STAFF_ID%>:
		</td>		
		<td>
		<form:input path="staffId" id="staffId" cssClass="validate-integer " maxlength="19" />
		<font color='red'><form:errors path="staffId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockHouse.ALIAS_ADDRESS%>:
		</td>		
		<td>
		<form:input path="address" id="address" cssClass="" maxlength="256" />
		<font color='red'><form:errors path="address"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockHouse.ALIAS_PHONE%>:
		</td>		
		<td>
		<form:input path="phone" id="phone" cssClass="" maxlength="32" />
		<font color='red'><form:errors path="phone"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockHouse.ALIAS_CTIME%>:
		</td>		
		<td>
		<input value="${stockHouse.ctimeString}" onclick="WdatePicker({dateFmt:'<%=StockHouse.FORMAT_CTIME%>'})" id="ctimeString" name="ctimeString"  maxlength="0" class="" />
		<font color='red'><form:errors path="ctime"/></font>
		</td>
	</tr>	
	
		