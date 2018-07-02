<%--
  Created by IntelliJ IDEA.
  User: xyr
  Date: 2018/6/3
  Time: 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List,com.qst.itofferbacker.javabean.Job" %>
<%--返回当前链接使用的协议--%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<%
    List<Job> list = (List<Job>) request.getAttribute("list");
%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" ; charset="utf-8">
    <title>职位列表</title>
    <base href="<%=basePath%>"/>
    <link href="../css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
    <ul class="placeul">
        <li><a href="manage/index.html">首页</a></li>
        <li><a href="../JobServlet?type=list">职位列表</a></li>
    </ul>
</div>
<div class="rightinfo">
    <div class="tools">
        <ul class="toolbar">
            <li class="click"><span><img src="../images/t01.png" /></span>
                <a href="manage/jobAdd.html">添加</a></li>
        </ul>
        <iframe src="manage/jobSearch.html" scrolling="no" frameborder="0" width="630" height="42"></iframe>
    </div>
    <table class="imgtable">
        <thead>
        <tr>
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>职位名称</th>
            <th>所属企业</th>
            <th>招聘数</th>
            <th>申请数</th>
            <th>结束日期</th>
            <th>招聘状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (list != null) {
                for (Job j : list) {
        %>
        <tr height="50px">
            <td><input name="" type="checkbox" value=""/></td>
            <td><%=j.getJobName() %>
            </td>
            <td><%=j.getCompanyId() %>
            </td>
            <td><%=j.getJobHiringnum()%>
            </td>
            <td><%=j.getJobHiringnum()%>
            </td>
            <td><%=j.getJobEndtime()%>
            </td>
            <td><%if (j.getJobState() == 1) {%>招聘中
                <%} else if (j.getJobState() == 2) { %>已暂停
                <%} else if (j.getJobState() == 3) {%>已结束
                <%}%></td>

            <td><a href="JobServlet?type=updateServlet&jobId=<%=j.getCompanyId() %>" class="tablelink">修改</a>
                &nbsp;&nbsp;<a href="#" class="tablelink">删除</a>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
    <div class="pagin">
        <div class="message">共<i class="blue">1256</i>页，当前显示第&nbsp;<i class="blue">1&nbsp;</i>页</div>
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
