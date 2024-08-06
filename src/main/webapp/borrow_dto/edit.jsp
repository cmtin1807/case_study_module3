<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cập nhật giao dịch mượn sách</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Cập nhật giao dịch mượn sách</h2>
    <form action="/borrows" method="post">
        <input type="hidden" name="action" value="edit"/>
        <input type="hidden" name="id" value="${transaction.id}"/>
        <div class="form-group">
            <label for="studentName">Tên sinh viên</label>
            <input type="text" class="form-control" id="studentName" name="studentName" value="${transaction.studentName}" required/>
        </div>
        <div class="form-group">
            <label for="studentCode">Mã sinh viên</label>
            <input type="text" class="form-control" id="studentCode" name="studentCode" value="${transaction.studentCode}" required/>
        </div>
        <div class="form-group">
            <label for="studentClass">Class</label>
            <input type="text" class="form-control" id="studentClass" name="studentClass" value="${transaction.studentClass}"/>
        </div>
        <div class="form-group">
            <label for="studentAddress">Địa chỉ</label>
            <input type="text" class="form-control" id="studentAddress" name="studentAddress" value="${transaction.studentAddress}"/>
        </div>
        <div class="form-group">
            <label for="studentBirthDate">Ngày sinh</label>
            <input type="date" class="form-control" id="studentBirthDate" name="studentBirthDate" value="${transaction.studentBirthDate}"/>
        </div>
        <div class="form-group">
            <label for="bookName">Tên sách</label>
            <input type="text" class="form-control" id="bookName" name="bookName" value="${transaction.bookName}" required/>
        </div>
        <div class="form-group">
            <label for="bookImageUrl">Hình ảnh sách</label>
            <input type="text" class="form-control" id="bookImageUrl" name="bookImageUrl" value="${transaction.bookImageUrl}"/>
        </div>
        <div class="form-group">
            <label for="bookStatus">Trạng thái sách</label>
            <select class="form-control" id="bookStatus" name="bookStatus">
                <option value="true" <c:if test="${transaction.bookStatus}">selected</c:if>>Có sẵn</option>
                <option value="false" <c:if test="${!transaction.bookStatus}">selected</c:if>>Không có sẵn</option>
            </select>
        </div>
        <div class="form-group">
            <label for="bookCategoryName">Danh mục sách</label>
            <input type="text" class="form-control" id="bookCategoryName" name="bookCategoryName" value="${transaction.bookCategoryName}"/>
        </div>
        <div class="form-group">
            <label for="bookPublisherName">Nhà xuất bản</label>
            <input type="text" class="form-control" id="bookPublisherName" name="bookPublisherName" value="${transaction.bookPublisherName}"/>
        </div>
        <div class="form-group">
            <label for="borrowDate">Ngày mượn</label>
            <input type="date" class="form-control" id="borrowDate" name="borrowDate" value="${transaction.borrowDate}" required/>
        </div>
        <div class="form-group">
            <label for="returnDate">Ngày trả</label>
            <input type="date" class="form-control" id="returnDate" name="returnDate" value="${transaction.returnDate}"/>
        </div>
        <div class="form-group">
            <label for="statusBorrow">Trạng thái giao dịch</label>
            <select class="form-control" id="statusBorrow" name="statusBorrow">
                <option value="0" <c:if test="${transaction.statusBorrow == 0}">selected</c:if>>Chưa trả</option>
                <option value="1" <c:if test="${transaction.statusBorrow == 1}">selected</c:if>>Đã trả</option>
                <option value="2" <c:if test="${transaction.statusBorrow == 2}">selected</c:if>>Quá hạn</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Cập nhật</button>
        <a href="/borrows" class="btn btn-secondary">Quay lại</a>
    </form>
</div>
</body>
</html>
