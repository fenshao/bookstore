$(function () {
    //选择默认li标签
    $('#myTabs a').click(function (e) {
        $(this).tab('show');

        $.ajax({
            type: "get",
            url: "/bookstore/findBookList",
            data: {
                "cid": $.trim($(".active").children("input[name=cid]").val()),
                "uid": $.trim($(".active").children("input[name=uid]").val())
            },
            dateType: "json",
            success: function (data) {
                var date = $.parseJSON(data);
                var books = date.books;

                var row = $(".row");
                row.empty();
                for (i in books) {
                    var book = books[i]
                    row.append("<div class='col-sm-4 col-md-3'>" +
                        "            <div class='thumbnail' >" +
                        "                <a href='/bookstore/Home/bookinfo?bid=" + book.bid + "'>\n" +
                        "                    <img style='width: 100%; height: 200px; display: block;' alt=\"100%x200\" src='" + "../" + "" + book.image + "' data-src='holder.js/100%x200' data-holder-rendered='true' />" +
                        "                </a>" +
                        "                <div class='caption center'>\n" +
                        "                    <h5>" + book.bname+ "</h5>" +
                        "                    <p><span>价格:</span><span>" + book.price + "</span></p>" +
                        "                    <p><a class='btn btn-primary btn-block' href='/bookstore/Home/bookinfo?bid=" + book.bid + "'>查看详情</a></p>" +
                        "                </div>" +
                        "            </div>" +
                        "        </div>");
                }
            }
            
        });

    });
});