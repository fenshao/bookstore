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

    //非空验证
    $("#submit").click(function () {

        //用户名
        var username = $.trim($("input[name=username]").val());
        //密码
        var password = $.trim($("input[name=password]").val());


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

        $.ajax({
            type: "post",
            url: "/bookstore/admindoLogin",
            data: {
                "username": username,
                "password": password,
            },
            dateType: "json",
            success: function (data) {
                var json = JSON.parse(data);
                if (json.success) {
                    location.href = "/bookstore/admin/userList"
                }
                else {
                    $("#password").css("border", "1px solid red")
                        .next().text("密码错误").css("display", "inline-block").css("color", "red");
                }
            }
        });
    });
});