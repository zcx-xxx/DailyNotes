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

import com.zcx.mapper.StudentsMapper;
import com.zcx.pojo.Student;;


/**
 * @ClassName: testMybatis
 * @Description: 
 * @author 13071
 * @date 2019年11月12日
 *
 */
/**
 * 基于 SQL 动态代理的方式进行数据库的操作（只写了查询的操作，其他的操作仅仅是操作数据库代码不同）
 * Mybatis SQL 动态代理方式的实现原理：
 * 		Mybatis 的 SQL 动态代理方式相当于帮助我们动态生成了 DaoImpl 类（以前是由自己实现的），每一个 SQL 操作
 * 	所需要的 SQL 语句，从相应的 xxxxMapper.xml 文件中获得，因此需要保证 xxxxMapper.xml 和 Dao 接口（xxxxMapper.java）
 * 	拥有相同的文件名，xxxxMapper.java 中的方法名需要与 xxxxMapper.xml 文件中的 SQL 语句所对应的 id 相同
 * 		在执行完创建 SqlSession 对象之后就已经完成了所需的 DaoImpl 实现类的动态生成，接下来直接使用相应 Dao 接口的
 * 	类信息获取相应的 Impl 实现类即可
 * 
 * Mybatis SQL 动态代理方式的实现流程：
 * 	1. 在 Mybatis.xml 文件中配置 Mapper 文件扫描
 * 		<mappers>
			<package name="com.zcx.mapper"/>
		</mappers>
	2. 在 Mapper 包中创建接口文件和Sq1语句配置文件注意：接口和 Sq1 语句的配置文件名字必须相同，接口的方法名和Sq1配置文件
	    的标签ID名必须相同
	   目的：在将 Mapper 接口翻译成起对应的实例化对象时，根据此规则可以找到对应的SQL语句。
 *	3. 获取 Sq1Session 对象，使用 Sq1Session 对象获取 Mapper 接口的实例化对象 ss.getMapper（接口的类对象），返回接口的实例化对象
 */

/*
面试题：
	问：mybatis中SQL占位中的#{}和${}有什么区别
	答：
		#{}占位的底层使用的是PreparedStatement对象进行数据库操作，#{}占位会翻译成？占位
		${}占位的底层使用的是Statement对象进行数据库操作，会将数据直接拼接在SQL语句中|
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
		
		/* 无参数的操作 */
			//查询出所有的信息
			List<Student> stus = mapper.queryAllStudents();
			System.out.println(stus);
		
		/* 具有单参数的查询 */
			//基本数据类型
			Student stu = mapper.queryStudentById(22);
			System.out.println(stu.toString());
			//对象数据类型
			Student stu1 = mapper.queryStudentById2(new Student(29, null, null, null));
			System.out.println(stu1);
		
		/*多个参数的查询*/
			//多个基本类型参数的查询
			Student stu2 = mapper.queryStudentByMultiArg(28, 11);
			System.out.println(stu2);
			
			//基本类型的参数和引用类型的参数混用
			Student stu3 = mapper.queryStudentByMultiArg2(29, new Student(null, null, 8, null));
			System.out.println(stu3);
		
		/* 注解方式 */
			Student stu4 = mapper.queryStudentUseAnnotation(29, new Student(null, null, 8, null));
			System.out.println("annotation:" + stu4);
	}
}














