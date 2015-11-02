package org.gitmining.service;

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
}
