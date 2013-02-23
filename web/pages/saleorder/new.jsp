<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
   	<!--   <script src="<c:url value="/resources/plugins/jquery-combogrid-plugin/jquery/jquery-ui-1.8.9.custom.min.js"/>" type="text/javascript"></script> -->
	<!--  <script src="<c:url value="/resources/plugins/jquery-combogrid-plugin/plugin/jquery.ui.combogrid-1.6.2.js"/>" type="text/javascript"></script> -->
	
	<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/plugins/operamasks-ui/themes/default/operamasks-ui.min.css"/>" />
	
	
	<script src="<c:url value="/resources/plugins/operamasks-ui/operamasks-ui.min.js"/>" type="text/javascript"></script>
	
	<title><%=SaleOrder.TABLE_ALIAS%>新增</title>
</rapid:override>

<rapid:override name="content">

<div class="row">
			<div class="twelve columns">
				<div class="box_c">
					<div class="box_c_heading cf">
						<div class="box_c_ico"><img src="${ctx}/pertho/img/ico/icSw2/16-List.png" alt="" /></div>
						<p>Extended Form elements</p>
					</div>
					
					<div class="box_c_content form_a">
					
					<div class="tab_pane">
							<form:form method="post" action="${ctx}/saleorder" modelAttribute="saleOrder" cssClass="nice custom">
								<%@ include file="form_include.jsp" %>
								
									<div class="formRow cf">
		           							<input type="submit" class="gh_button" value="创建订单" />
											<input type="button" class="gh_button" value="返回列表" onclick="window.location='${ctx}/saleorder'"/>
											<input type="button" class="gh_button" value="后退" onclick="history.back();"/>
    								</div>
							</form:form>
							
					</div>
					
					</div>
					
					
				</div>
</div>
</div>


	
	
	<script>

	 
	 var popupOption={
		 'staffId': {url:'${ctx}/staff/query',title:'选择用户'},
		 'custId':{url:'${ctx}/customer/query',title:'选择客户'}
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
	
	<script>
		$(document).ready(function() {
                //* common functions
				prth_common.init();
				//clear form
				//prth_clearForm.init();
				//* datepicker & timepicker
				//prth_dp_tp.init();
				$("input#orderDateString").datepicker({dateFormat: 'yy-mm-dd'});
				$("input#deliveryDateString").datepicker({dateFormat: 'yy-mm-dd'});
				});
	</script>
	
	  <div id="dialog-modal" title="">

        <iframe frameborder="0" style="width:100%;height:99%;height:100%\9;" src="about:blank"></iframe>

    </div>
	
</rapid:override>
<%@ include file="base.jsp" %>
