package com.ljk.service;

import java.util.List;
import com.ljk.yc.Dept;
import com.ljk.yc.PageBean;

public interface DeptService {
	//更新
	public int updateDept(Dept dept);
	// 添加
	public int addDept(Dept dept);

	// 删除
	public int deleteDept(int id);

	// 分页
	public List<Dept> getAllDepts( int pageNo, int size, String name);

	// 获取数量
	public int getDeptCount(String name);
	
	//下面为原生的分页功能
	List<Dept> selectUserListByPage();
	
	int selectCountByPage();
	
	PageBean<Dept> findByPage(int currentPage);

}
