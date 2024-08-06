<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Borrow Transaction</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="my-4">Create Borrow Transaction</h1>
    <form action="/borrows?action=edit" method="post">
        <div class="form-group">
            <label for="customerId">Customer:</label>
            <select class="form-control" id="customerId" name="customerId">
                <c:forEach var="customer" items="${customers}">
                    <option value="${customer.id}">
                        <div class="option-container">
                            <span class="option-name">${customer.name}</span>
                            <span class="option-code">${customer.codeCustomer}</span>
                        </div>
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="bookId">Book:</label>
            <select class="form-control" id="bookId" name="bookId">
                <c:forEach var="book" items="${books}">
                    <option value="${book.id}">${book.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="borrowDate">Borrow Date:</label>
            <input type="date" class="form-control" id="borrowDate" name="borrowDate" required>
        </div>
        <div class="form-group">
            <label for="returnDate">Return Date:</label>
            <input type="date" class="form-control" id="returnDate" name="returnDate" required>
        </div>
        <div class="form-group">
            <label for="bookId">Status:</label>
            <select class="form-control" id="status" name="status">
                <c:forEach var="status" items="${books}">
                    <option value="${status.id}">${status.name}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Create Borrow Transaction</button>
    </form>
    <a href="/borrows">Quay lại</a>

</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
