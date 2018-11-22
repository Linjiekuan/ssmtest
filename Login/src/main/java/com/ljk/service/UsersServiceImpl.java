package com.ljk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ljk.dao.UsersDAO;
import com.ljk.yc.Users;


@Service
public class UsersServiceImpl implements UsersService{
    /**
     * 注入UserMapper接口
     */
    @Autowired
    private UsersDAO userMapper;

    /**
     * 新增用户
     */
    public void saveUser(Users user) {
        userMapper.saveUser(user);
    }

    /**
     * 更新用户
     */
 
    public boolean updateUser(Users user) {
        return userMapper.updateUser(user);
    }

    /**
     * 根据Id删除用户
     */
    public boolean deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    /**
     * 根据id查找用户
     */
    public Users findUserById(int id) {
        Users user = userMapper.findUserById(id);
        return user;
    }

    /**
     * 查询所有用户
     */

    public List<Users> findAll() {
        List<Users> allUser = userMapper.findAll();
        return allUser;
    }

}