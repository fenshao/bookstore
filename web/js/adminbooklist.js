$(function () {
    $("#isubmit").click(function () {

        var username = $.trim($("input[name=iusername]").val());
        var password = $.trim($("input[name=ipassword]").val());
        var email = $.trim($("input[name=iemail]").val());
        var state = $.trim($("select[name=istate]").val());
        var address = $.trim($("input[name=iaddress]").val());

        $.ajax({
            type: "post",
            url: "/bookstore/addBook",
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

