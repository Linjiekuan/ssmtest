<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="Author" contect="http://www.webqin.net">
	<title>忘记密码</title>
	<link rel="shortcut icon" href="images/favicon.ico" />
	<link type="text/css"
		href="/SSM-Project/css/findpassword/findpassword.css" rel="stylesheet" />
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.6.min.js"></script>
</head>
<body>
	<div class="content">
		<div class="web-width">
			<div class="for-liucheng">
				<div class="liulist for-cur"></div>
				<div class="liulist for-cur"></div>
				<div class="liulist for-cur"></div>
				<div class="liutextbox">
					<div class="liutext for-cur">
						<em>1</em><br /> <strong>验证身份</strong>
					</div>
					<div class="liutext for-cur">
						<em>2</em><br /> <strong>设置新密码</strong>
					</div>
					<div class="liutext for-cur">
						<em>3</em><br /> <strong>完成</strong>
					</div>
				</div>
			</div>
		</div>
		<!--for-liucheng/-->
		<div class="successs">
			<h3>恭喜您，修改成功！</h3>
			<span id=regester>3</span>秒后自动跳转到登陆页面
			</h4>
			<script type="text/javascript"
				src="/SSM-Project/js/findpassword/findpassword.js"></script><!-- 这里是我写的js，用来负责整个找回密码的js，需要修改路径 -->
			<script type="text/javascript">
				countDown(3, 'registerSuccess')
			</script>
		</div>
	</div>
	<!--web-width/-->
	</div>
	<!--content/-->

</body>
</html>
