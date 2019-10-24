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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

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
	 * 下面接着的三种方法路径规则和原先的 servlet 不一样，spring 对其进行了处理，/ 代表的是当前项目的根路径
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
	
	/*
	 * spring 的早期版本
	 * 通过不同的实例化对象来区分具体是转发请求还是重定向，其中需要注意的是路径规则，和在 servlet 中的路径规则一样
	 */
	@RequestMapping("tv")
	public View testView(String name, int age) {
		//请求转发，/ 代表的是当前项目的根路径
		View v1 = new InternalResourceView("/jsp/findex.jsp");
		
		//重定向,/ 代表的是当前服务器的根路径
		View v2 = new RedirectView("/springmvc-return/jsp/rindex.jsp");
		return v2;
	}
	
	/*
	 * 该方法中的路径规则是 spring 经过处理的，/ 代表的是当前项目的根路径
	 * Model 的使用：
	 *  	Model 相当于 request 中的 map 集合，在单元方法的形参列表中进行声明之后， DispatcherServlet
	 * 将该集合传入单元方法。
	 *  	Model 是专门为重定向进行设计的，Model 中的数据在重定向的时候会将其中的基本数据类型通过拼接字符串的
	 *  方式拼接到请求 url 的末尾。（复杂的数据类型无法拼接）
	 */
	@RequestMapping("tmav")
	public ModelAndView testModelAndView(Model model, String name, int age) {
		//请求转发
		ModelAndView modelAndView = new ModelAndView("forward:/jsp/findex.jsp");
		
		model.addAttribute("name", name);
		//重定向
		ModelAndView modelAndView2 = new ModelAndView("redirect:/jsp/rindex.jsp");
		
		return modelAndView2;
	}
}
