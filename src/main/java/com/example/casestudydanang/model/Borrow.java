package com.example.casestudydanang.model;

import java.sql.Date;

public class Borrow {
    private int id;
    private int customerId;
    private int bookId;
    private java.sql.Date borrowDate;
    private java.sql.Date returnDate;
    private int statusBorrowId;

    public Borrow() {
    }

    public Borrow(int id, int customerId, int bookId, java.sql.Date borrowDate, java.sql.Date returnDate, int statusBorrowId) {
        this.id = id;
        this.customerId = customerId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.statusBorrowId = statusBorrowId;
    }

    public Borrow(int customerId, int bookId, java.sql.Date borrowDate, java.sql.Date returnDate, int statusBorrowId) {
        this.customerId = customerId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.statusBorrowId = statusBorrowId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getStatusBorrowId() {
        return statusBorrowId;
    }

    public void setStatusBorrowId(int statusBorrowId) {
        this.statusBorrowId = statusBorrowId;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", bookId=" + bookId +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", statusBorrowId=" + statusBorrowId +
                '}';
    }
}
