package com.urillah.empireproj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpireController {

	@GetMapping("/")
	public String test() {
		return "<h1> Hello From EmpireController </h1>";
	}
	
	
}
