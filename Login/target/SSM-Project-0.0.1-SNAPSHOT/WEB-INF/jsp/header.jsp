<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="/SSM-Project/js/header.js"></script>
<link href="/SSM-Project/css/header.css" rel="stylesheet" />
<link href="/SSM-Project/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="/SSM-Project/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet" />
<link href="/SSM-Project/css/header.css" rel="stylesheet" />
<link href="/SSM-Project/css/index1.css" rel="stylesheet" />
<div class="col-md-12">
	<div class="headerDiv">
		<div class="div-inline">
			<img src="/SSM-Project/image/ldap_logo.png" alt="华润logo" />
		</div>
		<div class="div-inline"
			style="float: right; display: fixed; right: 120px;">
			<h3><%=request.getSession().getAttribute("username")%>
				| <a href="loginjsp">退出</a>
			</h3>
			<div class="test-box">
				<a href="Mailto:597690851@qq.com"> <img
					src="/SSM-Project/image/email.png" title="点击发送邮件"
					style="width: 20px; height: 20px"></img>
				</a> <img src="/SSM-Project/image/phone.png" title="电话联系：15917902177"
					style="width: 17.6px; height: 17。6px"></img>
			</div>
		</div>

	</div>

	<div class="bgcolor">
		<!-- <nav class="navbar navbar-inverse" > -->
		<div id="navbar-menu" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="usermain">用户页面</a></li>
				<li><a href="deptmain">部门页面</a></li>
				<li><a href="jobmain">职位页面</a></li>
				<li><a href="employeemain">员工页面</a></li>
				<li><a href="noticemain">公告页面</a></li>
				<li><a href="docmain">文件页面</a></li>
		</div>
		<!-- </nav> -->
	</div>