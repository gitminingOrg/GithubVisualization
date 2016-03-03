package org.gitmining.service;

import java.util.List;
import java.util.Map;

import org.gitmining.bean.History;
import org.gitmining.bean.Language;
import org.gitmining.bean.Repository;
import org.gitmining.bean.SimpleRepo;

public interface RepoDataService {
	public List<SimpleRepo> searchRepo(String name);
	public Repository getRepositoryById(int id);
	public Map<String,Integer> getRepositoryScoreById(int id);
	public Map<String,List> relatedRepos(Repository repository);
	public History getRepositoryHistory(int id);
	/**
	 * get statistics of repo languages and so on 
	 * @param type
	 * @return
	 */
	public Map<String, List> getStatCounts(String type);
	public Map<String, Integer> getLanguageAndNumber();
	public List<String> getRepoCreateTime();
	public List<Integer> getContributorNumber();
	public List<Integer> getCollaboratorNumber();
}
