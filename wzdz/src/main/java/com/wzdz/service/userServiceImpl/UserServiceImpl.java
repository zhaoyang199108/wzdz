package com.wzdz.service.userServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.UserDao;
import com.wzdz.entity.User;
import com.wzdz.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	private @Autowired UserDao userDao;
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}
	public int updateUserSetUserPicture(String picture,String mobile) {
		return userDao.updateUserSetUserPicture(picture,mobile);
	}
	public int modifyPassword(String mobile, String nPsw) {
		return userDao.modifyPassword(mobile,nPsw);
	}
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}
	public int modifyMobile(String mobile,String oMobile) {
		// TODO Auto-generated method stub
		return userDao.modifyMobile(mobile,oMobile);
	}
	public int forgetPassword(String mobile, String nPsw) {
		// TODO Auto-generated method stub
		return userDao.forgetPassword(mobile, nPsw);
	}
	

}
