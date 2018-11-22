<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>  
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
</head>
<body>
    <h1>添加用户</h1>
 <div class="ibox-content">
                        <form class="form-horizontal m-t" id="commentForm" action="">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">姓名：</label>
                                <div style="height:33px; width:370px;" class="col-sm-8">
                                    <input id="cname" name="username" minlength="2" type="text" class="form-control" required="" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">账号：</label>
                                <div style="height:33px; width:370px;" class="col-sm-8">
                                    <input id="caccount" name="loginname" minlength="2" type="text" class="form-control" required="" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">E-mail：</label>
                                <div style="height:33px; width:370px;" class="col-sm-8">
                                    <input id="cemail" type="email" class="form-control" name="email" required="" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">系统等级：</label>
                                <div style="height:33px; width:370px;" class="col-sm-8">
                                    <input id="curl" type="text" class="form-control" name="status">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">密码：</label>
                                <div style="height:33px; width:370px;" class="col-sm-8">
                                   <input id="cpassword" type="text" class="form-control" name="password">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary" type="submit" onclick="addUser()">提交</button>
                                    <input type="button" class="btn btn-primary" value="刷新" onclick="javascript:window.location.reload()" />
                                    <input type="button" class="btn btn-primary" value="返回" onclick="back()" />
                                </div>
                            </div>
                        </form>
                    </div>

    <script type="text/javascript">
        function addUser() {
            var form = document.forms[0];
            form.action = "<%=basePath %>user/addUser";
            form.method = "post";
            form.submit();
        }
        function back() {
        	window.location.href="/UserManager/user/userInfo";
        }
    </script>
    <script src="/SSM-Project/hplus/js/jquery.min.js?v=2.1.4"></script>
    <script src="/SSM-Project/hplus/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="/SSM-Project/hplus/js/content.min.js?v=1.0.0"></script>
    <script src="/SSM-Project/hplus/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="/SSM-Project/hplus/js/plugins/validate/messages_zh.min.js"></script>
    <script src="/SSM-Project/hplus/js/demo/form-validate-demo.min.js"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>
</html>