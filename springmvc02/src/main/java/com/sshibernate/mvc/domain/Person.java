package com.sshibernate.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="t_person")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	
	@Column
	private String nation;
	/**
	 *targetEntity=IdCard.class,mappedBy="person"我认为是告诉计算机，
	 *这个字段值参考IdCard类的person属性值来设置
	 *
	 * 在1-1外键关联 注解 场景这里
	 * 如果不设置mappedBy，在执行Person的插入操作的时候，会去维护一个与IdCard类中personid列一样为certification_id的字段/列。
	 * 如果设置了mappedBy，就不存在上述问题了。
	 * 大家可能会觉得：这与之前讲解1-n那里不使用mappedBy会需要中间表的情况不一样
	 * 但是，实际上是一样的，不管是需要1-n需要中间表，还是1-1这里需要一个多余的外键字段，都是Hibernate默认情况下
	 * 希望当前类要维护和另外一方的关系。但是实际上我们不需要中间表，也不需要多余的外键字段，因此，使用mappedBy让
	 * 另一个来维护它们之间的关系，当前这个类不负责维护关系。
	 * */
	@OneToOne(targetEntity=IdCard.class,mappedBy="person")
	@Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	private IdCard  idCard;
	public Person() {
		super();
	}
	
	public Person(String name, String nation) {
		super();
		this.name = name;
		this.nation = nation;
	}

	public Person(int id, String name, String nation, IdCard idCard) {
		super();
		this.id = id;
		this.name = name;
		this.nation = nation;
		this.idCard = idCard;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}
	
	
}
