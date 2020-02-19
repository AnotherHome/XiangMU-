package com.cy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.common.dto.JsonResult;
import com.cy.common.pojo.ZcEntity;
import com.cy.service.service.ZcService;


@RestController
@RequestMapping("/ZhuCe/")
public class ZcController {

	@Autowired
	private ZcService  zcService;
	
	
	
	@RequestMapping("doinsertZc")
	public JsonResult doinsertZc(ZcEntity Zentity) {
		
		
		zcService.insertObject(Zentity);
		
		
		return new JsonResult("注册成功！");
		
	}
	
}
