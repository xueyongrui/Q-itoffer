<%--
  Created by IntelliJ IDEA.
  User: xyr
  Date: 2018/6/1
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@page contentType="text/html" language="java" %>--%>
<%@page import="java.util.List,com.qst.itofferbacker.javabean.Company" %>
<%--返回当前链接使用的协议--%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<%
    List<Company> list = (List<Company>) request.getAttribute("list");
%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" ; charset="utf-8">
    <title>企业列表</title>
    <base href="<%=basePath%>"/>
    <link href="css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"><span>位置：</span>
    <ul class="placeul">
        <li><a href="manage/index.html">首页</a></li>
        <li><a href="../CompanyServlet?type=list">企业列表</a></li>
    </ul>
</div>
<div class="rightinfo">
    <div class="tools">
        <ul class="toolbar">
            <li class="click"><span><img src="../images/t01.png" /></span><a href="manage/companyAdd.html">添加</a></li>
            <li><span><img src="../images/t02.png" /></span><a href="#">修改</a></li>
                <li><span><img src="../images/t03.png" /></span><a href="manage/companyDelete.html">删除</a></li>
        </ul>
    </div>
    <table class="imgtable">
        <thead>
        <tr>
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>企业名称</th>
            <th>企业所在地</th>
            <th>企业规模</th>
            <th>企业性质</th>
            <th>招聘状态</th>
            <th>显示排序</th>
            <th>浏览数</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (list != null) {
                for (Company c : list) {
        %>
        <tr height="50px">
            <td><input name="" type="checkbox" value=""/></td>
            <td><%=c.getCompanyName() %>
            </td>
            <td><%=c.getCompanyArea() %>
            </td>
            <td><%=c.getCompanySize()%>
            </td>
            <td><%=c.getCompanyType()%>
            </td>
            <td><%if (c.getCompanyState() == 1) {%>招聘中
                <%} else if (c.getCompanyState() == 2) { %>已暂停
                <%} else if (c.getCompanyState() == 3) {%>已结束
                <%}%></td>
            <td><%=c.getCompanySort() %>
            </td>
            <td><%=c.getCompanyViewnum()%>
            </td>
            <td><a href="CompanyServlet?type=updateServlet&companyId=<%=c.getCompanyId() %>" class="tablelink">修改</a>
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
    <div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">1&nbsp;</i>页</div>
    <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
    </ul>
</div>
</div>
</body>
</html>
