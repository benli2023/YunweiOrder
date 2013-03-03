<%@page import="com.yunwei.order.model.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=Product.TABLE_ALIAS%> 维护</title>
	<%@ include file="../../commons/opera-maskui-dialog-import.jsp" %>
	<script src="${ctx}/scripts/rest.js" ></script>
	<link href="<c:url value="/widgets/simpletable/simpletable.css"/>" type="text/css" rel="stylesheet">
	
	<script type="text/javascript" src="<c:url value="/widgets/simpletable/simpletable.js"/>"></script>
	<script type="text/javascript" >
		$(document).ready(function() {
			// 分页需要依赖的初始化动作
			window.simpleTable = new SimpleTable('queryForm',${page.thisPageNumber},${page.pageSize},'${pageRequest.sortColumns}');
		});
		
		
	</script>
	
	<style>
	body .mini-textbox *,
body .mini-buttonedit *
{

box-sizing:content-box;
-moz-box-sizing:content-box;
-ms-box-sizing:content-box;
-webkit-box-sizing:content-box;
}


.mini-buttonedit-border
{
background:white;
border: solid 1px #a5acb5;
width:123px;
height:19px;
display:inline-block;
position:static;
float:left;
overflow:hidden;
}


.mini-buttonedit-input
{
background:none;
border: 0;
width:100px;
height:19px;
line-height:19px;
font-family: Verdana;
font-size: 9pt;
padding: 0;
margin:0;
padding-left:1px;
padding-right:1px;
outline:none;
float:left;
z-index:1;
cursor:text;
}


.mini-buttonedit-button, .mini-buttonedit-close
{
border:0px;
padding:1px;
background:none;
width:15px;
height:15px;
overflow:hidden;
cursor:pointer;
margin-top:1px;
margin-right:1px;
float:right;
z-index:10;
}

.mini-buttonedit-icon
{
display:block;
width:15px;
height:15px;
overflow:hidden;
background:url(<c:url value="${ctx}/scripts/plugins/popup-input/img/icon1.gif" />) no-repeat 50% 50%;
}

.mini-buttonedit-close
{
background:url(<c:url value="${ctx}/scripts/plugins/popup-input/img/close.gif" />) no-repeat 50% 50%;
}

.mini-buttonedit-button-hover,
.mini-buttonedit-hover .mini-buttonedit-button
{
border:1px solid #ababab;
padding:0;
background:#dde6fe url(<c:url value="${ctx}/scripts/plugins/popup-input/img/hover.png" />) repeat-x 0 0;
}

	</style>
	<script type="text/javascript">
<!--


//-->
</script>
</rapid:override>

