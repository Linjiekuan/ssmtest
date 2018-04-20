package com.ljk.dao;

import org.apache.ibatis.annotations.Param;

import com.ljk.yc.User;

public interface LoginRegisterDAO {
	// 验证登陆
		public User selectByName(@Param("username") String username, @Param("password") String password);

		// 注册
		void add(User user);
		//异步验证注册账号可不可以注册
		public int checkByName(String username);

}
