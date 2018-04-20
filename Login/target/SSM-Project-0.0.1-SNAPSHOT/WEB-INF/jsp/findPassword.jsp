<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码</title>
<script type="text/javascript">
function passwordEmail(){
	return true;
}
</script>
</head>
<body>
<!-- 	<from method="post" name="findEmail" id="findEmail" action="passwordEmail">
 <input type="email" name="email"
			id="email" placeholder="请输入你的注册邮箱" ></input>
	<button >发送邮件</button>
	</from>
	 -->
	<div id="LoginBox1">
		<form  method="post" name="form11" id="form_login1" action="passwordEmail">
		<div class="row">
		 <input type="email" class="form-control1"  
			name="email" id="email" placeholder="请输入注册的邮箱" autocomplete="off">
		</div>
		<div class="form-group">
			<button type="submit" id="loginbtn1"
				onclick="return passwordEmail()">发送邮件</button>
		</div>
		</from>
	</div>
</body>
</html>