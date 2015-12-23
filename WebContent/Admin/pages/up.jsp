<%@ page language="java" import="java.lang.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	 <script type="text/javascript"  src="../js/jquery-1.9.1.js"></script>
    <script type="text/javascript"  src="../js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="../js/jquery-form.js"></script>
    <script type="text/javascript" src="../js/common.js"></script>
</head>
<body>
<button type="button" id="addPic" onclick="$('#file').click();" style="margin-right: 10px;">添加图片</button>
 	<form id="upload" method="post" enctype="multipart/form-data" style="display: none;"> 
	                        <input id="file" type="file" name="file" style="display: none" onchange="uploadFile(1);"/>
	                    </form>
</body>
   
</html>