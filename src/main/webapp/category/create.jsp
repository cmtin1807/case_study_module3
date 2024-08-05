<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>View Book</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <%@ include file="css/styles.css" %>
</head>
<body>
<%@ include file="css/header.jsp" %>
<%@ include file="css/nav.jsp" %>
<div id="container">
    <%@ include file="css/sidebar.jsp" %>
<div class="container mt-4">
    <h2>Create Category</h2>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
    </c:if>
    <form action="categories" method="post">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <input type="hidden" name="action" value="create">
        <button type="submit" class="btn btn-primary">Create</button>
        <a href="categories" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</div>
<%@ include file="css/footer.jsp" %>
</body>
</html>
