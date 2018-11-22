package com.ljk.service;

import java.util.List;

import com.ljk.yc.Users;


public interface UsersService {  
    /**
     * 获取用户 + 分页 + 筛选
     * @param pageNo 页码
     * @param size 页的大小
     * @param search_name 按姓名匹配
     * @param search_account 按账号匹配
     * @return
     */
	void saveUser(Users user);

    boolean updateUser(Users user);

    boolean deleteUser(int id);

    Users findUserById(int id);

    List<Users> findAll();
}