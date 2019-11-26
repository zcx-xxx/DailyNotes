/**
 * @Title: UserMapper.java
 * @Package com.zcx.mapper
 * @Description: 
 * @author 13071
 * @date 2019年11月26日
 * @version V1.0
 */
package com.zcx.mapper;

import com.zcx.pojo.User;

/**
 * @ClassName: UserMapper
 * @Description: 
 * @author 13071
 * @date 2019年11月26日
 *
 */
public interface UserMapper {
	//查询用户是否存在
	public User selectUserByNameAndPwd(String uname, String pwd);
}
