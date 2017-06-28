package com.sshibernate.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sshibernate.mvc.domain.IdCard;
import com.sshibernate.mvc.domain.Person;
import com.sshibernate.mvc.service.IIdCardService;
import com.sshibernate.mvc.service.IPersonService;

@Controller
@RequestMapping(value="/personid")
public class PersonController {
	@Autowired
	private IPersonService personService;
	
	@RequestMapping(value="/test01",method=RequestMethod.POST)
	public String addPersonTransactionTest(@RequestParam(value="name") String name,
			@RequestParam(value="nation") String nation){
		Person person = new Person(name, nation);
		personService.addPerson(person);
		return "home";
	}
	
	public IPersonService getPersonService() {
		return personService;
	}
	
	public void setPersonService(IPersonService personService) {
		System.out.println("依赖注入了------------------");
		this.personService = personService;
	}
}
