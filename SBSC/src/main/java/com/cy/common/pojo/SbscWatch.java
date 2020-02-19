package com.cy.common.pojo;

import lombok.Data;

@Data
public class SbscWatch {
	
	private Integer id;
	private String watchImg;
	private String watchName;
	private String watchIntroduce;
	private Double watchPrice;
	private Double watchSale;
	private Integer watchInventory;
	private Integer watchSell;
	private boolean watchLike;
	private Integer watchComment;
	private Integer watchLevelId;
	private String watchSex;
}
