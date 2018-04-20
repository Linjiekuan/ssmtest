package com.ljk.service;
import java.util.List;
import com.ljk.yc.*;
public interface UserService {
	/**
	 * 登陆验证函数
	 * 
	 * */
	public User login(String username, String password);

	/**
	 * 用户注册函数
	 * 
	 * */
	public void addUser(User user);
	
	/**
     * 获取用户 + 分页 + 筛选
     * @param pageNo 页码
     * @param size 页的大小
     * @param search_name 按姓名匹配
     * @param search_account 按账号匹配
     * @return
     */
    public List<User> getAllUsers(int pageNo, int size, String usename, String password);   
    /**
     * 用户数量
     * @return
     */
    public int getCount(String usename, String password);
    
    /**
     * 更新用户
     * @return
     */
    public int updateUser(User user);
    /**
     * 删除用户
     * @return
     */
    public int deleteUserById(int id);
    
    /**
	 * 验证用户名注册函数
	 * 
	 * */
    public int checkByName(String username);
    /**
	 * 验证用户邮箱注册函数
	 * 
	 * */
    public int checkByEmail(String username);
    //找回密码
    public int findPassword(String email , String password);
}