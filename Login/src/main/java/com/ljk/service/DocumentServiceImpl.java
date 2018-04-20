package com.ljk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljk.dao.DocumentDAO;
import com.ljk.yc.Document;
@Service("documentService")
public class DocumentServiceImpl implements DocumentService{
	@Autowired
	DocumentDAO documentDao;
	//获取数量
	public int getDocumentCount(String title){
		return documentDao.getDocumentCount("%"+title+"%");
	}
	public List<Document> getAllDocuments(String title) {
		// TODO Auto-generated method stub
		return  documentDao.getAllDocuments("%"+title+"%");
	}
	public void addDocument(String title,  String remark ,String newFileName) {
		documentDao.addDocument(title, remark,newFileName);
		
	}
	public String findFileName(int id) {
		// TODO Auto-generated method stub
		return documentDao.findFileName(id);
	}
}
