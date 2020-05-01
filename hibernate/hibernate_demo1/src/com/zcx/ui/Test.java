/**
 * @Title: Test.java
 * @Package com.zcx.ui
 * @Description: 
 * @author 13071
 * @date 2020年2月19日
 * @version V1.0
 */
package com.zcx.ui;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zcx.entity.Student;
import com.zcx.util.HibernateUtil;

/**
 * @ClassName: Test
 * @Description: 
 * @author 13071
 * @date 2020年2月19日
 *
 */
public class Test {
	public static void main(String[] args) {
		Student student = new Student();
		student.setId(1);
		student.setName("zcx");
		student.setAge(11);
		
		// 获得 session 对象
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		if (session == null) {
			System.out.println("haha");
		}
		
		// 开启事务
		Transaction tx = session.beginTransaction();
		
		// 保存数据
		session.save(student);
		
		// 提交事务
		tx.commit();
		
		// 关闭 session
		session.close();
		
		HibernateUtil.closeSessionFactory();
	}
}
