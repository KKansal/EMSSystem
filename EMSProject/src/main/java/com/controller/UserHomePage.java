package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserHomePage {

	@RequestMapping("/updateStatusReports")
	public String displayUpdatStatusReports() {
		return "updateStatusReports";
	}
	
	
}
