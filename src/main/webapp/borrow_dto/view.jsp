<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Borrow Transaction</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="my-4">View Borrow Transaction</h1>
    <div class="card">
        <div class="card-header">
            Borrow Transaction Details
        </div>
        <div class="card-body">
            <h5 class="card-title">Customer Information</h5>
            <p class="card-text"><strong>Name:</strong> ${borrow.nameCustomer}</p>
            <p class="card-text"><strong>Code:</strong> ${borrow.codeCustomer}</p>
            <p class="card-text"><strong>Class:</strong> ${borrow.classCustomer}</p>
            <p class="card-text"><strong>Address:</strong> ${borrow.address}</p>
            <p class="card-text"><strong>Birth Date:</strong> ${borrow.birthDate}</p>

            <h5 class="card-title">Book Information</h5>
            <p class="card-text"><strong>Name:</strong> ${borrow.nameBook}</p>
            <p class="card-text"><strong>Image:</strong> <img src="${borrow.imageUrl}" alt="${borrow.nameBook}" class="img-thumbnail" style="max-width: 200px;"></p>
            <p class="card-text"><strong>Status:</strong> ${borrow.status ? "New" : "Use"}</p>
            <p class="card-text"><strong>Category:</strong> ${borrow.categoryName}</p>
            <p class="card-text"><strong>Publisher:</strong> ${borrow.publisherName}</p>

            <h5 class="card-title">Transaction Information</h5>
            <p class="card-text"><strong>Borrow Date:</strong> ${borrow.borrowDate}</p>
            <p class="card-text"><strong>Return Date:</strong> ${borrow.returnDate}</p>
            <p class="card-text"><strong>StatusBorrow:</strong> ${borrow.statusBorrowType}</p>

            <a href="borrows?action=list" class="btn btn-primary">Back to List</a>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
