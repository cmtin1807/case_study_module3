<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 8/3/2024
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Borrow Transactions</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Borrow Transactions</h1>
    <a href="<c:url value='/borrows?action=create' />" class="btn btn-primary mb-3">Add New</a>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Customer ID</th>
            <th>Book ID</th>
            <th>Borrow Date</th>
            <th>Return Date</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="transaction" items="${transactions}">
            <tr>
                <td>${transaction.id}</td>
                <td>${transaction.customerId}</td>
                <td>${transaction.bookId}</td>
                <td>${transaction.borrowDate}</td>
                <td>${transaction.returnDate != null ? transaction.returnDate : "Not Returned"}</td>
                <td>
                    <a href="<c:url value='/borrows?action=edit&id=${transaction.id}' />" class="btn btn-warning btn-sm">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

