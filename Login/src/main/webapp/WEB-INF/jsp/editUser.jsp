<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>  
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>添加用户</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="/SSM-Project/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/SSM-Project/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/SSM-Project/hplus/css/animate.min.css" rel="stylesheet">
    <link href="/SSM-Project/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
<head>
<title>编辑用户</title>

<script type="text/javascript">
    function updateUser() {
        var form = document.forms[0];
        form.action = "<%=basePath %>user/updateUser";
        form.method = "post";
        form.submit();
    }
    function back() {
    	window.location.href="/UserManager/user/userInfo";
    }
</script>

</head>
<body>
    <h1>编辑用户</h1>
    <div class="ibox-content">
             <form class="form-horizontal m-t" id="commentForm" name="userForm" action="">
             <input type="hidden" name="id" value="${user.id }" /> 
                            <div class="form-group">
                                <label class="col-sm-3 control-label">姓名：</label>
                                <div style="height:33px; width:370px;" class="col-sm-8">
                                    <input id="cname" name="loginname" value="${user.loginname }" minlength="2" type="text" class="form-control" required="" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">账号：</label>
                                <div style="height:33px; width:370px;" class="col-sm-8">
                                    <input id="caccount" name="username" value="${user.username }" minlength="2" type="text" class="form-control" required="" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">E-mail：</label>
                                <div style="height:33px; width:370px;" class="col-sm-8">
                                    <input id="cemail" type="email" class="form-control" name="email"   value="${user.email }" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">系统等级：</label>
                                <div style="height:33px; width:370px;" class="col-sm-8">
                                    <input id="curl" type="text" class="form-control" name="status" value="${user.status }">
                                </div>
                            </div>
<!--                             <div class="form-group">
                                <label class="col-sm-3 control-label">密码：</label>
                                <div style="height:33px; width:370px;" class="col-sm-8">
                                  <input id="cpassword" type="text" class="form-control" name="password">                                </div>
                            </div> -->
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary"  onclick="updateUser()">提交</button>
                                
                                <input type="button" class="btn btn-primary" value="编辑" onclick="updateUser()" />
                                <input type="button" class="btn btn-primary" value="刷新" onclick="javascript:window.location.reload()" />
                                <input type="button" class="btn btn-primary" value="返回" onclick="back()" />
                                </div>
                            </div>
                        </form>
                    </div>


</body>
</html>