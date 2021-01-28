<%-- 
    Document   : showcart
    Created on : May 25, 2020, 7:42:05 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/sp.css">
        <link rel="stylesheet" href="css/main.css">
        <style>
            #tong {
                color: red;
                font-size: 2em;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <header></header>
                <jsp:include page="navbar.jsp"/>
            <article>
                <h2>Your Shopping Cart</h2>
                <c:set var="shop" value="${sessionScope.SHOP}" />
                <c:if test="${not empty shop}">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Xóa</th>
                                <th>No.</th>
                                <th>Tên sp</th>
                                <th>Hình</th>
                                <th>Danh Mục</th>
                                <th>Số lượng</th>
                                <th>Đơn giá</th>
                            </tr>
                        </thead>
                        <tbody>
                        <form action="CartController">
                            <c:set var="count" value="0" />
                            <c:set var = "sum" value="0" />
                            <c:forEach var="rows" items="${shop}">
                                <c:set var="count" value="${count + 1}" />
                                <tr>    
                                    <td><input type="checkbox" name="rmv" value="${rows.value.sanpham.masp}" /></td>
                                    <td>${count}</td>
                                    <td>${rows.value.sanpham.tensp}</td>
                                    <td><img height="100px" width="100px" src="images/${rows.value.sanpham.hinh}"/></td>                           
                                    <td>${rows.value.sanpham.getDanhMuc()}</td>                        
                                    <td>
                                        <a class="btn btn-default" href="CartController?action=Tru&id=${rows.value.sanpham.masp}">-</a>
                                        ${rows.value.quantity}
                                        <a class="btn btn-default" href="CartController?action=Cong&id=${rows.value.sanpham.masp}">+</a>
                                    </td>
                                    <td>${rows.value.sanpham.dongia}</td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <c:url var="add" value="CartController">
                                    <c:param name="action" value="AddMore" />
                                </c:url>
                            <div>
                                <td></td>
                                <td><a href="CartController?action=xoatatca" class="btn btn-danger">Xóa Giỏ Hàng</a></td>
                                <td><input type="submit" value="Remove" name="action" class="btn btn-danger"/></td>
                                <td colspan ="1"><a href="index.jsp" class="btn btn-primary">Add more</a></td>
                                <td colspan="2"><input type="submit" value="Thanh Toán Giỏ Hàng" class="btn btn-primary" name="action" /></td>
                                <td id="tong">${tongtien}</td>
                            </div>
                            </tr>
                        </form>
                        </tbody>
                    </table>
                </c:if>
            </article>
            <footer>FPT Polytecnich &copy; 2017. All rights reserved.</footer>
        </div>
    </body>

</html>
