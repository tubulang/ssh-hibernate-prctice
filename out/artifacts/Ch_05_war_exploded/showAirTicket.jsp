<%--
  Created by IntelliJ IDEA.
  User: Standard_lang
  Date: 2018/4/19
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*,bean.Booking" contentType="text/html;charset=UTF-8" language="java" %>
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
    <s:iterator value="#session.air_tickets" status="st" var="airticket">
        <tr>
            <td><s:property value="#airticket.getName()"/></td>
            <td><s:property value="#airticket.getSex()"/></td>
            <td><s:property value="#airticket.getFrom_city()"/></td>
            <td><s:property value="#airticket.getTo_city()"/></td>
            <td><s:property value="#airticket.getStart_time()"/></td>
            <td><s:property value="#airticket.getId_card()"/></td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
