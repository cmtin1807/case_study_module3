package com.example.casestudydanang.service.publisher;

import com.example.casestudydanang.model.Publisher;
import com.example.casestudydanang.repository.publisher.PublisherRepository;

import java.util.List;

public class PublisherService {
    private PublisherRepository publisherDAO = new PublisherRepository();

    public List<Publisher> getAllPublishers() {
        return publisherDAO.getAllPublishers();
    }
}
