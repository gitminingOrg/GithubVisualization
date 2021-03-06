package org.gitmining.service;

import java.util.List;
import java.util.Map;

import org.gitmining.bean.*;

public interface UserInfoService {
	public User getUserInfo(int id);
	public Map getUserScore(int id);
	public Map getRecommendRepos(User user);
	public List<User> getTop20Users();

}
