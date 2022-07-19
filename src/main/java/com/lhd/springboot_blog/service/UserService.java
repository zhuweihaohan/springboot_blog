package com.lhd.springboot_blog.service;

import com.lhd.springboot_blog.entity.User;

import java.util.List;

public interface UserService {
	/**
	 * 根据用户名和密码登录
	 * @param userName 账号
	 * @param userPass 密码
	 * @return 用户信息
	 */
	User login( String userName, String userPass);
	/**
	 * 注册用户
	 * @param userName
	 * @param userNickname
	 * @param userEmail
	 * @param userPass
	 * @return
	 */
	void Register(String userName,String userNickname,String userEmail,String userPass);
	User getUserByName(String userName);
	void addUser(User user);

	List<User> listUser();
	User getUserById(Integer id);
	void deleteById(Integer id);
	void update(User user);
}