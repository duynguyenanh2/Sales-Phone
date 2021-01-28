<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng Ký</title>
        <link rel="stylesheet" href="css/sp.css">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <div class="container">
            <header></header>
                <jsp:include page="navbar.jsp"/>
            <article>
                <h1>Đăng Ký</h1>
                <form action="accountController">
                    <p>
                        <label>Username:</label>
                        <input type="text" class="form-control" placeholder="Enter username" name="username" required/>
                    </p>
                    <p>
                        <label>Password:</label>
                        <input type="password" class="form-control" placeholder="Enter password" name="password" required/>
                    </p>
                    <p>
                        <label>Role:</label>
                        <label class="radio-inline"><input type="radio" name="role" value="true" />Admin</label>
                        <label class="radio-inline"><input type="radio" name="role" value="false" checked/>User</label>
                    </p>
                    <input type="submit" class="btn btn-success" value="Insert" name="action"/>
                </form>
            </article>
            <footer>FPT Polytecnich &copy; 2017. All rights reserved.</footer>
        </div>
    </body>
</html>
