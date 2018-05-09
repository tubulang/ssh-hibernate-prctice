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
</head>
<body>
<%--<%&lt;%&ndash;Vector<Person> users=(Vector<Person>)request.getSession().getAttribute("users");%>&ndash;%&gt;--%>
    您好：${user.name}，欢迎您的注册！！！
    <table cellpadding="0" cellspacing="0" border="1" width="30%">
        <tr>
            <th>用户名</th>
            <th>密码</th>
        </tr>
        <s:iterator value="users" status="st" var="user">
            <tr>
                <td><s:property value="#user.name"/></td>
                <td><s:property value="#user.password"/></td>
            </tr>
        </s:iterator>
    </table>
</body>
</html>
