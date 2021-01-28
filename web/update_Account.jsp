<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/sp.css">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <div class="container">
            <header></header>
                <jsp:include page="navbar.jsp"/>
            <article>
                <h1>Update user</h1>
                <form action="accountController">
                    <input type="hidden" value="${u.id}" name="id"/>
                    <p>
                        <label>Username:</label>
                        <input type="text" class="form-control" value="${u.username}" name="username" required/>
                    </p>
                    <p>
                        <label>Password:</label>
                        <input type="password" class="form-control" value="${u.password}" name="password" required/>
                    </p>
                    <p>
                        <label>Role:</label>
                        <label class="radio-inline"><input type="radio" name="role" value="true" ${u.role ? "checked" : ""}/>Admin</label>
                        <label class="radio-inline"><input type="radio" name="role" value="false" ${!u.role ? "checked" : ""}/>User</label>
                    </p>
                    <input type="submit" class="btn btn-info" value="ExecUpdate" name="action"/>
                </form>
            </article>
            <footer>FPT Polytecnich &copy; 2017. All rights reserved.</footer>
        </div>
    </body>
</html>
