/**
 * @Title: Demo.java
 * @Package com.zcx.pojo
 * @Description: 
 * @author zcx
 * @date 2019年9月28日
 * @version V1.0
 */
package com.zcx.pojo;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Demo
 * @Description: 
 * @author zcx
 * @date 2019年9月28日
 *
 */
@Component
public class Demo {
	@Pointcut("execution(* com.zcx.pojo.Demo.demo())")
	public void demo() {
		System.out.println("我是切点");
	}
}
