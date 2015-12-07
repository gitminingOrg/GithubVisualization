package org.gitmining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.gitmining.bean.RepoTagPair;
import org.gitmining.bean.Repository;
import org.gitmining.bean.SimpleRepo;
import org.gitmining.bean.Tag;
import org.gitmining.dao.RepositoryDao;
import org.gitmining.dao.TagDao;

public class RepoByTagDataServiceImpl implements org.gitmining.service.RepoByTagDataService {
	private RepositoryDao repositoryDao;
	private TagDao tagDao;

	public RepositoryDao getRepositoryDao() {
		return repositoryDao;
	}

	public void setRepositoryDao(RepositoryDao repositoryDao) {
		this.repositoryDao = repositoryDao;
	}

	public TagDao getTagDao() {
		return tagDao;
	}

	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}

	@Override
	public List<SimpleRepo> searchAndSortByTag(String tagName, String type) {
		// TODO Auto-generated method stub
		int tag_id = tagDao.getTagID(tagName); 
		List<RepoTagPair> repoTagPairs = (List<RepoTagPair>) repositoryDao.getRepoTagPairsByTagID(tag_id);
		List<SimpleRepo> simpleRepos=new ArrayList<SimpleRepo>();
		for (int i = 0; i < repoTagPairs.size(); i++) {
			simpleRepos.add(repositoryDao.searchSimpleRepoById(repoTagPairs.get(i).getRepo_id()));
		}
		return simpleRepos;
	}

	@Override
	public List<Tag> listFirstTag() {
		// TODO Auto-generated method stub
		return tagDao.listFirstTag();
	}

	@Override
	public List<Tag> listSecondTag(String firstTag) {
		// TODO Auto-generated method stub
		String node_id = tagDao.getTagNodeID(firstTag);
		String para = node_id + "." + "%";
		return tagDao.listSecondTag(para);
	}

}
