package com.ljk.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ljk.service.*;
import com.ljk.yc.email.*;
@Controller
public class EmailController {
	    @Resource
	    @Autowired
		@Qualifier("emailserviceservice")
	    private EmailServiceImpl emailservice;
	    @RequestMapping(value="/postemail")
	   // @ResponseBody//不加应该也可以
	    public String postemail(HttpServletRequest request,HttpServletResponse response,HttpSession httpSession) throws IOException{
		        boolean data=true;
		        System.out.println("准备发送邮件");
		        //ModelAndView mav=new ModelAndView();
		        String email = request.getParameter("email");
	            String yanzhengma=emailservice.processregister(email);//发邮箱激活,并且取得验证码
	            //request.getSession().invalidate();
	            request.getSession().setAttribute("yanzhengma", yanzhengma); //储存验证码，方便等等验证验证码是否相同
	            httpSession.setAttribute("Yanzhengma", yanzhengma);
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
				return null;
	    }
}
