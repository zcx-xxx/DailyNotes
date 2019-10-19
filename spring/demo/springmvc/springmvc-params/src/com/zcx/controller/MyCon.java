/**
 * @Title: MyCon.java
 * @Package com.zcx.controller
 * @Description: 
 * @author 13071
 * @date 2019年10月19日
 * @version V1.0
 */
package com.zcx.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zcx.unity.User;

/**
 * @ClassName: MyCon
 * @Description: 
 * @author 13071
 * @date 2019年10月19日
 *
 */
@Controller
public class MyCon {
	
	@RequestMapping("demo1")
	public String demo1() {
		System.out.println("demo1");
		return "index.jsp";
	}
	
	//请求参数的学习
	/*
	 * 紧耦方式
	 * 直接将 request 对象传入单元方法，然后在获取数据
	 */
	@RequestMapping("demo2")
	public String demo2(HttpServletRequest request) {
		System.out.println("demo2" + " " + request.getParameter("name"));
		return "index.jsp";
	}
	
	/*
	 * 解耦方式一
	 * 直接在单元方法处声明形参，Servlet 中根据形参的名字请求数据，没有相应的数据返回 null，
	 * 一般推荐使用这种方法
	 */
	@RequestMapping("demo3")
	public String demo3(String name) {
		System.out.println("demo3" + " " + name);
		return "index.jsp";
	}
	
	/*
	 * 解耦方式二
	 * 还是直接在单元方法处声明形参，但是声明的形参名和 request 请求的中的 key 值不一致，
	 * 加 @RequestParam 注解，指明 request 中相应参数的实际 key 值，使用该 key 值成功获取参数后，
	 * 再将其赋值给形参
	 */
	@RequestMapping("demo4")
	public String demo4(@RequestParam("name")String namexx) {
		System.out.println("demo4" + " " + namexx);
		return "index.jsp";
	}
	
	/*
	 * 解耦方式三
	 * 传入一个对象，Servlet 根据对象的属性名去 request 对象中获取相应的请求参数，
	 * 并将其封装为一个对象直接返回
	 */
	@RequestMapping("demo5")
	public String demo5(User user) {
		System.out.println("demo5" + " " + user.getName());
		return "index.jsp";
	}
	
	/*
	 * 同键多个不同值的请求参数的获取，使用数组或者集合
	 * 数组：直接根据数组名字取匹配
	 * 集合：需要使用参数注解去指定参数的键值
	 */
	@RequestMapping("demo6")
	public String demo6(String name, String [] favs) {
		System.out.println("demo6数组" + " " + name);
		
		for(int i = 0; i < favs.length; ++i) {
			System.out.print(favs[i] + " ");
		}
		System.out.println();
		return "index.jsp";
	}
	
	@RequestMapping("demo7")
	public String demo7(String name, @RequestParam("favs")ArrayList<String> favs) {
		System.out.println("demo7集合" + " " + name);
		
		for(int i = 0; i < favs.size(); ++i) {
			System.out.print(favs.get(i) + " ");
		}
		System.out.println();
		return "index.jsp";
	}
	
	/*
	 * restful 风格的 url，配置通配请求映射
	 * 传统方式的 url 请求参数：
	 * 		以冒号开始，以键值对的形式传递，每一对键值对之间使用 & 隔开
	 * restful 风格的 url 请求参数：
	 * 		将请求的数据以请求地址的形式发送给服务器，服务器在做相应的处理
	 * 技能点：
	 * 		@RequestMapping 注解中声明的单元方法的别名可以使用{键名}进行通用声明
	 * 		使用 @PathVariable("键名") 可以获得请求地址中的参数
	 */
	@RequestMapping("demo8/{name}/{age}")
	public String demo8(@PathVariable("name") String name, @PathVariable("age")int age) {
		System.out.println("demo8" + " " + name + " " + age);
		return "index.jsp";
	}
}
