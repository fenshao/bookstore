<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../bootstrap-3.3.4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../Flat-UI-master/dist/css/flat-ui.min.css"/>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="../js/adminbooklist.js"></script>
    <title>网上书店-主页</title>
    <style>
        .row{
            margin-top: 20px;;
        }
        .center{
            text-align: center;
        }
        .pagination{
            background: #cccccc;
        }
    </style>
</head>
<body>
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/bookstore/Home/login?uid=${user.uid}">图书商城后台管理系统</a>
            <ul class="nav navbar-nav navbar-right hidden-sm">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="usermenu">
                        用户管理
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="usermenu">
                        <li><a href="/bookstore/admin/userList" data-toggle="modal">用户列表</a></li>
                        <li role="presentation" class="divider"></li>
                        <li><a href="#insertuser" data-toggle="modal">添加用户</a></li>
                        <li role="presentation" class="divider"></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="bookmenu">
                        书籍管理
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="usermenu">
                        <li><a href="/bookstore/admin/bookList" data-toggle="modal">书籍列表</a></li>
                        <li role="presentation" class="divider"></li>
                        <li><a href="#insertuser" data-toggle="modal">添加图书</a></li>
                        <li role="presentation" class="divider"></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="categorymenu">
                        分类管理
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="usermenu">
                        <li><a href="/bookstore/admin/categoryList" data-toggle="modal">分类列表</a></li>
                        <li role="presentation" class="divider"></li>
                        <li><a href="#updatepwd" data-toggle="modal">添加分类</a></li>
                        <li role="presentation" class="divider"></li>
                    </ul>
                </li>
                <li><a href="/bookstore/admin/orderList">订单管理</a></li>
            </ul>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right hidden-sm">
                <c:choose>
                    <c:when test="${empty admin}">
                        <li><a href="Login.jsp">登录</a></li>
                        <li><a href="Register.jsp">注册</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="dropdownMenu1">
                                <i class="glyphicon glyphicon-user" aria-hidden="true"></i>欢迎您,
                                ${admin.username}
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <li><a href="#updateinfo" data-toggle="modal">个人资料</a></li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="#updatepwd" data-toggle="modal">修改密码</a></li>
                                <li role="presentation" class="divider"></li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="../loginOut">退出</a></li>
                            </ul>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
<!--content-->
<div class="container">
    <div class="row thumbnail center">
        <div class="col-sm-12">
            <h1 class="text-center" style="margin-bottom: 30px">图书列表</h1>
        </div>
        <div class=" list-group">
            <div class="col-sm-12 thumbnail table-responsiv">
                <table class="table table-striped table-condensed">
                    <thead>
                    <tr class="line-center">
                        <th>图片</th>
                        <th>书籍id</th>
                        <th>书名</th>
                        <th>价格</th>
                        <th>作者</th>
                        <th>类别</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <x:forEach items="${bookList}" var="book">
                        <tr>
                            <td><div class="line-center"><img src="../${book.image}" style="width: 40px; height: 60px"></div></td>
                            <td><div class="line-center">${book.bid}</div></td>
                            <td><div class="line-center">${book.bname}</div></td>
                            <td><div class="line-center">${book.price}</div></td>
                            <td><div class="line-center">${book.author}</div></td>
                            <td><div class="line-center">${book.category.cname}</div></td>
                            <td>
                                <div class="line-center">
                                    <button class="btn btn-danger btn-xs" onclick="deleteuser('${book.bid}')">删除</button>
                                    <button data-toggle="modal" data-target="#updateuser" class="btn btn-success btn-xs" onclick="showBookInfo('${book.bid}', '${book.bname}', '${book.price}', '${book.author}', '${book.cid}')" id="btn-update" data-toggle="modal" data-target="#updateuser">修改</button>
                                </div>
                            </td>
                            <td></td>
                        </tr>
                    </x:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>

<div class="navbar navbar-default footer">
    <p class="text-center" style="margin-top: 20px;">Copyright2019&copy;汪字全</p>
</div>

