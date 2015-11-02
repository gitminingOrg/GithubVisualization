package org.gitmining.dao.impl;

import java.util.List;

import org.gitmining.bean.User;
import org.gitmining.dao.UserDao;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public List<User> selectAllUsers() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("user.selectAllUsers");
	}

	@Override
	public int countUsers() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("user.countUsers");
	}

}
