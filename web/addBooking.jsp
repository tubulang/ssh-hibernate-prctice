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
    <link href="css/bootstrap.min.css" rel="stylesheet">
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
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
    <a class="navbar-brand" href="main.jsp">首页</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="changepwd.jsp">修改密码 <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="addBooking.jsp">机票预定</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="queryTicketsAction">预定信息维护</a>
                <%--<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                <%--Dropdown--%>
                <%--</a>--%>
                <%--<div class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
                <%--<a class="dropdown-item" href="#">Action</a>--%>
                <%--<a class="dropdown-item" href="#">Another action</a>--%>
                <%--<div class="dropdown-divider"></div>--%>
                <%--<a class="dropdown-item" href="#">Something else here</a>--%>
                <%--</div>--%>
            </li>
            <li class="nav-item active">
                <a class="nav-link acitve" href="#">退出系统</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search"
                   aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
                Search
            </button>
        </form>
    </div>
</nav>
    <div class="main">
        <h1>在线机票预定</h1>
        <%--校验未显示出来，但在控制台可以看到--%>
        <%--<s:fielderror />--%>
        <%--<s:fielderror/>--%>
        <s:form method="post" action="AddBookingAction">
            <s:textfield name="air_ticket.name" label="姓名"/>
            <s:radio name="air_ticket.sex" list="#{'男':'男','女':'女'}" label="性别" value='男'/>
            <s:textfield name="air_ticket.from_city" label="始发城市"/>
            <s:textfield name="air_ticket.to_city" label="目的城市"/>
            <s:textfield name="air_ticket.start_time" label="出发日期"/>
            <%--<input type="date" name="air_ticket.start_time">出发日期</input>--%>
            <s:textfield name="air_ticket.id_card" label="身份证"/>
            <s:submit name="addsubmit" value="预定"/>
            <%--<s:reset name="regreset" value="重置"/>--%>
        </s:form>
    </div>
<script src="js/jquery-3.3.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
