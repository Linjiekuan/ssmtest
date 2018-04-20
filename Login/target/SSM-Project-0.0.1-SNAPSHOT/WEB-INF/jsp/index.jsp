<%@page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>
<html >  
<head>  
    <meta charset="utf-8"/>  
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />  
    <title>Home</title>  
    <style>  
        #iframeTop{  
            width: 100%;  
            height: 70px;  
        }  
        #iframeLeft{  
            width: 15%;  
            height: 700px;  
            float: left;  
            bgclour:blue;
        }  
        #iframeContent{  
            width: 84%;  
            height: 700px;  
        }  
    </style>  
<!--     <script type="text/javascript"  src="/SSM-Project/js/index.js"></script> -->
    <script type="text/javascript">
    window.onload = function(){
        alert("欢迎进入本网页");
    } 
    function clickTest(){
    	alert("test");
    	var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","userjsp");
    }
    
    function user(){
    	var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","userjsp");
    }

    function dept(){
    	alert("test");
    }

    function job(){
    	var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","jobjsp");
    }

    function employee(){
    	var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","employeejsp");
    }

    function notice(){
    	var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","noticejsp");
    }

    function doc(){
    	var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","docjsp");
    }

    
    </script>
</head>
<body>  
<div>  
    <iframe id="iframeTop" name="iframeTop" frameborder="0" src="headerjsp"></iframe>  
    <iframe id="iframeLeft" name="iframeLeft" frameborder="0" src="navjsp">
    <ul>
		<button onclick="user()">用户管理</button>
		<button onclick="dept()">部门管理</button>
		<button onclick="job()">职位管理</button>
		<button onclick="employee()">员工管理</button>
		<button onclick="notice()">公告管理</button>
		<button onclick="doc()">文件管理</button>
	</ul>
    </iframe>  
    <iframe id="iframeContent" name="iframeContent" frameborder="0" src="mainjsp"></iframe>  
</div>  
<input type="button" value="点击" onclick="clickTest()"/>

</body>  
</html>
