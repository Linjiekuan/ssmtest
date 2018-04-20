<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理页面</title>
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
        function addDept(){
            $('#dlg').dialog('open').dialog('setTitle','添加部门');
            $('#fm').form('clear');
            url = 'addDept';
        }
        //修改选中行，打开对话框，指定url为update加上对应id
        function editDept(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('setTitle','部门信息修改');
                //将选中行的数据加载到表单
                $('#fm').form('load',row);
                url = 'updateDept/' + row.id;
            }
        }
        //提交表单到对应url ,应该是异步提交验证
        function saveDept(){
            $('#fm').form('submit',{
                url: url,
                success: function(result){
                    //json字符串转对象，对应controller层的json对象
                    var res = eval('('+result+')');
                    //成功则关闭对话框并刷新数据
                    if (res.success){
                        $('#dlg').dialog('close');
                        $('#dg').datagrid('reload');
                    } 
                    //提示
                    $.messager.show({
                        title: '提示',
                        msg: res.msg
                    });
                }
            });
        }
        
        function deleteDept(){
            var row = $('#dg').datagrid('getSelected');
            if(row){
                //消息框
                $.messager.confirm('警告','确定删除这个职位吗？',function(r) {
                    //点击确认
                    if(r){
                        $.post('deleteDept',{id:row.id},function(result){
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
            var name = $('#name').val();
            //传递筛选条件重新加载
            $('#dg').datagrid('load',{
            	name: name,
            });
        }

    </script>
</head>
<div class="easyui-layout" fit="true">
	<!-- datagrid，通过url指定数据来源，toolbar指定头部工具栏，pagination显示分页工具栏-->
	<!-- 自动获取后台的数据，主动加载或者更新数据-->    
	<table id="dg" fit="true" title="部门管理" class="easyui-datagrid"
		url="getDepts" toolbar="#toolbar"
		pagination="true" rownumbers="true" fitColumns="true"
		options="onRowContextMenu:onRowContextMenu" singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="30%">部门ID</th>
				<th field="name" width="30%">部门名称</th>
				<th field="remark" width="40%">部门信息</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<!-- 增、改、删按钮 -->
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="addDept()">新增</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editDept()">修改</a> <a
			href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
			onclick="deleteDept()">移除</a>
		<!-- 筛选工具栏 -->
		<div>
			<label>职位名称</label> <input id="name" class="easyui-textbox"
				label="Search:" labelPosition="left">&nbsp; <a href="#"
				class="easyui-linkbutton" iconCls="icon-search" plain="true"
				onclick="searchFilter()">筛选</a>
		</div>
	</div>
	<!-- 对话框，用来填写用户信息和提交，buttons指定按钮组 -->
	<div id="dlg" class="easyui-dialog" closed="true"
		style="width: auto; height: auto; padding: 10px 20px;"
		buttons="#dlg-buttons">
		<div class="ftitle">信息填写</div>
		<form id="fm" method="post">
			<div class="fitem">
				<label>部门名称:</label> <input name="name"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>部门信息:</label> <input name="remark"
					class="easyui-validatebox" required="true">
			</div>
		</form>
	</div>
	<!-- 提交和取消按钮 -->
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveDept()">确定</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
</div>
</html>
