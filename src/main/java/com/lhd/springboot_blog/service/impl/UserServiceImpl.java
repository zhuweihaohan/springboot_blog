package com.lhd.springboot_blog.service.impl;


import com.lhd.springboot_blog.entity.User;
import com.lhd.springboot_blog.mapper.UserMapper;
import com.lhd.springboot_blog.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;	
	@Override
    public User login(String userName, String userPass) {
		User user=userMapper.login(userName, userPass);
		 if(user!=null)
		 {	 userMapper.lastLogin(userName, userPass);
		 return user;
		 }
		 else
			 return null;
	}
	
	public void  Register(String userName, String userNickname, String userEmail, String userPass) {
		userMapper.Register(userName, userNickname, userEmail, userPass);
		
		
	}

	public User getUserByName(String userName) {
		
		return userMapper.getUserByName(userName);
	}

	
	public void addUser(User user) {
		userMapper.addUser(user);		
	}


	public List<User> listUser() {
		
		return userMapper.listUser();
	}

	
	public User getUserById(Integer id) {
		
		return userMapper.getUserById(id);
	}

	
	public void deleteById(Integer id) {
	userMapper.deleteById(id);
		
	}

	
	public void update(User user) {
		userMapper.update(user);
		
	}

	

}
