package com.example.casestudydanang.repository.book;

// BookDAO.java


import com.example.casestudydanang.model.Book;
import com.example.casestudydanang.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {

    private static final String SHOW_ALL_LIST_BOOKS = "SELECT b.*, c.category_name, p.publisher_name " +
            "FROM Book b " +
            "JOIN Category c ON b.category_id = c.category_id " +
            "JOIN Publisher p ON b.publisher_id = p.publisher_id " +
            "ORDER BY b.book_id";
    private static final String SHOW_BOOK_BY_ID = "SELECT b.*, c.category_name, p.publisher_name " +
            "FROM Book b " +
            "JOIN Category c ON b.category_id = c.category_id " +
            "JOIN Publisher p ON b.publisher_id = p.publisher_id " +
            "WHERE b.book_id = ?";





    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();



        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SHOW_ALL_LIST_BOOKS);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("book_id"));
                book.setName(rs.getString("name"));
                book.setDescription(rs.getString("description"));
                book.setImageUrl(rs.getString("image_url"));
                book.setStatus(rs.getBoolean("status"));
                book.setCategoryId(rs.getInt("category_id"));
                book.setPublisherId(rs.getInt("publisher_id"));
                book.setCategoryName(rs.getString("category_name")); // New
                book.setPublisherName(rs.getString("publisher_name")); // New
                book.setCreatedAt(rs.getTimestamp("created_at"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }



    public void save(Book book) {
        String sql = "INSERT INTO Book (name, description, image_url, status, category_id, publisher_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getName());
            stmt.setString(2, book.getDescription());
            stmt.setString(3, book.getImageUrl());
            stmt.setBoolean(4, book.isStatus());
            stmt.setInt(5, book.getCategoryId());
            stmt.setInt(6, book.getPublisherId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book findById(int id) {
        Book book = null;
        try (
                Connection connection = Database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SHOW_BOOK_BY_ID);
        ) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    book = new Book();
                    book.setId(resultSet.getInt("book_id"));
                    book.setName(resultSet.getString("name"));
                    book.setDescription(resultSet.getString("description"));
                    book.setImageUrl(resultSet.getString("image_url"));
                    book.setStatus(resultSet.getBoolean("status"));
                    book.setCategoryId(resultSet.getInt("category_id"));
                    book.setPublisherId(resultSet.getInt("publisher_id"));
                    book.setCategoryName(resultSet.getString("category_name"));
                    book.setPublisherName(resultSet.getString("publisher_name"));
                    book.setCreatedAt(resultSet.getTimestamp("created_at"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }


    @Override
    public void update(int id, Book book) {
        String sql = "UPDATE Book SET name = ?, description = ?, image_url = ?, status = ?, category_id = ?, publisher_id = ? WHERE book_id = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getName());
            stmt.setString(2, book.getDescription());
            stmt.setString(3, book.getImageUrl());
            stmt.setBoolean(4, book.isStatus());
            stmt.setInt(5, book.getCategoryId());
            stmt.setInt(6, book.getPublisherId());
            stmt.setInt(7, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Book WHERE book_id = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

