$(function () {

    //用户名input获取光标
    $("#username").focus(function () {
        $(this).css("border", "1px solid #3879D9")
            .next().text("请输入用户名").css("display", "inline-block").css("color", "#00A0E9");
    });

    $("#password").focus(function () {
        $(this).css("border", "1px solid #3879D9")
            .next().text("请输入密码").css("display", "inline-block").css("color", "#00A0E9");
    });

    $("#password2").focus(function () {
        $(this).css("border", "1px solid #3879D9")
            .next().text("请再次输入密码").css("display", "inline-block").css("color", "#00A0E9");
    });

    $("#email").focus(function () {
        $(this).css("border", "1px solid #3879D9")
            .next().text("请输入邮箱").css("display", "inline-block").css("color", "#00A0E9");
    });

    //用户名重复验证
    $("#username").blur(function () {
       $.ajax({
           type: "get",
           url: "/bookstore/doCheckUser",
           data: {
               "username": $.trim($("input[name=username]").val()),
           },
           dateType: "json",
           success: function (data) {
               var json = JSON.parse(data);
               if (json.success) {
                   $("#username").css("border", "1px solid red")
                       .next().text("用户名已经存在").css("display", "inline-block").css("color", "red");
                   $("#username").val("");
               }
           }
       });
    });

    //邮箱重复验证
    $("#email").blur(function () {
        $.ajax({
            type: "get",
            url: "/bookstore/doCheckEmail",
            data: {
                "email": $.trim($("input[name=email]").val())
            },
            dateType: "json",
            success: function (data) {
                var json = JSON.parse(data);
                if (json.success) {
                    $("#email").css("border", "1px solid red")
                        .next().text("邮箱已经存在").css("display", "inline-block").css("color", "red");
                    $("#email").val("");
                }
            }
        });
    });

    //非空验证
    $("#submit").click(function () {

        //用户名
        var username = $.trim($("input[name=username]").val());
        //密码
        var password = $.trim($("input[name=password]").val());
        //确认密码
        var password2 = $.trim($("input[name=password2]").val());
        //邮箱
        var email = $.trim($("input[name=email]").val());


        if (username == null || username === "") {
            $("#username").css("border", "1px solid red")
                .next().text("请输入用户名").css("display", "inline-block").css("color", "red");
            return false;
        }
        else if (password == null || password === "") {
            $("#password").css("border", "1px solid red")
                .next().text("请输入密码").css("display", "inline-block").css("color", "red");
            return false;
        }
        else if (password2 == null || password2 === "") {
            $("#password2").css("border", "1px solid red")
                .next().text("请再次输入密码").css("display", "inline-block").css("color", "red");
            return false;
        }
        else if (email == null || email === "") {
            $("#email").css("border", "1px solid red")
                .next().text("请输入邮箱").css("display", "inline-block").css("color", "red");
            return false;
        } else if (password != password2) {
            $("#password2").css("border", "1px solid red")
                .next().text("两次输入的密码不一样").css("display", "inline-block").css("color", "red");
            return false;
        }

        $.ajax({
            type: "post",
            url: "/bookstore/doRegister",
            data: {
                "username": username,
                "password": password,
                "email": email
            },
            dateType: "json",
            success: function (data) {
                var json = JSON.parse(data);
                if (json.success) {
                    alert("注册成功！请到邮箱激活后登录！");
                    location.href = "/bookstore/Home/Login.jsp";
                }
            }
        });
    });
})