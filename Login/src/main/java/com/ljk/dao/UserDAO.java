package com.ljk.dao;
import com.ljk.yc.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
//import org.springframework.stereotype.Service;
import java.util.List;

@Repository
public interface UserDAO {
	// 验证登陆
	public User selectByName(@Param("username") String username, @Param("password") String password);

	// 注册
	void add(User user);
	// void add( @Param("username") String username, @Param("password") String
	// password, @Param("loginname") String loginname);
	// 取全部用户 + 分页 + 按条件匹配
	public List<User> getAllUsers(@Param("skip") int skip, @Param("size") int size, @Param("username") String username,
			@Param("password") String password);

	// 用户数量，分页需要
	public int getCount(@Param("username") String username, @Param("password") String password);

	// 更新用户
	public int updateUser(User user);

	// 删除
	public int deleteUserById(int id);
	//异步验证注册账号可不可以注册
	public int checkByName(String username);
	//异步验证注册邮箱可不可以注册
	public int checkByEmail(String email);
	//找回密码时候的修改密码
	public int findPassword(@Param("email")String email,@Param("password")String password);
}