package org.gitmining.controller;

import java_cup.internal_error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gitmining.bean.Choice;
import org.gitmining.bean.History;
import org.gitmining.bean.Language;
import org.gitmining.bean.Repository;
import org.gitmining.bean.SimpleRepo;
import org.gitmining.bean.Tag;
import org.gitmining.service.RepoByTagDataService;
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
	private RepoByTagDataService repoByTagDataService;

	public RepoByTagDataService getRepoByTagDataService() {
		return repoByTagDataService;
	}

	public void setRepoByTagDataService(RepoByTagDataService repoByTagDataService) {
		this.repoByTagDataService = repoByTagDataService;
	}

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
		List<String> tagNameList = new ArrayList<String>();
		tagNameList.add("ActiveRecord");
		tagNameList.add("all");
		tagNameList.add("all");
		List<Tag> firsTags = (ArrayList<Tag>) repoByTagDataService
				.listFirstTag();
		// List<Tag> secondTags = (ArrayList<Tag>) repoByTagDataService
		// .listSecondTagByMulti(tagNameList);
		String[] languages = Choice.getLanguages();
		String[] create_years = Choice.getCreate_years();

		result.put("tags", firsTags);
		result.put("languages", languages);
		result.put("createYears", create_years);
		result.put("searchTag", tagNameList);
		return new ModelAndView("allrepos", "result", result);
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
		return new ModelAndView("repoanalysis","result",result);
	}
	
	@RequestMapping(value="/statCounts")
	public Map getStatCounts(HttpServletRequest request) throws Exception {
		Map<String, List> result = repoDataService.getStatCounts(request.getParameter("type"));
		return result;
	}
	
	@RequestMapping(value="/repository/language")
	public Map<String, Object> getRepoLanguage(HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> language = new ArrayList<String>();
		List<Integer> number = new ArrayList<Integer>();
		Map<String, Integer> temp = repoDataService.getLanguageAndNumber();
		for(String key : temp.keySet()){
			language.add(key);
			number.add(temp.get(key));
		}
		result.put("language", language);
		result.put("number", number);
		return result;
	}
	
	@RequestMapping(value="/repository/createtime")
	public Map<Integer, Integer> getRepoCreateTime(HttpServletRequest request) throws Exception {
		List<String> createtime = repoDataService.getRepoCreateTime();
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		for(int i = 0 ; i < createtime.size() ; i ++){
			int year = Integer.parseInt(createtime.get(i).split("-")[0]);
			if(result.containsKey(year)){
				result.put(year, result.get(year) + 1);
			}else{
				result.put(year, 1);
			}
		}
		return result;
	}
	
	@RequestMapping(value="/repository/contributor")
	public Map<String, Integer> getRepoContributor(HttpServletRequest request) throws Exception {
		Map<String, Integer> result = new LinkedHashMap<String, Integer>();
		List<Integer> temp = repoDataService.getContributorNumber();
		result.put("0~25", 0);
		result.put("25~50", 0);
		result.put("50~75", 0);
		result.put("75~100", 0);
		result.put("over 100", 0);
		for(int i = 0 ; i < temp.size() ; i ++){
			if(temp.get(i) >= 0 && temp.get(i) <= 25){
				result.put("0~25", result.get("0~25") + 1);
			}else if(temp.get(i) > 25 && temp.get(i) <= 50){
				result.put("25~50", result.get("25~50") + 1);
			}else if(temp.get(i) > 50 && temp.get(i) <= 75){
				result.put("50~75", result.get("50~75") + 1);
			}else if(temp.get(i) > 75 && temp.get(i) <= 100){
				result.put("75~100", result.get("75~100") + 1);
			}else{
				result.put("over 100", result.get("over 100") + 1);
			}
		}
		return result;
	}
	
	@RequestMapping(value="/repository/collaborator")
	public Map<String, Integer> getRepoCollaborator(HttpServletRequest request) throws Exception {
		Map<String, Integer> result = new LinkedHashMap<String, Integer>();
		List<Integer> temp = repoDataService.getCollaboratorNumber();
		result.put("0~25", 0);
		result.put("25~50", 0);
		result.put("50~75", 0);
		result.put("75~100", 0);
		result.put("over 100", 0);
		for(int i = 0 ; i < temp.size() ; i ++){
			if(temp.get(i) >= 0 && temp.get(i) <= 25){
				result.put("0~25", result.get("0~25") + 1);
			}else if(temp.get(i) > 25 && temp.get(i) <= 50){
				result.put("25~50", result.get("25~50") + 1);
			}else if(temp.get(i) > 50 && temp.get(i) <= 75){
				result.put("50~75", result.get("50~75") + 1);
			}else if(temp.get(i) > 75 && temp.get(i) <= 100){
				result.put("75~100", result.get("75~100") + 1);
			}else{
				result.put("over 100", result.get("over 100") + 1);
			}
		}
		return result;
	}
}
