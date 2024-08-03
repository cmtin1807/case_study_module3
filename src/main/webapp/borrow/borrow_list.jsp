<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 8/3/2024
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Sách Phiếu Mượn</title>
</head>
<body>
<h2>Danh Sách Phiếu Mượn</h2>
<table border="1">
<thead>
<tr>
    <th>ID</th>
    <th>Mã Sinh Viên</th>
    <th>Tên Sinh Viên</th>
    <th>Sách</th>
    <th>Ngày Mượn</th>
    <th>Ngày Trả</th>
    <th>Trạng Thái</th>
</tr>
</thead>
<tbody>
<c:forEach var="transaction" items="${transactions}">
    <tr>
    <td>${transaction.id}</td>
    <td>${transaction.customerId}</td>
    <td>${transaction.customerName}</td
        <td>${transaction.bookName}</td>
        <td>${transaction.borrowDate}</td>
        <td>${transaction.returnDate != null ? transaction.returnDate : "Chưa trả"}</td>
        <td>${transaction.statusBorrowId}</td>
    </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
