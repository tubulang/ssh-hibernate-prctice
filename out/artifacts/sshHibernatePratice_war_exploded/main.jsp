<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Standard_lang
  Date: 2018/5/10
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript">

            function outLogin(){
                window.location.href="outLoginAction";


            }
        </script>
        <%--<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
        <title>Title</title>

    </head>
    <body>
    <!-- 模态框（Modal） -->
    <%--<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">开始演示模态框</button>--%>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">

                    <h4 class="modal-title" id="myModalLabel" style="float: left;">退出系统</h4>
                    <button type="button" class="close" style="float: left;" data-dismiss="modal" aria-hidden="true">×</button>
                </div>
                <h4 class="modal-body" style="text-align: center">确认退出系统？</h4>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="outLogin()">确认</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
            <a class="navbar-brand" href="reglogin.jsp">首页</a>
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
                        <a class="nav-link acitve" href="" data-toggle="modal" data-target="#myModal">退出系统</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0" action="setQueryDataAction" method="post">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search"
                           aria-label="Search" name="query_data">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
                        Search
                    </button>
                </form>
            </div>
        </nav>

    <%--<a href="outLoginAction">退出</a>--%>
    </body>
</html>
