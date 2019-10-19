/**
 * @Title: MyControllerReturn.java
 * @Package com.zcx.controller
 * @Description: 
 * @author 13071
 * @date 2019年10月19日
 * @version V1.0
 */
package com.zcx.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: MyControllerReturn
 * @Description: 
 * @author 13071
 * @date 2019年10月19日
 *
 */
@Controller
public class MyControllerReturn {
	/*
	 * 根据方法的返回参数，DispatcherServlet 来具体判断执行什么操作
	 * 转发请求，重定向还是不做处理
	 */
	//转发请求
	@RequestMapping("forward")
	public String forwardDemo(HttpServletRequest request, String name, int age) {
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		return "forward:/jsp/findex.jsp";
	}
	
	//重定向
	@RequestMapping("redirect")
	public String redirectDemo(HttpServletRequest request, String name, int age) {
		request.getSession().setAttribute("name", name);
		request.getSession().setAttribute("age", age);
		return "redirect:/jsp/rindex.jsp";
	}
	//直接处理，
	@RequestMapping("without")
	public void withoutDemo(HttpServletResponse response, String name, int age) {
		try {
			response.getWriter().print(name + " " + age);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
