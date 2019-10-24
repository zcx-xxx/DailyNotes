/**
 * @Title: MyCon.java
 * @Package com.zcx.controller
 * @Description: 
 * @author 13071
 * @date 2019年10月24日
 * @version V1.0
 */
package com.zcx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: MyCon
 * @Description: 
 * @author 13071
 * @date 2019年10月24日
 *
 */
@Controller
public class MyCon {
	/*
	 * 拦截器的使用
	 * 一、创建实现了 HandlerInterceptor 接口的 Java 类，实现相应的方法
	 * 	preHandle：执行访问资源之前执行的方法，该方法的返回值为 Boolean 类型，如果返回值为 true，表示放行
	 * 			接着执行后边的单元方法，如果返回值为 false，拦截，不继续执行
	 * 	postHandle：第二个要执行的方法
	 * 	afterCompletion：第三个最后要执的方法
	 * 
	 * 二、在 springmvc.xml 文件中配置拦截器
			<mvc:interceptors>
				<!-- 配置全局的拦截器 ,拦截所有的单元方法-->
	<!-- 			<bean id="myq" class="com.zcx.interceptor.MyInterceptor"></bean>  -->
				
				<!-- 配置指定的拦截器，拦截指定的单元方法 -->
				<mvc:interceptor>
					<mvc:mapping path="/demo"/>
					<bean id="myj" class="com.zcx.interceptor.MyInterceptor"></bean>
				</mvc:interceptor>		
			</mvc:interceptors>
	 * 三、使用单拦截器时的执行顺序
	 * 	DispatcherServlet -->拦截器 ---> preHandler ---> 单元方法 ---> 拦截器 ---> postHandle ---> afterCompletion
	 */
	@RequestMapping("demo")
	public String demo(String name, String pwd) {
//		System.out.println("hello");
		System.out.println(name + " " + pwd);
		return "forward:/jsp/index.jsp";
	}
}
