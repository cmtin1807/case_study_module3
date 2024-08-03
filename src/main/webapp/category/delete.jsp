<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Category</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>Delete Category</h2>
    <form action="categories" method="post">
        <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" class="form-control" id="id" value="${category.id}" readonly>
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" value="${category.name}" readonly>
        </div>
        <input type="hidden" name="id" value="${category.id}">
        <input type="hidden" name="action" value="delete">
        <button type="submit" class="btn btn-danger">Delete</button>
        <a href="categories" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>
