package org.gitmining.service;

import java.util.Map;

public interface UserDataService {
	/**
	 * user count of each company
	 * @return
	 */
	public Map<String, Integer> getCompanyUserCount();
	
	/**
	 * user count of each blog domain
	 * @return
	 */
	public Map<String, Integer> getBlogUserCount();
	
	/**
	 * user count of each dwell place
	 * @return
	 */
	public Map<String,Integer> getLocationCount();
	
	/**
	 * user count of each email domain
	 * @return
	 */
	public Map<String,Integer> getEmailCount();
}