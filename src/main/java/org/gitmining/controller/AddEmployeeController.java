package org.gitmining.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gitmining.bean.Employee;
import org.gitmining.dao.EmployeeDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
@RestController
public class AddEmployeeController implements Controller{	
	EmployeeDao employeeDao;
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	@RequestMapping(value="/addEmployee")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("啊啊啊");
		employeeDao.insertEmployee(employee);
		ModelAndView view = new ModelAndView("hello");
		return view;
	}
}
