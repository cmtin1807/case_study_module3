package com.example.casestudydanang.controller;

import com.example.casestudydanang.model.BorrowDTO.BorrowTransactionDTO;
import com.example.casestudydanang.service.Borrow.BorrowTransactionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
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
            case "details":
                showDetails(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {

    }

    private void deleteBorrowTransaction(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showDetails(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<BorrowTransactionDTO> borrows = service.findBasicBorrow();
        request.setAttribute("borrows", borrows);

        RequestDispatcher dispatcher = request.getRequestDispatcher("borrow/list.jsp");
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
                createBorrowTransaction(request, response);
                break;
            case "edit":
                updateBorrowTransaction(request, response);
                break;
        }
    }

    private void createBorrowTransaction(HttpServletRequest request, HttpServletResponse response) {

    }

    private void updateBorrowTransaction(HttpServletRequest request, HttpServletResponse response) {

    }
}
