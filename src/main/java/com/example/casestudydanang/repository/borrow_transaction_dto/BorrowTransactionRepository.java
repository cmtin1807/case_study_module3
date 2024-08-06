package com.example.casestudydanang.repository.borrow_transaction_dto;

import com.example.casestudydanang.model.BorrowDTO.BorrowTransactionDTO;
import com.example.casestudydanang.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BorrowTransactionRepository implements IBorrowTransactionRepository {

    private static final String SHOW_ALL_LIST_BORROWS = "select borrow_transactions_id, customer_name, customer_code, customer_class, customer_birthday, name, image_url, status, category_name, publisher_name, borrow_date, return_date, status_borrow_type from customers " +
            "join borrow_transactions on customers.customer_id = borrow_transactions.customer_id " +
            "join status_borrow on borrow_transactions.status_borrow_id = status_borrow.status_borrow_id " +
            "join Book on borrow_transactions.book_id = Book.book_id " +
            "join category on Book.category_id = category.category_id " +
            "join publisher on Book.publisher_id = publisher.publisher_id " +
            "WHERE Customers.customer_is_active = true;";
    private static final String SHOW_LIST_BASIC_BORROWS = "select borrow_transactions_id, customer_name, customer_code, name, status_borrow_type from Customers " +
            "join borrow_transactions  on Customers.customer_id = borrow_transactions.customer_id " +
            "join Book on borrow_transactions.book_id = Book.book_id " +
            "join status_borrow on borrow_transactions.status_borrow_id = status_borrow.status_borrow_id " ;
//            "where Customers.customer_is_active = true;";
    private static final String SHOW_BORROW_BY_ID ="select borrow_transactions_id, customer_name, customer_code, customer_class, customer_address, customer_birthday, name, image_url, status, category_name, publisher_name, borrow_date, return_date, status_borrow_type from customers\n" +
            "            join borrow_transactions on customers.customer_id = borrow_transactions.customer_id\n" +
            "            join status_borrow on borrow_transactions.status_borrow_id = status_borrow.status_borrow_id\n" +
            "            join Book on borrow_transactions.book_id = Book.book_id\n" +
            "            join category on Book.category_id = category.category_id\n" +
            "            join publisher on Book.publisher_id = publisher.publisher_id\n" +
            "            WHERE  borrow_transactions_id = ?;";
    private static final String SHOW_BORROW_BY_CODE_CUSTOMER ="select borrow_transactions_id, customer_name, customer_code, customer_class, customer_birthday, name, image_url, status, category_name, publisher_name, borrow_date, return_date, status_borrow_type from customers " +
            "join borrow_transactions on customers.customer_id = borrow_transactions.customer_id " +
            "join status_borrow on borrow_transactions.status_borrow_id = status_borrow.status_borrow_id " +
            "join Book on borrow_transactions.book_id = Book.book_id " +
            "join category on Book.category_id = category.category_id " +
            "join publisher on Book.publisher_id = publisher.publisher_id " +
            "WHERE Customers.customer_is_active = true and Customers.customer_code = ?;";
    private static final String INSERT_BORROW_TRANSACTION = "INSERT INTO borrow_transactions (customer_id, book_id, borrow_date, return_date, status_borrow_id) " +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_BORROW_TRANSACTION = "UPDATE borrow_transactions SET customer_id = ?, book_id = ?, borrow_date = ?, return_date = ?, status_borrow_id = ? WHERE borrow_transactions_id = ?";
    private static final String DELETE_BORROW_TRANSACTION = "DELETE FROM borrow_transactions WHERE borrow_transactions_id = ?";


    public List<BorrowTransactionDTO> findBasicBorrow() {
        List<BorrowTransactionDTO> borrowTransactionDTOList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SHOW_LIST_BASIC_BORROWS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("borrow_transactions_id");
                String nameCustomer = rs.getString("customer_name");
                String codeCustomer = rs.getString("customer_code");
                String nameBook = rs.getString("name");
                String statusBorrowType = rs.getString("status_borrow_type");

                BorrowTransactionDTO borrowTransactionDTO = new BorrowTransactionDTO(id, nameCustomer, codeCustomer, nameBook, statusBorrowType);
                borrowTransactionDTOList.add(borrowTransactionDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrowTransactionDTOList;
    }


    public List<BorrowTransactionDTO> findAllBorrow() {
        List<BorrowTransactionDTO> borrowTransactionDTOList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SHOW_ALL_LIST_BORROWS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("borrow_transactions_id");
                String nameCustomer = rs.getString("customer_name");
                String codeCustomer = rs.getString("customer_code");
                String classCustomer = rs.getString("customer_class");
                String address = rs.getString("customer_address");
                Date birthDate = rs.getDate("customer_birthday");
                String nameBook = rs.getString("name");
                String imageUrl = rs.getString("image_url");
                boolean status = rs.getBoolean("status");
                String categoryName = rs.getString("category_name");
                String publisherName = rs.getString("publisher_name");
                Date borrowDate = rs.getDate("borrow_date");
                Date returnDate = rs.getDate("return_date");
                String statusBorrowType = rs.getString("status_borrow_type");

                BorrowTransactionDTO borrowTransactionDTO = new BorrowTransactionDTO(id, nameCustomer, codeCustomer, classCustomer, address, birthDate, nameBook, imageUrl, status, categoryName, publisherName, borrowDate, returnDate, statusBorrowType);
                borrowTransactionDTOList.add(borrowTransactionDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrowTransactionDTOList;
    }

    @Override
    public List<BorrowTransactionDTO> findAll() {
        return Collections.emptyList();
    }

    @Override
    public BorrowTransactionDTO findById(int id) {
        BorrowTransactionDTO borrowTransactionDTO = null;
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SHOW_BORROW_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String nameCustomer = rs.getString("customer_name");
                String codeCustomer = rs.getString("customer_code");
                String classCustomer = rs.getString("customer_class");
                String address = rs.getString("customer_address");
                Date birthDate = rs.getDate("customer_birthday");
                String nameBook = rs.getString("name");
                String imageUrl = rs.getString("image_url");
                boolean status = rs.getBoolean("status");
                String categoryName = rs.getString("category_name");
                String publisherName = rs.getString("publisher_name");
                Date borrowDate = rs.getDate("borrow_date");
                Date returnDate = rs.getDate("return_date");
                String statusBorrowType = rs.getString("status_borrow_type");

                borrowTransactionDTO = new BorrowTransactionDTO(id, nameCustomer, codeCustomer, classCustomer, address, birthDate, nameBook, imageUrl, status, categoryName, publisherName, borrowDate, returnDate, statusBorrowType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrowTransactionDTO;
    }


    public List<BorrowTransactionDTO> findByCodeCustomer(String codeCustomer) {
        List<BorrowTransactionDTO> borrowTransactionDTOList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SHOW_BORROW_BY_CODE_CUSTOMER)) {
            preparedStatement.setString(1, codeCustomer);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("borrow_transactions_id");
                String nameCustomer = rs.getString("customer_name");
                String classCustomer = rs.getString("customer_class");
                Date birthDate = rs.getDate("customer_birthday");
                String nameBook = rs.getString("name");
                String imageUrl = rs.getString("image_url");
                boolean status = rs.getBoolean("status");
                String categoryName = rs.getString("category_name");
                String publisherName = rs.getString("publisher_name");
                Date borrowDate = rs.getDate("borrow_date");
                Date returnDate = rs.getDate("return_date");
                String statusBorrowType = rs.getString("status_borrow_type");

                BorrowTransactionDTO borrowTransactionDTO = new BorrowTransactionDTO(id, nameCustomer, codeCustomer, classCustomer, null, birthDate, nameBook, imageUrl, status, categoryName, publisherName, borrowDate, returnDate, statusBorrowType);
                borrowTransactionDTOList.add(borrowTransactionDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrowTransactionDTOList;
    }

    @Override
    public void save(BorrowTransactionDTO borrowTransaction) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BORROW_TRANSACTION)) {
            preparedStatement.setInt(1, borrowTransaction.getCustomerId());
            preparedStatement.setInt(2, borrowTransaction.getBookId());
            preparedStatement.setDate(3, borrowTransaction.getBorrowDate());
            preparedStatement.setDate(4, borrowTransaction.getReturnDate());
            preparedStatement.setInt(5, borrowTransaction.getStatusBorrowId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, BorrowTransactionDTO object) {

    }

    @Override
    public void delete(int id) {

    }


    public void update(BorrowTransactionDTO borrowTransaction) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BORROW_TRANSACTION)) {
            preparedStatement.setInt(1, borrowTransaction.getCustomerId());
            preparedStatement.setInt(2, borrowTransaction.getBookId());
            preparedStatement.setDate(3, borrowTransaction.getBorrowDate());
            preparedStatement.setDate(4, borrowTransaction.getReturnDate());
            preparedStatement.setInt(5, borrowTransaction.getStatusBorrowId());
            preparedStatement.setInt(6, borrowTransaction.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteBorrowTransaction(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BORROW_TRANSACTION)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
