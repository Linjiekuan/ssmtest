<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理</title>
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
        function addEmployee(){
            $('#dlg').dialog('open').dialog('setTitle','添加员工');
            $('#fm').form('clear');
            url = 'addEmployee';
        }
        //修改选中行，打开对话框，指定url为update加上对应id
        function editEmployee(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('setTitle','员工信息修改');
                //将选中行的数据加载到表单
                $('#fm').form('load',row);
                url = 'updateEmployee/' + row.id;
            }
        }
        //提交表单到对应url
        function saveEmployee(){
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
        function deleteEmployee(){
            var row = $('#dg').datagrid('getSelected');
            if(row){
                //消息框
                $.messager.confirm('警告','确定删除这个用户吗？',function(r){
                    //点击确认
                    if(r){
                        $.post('deleteEmployee',{id:row.id},function(result){
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
<body>
	<!-- datagrid，通过url指定数据来源，toolbar指定头部工具栏，pagination显示分页工具栏-->
	<!-- 自动获取后台的数据，主动加载或者更新数据-->    <!-- fitColumns为"true"则是没有水平滚动，为"false"则有水平滚动 -->
	<table id="dg" fit="true" title="员工管理" class="easyui-datagrid"
		style="width: 800px; height: 600px;" url="getEmployees" toolbar="#toolbar"
		pagination="true" rownumbers="true" fitColumns="false"  
		singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="5%">员工ID</th>
				<th field="name" width="15%">员工姓名</th>
				<th field="phone" width="20%">手机号码</th>
				<th field="qq_num" width="20%">QQ号码</th>
				<th field="email" width="20%">邮箱</th>
				<th field="deptName" width="20%">部门</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<!-- 增、改、删按钮 -->
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="addEmployee()">新增</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editEmployee()">修改</a> <a
			href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
			onclick="deleteEmployee()">移除</a>
		<!-- 筛选工具栏 -->
		<div>
			<label>员工名</label> <input id="name" class="easyui-textbox"
				label="Search:" labelPosition="left">&nbsp; <a href="#"
				class="easyui-linkbutton" iconCls="icon-search" plain="true"
				onclick="searchFilter()">筛选</a>
		</div>
	</div>
	<!-- 对话框，用来填写用户信息和提交，buttons指定按钮组 -->
	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">信息填写</div>
		<form id="fm" method="post">
			<div class="fitem">
				<label>职员姓名:</label> <input name="name"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>手机号码:</label> <input name="phone"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>邮箱:</label> <input name="email"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>QQ号码:</label> <input name="qq_num"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>部门:</label> 
				<select name="deptName" class="easyui-combobox" required="true">
				  <option value="0">--选择部门--</option>
				  <c:forEach items="${listDept}"  var="dept">
				  <option value="${dept.name}"> ${dept.name}</option>
				  </c:forEach>
				</select>
			</div>
			<!-- <div class="fitem">
				<label>职位ID:</label> <input name="job_id"
					class="easyui-validatebox" required="true">
			</div> -->
		</form>
	</div>
	<!-- 提交和取消按钮 -->
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveEmployee()">Save</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
	</div>
</body>
</html>
