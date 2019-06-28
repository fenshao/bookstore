$(function () {
    $("#usersubmit").click(function () {

        var uid = $.trim($("input[name=userid]").val());
        var username = $.trim($("input[name=uusername]").val());
        var email = $.trim($("input[name=uemail]").val());
        var state = $.trim($("select[name=ustate]").val());
        var address = $.trim($("input[name=uaddress]").val());
        var password = $.trim($("input[name=upassword]").val());

        $.ajax({
            type: "post",
            url: "/bookstore/updateUser",
            data: {
                "uid": uid,
                "username": username,
                "email": email,
                "state": state,
                "address": address,
                "password": password
            },
            dateType: "json",
            success: function (data) {
                var json = JSON.parse(data);

                if (json.success) {
                    alert(json.msg)
                    location.href = "/bookstore/admin/userList";
                }
            }
        })
    });

    $("#isubmit").click(function () {

        var username = $.trim($("input[name=iusername]").val());
        var password = $.trim($("input[name=ipassword]").val());
        var email = $.trim($("input[name=iemail]").val());
        var state = $.trim($("select[name=istate]").val());
        var address = $.trim($("input[name=iaddress]").val());

        $.ajax({
            type: "post",
            url: "/bookstore/addUser",
            data: {
                "password": password,
                "username": username,
                "email": email,
                "state": state,
                "address": address
            },
            dateType: "json",
            success: function (data) {
                var json = JSON.parse(data);

                if (json.success) {
                    alert(json.msg)
                    location.href = "/bookstore/admin/userList";
                }
            }
        })
    });
});

