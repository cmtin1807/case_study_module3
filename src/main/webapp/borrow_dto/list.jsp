<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Borrow Transactions</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <%@ include file="css/styles.css" %>
</head>
<body>
<%@ include file="css/header.jsp" %>
<%@ include file="css/nav.jsp" %>
<div id="container">
    <%@ include file="css/sidebar.jsp" %>
<div class="container">
    <h1 class="my-4">List of Borrow Transactions</h1>
    <a href="borrows?action=create" class="btn btn-primary mb-3">Create New Transaction</a>
    <c:if test="${not empty successMessage}">
        <div class="alert alert-success" role="alert">
                ${successMessage}
        </div>
    </c:if>
    <form action="borrows" method="get">
        <input type="hidden" name="action" value="search">
        <div class="form-group">
            <label for="codeCustomer">Mã Khách Hàng:</label>
            <input type="text" id="codeCustomer" name="codeCustomer" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Tìm Kiếm</button>
    </form>
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
                    <a href="borrows?action=edit&id=${borrow.id}" class="btn btn-danger btn-sm">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>
<%@ include file="css/footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
