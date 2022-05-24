package com.javaex.phone;

public class PersonVo {

	//필드
	private String name;
	private String hp;
	private String company;
	private int personId;
	
	//생성자
	public PersonVo() {}
	
	public PersonVo(int personId) {
		super();
		this.personId = personId;
	}

	public PersonVo(String name, String hp, String company) {
		super();
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	public PersonVo(int personId, String name, String hp, String company) {
		super();
		this.personId = personId;
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	
	public PersonVo(String name, String hp, String company, int personId) {
		super();
		this.name = name;
		this.hp = hp;
		this.company = company;
		this.personId = personId;
	}
	
	
	//메소드 - gs
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setPhone(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	//메소드 - 일반
	@Override
	public String toString() {
		return "PersonVo [name=" + name + ", phone=" + hp + ", company=" + company + "]";
	}

	
	
	
	
}
