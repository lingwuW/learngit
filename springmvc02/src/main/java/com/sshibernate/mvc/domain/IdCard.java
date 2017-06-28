package com.sshibernate.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="idcard_tab")
public class IdCard {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String number;
	/**
	 * @ManyToOne
	 * */
	@ManyToOne(targetEntity=Person.class)
	@JoinColumn(name="personid",unique=true)
	private Person person;
	public IdCard() {
		super();
	}
	
	public IdCard(String number) {
		super();
		this.number = number;
	}

	public IdCard(int id, String number, Person person) {
		super();
		this.id = id;
		this.number = number;
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
