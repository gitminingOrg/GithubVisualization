package org.gitmining.service;

import java.util.List;

import org.gitmining.bean.RepoTagPair;
import org.gitmining.bean.Repository;
import org.gitmining.bean.SimpleRepo;
import org.gitmining.bean.Tag;

public interface RepoByTagDataService {
	
	public List<SimpleRepo> searchAndSortByTag(String tagName ,String type);
	
	public List<Tag> listFirstTag();
	
	public List<Tag> listSecondTag(String firstTag);
}
