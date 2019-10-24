/**
 * @Title: MyInterceptor.java
 * @Package com.zcx.interceptor
 * @Description: 
 * @author 13071
 * @date 2019年10月24日
 * @version V1.0
 */
package com.zcx.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zcx.controller.MyCon;

/**
 * @ClassName: MyInterceptor
 * @Description: 
 * @author 13071
 * @date 2019年10月24日
 *
 */
public class MyInterceptor implements HandlerInterceptor{
	//依赖注入
	@Resource
	private MyCon myCon;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("3");
	}

	/**
	 * request：请求对象
	 * response：响应对象
	 * handler：HandlerMethod 对象，封装了要请求的单元方法对象以实现在 preHandle 方法中可以调用一次单元方法，
	 * modelAndView：单元方法的返回值对象，可以根据需要重新设置返回值的内容，跳到指定的 jsp 页面
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		modelAndView.setViewName("forward:/jsp/error.jsp");
		System.out.println(modelAndView.getViewName());
	}

	/**
	 * request：请求对象
	 * response：响应对象
	 * handler：HandlerMethod 对象，封装了要请求的单元方法对象以实现在 preHandle 方法中可以调用一次单元方法，
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod hm = (HandlerMethod)handler;
		hm.getMethod().invoke(myCon, "zs", "123");
		return true;
	}
}
