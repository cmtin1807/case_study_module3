package com.example.casestudydanang.service.book;


import com.example.casestudydanang.model.Book;
import com.example.casestudydanang.repository.book.BookRepository;

import java.util.List;

public class BookService implements IBookService {
    private BookRepository bookRepository = new BookRepository();

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void update(int id, Book object) {
        bookRepository.update(id, object);
    }

    @Override
    public void delete(int id) {
        bookRepository.delete(id);

    }
}

