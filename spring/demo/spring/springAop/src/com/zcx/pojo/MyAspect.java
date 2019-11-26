/**
 * @Title: MyAspect.java
 * @Package com.zcx.pojo
 * @Description: 
 * @author zcx
 * @date 2019年9月28日
 * @version V1.0
 */
package com.zcx.pojo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyAspect
 * @Description: 
 * @author zcx
 * @date 2019年9月28日
 *
 */

@Component
@Aspect
public class MyAspect {
	@Before("com.zcx.pojo.Demo.demo()")
	public void before() {
		System.out.println("我是前置通知");
	}
	@After("com.zcx.pojo.Demo.demo()")
	public void after() {
		System.out.println("我是后置通知");
	}
	@AfterReturning("com.zcx.pojo.Demo.demo()")
	public void afterRunning() {
		System.out.println("我是返回通知");
	}
	@Around("com.zcx.pojo.Demo.demo()")
	public void round(ProceedingJoinPoint pjp) {
		System.out.println("我是环绕前");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("我是环绕后");
	}
	@AfterThrowing("com.zcx.pojo.Demo.demo()")
	public void myThrow() {
		System.out.println("我是异常通知");
	}
}
