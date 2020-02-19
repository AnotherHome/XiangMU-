package com.cy.common.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResult2 implements Serializable{

	private static final long serialVersionUID = -8748276943766688060L;
	
	int state = 0;
	PageObject2 page = null;
	
	public JsonResult2(PageObject2 page) {
		super();
		this.page = page;
	}
	

}





