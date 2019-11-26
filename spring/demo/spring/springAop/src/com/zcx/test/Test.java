/**
 * @Title: Test.java
 * @Package com.zcx.test
 * @Description: 
 * @author zcx
 * @date 2019年9月28日
 * @version V1.0
 */
package com.zcx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zcx.pojo.Demo;
import com.zcx.pojo.TestDemoZcx;

/**
 * @ClassName: Test
 * @Description: 
 * @author zcx
 * @date 2019年9月28日
 *
 */
public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext.xml");
//		Demo d = (Demo) ac.getBean("demo");
//		d.demo();
		TestDemoZcx zcx = (TestDemoZcx) ac.getBean("TestDemoZcx");
		zcx.print();
	}
}
