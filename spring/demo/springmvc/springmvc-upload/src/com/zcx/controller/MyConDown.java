/**
 * @Title: MyConDown.java
 * @Package com.zcx.controller
 * @Description: 
 * @author 13071
 * @date 2019年10月21日
 * @version V1.0
 */
package com.zcx.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @ClassName: MyConDown
 * @Description: 
 * @author 13071
 * @date 2019年10月21日
 *
 */
@Controller
public class MyConDown {
	
	@RequestMapping("down")
	public void downFile(String oldName, String newName, String contentType, HttpServletRequest request, HttpServletResponse response) {
		//设置相应的类型
		response.setContentType(contentType);
		
		//将原始文件名进行重新编码，因为浏览器的编码格式默认为 iso-8859-1
		try {
			oldName = new String(oldName.getBytes("utf-8"), "iso-8859-1");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//设置响应头，告诉浏览器不要直接在浏览器解析文件，而是存储到客户端
		response.setHeader("Content-Disposition", "attachment;filename=" + oldName);
		
		//获取资源的存储路径
		String path = request.getServletContext().getRealPath("/images");
		
		try {
			//获得输出流
			ServletOutputStream out = response.getOutputStream();
			//将文件写到浏览器
			out.write(FileUtils.readFileToByteArray(new File(path, newName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
