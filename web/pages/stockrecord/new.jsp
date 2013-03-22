<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<%@ include file="../../commons/opera-maskui-dialog-import.jsp" %>
	<link href="<c:url value="${ctx}/scripts/plugins/popup-input/popup-input.css"/>" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${ctx}/scripts/plugins/popup-input/popup_selection.js"></script>
	
	<link href="<c:url value="${ctx}/scripts/plugins/easytab/css/easytab.css"/>" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${ctx}/scripts/plugins/easytab/vendor/jquery.hashchange.min.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/plugins/easytab/vendor/jquery.easytabs.min.js"></script>
	
	<!-- grid -->
	<script src="<c:url value="/scripts/plugins/operamasks-ui/js/om-combo.js" />" ></script>
	<script src="<c:url value="/scripts/plugins/operamasks-ui/js/om-numberfield.js" />"></script>
    <script src="<c:url value="/scripts/plugins/operamasks-ui/js/om-calendar.js" />"></script>
    <script type="text/javascript" src="<c:url value="/scripts/plugins/operamasks-ui/js/om-grid.js" />"></script>
    <script type="text/javascript" src="<c:url value="/scripts/plugins/operamasks-ui/js/om-grid-roweditor.js" />"></script>
	
	<title><%=StockRecord.TABLE_ALIAS%>新增</title>
</rapid:override>

<rapid:override name="content">
	<form:form method="post" action="${ctx}/stockrecord" modelAttribute="stockRecord" >
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
					<input type="button" id="save" value="保存修改" />
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
    
    $(document).ready(function() {
            $('#grid').omGrid({
                limit:10,
                title : '表格',
                width:600,
                height : 300,
                colModel : [ <c:forEach items="${colModelList}" var="current" varStatus="loop">
        	    			   {header: '<c:out value="${current.header}" />',name:'<c:out value="${current.name}" />',width:'<c:out value="${current.width}" />',align:'<c:out value="${current.align}" />' }<c:if test="${!loop.last}">,</c:if>
        					  </c:forEach>],
				dataSource : "${ctx}/stockrecordline/index.json",
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
            
            $('#add').click(function(){
            	$('#grid').omGrid('insertRow',0,{productId:100});
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
            	/*****保存成功之后执行如下操作********/
            	 $('#grid').omGrid('saveChanges');
            	/******或者执行$('#grid').omGrid('reload');***/
            });
        });
  </script>
  
    
    
</rapid:override>

<%@ include file="base.jsp" %>
