package com.example.casestudydanang.repository.borrowing;

import com.example.casestudydanang.model.BorrowDTO.BorrowTransactionDTO;
import com.example.casestudydanang.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowTransactionRepository implements IBorrowTransactionRepository {

    private static final String SHOW_ALL_LIST_BORROWS = "select borrow_transactions_id,customer_name, customer_code, customer_class, customer_birthday, name, image_url, status, category_name, publisher_name, borrow_date, return_date, status_borrow_type from customers\n" +
            "    join borrow_transactions on customers.customer_id = borrow_transactions.customer_id\n" +
            "join status_borrow on borrow_transactions.status_borrow_id = status_borrow.status_borrow_id\n" +
            "join Book on borrow_transactions.book_id = Book.book_id\n" +
            "join category on Book.category_id = category.category_id\n" +
            "join publisher on Book.publisher_id = publisher.publisher_id\n" +
            "WHERE Customers.is_deleted = false;";
    private static final String SHOW_LIST_BASIC_BORROWS = "select borrow_transactions_id, customer_name, customer_code, name, status_borrow_type from Customers\n" +
            "join borrow_transactions  on Customers.customer_id = borrow_transactions.customer_id\n" +
            "join Book on borrow_transactions.book_id = Book.book_id\n" +
            "join status_borrow on borrow_transactions.status_borrow_id = status_borrow.status_borrow_id\n" +
            "where Customers.is_deleted = false;";

    @Override
    public List<BorrowTransactionDTO> findAll() {
        List<BorrowTransactionDTO> borrowTransactionDTOS = new ArrayList<>();

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SHOW_ALL_LIST_BORROWS);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                BorrowTransactionDTO borrowTransactionDTO = new BorrowTransactionDTO();
                borrowTransactionDTO.setId(rs.getInt("borrow_transactions_id"));
                borrowTransactionDTO.setNameCustomer(rs.getString("customer_name"));
                borrowTransactionDTO.setCodeCustomer(rs.getString("customer_code"));
                borrowTransactionDTO.setClassCustomer(rs.getString("customer_class"));
                borrowTransactionDTO.setBirthDate(rs.getDate("customer_birthday"));
                borrowTransactionDTO.setNameBook(rs.getString("name"));
                borrowTransactionDTO.setImageUrl(rs.getString("image_url"));
                borrowTransactionDTO.setStatus(rs.getBoolean("status"));
                borrowTransactionDTO.setCategoryName(rs.getString("category_name"));
                borrowTransactionDTO.setPublisherName(rs.getString("publisher_name"));
                borrowTransactionDTO.setBorrowDate(rs.getDate("borrow_date"));
                borrowTransactionDTO.setReturnDate(rs.getDate("return_date"));
                borrowTransactionDTO.setStatusBorrowType(rs.getString("status_borrow_type"));
                borrowTransactionDTOS.add(borrowTransactionDTO);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrowTransactionDTOS;
    }

    public List<BorrowTransactionDTO> findBasicBorrow() {
        List<BorrowTransactionDTO> borrowTransactionDTOS = new ArrayList<>();

        try (Connection connection = Database.getConnection();
                PreparedStatement stmt = connection.prepareStatement(SHOW_LIST_BASIC_BORROWS);
                ResultSet rs = stmt.executeQuery()){

            while (rs.next()){
                BorrowTransactionDTO borrowTransactionDTO = new BorrowTransactionDTO();
                borrowTransactionDTO.setId(rs.getInt("borrow_transactions_id"));
                borrowTransactionDTO.setNameCustomer(rs.getString("customer_name"));
                borrowTransactionDTO.setCodeCustomer(rs.getString("customer_code"));
                borrowTransactionDTO.setNameBook(rs.getString("name"));
                borrowTransactionDTO.setStatusBorrowType(rs.getString("status_borrow_type"));
                borrowTransactionDTOS.add(borrowTransactionDTO);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return borrowTransactionDTOS;
    }

    @Override
    public BorrowTransactionDTO findById(int id) {
        BorrowTransactionDTO transaction = null;


        return transaction;
    }

    // Các phương thức còn lại không thay đổi
    @Override
    public void save(BorrowTransactionDTO object) {
        // Implement save logic
    }

    @Override
    public void update(int id, BorrowTransactionDTO object) {
        // Implement update logic
    }

    @Override
    public void delete(int id) {
        // Implement delete logic
    }
}
