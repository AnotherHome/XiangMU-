package com.cy.common.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserEntity implements Serializable{
	private static final long serialVersionUID = -965809193462945177L;
	
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
