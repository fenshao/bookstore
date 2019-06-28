$(function () {
    $("#createorder").click(function () {

       var numbers = [];

       $("input[name=number]").each(function () {
          numbers.push($(this).val());
       });

        $.ajax({
            type: "get",
            url: "/bookstore/createOrder",
            data: {
                "numbers": numbers
            },
            dateType: "json",
            traditional: true,
            success: function (data) {
                var json = JSON.parse(data);

                alert(json.msg);
            }
        })
    });
});