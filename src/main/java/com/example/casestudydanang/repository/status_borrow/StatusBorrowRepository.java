package com.example.casestudydanang.repository.status_borrow;

import com.example.casestudydanang.model.StatusBorrow;
import com.example.casestudydanang.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatusBorrowRepository implements IStatusBorrowRepository {
    @Override
    public List<StatusBorrow> findAll() {
        String sql = "select * from status_borrow";
        List<StatusBorrow> statusBorrows = new ArrayList<>();
        try (Connection connection = Database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()){

                    while (resultSet.next()){
                        StatusBorrow statusBorrow = new StatusBorrow();
                        statusBorrow.setId(resultSet.getInt("status_borrow_id"));
                        statusBorrow.setStatusBorrowType(resultSet.getString("status_borrow_type"));
                        statusBorrows.add(statusBorrow);
                    }

        }catch (SQLException e){
                    e.printStackTrace();
        }
        return statusBorrows;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, StatusBorrow object) {

    }

    @Override
    public void save(StatusBorrow object) {

    }

    @Override
    public StatusBorrow findById(int id) {
        return null;
    }
}
