package com.example.casestudydanang.repository.customer;

import com.example.casestudydanang.model.Customer;
import com.example.casestudydanang.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
//    private static final String SHOW_ALL_LIST_CUSTOMER = "SELECT customer_id, customer_name, customer_code, " +
//            "customer_class, customer_address, customer_birthday, customer_is_active FROM customers";
    private static final String CREATE_CUSTOMER = "INSERT INTO customers (customer_name, customer_code, customer_class, customer_address, customer_birthday) VALUES (?, ?, ?, ?, ?)";
    private static final String SHOW_ALL_LIST_CUSTOMER = "SELECT customer_id, customer_name, customer_code, " +
            "customer_class, customer_address, customer_birthday, customer_is_active, is_deleted FROM customers WHERE is_deleted = FALSE";
    private static final String UPDATE_CUSTOMER = "UPDATE customers SET customer_name = ?, customer_code = ?, " +
            "customer_class = ?, customer_address = ?, customer_birthday = ?, customer_is_active = ?, is_deleted = ? WHERE customer_id = ?";
    private static final String FIND_CUSTOMER_BY_ID = "SELECT * FROM customers WHERE customer_id = ?";
    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SHOW_ALL_LIST_CUSTOMER);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("customer_id"));
                customer.setName(rs.getString("customer_name"));
                customer.setCodeCustomer(rs.getString("customer_code"));
                customer.setClassCustomer(rs.getString("customer_class"));
                customer.setAddress(rs.getString("customer_address"));
                customer.setBirthDate(rs.getDate("customer_birthday"));
                customer.setActive(rs.getBoolean("customer_is_active"));
                customer.setIsDeleted(rs.getBoolean("is_deleted"));
                customers.add(customer);

                // In ra số lượng khách hàng để kiểm tra
                System.out.println("Number of customers fetched: " + customers.size());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;

        try (
                Connection connection = Database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_CUSTOMER_BY_ID);
                ){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                customer = new Customer();
                customer.setId(resultSet.getInt("customer_id"));
                customer.setName(resultSet.getString("customer_name"));
                customer.setCodeCustomer(resultSet.getString("customer_code"));
                customer.setClassCustomer(resultSet.getString("customer_class"));
                customer.setAddress(resultSet.getString("customer_address"));
                customer.setBirthDate(resultSet.getDate("customer_birthday"));
                customer.setActive(resultSet.getBoolean("customer_is_active"));
                customer.setIsDeleted(resultSet.getBoolean("is_deleted"));

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void save(Customer customer) {
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(CREATE_CUSTOMER)) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getCodeCustomer());
            stmt.setString(3, customer.getClassCustomer());
            stmt.setString(4, customer.getAddress());
            stmt.setDate(5, customer.getBirthDate());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void update(int id, Customer customer) {
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_CUSTOMER)) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getCodeCustomer());
            stmt.setString(3, customer.getClassCustomer());
            stmt.setString(4, customer.getAddress());
            stmt.setDate(5, customer.getBirthDate());
            stmt.setBoolean(6, customer.getActive());
            stmt.setBoolean(7, customer.getIsDeleted());
            stmt.setInt(8, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
    }
    public boolean isCustomerCurrentlyBorrowingBooks(int customerId) {
        String query = "SELECT COUNT(*) FROM borrow_transactions WHERE customer_id = ? AND return_date IS NULL";
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
