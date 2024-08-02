<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>List of Books</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Book List</h1>
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Image</th>
            <th>Category</th>
            <th>Publisher</th>
            <th>Status</th>
            <th>View</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.description}</td>
                <td><img src="${book.imageUrl}" alt="${book.name}" width="100"></td>
                <td>${book.categoryName}</td>
                <td>${book.publisherName}</td>
                <td>${book.status ? 'New' : 'Old'}</td>
                <td><a href="<c:url value='/books?action=view&id=${book.id}'/>" class="btn btn-primary btn-sm">View</a></td>
                <td>
                    <a href="<c:url value='/books?action=edit&id=${book.id}'/>" class="btn btn-primary btn-sm">Edit</a>
                    <a href="<c:url value='/books?action=delete&id=${book.id}'/>" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value='/books?action=create'/>" class="btn btn-success">Add New Book</a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
