<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 8/3/2024
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Phiếu Mượn Sách</title>
</head>
<body>
<h2>Phiếu Mượn Sách</h2>
<form action="/borrow" method="post">
    <input type="hidden" name="action" value="borrow">

    <label for="customerId">Mã Sinh Viên:</label>
    <select id="customerId" name="customerId">
        <c:forEach var="customer" items="${customers}">
            <option value="${customer.id}">${customer.name}</option>
        </c:forEach>
    </select><br><br>

    <label for="bookId">Sách Mượn:</label>
    <select id="bookId" name="bookId">
        <c:forEach var="book" items="${books}">
            <option value="${book.id}">${book.name}</option>
        </c:forEach>
    </select><br><br>

    <input type="submit" value="Mượn Sách">
</form>
<p>Ngày mượn: ${currentDate}</p>
</body>
</html>

