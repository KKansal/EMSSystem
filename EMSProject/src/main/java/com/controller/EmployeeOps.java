package com.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.DepartmentDao;
import com.dao.EmployeeDao;
import com.to.Department;


@Controller
@RequestMapping(value = "/admin")
public class EmployeeOps {
	
	
	@Autowired
	private DepartmentDao deptDao;
	
	@Autowired
	private EmployeeDao empDao;

	
	@RequestMapping("/")
	public String displayAdminHomePage() {
		return "admin";
	}
	
	@RequestMapping(value = "/addEmployee", method=RequestMethod.POST)
	public ModelAndView addEmployee(@RequestParam("fname") String fname,
							  @RequestParam("lname") String lname,
							  @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
							  @RequestParam("email") String email,
							  @RequestParam("department") int department){
		
		ModelAndView res  = new ModelAndView("addEmployee");
		
		Period diff = Period.between(date, LocalDate.now());
		
		
		if(diff.getYears() < 25){
			res.addObject("color","red");
			res.addObject("message","Unable to add Employee, Age less than 25");
			return res;
		}
		
		Department dept = deptDao.getDeptbyId(department);
		
		if(dept == null) {
			res.addObject("color","red");
			res.addObject("message","Unable to add Employee, Invalid Department ID");
			return res;
			
		}
		
		
		int newEmpId = empDao.addEmployee(fname, lname, date, email, dept);
		
		res.addObject("color","green");
		res.addObject("message","Employee Added, Employee Id = " + newEmpId);
		return res;
		
	}
	
	@RequestMapping("/viewEmployee")
	public ModelAndView viewEmployee() {
		
		return new ModelAndView("viewEmployee","employeeList",empDao.getAllEmployees());
		
	}
	
	
	@RequestMapping("/editEmployee")
	public ModelAndView editEmployee(@RequestParam("empId") int empId,
			  @RequestParam("fname") String fname,
			  @RequestParam("lname") String lname,
			  @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			  @RequestParam("email") String email,
			  @RequestParam("department") int department) {
		
		ModelAndView res = new ModelAndView("editEmployee");
		
		Department dept = deptDao.getDeptbyId(department);
		
		if(dept == null) {
			res.addObject("color","red");
			res.addObject("message","Unable to edit Employee, Invalid Department ID");
			return res;
			
		}
		else if(!empDao.editEmployee(empId, fname, lname, date, email, dept)) {
			res.addObject("color","red");
			res.addObject("message","Unable to edit Employee, Invalid Employee ID");
			return res;
			
		}
		res.addObject("color","green");
		res.addObject("message","Employee Updated");
		return res;

	}
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public ModelAndView deleteEmployee(@RequestParam("empId") int empId) {
		
		ModelAndView res = new ModelAndView("deleteEmployee");
		
		if(empDao.deleteEmployee(empId) == false) {
			res.addObject("color","red");
			res.addObject("message", "Invalid Employee Id");
		}else {
			res.addObject("color","green");
			res.addObject("message", "Employee Deleted");
		}
		return res;
		
	}
	
	
	
}
