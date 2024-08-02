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
    private CategoryService categoryService = new CategoryService();
    private PublisherService publisherService = new PublisherService();

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
            case "searchCategory":
                showListSearchCategory(request, response);
                break;

            default:
                showListBook(request, response);
                break;
        }
    }



    private void showListSearchCategory(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categories = categoryService.getAllCategories();
        List<Publisher> publishers = publisherService.getAllPublishers();

        request.setAttribute("categories", categories);
        request.setAttribute("publishers", publishers);

        String searchCategoryName = request.getParameter("searchCategoryName");
        List<Book> books = bookService.findByCategoryName(searchCategoryName);

        if (books == null || books.isEmpty()) {
            books = bookService.findAll();
        }

        handlePagination(request, response, books, "book/list.jsp");
    }

    private void handlePagination(HttpServletRequest request, HttpServletResponse response, List<Book> books, String jspPath) {
        int pageSize = 10;
        int pageNumber = 1;
        String pageParam = request.getParameter("page");

        if (pageParam != null) {
            try {
                pageNumber = Integer.parseInt(pageParam);
            } catch (NumberFormatException e) {
                pageNumber = 1;
            }
        }

        int totalBooks = books.size();
        int totalPages = (int) Math.ceil((double) totalBooks / pageSize);
        int startIndex = (pageNumber - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, totalBooks);
        List<Book> booksToDisplay = books.subList(startIndex, endIndex);

        request.setAttribute("books", booksToDisplay);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("totalPages", totalPages);

        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPath);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
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
        CategoryService categoryService = new CategoryService();
        PublisherService publisherService = new PublisherService();

        List<Category> categories = categoryService.getAllCategories();
        List<Publisher> publishers = publisherService.getAllPublishers();
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = this.bookService.findById(id);
        RequestDispatcher dispatcher;
        if (book == null) {
            dispatcher = request.getRequestDispatcher("errorPage.jsp");
        } else {
            request.setAttribute("categories", categories);
            request.setAttribute("publishers", publishers);
            request.setAttribute("book", book);
            dispatcher = request.getRequestDispatcher("book/update.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


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
        CategoryService categoryService = new CategoryService();
        PublisherService publisherService = new PublisherService();
        List<Category> categories = categoryService.getAllCategories();
        List<Publisher> publishers = publisherService.getAllPublishers();
        request.setAttribute("categories", categories);
        request.setAttribute("publishers", publishers);
        List<Book> books = bookService.findAll();


        handlePagination(request, response, books, "book/list.jsp");
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
            case "edit":
                updateBook(request, response);
                break;
            case "delete":
                deleteBook(request, response);
                break;
            default:
                break;
        }
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        bookService.delete(id);
        try {
            response.sendRedirect("books");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void updateBook(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String imageUrl = request.getParameter("image_url");
            boolean status = Boolean.parseBoolean(request.getParameter("status"));
            int categoryId = Integer.parseInt(request.getParameter("category_id"));
            int publisherId = Integer.parseInt(request.getParameter("publisher_id"));

            Book book = new Book(name, description, imageUrl, status, categoryId, publisherId);

            bookService.update(id, book);
            response.sendRedirect("books");
        } catch (NumberFormatException e) {
            request.setAttribute("message", "Invalid or missing parameters.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("errorPage.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

