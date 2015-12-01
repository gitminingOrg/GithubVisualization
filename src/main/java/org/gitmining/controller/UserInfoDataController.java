package org.gitmining.controller;

import javax.servlet.http.HttpServletRequest;

import org.gitmining.service.UserDataService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserInfoDataController {
	private UserDataService userDataService;
	public UserDataService getUserDataService() {
		return userDataService;
	}
	public void setUserDataService(UserDataService userDataService) {
		this.userDataService = userDataService;
	}
	
	@RequestMapping(value="/simpleUser")
	public ModelAndView getUserView(HttpServletRequest request) throws Exception {
		ModelMap result=new ModelMap();
		result.put("type", "USER");
		return new ModelAndView("userinfo","result",result);
	}
	
}
