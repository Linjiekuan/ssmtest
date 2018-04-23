package com.ljk.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljk.service.EmailServiceImpl;
import com.ljk.service.UserService;
import com.ljk.yc.User;
import com.ljk.md5.*;

//@Controller注解用于标示本类为web层控制组件
@Controller
public class LoginRegisterController {
	// 自动注入业务层的userService类
		@Autowired
		@Qualifier("userService")
		private UserService userService;
		@Autowired
		@Qualifier("emailserviceservice")
		@Resource
		 private EmailServiceImpl emailservice;
		//引入MD5加密
		private MD5 md5 = new MD5();
		/**
		 * 处理/login请求,也就是登陆验证
		 * @throws Exception 
		 */
		@RequestMapping(value = "/login")
		public String login( HttpServletRequest request, Model model) throws Exception {
			// 根据登录名和密码查找用户，判断用户登录
			User user1 = new User();
			String passwordMD5 = md5.md5(request.getParameter("password"), "linjiekuan");
			user1.setUserName(request.getParameter("username"));
			user1.setPassword(passwordMD5);
			// User user = userService.login(
			// user.getUserName(),user.getPassword());
			User user = userService.login(request.getParameter("username"), passwordMD5);
			// User user = userService.login(
			// username,password);//
			if (user != null) {
				// 登录成功，将user对象设置到HttpSession作用范围域
				request.getSession().setAttribute("username", user.getUserName());
				//return "user/usermain"; // 在这里可以直接返回主页面，因为在mvc那里配置了前缀和后缀。
				return "index1";
			} else {
				// 登录失败，设置失败提示信息，并跳转到登录页面
				return "error";
			}
		}

		/**
		 * 跳转到注册页面
		 */
		@RequestMapping(value = "/registerpage")
		public String registerpage() {
			return "register";
		}
		
		@RequestMapping("/addAjax")
		@ResponseBody//必须加入的注解
		public void addAjax(HttpServletRequest request,HttpServletResponse response) throws IOException {
			         boolean data=true;
			         String username=request.getParameter("username");
			          int name=userService.checkByName(username);
			         if(name<=0){
			        	 data=false;
			         }
			         //响应前台
			         response.setCharacterEncoding("utf-8");
			         response.setContentType("text/html");
			         PrintWriter out=response.getWriter();
			         if(data){
			             out.print("true");
			         }else{
			             out.print("false");
			         }
			         out.flush();//刷新流
			         out.close();//关闭流
			         
			     }
		@RequestMapping("/addEmailAjax")
		@ResponseBody//必须加入的注解
		public void addEmailAjax(HttpServletRequest request,HttpServletResponse response) throws IOException {
			         boolean data=true;
			         String email=request.getParameter("email");
			          int count=userService.checkByEmail(email);
			         if(count<=0){
			        	 data=false;
			         }
			         //响应前台
			         response.setCharacterEncoding("utf-8");
			         response.setContentType("text/html");
			         PrintWriter out=response.getWriter();
			         if(data){
			             out.print("true");
			         }else{
			             out.print("false");
			         }
			         out.flush();//刷新流
			         out.close();//关闭流
			         
			     }



		/**
		 * 在注册页面注册用户时候的处理
		 * @throws Exception 
		 */
		@RequestMapping(value = "/register")
		public String register(@Param("username") String username, @Param("password") String password,
				@Param("eamil") String email,@Param("emailyanzheng") String emailyanzheng,
				HttpServletRequest request ,HttpSession httpSession) throws Exception {
			User newuser = new User();
			String passwordMD5 = md5.md5(password, "linjiekuan");
			newuser.setUserName(username);
			newuser.setPassword(passwordMD5);
			newuser.setEmail(email);
			String emailyanzheng1=(String)request.getParameter("emailyanzheng");
			String yanzheng=(String) request.getSession().getAttribute("yanzhengma");
			if( emailyanzheng1.equals(yanzheng)){   //emailyanzheng1==request.getSession().getAttribute("yanzhengma")!emailyanzheng1.isEmpty()
				userService.addUser(newuser);
				return "successReegister";
			}
			else{
				return "error";		
			}
		}
		
		/**
		 * 找回密码的控制层代码，就是点击提交的时候的代码。第一步，验证邮箱的代码
		 */
		@RequestMapping(value = "/findpassword1")
		public String findpassword1(
				@Param("eamil") String email,@Param("emailyanzheng") String emailyanzheng,
				HttpServletRequest request ,HttpSession httpSession) {
			User newuser = new User();
			newuser.setEmail(email);
			String emailyanzheng1=(String)request.getParameter("emailyanzheng");
			String yanzheng=(String) request.getSession().getAttribute("yanzhengma");
			request.getSession().setAttribute("email", newuser.getEmail()); //保存页面1的email，方便下面第二步利用邮箱的唯一性修改密码
			if( emailyanzheng1.equals(yanzheng)){   //一定要使用equals()函数判断是否相等  
				return "findpassword/findpassword3";   
			}
			else{
				return "error";		
			}
		}
		/**
		 * 第二步,修改密码的代码
		 */
		@RequestMapping(value = "/findpassword3")
		public String findpassword3(
				HttpServletRequest request ,HttpSession httpSession) {
			User newuser = new User();
			String email = (String) request.getSession().getAttribute("email");
			newuser.setPassword(request.getParameter("password"));
			newuser.setEmail(email); 
			userService.findPassword(newuser.getEmail(), newuser.getPassword());//这里根据你自己的代码修改，利用email，和password进行修改
			return "findpassword/findpassword4";
		}
		
		
		@RequestMapping(value = "/registerSuccess")  //注册成功后
		public String register1() {
			return "login"; // 跳转页面3秒后会跳回登陆页面
		}
		@RequestMapping(value = "/loginError")  //登陆失败返回来登陆页面
		public String loginError() {
			return "login"; // 跳转页面3秒后会跳回登陆页面
		}
		@RequestMapping(value = "/findPassword")
		public String findPassword() {
			return "findpassword/findpassword1"; // 找回密码的jsp页面 emailPassword
		}
		@RequestMapping(value = "/passwordEmail")  //发送邮件修改密码
		public String passwordEmail(HttpServletRequest request ,HttpSession httpSession) {
	        String email = request.getParameter("email");
            String password=emailservice.findPassword(email);
            userService.findPassword(email, password);
			return "emailPassword"; 
		}
}
