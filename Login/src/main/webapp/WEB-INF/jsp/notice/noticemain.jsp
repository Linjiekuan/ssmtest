<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<head>
    <meta charset="UTF-8">
    <title>index</title>
    <link href="/SSM-Project/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/SSM-Project/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>
    <link href="/SSM-Project/css/header.css" rel="stylesheet"/>

</head>
<body>
    <div class="col-md-12">
     <jsp:include page="../header.jsp"></jsp:include>
           <iframe  class="col-md-12" style= " height:410px; margin:0;padding:0;border:0;” id="iframeContent" name="iframeContent" frameborder="0" src="noticejsp"></iframe> 
    </div>
    <script type="text/javascript" src="/SSM-Project/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="/SSM-Project/js/index1.js"></script>
    <script type="text/javascript" src="/SSM-Project/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>


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
    </ul>      
        </div> -->