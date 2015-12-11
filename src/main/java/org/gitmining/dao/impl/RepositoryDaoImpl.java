package org.gitmining.dao.impl;

import java.util.List;
import java.util.Map;

import org.gitmining.bean.MultiTag;
import org.gitmining.bean.RepoPairRelation;
import org.gitmining.bean.RepoScore;
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
		return sqlSession.selectList("repo.getRepoTagPairsByTagID", tid);
	}
	
	@Override
	public List<Repository> getRepositoryByOwnerName(String owner_name) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("repo.searchRepoByOwnerName", owner_name);
	}

	@Override
	public RepoScore getRepoScoreById(int repo_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("repo.searchRepoScoreById", repo_id);
	}

	@Override
	public SimpleRepo searchSimpleRepoById(int id) {
		// TODO Auto-generated method stub	
		return sqlSession.selectOne("repo.searchSimpleRepoById", id);
	}

	@Override
	public List<SimpleRepo> getSimpleReposByTagNode(String node_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("repo.getSimpleReposByTagNode", node_id);
	}

	@Override
	public List<SimpleRepo> getSimpleReposByTagName(String tag_name) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("repo.getSimpleReposByTagName", tag_name);
	}

	@Override
	public List<SimpleRepo> getSimpleReposByTagNameAndSort(String tag_name,
			String type) {
		// TODO Auto-generated method stub
		if(type.equals("fork")){
			return sqlSession.selectList("repo.getSimpleReposByTagNameSortFork", tag_name);
		}else if(type.equals("star")){
			return sqlSession.selectList("repo.getSimpleReposByTagNameSortStar", tag_name);
		}else{
			return sqlSession.selectList("repo.getSimpleReposByTagName", tag_name);
		}
		
	}

	@Override
	public List<Repository> getReposSortByHot(List<Integer> tagIDs, int number) {
		// TODO Auto-generated method stub
		MultiTag tags = new MultiTag();
		tags.setTagIDs(tagIDs);
		tags.setNumber(number);
		return sqlSession.selectList("repo.getReposSortByHot", tags);
	}
	@Override
	public List<RepoPairRelation> getSimilarRepoPairRelation(int repo_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("repo.getSimilarRepo", repo_id);
	}

	@Override
	public List<Repository> getContributedRepoByUserId(int user_id) {
		// TODO Auto-generated method stub		
		return sqlSession.selectList("repo.searchContributedRepoByUserId", user_id);
	}
}
