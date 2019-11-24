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

import com.zcx.pojo.Student;

/**
 * @ClassName: StudentsMapper
 * @Description: 
 * @author 13071
 * @date 2019年11月23日
 */
public interface StudentsMapper {
	//if 标签的使用：通过 id 和 name 查询学生
	public Student queryStudentByNameAndId(int id, String name);

	//where 标签的使用
	public Student queryStudentByNameAndId2(Integer id, String name);
	
	//choose 标签的使用
	public Student queryStudentUseChoose(Integer id, String name);
	
	//set 标签的使用
	public int updateStudentById(String name, Integer id);
	
	//forEach 标签的使用
	public List<Student> queryUseIn(List<Integer> list);
	
	//bind 标签的使用
	public List<Student> queryUseBind(String name);
}
