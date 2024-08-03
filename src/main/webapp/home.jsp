<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 03/08/2024
  Time: 6:43 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Welcome to the Book Management System</h1>

    <c:choose>
        <c:when test="${role == 'admin'}">
            <div class="alert alert-info">
                <h4 class="alert-heading">Hello Admin!</h4>
                <p>Welcome back, <%= user.getUsername() %>. You can manage the book categories and other admin functionalities from the menu below.</p>
                <a href="categoryList" class="btn btn-primary">Manage Categories</a>
                <a href="bookList" class="btn btn-secondary">View Books</a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="alert alert-info">
                <h4 class="alert-heading">Hello Customer!</h4>
                <p>Welcome back, <%= user.getUsername() %>. Browse through our collection of books and manage your profile.</p>
                <a href="bookList" class="btn btn-primary">Browse Books</a>
                <a href="profile" class="btn btn-secondary">My Profile</a>
            </div>
        </c:otherwise>
    </c:choose>

</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

