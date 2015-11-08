package org.gitmining.bean;

public class SimpleRepo {
	private int id;
	private String full_name;
	private String owner_name;
	private String description;
	private String update_time;
	private String language;
	private int stargazers;
	private int fork_num;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getStargazers() {
		return stargazers;
	}
	public void setStargazers(int stargazers) {
		this.stargazers = stargazers;
	}
	public int getFork_num() {
		return fork_num;
	}
	public void setFork_num(int fork_num) {
		this.fork_num = fork_num;
	}
	
	
}
