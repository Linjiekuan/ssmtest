package com.ljk.service;
import org.springframework.stereotype.Service;
import com.ljk.yc.email.*;
@Service("emailservice")
public class EmailServiceImpl {
	    /**
	     * 处理注册
	     */
	    public String processregister( String email){
	    	MD5Util yanzheng=new MD5Util();
	    	String yanzhengma=yanzheng.yanzhengma();
	        ///邮件的内容
	        StringBuffer textemail=new StringBuffer("你的邮箱验证码为：");
	        textemail.append(yanzhengma); 
	        //发送邮件
	        SendEmail.send(email, textemail.toString());
	        System.out.println("发送邮件");
	        return yanzhengma;

	    }
	    /**
	     * 处理找回密码
	     */
	    public String findPassword(String email){
	    	StringBuffer textemail=new StringBuffer("你的重置密码为：");
	    	String password="123";
	    	textemail.append(password);
	    	//发送邮件
	        SendEmail.send(email, textemail.toString());
	        System.out.println("发送邮件");
			return password;
	    }
}