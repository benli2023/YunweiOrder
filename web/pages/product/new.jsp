<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=Product.TABLE_ALIAS%>新增</title>
	
	<script type="text/javascript" src="<c:url value="/scripts/image-priew/image-preview.js"/>"></script>
	<!--[if gte IE 7]> 
		<script type="text/javascript" src="<c:url value="/scripts/image-priew/image-preview-ie.js"/>"></script>
	<![endif]-->
	
	<%@ include file="../../commons/opera-maskui-dialog-import.jsp" %>
	<link href="<c:url value="${ctx}/scripts/plugins/popup-input/popup-input.css"/>" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${ctx}/scripts/plugins/popup-input/popup_selection.js"></script>
</rapid:override>

<rapid:override name="content">
	<form:form method="post" action="${ctx}/product" modelAttribute="product" enctype="multipart/form-data">
		<table class="formTable">
		<%@ include file="form_include.jsp" %>
		</table>
		<input id="submitButton" name="submitButton" type="submit" value="提交" />
		<input type="button" value="返回列表" onclick="window.location='${ctx}/product'"/>
		<input type="button" value="后退" onclick="history.back();"/>
	</form:form>
	
	<script>
		new Validation(document.forms[0],{onSubmit:true,immediate:true,onFormValidate : function(result,form) {
			var finalResult = result;
			return disableSubmit(finalResult,'submitButton');
		}});
	</script>
		
		
		
		
	<script type="text/javascript">

	 var popupOption={
		 'popup_input_id': {url:'${ctx}/category/query',title:'选择产品分类',hiddenId:'',textColumn:'cate_name',valueColumn:'cateId'}
	 };
	 PopupSelection.initOption(popupOption); 	
	</script>
	  <div id="dialog-modal" title="">
        <iframe frameborder="0" style="width:100%;height:99%;height:100%\9;" src="about:blank"></iframe>
    </div>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>
