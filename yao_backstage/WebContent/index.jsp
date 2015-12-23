<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>11</h1>
	<s:iterator value="dataList">
		ID:<s:property value="id"/>&nbsp;&nbsp;Name:<s:property value="name"/>&nbsp;&nbsp;Password:<s:property value="password"/><br/>
	</s:iterator>
</body>
</html>