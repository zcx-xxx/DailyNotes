/**
 * @Title: MyConUpload.java
 * @Package com.zcx.controller
 * @Description: 
 * @author 13071
 * @date 2019年10月20日
 * @version V1.0
 */
package com.zcx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zcx.entity.UpLoad;
import com.zcx.service.UpLoadFileService;
import com.zcx.service.impl.UpLoadFileServiceImpl;

/**
 * @ClassName: MyConUpload
 * @Description: 
 * @author 13071
 * @date 2019年10月20日
 *
 */
@Controller
public class MyConUpload {
	private UpLoadFileService upLoadFileService = new UpLoadFileServiceImpl();
	
	/**
	 * 实现文件的上传
	 * @Title: myUpload
	 * @Description:
	 * @param username
	 * @param password
	 * @param photo
	 * @param request
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("upload")
	public String myUpload(String username, String password, MultipartFile photo, HttpServletRequest request) {

		//获取后缀名
		String suffixName = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf("."));
		//动态生成文件名
		String fileName = "" + UUID.randomUUID() + System.currentTimeMillis();
		//拼接文件名
		String newName = fileName + suffixName;
		
		//设置文件存储目录
		String path = request.getServletContext().getRealPath("/images");
		File fpath = new File(path);
		if(!fpath.exists()) {
			//如果目录不存在，则创建
			fpath.mkdirs();
		}
		
		//通过目录加文件名存储文件
		File file = new File(fpath, newName);
		try {
			//将文件存储到服务器
			photo.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//使用原始的数据库操作，将数据信息保存到数据库中，后期可以改为 Mybatis
		upLoadFileService.uploadFile(1, photo.getOriginalFilename(), newName, photo.getContentType());
		
		return "forward:/success";
	}
	
	/**
	 * 文件上传成功之后，查询出上传的所有文件，并显示
	 * @Title: getUpLoadInfo
	 * @Description:
	 * @param request
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("success")
	public String getUpLoadInfo(HttpServletRequest request) {
		List<UpLoad> listFile = new ArrayList<UpLoad>();
		
		//该处暂时只查询一个指定的用户
		listFile = upLoadFileService.getUpLoadFile(1);
		request.setAttribute("listFile", listFile);
		
		return "forward:/jsp/success.jsp";
	}
}
