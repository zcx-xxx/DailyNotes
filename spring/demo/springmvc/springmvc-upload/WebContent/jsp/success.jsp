<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>显示所有的上传记录</h3>
	<hr/>
	
	<table border="1px" cellpadding="10px" cellspacing="0px">
		<tr>
			<td>上传编号</td>
			<td>用户编号</td>
			<td>原始文件名</td>
			<td>存储文件名</td>
			<td>文件类型</td>
			<td>上传时间</td>
			<td>下载</td>
		</tr>
		
		<c:forEach items="${listFile }" var="file">
			<tr>
				<td>${file.upid }</td>
				<td>${file.uid }</td>
				<td>${file.oldName }</td>
				<td>${file.newName }</td>
				<td>${file.contentType }</td>
				<td>${file.uploadTime }</td>
				<td><a href="/springmvc-upload/down?oldName=${file.oldName }&newName=${file.newName}&contentType=${file.contentType}">下载</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>