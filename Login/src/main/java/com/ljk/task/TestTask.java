package com.ljk.task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Component;
import java.text.*;  
import java.util.*; 
import com.ljk.service.EmailServiceImpl;
import com.ljk.service.RedisServiceTest;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.annotations.Param;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.webxml.*;
@Component
public class TestTask {
	@Autowired
	@Qualifier("redisServiceTest")
	@Resource
	private RedisServiceTest redisService;
	@Resource
    @Autowired
	@Qualifier("emailserviceservice")
    private EmailServiceImpl emailservice;
	//private final String time= "0/600 * * * * ? ";//0 0 10,14,16 * *
	private final String time= "0 0 0,1,2,6,8,9,11,13,14,17,19,20,22 * * ? ";
	private boolean flag = false;
	@Scheduled(cron=time) //
    public void taskCycle(){
    	Map wsData =new HashMap();
			Date nowTime = new Date();  
	        String city = "深圳";
			TestWebservice ws = new TestWebservice();
			String data = (String)ws.getWeather(city);
			String [] info =data.split("#");
        for(int i =0;i<info.length;i++) {
        	String tip=info[i];
        	wsData.put(i+1+"", tip);
            System.out.println(info[i]);
        }
        System.out.println("1");
        redisService.setMap("WSdate", wsData);
        System.out.println("2");
        Map<Object, Object> resultMap= redisService.getMap("WSdate");
        System.out.println(resultMap);
		 
    }
/*	@Scheduled(cron="0 0/5 * * * ? ") //18900807988@189.cn
	public void taskEmail(){
		if(flag == true){
		System.out.println("准备发送邮件");
        //ModelAndView mav=new ModelAndView();
        String email =  "614435933@qq.com";
        String yanzhengma=emailservice.processregister(email);
		}
	}
	@Scheduled(cron="0 0/5 * * * ? ") //18900807988@189.cn
	public void taskEmail01(){
		if(flag == true){
		System.out.println("准备发送邮件");
        //ModelAndView mav=new ModelAndView();
        String email =  "18900807988@189.cn";
        String yanzhengma=emailservice.processregister(email);
		}
	}
	@Scheduled(cron="0 0/5 * * * ? ") //间隔5秒执行
    public void taskCycle01(){
		if(flag == true){
		Date nowTime = new Date();  
		
        System.out.println(nowTime+"*********A任务每30秒执行一次进入测试"); 
		}
    }*/
}
