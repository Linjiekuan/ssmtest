<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta
	content="initial-scale=1.0,user-scalable=no,maximum-scale=1,width=device-width"
	name="viewport" />
<meta content="initial-scale=1.0,user-scalable=no,maximum-scale=1"
	media="(device-height: 568px)" name="viewport">
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="/SSM-Project/css/login.css" rel="stylesheet" />
<title>登陆页面</title>
</head>
<body>
	<div class="form_login">
		<br />
		<h2>人事管理系统登陆</h2>
	</div>
	<form  method="post" name="form1" id="form_login" action="login">
		<div class="form-group">
			<i class="fa fa-user"></i> <input type="text" class="form-control" 
			name="username" id="username" placeholder="账号/邮箱" autocomplete="off" >
		</div>
		<div class="form-group">
			<i class="fa fa-key"></i> <input type="password" class="form-control"  
			name="password" id="password" placeholder="密码" autocomplete="off">
		</div>
		<div class="form-group">
			<i class=""></i> <input type="text" class="form-control1" 
			name="yanzheng" id="yanzheng" placeholder="验证码" autocomplete="off" onblur="check();" />
			<h1> <label class="yanzhengma" id="yanzhengma" onclick="yanzhengma()" >  </label></h1>
		</div>
		<div class="a-group"> <a href="findPassword">忘记密码？</a> </div>

		<!-- 登陆按钮 -->
		<div class="form-group">
			<button type="submit" class="btn btn-primary btn-block btn-login"
				onclick="return login()">登录</button>
	</form>
	<!-- 注册按钮 -->
	</div>
	<form method="post" name="form2" id="form_res" action="registerpage">
		<div class="form-group">
			<button type="submit" class="btn btn-primary btn-block btn-login">
				注册</button>
	</form>
	 <dd>
  <p>© 2017-2018 LJK 版权所有</p>
 </dd>
	<div class="hovertree_form_footer"></div>
	</div>
		<script type="text/javascript" src="/SSM-Project/js/md5.js"></script>
	<script type="text/javascript" src="/SSM-Project/js/login.js"></script>
	<script type="text/javascript" src="/SSM-Project/js/jquery-1.8.0.min.js"></script>
</body>
</html>