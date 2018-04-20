<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<head>
<meta charset="UTF-8">
<title>主页面</title>
<link href="/SSM-Project/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="/SSM-Project/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet" />
<link href="/SSM-Project/css/header.css" rel="stylesheet" />
<link href="/SSM-Project/css/index1.css" rel="stylesheet" />
</head>
<body>
		<div class="col-md-12"><!-- container -->
			<jsp:include page="header.jsp"></jsp:include>
			<nav class="navbar navbar-inverse">
				<div id="navbar-menu" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li><a href="usermain">用户页面</a></li>
						<li><a href="deptmain">部门页面</a></li>
						<li><a href="jobmain">职位页面</a></li>
						<li><a href="employeemain">员工页面</a></li>
						<li><a href="noticemain">公告页面</a></li>
						<li><a href="docmain">文件页面</a></li>
						</ul>
				</div>
			</nav>
			<!--  <div class="col-md-3">
          <h2>页面导航</h2>
          <ul class="nav nav-tabs nav-stacked">
        <li><a href='#'>Link 1</a></li>
        <li><a href='#'>Link 2</a></li>
        <li><a href='#'>Link 3</a></li>
        <li><button onclick="user()">用户管理</button></li>
		<li><button onclick="dept()">部门管理</button></li>
		<li><button onclick="job()">职位管理</button></li>
		<li><button onclick="employee()">员工管理</button></li>
		<li><button onclick="notice()">公告管理</button></li>
		<li><button onclick="doc()">文件管理</button></li>
    </ul> -->
		</div>
	<div class="col-md-12">
	<iframe id="shopStep" name="shopStep" src="userjsp" frameborder="0" ></iframe> 
		 <!-- <iframe id="external-frame" name="external-frame" frameborder="0" src="userjsp"></iframe>  -->
		<%-- <%@include file="user/user.jsp"%> --%>
	</div>  
	<script type="text/javascript"
		src="/SSM-Project/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="/SSM-Project/js/index1.js"></script>
	<script type="text/javascript"
		src="/SSM-Project/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>