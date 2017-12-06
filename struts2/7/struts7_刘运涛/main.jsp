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
         <h3>歌曲下载</h3> 
         <table width="350" border="0" style="text-align: center" bgcolor="gray"  >
	             <tr bgcolor="white">
	               <th>编号</th>
	               <th>歌曲名字</th>
	               <th>操作</th>
	             </tr>
             <s:iterator value="list" var="song">
                 <tr bgcolor="white">
                    <td>
                       <s:property value="#song.sid"/>
                    </td>
                    <td>
                       <s:property value="#song.name"/>
                    </td>
                    <td>
                       <a href="uploadAction!downLoad?sid=<s:property value="#song.sid"/>">下载</a>
                    </td>
                 </tr>
             </s:iterator>
         </table>
     </center> 
 </body>
</html>
