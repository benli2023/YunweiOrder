<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="custId" name="custId" value="${customer.custId}"/>

	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_CUST_NAME%>:
		</td>		
		<td>
		<form:input path="custName" id="custName" cssClass="" maxlength="64" />
		<font color='red'><form:errors path="custName"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_SHORT_NAME%>:
		</td>		
		<td>
		<form:input path="shortName" id="shortName" cssClass="" maxlength="64" />
		<font color='red'><form:errors path="shortName"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_CUST_CODE%>:
		</td>		
		<td>
		<form:input path="custCode" id="custCode" cssClass="" maxlength="128" />
		<font color='red'><form:errors path="custCode"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_CONTACT_NAME%>:
		</td>		
		<td>
		<form:input path="contactName" id="contactName" cssClass="" maxlength="64" />
		<font color='red'><form:errors path="contactName"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_CONTRY_CODE%>:
		</td>		
		<td>
		<form:input path="contryCode" id="contryCode" cssClass="" maxlength="8" />
		<font color='red'><form:errors path="contryCode"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_PROV_CODE%>:
		</td>		
		<td>
		<form:input path="provCode" id="provCode" cssClass="" maxlength="8" />
		<font color='red'><form:errors path="provCode"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_CITY_CODE%>:
		</td>		
		<td>
		<form:input path="cityCode" id="cityCode" cssClass="" maxlength="8" />
		<font color='red'><form:errors path="cityCode"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_ADDRESS%>:
		</td>		
		<td>
		<form:input path="address" id="address" cssClass="" maxlength="256" />
		<font color='red'><form:errors path="address"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_CONTACT%>:
		</td>		
		<td>
		<form:input path="contact" id="contact" cssClass="" maxlength="64" />
		<font color='red'><form:errors path="contact"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_TELEPHONE%>:
		</td>		
		<td>
		<form:input path="telephone" id="telephone" cssClass="" maxlength="64" />
		<font color='red'><form:errors path="telephone"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_FAX%>:
		</td>		
		<td>
		<form:input path="fax" id="fax" cssClass="" maxlength="64" />
		<font color='red'><form:errors path="fax"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_EMAIL%>:
		</td>		
		<td>
		<form:input path="email" id="email" cssClass="validate-email " maxlength="64" />
		<font color='red'><form:errors path="email"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_WEBSITE%>:
		</td>		
		<td>
		<form:input path="website" id="website" cssClass="" maxlength="256" />
		<font color='red'><form:errors path="website"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_BANK%>:
		</td>		
		<td>
		<form:input path="bank" id="bank" cssClass="" maxlength="128" />
		<font color='red'><form:errors path="bank"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_BANK_ACCOUNT%>:
		</td>		
		<td>
		<form:input path="bankAccount" id="bankAccount" cssClass="" maxlength="128" />
		<font color='red'><form:errors path="bankAccount"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_BANK_ACCOUNT_NAME%>:
		</td>		
		<td>
		<form:input path="bankAccountName" id="bankAccountName" cssClass="" maxlength="128" />
		<font color='red'><form:errors path="bankAccountName"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_TAX_ID%>:
		</td>		
		<td>
		<form:input path="taxId" id="taxId" cssClass="" maxlength="256" />
		<font color='red'><form:errors path="taxId"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_BUSINESS_PEOPLE%>:
		</td>		
		<td>
		<form:input path="businessPeople" id="businessPeople" cssClass="" maxlength="64" />
		<font color='red'><form:errors path="businessPeople"/></font>
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_COLLECTION_PEOPLE%>:
		</td>		
		<td>
		<form:input path="collectionPeople" id="collectionPeople" cssClass="" maxlength="64" />
		<font color='red'><form:errors path="collectionPeople"/></font>
		</td>
	</tr>	
	
	<!--  
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_CTIME%>:
		</td>		
		<td>
		<input value="${customer.ctimeString}" onclick="WdatePicker({dateFmt:'<%=Customer.FORMAT_CTIME%>'})" id="ctimeString" name="ctimeString"  maxlength="0" class="" />
		<font color='red'><form:errors path="ctime"/></font>
		</td>
	</tr>	
	-->
	<tr>	
		<td class="tdLabel">
			<%=Customer.ALIAS_REMARK%>:
		</td>		
		<td>
		<form:input path="remark" id="remark" cssClass="" maxlength="512" />
		<font color='red'><form:errors path="remark"/></font>
		</td>
	</tr>	
	
		