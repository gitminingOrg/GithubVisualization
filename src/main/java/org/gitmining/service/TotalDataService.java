package org.gitmining.service;

public interface TotalDataService {
	/**
	 * get the num of users
	 * @return
	 */
	public int getUserCount();
	
	/**
	 * get the num of orgs
	 * @return
	 */
	public int getOrgCount();
}
