package org.gitmining.bean;

public class RepoTagPair {
	private int id;
	private int repo_id;
	private int tag_id;
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
	public int getTag_id() {
		return tag_id;
	}
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	
}
