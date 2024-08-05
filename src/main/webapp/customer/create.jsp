<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 8/2/2024
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Create Customer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Create New Customer</h1>
    <form action="<c:url value='/customers' />" method="post">
        <input type="hidden" name="action" value="create">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="codeCustomer">Code</label>
            <input type="text" class="form-control" id="codeCustomer" name="codeCustomer" required>
        </div>
        <div class="form-group">
            <label for="classCustomer">Class</label>
            <input type="text" class="form-control" id="classCustomer" name="classCustomer">
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address">
        </div>
        <div class="form-group">
            <label for="birthDate">Birthday</label>
            <input type="date" class="form-control" id="birthDate" name="birthDate">
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
        <a href="<c:url value='/customers'/>" class="btn btn-secondary">Cancel</a>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


</body>
</html>
