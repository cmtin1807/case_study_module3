<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 8/6/2024
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Overdue Borrowings</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            padding-top: 20px;
        }
        .table th, .table td {
            text-align: center;
        }
        .table thead th {
            background-color: #343a40;
            color: white;
        }
        .table tbody tr:nth-child(odd) {
            background-color: #f8f9fa;
        }
        .table tbody tr:hover {
            background-color: #e2e6ea;
        }
        .no-data {
            text-align: center;
            font-style: italic;
            color: #6c757d;
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="mb-4">Overdue Borrowings</h2>
    <div class="card">
        <div class="card-body">
            <table class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>Borrow Transaction ID</th>
                    <th>Customer Name</th>
                    <th>Customer Code</th>
                    <th>Book Name</th>
                    <th>Status Borrow Type</th>
                </tr>
                </thead>
                <tbody>
                <!-- Sử dụng JSTL để lặp qua danh sách giao dịch mượn quá hạn -->
                <c:forEach var="transaction" items="${overdueBorrowings}">
                    <tr>
                        <td>${transaction.id}</td>
                        <td>${transaction.nameCustomer}</td>
                        <td>${transaction.codeCustomer}</td>
                        <td>${transaction.nameBook}</td>
                        <td>${transaction.statusBorrowType}</td>
                    </tr>
                </c:forEach>

                <!-- Hiển thị thông báo nếu không có dữ liệu -->
                <c:if test="${empty overdueBorrowings}">
                    <tr>
                        <td colspan="5" class="no-data">No overdue borrowings found.</td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

