<%@ page import="java.util.Map" %>
<%@ page import="com.qst.itofferbacker.javabean.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>在线用户列表</title>
<link href="../css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
  Map map = (Map)application.getAttribute("ONLINE");
%>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="index.html">首页</a></li>
    <li>在线用户列表</li>
  </ul>
</div>
<div class="rightinfo">
  <table class="imgtable">
    <thead>
      <tr>
        <th>用户登录名</th>
        <th>用户真实姓名</th>
        <th>用户角色</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
    <%
      for (Object key:map.keySet()) {
          User user = (User)map.get(key);
     %>
      <tr height="50px">
        <td><%=user.getUserLogname()%></td>
        <td><%=user.getUserRealname()%></td>
        <td><%=user.getUserRole()%></td>
        <td ><a href="#" class="tablelink">强制下线</a> </td>
      </tr>
     <%
      }
    %>
    </tbody>
  </table>
</div>
</body>
</html>
