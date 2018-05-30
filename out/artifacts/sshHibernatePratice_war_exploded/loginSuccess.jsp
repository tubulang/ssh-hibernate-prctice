<%--
  Created by IntelliJ IDEA.
  User: 10537
  Date: 2018/4/16
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*, bean.Person" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <style>
        .main{
            text-align: center; /*让div内部文字居中*/
            background-color: #fff;
            /*border-radius: 20px;*/
            width: 600px;
            height: 350px;
            margin: auto;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
        }

    </style>
</head>
<body>
<s:include value="main.jsp"/>
<div class="main"><h2>您好：<s:property value="#session.user.name"/>, 欢迎您的登录！</h2></div>
<%--<table cellpadding="0" cellspacing="0" border="1" width="30%">--%>
    <%--<tr>--%>
        <%--<th>用户名</th>--%>
        <%--<th>密码</th>--%>
    <%--</tr>--%>
    <%--<s:iterator value="#session.users" status="st" var="user">--%>
        <%--<tr>--%>
            <%--<td><s:property value="#user.getName()"></s:property></td>--%>
            <%--<td><s:property value="#user.getPassword()"></s:property></td>--%>
        <%--</tr>--%>
    <%--</s:iterator>--%>
<%--</table>--%>
</body>
</html>
