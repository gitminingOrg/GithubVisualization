package org.gitmining.service;

import java.util.List;

import org.gitmining.bean.Repository;
import org.gitmining.bean.SimpleRepo;
import org.gitmining.bean.Sort;
import org.gitmining.bean.Tag;

public interface RepoByTagDataService {

	public List<SimpleRepo> searchAndSortByTag(List<String> tagName, Sort type);

	//分页
	public List<Repository> searchAndSortByTagPagination(List<String> tagName,
			Sort type, int currentPage, int itemsPerPage);

	// 结果集总行数
	public int resultCount(List<String> tagName, Sort type);

	public List<Tag> listFirstTag();

	public List<Tag> listSecondTag(String firstTag);

	public List<Tag> listSecondTagByMulti(List<String> firstTags);

	public List<SimpleRepo> getReposSortByHot(List<String> tags);
}
