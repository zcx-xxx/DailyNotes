/**
 * @Title: HibernateUtil.java
 * @Package com.zcx.util
 * @Description: 
 * @author 13071
 * @date 2020年2月19日
 * @version V1.0
 */
package com.zcx.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @ClassName: HibernateUtil
 * @Description: 
 * @author 13071
 * @date 2020年2月19日
 *
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	static {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("null");
			sessionFactory = null;
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void closeSessionFactory() {
		sessionFactory.close();
	}
}
