<%--
  Created by IntelliJ IDEA.
  User: Standard_lang
  Date: 2018/4/19
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*,action.*" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <%--<script type="text/javascript" src="js/showTickets.js"></script>--%>
    <script type="text/javascript">
        function deleteTicket(tid){
            if(confirm("你确定删除该预定信息吗?")){
                location.href="deleteTicketAction?tid="+tid;
            }
        }
        function queryTicketDetails(tid){
            // alert("afsdfdas");
            location.href="queryTicketByTidAction?tid="+tid;
        }
    </script>
</head>
<body>
<s:include value="main.jsp"/>
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
        <th>操作</th>
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
                <a href="javascript:queryTicketDetails('<s:property value="#airticket.tid"/>')">修改</a>
                <a href="javascript:deleteTicket('<s:property value="#airticket.tid"/>')">删除</a>
            </td>
        </tr>
    </s:iterator>
</table>
[<a href="queryTicketsAction?pageNo=1">首页</a>]
<c:choose>
    <c:when test="${currentPage>1}">
        [<a href="queryTicketsAction?pageNo=${currentPage-1}">上一页</a>]
    </c:when>
</c:choose>
<c:choose>
    <c:when test="${currentPage<totalPage}">
        [<a href="queryTicketsAction?pageNo=${currentPage+1}">下一页</a>]
    </c:when>
</c:choose>
[<a href="queryTicketsAction?pageNo=${totalPage}">尾页</a>]
</body>
</html>
