package com.ljk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.annotations.Param;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljk.service.UserService;
import com.ljk.yc.User;
import static com.ljk.yc.HrmConstants.PAGE_DEFAULT_SIZE;

//@Controller注解用于标示本类为web层控制组件
@Controller
public class UserController {
	// 自动注入业务层的userService类
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	/**
	 * 在用户管理页面添加用户时候的处理
	 */
	@RequestMapping(value = "/adduser")
	public String adduser(@Param("username") String username, @Param("password") String password,
			@Param("email") String email, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		User newuser = new User();
		newuser.setUserName(username);
		newuser.setPassword(password);
		newuser.setEmail(email);
		// userService.addUser(request.getParameter("username"),request.getParameter("password"),request.getParameter("loginname"));
		JSONObject result = new JSONObject(); // 更后面jsp页面的easyui框架的json对象相互映射
		try {
			userService.addUser(newuser);
			result.put("success", true);
			result.put("msg", "添加成功!");
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", "添加失败!");
			}
		// 写入响应
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(result.toString()); // 可以返回json信息给前端页面
		return null; // 直接是返回本页面，也就是不跳转页面，在本页面显示
	}

	@RequestMapping(value = "/getUsers")
	public String getAllUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 分页,easyui-datagrid会自动传递页码page和页长size
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int rows = request.getParameter("rows") == null ? PAGE_DEFAULT_SIZE
				: Integer.parseInt(request.getParameter("rows"));
		// 筛选条件
		String username = request.getParameter("username") == null ? "" : request.getParameter("username");
		String password = request.getParameter("email") == null ? "" : request.getParameter("email");
		// 调用服务
		List<User> users = userService.getAllUsers(page, rows, username, password);
		// 封装json数据,total存放数据总数,rows存放数据数组，以提供给easyui的datagrid
		JSONObject json = new JSONObject();
		// 筛选后的总数
		json.put("total", userService.getCount(username, password));
		JSONArray row = new JSONArray();
		for (User info : users) { // 设置json数组，把要在前端页面的显示的每一个user对象装进去
			JSONObject jo = new JSONObject();
			jo.put("id", info.getId());
			jo.put("username", info.getUserName());
			jo.put("email", info.getEmail());
			jo.put("status", info.getStatus());
			jo.put("date", info.getCreateDate());
			row.put(jo);
		}
		json.put("rows", row); // 把含有所有的显示的对象的数组row传递给前端页面
		System.out.println(json.toString());
		// 写入响应
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(json.toString());
		// 不跳转到别的jsp页面，所以写这样可以在本页面刷新
		return null;
	}

	@RequestMapping(value = "/update/{id}")
	public String updateUser(@PathVariable int id, // 用来获得请求url中的动态参数,在这里是为了获取ID
			@Param("username") String username, @Param("password") String password,
			@Param("email") String email, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String username1= (String) request.getSession().getAttribute("username");
		User newuser = new User();
		newuser.setId(id);
		/*也可以如同下面一样，直接从request里面获取参数
		 * newuser.setUserName(request.getParameter("username"));
		 * newuser.setLoginName(request.getParameter("loginname"));
		 * newuser.setPassword(request.getParameter("password"));
		 */
		newuser.setEmail(email);
		newuser.setPassword(password);
		newuser.setUserName(username);
		// 封装操作结果，包括success是否成功和msg消息提示
		JSONObject result = new JSONObject();
		try {
			
				userService.updateUser(newuser);
				result.put("success", true);
				result.put("msg", "修改成功！");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result.put("success", false);
			result.put("msg", "修改失败！");
		}
		// 写入响应
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(result.toString());
		return null;
	}

	/*
	 * 删除指定id用户
	 */
	@RequestMapping(value = "/deleteuser")
	public String deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 封装操作结果，包括success是否成功和msg消息提示
		JSONObject result = new JSONObject();
		try {
			userService.deleteUserById(Integer.parseInt(request.getParameter("id")));
			result.put("success", true);
			result.put("msg", "删除成功！");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result.put("success", false);
			result.put("msg", "删除失败！");
		}
		// 写入响应
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(result.toString());
		return null;
	}
}
