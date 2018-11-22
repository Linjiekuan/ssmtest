package com.ljk.yc;

import java.util.Date;

public class Users {

	private Integer id;
	private String username;
	private String loginname;
	private String password;
	private Integer status;
	private Date createDate;
	private String email;
    
    
    public Users() {
        super();
    }

    public Users(int id, String name, String account,String phone,String email,String address,String password) {
        super();
        this.id = id;
        this.username = username;
        this.loginname = loginname;
        this.password = password;
        this.status = status;
        this.createDate = createDate;
        this.email = email;
        
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    
}