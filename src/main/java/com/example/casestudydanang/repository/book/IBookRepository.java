package com.example.casestudydanang.repository.book;


import com.example.casestudydanang.model.Book;
import com.example.casestudydanang.repository.IGenerateRepository;

import java.util.List;

public interface IBookRepository extends IGenerateRepository<Book> {
    List<Book> findByCategoryName (String categoryName);
}
