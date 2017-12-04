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
    
    <title>My JSP 'upd.jsp' starting page</title>
    
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
   <h4><s:property value="student==null?'添加':'修改'"/>学生</h4>
   <s:form action="%{student==null?'student/studentaction_add':'student/studentaction_upd'}" method="post">
   		<s:hidden name="student.sid" value="%{student.sid}"/>
 		<s:textfield name="student.name" label="姓名" value="%{student.name}" />
 		<s:radio list="{'男','女'}" name="student.sex" value="%{student.sex!=null?student.sex:'男'}" label="性别" />
 		<s:textfield name="student.birthday" label="生日" value="%{student.birthday}" />
 		<s:select list="{'高软','3g4g','网络营销'}" name="student.major" value="%{student.major}" label="专业" />
 		<s:textfield name="student.classes" value="%{student.classes}" label="班级" />
 		<s:textfield name="student.telephone" value="%{student.telephone}" label="电话" />
 		<s:submit value="%{student==null?'添加':'修改'}"/>
   </s:form>
   <h6 style="color:red;"><s:property value="message"/></h6> 
   </center>
  </body>
</html>
