package com.urillah.empireproj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpireController {

	@GetMapping("/Test")
	public String test() {
		return "<h1> Hello From EmpireController </h1>";
	}
	
	
}
