package org.gitmining.dao.impl;

import java.util.List;

import org.gitmining.bean.Tag;
import org.gitmining.dao.TagDao;

public class TagDaoImpl extends BaseDaoImpl implements TagDao {

	@Override
	public List<Tag> listFirstTag() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("tag.listFirstTag");
	}

	@Override
	public List<Tag> listSecondTag(String firstTag) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("tag.listSecondTag" , firstTag);
	}

	@Override
	public int getTagID(String tagName) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("tag.getTagID" , tagName);
	}

	@Override
	public String getTagNodeID(String tagName) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("tag.getTagNodeID" , tagName);
	}

}
