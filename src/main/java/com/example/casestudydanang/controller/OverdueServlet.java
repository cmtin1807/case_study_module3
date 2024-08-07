package com.example.casestudydanang.controller;

import com.example.casestudydanang.model.Borrow;
import com.example.casestudydanang.model.BorrowDTO.BorrowTransactionDTO;
import com.example.casestudydanang.repository.BorrowDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "overdueServlet", value = "/overdue")
public class OverdueServlet extends HttpServlet {
    private BorrowDAO borrowDAO;

    @Override
    public void init() throws ServletException {
        borrowDAO = new BorrowDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<BorrowTransactionDTO> overdueBorrowings = borrowDAO.getOverdueBorrowings();
            request.setAttribute("overdueBorrowings", overdueBorrowings);
            RequestDispatcher dispatcher = request.getRequestDispatcher("overdues/overdue.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database access error", e);
        }
    }
}