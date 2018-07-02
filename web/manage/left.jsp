<%--
  Created by IntelliJ IDEA.
  User: xyr
  Date: 2018/6/2
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@page contentType="text/html" language="java" %>--%>
<%@page import="java.util.List,com.qst.itofferbacker.javabean.Company,com.qst.itofferbacker.javabean.User" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<%
    List<Company> list = (List<Company>) request.getAttribute("list");
    List<User> userList = (List<User>) request.getAttribute("userList");
%>
<%
    User user = (User) session.getAttribute("SESSION_USER");
    int flag = user.getUserRole();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Q_ITOffer锐聘网后台管理系统</title>
    <link href="../css/left.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="../js/jquery.js"></script>
    <script type="text/javascript">
        $(function () {
            //导航切换
            $(".menuson li").click(function () {
                $(".menuson li.active").removeClass("active")
                $(this).addClass("active");
            });

            $('.title').click(function () {
                var $ul = $(this).next('ul');
                $('dd').find('ul').slideUp();
                if ($ul.is(':visible')) {
                    $(this).next('ul').slideUp();
                } else {
                    $(this).next('ul').slideDown();
                }
            });
        })
    </script>
</head>
<body style="background:#f0f9fd;">
<div class="lefttop"><span></span>功能菜单</div>
<dl class="leftmenu">
    <dd>
        <%
            if (flag == 2) {
        %>
        <div class="title"><span><img src="../images/leftico01.png"/></span>企业职位管理</div>
        <ul class="menuson">
            <li><cite></cite><a href="jobApplyList.html" target="rightFrame">职位申请查看</a><i></i></li>
            <li><cite></cite><a href="../JobServlet?type=list" target="rightFrame">职位管理</a><i></i></li>
            <li><cite></cite><a href="../CompanyServlet?type=list" target="rightFrame">企业管理</a><i></i></li>
        </ul>
    </dd>
    <%
    } else {
    %>
    <%
        }
    %>
    <%
        if (flag == 2) {
    %>
    <dd>
        <div class="title"><span><img src="../images/leftico02.png"/></span>简历管理</div>
        <ul class="menuson">
            <li><cite></cite><a href="resumeList.html" target="rightFrame">简历查询</a><i></i></li>
        </ul>
    </dd>
    <%
    } else {
    %>
    <%
        }
    %>
    <%
        if (flag == 1) {
    %>
    <dd>
        <div class="title"><span><img src="../images/leftico03.png"/></span>用户管理</div>
        <ul class="menuson">
            <li><cite></cite><a href="../UserServlet?type=userList" target="rightFrame">用户管理</a><i></i></li>
        </ul>
    </dd>
    <dd>
        <div class="title"><span><img src="../images/leftico04.png"/></span>系统管理</div>
        <ul class="menuson">
            <li><cite></cite><a href="userOnline.jsp" target="rightFrame">在线用户</a><i></i></li>
        </ul>
    </dd>
    <%
    } else {
    %>
    <%
        }
    %>
    <dd>
        <div class="title"><span><img src="../images/leftico04.png"/></span>密码修改</div>
    </dd>
</dl>
</body>
</html>
