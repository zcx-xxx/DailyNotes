/**
 * @Title: TestService.java
 * @Package com.zcx.test
 * @Description: 
 * @author 13071
 * @date 2019年11月26日
 * @version V1.0
 */
package com.zcx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zcx.pojo.User;
import com.zcx.service.UserService;
import com.zcx.service.impl.UserServiceImpl;

/**
 * @ClassName: TestService
 * @Description: 
 * @author 13071
 * @date 2019年11月26日
 *
 */
public class TestService {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext.xml");
//		UserService userService = new UserServiceImpl();
		UserService userService = (UserService) ac.getBean("userService");
		User user = userService.checkLogin("zcx", "123");
		System.out.println(user);
	}
}
