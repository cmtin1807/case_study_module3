<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 8/3/2024
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Edit Borrow Transaction</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Edit Borrow Transaction</h1>
    <form action="<c:url value='/borrows' />" method="post">
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="${transaction.id}">
        <div class="form-group">
            <label for="customerId">Customer ID</label>
            <select id="customerId" name="customerId" class="form-control" required>
                <c:forEach var="customer" items="${customers}">
                    <option value="${customer.customerId}" ${customer.customerId == transaction.customerId ? "selected" : ""}>
                            ${customer.name}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="bookId">Book ID</label>
            <select id="bookId" name="bookId" class="form-control" required>
                <!-- Thay thế bằng danh sách sách -->
                <c:forEach var="book" items="${books}">
                    <option value="${book.bookId}" ${book.bookId == transaction.bookId ? "selected" : ""}>
                            ${book.title}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="borrowDate">Borrow Date</label>
            <input type="date" id="borrowDate" name="borrowDate" class="form-control" value="${transaction.borrowDate}" required>
        </div>
        <div class="form-group">
            <label for="returnDate">Return Date</label>
            <input type="date" id="returnDate" name="returnDate" class="form-control" value="${transaction.returnDate}">
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
        <a href="<c:url value='/borrows' />" class="btn btn-secondary">Cancel</a>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

