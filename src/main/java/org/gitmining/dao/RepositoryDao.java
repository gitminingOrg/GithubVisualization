package org.gitmining.dao;
import java.util.*;

import org.gitmining.bean.RepoScore;
import org.gitmining.bean.RepoTagPair;
import org.gitmining.bean.Repository;
import org.gitmining.bean.SimpleRepo;
public interface RepositoryDao {
	public	List<SimpleRepo> searchRepos(String pattern);
	public	SimpleRepo searchSimpleRepoById(int id);
	public	Repository getRepositoryById(int id);
	public RepoScore getRepoScoreById(int repo_id);
	public	Repository getRepositoryByName(String name);
	public List<RepoTagPair> getAllRepoTagPairs();
	public List<Repository> getRepositoryByOwnerName(String owner_name);
}
