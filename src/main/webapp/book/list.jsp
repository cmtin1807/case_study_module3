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
    <form method="get" action="books">
        <input type="hidden" name="action" value="searchCategory">
        <div class="form-group">
            <label for="searchCategoryName">Search by Category:</label>
            <select name="searchCategoryName" id="searchCategoryName" class="form-control">
                <option value="">Select a category</option>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.name}">${category.name}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
    </form>

    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
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

    <div class="pagination">
        <ul class="pagination">
            <c:if test="${currentPage > 1}">
                <li class="page-item">
                    <a class="page-link" href="<c:url value='/books?page=${currentPage - 1}'/>" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>
            <c:forEach var="i" begin="1" end="${totalPages}">
                <li class="page-item <c:if test="${i == currentPage}">active</c:if>">
                    <a class="page-link" href="<c:url value='/books?page=${i}'/>">${i}</a>
                </li>
            </c:forEach>
            <c:if test="${currentPage < totalPages}">
                <li class="page-item">
                    <a class="page-link" href="<c:url value='/books?page=${currentPage + 1}'/>" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </div>

    <a href="<c:url value='/books?action=create'/>" class="btn btn-success">Add New Book</a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
