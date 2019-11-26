/**
 * @Title: TestSpringIoc.java
 * @Package com.zcx.test
 * @Description: 
 * @author 13071
 * @date 2019年11月25日
 * @version V1.0
 */
package com.zcx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zcx.pojo.Student;

/**
 * @ClassName: TestSpringIoc
 * @Description: 
 * @author 13071
 * @date 2019年11月25日
 *
 */
public class TestSpringIoc {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext.xml");
		
		//构造器注入之依赖注入
		Student stu1 = (Student)ac.getBean("stu1");
		System.out.println(stu1);

		//属性注入之依赖注入
		Student stu2 = (Student)ac.getBean("stu2");
		System.out.println(stu2);
	}
}
