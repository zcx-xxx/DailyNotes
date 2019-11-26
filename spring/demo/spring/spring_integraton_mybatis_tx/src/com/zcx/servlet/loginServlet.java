package com.zcx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zcx.pojo.User;
import com.zcx.service.UserService;

/**
 * Servlet implementation class loginServlet
 */
//@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	/* (非 Javadoc)
	 * <p>Title: init</p>
	 * <p>Description: </p>
	 * @throws ServletException
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());		
		userService = (UserService) ac.getBean("userService");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/* (非 Javadoc)
	 * <p>Title: service</p>
	 * <p>Description: </p>
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		
		User user = userService.checkLogin(uname, pwd);
		
		if(user == null) {
			System.out.println("fail");
		} else {
			System.out.println("success");
		}
	}

}
