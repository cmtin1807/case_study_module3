<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Category List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Category List</h1>
    <a href="categories?action=create" class="btn btn-success mb-3">Add New Category</a>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categories}" var="categorie">
            <tr>
                <td>${categorie.id}</td>
                <td>${categorie.name}</td>
                <td><a href="categories?action=view&id=${categorie.id}" class="btn btn-info btn-sm">View</a></td>
                <td><a href="categories?action=edit&id=${categorie.id}" class="btn btn-primary btn-sm">Edit</a></td>
                <td><a href="categories?action=delete&id=${categorie.id}" class="btn btn-danger btn-sm">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
