<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>注册成功页面</title>
</head>
<body>
<h4>你已经成功注册，
<span id=regester>3</span>秒后自动跳转到登陆页面</h4>
<script type="text/javascript" src="/SSM-Project/js/register.js"></script>
<script type="text/javascript">
countDown(3,'registerSuccess')
</script>
</body>
</html>
