<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="/SSM-Project/js/index.js"></script>
<!-- <script type="text/javascript">
    window.onload = function(){
        alert("欢迎进入本网页");
    } 
    function clickTest(){
    	alert("test");
    }
    
    function user(){
    	var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","/user");
    }

    function dept(){
    	/* var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","/dept"); */
    	alert("test");
    }

    function job(){
    	var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","/job");
    }

    function employee(){
    	var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","/employee");
    }

    function notice(){
    	var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","/notice");
    }

    function doc(){
    	var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","/doc");
    }

    
    </script> -->
<style>
li {
	list-style-type: none;
}
</style>
<nav>
	<ul>
		<li><button onclick="user()">用户管理</button></li>
		<li><button onclick="dept()">部门管理</button></li>
		<li><button onclick="job()">职位管理</button></li>
		<li><button onclick="employee()">员工管理</button></li>
		<li><button onclick="notice()">公告管理</button></li>
		<li><button onclick="doc()">文件管理</button></li>
	</ul>
	<nav>