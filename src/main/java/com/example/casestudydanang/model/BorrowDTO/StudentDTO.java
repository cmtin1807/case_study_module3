package com.example.casestudydanang.model.BorrowDTO;


public class StudentDTO {
    private String studentId; // Mã sinh viên
    private String name; // Tên sinh viên
    private String email; // Email sinh viên
    private String phoneNumber; // Số điện thoại sinh viên

    // Constructor
    public StudentDTO() {}

    public StudentDTO(String studentId, String name, String email, String phoneNumber) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    // ...

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

