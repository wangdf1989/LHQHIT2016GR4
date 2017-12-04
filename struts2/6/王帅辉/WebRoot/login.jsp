<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
  	<h1><s:text name="login"/></h1>
    <s:form action="user/userAction!login">
    	<s:textfield key="username" name="user.username"/> <s:fielderror fieldName="login.username"/>
    	<s:password key="password" name="user.password"/> <s:fielderror fieldName="login.password"/>
    	<s:submit value="%{getText('login')}"/>
    </s:form>
    <s:fielderror  fieldName ="login.forms"/>
    <s:actionerror/>
  </body>
</html>
