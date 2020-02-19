package com.cy.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cy.common.pojo.SbscWatch;


public interface SbscWatchService {
	List<SbscWatch> findSexObject(String watchSex);
	
	List<SbscWatch> findSexObjectLevel(Integer watchLevelId ,String watchSex);

}
