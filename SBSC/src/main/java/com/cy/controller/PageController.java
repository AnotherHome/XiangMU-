package com.cy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
		
	@RequestMapping("{page}")
	public String doJump(@PathVariable String page) {
		System.out.println(page);	
		return page;
		
	}
	
}
