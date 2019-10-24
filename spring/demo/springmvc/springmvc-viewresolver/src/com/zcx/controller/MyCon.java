/**
 * @Title: MyCon.java
 * @Package com.zcx.controller
 * @Description: 
 * @author 13071
 * @date 2019年10月20日
 * @version V1.0
 */
package com.zcx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: MyCon
 * @Description: 
 * @author 13071
 * @date 2019年10月20日
 *
 */
@Controller
public class MyCon {
	
	/*
	 * 测试自定义的视图解析器，对于转发请求而言
	 * 		在 springmvc.xml 文件中进行相应的配置，根据相应的配置 DispatcherServlet 会选择是执行自定义的
	 * 视图解析器还是默认的视图解析器
	 * 		如果单元方法的返回值不加 forward: 则走自定义的视图解析器，否则走默认的视图解析器
	 */
	@RequestMapping("main")
	public String visitMain() {
		System.out.println("main");
		return "main";
	}
}
