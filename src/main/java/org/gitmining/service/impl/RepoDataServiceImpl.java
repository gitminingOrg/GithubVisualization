package org.gitmining.service.impl;

import java.util.List;

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

}
