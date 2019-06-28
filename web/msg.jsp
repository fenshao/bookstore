<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>激活</title>
</head>
<body>

	<p>${msg}</p>
    <span id="sp"></span>

	<script type="text/javascript">
        onload = function() {
            <%
                String str = (String) request.getAttribute("str");
                if (str != null && str.equals("true")) {
            %>
            setInterval(go, 1000);
            <%}%>
        };

        var x = 3; //利用了全局变量来执行

        function go() {
            x--;
            if (x > 0){
                document.getElementById("sp").innerHTML = x; //每次设置的x的值都不一样了。
            } else{
                location.href='/bookstore/Home/Login.jsp';
            }
        }
	</script>
</body>
</html>