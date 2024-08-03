package com.example.casestudydanang.service.book;

import com.example.casestudydanang.model.Book;
import com.example.casestudydanang.service.IGenerateService;

import java.util.List;

public interface IBookService extends IGenerateService<Book> {
    List<Book> findByCategoryName (String categoryName);
    List<Book> findByPublisherName(String publisherName);

}
