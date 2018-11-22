package com.ljk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ljk.yc.Users;


@Repository
public interface UsersDAO {
	 void saveUser(Users user);

	    boolean updateUser(Users user);

	    boolean deleteUser(int id);

	    Users findUserById(int id);

	    List<Users> findAll();
	}