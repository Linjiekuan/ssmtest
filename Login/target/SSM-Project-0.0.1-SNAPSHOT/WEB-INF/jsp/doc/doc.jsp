<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件管理页面</title>
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.net/Public/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.net/Public/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.net/Public/js/easyui/demo/demo.css">
<link href="/SSM-Project/css/allmain.css" rel="stylesheet"/>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript"
	src="http://www.jeasyui.net/Public/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="datagrid-filter.js"></script>
<script type="text/javascript">
var url;
//新增用户，打开对话框，指定url为add
function addDoc(){
    $('#dlg').dialog('open').dialog('setTitle','文件上传');
    $('#fm').form('clear');
    url = 'addFile';
}
function downDoc(){
	var row = $('#dg').datagrid('getSelected');
    if(row){
        //消息框
        $.messager.confirm('警告','确定吗？',function(r) {
            //点击确认
            if(r){
                $.post('downDoc',{id:row.id},function(result){
                    var res = eval('('+result+')');
                    if (res.success){
                        //重新加载该页数据
                        $('#dg').datagrid('reload');
                    }
                    $.messager.show({
                        title: '提示',
                        msg: res.msg
                    });
                });
            }
        });
    }
}
//按条件筛选
function searchFilter(){
    var title = $('#title').val();
    //传递筛选条件重新加载
    $('#dg').datagrid('load',{
    	title: title,
    });
}

</script>
</head>
<body>
	<!-- datagrid，通过url指定数据来源，toolbar指定头部工具栏，pagination显示分页工具栏-->
	<!-- 自动获取后台的数据，主动加载或者更新数据-->    
	<table id="dg" fit="true" title="文件管理" class="easyui-datagrid"
		style="width: 100%; height: 500px;" url="getAllDocuments" toolbar="#toolbar"
		pagination="true" rownumbers="true" fitColumns="true" options="onRowContextMenu:onRowContextMenu"
		singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="10%" align="center">文件ID</th>
				<th field="title" width="25%" align="center">文件名称</th>
				<th field="remark" width="65%" align="center">文件描述</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<!-- 增、改、删按钮 -->
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="addDoc()">新增</a> 
		<a
			href="listFile" class="easyui-linkbutton" iconCls="icon-remove" plain="true" >下载</a>
			<a
			href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="downDoc()" >下载</a>
		<!-- 筛选工具栏 -->
		<div>
			<label>文件名称</label> <input id="title" class="easyui-textbox"
				label="Search:" labelPosition="left">&nbsp; <a href="#"
				class="easyui-linkbutton" iconCls="icon-search" plain="true"
				onclick="searchFilter()">筛选</a>
		</div>
	</div>
	<!-- 对话框，用来填写用户信息和提交，buttons指定按钮组 -->
	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post" enctype="multipart/form-data">  
            <div class="fitem">
				<label>文件标题:</label> <input name="title"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>文件描述:</label> <input name="remark"
					class="easyui-validatebox" required="true">
			</div>
			            <!-- <input type="submit" value="上 传"/>   -->
			<div class="fitem">
            <input type="file" name="file" class="easyui-validatebox" required="true" /><br /> 
            </div>
        </form>  
	</div>
	<div id="dlg2" class="easyui-dialog" 
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons2"> 	
		<form id="fm2"  method="post" >
		<!-- <div class="fitem">
				<label>文件ID:</label> <input name="id"
					class="easyui-validatebox" disabled />
			</div> -->
		            <div class="fitem">
				<label>文件标题:</label> <input name="title"
					class="easyui-validatebox" disabled />
			</div>
			<div class="fitem">
				<label>文件描述:</label> <input name="remark"
					class="easyui-validatebox" disabled />
			</div> 
			</div>
			</form>
	<!-- 提交和取消按钮 -->
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveDoc()">确定</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
	<div id="dlg-buttons2" class="dlg-buttons2">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveDoc2()">确定</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg2').dialog('close')">取消</a>
	</div>
</body>
</html>