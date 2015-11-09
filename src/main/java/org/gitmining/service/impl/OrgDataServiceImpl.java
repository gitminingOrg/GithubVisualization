package org.gitmining.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.gitmining.bean.Organization;
import org.gitmining.dao.OrganizationDao;
import org.gitmining.service.OrgDataService;

public class OrgDataServiceImpl implements OrgDataService {
	public OrganizationDao organizationDao;
	public OrganizationDao getOrganizationDao() {
		return organizationDao;
	}

	public void setOrganizationDao(OrganizationDao organizationDao) {
		this.organizationDao = organizationDao;
	}

	@Override
	public Map<Integer, Integer> getOrgMemberCountData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Integer> getOrgRepoCountData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<double[]> getOrgLnMap() {
		// TODO Auto-generated method stub
		List<Organization> organizations =  organizationDao.selectAllOrganizations();
		List<double[]> result = new ArrayList<double[]>();
		for (Organization organization : organizations) {
			double lnMember = (double)Math.round(Math.log10(organization.getMember_count()+1) * 10) / 10;
			double lnRepo = (double)Math.round(Math.log10(organization.getRepo_count()+1) * 10) / 10;
			double[] items = new double[]{lnMember,lnRepo};
			result.add(items);
			
		}
		return result;
	}

}
