package com.example.casestudydanang.controller;


// BookManager.java (continued)

import com.example.casestudydanang.model.Book;
import com.example.casestudydanang.model.Category;
import com.example.casestudydanang.model.Publisher;
import com.example.casestudydanang.service.book.BookService;
import com.example.casestudydanang.service.category.CategoryService;
import com.example.casestudydanang.service.publisher.PublisherService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "bookManagerServlet", urlPatterns = "/books")
public class BookManagerServlet extends HttpServlet {
    private BookService bookService = new BookService();

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
            case "update":
                showFormUpdate(request, response);
                break;
            case "delete":
                showFormDelete(request, response);
                break;
            case "view":
                showFormView(request, response);
            default:
                showListBook(request, response);
        }
    }

    private void showFormView(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = this.bookService.findById(id);
        RequestDispatcher dispatcher;
        if (book == null) {
            dispatcher = request.getRequestDispatcher("errorPage.jsp");
        } else {
            request.setAttribute("book", book);
            dispatcher = request.getRequestDispatcher("book/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = this.bookService.findById(id);
        RequestDispatcher dispatcher;
        if (book == null) {
            dispatcher = request.getRequestDispatcher("errorPage.jsp");
        } else {
            request.setAttribute("book", book);
            dispatcher = request.getRequestDispatcher("book/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        CategoryService categoryService = new CategoryService();
        PublisherService publisherService = new PublisherService();

        List<Category> categories = categoryService.getAllCategories();
        List<Publisher> publishers = publisherService.getAllPublishers();

        request.setAttribute("categories", categories);
        request.setAttribute("publishers", publishers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showListBook(HttpServletRequest request, HttpServletResponse response) {
        List<Book> books = bookService.findAll();
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
                createBook(request, response);
                break;
            case "update":
                updateBook(request,response);
                break;
            case "delete":
                deleteBook(request,response);
                break;
            default:
                break;
        }
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) {
        
    }

    private void createBook(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String imageUrl = request.getParameter("image_url");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        int categoryId = Integer.parseInt(request.getParameter("category_id"));
        int publisherId = Integer.parseInt(request.getParameter("publisher_id"));

        Book book = new Book(name, description, imageUrl, status, categoryId, publisherId);

        try {
            bookService.save(book);
            request.setAttribute("message", "Book created successfully!");
        } catch (Exception e) {
            request.setAttribute("message", "Error creating book: " + e.getMessage());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("book/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}

