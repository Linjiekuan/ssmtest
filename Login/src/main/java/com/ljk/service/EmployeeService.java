package com.ljk.service;

import java.util.List;

import com.ljk.yc.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees(int pageNo,int size, String name);
	public int getEmployeeCount(String name);
	public int getDeptId(String deptName);
	public void addEmployee(
			String name,String phone,
			String email,String qq_num, String deptName);
	public int deleteEmployee(int id);
	public int updateEmployee(Employee employee);

}
