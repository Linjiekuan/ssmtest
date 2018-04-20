package com.ljk.controller;
import static com.ljk.yc.HrmConstants.PAGE_DEFAULT_SIZE;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.beans.factory.annotation.Qualifier;
import  org.springframework.stereotype.Controller;
import  org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.ljk.service.DeptService;
import com.ljk.service.EmployeeService;
import com.ljk.service.JobService;
import com.ljk.service.UserService;
import com.ljk.yc.Dept;
import com.ljk.yc.Employee;
import com.ljk.yc.email.EmailTest;
@Controller
public class mainController {
	@Autowired
	@Qualifier("deptService")
	private DeptService deptService;
	@RequestMapping(value="/email")
	String email(){
		return "testEmail/registerEmailValidae";
	}
	@RequestMapping(value="/doc")
	String doc(){
		return "doc/document";
	}
	@RequestMapping(value="/job")
	String job(){
		return "job/job";
	}
	@RequestMapping(value="/notice")
	String notice(){
		return "notice/notice";
	}
	@RequestMapping(value="/employee")
	String employee(HttpServletRequest request, HttpServletResponse response){

		String name = request.getParameter("name") == null ? "" : request.getParameter("name");
		int count=deptService.getDeptCount(name);
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int rows = request.getParameter("rows") == null ? count
				: Integer.parseInt(request.getParameter("rows"));
		// 
		// 
		
		List<Dept> listDept = deptService.getAllDepts(page, rows, name);
		//request.getSession().setAttribute("listDept",listDept);
		request.setAttribute("listDept", listDept);
		return "employee/employee";
	}
	@RequestMapping(value="/dept")
	String dept(Model model){
		//return "dept/dept";
		List<Dept> lists = deptService.selectUserListByPage();
        model.addAttribute("userLists", lists);//回显用户信息  
        return "redirect:maindept";  //这里转到下面的maindept进行处理
	}
	@RequestMapping(value="/user")
	String user(){
		return "user/user";
	}
	@RequestMapping(value="/mainindex")
	String indexmain(){
		return "index";
	}
	@RequestMapping(value="/mainindex1")
	String indexmain1(){
		return "index1";
	}
/*	@RequestMapping("/user")
	 public String  main(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,Model model){
	        model.addAttribute("pagemsg", userService.findByPage(currentPage));
	  return "user/user";
	}*/
	@RequestMapping(value="/maindept")
	public String  main(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,Model model){
        model.addAttribute("pagemsg", deptService.findByPage(currentPage));//回显分页数据
        return "dept/deptTest";
    }
	@RequestMapping(value="/docmain")
	String docmain(){
		return "doc/docmain";
	}
	@RequestMapping(value="/jobmain")
	String jobmain(){
		return "job/jobmain";
	}
	@RequestMapping(value="/noticemain")
	String noticemain(){
		return "notice/noticemain";
	}
	@RequestMapping(value="/deptmain")
	String deptmain(){
		return "dept/deptmain";
	}
	@RequestMapping(value="/employeemain")
		String employeemain(HttpServletRequest request, HttpServletResponse response){

			String name = request.getParameter("name") == null ? "" : request.getParameter("name");
			int count=deptService.getDeptCount(name);
			int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
			int rows = request.getParameter("rows") == null ? count
					: Integer.parseInt(request.getParameter("rows"));
			// 
			// 
			
			List<Dept> listDept = deptService.getAllDepts(page, rows, name);
			request.getSession().setAttribute("listDept",listDept);
			request.setAttribute("listDept", listDept);
		return "employee/employeemain";
	}
	@RequestMapping(value="/usermain")
	String usermain(){
		return "user/usermain";
	}
}
