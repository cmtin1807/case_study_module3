<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm giao dịch mượn sách</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Thêm giao dịch mượn sách</h2>
    <form action="/borrows" method="post">
        <input type="hidden" name="action" value="create"/>
        <div class="form-group">
            <label for="studentName">Tên sinh viên</label>
            <input type="text" class="form-control" id="studentName" name="studentName" required/>
        </div>
        <div class="form-group">
            <label for="studentCode">Mã sinh viên</label>
            <input type="text" class="form-control" id="studentCode" name="studentCode" required/>
        </div>
        <div class="form-group">
            <label for="studentClass">Class</label>
            <input type="text" class="form-control" id="studentClass" name="studentClass"/>
        </div>
        <div class="form-group">
            <label for="studentAddress">Địa chỉ</label>
            <input type="text" class="form-control" id="studentAddress" name="studentAddress"/>
        </div>
        <div class="form-group">
            <label for="studentBirthDate">Ngày sinh</label>
            <input type="date" class="form-control" id="studentBirthDate" name="studentBirthDate"/>
        </div>
        <div class="form-group">
            <label for="bookName">Tên sách</label>
            <input type="text" class="form-control" id="bookName" name="bookName" required/>
        </div>
        <div class="form-group">
            <label for="bookImageUrl">Hình ảnh sách</label>
            <input type="text" class="form-control" id="bookImageUrl" name="bookImageUrl"/>
        </div>
        <div class="form-group">
            <label for="bookStatus">Trạng thái sách</label>
            <select class="form-control" id="bookStatus" name="bookStatus">
                <option value="true">Có sẵn</option>
                <option value="false">Không có sẵn</option>
            </select>
        </div>
        <div class="form-group">
            <label for="bookCategoryName">Danh mục sách</label>
            <input type="text" class="form-control" id="bookCategoryName" name="bookCategoryName"/>
        </div>
        <div class="form-group">
            <label for="bookPublisherName">Nhà xuất bản</label>
            <input type="text" class="form-control" id="bookPublisherName" name="bookPublisherName"/>
        </div>
        <div class="form-group">
            <label for="borrowDate">Ngày mượn</label>
            <input type="date" class="form-control" id="borrowDate" name="borrowDate" required/>
        </div>
        <div class="form-group">
            <label for="returnDate">Ngày trả</label>
            <input type="date" class="form-control" id="returnDate" name="returnDate"/>
        </div>
        <div class="form-group">
            <label for="statusBorrow">Trạng thái giao dịch</label>
            <select class="form-control" id="statusBorrow" name="statusBorrow">
                <option value="0">Chưa trả</option>
                <option value="1">Đã trả</option>
                <option value="2">Quá hạn</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Tạo mới</button>
        <a href="/borrows" class="btn btn-secondary">Quay lại</a>
    </form>
</div>
</body>
</html>
