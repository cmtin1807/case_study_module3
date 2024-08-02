package com.example.casestudydanang.model;

import java.sql.Timestamp;

public class Book {
    private int id;
    private String name;
    private String description;
    private String imageUrl;
    private boolean status;
    private int categoryId;
    private int publisherId;
    private java.sql.Timestamp createdAt;
    private String categoryName;
    private String publisherName;

    public Book() {}

    public Book(int id, String name, String description, String imageUrl, boolean status, int categoryId, int publisherId, Timestamp createdAt, String categoryName, String publisherName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.status = status;
        this.categoryId = categoryId;
        this.publisherId = publisherId;
        this.createdAt = createdAt;
        this.categoryName = categoryName;
        this.publisherName = publisherName;
    }

    public Book(int id, String name, String description, String imageUrl, boolean status, String categoryName, String publisherName ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.status = status;
        this.categoryName = categoryName;
        this.publisherName = publisherName;

    }

    public Book(String name, String description, String imageUrl, boolean status, int categoryId, int publisherId) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.status = status;
        this.categoryId = categoryId;
        this.publisherId = publisherId;
    }

    public Book(String name, String description, String imageUrl, boolean status, int categoryId, int publisherId, Timestamp createdAt) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.status = status;
        this.categoryId = categoryId;
        this.publisherId = publisherId;
        this.createdAt = createdAt;
    }

    public Book(int id, String name, String description, String imageUrl, boolean status, int categoryId, int publisherId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.status = status;
        this.categoryId = categoryId;
        this.publisherId = publisherId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
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
}
