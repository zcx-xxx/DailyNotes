/**
 * @Title: UserServiceImpl.java
 * @Package com.zcx.service.impl
 * @Description: 
 * @author 13071
 * @date 2019年11月26日
 * @version V1.0
 */
package com.zcx.service.impl;
import com.zcx.mapper.UserMapper;
import com.zcx.pojo.User;
import com.zcx.service.UserService;

/**
 * @ClassName: UserServiceImpl
 * @Description: 
 * @author 13071
 * @date 2019年11月26日
 *
 */
public class UserServiceImpl implements UserService {
	private UserMapper mapper;
	
	public UserMapper getMapper() {
		return mapper;
	}
	public void setMapper(UserMapper mapper) {
		this.mapper = mapper;
	}
	/* (非 Javadoc)
	 * <p>Title: checkLogin</p>
	 * <p>Description: </p>
	 * @param uname
	 * @param pwd
	 * @return
	 * @see com.zcx.service.UserService#checkLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public User checkLogin(String uname, String pwd) {
		System.out.println(uname + " " + pwd);
		User user = mapper.queryUserByNameAndPwd(uname, pwd);

		return user;
	}
}
