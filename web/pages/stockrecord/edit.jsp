<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<%@ include file="../../commons/opera-maskui-dialog-import.jsp" %>
	<link href="<c:url value="${ctx}/scripts/plugins/popup-input/popup-input.css"/>" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${ctx}/scripts/plugins/popup-input/popup_selection.js"></script>
	<title><%=StockRecord.TABLE_ALIAS%>编辑</title>
</rapid:override>

<rapid:override name="content">
	<form:form method="put" action="${ctx}/stockrecord/${stockRecord.stockOperationId}" modelAttribute="stockRecord">
		<input id="submitButton" name="submitButton" type="submit" value="提交" />
		<input type="button" value="返回列表" onclick="window.location='${ctx}/stockrecord'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<table class="formTable">
		<%@ include file="form_include.jsp" %>
		</table>
	</form:form>
	
	<script>
		
		new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
			var finalResult = result;
			
			//在这里添加自定义验证
			
			return disableSubmit(finalResult,'submitButton');
		}});
	</script>
	
	<script type="text/javascript">
	 var popupOption={
		 'stockRecord_deptId': {url:'${ctx}/dept/query',title:'选择部门',textColumn:'dept_name',valueColumn:'deptId'},
		 'stockRecord_staffId': {url:'${ctx}/staff/query',title:'选择创建人',textColumn:'staff_name',valueColumn:'staffId'},
		 'stockRecord_custId': {url:'${ctx}/customer/query',title:'选择客户',textColumn:'cust_name',valueColumn:'custId'},
		 'stockRecord_approvalId': {url:'${ctx}/staff/query',title:'选择创建人',textColumn:'staff_name',valueColumn:'staffId'},
		 'stockRecord_stockId': {url:'${ctx}/stockhouse/query',title:'选择仓库',textColumn:'stock_name',valueColumn:'stockId'}
		 //'stockRecord_toStockId': {url:'${ctx}/stockhouse/query',title:'选择仓库',textColumn:'stock_name',valueColumn:'stockId'}
	 };
	 PopupSelection.initOption(popupOption); 	
	</script>
	  <div id="dialog-modal" title="">
        <iframe frameborder="0" style="width:100%;height:99%;height:100%\9;" src="about:blank"></iframe>
    </div>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>