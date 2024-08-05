<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Category</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <%@ include file="css/styles.css" %>
</head>
<body>
<%@ include file="css/header.jsp" %>
<%@ include file="css/nav.jsp" %>
<div id="container">
    <%@ include file="css/sidebar.jsp" %>
<div class="container mt-4">
    <h2>View Category</h2>
    <div class="form-group">
        <label for="id">ID:</label>
        <input type="text" class="form-control" id="id" value="${category.id}" readonly>
    </div>
    <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" class="form-control" id="name" value="${category.name}" readonly>
    </div>
    <a href="categories" class="btn btn-secondary">Back to List</a>
</div>
</div>
<%@ include file="css/footer.jsp" %>
</body>
</html>
