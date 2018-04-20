package com.ljk.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.ljk.yc.Document;

@Repository
public interface DocumentDAO {
	//获取文件信息
	public List<Document> getAllDocuments(String title);
	//获取文件数量
	public int getDocumentCount(String title);
	//添加文件
	public void addDocument(@Param("title")String title,@Param("remark")String remark,
			@Param("filename") String filename );
	//根据id查找文件上传后的文件名
	public String findFileName(@Param("id") int id);
}

