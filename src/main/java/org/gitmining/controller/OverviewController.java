package org.gitmining.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java_cup.internal_error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gitmining.bean.SimpleRepo;
import org.gitmining.bean.Sort;
import org.gitmining.bean.Tag;
import org.gitmining.service.RepoByTagDataService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class OverviewController {

	private RepoByTagDataService repoByTagDataService;

	@RequestMapping(value = "/overview")
	public ModelAndView getOverviewView(HttpServletRequest request)
			throws Exception {
		ModelMap result = new ModelMap();
		result.put("type", "OVERVIEW");
		List<Tag> firsTags = (ArrayList<Tag>) repoByTagDataService
				.listFirstTag();
		result.put("tags", firsTags);
		return new ModelAndView("overview", "result", result);
	}

	@RequestMapping(value = "/repos")
	public ModelAndView getReposView(HttpServletRequest request)
			throws Exception {
		String[] tagName = request.getParameter("tag").split("ae");
		List<String> tagNameList = new ArrayList<String>();
		for (int i = 0; i < tagName.length; i++) {
			tagNameList.add(tagName[i]);
		}

		List<SimpleRepo> repos = repoByTagDataService.searchAndSortByTag(
				tagNameList, Sort.GENERAL);
		ModelMap result = new ModelMap();
		result.put("repos", repos);
		result.put("type", "REPOSITORY");
		List<Tag> firsTags = (ArrayList<Tag>) repoByTagDataService
				.listFirstTag();
		List<Tag> secondTags = (ArrayList<Tag>) repoByTagDataService
				.listSecondTag("typeA");
		Map<Tag, Integer> searchTags = new HashMap<Tag, Integer>();
		for (int i = 0; i < firsTags.size(); i++) {
			if (tagNameList.contains(firsTags.get(i).getName())) {
				searchTags.put(firsTags.get(i), 1);
			} else {
				searchTags.put(firsTags.get(i), 0);
			}
		}

		result.put("tags", firsTags);
		result.put("secondTags", secondTags);
		result.put("searchTag", searchTags);
		return new ModelAndView("allrepos", "result", result);
	}

	@RequestMapping(value = "/TopTen", method = RequestMethod.POST)
	public Map getTopTen(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Map<String, List> result = new HashMap<String, List>();
		String temp=request.getParameter("tag");
		String[] tagName = temp.substring(1,temp.length()-1).split("ae");
		List<String> tagNameList = new ArrayList<String>();
		for (int i = 0; i < tagName.length; i++) {
			tagNameList.add(tagName[i]);
		}
		List<SimpleRepo> repos = repoByTagDataService
				.getReposSortByHot(tagNameList);
		result.put("repos", repos);
		return result;
	}

	@RequestMapping(value = "/repos/star", method = RequestMethod.POST)
	public Map getStarRepos(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Map<String, List> result = new HashMap<String, List>();

		String[] tagName = request.getParameter("tag").split("ae");
		List<String> tagNameList = new ArrayList<String>();
		for (int i = 0; i < tagName.length; i++) {
			tagNameList.add(tagName[i]);
		}

		List<SimpleRepo> repos = repoByTagDataService.searchAndSortByTag(
				tagNameList, Sort.STAR);
		result.put("repos", repos);
		return result;
	}

	@RequestMapping(value = "/repos/fork", method = RequestMethod.POST)
	public Map getForkRepos(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Map<String, List> result = new HashMap<String, List>();

		String[] tagName = request.getParameter("tag").split("ae");
		List<String> tagNameList = new ArrayList<String>();
		for (int i = 0; i < tagName.length; i++) {
			tagNameList.add(tagName[i]);
		}

		List<SimpleRepo> repos = repoByTagDataService.searchAndSortByTag(
				tagNameList, Sort.FORK);
		result.put("repos", repos);
		return result;
	}

	public RepoByTagDataService getRepoByTagDataService() {
		return repoByTagDataService;
	}

	public void setRepoByTagDataService(
			RepoByTagDataService repoByTagDataService) {
		this.repoByTagDataService = repoByTagDataService;
	}
}
