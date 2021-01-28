

<%@page import="dao.accountDAO"%>
<%@page import="model.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh Sách Quản Lý</title>
        <link rel="stylesheet" href="css/sp.css">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <div class="container">
            <header></header>
                <jsp:include page="navbar.jsp"/>
            <article>     
                <h1>Danh Sách Quản Lý</h1>
                <form action="accountController" >
                    <div class="input-group">
                        <input class="form-control" placeholder="Search for username" name="keyword"/>
                        <div class="input-group-btn">
                            <input type="submit" class="btn btn-default" value="Search" name="action"/>
                        </div>
                    </div>
                </form>
                <hr/>
                <form action="accountController">
                    <table class="table table-hover">
                        <tr>
                            <th>ID</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Role</th>
                            <th colspan="3"></th>
                        </tr>
                        <%
                            //ArrayList<user> list = (ArrayList) session.getAttribute("list");
                            String keyword = (String) request.getParameter("keyword");
                            if (keyword == null) {
                                keyword = "";
                            }
                            ArrayList<Account> list = new accountDAO().getList(keyword);
                            for (Account u : list) {
                                out.println("<tr>"
                                        + "<td>" + u.getId() + "</td>"
                                        + "<td>" + u.getUsername() + "</td>"
                                        + "<td>" + u.getPassword() + "</td>"
                                        + "<td>" + u.getRole() + "</td>"
                                        + "<form action='accountController'>"
                                        + "<td><input type='submit' class='btn btn-info' value='Update' name='action'/></td>"
                                        + "<td><input type='submit' class='btn btn-danger' value='Delete' name='action'/></td>"
                                        + "<input type='hidden' value=" + u.getId() + " name='accountid'/>"
                                        + "</form>"
                                        + "<td><input type='checkbox' value=" + u.getId() + " name='chon'/></td>"
                                        + "</tr>");
                            }
                        %>
                    </table>
                    <input type="submit" class="btn btn-danger del-all" value="Delete All" name="action" style="float: right"/>
                </form>
            </article>
            <footer>FPT Polytecnich &copy; 2017. All rights reserved.</footer>
        </div>
    </body>
</html>
