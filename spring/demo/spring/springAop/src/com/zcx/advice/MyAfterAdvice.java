/**
 * @Title: MyAfterAdvice.java
 * @Package com.zcx.test
 * @Description: 
 * @author zcx
 * @date 2019年9月28日
 * @version V1.0
 */
package com.zcx.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * @ClassName: MyAfterAdvice
 * @Description: 
 * @author zcx
 * @date 2019年9月28日
 *
 */
public class MyAfterAdvice implements AfterReturningAdvice{

	/* (非 Javadoc)
	 * @param arg0 切点方法返回值
	 * @param arg1 切点方法对象
	 * @param arg2 切点方法参数
	 * @param arg3 切点方法所在的类对象
	 * @throws Throwable
	 */
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("我是后置通知");
	}
}
