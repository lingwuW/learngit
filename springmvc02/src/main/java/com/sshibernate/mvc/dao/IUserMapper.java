package com.sshibernate.mvc.dao;

import java.util.List;

import com.sshibernate.mvc.domain.User;

public interface IUserMapper {
	
	public User findUserById(int id);
	
	/**
	 * �@�e@Param�]�ⲻ��ע጑���׃������tSpring���ܽ���
	 * */
	public void addUser(User user);
	
	public void deleteUser(int id);
	
	public void updateUser(User user);
	
	public List<User> findAllUsers();
}
