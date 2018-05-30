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
    <style>
        .main{
            text-align: center; /*让div内部文字居中*/
            background-color: #fff;
            /*border-radius: 20px;*/
            width: 300px;
            height: 650px;
            margin: auto;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
        }

    </style>
</head>
<body> <s:include value="main.jsp"/>
<div class="main">
    <%--<s:fielderror/>--%>
    <h2 style="color: red;"><s:property value="popedom"/></h2>
        <div style="position:relative;float:right;left: -20px;">
        <h4>用户登录</h4>

        <s:form method="post" action="LogAction" >
            <s:textfield name="user.name" label="账户"/>
            <s:password name="user.password" label="密码"/>
            <s:submit  name="logsubmit" value="登录"/>
            <%--<s:reset style="float:left;position:relative;" name="regreset" value="重置"/>--%>
        </s:form>
        </div>
    <hr style="top:155px;position: relative" color="RED">
        <div style="position:relative;top:55px;float:right;left: -20px;">
        <h4 >用户注册</h4>
        <s:form method="post" action="RegAction" >
            <s:textfield name="user.name" label="用户名"/>
            <s:password name="user.password" label="密码"/>
            <s:password name="user.password2" label="确认密码"/>
            <%--<s:password name="password2" label="确认密码"/>--%>
            <%--<s:password name="password3" label="确认密码" size="20"/>--%>
            <s:submit name="regsubmit" value="注册"/>
            <%--<s:reset name="regreset" value="重置"/>--%>
        </s:form>
        </div>
</div>
</body>
</html>
