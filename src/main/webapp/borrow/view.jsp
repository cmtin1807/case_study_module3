<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chi tiết giao dịch mượn sách</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Chi tiết giao dịch mượn sách</h2>
    <table class="table table-bordered">
        <tbody>
        <tr>
            <th>ID</th>
            <td>${transaction.id}</td>
        </tr>
        <tr>
            <th>Tên sinh viên</th>
            <td>${transaction.studentName}</td>
        </tr>
        <tr>
            <th>Mã sinh viên</th>
            <td>${transaction.studentCode}</td>
        </tr>
        <tr>
            <th>Class</th>
            <td>${transaction.studentClass}</td>
        </tr>
        <tr>
            <th>Địa chỉ</th>
            <td>${transaction.studentAddress}</td>
        </tr>
        <tr>
            <th>Ngày sinh</th>
            <td>${transaction.studentBirthDate}</td>
        </tr>
        <tr>
            <th>Tên sách</th>
            <td>${transaction.bookName}</td>
        </tr>
        <tr>
            <th>Hình ảnh sách</th>
            <td><img src="${transaction.bookImageUrl}" alt="Book Image" width="100"/></td>
        </tr>
        <tr>
            <th>Trạng thái sách</th>
            <td>
                <c:choose>
                    <c:when test="${transaction.bookStatus}">Có sẵn</c:when>
                    <c:otherwise>Không có sẵn</c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <th>Danh mục sách</th>
            <td>${transaction.bookCategoryName}</td>
        </tr>
        <tr>
            <th>Nhà xuất bản</th>
            <td>${transaction.bookPublisherName}</td>
        </tr>
        <tr>
            <th>Ngày mượn</th>
            <td>${transaction.borrowDate}</td>
        </tr>
        <tr>
            <th>Ngày trả</th>
            <td>${transaction.returnDate}</td>
        </tr>
        <tr>
            <th>Trạng thái giao dịch</th>
            <td>
                <c:choose>
                    <c:when test="${transaction.statusBorrow == 0}">Chưa trả</c:when>
                    <c:when test="${transaction.statusBorrow == 1}">Đã trả</c:when>
                    <c:otherwise>Quá hạn</c:otherwise>
                </c:choose>
            </td>
        </tr>
        </tbody>
    </table>
    <a href="/borrows" class="btn btn-secondary">Quay lại</a>
</div>
</body>
</html>
