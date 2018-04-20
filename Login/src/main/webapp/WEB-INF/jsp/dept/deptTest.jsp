<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理</title>
<link href="/SSM-Project/css/dept/dept.css" rel="stylesheet" />
<script type="text/javascript" src="/SSM-Project/js/jquery-1.8.0.min.js"></script>
</head>
<body onload="SetTableColor()">
	欢迎你：<%=request.getSession().getAttribute("username")%>
	<br>
	<%-- 当前用户：${pageScope.currentUser}<!-- (只能在同一个页面中使用) --> <br>
    当前用户：${requestScope.currentUser}-${roleName} 有重定向数据就访问不到<br>
    当前用户：${sessionScope.currentUser}-${roleName} 可以使用<br> --%>
	<hr>
	<div>
		<a href="#" id="example"> 添加用户</a>
	</div>
	<br />
	<br />
	<c:if test="${empty requestScope.pagemsg}">
        没有任何用户信息！
    </c:if>
	<c:if test="${!empty requestScope.pagemsg}">
		<table id="tbl"  border="1" cellpadding="10" cellspacing="0" class="table1">
			<thead>
				<tr>
					<td>ID</td>
					<td>部门名</td>
					<td>部门描述</td>
					<td>修改操作</td>
					<td>删除操作</td>
				</tr>
			</thead>
			<c:forEach items="${requestScope.pagemsg.lists}" var="u">
				<tr onmouseover="style.backgroundColor='#C86F70'"  onmouseout="SetTableColor()">
					<th>${u.id }</th>
					<th>${u.name }</th>
					<th>${u.remark }</th>
					<th><a href="edit?id=${u.id}">Edit</a></th>
					<th><a href="deleteDept?${u.id }"
						onclick="return deleteDept()">Delete</a></th>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<table border="0" cellspacing="0" cellpadding="0" width="900px">
		<tr>
			<td class="td2">
				<!-- requestScope为el表达式的隐含对象 --> <span>第${requestScope.pagemsg.currPage }/
					${requestScope.pagemsg.totalPage}页</span>&nbsp;&nbsp; <span>总记录数：${requestScope.pagemsg.totalCount }&nbsp;&nbsp;每页显示:${requestScope.pagemsg.pageSize}</span>&nbsp;&nbsp;
				<span> <c:if test="${requestScope.pagemsg.currPage != 1}">
						<!-- 可以使用session的方法，把currentPage存储在session里面，再传递给controller层里面 -->
						<a href="maindept?currentPage=1">[首页]</a>&nbsp;&nbsp;
           <a
							href="maindept?currentPage=${requestScope.pagemsg.currPage-1}">[上一页]</a>&nbsp;&nbsp;
       </c:if> <c:if
						test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">
						<a href="maindept?currentPage=${requestScope.pagemsg.currPage+1}">[下一页]</a>&nbsp;&nbsp;
           <a
							href="maindept?currentPage=${requestScope.pagemsg.totalPage}">[尾页]</a>&nbsp;&nbsp;
       </c:if>
			</span>
			</td>
		</tr>
	</table>
	<div id="LoginBox">
		<form  method="post" name="form1" id="form_login" action="addDept">
		<div class="row1">
			部门窗口<a href="javascript:void(0)" title="关闭窗口" class="close_btn"
				id="closeBtn">×</a>
		</div>
		<div class="row">
			部门名称: <span class="inputBox"> <input type="text" class="form-control" 
			name="name" id="name" placeholder="名称" autocomplete="off">
			</span><a href="javascript:void(0)" title="提示" class="warning" id="warn">*</a>
		</div>
		<div class="row">
			部门描述: <span class="inputBox"> <input type="text" class="form-control"  
			name="remark" id="remark" placeholder="描述" autocomplete="off">
			</span><a href="javascript:void(0)" title="提示" class="warning" id="warn2">*</a>
		</div>
		<br/><br/>
		<div class="form-group">
			<button type="submit" id="loginbtn"
				onclick="return addDept()">添加</button>
		</from>
	</div>
	<script type="text/javascript" src="/SSM-Project/js/dept/dept.js"></script>
</body>
</html>