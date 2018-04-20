package com.ljk.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.ljk.yc.Notice;

@Repository
public interface NoticeDAO {
	//获取公告
	public List<Notice> getAllNotices(@Param("skip") int skip, @Param("size") int size, @Param("title") String title);
	//获取公告数量
	public int getNoticeCount(@Param("title") String title);
	//新增公告
	public void addNotice(@Param("title")String title,@Param("content")String content,@Param("noticeUsername")String noticeUsername);
	//删除公告
	public int deleteNotice(int id);
	//修改公告
	public int updateNotice(Notice notice);

}
