package com.ljk.yc;
public class Employee {
	private Integer id;			// id
	private Integer dept_id;	// 部门id
	private Integer job_id;		// 职位id
	private String name;		// 名称
	private String cardId;		// 工牌号码
	private String address;		// 地址
	private String postCode;	// 邮政编码
	private String tel;			// 电话
	private String phone;		// 手机
	private String qq_num;		// qq号码
	private String email;		// 邮箱
	private String dept;        //部门信息
	private String job;        //部门信息
	private String deptName;   //部门名字
	private String jobName;   //职位
	
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDept_id() {
		return dept_id;
	}
	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}
	public Integer getJob_id() {
		return job_id;
	}
	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq_num() {
		return qq_num;
	}
	public void setQq_num(String qq_num) {
		this.qq_num = qq_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", dept=" + dept_id + ", job=" + dept_id
				+ ", name=" + name + ", cardId=" + cardId + ", address="
				+ address + ", postCode=" + postCode + ", tel=" + tel
				+ ", phone=" + phone + ", qq_num=" + qq_num + ", email=" + email
				+ "]";
	}

}
