<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../bootstrap-3.3.4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../Flat-UI-master/dist/css/flat-ui.min.css"/>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>订单详情</title>
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
        .list-group-item:hover{
            background: #27ae60;

        }
        .list-group-item div:first-child:hover{

            cursor: pointer;
        }
        th{
            text-align: right;
            width: 200px;;
        }
        td{
            text-align: left;
            padding: 10px;
        }
        .table th{
            text-align: center;
        }
        .table td{
            text-align: center;
        }
    </style>
    <script>
        function myClick(n){
            location.href = "OrderInfoService.html";
        }
        function btnClick(){
            alert("btn");
            return false;
        }
        $(function(){

        })
    </script>
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
    <div class="row thumbnail center col-sm-12">
        <div class="col-sm-12">
            <h1 class="text-center" style="margin-bottom: 30px">订单详情</h1>
        </div>

        <div class="col-sm-12 ">

           <table>
               <tr>
                   <th>订单编号：</th><td>${orders.oid}</td>
               </tr>
               <tr>
                   <th>订单状态：</th>
                   <td>
                       <x:choose>
                           <x:when test="${orders.state==0}">未付款</x:when>
                           <x:when test="${orders.state==2}">已发货</x:when>
                           <x:otherwise>已付款</x:otherwise>
                       </x:choose>
                   </td>
               </tr>
               <tr>
                   <th>收货人姓名：</th><td>${orders.user.username}</td>
               </tr>
               <tr>
                   <th>收货人地址：</th><td>${orders.user.address}</td>
               </tr>
           </table>
        </div>
        <div class="col-sm-12">
            <table class="table table-striped table-condensed">
                <tr>
                    <th>书名</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>小计</th>
                </tr>
                <x:forEach items="${orderitems}" var="infos">
                    <tr>
                        <td>${infos.book.bname}</td>
                        <td>${infos.book.price}</td>
                        <td>${infos.count}</td>
                        <td>${infos.subtotal}</td>
                    </tr>
                </x:forEach>
            </table>
        </div>

        <div class="col-sm-12 ">
            <table>
                <tr>
                   <th> </th><th></th> <th>商品总数：</th><td>${numbers}</td> <th>订单总价：</th><td><span class="text-danger">￥${orders.price}</span></td>
                </tr>
            </table>
        </div>
    </div>
    <form method="post" action="/bookstore/Home/pay">
    <div class="col-sm-offset-10 col-sm-5" style="padding: 30px;">
        <input type="hidden" name="WIDout_trade_no" value="${orders.oid}" />
        <input type="hidden" name="WIDtotal_amount" value="${orders.price}" />
        <input type="hidden" name="WIDsubject" value="网上书店售书"/>
        <input type="hidden" name="WIDbody" value="网上书店售书" />

        <a href="/bookstore/Home/login" class="btn btn-success" >继续购物</a>
        <x:choose>
            <x:when test="${orders.state==0}"><input type="submit" class="btn btn-success" value="付款" /></x:when>
            <x:otherwise></x:otherwise>
        </x:choose>
    </div>
    </form>
</div>
<div class="navbar navbar-default footer">
    <p class="text-center" style="margin-top: 20px;">Copyright2019&copy;汪字全</p>
</div>
</body>
<!--个人资料-->
<!-- 模态框（Modal） -->
<form class="form-horizontal" method="post" action="/bookstore/Home/updateInfo">
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
                            <input type="hidden" name="uid" value="${user.uid}" />
                            <input type="text" class="form-control" id="username" name="username" placeholder="请输入您的用户名" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="" class="col-sm-3 control-label">邮箱</label>
                        <div class="col-lg-7">
                            <input type="text" class="form-control" id="email" name="email" placeholder="请输入新的邮箱" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">地址</label>
                        <div class="col-lg-7">
                            <input type="text" class="form-control" id="address" name="address" placeholder="请输入您的地址" value="" />
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="submit" id="usubmit" class="btn btn-primary">
                        修改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</form>
<!--修改密码-->
<!-- 模态框（Modal） -->
<form  class="form-horizontal" method="post" action="/bookstore/Home/updatepswd">
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
                    <button type="submit" id="pwdsubmit" class="btn btn-primary">
                        修改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</form>
</html>