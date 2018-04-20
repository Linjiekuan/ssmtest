package com.ljk.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljk.dao.JobDAO;
import com.ljk.service.JobService;
import com.ljk.yc.Job;
@Service("jobService")
public class JobServiceImpl implements JobService {
	@Autowired 
    JobDAO jobdao;
	    //添加
		public int addJob(Job job){
			return jobdao.addJob(job);
		}
		//更新
		public int updateJob(Job job){
			return jobdao.updateJob(job);
		}
		//删除
		public int deleteJob(int id){
			return jobdao.deleteJob(id);
		}
		//分页获取
		public List<Job> getAllJobs(int pageNo, int size, String name){
			return jobdao.getAllJobs((pageNo-1)*size, size, "%"+name+"%");
		}
		//获取数量
		public int getJobCount(String name){
			return jobdao.getJobCount("%"+name+"%");
		}

}
