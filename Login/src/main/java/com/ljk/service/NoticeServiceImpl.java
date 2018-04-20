package com.ljk.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ljk.dao.NoticeDAO;
import com.ljk.service.NoticeService;
import com.ljk.yc.Notice;
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	@Autowired 
	NoticeDAO noticeDao;
	public List<Notice> getAllNotices(int pageNo, int size, String title) {
		// TODO Auto-generated method stub
		return noticeDao.getAllNotices((pageNo-1)*size, size, "%"+title+"%");
	}

	public int getNoticeCount(String title) {
		// TODO Auto-generated method stub
		return noticeDao.getNoticeCount("%"+title+"%");
	}
	
	public void addNotice(String title,String content,String noticeUsername){
		 noticeDao.addNotice(title,content,noticeUsername);
	}
	/*public void addNotice(String title,String content){
		 noticeDao.addNotice(title,content);
	}*/
	public int deleteNotice(int id){
		return noticeDao.deleteNotice(id);
	}
	//更新
	public int updateNotice(Notice notice){
		return noticeDao.updateNotice( notice);
	}

}
