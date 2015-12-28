package org.gitmining.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gitmining.bean.User;
import org.gitmining.bean.UserScore;
import org.gitmining.service.UserDataService;
import org.gitmining.service.UserInfoService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserInfoDataController {
	private UserDataService userDataService;
	private UserInfoService userInfoService;
	public UserDataService getUserDataService() {
		return userDataService;
	}
	public void setUserDataService(UserDataService userDataService) {
		this.userDataService = userDataService;
	}
	
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	@RequestMapping(value="/simpleUser")
	public ModelAndView getUserView(HttpServletRequest request) throws Exception {
		ModelMap result=new ModelMap();
		result.put("type", "USER");
		return new ModelAndView("userinfo","result",result);
	}
	
	@RequestMapping(value="/user/content")
	public ModelAndView getUserContent(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelMap result=new ModelMap();
		int user_id = Integer.parseInt(request.getParameter("id"));
		User user = userInfoService.getUserInfo(user_id);
		user.setCreated_at(user.getCreated_at().substring(0, 10));
		
		Map userScores = userInfoService.getUserScore(user_id);
		
		Map<String, List> relatedRepos = userInfoService.getRecommendRepos(user);
		result.put("type", "USER");
		result.put("user", user);
		result.put("score", userScores);
		result.put("repos", relatedRepos);
		return new ModelAndView("userinfo","result",result);
	}	
	
	@RequestMapping(value="/user/top")
	public ModelAndView getTopUserContent(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelMap result=new ModelMap();
		List<User> users = userInfoService.getTop20Users();
		for (int i = 0; i < users.size(); i++) {
			users.get(i).setFollowers(users.get(i).getFollowers()/240);
			System.out.println(users.get(i).getId());
		}
		result.put("type", "USER");
		result.put("users", users);
		return new ModelAndView("useroverview","result",result);
	}
}
