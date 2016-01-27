package org.gitmining.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gitmining.bean.Choice;
import org.gitmining.bean.Repository;
import org.gitmining.bean.SimpleRepo;
import org.gitmining.bean.Sort;
import org.gitmining.bean.Tag;
import org.gitmining.service.RepoByTagDataService;
import org.springframework.ui.ModelMap;
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
		String tagName = request.getParameter("tag");
		String language = request.getParameter("lan");
		String year = request.getParameter("year");
		System.out.println(request.getParameter("tag"));
		List<String> tagNameList = new ArrayList<String>();
		tagNameList.add(tagName);
		tagNameList.add(language);
		tagNameList.add(year);

		ModelMap result = new ModelMap();
		result.put("type", "REPOSITORY");
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

	@RequestMapping(value = "/repos/sort", method = RequestMethod.POST)
	public Map getGeneralRepos(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<String, Object>();
		int currentPage = Integer.parseInt(request.getParameter("pageIndex"));
		int itemsperPage = Integer.parseInt(request.getParameter("pageSize"));
		String tag = request.getParameter("tag");
		String language = request.getParameter("language");
		String year = request.getParameter("year");
		List<String> tagNameList = new ArrayList<String>();
		tagNameList.add(tag);
		tagNameList.add(language);
		tagNameList.add(year);

		int type = Integer.parseInt(request.getParameter("type"));
		List<Repository> repos = new ArrayList<Repository>();
		switch (type) {
		case 1:
			repos = repoByTagDataService.searchAndSortByTagPagination(
					tagNameList, Sort.GENERAL, currentPage, itemsperPage);
			break;
		case 2:
			repos = repoByTagDataService.searchAndSortByTagPagination(
					tagNameList, Sort.STAR, currentPage, itemsperPage);
			break;
		case 3:
			repos = repoByTagDataService.searchAndSortByTagPagination(
					tagNameList, Sort.FORK, currentPage, itemsperPage);
			break;
		case 4:
			repos = repoByTagDataService.searchAndSortByTagPagination(
					tagNameList, Sort.CONTRIBUTOR, currentPage, itemsperPage);
			break;
		default:
			break;
		}

		int totalCount = repoByTagDataService.resultCount(tagNameList,
				Sort.GENERAL);
		result.put("count", totalCount);
		result.put("repos", repos);
		result.put("count", totalCount);
		return result;
	}

	@RequestMapping(value = "/TopTen", method = RequestMethod.POST)
	public Map getTopTen(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Map<String, List> result = new HashMap<String, List>();
		String tag = request.getParameter("tag");
		String language = request.getParameter("language");
		String year = request.getParameter("year");
		System.out.println(tag+","+language+","+year);
		List<String> tagNameList = new ArrayList<String>();
		tagNameList.add(tag);
		tagNameList.add(language);
		tagNameList.add(year);

		List<Repository> repos = repoByTagDataService
				.searchAndSortByTagPagination(tagNameList, Sort.HOT, 0, 5);
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
