<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 8/3/2024
  Time: 8:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Edit Customer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1>Edit Customer</h1>
    <form action="customers?action=edit" method="post">
        <input type="hidden" name="id" value="${customer.id}">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="${customer.name}" required>
        </div>
        <div class="form-group">
            <label for="codeCustomer">Code:</label>
            <input type="text" class="form-control" id="codeCustomer" name="codeCustomer" value="${customer.codeCustomer}" required>
        </div>
        <div class="form-group">
            <label for="classCustomer">Class:</label>
            <input type="text" class="form-control" id="classCustomer" name="classCustomer" value="${customer.classCustomer}" required>
        </div>
        <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" class="form-control" id="address" name="address" value="${customer.address}" required>
        </div>
        <div class="form-group">
            <label for="birthDate">Birthday:</label>
            <input type="date" class="form-control" id="birthDate" name="birthDate" value="${customer.birthDate}">
        </div>
        <div class="form-group">
            <label for="active">Active:</label>
            <select class="form-control" id="active" name="active">
                <option value="true" ${customer.active ? 'selected' : ''}>Yes</option>
                <option value="false" ${!customer.active ? 'selected' : ''}>No</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
        <a href="customers" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>

