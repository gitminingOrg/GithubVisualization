package org.gitmining.bean;

public class Language {
	private int id;
	private int repo_id;
	private String language;
	private int count;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRepo_id() {
		return repo_id;
	}
	public void setRepo_id(int repo_id) {
		this.repo_id = repo_id;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
