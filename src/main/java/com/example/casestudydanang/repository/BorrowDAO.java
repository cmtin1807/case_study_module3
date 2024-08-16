package com.example.casestudydanang.repository;

import com.example.casestudydanang.model.BorrowDTO.BorrowTransactionDTO;
import com.example.casestudydanang.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowDAO {
    public List<BorrowTransactionDTO> getOverdueBorrowings() throws SQLException {
        List<BorrowTransactionDTO> overdueBorrowings = new ArrayList<>();
        String sql = "SELECT\n" +
                "    bt.borrow_transactions_id,\n" +
                "    c.customer_name,\n" +
                "    c.customer_code,\n" +
                "    b.name AS book_name,\n" +
                "    sb.status_borrow_type\n" +
                "FROM\n" +
                "    Customers c\n" +
                "        JOIN\n" +
                "    borrow_transactions bt ON c.customer_id = bt.customer_id\n" +
                "        JOIN\n" +
                "    Book b ON bt.book_id = b.book_id\n" +
                "        JOIN\n" +
                "    status_borrow sb ON bt.status_borrow_id = sb.status_borrow_id\n" +
                "WHERE\n" +
                "    bt.return_date < CURRENT_DATE\n" +
                "  AND bt.status_borrow_id != 3;";

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("borrow_transactions_id");
                String nameCustomer = rs.getString("customer_name");
                String codeCustomer = rs.getString("customer_code");
                String nameBook = rs.getString("book_name");
                String statusBorrowType = rs.getString("status_borrow_type");

                BorrowTransactionDTO borrowTransactionDTO = new BorrowTransactionDTO(id, nameCustomer, codeCustomer, nameBook, statusBorrowType);
                overdueBorrowings.add(borrowTransactionDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return overdueBorrowings;
    }
}
