package org.gitmining.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.gitmining.bean.SimpleRepo;
import org.gitmining.bean.Tag;
import org.gitmining.service.RepoByTagDataService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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
		List<Tag> firsTags=(ArrayList<Tag>)repoByTagDataService.listFirstTag();
		result.put("tags", firsTags);
		return new ModelAndView("overview", "result", result);
	}
	
	@RequestMapping(value = "/repos")
	public ModelAndView getReposView(HttpServletRequest request)
			throws Exception {
		String tagName=request.getParameter("tag");
		String type=request.getParameter("type");
		System.out.println(tagName+"fefew"+type);
		List<SimpleRepo> repos=repoByTagDataService.searchAndSortByTag(tagName, type);
		System.out.println(repos.size());
		ModelMap result = new ModelMap();
		result.put("repos", repos);
		result.put("type", "REPOSITORY");
		List<Tag> firsTags=(ArrayList<Tag>)repoByTagDataService.listFirstTag();
		result.put("tags", firsTags);
		return new ModelAndView("allrepos", "result", result);
	}


	public RepoByTagDataService getRepoByTagDataService() {
		return repoByTagDataService;
	}

	public void setRepoByTagDataService(RepoByTagDataService repoByTagDataService) {
		this.repoByTagDataService = repoByTagDataService;
	}
}
