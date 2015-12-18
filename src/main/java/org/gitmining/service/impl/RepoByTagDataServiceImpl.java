package org.gitmining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.gitmining.bean.SimpleRepo;
import org.gitmining.bean.Sort;
import org.gitmining.bean.Tag;
import org.gitmining.dao.RepositoryDao;
import org.gitmining.dao.TagDao;

public class RepoByTagDataServiceImpl implements
		org.gitmining.service.RepoByTagDataService {
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
	public List<SimpleRepo> searchAndSortByTag(List<String> tagName, Sort type) {
		// TODO Auto-generated method stub
		// int tag_id = tagDao.getTagID(tagName);
		// List<RepoTagPair> repoTagPairs = (List<RepoTagPair>)
		// repositoryDao.getRepoTagPairsByTagID(tag_id);

		List<SimpleRepo> simpleRepos = new ArrayList<SimpleRepo>();
		if (type == Sort.GENERAL) {
			simpleRepos = repositoryDao.getSimpleReposByTagName(tagName);
		} else if (type == Sort.STAR) {
			simpleRepos = repositoryDao.getSimpleReposByTagNameAndSort(tagName,
					"star");
		} else if (type == Sort.FORK) {
			simpleRepos = repositoryDao.getSimpleReposByTagNameAndSort(tagName,
					"fork");
		}
		// for (int i = 0; i < repoTagPairs.size(); i++) {
		// simpleRepos.add(repositoryDao.searchSimpleRepoById(repoTagPairs.get(i).getRepo_id()));
		// }
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

	@Override
	public List<Tag> listSecondTagByMulti(List<String> firstTags) {
		// TODO Auto-generated method stub
		List<Tag> secondTags = new ArrayList<Tag>();
		for (int i = 0; i < firstTags.size(); i++) {
			String node_id = tagDao.getTagNodeID(firstTags.get(i));
			String para = node_id + "." + "%";
			List<Tag> temp = tagDao.listSecondTag(para);
			for (int j = 0; j < temp.size(); j++) {
				secondTags.add(temp.get(j));
			}
		}
		return secondTags;
	}

	@Override
	public List<SimpleRepo> getReposSortByHot(List<String> tags) {
		// TODO Auto-generated method stub
		List<Integer> tagIDs = new ArrayList<Integer>();

		for (int i = 0; i < tags.size(); i++) {
			tagIDs.add(tagDao.getTagID(tags.get(i)));
		}
		return repositoryDao.getReposSortByHot(tagIDs, tagIDs.size());
	}

	@Override
	public List<SimpleRepo> searchAndSortByTagPagination(List<String> tagName,
			Sort type, int currentPage, int itemsPerPage) {
		// TODO Auto-generated method stub
		int begin = (currentPage - 1) * itemsPerPage;

		List<SimpleRepo> simpleRepos = new ArrayList<SimpleRepo>();

		if (type == Sort.GENERAL) {
			simpleRepos = repositoryDao
					.getSimpleReposByTagNameAndSortPagination(tagName,
							Sort.GENERAL, begin, itemsPerPage);
			System.out.println("general++" + simpleRepos.size());
		} else if (type == Sort.STAR) {
			simpleRepos = repositoryDao
					.getSimpleReposByTagNameAndSortPagination(tagName,
							Sort.STAR, begin, itemsPerPage);
		} else if (type == Sort.FORK) {
			simpleRepos = repositoryDao
					.getSimpleReposByTagNameAndSortPagination(tagName,
							Sort.FORK, begin, itemsPerPage);
		}
		return simpleRepos;
	}

	@Override
	public int resultCount(List<String> tagName, Sort type) {
		// TODO Auto-generated method stub
		int resultCount = 0;
		if (type == Sort.GENERAL) {
			resultCount = repositoryDao.getResultCountPagination(tagName,
					Sort.GENERAL);
		} else if (type == Sort.STAR) {
			resultCount = repositoryDao.getResultCountPagination(tagName,
					Sort.STAR);
		} else if (type == Sort.FORK) {
			resultCount = repositoryDao.getResultCountPagination(tagName,
					Sort.FORK);
		}
		return resultCount;
	}

}
