<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Overdue Borrowings</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <%@ include file="css/styles.css" %>
    <style>
        #container {
            display: flex;
            min-height: 100vh;
        }
        #sidebar {
            width: 250px;
            background-color: #f8f9fa;
            padding: 15px;
        }
        main {
            flex-grow: 1;
            padding: 20px;
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<%@ include file="css/header.jsp" %>
<%@ include file="css/nav.jsp" %>

<div id="container">
    <%@ include file="css/sidebar.jsp" %>

    <main>
        <h2 class="mb-4">Overdue Borrowings</h2>
        <a href="/borrows">Quay lại</a>
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
                    <c:forEach var="transaction" items="${overdueBorrowings}">
                        <tr>
                            <td>${transaction.id}</td>
                            <td>${transaction.nameCustomer}</td>
                            <td>${transaction.codeCustomer}</td>
                            <td>${transaction.nameBook}</td>
                            <td>${transaction.statusBorrowType}</td>
                        </tr>
                    </c:forEach>

                    <c:if test="${empty overdueBorrowings}">
                        <tr>
                            <td colspan="5" class="no-data">No overdue borrowings found.</td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </main>
</div>

<%@ include file="css/footer.jsp" %>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
