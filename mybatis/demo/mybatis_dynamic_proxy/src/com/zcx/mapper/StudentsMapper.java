/**
 * @Title: StudentsMapper.java
 * @Package com.zcx.mapper
 * @Description: 
 * @author 13071
 * @date 2019年11月23日
 * @version V1.0
 */
package com.zcx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zcx.pojo.Student;

/**
 * @ClassName: StudentsMapper
 * @Description: 
 * @author 13071
 * @date 2019年11月23日
 */
/*
 * 注意：
 * 		该接口中的方法不可以进行重载，因为 Mybatis 规定，xxxxMapper.xml 中 SQL 语句的 id 字段必须与相应
 * 		的查询方法的方法名相同，但是由于 id 值不可以相同，因此方法名也不可以相同
 */
public interface StudentsMapper {
	/************** 无参数的查询 ***************/
	/**
	 * 查询所有的学生信息
	 * @Title: queryAllStudents
	 * @Description:
	 * @return
	 * @return List<Student>
	 * @throws
	 */
	public List<Student> queryAllStudents();
	
	/************** 单个参数的查询 ***************/
	/**
	 * 根据 id 查询单个学生的信息（单个基本类型的参数）
	 * @Title: queryStudentById
	 * @Description:
	 * @return
	 * @return Student
	 * @throws
	 */
	public Student queryStudentById(int id);
	/**
	 * 根据 id 查询单个学生的信息（单个引用类型的参数）
	 * 		注意：该处的方法名必须和上边的方法名不一样，不可以进行方法的重载
	 * @Title: queryStudentById2
	 * @Description:
	 * @param student
	 * @return
	 * @return Student
	 * @throws
	 */
	public Student queryStudentById2(Student student);
	
	/************** 多个参数的查询 ***************/
	//多个基本类型参数的查询
	public Student queryStudentByMultiArg(int id, int age);

	//基本类型的参数和引用类型的参数混用
	public Student queryStudentByMultiArg2(int id, Student student);
	
	/************** 注解的使用 ***************/
	public Student queryStudentUseAnnotation(@Param("id")int id, @Param("stu")Student stu);
	
}
