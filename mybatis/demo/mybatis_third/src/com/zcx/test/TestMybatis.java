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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zcx.pojo.Student;;


/**
 * @ClassName: testMybatis
 * @Description: 
 * @author 13071
 * @date 2019年11月12日
 *
 */

/*
 * Mybatis 使用流程：
 * 		1. 导入相关的 jar 包
 * 		2. 配置 mybatis.xml 配置文件
 * 		3. 配置 xxxmapper.xml 配置文件
 * 		4. 创建 SqlSession 对象，在创建 Mybatis 对象的时候解析相应的配置文件
 * 				通过解析 mybatis.xml 文件获取数据库的相关信息
 * 		 	        同时解析 mapper.xml 文件，获得相关的操作
 * 		5. 调用相应的方法，完成相应的操作
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
	
//		/******** 单表无参数的增删改查操作 ********/
//		//查询单条数据
//		Student stu = ss.selectOne("com.zcx.mapper.StudentsMapper.selOne");
//		System.out.println(stu);
//		//查询多条数据
//		List<Student> stus = ss.selectList("com.zcx.mapper.StudentsMapper.selAll");
//		System.out.println(stus);
//		
//		//无参数的单表插入
//		int num = ss.insert("com.zcx.mapper.StudentsMapper.insert");
//		System.out.println("ins" + num);
//		//无参数的单表修改
//		num = ss.update("com.zcx.mapper.StudentsMapper.update");
//		System.out.println("upd" + num);
//		//无参数的单表删除
//		num = ss.delete("com.zcx.mapper.StudentsMapper.delete");
//		System.out.println("del" + num);
//		
//		ss.commit();
//		/***************************************/
		
		/******** 单表有参数的增删改查操作 ********/
		//查询单条数据
		Student param = new Student();
		param.setId(22);
		param.setName("zcx01");
		Student stu = ss.selectOne("com.zcx.mapper.StudentsMapper.self", param);
		System.out.println(stu);
		
		//查询多条数据，与单条数据的查询一样，只不过是调用 selectList 方法，返回值为一个集合
		
		//使用 Map 集合封装传递的多个参数，进行插入操作
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "gl");
		map.put("age", "21");
		map.put("sex", "女");
		int num = ss.insert("com.zcx.mapper.StudentsMapper.insf", map);
		System.err.println("insert data numbers:" + num);
		ss.commit();
		
		//删除与修改和增加操作相似，直接封装参数为对象或者  Map 集合就好
		/***************************************/
	}
}














