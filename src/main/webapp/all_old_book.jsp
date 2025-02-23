<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!-- Đảm bảo jstl core được sử dụng -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.DAO.BookDAOImpl" %>
<%@ page import="com.entity.BookDtls" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.DB.DBConnect" %>
<%@ page import="com.entity.User" %>
<!-- Đảm bảo biểu thức EL được hiển thị -->
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1" />
    <title>All Old Book</title>
    <%@include file="all_component/allCss.jsp" %>
    <style type="text/css">
        .back-img {
            background: url('img/b.jpg');
            height: 50vh;
            width: 100%;
            background-repeat: no-repeat;
            background-size: cover;
        }

        .crd-ho:hover {
            background-color: #fcf7f7;
        }
    </style>
</head>

<body>
    <%@include file="all_component/navbar.jsp" %>
    <div class="container-fluid">
        <div class="row p-4">
            <% 
                BookDAOImpl dao3 = new BookDAOImpl(DBConnect.getConn());
                List<BookDtls> list3 = dao3.getAllOldBook();
                for (BookDtls b : list3) {
            %>
            <div class="col-md-3">
                <div class="card crd-ho mt-2">
                    <div class="card-body text-center">
                        <img alt="" src="book/<%=b.getPhotoName()%>" style="width: 100px; height: 150px" class="img-thumblin">
                        <p><%= b.getBookName() %></p>
                        <p><%= b.getAuthor() %></p>
                        <p>Categories: <%= b.getBookCategory() %></p>
                        <div class="row">
                            <a href="view_books.jsp?bid=<%=b.getBookId()%>" class="btn btn-success btn-sm ml-5">View Details</a>
                            <a href="" class="btn btn-danger btn-sm ml-1"><%= b.getPrice() %><i class="fas fa-euro-sign"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
    </div>
    <%@include file="all_component/footer.jsp" %>
</body>
</html>