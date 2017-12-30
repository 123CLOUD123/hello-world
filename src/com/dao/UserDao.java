package com.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.entity.User;

public class UserDao extends HibernateDaoSupport{
	//添加用户
	public void addUser(User user){
		this.getHibernateTemplate().save(user);
	}
	//查询所有用户
	public List<User> getUsers(){
		return (List<User>) this.getHibernateTemplate().find("from User");
	}
	//删除用户
	public void deleteUser(User user){
		this.getHibernateTemplate().delete(user);
	}
	//ID取得用户
	public User getUserById(int id){
		return this.getHibernateTemplate().get(User.class, id);
	}
	//更新
	public void updateUser(User user){
		this.getHibernateTemplate().update(user);
	}
}
