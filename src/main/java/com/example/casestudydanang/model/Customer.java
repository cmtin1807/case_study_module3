package com.example.casestudydanang.model;

public class Customer {
        private int id;
        private String name;
        private String codeCustomer;
        private String classCustomer;
        private String address;
        private java.sql.Date birthDate;
        private Boolean active;
        private Boolean isDeleted;

//    public Customer() {
//    }

    public Customer() {
        // Khởi tạo các thuộc tính mặc định
        this.id = 0; // Mặc định id là 0
        this.name = ""; // Mặc định name là chuỗi rỗng
        this.codeCustomer = ""; // Mặc định codeCustomer là chuỗi rỗng
        this.classCustomer = ""; // Mặc định classCustomer là chuỗi rỗng
        this.address = ""; // Mặc định address là chuỗi rỗng
        this.birthDate = null; // Mặc định birthDate là null (không có ngày sinh)
        this.active = false; // Mặc định active là false (không hoạt động)
        this.isDeleted = false; // Mặc định isDeleted là false (chưa bị xoá)
    }

    public Customer(String name, String codeCustomer, String classCustomer,
                    String address, java.sql.Date birthDate) {
        super();
        this.name = name;
        this.codeCustomer = codeCustomer;
        this.classCustomer = classCustomer;
        this.address = address;
        this.birthDate = birthDate;
    }

    public Customer(String name, String codeCustomer, String classCustomer,
                    String address, java.sql.Date birthDate, Boolean active) {
        super();
        this.name = name;
        this.codeCustomer = codeCustomer;
        this.classCustomer = classCustomer;
        this.address = address;
        this.birthDate = birthDate;
        this.active = active;
    }

    public Customer(int id, String name, String codeCustomer, String classCustomer,
                    String address, java.sql.Date birthDate, Boolean active, Boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.codeCustomer = codeCustomer;
        this.classCustomer = classCustomer;
        this.address = address;
        this.birthDate = birthDate;
        this.active = active;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public java.sql.Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(java.sql.Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getIsDeleted() {
        return isDeleted != null ? isDeleted : false;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", codeCustomer='" + codeCustomer + '\'' +
                ", classCustomer='" + classCustomer + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", active='" + active + '\'' +
                '}';
    }
}
