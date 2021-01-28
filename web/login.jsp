<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng Nhập</title>
        <link rel="stylesheet" href="css/sp.css">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <div class="container">
            <header></header>
                <jsp:include page="navbar.jsp"/>
            <article>
                <h1>Đăng Nhập</h1>
                <%
                    String message = (String) request.getAttribute("message");
                    if (message != null) {
                        out.println("<div id='error'>" + message + "</div>");
                    }
                %>
                <form action="accountController">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="text" class="form-control" placeholder="Enter username" name="username" required/>
                    </div>
                    <br/>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" class="form-control" placeholder="Enter password" name="password" required/>
                    </div>
                    <br/>
                    <input type="submit" class="btn btn-primary" value="Login" name="action"/>
                    <input type="reset" class="btn btn-default" value="Reset"/>
                </form>
            </article>
            <footer>FPT Polytecnich &copy; 2017. All rights reserved.</footer>
        </div>
    </body>
</html>
