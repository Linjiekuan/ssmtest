<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="initial-scale=1.0,user-scalable=no,maximum-scale=1,width=device-width" name="viewport" />
<meta content="initial-scale=1.0,user-scalable=no,maximum-scale=1" media="(device-height: 568px)" name="viewport">
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="/SSM-Project/css/register.css" rel="stylesheet" />
<script type="text/javascript" src="/SSM-Project/js/jquery-1.8.0.min.js"></script> <!--  //当要使用jquery时，需要提前把文件引入 -->
<title>注册页面</title>
</head>
<body>
<div class="form_login">
<br/>
请注册您的信息<br/>
</div>
<form method="post"  name="form3" id="form_register"  action="register">
<div class="form-group">
<i class="fa fa-user"></i>
<input type="text" class="form-control" name="username" id="username" placeholder="登录账号" 
autocomplete="off" onBlur="addAjax()">
<h4 id="usernametext" style="color:red;display:inline;"></h4>
</div>
<div class="form-group">
<i class="fa fa-key"></i>
<input type="password" class="form-control" name="password" id="password" placeholder="登录密码" autocomplete="off">
</div>
<div class="form-group">
<i class="fa fa-email"></i>
<input type="email" class="form-control"  name="email" id="email" placeholder="邮箱" autocomplete="off">
<h4 id="emailtext" style="color:red;display:inline;"></h4>
</div>
<div id="displayemail" class="form-group ">
 <input type="text" class="form-control1" 
			name="emailyanzheng" id="emailyanzheng" placeholder="邮箱验证码" 
			autocomplete="off" />
			<h1> <label class="postemail" id="postemail" onclick="postemail()" >发送验证码 </label></h1>
</div>
<!-- 登陆按钮 -->
<div class="form-group">
<button type="submit" class="btn btn-primary btn-block btn-login" onclick="return register()">注册</button></div>
</form>
<!-- 返回登陆页面按钮 -->
	</div>
	<form method="post" name="form2" id="form_res" action="registerSuccess">
		<div class="form-group">
			<button type="submit" class="btn btn-primary btn-block btn-login">
				返回登陆</button>
				</div>
	</form>
<div class="hovertree_form_footer"> </div>
</form>
	<script type="text/javascript" src="/SSM-Project/js/register.js"></script>
</body>
</html>