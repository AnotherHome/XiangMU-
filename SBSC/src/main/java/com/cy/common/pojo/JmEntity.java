package com.cy.common.pojo;

import java.io.Serializable;

import lombok.Data;

/*
 *    本类预用于存储寄卖添加的数据
 */

public class JmEntity implements Serializable {

	
	private static final long serialVersionUID = 8624897575824958225L;
	/****************************************************************************************************/	
	/**用于存储寄卖添加的数据*/
	
	
	//手表名称
	private  String jmWatchName;
	//手表型号
	private String jmModel;
	//手表图片
	private String jmImg;
	//期望到手价
	private Double  jmPrice;
	//姓名
	private String jmUsername;
	//手机号
	private Integer jmTel;
	//邮箱
	private String jmEmail;
	//QQ
	private Integer jmQq;
	//其他要求
	private String jmText;
	
/****************************************************************************************************/	
	public String getJmWatchName() {
		return jmWatchName;
	}
	public void setJmWatchName(String jmWatchName) {
		this.jmWatchName = jmWatchName;
	}
	public String getJmModel() {
		return jmModel;
	}
	public void setJmModel(String jmModel) {
		this.jmModel = jmModel;
	}
	public String getJmImg() {
		return jmImg;
	}
	public void setJmImg(String jmImg) {
		this.jmImg = jmImg;
	}
	public Double getJmPrice() {
		return jmPrice;
	}
	public void setJmPrice(Double jmPrice) {
		this.jmPrice = jmPrice;
	}
	public String getJmUsername() {
		return jmUsername;
	}
	public void setJmUsername(String jmUsername) {
		this.jmUsername = jmUsername;
	}
	public Integer getJmTel() {
		return jmTel;
	}
	public void setJmTel(Integer jmTel) {
		this.jmTel = jmTel;
	}
	public String getJmEmail() {
		return jmEmail;
	}
	public void setJmEmail(String jmEmail) {
		this.jmEmail = jmEmail;
	}
	public Integer getJmQq() {
		return jmQq;
	}
	public void setJmQq(Integer jmQq) {
		this.jmQq = jmQq;
	}
	public String getJmText() {
		return jmText;
	}
	public void setJmText(String jmText) {
		this.jmText = jmText;
	}
	@Override
	public String toString() {
		return "JmEntity [jmWatchName=" + jmWatchName + ", jmModel=" + jmModel + ", jmImg=" + jmImg + ", jmPrice="
				+ jmPrice + ", jmUsername=" + jmUsername + ", jmTel=" + jmTel + ", jmEmail=" + jmEmail + ", jmQq="
				+ jmQq + ", jmText=" + jmText + "]";
	}
	
	
	
}
