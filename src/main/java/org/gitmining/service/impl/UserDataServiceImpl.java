package org.gitmining.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.gitmining.bean.User;
import org.gitmining.dao.OrganizationDao;
import org.gitmining.dao.UserDao;
import org.gitmining.service.UserDataService;
import org.gitmining.util.DomainRetriever;

public class UserDataServiceImpl implements UserDataService {
	private UserDao userDao;
	private OrganizationDao organizationDao;
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public OrganizationDao getOrganizationDao() {
		return organizationDao;
	}

	public void setOrganizationDao(OrganizationDao organizationDao) {
		this.organizationDao = organizationDao;
	}

	@Override
	public Map<String, Integer> getCompanyUserCount() {
		// TODO Auto-generated method stub
		List<User> users = userDao.selectAllUsers();
		Map<String,Integer> companyMap = new HashMap<String, Integer>();
		for (User user : users) {
			String company = user.getCompany();
			if(company == null || company == ""){
				company = "empty";
			}
			if(!companyMap.containsKey(company)){
				companyMap.put(company, 1);
			}else{
				companyMap.put(company, companyMap.get(company)+1);
			}
		}
		companyMap.put("others", 0);
		Iterator<String> keys = companyMap.keySet().iterator();
		List<String> deleteKeys = new ArrayList<String>();
		while(keys.hasNext()){
			String key = keys.next();
			int count = companyMap.get(key);
			if(count < 50){
				deleteKeys.add(key);
				companyMap.put("others", companyMap.get("others")+count);
			}
		}
		for (String key : deleteKeys) {
			companyMap.remove(key);
		}
		
		Map<String, Integer> result = new TreeMap<String, Integer>();
		Set<String> keysRemain = companyMap.keySet();
		for (String key : keysRemain) {
			if(!key.equals("empty") && !key.equals("others")){
				result.put(key, companyMap.get(key));
			}
		}
		

		return result;
	}

	@Override
	public Map<String, Integer> getBlogUserCount() {
		// TODO Auto-generated method stub
		List<User> users = userDao.selectAllUsers();
		Map<String,Integer> blogMap = new HashMap<String, Integer>();
		for (User user : users) {
			String blog = user.getBlog();
			if(blog == null || blog == ""){
				blog = "empty";
			}else{
				blog = DomainRetriever.extractBlogDomain(blog);
			}
			if(!blogMap.containsKey(blog)){
				blogMap.put(blog, 1);
			}else{
				blogMap.put(blog, blogMap.get(blog)+1);
			}
		}
		blogMap.put("others", 0);
		Iterator<String> keys = blogMap.keySet().iterator();
		List<String> deleteKeys = new ArrayList<String>();
		while(keys.hasNext()){
			String key = keys.next();
			int count = blogMap.get(key);
			if(count < 50){
				deleteKeys.add(key);
				blogMap.put("others", blogMap.get("others")+count);
			}
		}
		
		for (String key : deleteKeys) {
			blogMap.remove(key);
		}
		return blogMap;
	}

	@Override
	public Map<String, Integer> getLocationCount() {
		// TODO Auto-generated method stub
		List<User> users = userDao.selectAllUsers();
		Map<String,Integer> locationMap = new HashMap<String, Integer>();
		for (User user : users) {
			String location = user.getLocation();
			if(location == null || location == ""){
				location = "empty";
			}
			if(!locationMap.containsKey(location)){
				locationMap.put(location, 1);
			}else{
				locationMap.put(location, locationMap.get(location)+1);
			}
		}
		locationMap.put("others", 0);
		Iterator<String> keys = locationMap.keySet().iterator();
		List<String> deleteKeys = new ArrayList<String>();
		while(keys.hasNext()){
			String key = keys.next();
			int count = locationMap.get(key);
			if(count < 50){
				deleteKeys.add(key);
				locationMap.put("others", locationMap.get("others")+count);
			}
		}
		
		for (String key : deleteKeys) {
			locationMap.remove(key);
		}
		return locationMap;
	}

	@Override
	public Map<String, Integer> getEmailCount() {
		// TODO Auto-generated method stub
		List<User> users = userDao.selectAllUsers();
		Map<String,Integer> emailMap = new HashMap<String, Integer>();
		for (User user : users) {
			String email = user.getEmail();
			if(email == null || email == ""){
				email = "empty";
			}else{
				email = DomainRetriever.extractEmailDomain(email);
			}
			
			if(!emailMap.containsKey(email)){
				emailMap.put(email, 1);
			}else{
				emailMap.put(email, emailMap.get(email)+1);
			}
		}
		emailMap.put("others", 0);
		Iterator<String> keys = emailMap.keySet().iterator();
		List<String> deleteKeys = new ArrayList<String>();
		while(keys.hasNext()){
			String key = keys.next();
			int count = emailMap.get(key);
			if(count < 50){
				deleteKeys.add(key);
				emailMap.put("others", emailMap.get("others")+count);
			}
		}
		
		for (String key : deleteKeys) {
			emailMap.remove(key);
		}
		return emailMap;
	}

	@Override
	public int getUserCount() {
		// TODO Auto-generated method stub
		return userDao.countUsers();
	}

	@Override
	public int getOrgCount() {
		// TODO Auto-generated method stub
		return organizationDao.countOrganizations();
	}

	@Override
	public Map<Integer, Integer> getUserRepoData() {
		// TODO Auto-generated method stub
		int[] bounds = {0,20,40,60,80,100,120,140,160,180,200,52713};
		int[] counts = new int[bounds.length];
		List<User> users = userDao.selectAllUsers();
		users.sort(new Comparator<User>() {
			@Override
			public int compare(User u1, User u2) {
				// TODO Auto-generated method stub
				return u1.getPublic_repos()-u2.getPublic_repos();
			}
		});
		
		int bound = 0;
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getPublic_repos() > bounds[bound]){
				counts[bound] = i;
				bound++;
			}
		}
		counts[counts.length-1] = users.size();
		
		Map<Integer,Integer> repoMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < counts.length; i++) {
			repoMap.put(bounds[i], counts[i]);
		}
		return repoMap;
	}

	@Override
	public Map<Integer, Integer> getUserGistData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Integer> getUserFollowerData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Integer> getUserFollowingData() {
		// TODO Auto-generated method stub
		return null;
	}

}
