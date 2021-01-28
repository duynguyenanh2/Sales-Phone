<%@page import="java.util.ArrayList"%>
<%@page import="dao.SanPhamDao"%>
<%@page import="model.DanhMuc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm Sản Phẩm</title>
        <link rel="stylesheet" href="css/sp.css">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <div class="container">
            <header></header>
                <jsp:include page="navbar.jsp"/>
            <article>
                <h1>Thêm Sản Phẩm</h1>
                <form action="sanphamController" method="post" enctype="multipart/form-data">
                    <p>
                        <label>Tên:</label>
                        <input type="text" class="form-control" placeholder="Điền tên sản phẩm" name="tensp" required/>
                    </p>
                    <p>
                        <label>Giá:</label>
                        <input type="number" class="form-control" placeholder="Điền giá sản phảm" name="dongia" required/>
                    </p>
                    <p>
                        <label>Hình:</label>
                        <input type="file" name="file" size="50"/>
                    </p>
                    <p>
                        <label>Danh Mục:</label>
                        <select class="form-control" name="madm">
                            <%
                                ArrayList<DanhMuc> list = new SanPhamDao().getDMList();
                            %>
                            <c:forEach var="ct" items="<%= list%>">
                                <option value="${ct.id}">${ct.name}</option>
                            </c:forEach>
                        </select>
                    </p>
                    <input type="submit" class="btn btn-success" value="Insert" name="action"/>
                </form>
            </article>
            <footer>FPT Polytecnich &copy; 2017. All rights reserved.</footer>
        </div>
    </body>
</html>
