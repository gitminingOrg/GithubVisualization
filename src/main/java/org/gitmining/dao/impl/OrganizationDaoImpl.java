package org.gitmining.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.gitmining.bean.Organization;
import org.gitmining.dao.OrganizationDao;

public class OrganizationDaoImpl extends BaseDaoImpl implements OrganizationDao {

	@Override
	public List<Organization> selectAllOrganizations() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("organization.selectAllOrganizations");
	}

	@Override
	public int countOrganizations() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("organization.countOrganizations");
	}

}
