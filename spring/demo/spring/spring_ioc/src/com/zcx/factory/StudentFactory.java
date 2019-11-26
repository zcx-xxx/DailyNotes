/**
 * @Title: StudentFactory.java
 * @Package com.zcx.factory
 * @Description: 
 * @author 13071
 * @date 2019年11月26日
 * @version V1.0
 */
package com.zcx.factory;

import com.zcx.pojo.Student;
import com.zcx.pojo.Teacther;

/**
 * @ClassName: StudentFactory
 * @Description: 
 * @author 13071
 * @date 2019年11月26日
 *
 */
public class StudentFactory {
	//静态工厂，方法是静态的
	public static Student newInstance() {
		Teacther teacther = new Teacther(100);
		Student stu = new Student(1, "zcx", 18, "man", teacther);
		
		return stu;
	}
	
	//动态工厂
	public Student newInstance2() {
		Teacther teacther = new Teacther(100);
		Student stu = new Student(1, "zcx", 18, "man", teacther);
		
		return stu;
	}
}
