package com.ljk.controller;
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
import com.ljk.service.JobService;
import com.ljk.yc.Job;
import static com.ljk.yc.HrmConstants.PAGE_DEFAULT_SIZE;

@Controller
public class JobController {
	// 
	@Autowired
	@Qualifier("jobService")
	private JobService jobService;  //记得要在前面的JobServiceImpl注入@Service("JobService")
	/**
	 * 
	 */
	@RequestMapping(value = "/addjob")
	public String addJob(@Param("name") String name, @Param("remark") String remark,
			 HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Job job = new Job();
		job.setName(name);
		job.setRemark(remark);
		JSONObject result = new JSONObject(); // 
		try {
			jobService.addJob(job);
			result.put("success", true);
			result.put("msg", "添加成功");
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", "添加失败");
		}
		// 
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(result.toString());  
		return null; // ֱ
	}

	@RequestMapping(value = "/getJobs")
	public String getAllJobs(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int rows = request.getParameter("rows") == null ? PAGE_DEFAULT_SIZE
				: Integer.parseInt(request.getParameter("rows"));
		// 
		String name = request.getParameter("name") == null ? "" : request.getParameter("name");
		// 
		List<Job> job = jobService.getAllJobs(page, rows, name);
		//
		JSONObject json = new JSONObject();
		// 
		json.put("total", jobService.getJobCount(name));
		JSONArray row = new JSONArray();
		for (Job info : job) {  //
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

	@RequestMapping(value = "/updatejob/{id}")
	public String updateJob(
			@PathVariable int id, // 动态获取id
			@Param("name") String name, @Param("remark") String remark,
			 HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Job job = new Job();
		job.setId(id);
		job.setName(name);
		job.setRemark(remark);
		// 
		JSONObject result = new JSONObject();
		try {
			jobService.updateJob(job);
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
	@RequestMapping(value="/deleteJob")  
    public String deleteJob(
    		HttpServletRequest request, 
            HttpServletResponse response) throws IOException{  
  
        JSONObject result = new JSONObject();
        try{
        	jobService.deleteJob(Integer.parseInt(request.getParameter("id")));
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
