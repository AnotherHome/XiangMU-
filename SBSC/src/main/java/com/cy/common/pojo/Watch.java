package com.cy.common.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Watch {

	Integer id;
	String watchImg; //img_sb_16
	String watchName; //like 女士石英表
	String watchIntroduce; //like 经典唯美透窗表盘设计 
	Double watchPrice; 
	Double watchSale;
	Integer watchInventory;
	String watchSex; //"woman", "man"
	
	//unused
	Integer watchSell;
	Integer watchLike;
	Integer watchComment;
	Integer watchLevelId;
}
