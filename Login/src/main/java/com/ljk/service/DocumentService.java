package com.ljk.service;

import java.util.List;
import com.ljk.yc.Document;

public interface DocumentService {
	//获取文件信息
	public List<Document> getAllDocuments(String title);
	//获取文件数量
	public int getDocumentCount(String title);
	//添加文件
	public void addDocument(String title,String remark,String newFileName);
   //获取文件上传后的文件名
	public String findFileName(int id);
}
