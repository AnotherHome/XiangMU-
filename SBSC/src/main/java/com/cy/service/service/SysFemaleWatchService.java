package com.cy.service.service;

import org.springframework.stereotype.Service;

import com.cy.common.dto.PageObject2;
import com.cy.common.pojo.Watch;




public interface SysFemaleWatchService {

	PageObject2<Watch> findPageObject(int curPage);
	
	PageObject2<Watch> findPageObjectByName(int curPage, String watchName);
		
}
