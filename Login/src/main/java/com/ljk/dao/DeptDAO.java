package com.ljk.dao;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.ljk.yc.Dept;

@Repository
public interface DeptDAO {
	// 更新
	public int updateDept(Dept dept);

	// 添加
	public int addDept(Dept dept);

	// 删除
	public int deleteDept(int id);

	// 分页
	public List<Dept> getAllDepts(@Param("skip") int skip, @Param("size") int size, @Param("name") String name);

	// 获取数量
	public int getDeptCount(@Param("name") String name);
	
	//原生的分页功能
	public List<Dept> findByPage(HashMap<String,Object> map);
    //原生的查询所有部门数据
	public List<Dept> selectUserListByPage();
    //原生的查询部门记录总数
	public int selectCountByPage();

}
