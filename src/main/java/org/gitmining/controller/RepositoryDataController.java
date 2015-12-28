package org.gitmining.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gitmining.bean.History;
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
		int repo_id = Integer.parseInt(request.getParameter("id"));
		ModelMap map = new ModelMap();
		Repository repository = repoDataService.getRepositoryById(repo_id);
		
		String fullname=repository.getFull_name().split("/")[1];
		repository.setFull_name(fullname);
		
		Map<String,List> relatedRepos = repoDataService.relatedRepos(repository);
		Map<String,Integer> scores = repoDataService.getRepositoryScoreById(repo_id);
		History history = repoDataService.getRepositoryHistory(repo_id);
		map.put("history", history);
		map.put("repository", repository);
		map.put("relatedRepos", relatedRepos);
		map.put("scores", scores);
		map.put("type", "REPOSITORY");
		return new ModelAndView("repo", "result", map);
	}
	@RequestMapping(value="/repository/score")
	public Map userScore(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub	
		
		int repo_id = Integer.parseInt(request.getParameter("id"));
		Map<String, Object> result = new TreeMap<String, Object>();
		List<String> names = new ArrayList<String>();
		List<Integer> nums = new ArrayList<Integer>();
		Map<String,Integer> scores = repoDataService.getRepositoryScoreById(repo_id);
		result.put("total", scores.get("total"));
		scores.remove("total");
		Set<String> keySet = scores.keySet();
		for (String string : keySet) {
			names.add(string);
			nums.add(scores.get(string));
		}

		result.put("names", names);
		result.put("scores", nums);
		return result;
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
