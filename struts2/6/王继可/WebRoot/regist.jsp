<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<s:property value="#parameters['abc']"/>
   <h1>注册</h1>
   <form action="user/userAction_regist" method="post">
 	<s:textfield name="user.username" label="用户名" tooltip="不可为空"/><br/>  
   	密码：<input type="password" name="user.password"/><br/>  
   	年龄：<input type="text" name="user.age"/><br/>  
   	生日：<input type="text" name="user.birthday"/><br/>  
   	性别：<s:radio list="#{0:'男',1:'女'}" name="sex" value="1"/><br/>  
   	<s:checkboxlist list="#{1:'足球',2:'篮球',3:'羽毛球'}" name="love" label="爱好"  /><br/>
   	<s:textarea cols="10" rows="5" label="个人简介"></s:textarea>
   	<input type="submit" value="注册"/>
  </body>
</html>
