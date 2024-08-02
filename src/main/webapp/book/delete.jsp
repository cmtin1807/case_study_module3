<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 02/08/2024
  Time: 1:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete Book</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-5">Delete Book</h1>
    <div class="alert alert-danger">
        <h4 class="alert-heading">Are you sure you want to delete this book?</h4>
        <p><strong>Name:</strong> ${book.name}</p>
        <p><strong>Description:</strong> ${book.description}</p>
        <p><strong>Image:</strong> <img src="${book.imageUrl}" alt="${book.name}" style="width: 150px; height: 150px;"></p>
        <p><strong>Status:</strong> ${book.status ? "Available" : "Not Available"}</p>
        <p><strong>Category:</strong> ${book.categoryName}</p>
        <p><strong>Publisher:</strong> ${book.publisherName}</p>
    </div>
    <form action="books" method="post">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="id" value="${book.id}">
        <button type="submit" class="btn btn-danger">Delete</button>
        <a href="books" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>

