package com.example.casestudydanang.controller;

import com.example.casestudydanang.model.Book;
import com.example.casestudydanang.model.Borrow;
import com.example.casestudydanang.model.BorrowDTO.BorrowTransactionDTO;
import com.example.casestudydanang.model.Customer;
import com.example.casestudydanang.model.StatusBorrow;
import com.example.casestudydanang.service.borrow.BorrowService;
import com.example.casestudydanang.service.borrow_transaction_dto.BorrowTransactionService;
import com.example.casestudydanang.service.book.BookService;
import com.example.casestudydanang.service.customer.CustomerService;
import com.example.casestudydanang.service.status_borrow.StatusBorrowService;

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

@WebServlet(name = "borrowTransactionServlet", value = "/borrows")
public class BorrowTransactionServlet extends HttpServlet {
    private BorrowTransactionService service = new BorrowTransactionService();


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
                deleteBorrowTransaction(request, response);
                break;
            case "edit":
                showFormUpdate(request, response);
                break;
            case "search":
                showFormSearch(request, response);
                break;
            case "view":
                showViewBorrow(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {

        BorrowService borrowService = new BorrowService();
        BookService bookService = new BookService();
        CustomerService customerService = new CustomerService();
        StatusBorrowService statusBorrowService = new StatusBorrowService();

        List<Book> books = bookService.findAll();
        List<Customer> customers = customerService.findAll();
        List<StatusBorrow> status = statusBorrowService.findAll();

        int id = Integer.parseInt(request.getParameter("id"));

        Borrow borrow = borrowService.findById(id);
        System.out.println(borrow.toString());

        request.setAttribute("books", books);
        request.setAttribute("customers", customers);
        request.setAttribute("status", status);
        request.setAttribute("borrow", borrow);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("borrow_dto/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        BookService bookService = new BookService();
        CustomerService customerService = new CustomerService();


        List<Book> books = bookService.findAll();
        List<Customer> customers = customerService.findAll();


        request.setAttribute("books", books);
        request.setAttribute("customers", customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("borrow_dto/create.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codeCustomer = request.getParameter("codeCustomer");
        List<BorrowTransactionDTO> borrowTransactionDTOS = service.findByCodeCustomer(codeCustomer);

        request.setAttribute("borrows", borrowTransactionDTOS);
        RequestDispatcher dispatcher = request.getRequestDispatcher("borrow_dto/search.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteBorrowTransaction(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);

        List<BorrowTransactionDTO> borrows = service.findBasicBorrow();
        request.setAttribute("borrows", borrows);
        request.setAttribute("successMessage", "Phiếu mượn đã được xóa thành công!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("borrow_dto/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }

    private void showViewBorrow(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        BorrowTransactionDTO borrowTransactionDTO = service.findById(id);
        System.out.println(borrowTransactionDTO.toString());
        request.setAttribute("borrow", borrowTransactionDTO);
        RequestDispatcher dispatcher = request.getRequestDispatcher("borrow_dto/view.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BorrowTransactionDTO> borrows = service.findBasicBorrow();
        request.setAttribute("borrows", borrows);

        RequestDispatcher dispatcher = request.getRequestDispatcher("borrow_dto/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createBorrowTransaction(request, response);
                break;
            case "edit":
                updateBorrowTransaction(request, response);
                break;
        }
    }

    private void createBorrowTransaction(HttpServletRequest request, HttpServletResponse response) {

        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String borrowDate = request.getParameter("borrowDate");
        String returnDate = request.getParameter("returnDate");
        int statusBorrowId = 1;

        BorrowService borrowService = new BorrowService();
        CustomerService customerService = new CustomerService();

        Customer customer = customerService.findById(customerId);
        customer.setIsDeleted(false);
        customerService.update(customerId, customer);


        java.sql.Date borrowDateSql = null;
        java.sql.Date returnDateSql = null;
        if (borrowDate != null && !borrowDate.isEmpty()) {
            borrowDateSql = java.sql.Date.valueOf(LocalDate.parse(borrowDate));
        }
        if (returnDate != null && !returnDate.isEmpty()) {
            returnDateSql = java.sql.Date.valueOf(LocalDate.parse(returnDate));
        }

        Borrow newBorrow = new Borrow(customerId, bookId, borrowDateSql, returnDateSql, statusBorrowId);
        borrowService.save(newBorrow);
        request.setAttribute("successMessage", "Phiếu mượn đã được tạo thành công!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("borrow_dto/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateBorrowTransaction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String borrowDate = request.getParameter("borrowDate");
        String returnDate = request.getParameter("returnDate");
        int statusBorrowId = Integer.parseInt(request.getParameter("statusBorrowId"));

        java.sql.Date borrowDateSql = null;
        java.sql.Date returnDateSql = null;
        if (borrowDate != null && !borrowDate.isEmpty()) {
            borrowDateSql = java.sql.Date.valueOf(LocalDate.parse(borrowDate));
        }
        if (returnDate != null && !returnDate.isEmpty()) {
            returnDateSql = java.sql.Date.valueOf(LocalDate.parse(returnDate));
        }

        BorrowService borrowService = new BorrowService();

        Borrow borrow = new Borrow(customerId, bookId, borrowDateSql, returnDateSql, statusBorrowId);
        borrowService.update(id,borrow);
        List<BorrowTransactionDTO> borrows = service.findBasicBorrow();
        request.setAttribute("borrows", borrows);
        request.setAttribute("successMessage", "Phiếu mượn đã được cập nhật thành công!");

        RequestDispatcher dispatcher = request.getRequestDispatcher("borrow_dto/list.jsp");
        dispatcher.forward(request, response);


    }
}
