/**
 * @Title: UserServiceImpl.java
 * @Package com.edrop.service.impl
 * @Description: 
 * @author 13071
 * @date 2019年11月27日
 * @version V1.0
 */
package com.edrop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edrop.mapper.UserMapper;
import com.edrop.pojo.DDUser;

/**
 * @ClassName: UserServiceImpl
 * @Description: 
 * @author 13071
 * @date 2019年11月27日
 *
 */
//注解方式配置为 bean 对象
@Service
public class UserServiceImpl implements UserService {
	//注解进行依赖注入（已经在配置文件中声明按名字进行依赖注入 ）
	@Resource
	private UserMapper userMapper;
	/* (非 Javadoc)
	 * <p>Title: selUserInfoService</p>
	 * <p>Description: </p>
	 * @param uname
	 * @param pwd
	 * @return
	 * @see com.edrop.service.impl.UserService#selUserInfoService(java.lang.String, java.lang.String)
	 */
	@Override
	public DDUser selUserInfoService(String uname, String pwd) {
		return userMapper.getUserInfo(uname, pwd);
	}

}
