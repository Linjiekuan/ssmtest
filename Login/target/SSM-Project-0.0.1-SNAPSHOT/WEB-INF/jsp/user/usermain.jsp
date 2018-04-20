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
<body >
    <div class="col-md-12" >
     <jsp:include page="../header.jsp"></jsp:include>
      <iframe  class="col-md-12" style= "height:400px; margin:0;padding:0;border:0;” id="iframeContent" name="iframeContent" frameborder="0" src="userjsp"></iframe> 
</div>
    <script type="text/javascript" src="/SSM-Project/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="/SSM-Project/js/index1.js"></script>
    <script type="text/javascript" src="/SSM-Project/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>


<!-- <div class="bgcolor">
     <nav class="navbar navbar-inverse" >
    <div id="navbar-menu" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li ><a href="usermain">用户页面</a></li>
            <li><a href="deptmain">部门页面</a></li>
            <li><a href="jobmain">职位页面</a></li>
            <li ><a href="employeemain">员工页面</a></li>
            <li><a href="noticemain">公告页面</a></li>
            <li><a href="docmain">文件页面</a></li>        
       </div>
    </nav>
    </div> -->