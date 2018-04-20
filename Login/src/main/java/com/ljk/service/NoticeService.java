package com.ljk.service;

import java.util.List;

import com.ljk.yc.Notice;

public interface NoticeService {
	//获取公告内容
	public  List<Notice> getAllNotices(int pageNo, int size,String title);
	//获取数量
	public int getNoticeCount(String title);
	//新增公告
	public void addNotice(String title,String content,String noticeUsername);
	//public void addNotice(String title,String content);
	//删除公告
	public int deleteNotice(int id);
	//更新公告
	public int updateNotice(Notice notice);
}
