package org.gitmining.bean;

public class RepoPairRelation {
	int repo_id;
	int repo_relate_id;
	int relation_score;
	public int getRepo_id() {
		return repo_id;
	}
	public void setRepo_id(int repo_id) {
		this.repo_id = repo_id;
	}
	public int getRepo_relate_id() {
		return repo_relate_id;
	}
	public void setRepo_relate_id(int repo_relate_id) {
		this.repo_relate_id = repo_relate_id;
	}
	public int getRelation_score() {
		return relation_score;
	}
	public void setRelation_score(int relation_score) {
		this.relation_score = relation_score;
	}
}
