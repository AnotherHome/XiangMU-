package com.cy.common.pojo;

import lombok.Data;

@Data
public class ZcEntity {

	//用户名
	private String username;
	//密码
	private String password;
	//会员名
	private String memberName;
	//电子邮箱
	private String memberEmail;
	//手机号码
	private Integer  memberTel;

}
