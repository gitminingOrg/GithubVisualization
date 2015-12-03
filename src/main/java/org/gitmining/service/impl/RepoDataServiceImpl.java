package org.gitmining.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.gitmining.bean.RepoTagPair;
import org.gitmining.bean.Repository;
import org.gitmining.bean.SimpleRepo;
import org.gitmining.dao.RepositoryDao;
import org.gitmining.service.RepoDataService;

public class RepoDataServiceImpl implements RepoDataService {
	
	private RepositoryDao repositoryDao;
	public RepositoryDao getRepositoryDao() {
		return repositoryDao;
	}
	public void setRepositoryDao(RepositoryDao repositoryDao) {
		this.repositoryDao = repositoryDao;
	}

	@Override
	public List<SimpleRepo> searchRepo(String name) {
		// TODO Auto-generated method stub
		String pattern = "%"+name+"%";
		return repositoryDao.searchRepos(pattern);
	}
	@Override
	public Repository getRepositoryById(int id) {
		return repositoryDao.getRepositoryById(id);
	}
	@Override
	public Map<String,Integer> getRepositoryScoreById(int id){
		// TODO Auto-generated method stub
		return getRepositoryScoreByIdStub();
	}
	@Override
	public Map<String, List> relatedRepos(int id) {
		// TODO Auto-generated method stub
		Map<String, List> result = new TreeMap<String, List>();
		result.put("tag", getRelatedTagRepos(id));
		result.put("owner", getRelatedOwnerRepos(id));
		result.put("viewer", getRelatedOwnerRepos(id));
		return result;
	}
	
	public List<Repository> getRelatedTagRepos(int id){
		return getRelatedReposStub();
	}
	
	public List<Repository> getRelatedOwnerRepos(int id){
		return getRelatedReposStub();
	}
	public List<Repository> getRelatedViewerRepos(int id){
		return getRelatedReposStub();
	}
	public List<Repository> getRelatedReposStub(){
		List<Repository> repositories = new ArrayList<Repository>();
		for (int i = 0; i < 10; i++) {
			Repository repository = new Repository();
			repository.setId(i+1);
			repository.setFull_name("repo"+(i+1));
			repositories.add(repository);
		}
		
		return repositories;		
	}
	
	public Map<String,Integer> getRepositoryScoreByIdStub(){
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("hot", 88);
		map.put("mature", 70);
		map.put("popular", 95);
		map.put("size", 66);
		map.put("contributor", 77);
		map.put("total", 90);
		return map;
	}
	/**
	 * calculate the similarity metrix of repos by tag
	 */
	public void calculateRepoSimilarity(){
		//get all tags of each repo
		List<RepoTagPair> repoTagPairs = repositoryDao.getAllRepoTagPairs();
		Map<Integer,List<Integer>> repoTagMap = new HashMap<Integer, List<Integer>>();
		for (RepoTagPair repoTagPair : repoTagPairs) {
			if(!repoTagMap.containsKey(repoTagPair.getRepo_id())){
				List<Integer> list = new ArrayList<Integer>();
				list.add(repoTagPair.getTag_id());
				repoTagMap.put(repoTagPair.getRepo_id(), list);
			}else{
				List<Integer> list = repoTagMap.get(repoTagPair.getRepo_id());
				list.add(repoTagPair.getTag_id());
			}
		}
		
		//compare tags of different repos
		int[][] matrix = new int[30000][30000];
		Set<Integer> keySet = repoTagMap.keySet();
		for (Integer integer : keySet) {
			List<Integer> values1 = repoTagMap.get(integer);
			for (Integer integer2 : keySet) {
				List<Integer> values2 = repoTagMap.get(integer2);
				for (int i=0; i< values2.size(); i++) {
					if(values2.get(i) == values1.get(i)){
						matrix[integer][integer2]++;
						matrix[integer2][integer]++;
					}
				}
			}
		}
	}
}
