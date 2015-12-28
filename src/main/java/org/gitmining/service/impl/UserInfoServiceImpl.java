package org.gitmining.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.spy.memcached.MemcachedClient;

import org.gitmining.bean.Repository;
import org.gitmining.bean.User;
import org.gitmining.bean.UserScore;
import org.gitmining.dao.RepositoryDao;
import org.gitmining.dao.UserDao;
import org.gitmining.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	UserDao userDao;
	RepositoryDao repositoryDao;
	MemcachedClient MemcachedClient;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public RepositoryDao getRepositoryDao() {
		return repositoryDao;
	}

	public void setRepositoryDao(RepositoryDao repositoryDao) {
		this.repositoryDao = repositoryDao;
	}

	public MemcachedClient getMemcachedClient() {
		return MemcachedClient;
	}

	public void setMemcachedClient(MemcachedClient memcachedClient) {
		MemcachedClient = memcachedClient;
	}

	@Override
	public User getUserInfo(int id) {
		// TODO Auto-generated method stub
		return userDao.selectUserById(id);
	}

	@Override
	public Map getUserScore(int id) {
		// TODO Auto-generated method stub
		UserScore userScore = userDao.selectUserScoreById(id);
		Map<String, Integer> scores = new HashMap<String, Integer>();
//		scores.put("efficiency", userScore.getEfficiency_score());
//		scores.put("quantity", userScore.getQuantity_score());
//		scores.put("total", userScore.getTotal_score());
		scores.put("efficiency", 78);
		scores.put("quantity", 69);
		scores.put("total", 76);
		return scores;
	}

	@Override
	public Map getRecommendRepos(User user) {
		// TODO Auto-generated method stub
		Map<String, List> result = new HashMap<String, List>();
		List<Repository> repositories = repositoryDao.getRepositoryByOwnerName(user.getLogin());
		List<Repository> contriRepositories = repositoryDao.getContributedRepoByUserId(user.getId());
		result.put("own_repo", repositories);
		result.put("contri_repo", contriRepositories);
		return result;
	}

	@Override
	public List<User> getTop20Users() {
		// TODO Auto-generated method stub
		
		return getTop20UsersStub();
	}
	
	public List<User> getTop20UsersStub(){
		List<User> users = userDao.selectTOP20Users();
		
		return users;
	}

}
