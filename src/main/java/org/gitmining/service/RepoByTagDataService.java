package org.gitmining.service;

import java.util.List;

import org.gitmining.bean.SimpleRepo;
import org.gitmining.bean.Sort;
import org.gitmining.bean.Tag;

public interface RepoByTagDataService {
	
	public List<SimpleRepo> searchAndSortByTag(String tagName ,Sort type);
	
	public List<Tag> listFirstTag();
	
	public List<Tag> listSecondTag(String firstTag);
	
	public List<Tag> listSecondTagByMulti(List<String> firstTags);
	
	public List<SimpleRepo> getReposSortByHot(List<String> tags);
}
