/**
 * @Title: MyRound.java
 * @Package com.zcx.advice
 * @Description: 
 * @author zcx
 * @date 2019年9月28日
 * @version V1.0
 */
package com.zcx.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @ClassName: MyRound
 * @Description: 
 * @author zcx
 * @date 2019年9月28日
 *
 */
public class MyRound implements MethodInterceptor{

	/* (非 Javadoc)
	 * @param arg0
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("环绕前");
		Object res = arg0.proceed();           //放行，调用切点方法
		System.out.println("环绕后");
		return res;
	}
}
