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
    
    <title>My JSP 'show.jsp' starting page</title>
    
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
       <table border="1" width="800">
       <h3>欢迎您,<s:property value="#session.user.username"/></h3>
      <tr>
        <th>名字</th>
        <th>性别</th>
        <th>出生日期</th>
        <th>专业</th>
        <th>班级</th>
        <th>电话</th>
        <th>操作</th>  
      </tr>
      <s:iterator value="list" var="p">
      <tr>
         <td><s:property value="#p.name"/></td>
         <td><s:property value="#p.sex"/></td>
         <td><s:property value="#p.birthdate"/></td>
         <td><s:property value="#p.major"/></td>
         <td><s:property value="#p.classs"/></td>
         <td><s:property value="#p.telephone"/></td>
         <td>
         <a href="student/studentaction_del?sid=<s:property value="#p.sid"/>">删除</a>
         <a href="student/studentaction_preupd?sid=<s:property value="#p.sid"/>">修改</a>
         </td> 
      </tr>
      </s:iterator>
      <tr>
      <td colspan="7" align="center"><a href="cz.jsp">添加学生</a></td>
      </tr>
      </table>
    </center>
  </body>
</html>
