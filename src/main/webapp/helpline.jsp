<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<!-- Đảm bảo jstl core được sử dụng -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Đảm bảo biểu thức EL được hiển thị -->
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Setting: Help Center</title>
    <%@ include file="all_component/allCss.jsp" %>
  </head>
  <body style="background-color: #f0f1f2">
    <%@ include file="all_component/navbar.jsp" %>
    <div class="container">
      <div class="row p-5">
        <div class="col-md-4 offset-md-4 text-center">
          <div class="text-success">
            <i class="fas fa-phone-square-alt fa-5x"></i>
          </div>
          <h3>24/7 Customer Service</h3>
          <h4>Help Line Number</h4>
          <h5>+01 234 56789</h5>
          <a href="index.jsp" class="btn btn-primary">Back to Home</a>
        </div>
      </div>
    </div>
  </body>
</html>