<rapid:override name="content">
	<form id="queryForm" name="queryForm" method="get" style="display: inline;">
	<div class="queryPanel">
		<fieldset>
			<legend>搜索</legend>
			<table>
				<tr>	
					<td class="tdLabel"><%=Product.ALIAS_CAT_ID%></td>
					<td>
						<span class="mini-buttonedit" style="border-width: 0px; width: 130px;" id="btnEdit1">
						<span class="mini-buttonedit-border" style="width: 130px;">
						<input type="input" class="mini-buttonedit-input" autocomplete="off" placeholder="" name="catIdTxt" style="width: 103px;" id="popup_input_id" value="${query.catIdTxt}">
						<input type="hidden" name="catId" value="${product.catId}" id="hidden_popup_id" class="popup_hidden_Id"/>
						  <span class="mini-buttonedit-button mini-buttonedit-button-hover" onmouseover="addClass(this,'mini-buttonedit-button-hover');" onmouseout="removeClass(this,'mini-buttonedit-button-hover');" onclick="openDialog()">
						  <span class="mini-buttonedit-icon"></span>
						</span>
						<span class="mini-buttonedit-close" style="display: none;"></span>
						</span>
						</span>
					<td class="tdLabel"><%=Product.ALIAS_PRODUCT_NAME%></td>		
					<td>
						<input value="${query.productName}" id="productName" name="productName" maxlength="64"  class=""/>
					</td>
					<td class="tdLabel"><%=Product.ALIAS_PRODUCT_CODE%></td>		
					<td>
						<input value="${query.productCode}" id="productCode" name="productCode" maxlength="64"  class=""/>
					</td>
					<td class="tdLabel"><%=Product.ALIAS_CEIL_LIMIT%></td>		
					<td>
						<input value="${query.ceilLimit}" id="ceilLimit" name="ceilLimit" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Product.ALIAS_LOW_LIMIT%></td>		
					<td>
						<input value="${query.lowLimit}" id="lowLimit" name="lowLimit" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=Product.ALIAS_PINY_CODE%></td>		
					<td>
						<input value="${query.pinyCode}" id="pinyCode" name="pinyCode" maxlength="64"  class=""/>
					</td>
					<td class="tdLabel"><%=Product.ALIAS_PRODUCT_SPEC%></td>		
					<td>
						<input value="${query.productSpec}" id="productSpec" name="productSpec" maxlength="64"  class=""/>
					</td>
					<td class="tdLabel"><%=Product.ALIAS_SALE_PRICE%></td>		
					<td>
						<input value="${query.salePrice}" id="salePrice" name="salePrice" maxlength="10"  class="validate-integer "/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Product.ALIAS_PURCHASE_PRICE%></td>		
					<td>
						<input value="${query.purchasePrice}" id="purchasePrice" name="purchasePrice" maxlength="10"  class="validate-integer "/>
					</td>
					
					<td class="tdLabel"><%=Product.ALIAS_IS_AVAILABLE%></td>
					<td>
					<select name="isAvailable">
						<option value="-1" <c:if test="${query.isAvailable==-1}">selected</c:if>>不限</option>
						<option value="1" <c:if test="${query.isAvailable==1}">selected</c:if>>是</option>
						<option value="0" <c:if test="${query.isAvailable==0}">selected</c:if>>否</option>		
					</select>
					</td>
					<td class="tdLabel"><%=Product.ALIAS_IS_SELLABLE%></td>		
					<td>
							<!-- <input value="${query.isSellable}" id="isSellable" name="isSellable" maxlength="1"  class=""/>-->
						<select name="isSellable">
							<option value="-1" <c:if test="${query.isSellable==-1}">selected</c:if>>不限</option>
							<option value="1" <c:if test="${query.isSellable==1}">selected</c:if>>是</option>
							<option value="0" <c:if test="${query.isSellable==0}">selected</c:if>>否</option>		
						</select>
					</td>
					
					<td class="tdLabel"><%=Product.ALIAS_IS_NEGATIVE%></td>	
					<td>
						<select name="isNegative">
							<option value="-1" <c:if test="${query.isNegative==-1}">selected</c:if>>不限</option>
							<option value="1" <c:if test="${query.isNegative==1}">selected</c:if>>允许</option>
							<option value="0" <c:if test="${query.isNegative==0}">selected</c:if>>不允许</option>		
						</select>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Product.ALIAS_IS_PURCHASABLE%></td>		
					<td>
						<select name="isPurchasable">
							<option value="-1" <c:if test="${query.isPurchasable==-1}">selected</c:if>>不限</option>
							<option value="1" <c:if test="${query.isPurchasable==1}">selected</c:if>>是</option>
							<option value="0" <c:if test="${query.isPurchasable==0}">selected</c:if>>否</option>		
						</select>
						
					</td>
					<td class="tdLabel"><%=Product.ALIAS_MANUFACTURER%></td>		
					<td>
						<input value="${query.manufacturer}" id="manufacturer" name="manufacturer" maxlength="256"  class=""/>
					</td>
					<td class="tdLabel"><%=Product.ALIAS_ORGINAL_PLACE%></td>		
					<td>
						<input value="${query.orginalPlace}" id="orginalPlace" name="orginalPlace" maxlength="256"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Product.ALIAS_CTIME%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.ctimeBegin}' pattern='<%=Product.FORMAT_CTIME%>'/>" onclick="WdatePicker({dateFmt:'<%=Product.FORMAT_CTIME%>'})" id="ctimeBegin" name="ctimeBegin"   />
						<input value="<fmt:formatDate value='${query.ctimeEnd}' pattern='<%=Product.FORMAT_CTIME%>'/>" onclick="WdatePicker({dateFmt:'<%=Product.FORMAT_CTIME%>'})" id="ctimeEnd" name="ctimeEnd"   />
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/product'"/>
			<input type="button" class="stdButton" style="width:80px" value="新增" onclick="window.location = '${ctx}/product/new'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="doRestBatchDelete('${ctx}/product','items',document.forms.queryForm)"/>
		<div>
	
	</div>
	
	<div class="gridTable">
	
		<simpletable:pageToolbar page="${page}">
			产品列表
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="gridBody">
		  <thead>
			  
			  <tr>
				<th style="width:1px;"> </th>
				<th style="width:1px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="cat_id" ><%=Product.ALIAS_CAT_ID%></th>
				<th sortColumn="product_name" ><%=Product.ALIAS_PRODUCT_NAME%></th>
				<th sortColumn="product_code" ><%=Product.ALIAS_PRODUCT_CODE%></th>
				<th sortColumn="ceil_limit" ><%=Product.ALIAS_CEIL_LIMIT%></th>
				<th sortColumn="low_limit" ><%=Product.ALIAS_LOW_LIMIT%></th>
				<th sortColumn="piny_code" ><%=Product.ALIAS_PINY_CODE%></th>
				<th sortColumn="product_spec" ><%=Product.ALIAS_PRODUCT_SPEC%></th>
				<th sortColumn="sale_price" ><%=Product.ALIAS_SALE_PRICE%></th>
				<th sortColumn="purchase_price" ><%=Product.ALIAS_PURCHASE_PRICE%></th>
				<th sortColumn="is_available" ><%=Product.ALIAS_IS_AVAILABLE%></th>
				<th sortColumn="is_sellable" ><%=Product.ALIAS_IS_SELLABLE%></th>
				<th sortColumn="is_negative" ><%=Product.ALIAS_IS_NEGATIVE%></th>
				<th sortColumn="is_purchasable" ><%=Product.ALIAS_IS_PURCHASABLE%></th>
				<th sortColumn="product_image" ><%=Product.ALIAS_PRODUCT_IMAGE%></th>
				<th sortColumn="manufacturer" ><%=Product.ALIAS_MANUFACTURER%></th>
				<th sortColumn="orginal_place" ><%=Product.ALIAS_ORGINAL_PLACE%></th>
				<th sortColumn="cTime" ><%=Product.ALIAS_CTIME%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="${item.productId}"></td>
				
				<td><c:out value='${item.catIdTxt}'/>&nbsp;</td>
				<td><c:out value='${item.productName}'/>&nbsp;</td>
				<td><c:out value='${item.productCode}'/>&nbsp;</td>
				<td><c:out value='${item.ceilLimit}'/>&nbsp;</td>
				<td><c:out value='${item.lowLimit}'/>&nbsp;</td>
				<td><c:out value='${item.pinyCode}'/>&nbsp;</td>
				<td><c:out value='${item.productSpec}'/>&nbsp;</td>
				<td><c:out value='${item.salePrice}'/>&nbsp;</td>
				<td><c:out value='${item.purchasePrice}'/>&nbsp;</td>
				<td><c:choose><c:when test="${item.isAvailable==1}">是</c:when><c:when test="${item.isAvailable==0}">否</c:when></c:choose></td>
				<td><c:choose><c:when test="${item.isSellable==1}">是</c:when><c:when test="${item.isSellable==0}">否</c:when></c:choose></td>
				<td><c:choose><c:when test="${item.isNegative==1}">是</c:when><c:when test="${item.isNegative==0}">否</c:when></c:choose></td>
				<td><c:choose><c:when test="${item.isPurchasable==1}">是</c:when><c:when test="${item.isPurchasable==0}">否</c:when></c:choose></td>
				<td><img id="preview" <c:if test="${! empty item.productImage}">src="${ctx}/${item.productImage}" </c:if>  alt="" style="<c:if test="${ empty item.productImage}">display:none;</c:if> max-width: 100px; max-height: 60px; border: none; width:100px;height:60px"/></td>
				<td><c:out value='${item.manufacturer}'/>&nbsp;</td>
				<td><c:out value='${item.orginalPlace}'/>&nbsp;</td>
				<td><c:out value='${item.ctimeString}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/product/${item.productId}">查看</a>&nbsp;&nbsp;
					<a href="${ctx}/product/${item.productId}/edit">修改</a>&nbsp;&nbsp;
					<a href="${ctx}/product/${item.productId}" onclick="doRestDelete(this,'你确认删除?');return false;">删除</a>
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar page="${page}">
	
		</simpletable:pageToolbar>
		
	</div>
	</form>
	

