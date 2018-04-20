package com.ljk.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ljk.yc.Employee;

@Repository
public interface EmployeeDAO {
	//获取职员信息跟分页
	public List<Employee> getALLEmployees(@Param("skip") int skip, @Param("size") int size, @Param("name") String name);
    //获取数量
	public int getEmployeeCount(@Param("name")String name);
	//根据部门名称获取部门ID，以便导入职员表，因为职员表是没有部门ID的字段的
	public int getDeptId(@Param("deptName") String deptName);
	//增加职员
/*	public void addEmployee(@Param("name") String name,
			@Param("phone") String phone,@Param("email") String email,
			@Param("qq_num") String qq_num,@Param("dept_id") int dept_id);*/
	public void addEmployee(@Param("name") String name,
			@Param("phone") String phone,@Param("email") String email,
			@Param("qq_num") String qq_num,@Param("deptName") String deptName);
	//public int addEmployee(Employee employee);
	//删除员工
	public int deleteEmployee( int id);
	//更新员工信息
	public int updateEmployee(Employee employee);
}
