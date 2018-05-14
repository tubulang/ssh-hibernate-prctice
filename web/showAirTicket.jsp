<%--
  Created by IntelliJ IDEA.
  User: Standard_lang
  Date: 2018/4/19
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*,action.*" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--您好：<s:property value="#session.reguser.name"/>，欢迎您的注册！！！--%>
<h1>您的机票预定信息</h1>
<table cellpadding="0" cellspacing="0" border="1" width="100%">
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>始发城市</th>
        <th>目的城市</th>
        <th>出发日期</th>
        <th>身份证</th>
    </tr>
    <%--value对应struts.xml配置中action中的值--%>
    <s:iterator value="air_tickets" status="st" var="airticket">
        <tr>
            <td><s:property value="#airticket.name"/></td>
            <td><s:property value="#airticket.sex"/></td>
            <td><s:property value="#airticket.from_city"/></td>
            <td><s:property value="#airticket.to_city"/></td>
            <td><s:property value="#airticket.start_time"/></td>
            <td><s:property value="#airticket.id_card"/></td>
            <td>
                <a href="javascript:queryUserDetails('<s:property value="id"/>')">修改</a>
                <a href="javascript:deleteUser('<s:property value="id"/>')">删除</a>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
