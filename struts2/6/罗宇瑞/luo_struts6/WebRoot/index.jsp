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
    
    <title>My JSP 'index.jsp' starting page</title>
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
  		欢迎你，<s:property value="#session.u.username"/>
  		<table border=1 width=800>
  			<tr>
  				<th>姓名</th>
  				<th>性别</th>
  				<th>生日</th>
  				<th>专业</th>
  				<th>班级</th>
  				<th>电话</th>
  				<th>操作</th>
  			</tr>
  			<s:iterator value="list" var="student">
			<tr>
				<td><s:property value="#student.name"/></td>
				<td><s:property value="#student.sex"/></td>
				<td><s:property value="#student.birthday"/></td>
				<td><s:property value="#student.major"/></td>
				<td><s:property value="#student.classes"/></td>
				<td><s:property value="#student.telephone"/></td>
				<td>
					<a href="student/studentaction_del?sid=<s:property value="#student.sid"/>">删除</a>
					<a href="student/studentaction_preupd?sid=<s:property value="#student.sid"/>">修改</a>
				</td>
			</tr>
  			</s:iterator>
  		</table>
  		<a href="add.jsp">添加学生</a>
  		<h6 style="color:red">
  	</center>
  	<s:actionerror/>
  </body>
</html>
