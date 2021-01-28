<%@page import="java.util.ArrayList"%>
<%@page import="dao.SanPhamDao"%>
<%@page import="model.SanPham"%>
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
                <h1>Sản Phẩm</h1>
                <form action="sanphamController" method="post">
                    <table class="table table-hover">
                        <tr>
                            <th>Mã</th>
                            <th>Tên</th>
                            <th>Giá</th>
                            <th>Hình</th>
                            <th>Danh Mục</th>
                            <th colspan="3"></th>
                        </tr>
                        <%
                            ArrayList<SanPham> list = new SanPhamDao().getList();
                        %>
                        <c:forEach var="p" items="<%= list%>">
                            <tr>
                                <td>${p.masp}</td>
                                <td>${p.tensp}</td>
                                <td>${p.dongia}</td>
                                <td><img height=100 src="images/${p.hinh}"/></td>
                                <td>${p.getDanhMuc()}</td>
                            <form action="sanphamController" method="post">
                                <td><input type="submit" class="btn btn-info" value="Update" name="action"/></td>
                                <td><input type="submit" class="btn btn-danger" value="Delete" name="action"/></td>
                                <input type="hidden" value="${p.masp}" name="sanphamid"/>
                            </form>
                            <td><input type="checkbox" value="${p.masp}" name="chon"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <input type="submit" class="btn btn-danger del-all" value="Xóa tất cả" name="action" style="float: right"/>
                </form>
            </article>
            <footer>FPT Polytecnich &copy; 2017. All rights reserved.</footer>
        </div>
    </body>
</html>
