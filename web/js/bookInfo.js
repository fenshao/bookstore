$(function () {

    //获取加入购物车按钮
    $("#addcart").click(function () {
        var bid = $(this).attr("bid");

        $.ajax({
            type: "post",
            url: "/bookstore/addCart",
            data: {
                "bid": bid,
                "number": 1,
            },
            dateType: "json",
            success: function (data) {
                var json = JSON.parse(data);
                if (json.success) {
                    alert("添加成功！请到购物车查看！")
                }
                else if (json.success == false) {
                    alert(json.msg);
                }
            }
        });
    });

    //购买，先创建订单
    $("#buysubmit").click(function () {
        var numbers = 1;

        $("#buyinfo").find('input').each(function () {
            numbers = $(this).val();
        });

        $.ajax({
            type: "post",
            url: "/bookstore/buyBook",
            data: {
                "numbers": numbers,
                "bid": $.trim($("input[name=buybook]").val())
            },
            dateType: "json",
            success: function (data) {
                var json = JSON.parse(data);
                alert(json.msg);
            }
        })
    });
});