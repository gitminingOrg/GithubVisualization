package org.gitmining.service;

import java.util.List;
import java.util.Map;

import org.gitmining.bean.History;
import org.gitmining.bean.Repository;
import org.gitmining.bean.SimpleRepo;

public interface RepoDataService {
	public List<SimpleRepo> searchRepo(String name);
	public Repository getRepositoryById(int id);
	public Map<String,Integer> getRepositoryScoreById(int id);
	public Map<String,List> relatedRepos(Repository repository);
	public History getRepositoryHistory(int id);
}
