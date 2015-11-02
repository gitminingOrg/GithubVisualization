package org.gitmining.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.gitmining.bean.User;
import org.gitmining.dao.UserDao;
import org.gitmining.service.UserDataService;

public class UserDataServiceImpl implements UserDataService {
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
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
		return companyMap;
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

}
