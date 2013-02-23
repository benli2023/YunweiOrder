<%@page import="com.yunwei.order.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=Customer.TABLE_ALIAS%> 维护</title>
	
	<script src="${ctx}/scripts/rest.js" ></script>
	<link href="<c:url value="/widgets/simpletable/simpletable.css"/>" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="<c:url value="/widgets/simpletable/simpletable.js"/>"></script>
	
	<script type="text/javascript" >
		$(document).ready(function() {
			// 分页需要依赖的初始化动作
			window.simpleTable = new SimpleTable('queryForm',${page.thisPageNumber},${page.pageSize},'${pageRequest.sortColumns}');
		});
	</script>
</rapid:override>

<rapid:override name="content">
	<form id="queryForm" name="queryForm" method="get" style="display: inline;">
	<div class="queryPanel">
		<fieldset>
			<legend>搜索</legend>
			<table>
				<tr>	
					<td class="tdLabel"><%=Customer.ALIAS_CUST_NAME%></td>		
					<td>
						<input value="${query.custName}" id="custName" name="custName" maxlength="64"  class=""/>
					</td>
					<td class="tdLabel"><%=Customer.ALIAS_SHORT_NAME%></td>		
					<td>
						<input value="${query.shortName}" id="shortName" name="shortName" maxlength="64"  class=""/>
					</td>
					<td class="tdLabel"><%=Customer.ALIAS_CUST_CODE%></td>		
					<td>
						<input value="${query.custCode}" id="custCode" name="custCode" maxlength="128"  class=""/>
					</td>
					<td class="tdLabel"><%=Customer.ALIAS_CONTACT_NAME%></td>		
					<td>
						<input value="${query.contactName}" id="contactName" name="contactName" maxlength="64"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Customer.ALIAS_CONTRY_CODE%></td>		
					<td>
						<input value="${query.contryCode}" id="contryCode" name="contryCode" maxlength="8"  class=""/>
					</td>
					<td class="tdLabel"><%=Customer.ALIAS_PROV_CODE%></td>		
					<td>
						<input value="${query.provCode}" id="provCode" name="provCode" maxlength="8"  class=""/>
					</td>
					<td class="tdLabel"><%=Customer.ALIAS_CITY_CODE%></td>		
					<td>
						<input value="${query.cityCode}" id="cityCode" name="cityCode" maxlength="8"  class=""/>
					</td>
					<td class="tdLabel"><%=Customer.ALIAS_ADDRESS%></td>		
					<td>
						<input value="${query.address}" id="address" name="address" maxlength="256"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Customer.ALIAS_CONTACT%></td>		
					<td>
						<input value="${query.contact}" id="contact" name="contact" maxlength="64"  class=""/>
					</td>
					<td class="tdLabel"><%=Customer.ALIAS_TELEPHONE%></td>		
					<td>
						<input value="${query.telephone}" id="telephone" name="telephone" maxlength="64"  class=""/>
					</td>
					<td class="tdLabel"><%=Customer.ALIAS_FAX%></td>		
					<td>
						<input value="${query.fax}" id="fax" name="fax" maxlength="64"  class=""/>
					</td>
					<td class="tdLabel"><%=Customer.ALIAS_EMAIL%></td>		
					<td>
						<input value="${query.email}" id="email" name="email" maxlength="64"  class="validate-email "/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Customer.ALIAS_WEBSITE%></td>		
					<td>
						<input value="${query.website}" id="website" name="website" maxlength="256"  class=""/>
					</td>
					<td class="tdLabel"><%=Customer.ALIAS_BANK%></td>		
					<td>
						<input value="${query.bank}" id="bank" name="bank" maxlength="128"  class=""/>
					</td>
					<td class="tdLabel"><%=Customer.ALIAS_BANK_ACCOUNT%></td>		
					<td>
						<input value="${query.bankAccount}" id="bankAccount" name="bankAccount" maxlength="128"  class=""/>
					</td>
					<td class="tdLabel"><%=Customer.ALIAS_BANK_ACCOUNT_NAME%></td>		
					<td>
						<input value="${query.bankAccountName}" id="bankAccountName" name="bankAccountName" maxlength="128"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Customer.ALIAS_TAX_ID%></td>		
					<td>
						<input value="${query.taxId}" id="taxId" name="taxId" maxlength="256"  class=""/>
					</td>
					<td class="tdLabel"><%=Customer.ALIAS_BUSINESS_PEOPLE%></td>		
					<td>
						<input value="${query.businessPeople}" id="businessPeople" name="businessPeople" maxlength="64"  class=""/>
					</td>
					<td class="tdLabel"><%=Customer.ALIAS_COLLECTION_PEOPLE%></td>		
					<td>
						<input value="${query.collectionPeople}" id="collectionPeople" name="collectionPeople" maxlength="64"  class=""/>
					</td>
					<td class="tdLabel"><%=Customer.ALIAS_CTIME%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.ctimeBegin}' pattern='<%=Customer.FORMAT_CTIME%>'/>" onclick="WdatePicker({dateFmt:'<%=Customer.FORMAT_CTIME%>'})" id="ctimeBegin" name="ctimeBegin"   />
						<input value="<fmt:formatDate value='${query.ctimeEnd}' pattern='<%=Customer.FORMAT_CTIME%>'/>" onclick="WdatePicker({dateFmt:'<%=Customer.FORMAT_CTIME%>'})" id="ctimeEnd" name="ctimeEnd"   />
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Customer.ALIAS_REMARK%></td>		
					<td>
						<input value="${query.remark}" id="remark" name="remark" maxlength="512"  class=""/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/customer'"/>
			<input type="button" class="stdButton" style="width:80px" value="新增" onclick="window.location = '${ctx}/customer/new'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="doRestBatchDelete('${ctx}/customer','items',document.forms.queryForm)"/>
		<div>
	
	</div>
	
	<div class="gridTable">
	
		<simpletable:pageToolbar page="${page}">
		显示在这里是为了提示你如何自定义表头,可修改模板删除此行
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="gridBody">
		  <thead>
			  
			  <tr>
				<th style="width:1px;"> </th>
				<th style="width:1px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="cust_name" ><%=Customer.ALIAS_CUST_NAME%></th>
				<th sortColumn="short_name" ><%=Customer.ALIAS_SHORT_NAME%></th>
				<th sortColumn="cust_code" ><%=Customer.ALIAS_CUST_CODE%></th>
				<th sortColumn="contact_name" ><%=Customer.ALIAS_CONTACT_NAME%></th>
				<th sortColumn="contry_code" ><%=Customer.ALIAS_CONTRY_CODE%></th>
				<th sortColumn="prov_code" ><%=Customer.ALIAS_PROV_CODE%></th>
				<th sortColumn="city_code" ><%=Customer.ALIAS_CITY_CODE%></th>
				<th sortColumn="address" ><%=Customer.ALIAS_ADDRESS%></th>
				<th sortColumn="contact" ><%=Customer.ALIAS_CONTACT%></th>
				<th sortColumn="telephone" ><%=Customer.ALIAS_TELEPHONE%></th>
				<th sortColumn="fax" ><%=Customer.ALIAS_FAX%></th>
				<th sortColumn="email" ><%=Customer.ALIAS_EMAIL%></th>
				<th sortColumn="website" ><%=Customer.ALIAS_WEBSITE%></th>
				<th sortColumn="bank" ><%=Customer.ALIAS_BANK%></th>
				<th sortColumn="bank_account" ><%=Customer.ALIAS_BANK_ACCOUNT%></th>
				<th sortColumn="bank_account_name" ><%=Customer.ALIAS_BANK_ACCOUNT_NAME%></th>
				<th sortColumn="tax_id" ><%=Customer.ALIAS_TAX_ID%></th>
				<th sortColumn="business_people" ><%=Customer.ALIAS_BUSINESS_PEOPLE%></th>
				<th sortColumn="collection_people" ><%=Customer.ALIAS_COLLECTION_PEOPLE%></th>
				<th sortColumn="cTime" ><%=Customer.ALIAS_CTIME%></th>
				<th sortColumn="remark" ><%=Customer.ALIAS_REMARK%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.custId}"></td>
				
				<td><c:out value='${item.custName}'/>&nbsp;</td>
				<td><c:out value='${item.shortName}'/>&nbsp;</td>
				<td><c:out value='${item.custCode}'/>&nbsp;</td>
				<td><c:out value='${item.contactName}'/>&nbsp;</td>
				<td><c:out value='${item.contryCode}'/>&nbsp;</td>
				<td><c:out value='${item.provCode}'/>&nbsp;</td>
				<td><c:out value='${item.cityCode}'/>&nbsp;</td>
				<td><c:out value='${item.address}'/>&nbsp;</td>
				<td><c:out value='${item.contact}'/>&nbsp;</td>
				<td><c:out value='${item.telephone}'/>&nbsp;</td>
				<td><c:out value='${item.fax}'/>&nbsp;</td>
				<td><c:out value='${item.email}'/>&nbsp;</td>
				<td><c:out value='${item.website}'/>&nbsp;</td>
				<td><c:out value='${item.bank}'/>&nbsp;</td>
				<td><c:out value='${item.bankAccount}'/>&nbsp;</td>
				<td><c:out value='${item.bankAccountName}'/>&nbsp;</td>
				<td><c:out value='${item.taxId}'/>&nbsp;</td>
				<td><c:out value='${item.businessPeople}'/>&nbsp;</td>
				<td><c:out value='${item.collectionPeople}'/>&nbsp;</td>
				<td><c:out value='${item.ctimeString}'/>&nbsp;</td>
				<td><c:out value='${item.remark}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/customer/${item.custId}">查看</a>&nbsp;&nbsp;
					<a href="${ctx}/customer/${item.custId}/edit">修改</a>&nbsp;&nbsp;
					<a href="${ctx}/customer/${item.custId}" onclick="doRestDelete(this,'你确认删除?');return false;">删除</a>
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar page="${page}">
		显示在这里是为了提示你如何自定义表头,可修改模板删除此行
		</simpletable:pageToolbar>
		
	</div>
	</form>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>
