package com.ljk.service;
import com.ljk.dao.*;
import com.ljk.yc.*;
import com.ljk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import java.util.List;
import java.util.HashMap;
@Service("userService")
public class UserServiceImpl implements UserService  {
	@Autowired 
    UserDAO userdao;
	//登陆验证
	public User login(String username,String password) {
      return userdao.selectByName(username, password);
    }
    //添加用户
	public void addUser(User user){
		userdao.add(user);
		
	}
	 //获取用户 + 分页 + 按账号姓名匹配
    public List<User> getAllUsers(int pageNo, int size, String username, String password) {
        // TODO Auto-generated method stub
        return userdao.getAllUsers((pageNo-1)*size, size, "%"+username+"%", "%"+password+"%");
    }
    
  //获取用户数量 + 按账号姓名匹配
    public int getCount(String username, String password) {
        // TODO Auto-generated method stub
        return userdao.getCount("%"+username+"%", "%"+password+"%");
    }
    //更新用户
    public int updateUser(User user){
    	return userdao.updateUser(user);
    }
    //删除用户
    public int deleteUserById(int id){
    	return userdao.deleteUserById(id);
    }
    //异步验证注册的账号名
    public int checkByName(String username){
    	return userdao.checkByName(username);
    }
  //异步验证注册的邮箱
    public int checkByEmail(String email){
    	return userdao.checkByEmail(email);
    }
	public int findPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userdao.findPassword(email, password);
	}
}
