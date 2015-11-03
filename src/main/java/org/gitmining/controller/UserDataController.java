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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class UserDataController {
	private UserDataService userDataService;
	public UserDataService getUserDataService() {
		return userDataService;
	}
	public void setUserDataService(UserDataService userDataService) {
		this.userDataService = userDataService;
	}
	
	@RequestMapping(value="/user")
	public ModelAndView getUserView(HttpServletRequest request) throws Exception {
		
		return new ModelAndView("user");
	}
	
	@RequestMapping(value="/companyData",method=RequestMethod.GET)
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
		for (int i = 0; i < countList.size(); i++) {
			for (int j = 0; j < countList.size()-1; j++) {
				if(countList.get(j+1) > countList.get(j)){
					int tmp = countList.get(j);
					String ctmp = keyList.get(j);
					
					countList.set(j, countList.get(j+1));
					countList.set(j+1, tmp);
					
					keyList.set(j, keyList.get(j+1));
					keyList.set(j+1, ctmp);
				}
			}
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
	
	@RequestMapping(value="/totalCount")
	public Map totalCount(HttpServletRequest request,HttpServletResponse response){
		Map<String,Integer> result = new HashMap<String, Integer>();
		int userCount = userDataService.getUserCount();
		int orgCount = userDataService.getOrgCount();
		result.put("singleUser", userCount-orgCount);
		result.put("organization", orgCount);
		return result;	
	}
	
	@RequestMapping(value="/repoData")
	public Map repoData(HttpServletRequest request,HttpServletResponse response){
		Map<String,List> result = new HashMap<String, List>();
		Map<Integer, Integer> repoMap = userDataService.getUserRepoData();
		List<Integer> ranges = new ArrayList<Integer>();
		List<Integer> counts = new ArrayList<Integer>();
		
		Set<Integer> keySet = repoMap.keySet();
		for (Integer key : keySet) {
			ranges.add(key);
			counts.add(repoMap.get(key));
			System.out.println(repoMap.get(key));
		}
		result.put("range", ranges);
		result.put("count", counts);
		return result;	
	}
	
	@RequestMapping(value="/gistData")
	public Map gistData(HttpServletRequest request,HttpServletResponse response){
		Map<String,List> result = new HashMap<String, List>();
		Map<Integer, Integer> gistMap = userDataService.getUserGistData();
		List<Integer> ranges = new ArrayList<Integer>();
		List<Integer> counts = new ArrayList<Integer>();
		
		Set<Integer> keySet = gistMap.keySet();
		for (Integer key : keySet) {
			ranges.add(key);
			counts.add(gistMap.get(key));
			System.out.println(gistMap.get(key));
		}
		result.put("range", ranges);
		result.put("count", counts);
		return result;	
	}
	
	@RequestMapping(value="/followerData")
	public Map followerData(HttpServletRequest request,HttpServletResponse response){
		Map<String,List> result = new HashMap<String, List>();
		Map<Integer, Integer> followerMap = userDataService.getUserFollowerData();
		List<Integer> ranges = new ArrayList<Integer>();
		List<Integer> counts = new ArrayList<Integer>();
		
		Set<Integer> keySet = followerMap.keySet();
		for (Integer key : keySet) {
			ranges.add(key);
			counts.add(followerMap.get(key));
			System.out.println(followerMap.get(key));
		}
		result.put("range", ranges);
		result.put("count", counts);
		return result;	
	}
	
	@RequestMapping(value="/followingData")
	public Map followingData(HttpServletRequest request,HttpServletResponse response){
		Map<String,List> result = new HashMap<String, List>();
		Map<Integer, Integer> followerMap = userDataService.getUserFollowingData();
		List<Integer> ranges = new ArrayList<Integer>();
		List<Integer> counts = new ArrayList<Integer>();
		
		Set<Integer> keySet = followerMap.keySet();
		for (Integer key : keySet) {
			ranges.add(key);
			counts.add(followerMap.get(key));
			System.out.println(followerMap.get(key));
		}
		result.put("range", ranges);
		result.put("count", counts);
		return result;	
	}
}
