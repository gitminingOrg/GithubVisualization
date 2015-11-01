package org.gitmining.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
@RestController
public class HelloController implements Controller {
	@RequestMapping(value="/hello")
	public ModelAndView handleRequest(String id, ModelMap modelMap,HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		//ModelAndView view = new ModelAndView("hello");
		//view.addObject("mes", "hello");
		return new ModelAndView("user");
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
