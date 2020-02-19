package com.cy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.common.dto.JsonResult2;
import com.cy.common.dto.PageObject2;
import com.cy.service.service.SysFemaleWatchService;
import com.cy.service.service.SysMaleWatchService;



@Controller
//@RestController
@RequestMapping("/")
public class PagesexController {
	
	@Autowired
	private SysFemaleWatchService sysFemaleWatchService;
	
	@Autowired
	private SysMaleWatchService sysMaleWatchService;
		

	
	@RequestMapping("girlxxx")
	@ResponseBody
	public JsonResult2 girlxxx(int cur) {
		//System.out.println(page);
		System.out.println("PageController.girlxxx()");
		System.out.println("cur "+cur);
		
		PageObject2 pageObj = null; 
		//int cur=1;
		pageObj = sysFemaleWatchService.findPageObject(cur);
		
		return new JsonResult2(pageObj);
	}
	
	@RequestMapping("boysxxx")
	@ResponseBody
	public JsonResult2 boysxxx(int cur) {
		//System.out.println(page);
		System.out.println("PageController.boysxxx()");
		System.out.println("cur "+cur);
		
		PageObject2 pageObj = null; 
		//int cur=1;
		pageObj = sysMaleWatchService.findPageObject(cur);
		
		return new JsonResult2(pageObj);
	}
	
	//watchSex="women" & watchName="雅克利曼"
	@RequestMapping("girlyyy")
	@ResponseBody
	public JsonResult2 girlyyy(int cur, String watchName) {
		//System.out.println(page);
		System.out.println("PageController.girlxxx()");
		System.out.println("cur "+cur);
		
		PageObject2 pageObj = null; 
		//int cur=1;
		pageObj = sysFemaleWatchService.findPageObjectByName(cur, watchName);
		
		return new JsonResult2(pageObj);
	}
		
}




