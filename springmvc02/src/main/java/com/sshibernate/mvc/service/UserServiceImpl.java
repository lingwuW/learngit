package com.sshibernate.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sshibernate.mvc.dao.IUserMapper;
import com.sshibernate.mvc.domain.User;


@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserMapper userMapper;
	
	public IUserMapper getUserMapper() {
		return userMapper;
	}
	public void setUserMapper(IUserMapper userMapper) {
		this.userMapper = userMapper;
	}
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			transactionManager="transactionManager",
			rollbackFor=java.lang.NullPointerException.class)
	@Override
	public User findUserById(int id) {
		
		User user=userMapper.findUserById(id);
		return user;
	}

}
