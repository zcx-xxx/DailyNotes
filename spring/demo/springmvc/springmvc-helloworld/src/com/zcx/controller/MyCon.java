/**
 * @Title: MyCon.java
 * @Package com.zcx.controller
 * @Description: 
 * @author 13071
 * @date 2019年10月19日
 * @version V1.0
 */
package com.zcx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: MyCon
 * @Description: 
 * @author zcx
 * @date 2019年10月19日
 */

/*
 * 1. 注意 jar 包的版本问题
 * 
 * 2.流程
 *   1）创建 web 动态项目
 *   2）导入相应的 jar 包
		commons-logging-1.2.jar
		spring-aop-5.1.9.RELEASE.jar
		spring-beans-5.1.9.RELEASE.jar
		spring-context-5.1.9.RELEASE.jar
		spring-core-5.1.9.RELEASE.jar
		spring-expression-5.1.9.RELEASE.jar
		spring-web-5.1.9.RELEASE.jar
		spring-webmvc-5.1.9.RELEASE.jar
 *	 3）配置 web.xml 文件
 *		首先配置 servlet
 *		在 init-param 中配置 spring 子容器所使用的 xml 配置文件。
 *	 4）配置 spring 子容器的配置文件
 *		配置注解扫描
 *		配置注解驱动解析器
 *		配置静态资源放行
 *	 5）创建控制器类
 *		使用 @Controller 声明控制器 bean
 *		使用 @RequestMapping 声明单元方法别名，便于扫描 
 *	 6）启动服务器，使用单元方法别名进行访问。
 */
@Controller
public class MyCon {
	
	@RequestMapping("demo")
	public String demo() {
		System.out.println("MyCon.demo()");
		return "index.jsp";
	}
}
