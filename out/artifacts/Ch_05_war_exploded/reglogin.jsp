<%--
  Created by IntelliJ IDEA.
  User: 10537
  Date: 2018/4/16
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>欢迎你</title>
</head>
<body>
    <%--<s:fielderror/>--%>
    <h1>用户登录</h1>
    <s:property value="popedom"/>
    <s:form method="post" action="LogAction">
        <s:textfield name="user.name" label="账户"/>
        <s:password name="user.password" label="密码"/>
        <s:submit style="float:right;position:relative;" name="logsubmit" value="登录"/>
        <%--<s:reset style="float:left;position:relative;" name="regreset" value="重置"/>--%>
    </s:form>

    <hr align="left"  color="RED">
    <h1>用户注册</h1>
    <s:form method="post" action="RegAction">
        <s:textfield name="user.name" label="用户名"/>
        <s:password name="user.password" label="密码"/>
        <s:password name="user.password2" size="20" label="确认密码"/>
        <%--<s:password name="password2" label="确认密码"/>--%>
        <%--<s:password name="password3" label="确认密码" size="20"/>--%>
        <s:submit name="regsubmit" value="注册"/>
        <%--<s:reset name="regreset" value="重置"/>--%>
    </s:form>
</body>
</html>
