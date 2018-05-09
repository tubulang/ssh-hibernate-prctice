<%--
  Created by IntelliJ IDEA.
  User: Standard_lang
  Date: 2018/4/19
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>在线机票预定</h1>校验未显示出来，但在控制台可以看到
<%--<s:fielderror />--%>
<s:fielderror/>
<s:form method="post" action="AddBookingAction!addBooking">
    <s:textfield name="air_ticket.name" label="姓名"/>
    <s:radio name="air_ticket.sex" list="#{'男':'男','女':'女'}" label="性别" value="男"/>
    <s:textfield name="air_ticket.from_city" label="始发城市"/>
    <s:textfield name="air_ticket.to_city" label="目的城市"/>
    <s:textfield name="air_ticket.start_time" label="出发日期"/>
    <s:textfield name="air_ticket.id_card" label="身份证"/>
    <s:submit name="addsubmit" value="预定"/>
    <%--<s:reset name="regreset" value="重置"/>--%>
</s:form>
</body>
</html>
