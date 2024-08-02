package com.example.casestudydanang.service;

import com.example.casestudydanang.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    private Connection connection;
    public UserService(){}

    public UserService(Connection connection) {
        this.connection = connection;
    }

    public User findByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM User WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getString("role"));
            return user;
        } else {
            return null;
        }
    }
}

