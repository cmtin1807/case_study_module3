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
<div class="container mt-5">
    <h2 class="mb-4">Book Details</h2>

    <c:if test="${not empty book}">
        <div class="card">
            <div class="card-header">
                <h4>${book.name}</h4>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-md-4">
                        <img src="${book.imageUrl}" class="img-fluid" alt="${book.name}">
                    </div>
                    <div class="col-md-8">
                        <h5>Description:</h5>
                        <p>${book.description}</p>
                        <p><strong>Category:</strong> ${book.categoryName}</p>
                        <p><strong>Publisher:</strong> ${book.publisherName}</p>
                        <p><strong>Status:</strong> ${book.status ? 'New' : 'Old'}</p>
                        <p><strong>Created At:</strong> ${book.createdAt}</p>
                    </div>
                </div>
            </div>
            <div class="card-footer">
                <a href="books" class="btn btn-primary">Back to List</a>
            </div>
        </div>
    </c:if>

</div>
</div>
<%@ include file="css/footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>