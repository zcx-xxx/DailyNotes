/**
 * @Title: MyBeforeAdvice.java
 * @Package com.zcx.test
 * @Description: 
 * @author zcx
 * @date 2019年9月28日
 * @version V1.0
 */
package com.zcx.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @ClassName: MyBeforeAdvice
 * @Description: 
 * @author zcx
 * @date 2019年9月28日
 *
 */
public class MyBeforeAdvice implements MethodBeforeAdvice{

	/* (非 Javadoc)
	 * @param arg0 切点方法对象 Method 对象
	 * @param arg1 切点方法参数
	 * @param arg2 切点在哪个对象中
	 * @throws Throwable
	 */
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("我是前置通知");		
	}
}
