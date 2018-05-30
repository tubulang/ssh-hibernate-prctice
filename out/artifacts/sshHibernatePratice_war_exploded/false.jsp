<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Standard_lang
  Date: 2018/5/13
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h2>退出系统失败！！！</h2>
</body>
</html>
