<%--
  Created by IntelliJ IDEA.
  User: 10537
  Date: 2018/4/16
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*,bean.Person" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <style>
        .main{
            text-align: center; /*让div内部文字居中*/
            background-color: #fff;
            /*border-radius: 20px;*/
            width: 300px;
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
<%--<%&lt;%&ndash;Vector<Person> users=(Vector<Person>)request.getSession().getAttribute("users");%>&ndash;%&gt;--%>
    <h2 class="main">您好：<s:property value="#session.user.name"/>，欢迎您的注册！！！</h2>

</body>
</html>
