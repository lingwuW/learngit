package com.sshibernate.mvc.dao;

import java.util.List;

import com.sshibernate.mvc.domain.User;

public interface IUserMapper {
	
	public User findUserById(int id);
	
	/**
	 * 這裡@Param註解不能注釋應用變量，否則Spring不能解析
	 * */
	public void addUser(User user);
	
	public void deleteUser(int id);
	
	public void updateUser(User user);
	
	public List<User> findAllUsers();
}
