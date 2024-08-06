package com.example.casestudydanang.repository.borrow;

import com.example.casestudydanang.model.Borrow;
import com.example.casestudydanang.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class BorrowReposiotry implements IBorrowRepository{
    private static final String INSERT_INTO_BORROW = "insert into borrow_transactions (customer_id, book_id, borrow_date, return_date, status_borrow_id)\n" +
            "values (?,?,?,?,?);";
    private static final String UPDATE_INTO_BORROW_TRANSACTION = "UPDATE borrow_transactions SET customer_id = ?, book_id = ?, borrow_date = ?, return_date = ?, status_borrow_id = ? WHERE borrow_transactions_id = ?;";

    private static final String FIND_BORROW_TRANSACTION_BY_ID = "SELECT * FROM borrow_transactions WHERE borrow_transactions_id = ?;";

    @Override
    public List<Borrow> findAll() {
        return Collections.emptyList();
    }

    @Override
    public Borrow findById(int id) {
        Borrow borrow = null;

        try (Connection connection = Database.getConnection();
                PreparedStatement stmt = connection.prepareStatement(FIND_BORROW_TRANSACTION_BY_ID)){
                stmt.setInt(1,id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()){
                    borrow = new Borrow();
                    borrow.setId(rs.getInt("borrow_transactions_id"));
                    borrow.setCustomerId(rs.getInt("customer_id"));
                    borrow.setBookId(rs.getInt("book_id"));
                    borrow.setBorrowDate(rs.getDate("borrow_date"));
                    borrow.setReturnDate(rs.getDate("return_date"));
                    borrow.setStatusBorrowId(rs.getInt("status_borrow_id"));
                }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return borrow;
    }

    @Override
    public void save(Borrow object) {
    try(Connection connection = Database.getConnection();
    PreparedStatement stmt = connection.prepareStatement(INSERT_INTO_BORROW)) {
        stmt.setInt(1, object.getCustomerId());
        stmt.setInt(2,object.getBookId());
        stmt.setDate(3,object.getBorrowDate());
        stmt.setDate(4,object.getReturnDate());
        stmt.setInt(5,object.getStatusBorrowId());
        stmt.executeUpdate();
    }catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

    @Override
    public void update(int id, Borrow borrow) {
        try (Connection connection = Database.getConnection();
                PreparedStatement stmt = connection.prepareStatement(UPDATE_INTO_BORROW_TRANSACTION)){
            stmt.setInt(1, borrow.getCustomerId());
            stmt.setInt(2,borrow.getBookId());
            stmt.setDate(3,borrow.getBorrowDate());
            stmt.setDate(4,borrow.getReturnDate());
            stmt.setInt(5,borrow.getStatusBorrowId());
            stmt.setInt(6, id);
            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {

    }
}
