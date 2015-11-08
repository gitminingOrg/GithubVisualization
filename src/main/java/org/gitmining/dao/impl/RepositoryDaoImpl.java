package org.gitmining.dao.impl;

import java.util.List;

import org.gitmining.bean.SimpleRepo;
import org.gitmining.dao.RepositoryDao;

public class RepositoryDaoImpl extends BaseDaoImpl implements RepositoryDao {

	@Override
	public List<SimpleRepo> searchRepos(String pattern) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("repo.searchRepo",pattern);
	}

}
