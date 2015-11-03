package org.gitmining.bean;

public class Organization {
	private int id;
	private String login;
	private String name;
	private String company;
	private int member_count;
	private int repo_count;
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
	
	public int getRepo_count() {
		return repo_count;
	}
	public void setRepo_count(int repo_count) {
		this.repo_count = repo_count;
	}
}
