package com.cy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.common.dto.JsonResult;
import com.cy.common.pojo.SbscWatch;
import com.cy.service.service.SbscWatchService;

@Controller
@RequestMapping("/watch/")
public class SbscWatchController {
	@Autowired
	private SbscWatchService sbscWatchService;
	@ResponseBody
	@RequestMapping("doFindSexObject")
	public JsonResult doFindSexObject(String watchSex ) {
		List<SbscWatch> list = sbscWatchService.findSexObject(watchSex);
		return new JsonResult(list);	
	}
	
	@ResponseBody
	@RequestMapping("doFindSexObjectLevel")
	public JsonResult doFindSexObjectLevel(Integer watchLevelId, String watchSex) {
		List<SbscWatch> list = sbscWatchService.findSexObjectLevel(watchLevelId, watchSex);
		return new JsonResult(list);	
	}
	
	
}
