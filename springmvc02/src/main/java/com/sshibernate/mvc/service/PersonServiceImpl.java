package com.sshibernate.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sshibernate.mvc.dao.IPersonDao;
import com.sshibernate.mvc.domain.IdCard;
import com.sshibernate.mvc.domain.Person;
@Service
@Transactional
public class PersonServiceImpl implements IPersonService {
	@Autowired
	private IPersonDao personDao;
	
	@Autowired
	private IIdCardService idCardService;
	
	public IPersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(IPersonDao personDao) {
		this.personDao = personDao;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			transactionManager="transactionManager",
			rollbackFor=NullPointerException.class)
	@Override
	public void addPerson(Person person) {
		personDao.addPerson(person);
		IdCard idCard = new IdCard("5555555555555");
		idCardService.addIdCard(idCard);
	}

	public IIdCardService getIdCardService() {
		return idCardService;
	}

	public void setIdCardService(IIdCardService idCardService) {
		System.out.println("依赖注入了+++++++++");
		this.idCardService = idCardService;
	}

}
