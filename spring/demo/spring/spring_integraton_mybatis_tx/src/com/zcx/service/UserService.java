/**
 * @Title: UserService.java
 * @Package com.zcx.service.impl
 * @Description: 
 * @author 13071
 * @date 2019年11月26日
 * @version V1.0
 */
package com.zcx.service;

import com.zcx.pojo.User;

/**
 * @ClassName: UserService
 * @Description: 
 * @author 13071
 * @date 2019年11月26日
 *
 */
public interface UserService {
	public User checkLogin(String uname, String pwd);
}
