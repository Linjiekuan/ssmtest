package com.ljk.service;
import com.ljk.yc.Job;
import java.util.List;
public interface JobService {
	//添加
	public int addJob(Job job);
	//更新
	public int updateJob(Job job);
	//删除
	public int deleteJob(int id);
	//分页
	public List<Job> getAllJobs(int pageNo, int size, String name);
	//获取数量
	public int getJobCount(String name);

  
}
