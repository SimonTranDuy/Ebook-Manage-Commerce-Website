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
    <title>All New Book</title>
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

        /* SNACK BAR TOAST */
        #toast {
            min-width: 300px;
            position: fixed;
            bottom: 30px;
            left: 50%;
            margin-left: -125px;
            background: #333;
            padding: 10px;
            color: white;
            text-align: center;
            z-index: 1;
            font-size: 18px;
            visibility: hidden;
            box-shadow: 0px 0px 100px #000;
        }

        #toast.display {
            visibility: visible;
            animation: fadeIn 0.5s, fadeOut 0.5s 2.5s;
        }

        @-webkit-keyframes fadeIn {
            from {
                bottom: 0;
                opacity: 0;
            }

            to {
                bottom: 30px;
                opacity: 1;
            }
        }

        @keyframes fadeIn {
            from {
                bottom: 0;
                opacity: 0;
            }

            to {
                bottom: 30px;
                opacity: 1;
            }
        }

        @-webkit-keyframes fadeOut {
            from {
                bottom: 30px;
                opacity: 1;
            }

            to {
                bottom: 0;
                opacity: 0;
            }
        }

        @keyframes fadeOut {
            from {
                bottom: 30px;
                opacity: 1;
            }

            to {
                bottom: 0;
                opacity: 0;
            }
        }
    </style>
</head>

<body>
    <c:if test="${not empty addCart}">
        <div id="toast">${addCart}</div>
        <script type="text/javascript">
            showToast();
            function showToast(content) {
                $('#toast').addClass('display');
                $('#toast').html(content);
                setTimeout(() => {
                    $('#toast').removeClass('display');
                }, 2000);
            }
        </script>
        <c:remove var="addCart" scope="session" />
    </c:if>
    <%@include file="all_component/navbar.jsp" %>
    <% User u = (User)session.getAttribute("userobj"); %>
    <div class="container-fluid">
        <div class="row p-4">
            <% 
                BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
                List<BookDtls> list = dao.getAllNewBook();
                for (BookDtls b : list) {
            %>
            <div class="col-md-3">
                <div class="card crd-ho mt-2">
                    <div class="card-body text-center">
                        <img alt="" src="book/<%=b.getPhotoName()%>" style="width: 100px; height: 150px" class="img-thumblin">
                        <p><%= b.getBookName() %></p>
                        <p><%= b.getAuthor() %></p>
                        <p>Categories: <%= b.getBookCategory() %></p>
                        <div class="row">
                            <% if (u==null) { %>
                            <a href="login.jsp" class="btn btn-danger btn-sm ml-2"><i class="fas fa-cart-plus"></i> Add Cart</a>
                            <% } else { %>
                            <a href="cart?bid=<%=b.getBookId()%>&&uid=<%=u.getId()%>" class="btn btn-danger btn-sm ml-2"><i class="fas fa-cart-plus"></i> Add Cart</a>
                            <% } %>
                            <a href="view_books.jsp?bid=<%=b.getBookId()%>" class="btn btn-success btn-sm ml-1">View Details</a>
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