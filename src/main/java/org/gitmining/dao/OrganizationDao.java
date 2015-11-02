package org.gitmining.dao;

import java.util.List;

import org.gitmining.bean.Organization;

public interface OrganizationDao {
	public List<Organization> selectAllOrganizations();
	public int countOrganizations();
}
