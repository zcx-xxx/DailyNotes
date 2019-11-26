/**
 * @Title: Student.java
 * @Package com.zcx.pojo
 * @Description: 
 * @author 13071
 * @date 2019年11月12日
 * @version V1.0
 */
package com.zcx.pojo;

/**
 * @ClassName: Student
 * @Description: 
 * @author 13071
 * @date 2019年11月12日
 *
 */
public class Student {
	private Integer id;
	private String name;
	private Integer age;
	private String sex;
	private Teacher teacher;
	
	public Student(Integer id, String name, Integer age, String sex, Teacher teacher) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.teacher = teacher;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Student() {
		System.out.println("无参构造器");
	}
	public Student(Integer id, String name, Integer age, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", teacther=" + teacher
				+ "]";
	}

}
