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
		
		//不进行配置，默认调用的是无参构造器
		Student stu = (Student)ac.getBean("stu");
		System.out.println(stu);
		
		//有参构造器
		Student stu2 = (Student)ac.getBean("stu2");
		System.out.println(stu2);
		
		//静态工厂
		Student stu3 = (Student)ac.getBean("stu3");
		System.out.println("s3:" + stu3);

		//动态工厂
		Student stu4 = (Student)ac.getBean("stu4");
		System.out.println("s4:" + stu4);
		
		//属性注入
		Student stu5 = (Student)ac.getBean("stu5");
		System.out.println("s5:" + stu5);
		
	}
}
