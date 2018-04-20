<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户页面</title>
<link href="/SSM-Project/css/allmain.css" rel="stylesheet"/>
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.net/Public/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.net/Public/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.net/Public/js/easyui/demo/demo.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript"
	src="http://www.jeasyui.net/Public/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="datagrid-filter.js"></script>
<script type="text/javascript">
	var url;
	//新增用户，打开对话框，指定url为add
	function addUser() {
		$('#dlg').dialog('open').dialog('setTitle', '用户添加');
		$('#fm').form('clear');
		url = 'adduser';
	}
	//修改选中行，打开对话框，指定url为update加上对应id
	function editUser() {
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', '用户信息修改');
			//将选中行的数据加载到表单
			$('#fm').form('load', row);
			url = 'update/' + row.id;
		}
	}
	//提交表单到对应url
	function saveUser() {
		$('#fm').form('submit', {
			url : url,
			success : function(result) {
				//json字符串转对象，对应controller层的json对象
				var res = eval('(' + result + ')');
				//成功则关闭对话框并刷新数据
				if (res.success) {
					$('#dlg').dialog('close');
					$('#dg').datagrid('reload');
				}
				//提示
				$.messager.show({
					title : '提示',
					msg : res.msg
				});
			}
		});
	}
	function deleteUser() {
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			//消息框
			$.messager.confirm('Confirm', '确认删除这个用户吗?', function(r) {
				//点击确认
				if (r) {
					$.post('deleteuser', {
						id : row.id
					}, function(result) { //'deleteuser'表示url为：deleteuser
						var res = eval('(' + result + ')');
						if (res.success) {
							//重新加载该页数据
							$('#dg').datagrid('reload');
						}
						$.messager.show({
							title : '提示',
							msg : res.msg
						});
					});
				}
			});
		}
	}
	//按条件筛选
	function searchFilter() {
		var username = $('#username').val();
		//传递筛选条件重新加载
		$('#dg').datagrid('load', {
			username : username,
		});
	}
</script>
</head>
<div class="easyui-layout" fit="true">
	<!-- datagrid，通过url指定数据来源，toolbar指定头部工具栏，pagination显示分页工具栏-->
	<!-- 自动获取后台的数据，主动加载或者更新数据-->
	<table id="dg" fit="true" title="用户管理" class="easyui-datagrid"
		 url="getUsers" toolbar="#toolbar"
		pagination="true" rownumbers="true" fitColumns="true"
		options="onRowContextMenu:onRowContextMenu" singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="15%" align="center">账号ID</th>
				<th field="username" width="25%" align="center">登陆名</th>
				<th field="email" width="35%" align="center">邮箱</th>
				<th field="status" width="15%" align="center">系统等级</th>
				<!-- <th field="date" width="40%" align="center">账号注册时间</th> -->
			</tr>
		</thead>
	</table>

	<div id="toolbar">
		<!-- 增、改、删按钮 -->
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="addUser()">新增</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editUser()">修改</a> <a
			href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
			onclick="deleteUser()">移除</a>
		<!-- 筛选工具栏 -->
		<div>
			<label>登陆名</label> <input id="username" class="easyui-textbox"
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
				<label>用户密码:</label> <input name="password"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>登陆名:</label> <input name="username"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>邮箱:</label> <input name="email"
					class="easyui-validatebox" required="true">
			</div>
		</form>
	</div>
	<!-- 提交和取消按钮 -->
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveUser()">Save</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
	</div>
</div>
</html>
