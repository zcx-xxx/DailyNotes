/**
 * @Title: UserService.java
 * @Package com.edrop.service.impl
 * @Description: 
 * @author 13071
 * @date 2019年11月27日
 * @version V1.0
 */
package com.edrop.service.impl;

import com.edrop.pojo.DDUser;

/**
 * 提供用户的服务
 * @ClassName: UserService
 * @Description: 
 * @author 13071
 * @date 2019年11月27日
 *
 */
public interface UserService {
	//获得用户的信息
	public DDUser selUserInfoService(String uname, String pwd);
}
