package org.gitmining.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gitmining.service.UserDataService;
import org.springframework.web.bind.annotation.RequestMapping;

public class UserDataController {
	private UserDataService userDataService;
	public UserDataService getUserDataService() {
		return userDataService;
	}
	public void setUserDataService(UserDataService userDataService) {
		this.userDataService = userDataService;
	}
	
	@RequestMapping(value="/companyData")
	public Map companyData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String, List> result = new HashMap<String, List>();
		List<String> keyList = new ArrayList<String>();
		List<Integer> countList = new ArrayList<Integer>();
		Map<String, Integer> companyData = userDataService.getCompanyUserCount();
		Set<String> keys = companyData.keySet();
		for (String key : keys) {
			keyList.add(key);
			int count = companyData.get(key);
			countList.add(count);
		}
		result.put("companyName", keyList);
		result.put("companyCount", countList);
		return result;
	}	
	
	@RequestMapping(value="/blogData")
	public Map blogData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub	
		Map<String, List> result = new HashMap<String, List>();
		List<String> keyList = new ArrayList<String>();
		List<Integer> countList = new ArrayList<Integer>();
		Map<String, Integer> blogData = userDataService.getBlogUserCount();
		Set<String> keys = blogData.keySet();
		for (String key : keys) {
			keyList.add(key);
			int count = blogData.get(key);
			countList.add(count);
		}
		result.put("blogName", keyList);
		result.put("blogCount", countList);
		return result;
	}	
	
	@RequestMapping(value="/locationData")
	public Map locationData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub	
		Map<String, List> result = new HashMap<String, List>();
		List<String> keyList = new ArrayList<String>();
		List<Integer> countList = new ArrayList<Integer>();
		Map<String, Integer> locationData = userDataService.getLocationCount();
		Set<String> keys = locationData.keySet();
		for (String key : keys) {
			keyList.add(key);
			int count = locationData.get(key);
			countList.add(count);
		}
		result.put("locationName", keyList);
		result.put("locationCount", countList);
		return result;
	}
	
	@RequestMapping(value="/emailData")
	public Map emailData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub	
		Map<String, List> result = new HashMap<String, List>();
		List<String> keyList = new ArrayList<String>();
		List<Integer> countList = new ArrayList<Integer>();
		Map<String, Integer> emailData = userDataService.getEmailCount();
		Set<String> keys = emailData.keySet();
		for (String key : keys) {
			keyList.add(key);
			int count = emailData.get(key);
			countList.add(count);
		}
		result.put("emailName", keyList);
		result.put("emailCount", countList);
		return result;
	}	
}
