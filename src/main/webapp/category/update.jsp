<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Category</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>Update Category</h2>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
    </c:if>
    <form action="categories" method="post">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="${category.name}" required>
        </div>
        <input type="hidden" name="id" value="${category.id}">
        <input type="hidden" name="action" value="edit">
        <button type="submit" class="btn btn-primary">Update</button>
        <a href="categories" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>
