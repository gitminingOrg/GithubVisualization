package org.gitmining.dao;

import java.util.List;

import org.gitmining.bean.Tag;

public interface TagDao {
	
	public List<Tag> listFirstTag();
	
	public List<Tag> listSecondTag(String firstTag);
	
	public int getTagID(String tagName);
	
	public String getTagNodeID(String tagName);
}
