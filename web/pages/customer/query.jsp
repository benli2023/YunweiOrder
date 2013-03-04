<%@page import="com.yunwei.order.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=Staff.TABLE_ALIAS%>新增</title>
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/plugins/operamasks-ui/themes/default/operamasks-ui.min.css"/>" />
	<script src="<c:url value="/resources/plugins/operamasks-ui/operamasks-ui.min.js"/>" type="text/javascript"></script>
</rapid:override>

<rapid:override name="content">
	<style>
        html,body{
            margin: 0;
            padding: 0;
        }
        .treeContainer{
            width: 100%;
            height:100%;
            overflow: auto;
        }
        .toolbar{
            padding: 10px 0;
        }
        #q{
            width: 80px;
        }
    </style>
    <!-- view_source_begin -->
    <script type="text/javascript">
        var orgId=null;
        var parentFieldId='${fieldId}';
        $(document).ready(function() {
            var dataUrl='${ctx}/customer/index.json'; 
            $('#userGrid').omGrid({
                dataSource : dataUrl+'?q=&amp;orgId=',
                width : 500,
                height : 200,
                limit : 10, //不分页
                colModel : [ {header : '编号', name : 'custId', width : 50, align : 'center'}, 
                             {header : '客户名称', name : 'cust_name', width : 60, align : 'left'}, 
                             {header : '联系人', name : 'contact_name', align : 'center', width : 50}
                           ],
                onRowDblClick:function(e, rowData) {
                	  window.parent.$('#'+parentFieldId).val(rowData.cust_name).next('.userIDHidden:eq(0)').val(rowData.custId);
                      //window.parent.$( "#dialog-modal").omDialog('close');
                      window.parent.fillBackAndCloseDialog(rowData);
                }
            });
            $('#query').omButton({
                onClick:function(e) {
                    $('#userGrid').omGrid("setData", encodeURI(dataUrl+'?searchTerm='+$('#q').val()));
                }
            });
        });
    </script>



    <table style="width:100%;height:100%">
        <tbody><tr valign="top">
            <td> 
                <div class="toolbar">
			        查询条件(编号或姓名模糊查询)：
			        <input id="q">
			       <input id="query" type="submit" value="查询" />
			    </div>
				<table id="userGrid"></div>
            </td>
        </tr>
    </tbody>
	</table>


</rapid:override>

<%@ include file="../no_head_base.jsp" %>