package com.example.casestudydanang.controller;


import com.example.casestudydanang.model.Customer;
import com.example.casestudydanang.service.customer.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "customerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            case "edit":
                showFormUpdate(request,response);
                break;
            default:
                showListCustomer(request, response);
        }
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        if (customer != null) {
            request.setAttribute("customer", customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.sendRedirect("/customers");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        String message;

        if (customer != null) {
            if (customer.getActive()) {
                message = "Khách hàng đang mượn sách, không thể xóa.";
            } else {
                customerService.deleteSoft(id);
                message = "Xóa khách hàng thành công.";
            }
        } else {
            message = "Khách hàng không tồn tại.";
        }

        request.setAttribute("message", message);

        showListCustomer(request, response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = customerService.findAll();
        request.setAttribute("customers", customers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request,response);
                break;
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String codeCustomer = request.getParameter("codeCustomer");
        String classCustomer = request.getParameter("classCustomer");
        String address = request.getParameter("address");
        String birthDateStr = request.getParameter("birthDate");
        boolean active = Boolean.parseBoolean(request.getParameter("active"));

        java.sql.Date birthDate = null;
        if (birthDateStr != null && !birthDateStr.isEmpty()) {
            birthDate = java.sql.Date.valueOf(LocalDate.parse(birthDateStr));
        }

        Customer customer = new Customer(name, codeCustomer, classCustomer, address, birthDate);
        customer.setId(id);
        customer.setActive(active);
        customerService.update(id, customer);

        try {
            response.sendRedirect("/customers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String codeCustomer = request.getParameter("codeCustomer");
        String classCustomer = request.getParameter("classCustomer");
        String address = request.getParameter("address");
        String birthDateStr = request.getParameter("birthDate");

        java.sql.Date birthDate = null;
        if (birthDateStr != null && !birthDateStr.isEmpty()) {
            birthDate = java.sql.Date.valueOf(LocalDate.parse(birthDateStr));
        }

        Customer customer = new Customer(name, codeCustomer, classCustomer, address, birthDate);
        customerService.save(customer);

        try {
            response.sendRedirect("/customers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
