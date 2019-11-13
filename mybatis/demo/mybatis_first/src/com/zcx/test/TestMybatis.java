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
import java.util.List;

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
 * 		1。 导入相关的 jar 包
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
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession ss = factory.openSession();
	
		//查询所有的学生信息
		List<Student> stus = ss.selectList("com.zcx.mapper.FolwerMapper.stu");
		System.out.println(stus);
	}
}
