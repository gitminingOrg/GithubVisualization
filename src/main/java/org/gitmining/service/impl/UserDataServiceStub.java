package org.gitmining.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.gitmining.service.UserDataService;

public class UserDataServiceStub implements UserDataService {

	@Override
	public Map<String, Integer> getCompanyUserCount() {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("github", 10000);
		map.put("microsoft", 2000);
		map.put("ibm", 3000);
		map.put("empty", 40000);
		return map;
	}

	@Override
	public Map<String, Integer> getBlogUserCount() {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("githubblog", 10000);
		map.put("microsoftblog", 2000);
		map.put("ibmblog", 3000);
		map.put("empty", 40000);
		return map;
	}

	@Override
	public Map<String, Integer> getLocationCount() {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Beijing", 10000);
		map.put("New York", 2000);
		map.put("Washton D.C", 3000);
		map.put("empty", 40000);
		return map;
	}

	@Override
	public Map<String, Integer> getEmailCount() {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("github", 10000);
		map.put("baidu", 2000);
		map.put("163", 3000);
		map.put("empty", 40000);
		return map;
	}

}
