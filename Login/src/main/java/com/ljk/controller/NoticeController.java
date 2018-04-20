package com.ljk.controller;
import static com.ljk.yc.HrmConstants.PAGE_DEFAULT_SIZE;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ljk.service.NoticeService;
import com.ljk.yc.Employee;
import com.ljk.yc.Notice;

@Controller
public class NoticeController {
	@Autowired
	@Qualifier("noticeService")
	private NoticeService noticeService;  //记得要在前面的NoticeServiceImpl注入@Service("noticeService")
	@RequestMapping(value = "/getNotices")
	public String getAllJobs(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int rows = request.getParameter("rows") == null ? PAGE_DEFAULT_SIZE
				: Integer.parseInt(request.getParameter("rows"));
		// 
		String title = request.getParameter("title") == null ? "" : request.getParameter("title");
		// 
		List<Notice> notice = noticeService.getAllNotices(page, rows, title); //获取符合的所有的notice对象
		//
		JSONObject json = new JSONObject();
		// 
		json.put("total", noticeService.getNoticeCount(title));
		JSONArray row = new JSONArray();
		for (Notice info : notice) {  
			JSONObject jo = new JSONObject();
			jo.put("id", info.getId());
			jo.put("title", info.getTitle());
			jo.put("content", info.getContent());
			jo.put("noticeUsername", info.getNoticeUsername());
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
	@RequestMapping(value ="/addNotice")
	public String addEmployee(@Param("title") String title,
			@Param("content") String content,HttpSession session,
			 HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		JSONObject result = new JSONObject(); 
		String noticeUsername=(String)request.getSession().getAttribute("username");
		try {
			noticeService.addNotice(title,content,noticeUsername);
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
	@RequestMapping(value = "/updateNotice/{id}")
	public String updateEmployee(
			@PathVariable int id, // 动态获取id
			@Param("title") String title,HttpSession session,
			@Param("content") String content,@Param("noticeUsername") String noticeUsername,
			 HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setId(id);
		notice.setNoticeUsername(noticeUsername);
		JSONObject result = new JSONObject();
		try {
			String username=(String)request.getSession().getAttribute("username");
			/*if(username == notice.getNoticeUsername()){
				noticeService.updateNotice(notice);
				result.put("success", true);
				result.put("msg", "更新成功");
			}
			else{
				result.put("success", false);
				result.put("msg", "非公共发布人，不能修改此公告");
			}		*/
			noticeService.updateNotice(notice);
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
	@RequestMapping(value ="/deleteNotice")
	public String deleteNotice(
    		HttpServletRequest request, 
            HttpServletResponse response) throws IOException{  
        JSONObject result = new JSONObject();
        String username=(String) request.getSession().getAttribute("username");
        try{
        	if(username.equals("root")||username.equals(request.getParameter("noticeUsername"))){
        		noticeService.deleteNotice(Integer.parseInt(request.getParameter("id"))); //因为动态获取的ID为String类型，要强制转换成为Integer类型
                result.put("success", true);
                result.put("msg", "删除成功");
        	}
        	else{
        		result.put("success", false);
                result.put("msg", "没有权限删除");
        	}
        	
        	
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
