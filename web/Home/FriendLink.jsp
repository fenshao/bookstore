<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">

    <link rel="stylesheet" href="../bootstrap-3.3.4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../Flat-UI-master/dist/css/flat-ui.min.css"/>
    <script src="../Flat-UI-master/dist/js/vendor/jquery.min.js"></script>
    <script src="../bootstrap-3.3.4/dist/js/bootstrap.min.js"></script>
    <script src="../Flat-UI-master/dist/js/flat-ui.min.js"></script>
    <title></title>
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
            width: 10%;;
            padding: 10px;
        }
        td{
            text-align: left;
            width: 30%;;
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
    <script>
        $(function(){
            $('#myTabs a').click(function (e) {

                $(this).tab('show')
            });
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
                                <%=request.getSession().getAttribute("username")%>
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
    <div class="row">
        <div class="col-sm-4 col-md-3">
            <div class="thumbnail" >
                <a href="BookInfo.html">
                    <img style="width: 100%; height: 200px; display: block;" alt="100%x200" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAzNDggMjAwIiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJub25lIG1lZXQiIHdpZHRoPSIzNDgiIGhlaWdodD0iMjAwIj48ZGVmcyAvPjxyZWN0IGZpbGw9IiNlZWVlZWUiIHdpZHRoPSIzNDgiIGhlaWdodD0iMjAwIiAvPjxnPjx0ZXh0IHN0eWxlPSJmb250LWZhbWlseTogQXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7IGZvbnQtc2l6ZTogMjJweDsgZm9udC13ZWlnaHQ6IGJvbGQ7IGRvbWluYW50LWJhc2VsaW5lOiBjZW50cmFsOyBmaWxsOiAjYWFhYWFhOyIgeD0iMTMxLjE2IiB5PSIxMDAiPjM0OHgyMDA8L3RleHQ+PC9nPjwvc3ZnPg==" data-src="holder.js/100%x200" data-holder-rendered="true">
                </a>
            </div>
        </div>
        <div class="col-sm-4 col-md-3">
            <div class="thumbnail" >
                <a href="BookInfo.html">
                    <img style="width: 100%; height: 200px; display: block;" alt="100%x200" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAzNDggMjAwIiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJub25lIG1lZXQiIHdpZHRoPSIzNDgiIGhlaWdodD0iMjAwIj48ZGVmcyAvPjxyZWN0IGZpbGw9IiNlZWVlZWUiIHdpZHRoPSIzNDgiIGhlaWdodD0iMjAwIiAvPjxnPjx0ZXh0IHN0eWxlPSJmb250LWZhbWlseTogQXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7IGZvbnQtc2l6ZTogMjJweDsgZm9udC13ZWlnaHQ6IGJvbGQ7IGRvbWluYW50LWJhc2VsaW5lOiBjZW50cmFsOyBmaWxsOiAjYWFhYWFhOyIgeD0iMTMxLjE2IiB5PSIxMDAiPjM0OHgyMDA8L3RleHQ+PC9nPjwvc3ZnPg==" data-src="holder.js/100%x200" data-holder-rendered="true">
                </a>
            </div>
        </div>
        <div class="col-sm-4 col-md-3">
            <div class="thumbnail" >
                <a href="BookInfo.html">
                    <img style="width: 100%; height: 200px; display: block;" alt="100%x200" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAzNDggMjAwIiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJub25lIG1lZXQiIHdpZHRoPSIzNDgiIGhlaWdodD0iMjAwIj48ZGVmcyAvPjxyZWN0IGZpbGw9IiNlZWVlZWUiIHdpZHRoPSIzNDgiIGhlaWdodD0iMjAwIiAvPjxnPjx0ZXh0IHN0eWxlPSJmb250LWZhbWlseTogQXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7IGZvbnQtc2l6ZTogMjJweDsgZm9udC13ZWlnaHQ6IGJvbGQ7IGRvbWluYW50LWJhc2VsaW5lOiBjZW50cmFsOyBmaWxsOiAjYWFhYWFhOyIgeD0iMTMxLjE2IiB5PSIxMDAiPjM0OHgyMDA8L3RleHQ+PC9nPjwvc3ZnPg==" data-src="holder.js/100%x200" data-holder-rendered="true">
                </a>
            </div>
        </div>
        <div class="col-sm-4 col-md-3">
            <div class="thumbnail" >
                <a href="BookInfo.html">
                    <img style="width: 100%; height: 200px; display: block;" alt="100%x200" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAzNDggMjAwIiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJub25lIG1lZXQiIHdpZHRoPSIzNDgiIGhlaWdodD0iMjAwIj48ZGVmcyAvPjxyZWN0IGZpbGw9IiNlZWVlZWUiIHdpZHRoPSIzNDgiIGhlaWdodD0iMjAwIiAvPjxnPjx0ZXh0IHN0eWxlPSJmb250LWZhbWlseTogQXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7IGZvbnQtc2l6ZTogMjJweDsgZm9udC13ZWlnaHQ6IGJvbGQ7IGRvbWluYW50LWJhc2VsaW5lOiBjZW50cmFsOyBmaWxsOiAjYWFhYWFhOyIgeD0iMTMxLjE2IiB5PSIxMDAiPjM0OHgyMDA8L3RleHQ+PC9nPjwvc3ZnPg==" data-src="holder.js/100%x200" data-holder-rendered="true">
                </a>
            </div>
        </div>
        <div class="col-sm-4 col-md-3">
            <div class="thumbnail" >
                <a href="BookInfo.html">
                    <img style="width: 100%; height: 200px; display: block;" alt="100%x200" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAzNDggMjAwIiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJub25lIG1lZXQiIHdpZHRoPSIzNDgiIGhlaWdodD0iMjAwIj48ZGVmcyAvPjxyZWN0IGZpbGw9IiNlZWVlZWUiIHdpZHRoPSIzNDgiIGhlaWdodD0iMjAwIiAvPjxnPjx0ZXh0IHN0eWxlPSJmb250LWZhbWlseTogQXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7IGZvbnQtc2l6ZTogMjJweDsgZm9udC13ZWlnaHQ6IGJvbGQ7IGRvbWluYW50LWJhc2VsaW5lOiBjZW50cmFsOyBmaWxsOiAjYWFhYWFhOyIgeD0iMTMxLjE2IiB5PSIxMDAiPjM0OHgyMDA8L3RleHQ+PC9nPjwvc3ZnPg==" data-src="holder.js/100%x200" data-holder-rendered="true">
                </a>
            </div>
        </div>
        <div class="col-sm-4 col-md-3">
            <div class="thumbnail" >
                <a href="BookInfo.html">
                    <img style="width: 100%; height: 200px; display: block;" alt="100%x200" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAzNDggMjAwIiBwcmVzZXJ2ZUFzcGVjdFJhdGlvPSJub25lIG1lZXQiIHdpZHRoPSIzNDgiIGhlaWdodD0iMjAwIj48ZGVmcyAvPjxyZWN0IGZpbGw9IiNlZWVlZWUiIHdpZHRoPSIzNDgiIGhlaWdodD0iMjAwIiAvPjxnPjx0ZXh0IHN0eWxlPSJmb250LWZhbWlseTogQXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7IGZvbnQtc2l6ZTogMjJweDsgZm9udC13ZWlnaHQ6IGJvbGQ7IGRvbWluYW50LWJhc2VsaW5lOiBjZW50cmFsOyBmaWxsOiAjYWFhYWFhOyIgeD0iMTMxLjE2IiB5PSIxMDAiPjM0OHgyMDA8L3RleHQ+PC9nPjwvc3ZnPg==" data-src="holder.js/100%x200" data-holder-rendered="true">
                </a>
            </div>
        </div>

    </div>
</div>

<!--footer-->
<div class="navbar navbar-default navbar-static-bottom">
    版权声明区
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