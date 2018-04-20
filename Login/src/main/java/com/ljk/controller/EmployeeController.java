package com.ljk.controller;

import static com.ljk.yc.HrmConstants.PAGE_DEFAULT_SIZE;

import java.io.IOException;
import java.util.List;

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

import com.ljk.service.DeptService;
import com.ljk.service.EmployeeService;
import com.ljk.yc.Dept;
import com.ljk.yc.Employee;
import com.ljk.yc.Job;

@Controller
public class EmployeeController {
	@Autowired
	@Qualifier("employeeService")
	private EmployeeService employeeService; //记得要在前面注入@Service("employeeService")
	@Autowired
	@Qualifier("deptService")
	private DeptService deptService;
	@RequestMapping(value = "/getEmployees")
	public String getAllEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int rows = request.getParameter("rows") == null ? PAGE_DEFAULT_SIZE
				: Integer.parseInt(request.getParameter("rows"));
		// 
		String name = request.getParameter("name") == null ? "" : request.getParameter("name");
		// 
		List<Employee> employee = employeeService.getAllEmployees(page, rows, name);
		//获取职员的部门信息
		//List<Dept> listDept = deptService.getAllDepts(page, rows, name);
		//request.setAttribute("listDept", listDept);
		
		JSONObject json = new JSONObject();
		// 
		json.put("total", employeeService.getEmployeeCount(name));
		JSONArray row = new JSONArray();
		for (Employee info : employee) {  //
			JSONObject jo = new JSONObject();
			jo.put("id", info.getId());
			jo.put("name", info.getName());
			jo.put("phone", info.getPhone());
			jo.put("qq_num", info.getQq_num());
			jo.put("email", info.getEmail());
			jo.put("deptName",info.getDeptName());
			row.put(jo);
		}
		json.put("rows", row); 
		System.out.println(json.toString());
		// 
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(json.toString());
		// 返回本页，不跳转
		return null;
	}
	@RequestMapping(value = "/addEmployee")
	public String addEmployee(@Param("name") String name,
			@Param("phone") String phone,@Param("email") String email,
			@Param("qq_num") String qq_num,@Param("deptName") String deptName, //使用@Param(dept.name)也可以传送过来，神奇的事，暂时不知道原理
			 HttpServletRequest request, HttpServletResponse response)
			throws IOException {
	     //int dept_id= employeeService.getDeptId(deptName);
				/*	Employee employee = new Employee();
		employee.setName(name);
		employee.setId(id);
		employee.setPhone(phone);
		employee.setQq_num(qq_num);
		employee.setEmail(email);
		employee.setDept_id(dept_id);
		employee.setJob_id(job_id);*/
		JSONObject result = new JSONObject(); 
		try {
			employeeService.addEmployee(name,phone,email,qq_num,deptName);
			result.put("success", true);
			result.put("msg", "添加成功");
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", "添加失败");
		}
		// 
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(result.toString());  
		return null;       
	}
	@RequestMapping(value = "/updateEmployee/{id}")
	public String updateEmployee(
			@PathVariable int id, // 动态获取id
			@Param("name") String name,
			@Param("phone") String phone,@Param("email") String email,
			@Param("qq_num") String qq_num,@Param("dept.name") String deptName,
			 HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int dept_id= employeeService.getDeptId(deptName);
		Employee employee = new Employee();
		employee.setName(name);
		employee.setId(id);
        employee.setPhone(phone);
        employee.setQq_num(qq_num);
        employee.setEmail(email);
        employee.setDept_id(dept_id);
        employee.setJob_id(dept_id);
		// 
		JSONObject result = new JSONObject();
		try {
			employeeService.updateEmployee(employee);
			result.put("success", true);
			result.put("msg", "更新成功");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result.put("success", false);
			result.put("msg", "更新失败");
		}
		// 
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(result.toString());
		return null;
	}
	@RequestMapping(value="/deleteEmployee")  
    public String deleteJob(
    		HttpServletRequest request, 
            HttpServletResponse response) throws IOException{  
        JSONObject result = new JSONObject();
        try{
        	employeeService.deleteEmployee(Integer.parseInt(request.getParameter("id"))); //因为动态获取的ID为String类型，要强制转换成为Integer类型
            result.put("success", true);
            result.put("msg", "删除成功");
        }catch(Exception e){
            System.out.println(e.getMessage());
            result.put("success", false);
            result.put("msg", "删除失败");
        }
        //
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(result.toString());
        return null;
    } 
}

