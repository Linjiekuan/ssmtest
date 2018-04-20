package com.ljk.dao;

import com.ljk.yc.Job;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JobDAO {
	// 更新
	public int updateJob(Job job);

	// 添加
	public int addJob(Job job);

	// 删除
	public int deleteJob(int id);

	// 分页
	public List<Job> getAllJobs(@Param("skip") int skip, @Param("size") int size, @Param("name") String name);

	// 获取数量
	public int getJobCount(@Param("name") String name);

}
