<%--
  Created by IntelliJ IDEA.
  User: Standard_lang
  Date: 2018/5/10
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <div class="main">

        <s:form action="ChangePwdAction" method="post">
            <s:password name="oldPwd" label="旧密码"/>
            <s:password name="newPwd" label="新密码"/>
            <s:password name="newPwd2" label="确认密码"/>
            <s:submit name="submit" value="确认修改"/>
        </s:form>

    </div>
</body>
</html>
