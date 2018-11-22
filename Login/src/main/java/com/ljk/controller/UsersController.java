package com.ljk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljk.md5.MD5;
import com.ljk.service.UsersService;
import com.ljk.yc.Users;



@Controller
@RequestMapping(value="/user")
/**
 * 描述:用户controller<BR>
 * 创建人:<BR>
 * 时间:2017年7月10日下午7:15:58<BR>
 * @version
 */
public class UsersController {

    @Autowired
    private UsersService userService;  

    /**
     *跳转到添加用户界面
     */
    @RequestMapping("toAddUser")
    public String toAddUser(HttpServletRequest request, 
    		HttpServletResponse response){
    	
    	
    	int page = request.getParameter("page") == null ?
    			1 : Integer.parseInt(request.getParameter("page"));
    	int rows = request.getParameter("rows") == null ? 
    			10 : Integer.parseInt(request.getParameter("rows"));
    	//筛选条件
    	String search_name = request.getParameter("search_name") == null ? 
    			"" : request.getParameter("search_name");
    	String search_detail = request.getParameter("search_detail") == null ? 
    			"" : request.getParameter("search_detail");
    	String search_account = request.getParameter("search_account") == null ? 
    			"" : request.getParameter("search_account");
        return "addUser";
    }

    /**
     * 添加用户并重定向  
     * @param model
     * @param user
     * @return
     * @throws Exception 
     */
    @RequestMapping("addUser") 
    public String addUser(Model model,Users user) throws Exception{
    	MD5 md5 = new MD5();
    	String passwordMD5 = md5.md5(user.getPassword(), "linjiekuan");
    	user.setPassword(passwordMD5);
        if(user != null){
            userService.saveUser(user);
        }
        return "redirect:/user/userInfo";
    }
    @RequestMapping("addUser1") 
    public String addUser1(Model model,Users user){
        if(user != null){
            userService.saveUser(user);
        }
        return "redirect:/register11";
    }
    /**
     * 修改用户
     * @param model
     * @param request
     * @param user
     * @return
     */
    @RequestMapping("updateUser")  
    public String UpdateUser(Model model,Users user){
             if(userService.updateUser(user)){  
                    user = userService.findUserById(user.getId());  
                    model.addAttribute("user", user);  
                    return "redirect:/user/userInfo";  
                } 
         return "/error";  
    }

    /**
     * 查询所有用户
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("getAllUser")  
    public String getAllUser(Model model){
        List<Users> user = userService.findAll();
        model.addAttribute("userList",user);
        return "allUser";
    }

    /**
     * 查询单个用户
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/getUser")  
    public String getUser(int id,Model model){
        model.addAttribute("user", userService.findUserById(id));  
        return "editUser";
    }
    /**
     * 根据id删除用户
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping("/delUser") 
    public String deleteUser(int id,Model model){
        model.addAttribute("user", userService.deleteUser(id));  
        return "redirect:/user/userInfo";
    }

    /**
     * 分页查询用户信息
     * @param pn 默认从第一页开始  请求参数
     * @param model
     * @return
     */
    @RequestMapping("userInfo")
    public String getUsers(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model){
        //从第一条开始 每页查询五条数据
        PageHelper.startPage(pn, 5);
        List<Users> users = userService.findAll();
        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(users,5);
        model.addAttribute("pageInfo", page);
        return "user";
    }
    
 
/*    @RequestMapping(value="/user")
    public String user(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException {
    	return "user";
    }*/
}