package com.wzdz.dao;

import org.apache.ibatis.annotations.Param;

import com.wzdz.entity.User;


public interface UserDao {
	User findUserByUserName(@Param("userName")String userName);
	int insertUser(User user);
	int updateUserSetUserPicture(@Param("picture")String picture,@Param("mobile")String mobile);
	int modifyPassword(@Param("mobile")String mobile,@Param("nPsw")String nPsw);
	int updateUser(User user);
	int modifyMobile(@Param("mobile")String mobile,@Param("oMobile")String oMobile);
	int forgetPassword(@Param("mobile")String mobile,@Param("nPsw")String nPsw);
	/**
	 * 更新 账号  密码
	 * @param model
	 */
//	@Update("update user set upwd=#{mdl.upwd}, password=#{mdl.password}  "
//			+ "WHERE ID=#{mdl.id}")
//	public int updatePwd(@Param("user")User user);
	public int updatePwd(User user);
	
}
