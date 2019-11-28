/**
 * @Title: UserService.java
 * @Package com.zcx.service.impl
 * @Description: 
 * @author 13071
 * @date 2019年11月27日
 * @version V1.0
 */
package com.zcx.service.impl;

import com.zcx.pojo.User;

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
	public User selUserInfoService(String uname, String pwd);
}
