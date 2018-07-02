<%--
  Created by IntelliJ IDEA.
  User: xyr
  Date: 2018/6/4
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List,com.qst.itofferbacker.javabean.User" %>
<%--返回当前链接使用的协议--%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<%
    List<User> userList = (List<User>) request.getAttribute("userList");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8">
    <title>用户列表</title>
    <base href="<%=basePath%>"/>
    <link href="css/manageadmin.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="place"><span>位置：</span>
    <ul class="placeul">
        <li><a href="manage/index.html">首页</a></li>
        <li><a href="../UserServlet?type=userList">用户列表</a></li>
    </ul>
</div>
<div class="rightinfo">
    <div class="tools">
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
        <ul class="toolbar">
            <li class="click"><span><img src="../images/t01.png"/></span><a href="manage/userAdd.html">添加</a></li>
            <li class="click"><span><img src="../images/t02.png"/></span><a href="manage/userAdd.html">修改</a></li>
            <li><span><img src="../images/t03.png"/></span><a href="manage/userDelete.html">删除</a></li>
        </ul>

        <%--<iframe src="manage/userSearch.jsp" scrolling="no" frameborder="0" width="400" height="42"></iframe>--%>
    </div>
    <table class="imgtable">
        <thead>
        <tr>
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>用户登录名</th>
            <th>用户真实姓名</th>
            <th>用户Email</th>
            <th>用户角色</th>
            <th>用户状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (userList != null) {
                for (User u : userList) {
        %>
        <tr height="50px">
            <td><input name="" type="checkbox" value=""/></td>
            <td><%=u.getUserLogname() %>
            </td>
            <td><%=u.getUserRealname()%>
            </td>
            <td><%=u.getUserEmail()%>
            </td>
            <td><%=u.getUserRole()%>
            </td>
            <td><%if (u.getUserState() == 1) {%>普通用户
                <%} else if (u.getUserState() == 2) { %>企业管理员
                <%} else if (u.getUserState() == 3) {%>系统管理员
                <%}%></td>
            <td><a href="UserServlet?type=updateServlet&userId=<%=u.getUserId() %>" class="tablelink">修改</a> &nbsp;&nbsp;<a
                    href="#" class="tablelink"> 删除</a>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
    <div class="pagin">
        <div class="message">共<i class="blue">1256</i>页，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
            <li class="paginItem"><a href="javascript:;">首页</a></li>
            <li class="paginItem"><a href="javascript:;">上一页<span class="pagepre"></span></a></li>
            <li class="paginItem"><a href="javascript:;">下一页<span class="pagenxt"></span></a></li>
            <li class="paginItem"><a href="javascript:;">尾页</a></li>
        </ul>
    </div>
</div>
</body>
</html>