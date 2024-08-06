package com.example.casestudydanang.repository.borrow;

import com.example.casestudydanang.model.Borrow;
import com.example.casestudydanang.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class BorrowReposiotry implements IBorrowRepository{
    private static final String INSERT_INTO_BORROW = "insert into borrow_transactions (customer_id, book_id, borrow_date, return_date, status_borrow_id)\n" +
            "values (?,?,?,?,?);";

    @Override
    public List<Borrow> findAll() {
        return Collections.emptyList();
    }

    @Override
    public Borrow findById(int id) {
        return null;
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
    public void update(int id, Borrow object) {

    }

    @Override
    public void delete(int id) {

    }
}
