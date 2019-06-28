<%@ page import="cn.ynni.bookstore.entity.Orderitem" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.ynni.bookstore.service.OrderItemService" %>
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
    <script src="../js/Cart.js"></script>
    <title>购物车</title>
    <style>
        .row{
            margin-left: 20px;
            margin-right: 20px;;
        }
        .line-center{
            line-height:50px;
            text-align: center;
        }
        .row input{
            width: 50px;
        }
    </style>
</head>
<body>
<!-- Static navbar -->
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/bookstore/Home/login?uid=${user.uid}">图书商城</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right hidden-sm">
                <li><a href="/bookstore/Home/cart?uid=${user.uid}"><span class="glyphicon glyphicon-shopping-cart">购物车</span></a></li>
                <x:choose>
                    <x:when test="${empty user}">
                        <li><a href="Login.jsp">登录</a></li>
                        <li><a href="Register.jsp">注册</a></li>
                    </x:when>
                    <x:otherwise>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="dropdownMenu1">
                                <i class="glyphicon glyphicon-user" aria-hidden="true"></i>欢迎您,
                                    ${user.username}
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <li><a href="#updateinfo" data-toggle="modal">个人资料</a></li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="#updatepwd" data-toggle="modal">修改密码</a></li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="/bookstore/Home/order?uid=${user.uid}">订单管理</a></li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="../loginOut">退出</a></li>
                            </ul>
                        </li>
                    </x:otherwise>
                </x:choose>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
<!--content-->
<div class="container">
    <div class="row thumbnail center">
        <div class="col-sm-12">
            <h1 class="text-center" style="margin-bottom: 30px">购物车</h1>
        </div>
        <div class=" list-group">

            <div class="col-sm-12 thumbnail table-responsiv">
                <table class="table">
                    <thead>
                    <tr class="line-center">
                        <th class="text-center"></th>
                        <th class="text-center">图书</th>
                        <th class="text-center">单价</th>
                        <th class="text-center">数量</th>
                        <th class="text-center">小计</th>
                        <th class="text-center">操作</th>
                    </tr>
                    <script>
                        var totalAmount = 0;
                        var totalCount = 0;
                    </script>
                    </thead>
                        <tbody>
                            <c:forEach items="${ois}" var="oi">
                                <tr>
                                    <td><div class="line-center"><img src="../${oi.book.image}" style="width: 40px; height: 60px"></div></td>
                                    <td><div class="line-center">${oi.book.bname}</div></td>
                                    <td><div class="line-center">￥${oi.book.price}</div></td>
                                    <td>
                                        <div class="line-center">
                                            <button type="button" class="btn btn-default">
                                                <span id="minus${oi.book.bid}" class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                                            </button>
                                            <input type="text" name="number" id="count${oi.book.bid}" style="width: 40px" value="${oi.count}"/>
                                            <button type="button" class="btn btn-default">
                                                <span id="plus${oi.book.bid}"  class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                            </button>
                                        </div>
                                    </td>
                                    <script>
                                        var count${oi.book.bid} = $("#count${oi.book.bid}").val();

                                        var price${oi.book.bid} = ${oi.book.price};

                                        $("#minus${oi.book.bid}").click(function () {
                                            if (count${oi.book.bid} <= 1) {
                                                alert("不能再减啦。。。");
                                            }
                                            else {
                                                --count${oi.book.bid};
                                                totalAmount -= price${oi.book.bid};
                                                --totalCount;
                                                $("#totalCount").text(totalCount);
                                                $("#totalAmount").text(totalAmount.toFixed(2));
                                                $("#count${oi.book.bid}").val(count${oi.book.bid});
                                                $("#itemTotal${oi.book.bid}").text("￥" + (count${oi.book.bid} * price${oi.book.bid}).toFixed(2));
                                            }
                                        });
                                        $("#plus${oi.book.bid}").click(function () {
                                            ++count${oi.book.bid};
                                            ++totalCount;
                                            totalAmount += price${oi.book.bid};
                                            $("#totalCount").text(totalCount);
                                            $("#totalAmount").text(totalAmount.toFixed(2));
                                            $("#count${oi.book.bid}").val(count${oi.book.bid});
                                            $("#itemTotal${oi.book.bid}").text("￥" + (count${oi.book.bid} * price${oi.book.bid}).toFixed(2));
                                        });
                                    </script>
                                    <td>
                                        <div class="line-center" id="itemTotal${oi.book.bid}"></div>

                                    <script>
                                        var count${oi.book.bid} = $("#count${oi.book.bid}").val();
                                        var price${oi.book.bid} = ${oi.book.price};
                                        totalAmount += count${oi.book.bid} * price${oi.book.bid};
                                        totalCount += parseInt(count${oi.book.bid});
                                        $("#totalCount").text(totalCount);
                                        $("#totalAmount").text(totalAmount.toFixed(2));
                                        $("#itemTotal${oi.book.bid}").text("￥" + (count${oi.book.bid} * price${oi.book.bid}));
                                    </script>

                                    <td><div class="line-center"><a class="btn btn-default btn-danger" role="button" href="/bookstore/Home/CartDelete?bid=${oi.book.bid}">删除</a></div></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="3">统计</td>
                            <td class="text-center">总数：<span id="totalCount"></span></td>
                            <td class="text-center">总价:￥<span id="totalAmount"></span></td>
                        </tr>
                        <script>
                            $(document).ready(function () {
                                $("#totalCount").text(totalCount);
                                $("#totalAmount").text(totalAmount.toFixed(2));
                                $("input[type=hidden][name=totalCount]").val(totalCount);
                                $("input[type=hidden][name=totalAmount]").val(totalAmount.toFixed(2));
                            });
                        </script>
                </table>

        </div>
        <div class="col-sm-offset-7 col-sm-5" style="padding: 30px;">
            <a href="/bookstore/Home/login" class="btn btn-success" >继续购物</a>
            <a class="btn btn-danger" id="createorder">提交订单</a>
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
</body>
</html>