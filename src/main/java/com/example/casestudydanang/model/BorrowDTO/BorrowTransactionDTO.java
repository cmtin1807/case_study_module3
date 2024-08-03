package com.example.casestudydanang.model.BorrowDTO;


import java.sql.Date;

public class BorrowTransactionDTO {
    private int id;
    private String studentId; // Mã sinh viên
    private String studentName; // Tên sinh viên
    private int bookId; // ID sách
    private String bookTitle; // Tên sách
    private Date borrowDate; // Ngày mượn
    private Date returnDate; // Ngày trả
    private String statusBorrow; // Trạng thái phiếu mượn

    // Constructor
    public BorrowTransactionDTO() {}

    public BorrowTransactionDTO(int id, String studentId, String studentName, int bookId, String bookTitle, Date borrowDate, Date returnDate, String statusBorrow) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.statusBorrow = statusBorrow;
    }

    // Getters and Setters
    // ...

    @Override
    public String toString() {
        return "BorrowTransactionDTO{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", statusBorrow='" + statusBorrow + '\'' +
                '}';
    }
}

