package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/admin", method=RequestMethod.GET)
public class AdminHomePage {
	
	@RequestMapping("/")
	public String displayAdminHomePage() {
		return "admin";
	}
	
	@RequestMapping("/addEmployee")
	public String addEmployee() {
		return "addEmployee";
		
	}
	
	/*
	@RequestMapping("/viewEmployee")
	public String viewEmployee() {
		return "viewEmployee";	
	}
	*/
	
	@RequestMapping("/editEmployee")
	public String updateEmployee() {
		return "editEmployee";
	}
	
	@RequestMapping("/deleteEmployee")
	public String deleteEmployee() {
		return "deleteEmployee";
	
	}
	
	@RequestMapping("/addDepartment")
	public String addDepartment() {
		return "addDepartment";
	}
	
	/*
	
	@RequestMapping("/viewDepartment")
	public String viewDepartment() {
		return "viewDepartment";
	}
	
	*/
	
	@RequestMapping("/addCompliance")
	public String addCompliance() {
		return "addCompliance";
	}
	
	
}
