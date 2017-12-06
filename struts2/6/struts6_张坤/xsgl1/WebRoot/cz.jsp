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
    
    <title>My JSP 'cz.jsp' starting page</title>
    
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
  <s:form action="%{student==null ?'student/studentaction_add':'student/studentaction_upd'}">
   <s:hidden name="student.sid" value="%{student.sid}"/>
   <s:textfield  name="student.name" label="姓名" value="%{student.name}" />
   <s:radio list="{'男','女'}" value="%{student==null? '男':student.sex}" name="student.sex" label="性别"/>
   <s:textfield name="student.birthdate" value="%{student.birthdate}" label="出生日期"/>
   <s:select list="{'高软','3g4g','网络营销'}" name="student.major" value="%{student.major}" label="专业"/>
   <s:textfield name="student.classs" value="%{student.classs}" label="班级"/>
   <s:textfield name="student.telephone" value="%{student.telephone}" label="电话"/>
   <s:submit value="%{student==null?'添加':'修改'}"/>
  </s:form>
  </center>
  </body>
</html>
