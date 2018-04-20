<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="initial-scale=1.0,user-scalable=no,maximum-scale=1,width=device-width" name="viewport" />
<meta content="initial-scale=1.0,user-scalable=no,maximum-scale=1" media="(device-height: 568px)" name="viewport">
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<head>
<title>人事管理系统找回密码</title>
<link type="text/css" href="/SSM-Project/css/findpassword/findpassword.css" rel="stylesheet" />
<script type="text/javascript" src="/SSM-Project/js/jquery-1.8.0.min.js"></script> <!--  //当要使用jquery时，需要提前把文件引入 -->
<script type="text/javascript"
	src="http://www.jeasyui.net/Public/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript"
	src="/SSM-Project/js/findpassword/findpassword.js"></script>  <!-- 这里是我写的js，用来负责整个找回密码的js，需要修改路径 -->
</head>
<body>
<div class="content">
		<div class="web-width">
			<div class="for-liucheng">
				<div class="liulist for-cur"></div>
				<div class="liulist"></div>
				<div class="liulist"></div>
				<div class="liutextbox">
					<div class="liutext">
						<em>1</em><br />
						<strong>验证身份</strong>
					</div>
					<div class="liutext">
						<em>2</em><br />
						<strong>设置新密码</strong>
					</div>
					<div class="liutext">
						<em>3</em><br />
						<strong>完成</strong>
					</div>
				</div>
			</div>
			<!--for-liucheng/-->
			<form class="forget-pwd" action="findpassword1" method="post" name="findpassword1" id="findpassword1">
				<dl>
					<dt>注册邮箱：</dt>
					<dd><span>
						<input type="email" name="email" id="email" placeholder="邮箱" autocomplete="off"/>
                         <label class="postemail" id="postemail" onclick="postemail()" >发送验证码 </label>	
                        </span>
                        <br/><h4 id="emailtext" style="color:red;display:inline;"></h4>
					</dd>
				</dl>	
				<div></div>
				<br/><br/><br/>
				<dl>
					<dt>验证码：</dt>
					<dd>
						<input type="text" name="emailyanzheng" id="emailyanzheng" />
					</dd>
				</dl>
				<br/><br/>
				<div class="subtijiao">
					<button id="ver" type="submit"  >提交</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
