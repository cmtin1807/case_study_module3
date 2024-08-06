<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Borrow Transactions</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="my-4">Search Borrow Transactions</h1>
    <form action="borrows" method="get">
        <input type="hidden" name="action" value="search">
        <div class="form-group">
            <label for="searchQuery">Search</label>
            <input type="text" class="form-control" id="searchQuery" name="searchQuery" placeholder="Enter customer name, book name, or status">
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
    </form>

    <c:if test="${not empty borrows}">
        <h2 class="my-4">Search Results</h2>
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Customer Name</th>
                <th>Customer Code</th>
                <th>Book Name</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="borrow" items="${borrows}">
                <tr>
                    <td>${borrow.id}</td>
                    <td>${borrow.nameCustomer}</td>
                    <td>${borrow.codeCustomer}</td>
                    <td>${borrow.nameBook}</td>
                    <td>${borrow.statusBorrowType}</td>
                    <td>
                        <a href="borrows?action=view&id=${borrow.id}" class="btn btn-info btn-sm">View</a>
                        <a href="borrows?action=delete&id=${borrow.id}" class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
