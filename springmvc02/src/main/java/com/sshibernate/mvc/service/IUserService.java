package com.sshibernate.mvc.service;

import com.sshibernate.mvc.domain.User;


public interface IUserService {
	
	public User findUserById(int id);
}
