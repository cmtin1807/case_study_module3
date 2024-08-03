package com.example.casestudydanang.repository.borrowing;

import com.example.casestudydanang.model.BorrowTransaction;
import com.example.casestudydanang.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowTransactionRepository {
    private static final String CREATE_BORROW_TRANSACTION = "INSERT INTO borrow_transactions (customer_id, book_id, borrow_date) VALUES (?, ?, ?)";
    private static final String FIND_ALL_BORROW_TRANSACTIONS = "SELECT * FROM borrow_transactions";

    public void save(BorrowTransaction transaction) {
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(CREATE_BORROW_TRANSACTION)) {
            stmt.setInt(1, transaction.getCustomerId());
            stmt.setInt(2, transaction.getBookId());
            stmt.setDate(3, transaction.getBorrowDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public List<BorrowTransaction> findAll() {
//        List<BorrowTransaction> transactions = new ArrayList<>();
//        try (Connection conn = Database.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(FIND_ALL_BORROW_TRANSACTIONS);
//             ResultSet rs = stmt.executeQuery()) {
//
//            while (rs.next()) {
//                BorrowTransaction transaction = new BorrowTransaction();
//                transaction.setId(rs.getInt("borrow_transactions_id"));
//                transaction.setCustomerId(rs.getInt("customer_id"));
//                transaction.setBookId(rs.getInt("book_id"));
//                transaction.setBorrowDate(rs.getDate("borrow_date"));
//                transaction.setReturnDate(rs.getDate("return_date"));
//                transaction.setStatusBorrowId(rs.getInt("status_borrow_id"));
//                transactions.add(transaction);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return transactions;
//    }

    public static List<BorrowTransaction> findAll() {
        List<BorrowTransaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM borrow_transactions";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                BorrowTransaction transaction = new BorrowTransaction();
                transaction.setId(rs.getInt("id"));
                transaction.setCustomerId(rs.getInt("customer_id"));
                transaction.setBookId(rs.getInt("book_id"));
                transaction.setBorrowDate(rs.getDate("borrow_date"));
                transaction.setReturnDate(rs.getDate("return_date"));
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    public static BorrowTransaction findById(int id) {
        BorrowTransaction transaction = null;
        String query = "SELECT * FROM borrow_transactions WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                transaction = new BorrowTransaction();
                transaction.setId(rs.getInt("id"));
                transaction.setCustomerId(rs.getInt("customer_id"));
                transaction.setBookId(rs.getInt("book_id"));
                transaction.setBorrowDate(rs.getDate("borrow_date"));
                transaction.setReturnDate(rs.getDate("return_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }
}
