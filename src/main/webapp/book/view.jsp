<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 02/08/2024
  Time: 8:18 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Details</title>
</head>
<body>
<h2>Book Details</h2>
<c:if test="${not empty book}">
    <p><strong>Book ID:</strong> ${book.id}</p>
    <p><strong>Name:</strong> ${book.name}</p>
    <p><strong>Description:</strong> ${book.description}</p>
    <p><strong>Image URL:</strong> <img src="${book.imageUrl}" alt="${book.name}" width="100" height="150"/></p>
    <p><strong>Status:</strong> <c:choose>
        <c:when test="${book.status}">Available</c:when>
        <c:otherwise>Unavailable</c:otherwise>
    </c:choose></p>
    <p><strong>Category:</strong> ${book.categoryName}</p>
    <p><strong>Publisher:</strong> ${book.publisherName}</p>
    <p><strong>Created At:</strong> ${book.createdAt}</p>
</c:if>
<c:if test="${empty book}">
    <p>Book not found.</p>
</c:if>
<a href="list.jsp">Back to List</a>
</body>
</html>

