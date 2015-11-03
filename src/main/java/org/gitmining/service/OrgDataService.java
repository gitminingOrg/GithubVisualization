package org.gitmining.service;

import java.util.List;
import java.util.Map;

public interface OrgDataService {
	/**
	 * how many orgs have a specific number of members
	 * @return
	 */
	public Map<Integer,Integer> getOrgMemberCountData();
	/**
	 * how many orgs have a specific number of repos
	 * @return
	 */	
	public Map<Integer,Integer> getOrgRepoCountData();
	
	/**
	 * ln map of repo and member count of a org
	 * @return
	 */
	public List<double[]> getOrgLnMap();
}
