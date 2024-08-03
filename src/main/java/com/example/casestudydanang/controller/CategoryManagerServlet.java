package com.example.casestudydanang.controller;

import com.example.casestudydanang.model.Category;
import com.example.casestudydanang.service.category.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "categoryManagerServlet", urlPatterns = "/categories")
public class CategoryManagerServlet extends HttpServlet {

    private CategoryService categoryService = new CategoryService();

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
            case "edit":
                showFormUpdate(request, response);
                break;
            case "delete":
                showFormDelete(request, response);
                break;
            case "view":
                showFormView(request, response);
                break;
            default:
                showListCategory(request, response);
                break;
        }
    }

    private void showFormView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.findById(id);
        request.setAttribute("category", category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/view.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.findById(id);
        request.setAttribute("category", category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/delete.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category existingCategory = categoryService.findById(id);
        request.setAttribute("category", existingCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/update.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showListCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/list.jsp");
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
                createCategory(request, response);
                break;
            case "edit":
                updateCategory(request, response);
                break;
            case "delete":
                deleteCategory(request, response);
                break;
            default:
                response.sendRedirect("categories");
                break;
        }
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        categoryService.delete(id);
        response.sendRedirect("categories");
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Name is required");
            Category category = new Category();
            category.setId(id);
            category.setName(name);
            request.setAttribute("category", category);
            RequestDispatcher dispatcher = request.getRequestDispatcher("category/update.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Category category = new Category();
        category.setId(id);
        category.setName(name);

        categoryService.update(id, category);

        response.sendRedirect("categories");
    }

    private void createCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Name is required");
            RequestDispatcher dispatcher = request.getRequestDispatcher("category/create.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Category category = new Category();
        category.setName(name);

        categoryService.save(category);

        response.sendRedirect("categories");
    }
}
