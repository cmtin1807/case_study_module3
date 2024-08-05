<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Borrow Transactions</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="mt-5">List of Borrow Transactions</h2>
    <table class="table table-bordered mt-3">
        <thead>
        <tr>
            <th>ID</th>
            <th>Customer Name</th>
            <th>Customer Code</th>
            <th>Book Name</th>
            <th>Status</th>
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
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
