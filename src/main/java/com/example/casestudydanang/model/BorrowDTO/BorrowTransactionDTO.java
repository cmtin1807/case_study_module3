package com.example.casestudydanang.model.BorrowDTO;


import com.example.casestudydanang.model.Book;
import com.example.casestudydanang.model.Category;
import com.example.casestudydanang.model.Customer;
import com.example.casestudydanang.model.Publisher;

import java.sql.Date;
import java.util.List;

public class BorrowTransactionDTO {
    private int id;
    private int customerId;
    private String nameCustomer;
    private String codeCustomer;
    private String classCustomer;
    private String address;
    private java.sql.Date birthDate;
    private int bookId;
    private String nameBook;
    private String imageUrl;
    private boolean status;
    private String categoryName;
    private String publisherName;
    private java.sql.Date borrowDate;
    private java.sql.Date returnDate;
    private int statusBorrowId;
    private String statusBorrowType;

    public BorrowTransactionDTO() {
    }

    public BorrowTransactionDTO(int id, String nameCustomer, String codeCustomer, String nameBook,
                                String statusBorrowType) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.codeCustomer = codeCustomer;
        this.nameBook = nameBook;
        this.statusBorrowType = statusBorrowType;
    }

    public BorrowTransactionDTO(String nameCustomer, String codeCustomer, String classCustomer,
                                String address, Date birthDate, String nameBook, String imageUrl, boolean status,
                                String categoryName, String publisherName, Date borrowDate, Date returnDate,
                                String statusBorrowType) {
        this.nameCustomer = nameCustomer;
        this.codeCustomer = codeCustomer;
        this.classCustomer = classCustomer;
        this.address = address;
        this.birthDate = birthDate;
        this.nameBook = nameBook;
        this.imageUrl = imageUrl;
        this.status = status;
        this.categoryName = categoryName;
        this.publisherName = publisherName;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.statusBorrowType = statusBorrowType;
    }

    public BorrowTransactionDTO(int id, String nameCustomer, String codeCustomer, String classCustomer, String address, java.util.Date birthDate, String nameBook, String imageUrl, boolean status, String categoryName, String publisherName, java.util.Date borrowDate, java.util.Date returnDate, String statusBorrowType) {
            this.id = id;
            this.nameCustomer = nameCustomer;
            this.codeCustomer = codeCustomer;
            this.classCustomer = classCustomer;
            this.address = address;
            this.birthDate = (Date) birthDate;
            this.nameBook = nameBook;
            this.imageUrl = imageUrl;
            this.status = status;
            this.categoryName = categoryName;
            this.publisherName = publisherName;
            this.borrowDate = (Date) borrowDate;
            this.returnDate = (Date) returnDate;
            this.statusBorrowType = statusBorrowType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getClassCustomer() {
        return classCustomer;
    }

    public void setClassCustomer(String classCustomer) {
        this.classCustomer = classCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
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

    public String getStatusBorrowType() {
        return statusBorrowType;
    }

    public void setStatusBorrowType(String statusBorrowType) {
        this.statusBorrowType = statusBorrowType;
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

    public int getStatusBorrowId() {
        return statusBorrowId;
    }

    public void setStatusBorrowId(int statusBorrowId) {
        this.statusBorrowId = statusBorrowId;
    }

    @Override
    public String toString() {
        return "BorrowTransactionDTO{" +
                "id=" + id +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", codeCustomer='" + codeCustomer + '\'' +
                ", classCustomer='" + classCustomer + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", nameBook='" + nameBook + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", status=" + status +
                ", categoryName='" + categoryName + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", statusBorrowType='" + statusBorrowType + '\'' +
                '}';
    }
}

