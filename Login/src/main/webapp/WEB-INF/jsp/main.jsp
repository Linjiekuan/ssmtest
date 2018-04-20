<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body >
登陆成功，
<%=request.getSession().getAttribute("username")%>
<form method="post"  name="form_doc_add" id="form_doc"  action="doc">
<input type="submit" value="文件"> 
</form>
<form method="post"  name="employee" id="employee"  action="employee">
<input type="submit" value="职员"> 
</form>
<form method="post"  name="job" id="job"  action="job">
<input type="submit" value="职位"> 
</form>
<form method="post"  name="notice" id="notice"  action="notice">
<input type="submit" value="公告"> 
</form>
<form method="post"  name="dept" id="dept"  action="dept">
<input type="submit" value="部门"> 
</form>
<form method="post"  name=""user"" id=""user""  action="user">
<input type="submit" value="用户"> 
</form>
<form method="post"  name=""email"" id=""email""  action="email">
<input type="submit" value="email测试"> 
</form>
<form method="post"  name=""user"" id=""user""  action="mainindex">
<input type="submit" value="测试主页面"> 
<form method="post"  name=""user"" id=""user""  action="mainindex1">
<input type="submit" value="测试主页面1"> 
</form>
<!--  <img src="/SSM-Project/img/user.png"/>  使用这种方法可以引进去静态文件-->
</body>
</html>