<script>
	 var popupOption={
		 'popup_input_id': {url:'${ctx}/category/query',title:'选择产品分类',hiddenId:''}
	 };
     function fillBackAndCloseDialog(rowData,fieldId){
        $( "#dialog-modal").omDialog('close');
        window.frames[0].location.href="about:blank";//reset the iframe location
        window.$('#'+fieldId).val(rowData.cateName).next('.popup_hidden_Id:eq(0)').val(rowData.cateId);
     };
     
     function clearSelection(id,hiddenId) {
    	 var obj=document.getElementById(id);
    	 if(obj) obj.value='';
    	 var obj2=document.getElementById(hiddenId);
    	 if(obj2) obj2.value='';
     }
     
     function openSelection(fieldId) {
     	var requestUrl=popupOption[fieldId].url;
     	var title=popupOption[fieldId].title;
         $( "#dialog-modal").omDialog({
         	title:title
         });
         $( "#dialog-modal").omDialog('open');
         var frameLoc=window.frames[0].location;
         frameLoc.href=requestUrl+"?fieldId="+fieldId; 
     }
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
						  openSelection(fieldId);
		                return false;
		           }else{
		               return false; //forbide any input
		           }
		        });
        }
    });
    
    function addClass(obj,cssClazz) {
    		$(obj).addClass(cssClazz);
    	}
    	function removeClass(obj,cssClazz) {
    	 $(obj).removeClass(cssClazz);
    	}
    	function openDialog() {
    		openSelection('popup_input_id');
    	}
    	function onClose() {
    	//$("#undo").show();
    	}
    	function close() {
    	var kendoWindow = $("#window").data("kendoWindow");
    	kendoWindow.close();
    	}
    	function setValue(txt,val) {
    	$('#popup_input_id').val(txt);
    	$('#hidden_popup_id').val(val);
    	}
	</script>
	  <div id="dialog-modal" title="">
        <iframe frameborder="0" style="width:100%;height:99%;height:100%\9;" src="about:blank"></iframe>
    </div>
	
</rapid:override>

<%-- jsp模板继承,具体使用请查看: http://code.google.com/p/rapid-framework/wiki/rapid_jsp_extends --%>
<%@ include file="base.jsp" %>
