package com.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.entity.User;

public class UserDao extends HibernateDaoSupport{
	//����û�
	public void addUser(User user){
		this.getHibernateTemplate().save(user);
	}
	//��ѯ�����û�
	public List<User> getUsers(){
		return (List<User>) this.getHibernateTemplate().find("from User");
	}
	//ɾ���û�
	public void deleteUser(User user){
		this.getHibernateTemplate().delete(user);
	}
	//IDȡ���û�
	public User getUserById(int id){
		return this.getHibernateTemplate().get(User.class, id);
	}
	//����
	public void updateUser(User user){
		this.getHibernateTemplate().update(user);
	}
}
