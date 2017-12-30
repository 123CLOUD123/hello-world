package com.service;

import java.util.List;

import com.dao.UserDao;
import com.entity.User;

public class UserService {
	//定义UserDao属性，实现类之间协作
	private UserDao userDao;
	UserService(){}
	UserService(UserDao userDao){this.userDao=userDao;}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	//往数据库中添加用户
	public void addUser(User user){
		if(user==null)
			return;
		if(userDao.getUserById(user.getId())!=null)
			return;
		userDao.addUser(user);
	}
	//从数据库删除用户
	public void deleteUser(User user){
		if(user==null)
			return;
		if(user.getId()==0)
			return;
		userDao.deleteUser(user);
	}
	//获取所有用户
	public List<User> getAllUsers(){
		return userDao.getUsers();
	}
	//根据id获得用户
	public User getUserById(int id){
		return userDao.getUserById(id);
	}
	//更新数据库
	public void updateUser(User user){
		if(user==null)
			return;
		userDao.updateUser(user);
	}
}











