<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Borrow Transaction</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <%@ include file="css/styles.css" %>
</head>
<body>
<%@ include file="css/header.jsp" %>
<%@ include file="css/nav.jsp" %>
<div id="container">
    <%@ include file="css/sidebar.jsp" %>
<div class="container">
    <h1 class="my-4">Edit Borrow Transaction</h1>
    <c:if test="${not empty errorMessage or not empty successMessage}">
        <div class="alert ${not empty successMessage ? 'alert-success' : 'alert-danger'}" role="alert">
                ${not empty successMessage ? successMessage : errorMessage}
        </div>
    </c:if>
    <form action="/borrows?action=edit" method="post">
        <!-- Hidden field to store the id of the transaction being edited -->
        <input type="hidden" name="id" value="${borrow.id}" />

        <div class="form-group">
            <label for="customerId">Customer:</label>
            <select class="form-control" id="customerId" name="customerId">
                <c:forEach var="customer" items="${customers}">
                    <option value="${customer.id}" ${customer.id == borrow.customerId ? 'selected' : ''}>
                            ${customer.name} (${customer.codeCustomer})
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="bookId">Book:</label>
            <select class="form-control" id="bookId" name="bookId">
                <c:forEach var="book" items="${books}">
                    <option value="${book.id}" ${book.id == borrow.bookId ? 'selected' : ''}>${book.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="borrowDate">Borrow Date:</label>
            <input type="date" class="form-control" id="borrowDate" name="borrowDate"
                   value="${borrow.borrowDate != null ? borrow.borrowDate : ''}" required>
        </div>
        <div class="form-group">
            <label for="returnDate">Return Date:</label>
            <input type="date" class="form-control" id="returnDate" name="returnDate"
                   value="${borrow.returnDate != null ? borrow.returnDate : ''}" required>
        </div>
        <div class="form-group">
            <label for="statusBorrowId">Status:</label>
            <select class="form-control" id="statusBorrowId" name="statusBorrowId">
                <c:forEach var="status" items="${status}">
                    <option value="${status.id}" ${status.id == borrow.statusBorrowId ? 'selected' : ''}>
                            ${status.statusBorrowType}
                    </option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Cập nhật</button>
    </form>
    <a href="/borrows">Quay lại</a>
</div>
</div>
<%@ include file="css/footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
