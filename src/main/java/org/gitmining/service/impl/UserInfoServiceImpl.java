package org.gitmining.service.impl;

import java.util.Map;

import net.spy.memcached.MemcachedClient;

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
		return null;
	}

	@Override
	public UserScore getUserScore(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getRecommendRepos(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
