<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List,com.qst.itofferbacker.javabean.User" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>用户查询</title>
<link href="../css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<ul class="seachform">
  <li>
    <div class="vocation">
      <select class="select3" name="userRole">
        <option>普通用户</option>
        <option>企业管理员</option>
        <option>系统管理员</option>
      </select>
    </div>
  </li>
  <li>
    <input type="text" class="scinput" value="请输入用户姓名"/>
  </li>
  <li>
    <input name="" type="button" class="scbtn" value="查询"/>
  </li>
</ul>
</body>
</html>
