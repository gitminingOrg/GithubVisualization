package org.gitmining.service;

import java.util.Map;

import org.gitmining.bean.*;

public interface UserInfoService {
	public User getUserInfo(int id);
	public UserScore getUserScore(int id);
	public Map getRecommendRepos(int user_id);
}
