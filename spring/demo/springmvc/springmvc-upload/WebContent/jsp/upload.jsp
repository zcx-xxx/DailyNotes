<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	enctype="application/x-www-form-urlencoded":默认表示将数据以键值对的形式进行提交
	 -->
	<form action="/springmvc-upload/upload" method="post" enctype="multipart/form-data">
		用户名：<input type="text" name="username"/><br>
		密码：<input type="text" name="password"/><br>
		头像：<input type="file" name="photo"/><br>
		<input type="submit" value="点击上传">
	</form>
</body>
</html>