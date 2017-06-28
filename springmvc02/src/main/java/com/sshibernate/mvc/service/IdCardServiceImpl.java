package com.sshibernate.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sshibernate.mvc.dao.IIdcardDao;
import com.sshibernate.mvc.domain.IdCard;
@Service
public class IdCardServiceImpl implements IIdCardService {
	
	@Autowired
	private IIdcardDao idCardDao;
	
	public IIdcardDao getIdCardDao() {
		return idCardDao;
	}

	public void setIdCardDao(IIdcardDao idCardDao) {
		this.idCardDao = idCardDao;
	}
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			transactionManager="transactionManager",
			rollbackFor=NullPointerException.class)
	@Override
	public void addIdCard(IdCard idcard) {
		idCardDao.addIdCard(idcard);
	}

}
