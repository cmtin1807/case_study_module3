package com.example.casestudydanang.service.customer;

import com.example.casestudydanang.model.Customer;
import com.example.casestudydanang.repository.customer.CustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    private CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public List<Customer> findAllInBorrowCustomer() {
        return customerRepository.findAllInBorrowedCustomer();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer object) {
customerRepository.save(object);
    }

    @Override
    public void update(int id, Customer object) {
        customerRepository.update(id, object);
    }

    @Override
    public void delete(int id) {

    }
    public void deleteSoft(int id) {
        Customer customer = customerRepository.findById(id);
        if (customer != null) {
            if (customer.getActive()) {
                System.out.println("Khách hàng đang hoạt động, không thể xóa.");
            } else {
                customer.setIsDeleted(true);
                customerRepository.update(id, customer);
            }
        } else {
            System.out.println("Khách hàng không tồn tại.");
        }
    }

    public boolean isCustomerCurrentlyBorrowingBooks(int customerId) {
        return customerRepository.isCustomerCurrentlyBorrowingBooks(customerId);
    }
}
