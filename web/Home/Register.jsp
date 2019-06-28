<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">

    <link rel="stylesheet" href="../bootstrap-3.3.4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../Flat-UI-master/dist/css/flat-ui.min.css"/>
    <script src="../Flat-UI-master/dist/js/vendor/jquery.min.js"></script>
    <script src="../bootstrap-3.3.4/dist/js/bootstrap.min.js"></script>
    <script src="../Flat-UI-master/dist/js/flat-ui.min.js"></script>
    <script src="../js/register_fore.js"></script>
    <title>注册</title>
    <style>
        .row{
            margin-left: 20px;
            margin-right: 20px;;
        }

        .form_span {
            font-size: 14px;
        }

    </style>
</head>
<body><br>
<!--content-->
<div class="container">
    <div class="row thumbnail">
        <div class="col-sm-12">
             <h1 class="text-center" style="margin-bottom: 30px">用户注册</h1>
        </div>
        <div class="col-sm-6 col-sm-offset-3">
            <form class="form-horizontal caption">
                <div class="form-group">
                    <label for="username" class="col-sm-3 control-label">用户名</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="username" name="username" placeholder="用户名">
                        <span class="form_span"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">密码</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" id="password" name="password" placeholder="密码">
                        <span class="form_span"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">确认密码</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" id="password2" name="password2" placeholder="确认密码">
                        <span class="form_span"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">邮箱</label>
                    <div class="col-sm-8">
                        <input type="email" class="form-control" id="email" name="email" placeholder="邮箱">
                        <span class="form_span"></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-6 col-sm-5">
                        <button type="button" class="btn btn-success btn-block" id="submit">注册</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>