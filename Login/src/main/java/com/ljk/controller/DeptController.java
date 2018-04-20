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
import com.ljk.service.DocumentService;
import com.ljk.yc.Dept;
import com.ljk.yc.Document;

@Controller
public class DeptController {
	// 
	@Autowired
	@Qualifier("deptService")
	private DeptService deptService;  //记得要在前面注入@Service("deptService")
		/**
		 * 
		 */
		@RequestMapping(value = "/addDept")
		public String addDept(@Param("name") String name, @Param("remark") String remark,
				 HttpServletRequest request, HttpServletResponse response)
				throws IOException {
			Dept dept = new Dept();
			dept.setName(name);
			dept.setRemark(remark);
			JSONObject result = new JSONObject();
			try {
				deptService.addDept(dept);
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
		@RequestMapping(value = "/addDept1")
		public String addDept1(@Param("name") String name, @Param("remark") String remark,HttpServletRequest request, HttpServletResponse response)
				throws IOException {
			Dept dept = new Dept();
			dept.setName(name);
			dept.setRemark(remark);
			JSONObject result = new JSONObject();
			try {
				deptService.addDept(dept);
				result.put("success", true);
				result.put("msg", "添加部门成功");
			} catch (Exception e) {
				result.put("success", false);
				result.put("msg", "添加部门失败");
			}
			// 
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(result.toString()); 
			return null; 
		}


		@RequestMapping(value = "/getDepts")
		public String getAllJobs(HttpServletRequest request, HttpServletResponse response) throws IOException {
			// 
			int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
			int rows = request.getParameter("rows") == null ? PAGE_DEFAULT_SIZE
					: Integer.parseInt(request.getParameter("rows"));
			// 
			String name = request.getParameter("name") == null ? "" : request.getParameter("name");
			// 
			List<Dept> dept = deptService.getAllDepts(page, rows, name);
			//
			JSONObject json = new JSONObject();
			// 
			json.put("total", deptService.getDeptCount(name));
			JSONArray row = new JSONArray();
			for (Dept info : dept) {  //
				JSONObject jo = new JSONObject();
				jo.put("id", info.getId());
				jo.put("name", info.getName());
				jo.put("remark", info.getRemark());
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

		@RequestMapping(value = "/updateDept/{id}")
		public String updateJob(
				@PathVariable int id, // 动态获取id
				@Param("name") String name, @Param("remark") String remark,
				 HttpServletRequest request, HttpServletResponse response)
				throws IOException {
			Dept dept = new Dept();
			dept.setId(id);
			dept.setName(name);
			dept.setRemark(remark);
			// 
			JSONObject result = new JSONObject();
			try {
				deptService.updateDept(dept);
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

		/*
		 * 
		 */
		@RequestMapping(value="/deleteDept")  
	    public String deleteJob(
	    		HttpServletRequest request, 
	            HttpServletResponse response) throws IOException{  
	        //
	        JSONObject result = new JSONObject();
	        try{
	        	deptService.deleteDept(Integer.parseInt(request.getParameter("id")));
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
