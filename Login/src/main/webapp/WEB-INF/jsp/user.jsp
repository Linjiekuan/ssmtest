<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%
    pageContext.setAttribute("path", request.getContextPath());
%>   
<!DOCTYPE html>
<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/table_bootstrap.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:03 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>系统菜单</title>
   
     <link href="/SSM-Project/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/SSM-Project/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/SSM-Project/hplus/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="/SSM-Project/hplus/css/animate.min.css" rel="stylesheet">
    <link href="/SSM-Project/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        
            
        </div>

                    <div class="col-sm-12">
                        <!-- Example Events -->
                        <div class="example-wrap">
                           
                            <div class="example">
                               
                                <div class="btn-group hidden-xs" id="exampleTableEventsToolbar" role="group">
                                    <button type="button" class="btn btn-outline btn-default">
                                        <a class="glyphicon glyphicon-plus" aria-hidden="true"  href="${path}/user/addUser"></a>
                                    </button>
                                    <button type="button" class="btn btn-outline btn-default">
                                        <i class="glyphicon glyphicon-repeat" aria-hidden="true" onclick="javascript:window.location.reload()"></i>
                                    </button>
                                    
                                </div>
                                
                               <%--  ${pagemsg } --%>
                                <table id="exampleTableEvents" data-height="400" data-mobile-responsive="true">
                                    <thead>
                                         <tr>
                                            <th data-field="state" data-checkbox="true"></th>
                                            <th data-field="id">ID</th>
                                            <th data-field="name">用户名</th>
                                            <th data-field="parentid">系统等级</th>
                                            <th data-field="iconCls">姓名</th>
                                            <th data-field="url">邮箱</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${pageInfo.list }" var="user">
                                    		<tr>
                                   			    <td></td>
                                    			<td>${user.id}</td>
						                        <td>${user.username}</td>
						                        <td>${user.status}</td>
						                        <td>${user.loginname}</td>
						                        <td>${user.email}</td>
						                        <td>
                                <a type="button"  href="${path}/user/getUser?id=${user.id}" class="btn btn-info btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                    编辑</a>
                                <a type="button"  href="${path}/user/delUser?id=${user.id}" class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true" ></span>
                                    删除</a>
                            </td>
                                    		</tr>
                                    	</c:forEach>
                                    </tbody>
                                 
                                </table>
                            </div>
                        </div>
                       
                        <!-- End Example Events -->
                    </div>
                
    <script src="/SSM-Project/hplus/js/jquery.min.js?v=2.1.4"></script>
    <script src="/SSM-Project/hplus/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="/SSM-Project/hplus/js/content.min.js?v=1.0.0"></script>
    <script src="/SSM-Project/hplus/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="/SSM-Project/hplus/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="/SSM-Project/hplus/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
    <script src="/SSM-Project/hplus/js/demo/bootstrap-table-demo.min.js"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/table_bootstrap.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:06 GMT -->
</html>
