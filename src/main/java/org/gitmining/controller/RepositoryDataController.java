package org.gitmining.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gitmining.bean.Repository;
import org.gitmining.bean.SimpleRepo;
import org.gitmining.service.RepoDataService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@RestController
public class RepositoryDataController {
	private RepoDataService repoDataService;

	public RepoDataService getRepoDataService() {
		return repoDataService;
	}
	public void setRepoDataService(RepoDataService repoDataService) {
		this.repoDataService = repoDataService;
	}
	@RequestMapping(value = "/simpleRepo")
	public ModelAndView getRepoView(HttpServletRequest request)
			throws Exception {
		ModelMap type=new ModelMap();
		type.put("type", "REPOSITORY");
		return new ModelAndView("SearchRepository","type",type);
	}
	@RequestMapping(value = "/repository/search")
	public Map<String,List> searchRepository(HttpServletRequest request,HttpServletResponse response){
		String name = (String) request.getAttribute("name");
		Map<String,List> result = new HashMap<String, List>();
		List<SimpleRepo> simpleRepos = repoDataService.searchRepo(name);
		result.put("simpleRepos", simpleRepos);
		return result;
	}
	
	@RequestMapping(value = "/repository/info")
	public Map<String,Repository> getRepository(HttpServletRequest request,HttpServletResponse response){
		//int repo_id = (Integer) request.getAttribute("repo_id");
		int repo_id = 23013882;
		Map<String,Repository> result = new HashMap<String, Repository>();
		Repository repository = repoDataService.getRepositoryById(repo_id);
		result.put("repository", repository);
		return result;
	}
}
