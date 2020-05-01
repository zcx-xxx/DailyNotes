/**
 * @Title: Student.java
 * @Package com.zcx.entity
 * @Description: 
 * @author 13071
 * @date 2020年2月19日
 * @version V1.0
 */
package com.zcx.entity;

/**
 * @ClassName: Student
 * @Description: 
 * @author 13071
 * @date 2020年2月19日
 *
 */
public class Student {
	private Integer id;
	private String name;
	private Integer age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Student() {
	}
}
