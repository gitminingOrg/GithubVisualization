package org.gitmining.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import net.spy.memcached.MemcachedClient;

import org.gitmining.bean.Event;
import org.gitmining.bean.History;
import org.gitmining.bean.RepoPairRelation;
import org.gitmining.bean.RepoScore;
import org.gitmining.bean.RepoTagPair;
import org.gitmining.bean.Repository;
import org.gitmining.bean.SimpleRepo;
import org.gitmining.dao.RepositoryDao;
import org.gitmining.service.RepoDataService;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class RepoDataServiceImpl implements RepoDataService {
	
	private RepositoryDao repositoryDao;
	private MemcachedClient memcachedClient;
	public MemcachedClient getMemcachedClient() {
		return memcachedClient;
	}
	public void setMemcachedClient(MemcachedClient memcachedClient) {
		this.memcachedClient = memcachedClient;
	}
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
	//	RepoScore repoScore = repositoryDao.getRepoScoreById(id);
		return getRepositoryScoreByIdStub();
	}
	@Override
	public Map<String, List> relatedRepos(Repository repository) {
		// TODO Auto-generated method stub
		Map<String, List> result = new TreeMap<String, List>();
		result.put("tag", getRelatedTagRepos(repository.getId()));
		result.put("owner", getRelatedOwnerRepos(repository));
		result.put("viewer", getRelatedViewerRepos(repository.getId()));
		return result;
	}
	@Override
	public History getRepositoryHistory(int id) {
		// TODO Auto-generated method stub
		History history = new History();
		history.setId("History of Repository");
		history.setTitle("History of Repository");
		history.setFocus_date("2015-07-01 12:00");
		history.setColor("#82530d");
		history.setInitial_zoom(45);
		history.setSize_importance("true");
		List<Event> events = new ArrayList<Event>();
		Event event = new Event();
		event.setDescription("description of repo"+id);
		event.setEnddate("2015-07-01 12:00");
		event.setHigh_threshold(60);
		event.setLow_threshold(1);
		event.setImportance(45);
		event.setId(1);
		event.setSlug("");
		event.setStartdate("2015-08-01 12:00");
		event.setTitle("title");
		event.setYpix(0);
		events.add(event);
		history.setEvents(events);
		return history;
	}
	public List<Repository> getRelatedTagRepos(int id){
	
		List<RepoPairRelation> related = repositoryDao.getSimilarRepoPairRelation(id);
		ArrayList<Repository> relatedRepository = new ArrayList<Repository>();
		
		for (int index = 0; index < 5; index++) {
			int rid = related.get(index).getRepo_relate_id();
			Repository repository = repositoryDao.getRepositoryById(rid);
			relatedRepository.add(repository);
		}
		
		return relatedRepository;
	}
	
	public List<Repository> getRelatedOwnerRepos(Repository repository){
		List<Repository> repositories = repositoryDao.getRepositoryByOwnerName(repository.getOwner_name());
		repositories.remove(repository);
		return repositories;
	}
	public List<Repository> getRelatedViewerRepos(int id){
		return getRelatedReposStub();
	}
	public List<Repository> getRelatedReposStub(){
		List<Repository> repositories = new ArrayList<Repository>();
		for (int i = 0; i < 5; i++) {
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

}
