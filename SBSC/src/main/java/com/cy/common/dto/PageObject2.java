package com.cy.common.dto;

import java.util.ArrayList;
import java.util.List;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class PageObject2<E> {

	int pageSize = 4; // set 10 20,  has problem, see JS output
	
	int totalNum; 
	int pageNum;
	int numInPage;
	List<E> watches = new ArrayList<E>();
		
	public PageObject2(List<E> watches, int totalNum, int pageNum, int numInPage) {
		super();
		this.watches = watches;
		this.totalNum = totalNum;
		this.pageNum = pageNum;
		this.numInPage = numInPage;
	}	
	
	
}
