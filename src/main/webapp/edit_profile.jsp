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
    <title>Setting: Edit Profile Page</title>
    <%@ include file="all_component/allCss.jsp" %>
  </head>
  <body style="background-color: #f0f1f2">
    <%@ include file="all_component/navbar.jsp" %>

    <div class="container">
      <div class="row">
        <div class="col-md-4 offset-md-4">
          <div class="card">
            <div class="card-body">

                <h4 class="text-center text-primary p-1">Edit Profile</h4>

                <c:if test="${not empty failedMsg}">
                  <h5 class="text-center text-danger">${failedMsg}</h5>
                  <c:remove var="failedMsg" scope="session" />
                </c:if>

                <c:if test="${not empty succMsg}">
                  <h5 class="text-center text-success">${succMsg}</h5>
                  <c:remove var="succMsg" scope="session" />
                </c:if>

              <form action="update_profile" method="post">
              <input type="hidden" name="id" value="${userobj.id}"/>
                <!-- FULL NAME -->
                <div class="form-group">
                  <label for="exampleInputEmail1">Enter Full Name</label>
                  <input
                    type="text"
                    class="form-control"
                    id="exampleInputEmail1"
                    aria-describedby="emailHelp"
                    required="required"
                    name="fname"
                    value="${userobj.name}"
                  />
                </div>

                <!-- EMAIL -->
                <div class="form-group">
                  <label for="exampleInputEmail1">Email address</label>
                  <input
                    type="email"
                    class="form-control"
                    id="exampleInputEmail1"
                    aria-describedby="emailHelp"
                    required="required"
                    name="email"
                    value="${userobj.email}"
                  />
                </div>

                <!-- PHONE NUMBER -->
                <div class="form-group">
                  <label for="exampleInputEmail1">Phone number</label>
                  <input
                    type="number"
                    class="form-control"
                    id="exampleInputEmail1"
                    aria-describedby="emailHelp"
                    required="required"
                    name="phno"
                    value="${userobj.phno}"
                  />
                </div>

                <!-- PASSWORD -->
                <div class="form-group">
                  <label for="exampleInputPassword1">Password</label>
                  <input
                    type="password"
                    class="form-control"
                    id="exampleInputPassword1"
                    required="required"
                    name="password"
                  />
                </div>

                <button type="submit" class="btn btn-primary">Update</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
