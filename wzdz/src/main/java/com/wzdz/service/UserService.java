package com.wzdz.service;

import com.wzdz.entity.User;



public interface UserService {
	User findUserByUserName(String userName);
	int insertUser(User user);
	int updateUserSetUserPicture(String picture,String mobile);
	int modifyPassword(String mobile,String nPsw);
	int updateUser(User user);
	int modifyMobile(String mobile,String oMobile);
	int forgetPassword(String mobile,String nPsw);
	//密码更新
//	int updatePwd(User userSession, String oldPwd, String newPwd);
}
