<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Edit Customer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <%@ include file="css/styles.css" %>
</head>
<body>
<%@ include file="css/header.jsp" %>
<%@ include file="css/nav.jsp" %>
<div id="container">
    <%@ include file="css/sidebar.jsp" %>
<div class="container mt-5">
    <h1 class="mb-4">Edit Customer Information</h1>
    <form action="<c:url value='/customers' />" method="post">
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="${customer.id}">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${customer.name}" required>
        </div>
        <div class="form-group">
            <label for="codeCustomer">Customer Code</label>
            <input type="text" class="form-control" id="codeCustomer" name="codeCustomer" value="${customer.codeCustomer}" required>
        </div>
        <div class="form-group">
            <label for="classCustomer">Class</label>
            <input type="text" class="form-control" id="classCustomer" name="classCustomer" value="${customer.classCustomer}">
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address" value="${customer.address}">
        </div>
        <div class="form-group">
            <label for="birthDate">Date of Birth</label>
            <input type="date" class="form-control" id="birthDate" name="birthDate" value="${customer.birthDate}">
        </div>
        <div class="form-group">
            <label for="active">Active</label>
            <select class="form-control" id="active" name="active">
                <option value="true" ${customer.active ? 'selected' : ''}>Yes</option>
                <option value="false" ${!customer.active ? 'selected' : ''}>No</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Save Changes</button>
        <a href="<c:url value='/customers'/>" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</div>
<%@ include file="css/footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
