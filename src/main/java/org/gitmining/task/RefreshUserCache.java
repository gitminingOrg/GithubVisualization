package org.gitmining.task;

import org.gitmining.service.impl.UserDataServiceImpl;

public class RefreshUserCache {
	private UserDataServiceImpl userDataService;
	
	public UserDataServiceImpl getUserDataService() {
		return userDataService;
	}

	public void setUserDataService(UserDataServiceImpl userDataService) {
		this.userDataService = userDataService;
	}

	public void refreshUserCache(){
		userDataService.refreshBlogUserCache();
		userDataService.refreshCompanyUserCache();
		userDataService.refreshEmailCache();
		userDataService.refreshFollowerCache();
		userDataService.refreshFollowingCache();
		userDataService.refreshGistCache();
		userDataService.refreshLocationCache();
		userDataService.refreshRepoCache();
	}
}
