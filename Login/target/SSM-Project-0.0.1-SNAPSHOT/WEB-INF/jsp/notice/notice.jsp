<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告管理页面</title>
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
	//新增用户，打开对话框，指定url为addjob
	function addNotice() {
		$('#dlg').dialog('open').dialog('setTitle', '添加公告');
		$('#fm').form('clear');
		url = 'addNotice';
	}
	//修改选中行，打开对话框，指定url为update加上对应id
	function editNotice() {
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', '公告修改');
			//将选中行的数据加载到表单
			$('#fm').form('load', row);
			url = 'updateNotice/' + row.id;
		}
	}
	//提交表单到对应url
	function saveNotice() {
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

	function deleteNotice() {
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			//消息框
			$.messager.confirm('警告', '确定删除这个公告吗？', function(r) {
				//点击确认
				if (r) {
					$.post('deleteNotice', {
						id : row.id,noticeUsername:row.noticeUsername
					}, function(result) {
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
		var title = $('#title').val();
		//传递筛选条件重新加载
		$('#dg').datagrid('load', {
			title : title,
		});
	}
</script>
</head>
<div class="easyui-layout" fit="true">
	<!-- datagrid，通过url指定数据来源，toolbar指定头部工具栏，pagination显示分页工具栏-->
	<!-- 自动获取后台的数据，主动加载或者更新数据-->
	<table id="dg" fit="true" title="公告管理" class="easyui-datagrid"
		style="width: 800px; height: 400px;" url="getNotices"
		toolbar="#toolbar" pagination="true" rownumbers="true"
		fitColumns="false" singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="5%">ID</th>
				<th field="title" width="30%">标题</th>
				<th field="content" width="50%">内容</th>
				<th field="noticeUsername" width="15%">发布人</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<!-- 增、改、删按钮 -->
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="addNotice()">新增
			</a> 
			<a href="#" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editNotice()">修改
			</a> 
			<a
			href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
			onclick="deleteNotice()">移除
			</a>
		<!-- 筛选工具栏 -->
		<div>
			<label>公告名称</label> <input id="title" class="easyui-textbox"
				label="Search:" labelPosition="left">&nbsp; <a href="#"
				class="easyui-linkbutton" iconCls="icon-search" plain="true"
				onclick="searchFilter()">筛选</a>
		</div>
	</div>
	<!-- 对话框，用来填写用户信息和提交，buttons指定按钮组 -->
	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">公告填写</div>
		<form id="fm" method="post">
			<div class="fitem">
				<label>公告标题:</label> <input name="title" class="easyui-validatebox"
					required="true">
			</div>
			<div class="fitem">
				<label>公告内容:</label> <input name="content"
					class="easyui-validatebox" required="true">
			</div>
		</form>
	</div>
	<!-- 提交和取消按钮 -->
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveNotice()">确定</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
</div>
</html>
