<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Customer List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <%@ include file="css/styles.css" %>
</head>
<body>
<%@ include file="css/header.jsp" %>
<%@ include file="css/nav.jsp" %>
<div id="container">
    <%@ include file="css/sidebar.jsp" %>
<div class="container mt-5">
    <h1 class="mb-4">Customer List</h1>
    <a href="<c:url value='/customers?action=create'/>" class="btn btn-success">Add New Customer</a>

    <!-- Hiển thị thông báo nếu có -->
    <c:if test="${not empty message}">
        <div class="alert alert-info" role="alert">
                ${message}
        </div>
    </c:if>

    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Code</th>
            <th>Class</th>
            <th>Address</th>
            <th>Birthday</th>
            <th>Active</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.codeCustomer}</td>
                <td>${customer.classCustomer}</td>
                <td>${customer.address}</td>
                <td>${customer.birthDate}</td>
                <td><c:out value="${customer.active ? 'Yes' : 'No'}"/></td>
                <td>
                    <a href="<c:url value='/customers?action=edit&id=${customer.id}'/>" class="btn btn-secondary btn-sm">Edit</a>
                    <c:if test="${customer.isDeleted == false}">
                        <a href="<c:url value='/customers?action=delete&id=${customer.id}'/>" class="btn btn-danger btn-sm">Delete</a>
                    </c:if>
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
