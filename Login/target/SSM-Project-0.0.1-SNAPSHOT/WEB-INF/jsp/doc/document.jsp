<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
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
<style type="text/css">
#fm {
	margin: 0;
	padding: 10px 30px;
}

#fm2 {
	margin: 0;
	padding: 10px 30px;
}


.ftitle {
	font-size: 14px;
	font-weight: bold;
	color: blue;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}
</style>
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
            url = 'threeFile';
        }
        //修改选中行，打开对话框，指定url为update加上对应id
        function editDoc(){
                $('#dlg2').dialog('open').dialog('setTitle','文件下载');
                //将选中行的数据加载到表单
                $('#fm2').form('clear'); 
                url = 'listFile';
    
        }
        //提交表单到对应url
        function saveDoc(){
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
        //提交表单到对应url
        function downDoc(){
            $('#fm2').form('submit',{
                url: url,
                success: function(result){
                    //json字符串转对象，对应controller层的json对象
                    var res = eval('('+result+')');
                    //成功则关闭对话框并刷新数据
                    if (res.success){
                        $('#dlg2').dialog('close');
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
        
        function deleteDoc(){
            var row = $('#dg').datagrid('getSelected');
            if(row){
                //消息框
                $.messager.confirm('警告','确定删除这个文件吗？',function(r) {
                    //点击确认
                    if(r){
                        $.post('deleteDoc',{id:row.id},function(result){
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
            	title: title,
            });
        }

    </script>
</head>
<body>
	<h4>部门管理</h4>
	<!-- datagrid，通过url指定数据来源，toolbar指定头部工具栏，pagination显示分页工具栏-->
	<!-- 自动获取后台的数据，主动加载或者更新数据-->    
	<table id="dg" title="部门管理" class="easyui-datagrid"
		style="width: 100%; height: 400px;" url="getAllDocuments" toolbar="#toolbar"
		pagination="true" rownumbers="true" fitColumns="true"
		singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="50">ID</th>
				<th field="title" width="50">文件标题</th>
				<th field="filename" width="50">文件名称</th>
				<th field="remark" width="50">部门信息</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<!-- 增、改、删按钮 -->
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="addDoc()">新增</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editDoc()">下载</a> <a
			href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
			onclick="deleteDoc()">移除</a>
		<!-- 筛选工具栏 -->
		<div>
			<label>文件名</label> <input id="title" class="easyui-textbox"
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
				<label>文件名:</label> <input name="filename"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>文件描述:</label> <input name="remark"
					class="easyui-validatebox" required="true">
			</div>
            <input type="file" name="file" class="easyui-validatebox" required="true" /><br /> 
            <!-- <input type="submit" value="上 传"/>   -->
        </form>  
	</div>
	<div id="dlg2" class="easyui-dialog" 
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons1">  
		<form id="fm2" method="post" >
                      <!-- 遍历Map集合 -->  
            <c:forEach var="me" items="${fileNameMap}">  
            <c:url value="/downFile" var="downurl">  
                <c:param name="filename" value="${me.key}"></c:param>  
            </c:url>  
            ${me.value}<a href="${downurl}">下载</a>  
            <br/>  
        </c:forEach>  
        </form>  
	</div>
	
	<!-- 提交和取消按钮 -->
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveDoc()">确定</a>
		
	    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
	<!-- 提交和取消按钮 -->
	<div id="dlg-buttons1">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="downDoc()">确定</a>
		
	    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg2').dialog('close')">取消</a>
	</div>
</body>
</html>
