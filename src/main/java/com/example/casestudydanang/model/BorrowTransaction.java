package com.example.casestudydanang.model;

import java.sql.Date;

public class BorrowTransaction {
    private int id;
    private int customerId;
    private int bookId;
    private Date borrowDate;
    private Date returnDate;
    private int statusBorrowId;

    // Constructor không tham số
    public BorrowTransaction() {
    }

    // Constructor với tất cả các tham số
    public BorrowTransaction(int id, int customerId, int bookId, Date borrowDate, Date returnDate, int statusBorrowId) {
        this.id = id;
        this.customerId = customerId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.statusBorrowId = statusBorrowId;
    }

    // Constructor không có ID (được tạo tự động)
    public BorrowTransaction(int customerId, int bookId, Date borrowDate, Date returnDate, int statusBorrowId) {
        this.customerId = customerId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.statusBorrowId = statusBorrowId;
    }

    // Getter và Setter cho id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter và Setter cho customerId
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    // Getter và Setter cho bookId
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    // Getter và Setter cho borrowDate
    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    // Getter và Setter cho returnDate
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    // Getter và Setter cho statusBorrowId
    public int getStatusBorrowId() {
        return statusBorrowId;
    }

    public void setStatusBorrowId(int statusBorrowId) {
        this.statusBorrowId = statusBorrowId;
    }

    @Override
    public String toString() {
        return "BorrowTransaction{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", bookId=" + bookId +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", statusBorrowId=" + statusBorrowId +
                '}';
    }
}
