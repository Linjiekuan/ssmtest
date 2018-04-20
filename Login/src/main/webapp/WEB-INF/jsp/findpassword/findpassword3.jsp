<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>人事管理系统找回密码</title>
<link type="text/css" href="/SSM-Project/css/findpassword/findpassword.css" rel="stylesheet" />
<script type="text/javascript" src="/SSM-Project/js/jquery-1.8.0.min.js"></script> <!--  //当要使用jquery时，需要提前把文件引入 -->
<script type="text/javascript"
	src="http://www.jeasyui.net/Public/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript"
	src="/SSM-Project/js/findpassword/findpassword.js"></script>  <!-- 这里是我写的js，用来负责整个找回密码的js，需要修改路径 -->

<script type="text/javascript">

</script>
</head>

 <body>

  	<div class="content">
		<div class="web-width">
			<div class="for-liucheng">
				<div class="liulist for-cur"></div>
				<div class="liulist for-cur"></div>
				<div class="liulist"></div>
				<div class="liutextbox">
					<div class="liutext for-cur">
						<em>1</em><br />
						<strong>验证身份</strong>
					</div>
					<div class="liutext for-cur">
						<em>2</em><br />
						<strong>设置新密码</strong>
					</div>
					<div class="liutext">
						<em>3</em><br />
						<strong>完成</strong>
					</div>
				</div>
			</div>
     <form class="forget-pwd" action="findpassword3" method="post" name="findpassword3" id="findpassword3">
       <dl>
        <dt>新密码：</dt>
        <dd><input type="password" id="password" name="password"/></dd>
       </dl> 
       <dl>
        <dt>确认密码：</dt>
        <dd><input type="password" id="qpassword" name="qpassword"/></dd>
       </dl> 
       <br/>
     <div class="subtijiao">
					<button id="password3" type="submit" onclick="return findpassword3()"> 提交</button>
				</div>
      </form>
   </div>
  </div>
</body> 


</html>
