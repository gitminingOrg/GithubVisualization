package org.gitmining.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		List<Tag> firsTags=(ArrayList<Tag>)repoByTagDataService.listFirstTag();
		result.put("tags", firsTags);
		return new ModelAndView("overview", "result", result);
	}
	
	@RequestMapping(value = "/repos")
	public ModelAndView getReposView(HttpServletRequest request)
			throws Exception {
		String tagName=request.getParameter("tag");
		List<SimpleRepo> repos=repoByTagDataService.searchAndSortByTag(tagName, Sort.GENERAL);
		ModelMap result = new ModelMap();
		result.put("repos", repos);
		result.put("type", "REPOSITORY");
		List<Tag> firsTags=(ArrayList<Tag>)repoByTagDataService.listFirstTag();
		List<Tag> secondTags=(ArrayList<Tag>)repoByTagDataService.listSecondTag(tagName);
		result.put("tags", firsTags);
		result.put("secondTags", secondTags);
		result.put("searchTag", tagName);
		return new ModelAndView("allrepos", "result", result);
	}
	
	@RequestMapping(value="/TopTen",method=RequestMethod.POST)
	public Map getTopTen(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub	
		Map<String, List> result = new HashMap<String, List>();
		
		List<String> tags=new ArrayList<String>();
		tags.add(new String("typeA"));
		List<SimpleRepo> repos=repoByTagDataService.getReposSortByHot(tags);
		result.put("repos", repos);
		return result;
	}
	
	@RequestMapping(value="/repos/star",method=RequestMethod.POST)
	public Map getStarRepos(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub	
		Map<String, List> result = new HashMap<String, List>();
		List<SimpleRepo> repos=repoByTagDataService.searchAndSortByTag("typeA", Sort.STAR);
		result.put("repos", repos);
		return result;
	}
	
	@RequestMapping(value="/repos/fork",method=RequestMethod.POST)
	public Map getForkRepos(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub	
		Map<String, List> result = new HashMap<String, List>();
		List<SimpleRepo> repos=repoByTagDataService.searchAndSortByTag("typeA", Sort.FORK);
		result.put("repos", repos);
		return result;
	}



	public RepoByTagDataService getRepoByTagDataService() {
		return repoByTagDataService;
	}

	public void setRepoByTagDataService(RepoByTagDataService repoByTagDataService) {
		this.repoByTagDataService = repoByTagDataService;
	}
}
