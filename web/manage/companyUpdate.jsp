<%--
  Created by IntelliJ IDEA.
  User: xyr
  Date: 2018/6/4
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List,com.qst.itofferbacker.javabean.Company" %>
<%--返回当前链接使用的协议--%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<%
    Company company = (Company) request.getAttribute("company");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" ; charset="utf-8">
    <title>修改企业</title>
    <link href="../css/manageadmin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
    <script type="text/javascript">
        function validate() {
            if (document.getElementById("companyName").value == "") {
                alert("企业名称不能为空！");
                document.getElementById("companyName").focus();
                return false;
            }
            if (document.getElementById("companyArea").value == "") {
                alert("企业所在地不能为空！");
                document.getElementById("companyArea").focus();
                return false;
            }
            if (document.getElementById("companySize").value == "") {
                alert("企业规模不能为空！");
                document.getElementById("companySize").focus();
                return false;
            }
            if (document.getElementById("companyType").value == "") {
                alert("企业性质不能为空！");
                document.getElementById("companyType").focus();
                return false;
            }
            if (document.getElementById("companyPic").value == "") {
                alert("请选择企业宣传图片！");
                document.getElementById("companyPic").focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div class="place"><span>位置：</span>
    <ul class="placeul">
        <li><a href="index.html">首页</a></li>
        <li><a href="#">修改企业</a></li>
    </ul>
</div>
<div class="formbody">
    <div class="usual">
        <form name="frm" action="../CompanyServlet" method="post" enctype="multipart/form-data"
              onsubmit="return validate();">
            <div class="tabson">
                <ul class="forminfo">
                    <li>
                        <label>企业名称<b>*</b></label>
                        <input name="companyName" type="text" id="companyName" value="<%=company.getCompanyName()%>"
                               class="dfinput" style="width:518px;"/>
                    </li>
                    <li>
                        <label>企业所在地<b>*</b></label>
                        <input name="companyArea" type="text" id="companyArea" value="<%=company.getCompanyArea()%>"
                               class="dfinput" style="width:518px;"/>
                    </li>
                    <li>
                        <label>企业规模<b>*</b></label>
                        <input name="companySize" type="text" id="companySize" value="<%=company.getCompanySize()%>"
                               class="dfinput" style="width:518px;"/>
                    </li>
                    <li>
                        <label>企业性质<b>*</b></label>
                        <input name="companyType" type="text" id="companyType" value="<%=company.getCompanyType()%>"
                               class="dfinput" style="width:518px;"/>
                    </li>
                    <li>
                        <p>企业简介&nbsp;(不超过1000字)</p>
                        <textarea class="ckeditor" cols="50" id="companyBrief" name="companyBrief" rows="10"><%=company.getCompanyBrief() %></textarea>
                    </li>
                    <li>
                        <label>企业招聘状态</label>
                        <div class="vocation">
                            <select name="companyState" value="<%=company.getCompanyState()%>" class="select3">
                                <option value="1">招聘中</option>
                                <option value="2">已暂停</option>
                                <option value="3">已结束</option>
                            </select>
                        </div>
                    </li>
                    <li>
                        <label>显示排序<b></b></label>
                        <input name="companySort" type="text" id="companySort" value="<%=company.getCompanySort()%>"
                               class="dfinput" style="width:100px;"/>
                    </li>
                    <li>
                        <label>宣传图片<b>*</b></label>
                        <input name="companyPic" id="companyPic" value="<%=company.getcompanyPicpathName()%>"
                               type="file" class="dfinput" style="width:300px; margin-right:5px;"/>
                    </li>
                    <li>
                        <input name="companyId" value="<%=company.getCompanyId()%>"type="hidden">
                        <input name="type" value="update" type="hidden">
                        <input name="" type="submit" class="btn" value="修改"/>
                    </li>
                </ul>
            </div>
        </form>
    </div>
</div>
</body>
</html>
