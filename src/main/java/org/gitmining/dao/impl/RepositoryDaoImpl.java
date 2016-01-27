package org.gitmining.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.MediaSize.NA;

import org.gitmining.bean.RepoPairRelation;
import org.gitmining.bean.RepoScore;
import org.gitmining.bean.RepoTagPair;
import org.gitmining.bean.Repository;
import org.gitmining.bean.SimpleRepo;
import org.gitmining.bean.Sort;
import org.gitmining.dao.RepositoryDao;

public class RepositoryDaoImpl extends BaseDaoImpl implements RepositoryDao {

	@Override
	public List<SimpleRepo> searchRepos(String pattern) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("repo.searchRepo", pattern);
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
	public List<SimpleRepo> getSimpleReposByTagName(List<String> tag_name) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", tag_name);
		return sqlSession.selectList("repo.getSimpleReposByTagName", map);
	}

	@Override
	public List<SimpleRepo> getSimpleReposByTagNameAndSort(
			List<String> tag_name, String type) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", tag_name);

		if (type.equals("fork")) {
			return sqlSession.selectList(
					"repo.getSimpleReposByTagNameSortFork", map);
		} else if (type.equals("star")) {
			return sqlSession.selectList(
					"repo.getSimpleReposByTagNameSortStar", map);
		} else {
			return sqlSession.selectList("repo.getSimpleReposByTagName", map);
		}

	}

	@Override
	public List<SimpleRepo> getReposSortByHot(List<Integer> tagIDs, int number) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first", tagIDs);
		map.put("second", number);
		return sqlSession.selectList("repo.getReposSortByHot", map);
	}

	@Override
	public List<RepoPairRelation> getSimilarRepoPairRelation(int repo_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("repo.getSimilarRepo", repo_id);
	}

	@Override
	public List<Repository> getContributedRepoByUserId(int user_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("repo.searchContributedRepoByUserId",
				user_id);
	}

	@Override
	public List<Repository> getSimpleReposByTagNameAndSortPagination(
			List<String> tag_name, Sort type, int begin, int itemsPerPage) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		if(!tag_name.get(0).equals("all"))
			map.put("tag", tag_name.get(0));
		if(!tag_name.get(1).equals("all"))
			map.put("language", tag_name.get(1));
		if(!tag_name.get(2).equals("all"))
			map.put("year", tag_name.get(2));
		map.put("beginItem", begin);
		map.put("itemsPerPage", itemsPerPage);

		if (type == Sort.GENERAL) {
			return sqlSession.selectList(
					"repo.getSimpleReposByTagNameSortGeneralPagination", map);
		} else if (type == Sort.STAR) {
			map.put("type", "stargazers");
			return sqlSession.selectList(
					"repo.getSimpleReposByTagNameSortPagination", map);
		} else if (type == Sort.FORK) {
			map.put("type", "fork_num");
			return sqlSession.selectList(
					"repo.getSimpleReposByTagNameSortPagination", map);
		} else {
			map.put("type", "contributor");
			return sqlSession.selectList(
					"repo.getSimpleReposByTagNameSortPagination", map);
		}
	}

	@Override
	public int getResultCountPagination(List<String> tagName, Sort type) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", tagName);
		return sqlSession.selectList("repo.getSimpleReposByTagName", map)
				.size();
	}

	@Override
	public List<String> getAllLanguages() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("repo.getAllLanguages");
	}

	@Override
	public List<Integer> getStatCounts(String table) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("table", table);
		return sqlSession.selectList("repo.getStatCounts",map);
	}

	@Override
	public List<String> getStatTypes(String table, String column) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("table", table);
		map.put("column", column);
		return sqlSession.selectList("repo.getStatTypes",map);
	}
}
