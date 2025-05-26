package com.example.postapp.service;

import com.example.postapp.model.PostOffice;
import com.example.postapp.repository.PostOfficeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostOfficeService {

    private final PostOfficeRepository repository;

    public PostOfficeService(PostOfficeRepository repository) {
        this.repository = repository;
    }

    public String removePostOffice(Long id) {
       if (repository.findById(id).isPresent()){
           repository.deleteById(id);
           return "Отделение успешно удалено";
       }else
        return "Отделение отсутствует";
    }

    public ResponseEntity<PostOffice> save(PostOffice postOffice) {
        return ResponseEntity.ok(repository.save(postOffice));
    }

     public List<PostOffice> findAll() {
        return repository.findAll();
    }

    public PostOffice findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
