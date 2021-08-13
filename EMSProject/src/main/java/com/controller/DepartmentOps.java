package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.DepartmentDao;

@Controller
@RequestMapping("/admin")
public class DepartmentOps {
	@Autowired
	private DepartmentDao deptDao;
		
	@RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
	public ModelAndView addDepartment(@RequestParam("deptName") String deptName) {
		
		ModelAndView res = new ModelAndView("addDepartment");
		
		int deptId = deptDao.addDept(deptName);
		
		res.addObject("color","green");
		res.addObject("message","Added Department with Id "+ deptId);
		
		
		return res;
		
		
	}
	
	@RequestMapping(value = "/viewDepartment")
	public ModelAndView viewDepartment() {
		
		System.out.println("hello " + deptDao.getAllDepts().size());
		return new ModelAndView("viewDepartment","departmentList",deptDao.getAllDepts());
	}

	
}