<!--个人资料-->
<!-- 模态框（Modal） -->
<div class="form-horizontal">
    <div class="modal fade" id="updateinfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        个人资料
                    </h4>
                </div>
                <div class="modal-body">
                    <!--正文-->
                    <div class="form-group">
                        <label class="col-sm-3 control-label">用户名</label>
                        <div class="col-lg-7">
                            <input type="text" class="form-control" id="username" name="username" placeholder="请输入您的用户名" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="" class="col-sm-3 control-label">邮箱</label>
                        <div class="col-lg-7">
                            <input type="text" class="form-control" id="sex" name="sex" placeholder="请输入新的邮箱" value="" />
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="usubmit" class="btn btn-primary">
                        修改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>
<!--修改密码-->
<!-- 模态框（Modal） -->
<div  class="form-horizontal">
    <div class="modal fade" id="updatepwd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        修改密码
                    </h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">原密码</label>
                        <div class="col-lg-7">
                            <input type="password" class="form-control" id="oldPwd" name="password" placeholder="请输入原密码" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="" class="col-sm-3 control-label">新密码</label>
                        <div class="col-lg-7">
                            <input type="password" class="form-control" id="newPwd" name="password2" placeholder="请输入新密码" value="" />
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="pwdsubmit" class="btn btn-primary">
                        修改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>

<%--添加用户--%>
<form  class="form-horizontal" method="post" action="/bookstore/admin/addBook" enctype="multipart/form-data">
    <div class="modal fade" id="insertuser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        添加图书
                    </h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">书名</label>
                        <div class="col-lg-7">
                            <input type="text"  class="form-control" id="ibname" name="ibname" value=""/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">价格</label>
                        <div class="col-lg-7">
                            <input type="text" class="form-control" id="iprice" name="iprice" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">作者</label>
                        <div class="col-lg-7">
                            <input type="text" class="form-control" id="iauthor" name="iauthor" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">类别</label>
                        <div class="col-lg-7">
                            <select class="form-control" id="icategory" name="icategory">
                                <x:forEach items="${categorylist}" var="list">
                                    <option value="${list.cid}">${list.cname}</option>
                                </x:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="" class="col-sm-3 control-label">图片(不修改请不要上传图片)</label>
                        <div class="col-lg-7 custom-file">
                            <input  class="custom-file-input" type="file"  id="iname" name="path" />
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="submit" id="usersubmit" class="btn btn-primary">
                        修改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</form>

<%--//修改书籍--%>
<form  class="form-horizontal" method="post" action="/bookstore/admin/updateBook" enctype = "multipart/form-data" >
    <div class="modal fade" id="updateuser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        修改图书
                    </h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">图书id</label>
                        <div class="col-lg-7">
                            <input type="text" class="form-control" id="bid" name="bid" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">书名</label>
                        <div class="col-lg-7">
                            <input type="text"  class="form-control" id="bname" name="bname" value=""/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">价格</label>
                        <div class="col-lg-7">
                            <input type="text" class="form-control" id="price" name="price" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">作者</label>
                        <div class="col-lg-7">
                            <input type="text" class="form-control" id="author" name="author" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">类别</label>
                        <div class="col-lg-7">
                            <select class="form-control" id="category" name="category">
                                <x:forEach items="${categorylist}" var="list">
                                    <option value="${list.cid}">${list.cname}</option>
                                </x:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="" class="col-sm-3 control-label">图片(不修改请不要上传图片)</label>
                        <div class="col-lg-7 custom-file">
                            <input  class="custom-file-input" type="file"  id="name" name="path" />
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="submit" id="usersubmit" class="btn btn-primary">
                        修改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</form>


<script type="text/javascript">
    function showBookInfo(bid, bname, price, author, category) {
        $("#bid").val(bid);
        $("#bname").val(bname);
        $("#price").val(price);
        $("#author").val(author);
        $("#category").val(category);
    }

    function deleteuser(bid) {
        con = confirm("是否删除?");
        if (con == true) {
            location.href = "/bookstore/admin/deleteBook?bid=" + bid;
        }
    }
</script>
</body>
</html>