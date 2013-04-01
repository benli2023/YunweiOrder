<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<script>
		
		new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
			var finalResult = result;
			var data = $('#grid').omGrid('getChanges');
			$('#product_json_data').val(JSON.stringify(data));
			return disableSubmit(finalResult,'submitButton');
		}});
	</script>

	<div id="tab-container" class="tab-container">
		<ul class='etabs'>
			<li class='tab'><a href="#tabs1-html">产品列表</a>
			</li>
			<li class='tab'><a href="#tabs1-js">Required JS</a>
			</li>
			<li class='tab'><a href="#tabs1-css">Example CSS</a>
			</li>
		</ul>
		<div class='panel-container'>
		<div id="tabs1-html">
			<!-- content -->
				<div id="demo" style="margin-left: 30px; margin-top: 20px">
					<input type="button" id="add" value="新增" /> 
					<input type="button" id="del" value="删除" /> 

					<table id="grid"></table>
				</div>
			</div>
		<div id="tabs1-js">
			<h2>JS for these tabs</h2>
			<!-- content -->
		</div>
		<div id="tabs1-css">
			<h2>CSS Styles for these tabs</h2>
			<!-- content -->
		</div>
		</div>
	</div>



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
    
    <script type="text/javascript">
    $(document).ready( function() {
      $('#tab-container').easytabs();
    });
    
    $.validator.addMethod("invoiceNumber", function(value) {
        if($('#haveInvoice').val()=='是'&&!value)  {
        	return false;
        }
        return true;
 	}, '请填写发票号');
    
    $(document).ready(function() {
            $('#grid').omGrid({
                limit:10,
                title : '表格',
                width:750,
                height : 300,
                editMode:"all",
                colModel : [<c:forEach items="${colModelList}" var="current" varStatus="loop">
        	    			   { 
        	    				   header: '<c:out value="${current.header}" />',
        	    				   name:'<c:out value="${current.name}" />',
        	    				   width:'<c:out value="${current.width}" />',
        	    				   align:'<c:out value="${current.align}" />' 
        	    				   <c:if test="${!empty current.editor}">,
        	    				   editor:{
   											<c:if test="${!empty current.editor.rules}">rules:
        	    					   			<c:if test="${fn:length(current.editor.rules)>1}">[</c:if>
        	    					   				<c:forEach items="${current.editor.rules}" var="rule" varStatus="ruleLoop">
        	    					   						<c:if test="${!empty rule.customValidator}">['<c:out value="${rule.customValidator}" />']</c:if>
        	    					   						<c:if test="${empty rule.customValidator}">['<c:out value="${rule.method}" />',<c:out value="${rule.value}" />,'<c:out value="${rule.message}" />']</c:if>
        	    					   						<c:if test="${!ruleLoop.last}">,</c:if>
        	    					   				</c:forEach>
        	    					   			<c:if test="${fn:length(current.editor.rules)>1}">]</c:if>,
        	    					   		</c:if>
        	    				           type:'<c:out value="${current.editor.type}" />',
        	    				           editable:<c:out value="${current.editor.editable}" />, 
        	    				           <c:if test="${!empty current.editor.options}">options:<c:out value="${current.editor.options}" escapeXml="false"/>,</c:if>
        	    				           name:'<c:out value="${current.editor.name}" />'}</c:if>
        	    				           <c:if test="${!empty current.renderer}">,renderer:<c:out value="${current.renderer}" escapeXml="false"/></c:if>
        	    				 }<c:if test="${!loop.last}">,</c:if>
        					</c:forEach>],
				dataSource : "${ctx}/stockrecordline/index.json?stockOperationId=${stockRecord.stockOperationId}",
				onBeforeEdit : function(){
					$('#demo >:button').attr("disabled",true);
				},
				onAfterEdit : function(){
					$('#demo >:button').removeAttr("disabled");
				},
				onCancelEdit : function(){
					$('#demo >:button').removeAttr("disabled");
				}
            });
            
            popupOption['productId']={
            		url:'${ctx}/product/query',
            		title:'选择产品',
            		textColumn:'product_name',
            		valueColumn:'productId',
            		IdFieldId:'productId',
            		TxtFieldId:'productIdTxt',
            		fields:{'price':'salePrice'},
            		callback:function(rowdata,fieldId) {
            			$('#grid').omGrid('ValidateRowData');
            		}
            	};
            
            $('#productIdTxt').live('focus',function(){
            	PopupSelection.openSelection('productId','product');
            });
            
            
            $('#add').click(function(){
            	$('#grid').omGrid('insertRow',0);
            });
            $('#del').click(function(){
            	var dels = $('#grid').omGrid('getSelections');
            	if(dels.length <= 0 ){
            		alert('请选择删除的记录！');
            		return;
            	}
            	$('#grid').omGrid('deleteRow',dels[0]);
            });
            $('#save').click(function(){
            	var data = $('#grid').omGrid('getChanges');
            	/*****此处传递data到后台并处理*******/
            		alert(JSON.stringify(data));
            	/*****保存成功之后执行如下操作********/
            	 $('#grid').omGrid('saveChanges');
            	/******或者执行$('#grid').omGrid('reload');***/
            });
        });
  </script>