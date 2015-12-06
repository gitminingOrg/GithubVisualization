package org.gitmining.dao.impl;

import java.util.List;

import org.gitmining.bean.RepoTagPair;
import org.gitmining.bean.Repository;
import org.gitmining.bean.SimpleRepo;
import org.gitmining.dao.RepositoryDao;

public class RepositoryDaoImpl extends BaseDaoImpl implements RepositoryDao {

	@Override
	public List<SimpleRepo> searchRepos(String pattern) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("repo.searchRepo",pattern);
	}

	@Override
	public Repository getRepositoryById(int id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("repo.searchRepoById", id);
	}

	@Override
	public Repository getRepositoryByName(String name) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("repo.searchRepoByName", name);
	}

	@Override
	public List<RepoTagPair> getAllRepoTagPairs() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("repo.getAllRepoTagPair");
	}

	@Override
	public List<RepoTagPair> getRepoTagPairsByTagID(int tid) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("repo.getRepoTagPairsByName", tid);
	}

}
