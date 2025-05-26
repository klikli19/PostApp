package com.example.postapp.service;

import com.example.postapp.model.PostalItems;
import com.example.postapp.repository.PostalItemsRepository;
import org.springframework.stereotype.Service;

@Service
public class PostalItemsService {

    private PostalItemsRepository repository;

    public PostalItemsService(PostalItemsRepository repository) {
        this.repository = repository;
    }

    public PostalItems save(PostalItems postalItems){
        return repository.save(postalItems);
    }

    public PostalItems findById(Long id) {
        return repository.findById(id).orElse(null);
    }


}
