package org.gitmining.dao.impl;

import org.apache.ibatis.session.SqlSession;

public class BaseDaoImpl {

	protected SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
}
