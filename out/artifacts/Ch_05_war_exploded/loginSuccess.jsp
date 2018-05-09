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
</head>
<body>
您好：<s:property value="#session.user.name"/>, 欢迎您的登录！<p>
<table cellpadding="0" cellspacing="0" border="1" width="30%">
    <tr>
        <th>用户名</th>
        <th>密码</th>
    </tr>
    <s:iterator value="#session.users" status="st" var="user">
        <tr>
            <td><s:property value="#user.getName()"></s:property></td>
            <td><s:property value="#user.getPassword()"></s:property></td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
