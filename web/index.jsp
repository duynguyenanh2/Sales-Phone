<%@page import="dao.SanPhamDao"%>
<%@page import="model.SanPham"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/sp.css">
    </head>
    <body>
        <div class="container">
            <header></header>
            <jsp:include page="navbar.jsp"/>
            <article>
                <h1>SMART PHONE</h1>
                <h4><font color="red">${requestScope.message}</font></h4>
                <%
                    ArrayList<SanPham> list = new SanPhamDao().getList();
                %>
                <c:forEach var="p" items="<%= list%>">
                    <div class ="col-25">
                        <div class="prod">
                            <div class="name">${p.tensp}</div>
                            <img class="image" src="images/${p.hinh}"/>
                            <div class="price">${p.dongia}</div>
                            <div class="btnmua">
                                <a href="CartController?action=AddToCart&id=${p.masp}" class="btn btn-success">Add To Cart</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <form action ="CartController" align="center" >
                    <input type= "submit" value ="View Cart" name="action" class="btn1" />
                </form>
            </article>
            <footer>FPT Polytecnich &copy; 2017. All rights reserved.</footer>
        </div>
    </body>
</html>
