package org.gitmining.bean;

public class Orgnization {
	private int id;
	private String login;
	private String name;
	private String company;
	private int member_count;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getMember_count() {
		return member_count;
	}
	public void setMember_count(int member_count) {
		this.member_count = member_count;
	}
	public Orgnization(int id, String login, String name, String company,
			int member_count) {
		super();
		this.id = id;
		this.login = login;
		this.name = name;
		this.company = company;
		this.member_count = member_count;
	}
	
}
