/**
 * @Title: testMybatis.java
 * @Package com.zcx.test
 * @Description: 
 * @author 13071
 * @date 2019年11月12日
 * @version V1.0
 */
package com.zcx.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zcx.mapper.StudentsMapper;
import com.zcx.pojo.Student;;


/**
 * 动态拼接 SQL 的学习
 * @ClassName: testMybatis
 * @Description: 
 * @author 13071
 * @date 2019年11月12日
 *
 */
public class TestMybatis {
	public static void main(String[] args) throws IOException {
		//创建 Mybatis 对象
		//获取配置文件流对象
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//获取 SqlSessionFactory 工厂(底层完成了配置文件的解析)
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//获取 SqlSession 对象
		SqlSession ss = factory.openSession();
		//获得 Mapper，相当于之前 Dao 接口的实例化对象
		StudentsMapper mapper = ss.getMapper(StudentsMapper.class);
		
		//if 标签
		Student stu = mapper.queryStudentByNameAndId(28, "zcxlala");
		System.out.println(stu);
		
		//where 标签
		Student stu1 = mapper.queryStudentByNameAndId2(null, "zcxlala");
		System.out.println(stu1);
		
		//choose 标签的使用
		Student stu2 = mapper.queryStudentUseChoose(null, "");
		System.out.println(stu2);
		
		//set 标签的使用
		int row = mapper.updateStudentById("zcxkaka", 22);
		System.out.println(row);
		
		List<Integer> cons = new ArrayList<Integer>();
		cons.add(26);
		cons.add(30);
		cons.add(33);
		cons.add(28);
		List<Student> stus = mapper.queryUseIn(cons);
		System.out.println(stus);
		
		List<Student> stus2 = mapper.queryUseBind("zcx");
		System.out.println(stus2);
		//提交
		ss.commit();
	}
}














