<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=Product.TABLE_ALIAS%>编辑</title>
	<%@ include file="../../commons/opera-maskui-import.jsp" %>
	<script type="text/javascript" src="<c:url value="/scripts/image-priew/image-preview.js"/>"></script>
	<!--[if gte IE 7]> 
		<script type="text/javascript" src="<c:url value="/scripts/image-priew/image-preview-ie.js"/>"></script>
	<![endif]-->
</rapid:override>

<rapid:override name="content">
	<form:form method="put" action="${ctx}/product/update/${product.productId}" modelAttribute="product"  enctype="multipart/form-data">
		<table class="formTable">
		<%@ include file="form_include.jsp" %>
		<input id="submitButton" name="submitButton" type="submit" value="提交" />
		<input type="button" value="返回列表" onclick="window.location='${ctx}/product'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		</table>
	</form:form>
	
	<script>
		
		new Validation(document.forms[0],{onSubmit:true,immediate:true,onFormValidate : function(result,form) {
			var finalResult = result;
			
			//在这里添加自定义验证
			
			return disableSubmit(finalResult,'submitButton');
		}});
	</script>
	
		<script>
	 var popupOption={
		 'catIdTxt': {url:'${ctx}/category/query',title:'选择产品分类'}
	 };
     function fillBackAndCloseDialog(data){
        $( "#dialog-modal").omDialog('close');
        window.frames[0].location.href="about:blank";//reset the iframe location
     };
    $(function() {
        $( "#dialog-modal").omDialog({
            autoOpen: false,
            width:535,
            height: 465,
            modal: true
        });
        for(var htmlId in popupOption) {
		        $('#'+htmlId).keydown(function(e){
		             if(e.keyCode==118){ //F7
		            	var fieldId=$(this).attr('id');
		            	var requestUrl=popupOption[fieldId].url;
		            	var title=popupOption[fieldId].title;
			            $( "#dialog-modal").omDialog({
			            	title:title
			            });
		                $( "#dialog-modal").omDialog('open');
		                var frameLoc=window.frames[0].location;
		                var date=new Date();
		                frameLoc.href=requestUrl+"?fieldId="+fieldId;
		                return false;
		           }else{
		               return false; //forbide any input
		           }
		        });
        }
    });
	</script>
	  <div id="dialog-modal" title="">
        <iframe frameborder="0" style="width:100%;height:99%;height:100%\9;" src="about:blank"></iframe>
    </div>
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>