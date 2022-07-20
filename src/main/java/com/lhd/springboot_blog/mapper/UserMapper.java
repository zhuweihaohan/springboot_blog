package com.lhd.springboot_blog.mapper;

import com.lhd.springboot_blog.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
	/**
	 * 根据用户名和密码登录
	 * @param userName 账号
	 * @param userPass 密码
	 * @return 用户信息
	 */
	@Select("select * from user where user_name= #{userName} and user_pass=#{userPass} and user_status>0 limit 1")
	User login(@Param("userName") String userName,@Param("userPass") String userPass);
	@Update("update user set user_last_login_time=NOW() where user_name= #{userName} and user_pass=#{userPass} and user_status>0")
	void lastLogin(@Param("userName") String userName,@Param("userPass") String userPass);
	@Insert("INSERT INTO user (user_name,user_nickname,user_email,user_pass,user_register_time) VALUES(#{userName},#{userNickname},#{userEmail},#{userPass},NOW());")
	int Register(@Param("userName") String userName,@Param("userNickname") String userNickname,@Param("userEmail") String userEmail,@Param("userPass") String userPass);



	@Insert("insert into   user (user_id,user_name,user_pass,user_nickname,user_email,user_url,"
			+"user_avatar,user_last_login_ip,user_register_time," +
			"user_last_login_time, user_status)" +
			" values (#{userId}, #{userName}, #{userPass}," +
			"#{userNickname}, #{userEmail}, #{userUrl}," +
			"#{userAvatar}, #{userLastLoginIp}, #{userRegisterTime}," +
			"#{userLastLoginTime}, #{userStatus})")
	void addUser(User user);
	@Select("select * from user")
	List<User> listUser();
	@Select("select * from user where user_name= #{userName}")
	User getUserByName(@Param("userName") String userName);
	@Select("select * from user where user_id= #{userId}")
	User getUserById(@Param("userId") Integer userId);

	@Delete("delete from user where user_id=#{id}")
	void deleteById(Integer id);

	@Update("update user set user_name=#{userName},user_pass=#{userPass},user_nickname=#{userNickname},user_email=#{userEmail},user_url=#{userUrl} where user_id=#{userId}")
	void update(User user);
}
