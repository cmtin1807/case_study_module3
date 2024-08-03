package com.example.casestudydanang.service.publisher;

import com.example.casestudydanang.model.Publisher;
import com.example.casestudydanang.repository.publisher.PublisherRepository;

import java.util.List;

public class PublisherService {
    private PublisherRepository publisherRepository = new PublisherRepository();

    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }
}
