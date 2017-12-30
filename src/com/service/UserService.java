package com.service;

import java.util.List;

import com.dao.UserDao;
import com.entity.User;

public class UserService {
	//����UserDao���ԣ�ʵ����֮��Э��
	private UserDao userDao;
	UserService(){}
	UserService(UserDao userDao){this.userDao=userDao;}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	//�����ݿ�������û�
	public void addUser(User user){
		if(user==null)
			return;
		if(userDao.getUserById(user.getId())!=null)
			return;
		userDao.addUser(user);
	}
	//�����ݿ�ɾ���û�
	public void deleteUser(User user){
		if(user==null)
			return;
		if(user.getId()==0)
			return;
		userDao.deleteUser(user);
	}
	//��ȡ�����û�
	public List<User> getAllUsers(){
		return userDao.getUsers();
	}
	//����id����û�
	public User getUserById(int id){
		return userDao.getUserById(id);
	}
	//�������ݿ�
	public void updateUser(User user){
		if(user==null)
			return;
		userDao.updateUser(user);
	}
}











