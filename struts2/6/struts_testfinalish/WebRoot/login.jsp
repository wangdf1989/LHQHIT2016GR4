<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
   <center>
   <h1>登陆</h1>
   <s:form action="user/useraction_login" method="post">
 		<s:textfield name="user.username" label="用户名" />
 		<s:password name="user.password" label="密码" />
 		<s:submit value="登陆"/>  
   </s:form>
   <h6 style="color:red;"><s:property value="message"/></h6> 
   <h6>
   <s:fielderror fieldName="login.fromInput" ></s:fielderror>
   </h6>
   </center>
  </body>
</html>
