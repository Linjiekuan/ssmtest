package com.ljk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljk.dao.EmployeeDAO;
import com.ljk.yc.Employee;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired 
	EmployeeDAO employeedao;
	//获取信息和分页
	public List<Employee> getAllEmployees(int pageNo,int size, String name){
		return employeedao.getALLEmployees((pageNo-1)*size,size, "%"+name+"%");
	}
	//获取数量
	public int getEmployeeCount(String name){
		return employeedao.getEmployeeCount("%"+name+"%");
	}
	//根据部门姓名获取部门Id
	public int getDeptId(String deptName) {
		return employeedao.getDeptId(deptName);
	}
	//添加部门
	public void addEmployee(String name,
			 String phone,String email,
			 String qq_num,String deptName){
		 employeedao.addEmployee(name,phone,email,qq_num,deptName);
		 
	}
	public int deleteEmployee(int id) {
		return employeedao.deleteEmployee(id);
	}
	public int updateEmployee(Employee employee){
		return employeedao.updateEmployee(employee);
	}
}
