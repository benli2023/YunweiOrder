<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="stockId" name="stockId" value="${stockHouse.stockId}"/>

	<tr>	
		<td class="tdLabel">
			<%=StockHouse.ALIAS_STAFF_ID%>:
		</td>		
		<td>
		<yun:button-edit name="staffIdTxt" hiddenName="staffId" id="stockHouse_staffId" txtVal="${stockHouse.staffIdTxt}"  hiddenVal="${stockHouse.staffId}" width="130"  profileId="stock"/> 
	
		<font color='red'><form:errors path="staffId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=StockHouse.ALIAS_STOCK_NAME%>:
		</td>		
		<td>
		<form:input path="stockName" id="stockName" cssClass="" maxlength="256" />
		<font color='red'><form:errors path="stockName"/></font>
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
	
		