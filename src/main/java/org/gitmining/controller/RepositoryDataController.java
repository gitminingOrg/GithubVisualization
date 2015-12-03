package org.gitmining.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gitmining.bean.Repository;
import org.gitmining.bean.SimpleRepo;
import org.gitmining.service.RepoDataService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		ModelMap result = new ModelMap();
		result.put("type", "REPOSITORY");
		return new ModelAndView("searchrepo", "result", result);
	}
	
	@RequestMapping(value = "/repository/content", method = RequestMethod.GET)
	public ModelAndView getRepositoryContent(HttpServletRequest request,HttpServletResponse response){
		int repo_id = 1;//Integer.parseInt(request.getParameter("id"));
		ModelMap map = new ModelMap();
		Repository repository = repoDataService.getRepositoryById(repo_id);
		Map<String,List> relatedRepos = repoDataService.relatedRepos(repo_id);
		Map<String,Integer> scores = repoDataService.getRepositoryScoreById(repo_id);
		map.put("repository", repository);
		map.put("relatedRepos", relatedRepos);
		map.put("scores", scores);
		map.put("type", "REPOSITORY");
		return new ModelAndView("repo", "result", map);
	}

	@RequestMapping(value = "/repository/search", method = RequestMethod.POST)
	public ModelAndView searchRepository(HttpServletRequest request,
			HttpServletResponse response) {
		String name = request.getParameter("reponame");
		ModelMap result = new ModelMap();
		List<SimpleRepo> simpleRepos = (ArrayList<SimpleRepo>)repoDataService.searchRepo(name);
		result.put("simpleRepos", simpleRepos);
		result.put("type", "REPOSITORY");
		result.put("searchstring", name);
		return new ModelAndView("repolist", "result", result);
	}

	@RequestMapping(value = "/repository/info")
	public ModelAndView getRepository(HttpServletRequest request,
			HttpServletResponse response) {
		int repo_id = Integer.parseInt(request.getParameter("id"));
		ModelMap map=new ModelMap();
		Repository repository = repoDataService.getRepositoryById(repo_id);
		map.put("repository", repository);
		map.put("type", "REPOSITORY");
		return new ModelAndView("repoinfo","result",map);
	}
	
	@RequestMapping(value="/repoAnalysis")
	public ModelAndView getUserView(HttpServletRequest request) throws Exception {
		ModelMap result=new ModelMap();
		result.put("type", "REPOSITORYANALYSIS");
		return new ModelAndView("repoanalysis","result",result);
	}
}
