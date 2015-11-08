package org.gitmining.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RepositoryDataController {
	@RequestMapping(value = "/simpleRepo")
	public ModelAndView getUserView(HttpServletRequest request)
			throws Exception {
		return new ModelAndView("SearchRepository");
	}
}
