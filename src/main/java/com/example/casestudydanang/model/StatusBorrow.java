package com.example.casestudydanang.model;

public class StatusBorrow {
    private int id;
    private String statusBorrowType;

    public StatusBorrow() {
    }

    public StatusBorrow(int id, String statusBorrowType) {
        this.id = id;
        this.statusBorrowType = statusBorrowType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusBorrowType() {
        return statusBorrowType;
    }

    public void setStatusBorrowType(String statusBorrowType) {
        this.statusBorrowType = statusBorrowType;
    }
}
