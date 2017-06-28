package com.sshibernate.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sshibernate.mvc.domain.User;
/**
 * ��ʶ����һ����spring IOC����Ľ���������ע����ࣻ
 * ע��service��@Autowired private IUserMapper userMapper;
 * ��@serviceע����һ����
 * 
 * Mybatis����û���õ����ע�⣬��Ϊ��û��DAO��ʵ���ֻ࣬���ýӿڶ�̬���ɴ������
 * */
@Repository
public class UserDaoImpl implements IUserMapper {
	
	/*@Autowired
	private HibernateTemplate hibernateTemplate;*/
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public User findUserById(int id) {
		User user=(User) sessionFactory.getCurrentSession().get(User.class, 1);
		System.out.println("user:"+user);
		
		return user;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	/*public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}*/
	
}
