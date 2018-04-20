package com.ljk.controller;
import static com.ljk.yc.HrmConstants.PAGE_DEFAULT_SIZE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.MediaType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.ljk.service.DocumentService;
import com.ljk.yc.Document;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DocumentController {	
    @Autowired
    @Qualifier("documentService")
    private DocumentService documentService;
    @RequestMapping(value="/getAllDocuments") 
    public String getAllDocuments(HttpServletRequest request, HttpServletResponse response)  throws IOException {  
	    
	    int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int rows = request.getParameter("rows") == null ? PAGE_DEFAULT_SIZE
				: Integer.parseInt(request.getParameter("rows"));
		// 
		String title = request.getParameter("title") == null ? "": request.getParameter("title");
		// 
					List<Document> document = documentService.getAllDocuments(title);
					//
					JSONObject json = new JSONObject();
					// 
					json.put("total", documentService.getDocumentCount(title) );
					JSONArray row = new JSONArray();
					for (Document info : document) {  
						JSONObject jo = new JSONObject();
						jo.put("id", info.getId());
						jo.put("title", info.getTitle());
						jo.put("filename", info.getFileName());
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
	/** 
     * 上传多个文件 
	 * @throws IOException 
     */  
    @RequestMapping("/addFile")  
    public String threeFileUpload( @Param("title")String title,
			@Param("remark")String remark, 
            @RequestParam("file") CommonsMultipartFile files[],  
            HttpServletRequest request, ModelMap model,HttpServletResponse response
           ) throws IOException {  
      
        List<String> list = new ArrayList<String>();  
        // 获得项目的路径  
        ServletContext sc = request.getSession().getServletContext();  
        // 上传位置  
        String path = sc.getRealPath("/img") + "/"; // 设定文件保存的目录  
        File f = new File(path);  
        if (!f.exists())  
            f.mkdirs();  
        String newFileName1 = null;
        for (int i = 0; i < files.length; i++) {  
            // 获得原始文件名  
            String fileName = files[i].getOriginalFilename();  
            System.out.println("原始文件名:" + fileName);  
            // 新文件名  
            String newFileName = UUID.randomUUID() +"_"+ fileName;  
            newFileName1=newFileName;
            if (!files[i].isEmpty()) {  
                try {  
                    FileOutputStream fos = new FileOutputStream(path  
                            + newFileName);  
                    java.io.InputStream in = files[i].getInputStream();  
                    int b = 0;  
                    while ((b = in.read()) != -1) {  
                        fos.write(b);  
                    }  
                    fos.close();  
                    in.close();  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
          
        }
        JSONObject result = new JSONObject(); 
		try {
			String filename=newFileName1;
			documentService.addDocument(title,remark,filename);
			result.put("success", true);
			result.put("msg", "上传文件成功");
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", "上传文件失败");
		}
		// 
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(result.toString()); 
        return null; 
    } 
	    	/**
	    	 * 列出所有的文件
	    	 */
    @RequestMapping("/listFile")
    public String listFile(HttpServletRequest request,  
            HttpServletResponse response) {  
        // 获取上传文件的目录  
        ServletContext sc = request.getSession().getServletContext();  
        // 上传位置  
        String uploadFilePath = sc.getRealPath("/img") + "/"; // 设定文件保存的目录  
        // 存储要下载的文件名  
        Map<String, String> fileNameMap = new HashMap<String, String>();  
        // 递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中  
        listfile(new File(uploadFilePath), fileNameMap);// File既可以代表一个文件也可以代表一个目录  
        // 将Map集合发送到listfile.jsp页面进行显示  
        request.setAttribute("fileNameMap", fileNameMap);  
        return "doc/listFileDown"; 
    }
	    @RequestMapping("/listFileDown")
	    public String listFileDown( // 获取id 
	    			HttpServletRequest request,  
	    	        HttpServletResponse response) throws IOException{  
	    		System.out.println("1");
	    		Document doc=new Document();
	    		doc.setId(Integer.parseInt(request.getParameter("id")));
	    		doc.setFileName(documentService.findFileName(doc.getId()));
	    		JSONObject result = new JSONObject();
	    		try{		
	    		// 获取上传文件的目录  
	    	    ServletContext sc = request.getSession().getServletContext();  
	    	    // 上传位置  
	    	    String uploadFilePath = sc.getRealPath("/img") + "/"; // 设定文件保存的目录 
	    	    File file = new File(uploadFilePath + "\\" + doc.getFileName());
	    	    // 存储要下载的文件名  
	    	    Map<String, String> fileNameMap = new HashMap<String, String>();  
	    	    // 递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中  
	    	    listfile(file, fileNameMap);// File既可以代表一个文件也可以代表一个目录  
	    	    // 将Map集合发送到listfile.jsp页面进行显示  
	    	    request.setAttribute("fileNameMap", fileNameMap); 
	    	    System.out.println("2");
	    	    result.put("success", true);
	            result.put("msg", "下载成功");
	    	    
	    		}catch(Exception e){
		            System.out.println(e.getMessage());
		            result.put("success", false);
		            result.put("msg", "下载失败");
		        }
	    		 return "doc/listFileDown";
	    	}

	    	public void listfile(File file, Map<String, String> map) {
	    		// 如果file代表的不是一个文件，而是一个目录
	    		if (!file.isFile()) {
	    			// 列出该目录下的所有文件和目录
	    			File files[] = file.listFiles();
	    			// 遍历files[]数组
	    			for (File f : files) {
	    				// 递归
	    				listfile(f, map);
	    			}
	    		} else {
	    			/**
	    			 * 处理文件名，上传后的文件是以uuid_文件名的形式去重新命名的，去除文件名的uuid_部分
	    			 * file.getName().indexOf
	    			 * ("_")检索字符串中第一次出现"_"字符的位置，如果文件名类似于：9349249849-88343-8344_阿_凡_达.avi
	    			 * 那么file.getName().substring(file.getName().indexOf("_")+1)
	    			 * 处理之后就可以得到
	    			 */
	    			String realName = file.getName().substring(
	    					file.getName().indexOf("_") + 1);
	    			// file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复
	    			map.put(file.getName(), realName);
	    		}
	    		 
	    	}

	    	@RequestMapping("/downFile")
	    	public void downFile(HttpServletRequest request,
	    			HttpServletResponse response) {
	    		System.out.println("1");
	    		// 得到要下载的文件名
	    		String fileName = request.getParameter("filename");
	    		//String fileName=documentService.findFileName(Integer.parseInt(request.getParameter("id")));
	    		System.out.println(fileName);
	    		System.out.println("2");
	    		try {
	    			fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
	    			System.out.println("3");
	    			// 获取上传文件的目录
	    			ServletContext sc = request.getSession().getServletContext();
	    			System.out.println("4");
	    			// 上传位置
	    			String fileSaveRootPath = sc.getRealPath("/img"); 
	    			
	    			System.out.println(fileSaveRootPath + "\\" + fileName);
	    			// 得到要下载的文件
	    			File file = new File(fileSaveRootPath + "\\" + fileName);
	    			
	    			// 如果文件不存在
	    			if (!file.exists()) {
	    				request.setAttribute("message", "您要下载的资源已被删除！！");
	    				System.out.println("您要下载的资源已被删除！！");
	    				return;
	    			}
	    			// 处理文件名
	    			String realname = fileName.substring(fileName.indexOf("_") + 1);
	    			// 设置响应头，控制浏览器下载该文件
	    			response.setHeader("content-disposition", "attachment;filename="
	    					+ URLEncoder.encode(realname, "UTF-8"));  //
	    			// 读取要下载的文件，保存到文件输入流
	    			FileInputStream in = new FileInputStream(fileSaveRootPath + "\\" + fileName);
	    			// 创建输出流
	    			OutputStream out = response.getOutputStream();
	    			// 创建缓冲区
	    			byte buffer[] = new byte[1024];
	    			int len = 0;
	    			// 循环将输入流中的内容读取到缓冲区当中
	    			while ((len = in.read(buffer)) > 0) {
	    				// 输出缓冲区的内容到浏览器，实现文件下载
	    				out.write(buffer, 0, len);
	    			}
	    			// 关闭文件输入流
	    			in.close();
	    			// 关闭输出流
	    			out.close();
	    		} catch (Exception e) {

	    		}
	    	}
	    	
	    	@RequestMapping(value="/downDoc")  
		    public void downDoc(
	    			HttpServletRequest request,  
	    	        HttpServletResponse response) throws IOException{ 
	    		JSONObject result = new JSONObject();	
		        	System.out.println("1");
		        	Document doc =new Document();
		        	doc.setId(Integer.parseInt(request.getParameter("id")));
		        	String fileName=documentService.findFileName(doc.getId());
		        	System.out.println("2");
		        	System.out.println(fileName);
		        	System.out.println(Integer.parseInt(request.getParameter("id")));
		        	try {
		    			fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
		    			System.out.println("3");
		    			// 获取上传文件的目录
		    			ServletContext sc = request.getSession().getServletContext();
		    			System.out.println("4");
		    			// 上传位置
		    			String fileSaveRootPath = sc.getRealPath("/img"); 
		    			
		    			System.out.println(fileSaveRootPath + "\\" + fileName);
		    			// 得到要下载的文件
		    			File file = new File(fileSaveRootPath + "\\" + fileName);
		    			
		    			// 如果文件不存在
		    			if (!file.exists()) {
		    				request.setAttribute("message", "您要下载的资源已被删除！！");
		    				System.out.println("您要下载的资源已被删除！！");
		    				return ;
		    			}
		    			// 处理文件名
		    			String realname = fileName.substring(fileName.indexOf("_") + 1);
		    			// 设置响应头，控制浏览器下载该文件
		    			response.setHeader("content-disposition", "attachment;filename="
		    					+ URLEncoder.encode(fileName, "UTF-8"));
		    			// 读取要下载的文件，保存到文件输入流
		    			FileInputStream in = new FileInputStream(fileSaveRootPath + "\\" + fileName);
		    			// 创建输出流
		    			OutputStream out = response.getOutputStream();
		    			// 创建缓冲区
		    			byte buffer[] = new byte[1024];
		    			int len = 0;
		    			// 循环将输入流中的内容读取到缓冲区当中
		    			while ((len = in.read(buffer)) > 0) {
		    				// 输出缓冲区的内容到浏览器，实现文件下载
		    				out.write(buffer, 0, len);
		    			}
		    			// 关闭文件输入流
		    			in.close();
		    			// 关闭输出流
		    			out.close();
		    			result.put("success", true);
						result.put("msg", "下载成功");
						System.out.println("5");
		    		} catch (Exception e) {
		    			result.put("success", true);
						result.put("msg", "下载失败");

		    		}
		        //
		    } 
	    	
	    	@RequestMapping(value="/download")
	        public ResponseEntity<byte[]> download(HttpServletRequest request, 
		            HttpServletResponse response,
	                Model model)throws Exception {
	        	ServletContext sc = request.getSession().getServletContext();
    			System.out.println("4");
    			// 上传位置
    			String fileSaveRootPath = sc.getRealPath("/img"); 
    			
	           //下载文件路径
	           //String path = request.getServletContext().getRealPath("/img/");
	           String filename=documentService.findFileName(Integer.parseInt(request.getParameter("id")));
	           File file = new File(fileSaveRootPath + "\\" + filename);           
	           //File file = new File(path + File.separator + filename);
	           HttpHeaders headers = new HttpHeaders();  
	           //下载显示的文件名，解决中文名称乱码问题  
	           String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
	           //通知浏览器以attachment（下载方式）打开图片
	           headers.setContentDispositionFormData("attachment", downloadFielName); 
	           //application/octet-stream ： 二进制流数据（最常见的文件下载）。
	           headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	           return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
	                   headers, HttpStatus.CREATED);  
	        }
	        
}

/*  文件显示
@RequestMapping("/listFile")
public String listFile(HttpServletRequest request,  
        HttpServletResponse response) {  
    // 获取上传文件的目录  
    ServletContext sc = request.getSession().getServletContext();  
    // 上传位置  
    String uploadFilePath = sc.getRealPath("/img") + "/"; // 设定文件保存的目录  
    // 存储要下载的文件名  
    Map<String, String> fileNameMap = new HashMap<String, String>();  
    // 递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中  
    listfile(new File(uploadFilePath), fileNameMap);// File既可以代表一个文件也可以代表一个目录  
    // 将Map集合发送到listfile.jsp页面进行显示  
    request.setAttribute("fileNameMap", fileNameMap);  
    return "doc/listFileDown"; 
}*/
