package com.example.postapp.controllers;

import com.example.postapp.dto.PostOfficeDTO;
import com.example.postapp.model.PostOffice;
import com.example.postapp.service.PostOfficeService;
import com.example.postapp.mapper.MappingPostalOffice;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/postOffice")
@RestController
public class PostOfficeController {

    private final PostOfficeService service;
    private final MappingPostalOffice mappingPostalOffice;


    public PostOfficeController(PostOfficeService service, MappingPostalOffice mappingPostalOffice) {
        this.service = service;
        this.mappingPostalOffice = mappingPostalOffice;
    }

    @Operation(
            summary = "Добавить почтовое отделение",
            tags = "Почтовое отделение"
    )
    @PostMapping
    public ResponseEntity<ResponseEntity<PostOffice>> addPostOffice(@RequestParam(name = "индекс") int index,
                                                                          @RequestParam(name = "название") String name,
                                                                          @RequestParam (name = "адрес") String address){
        PostOffice postOff = new PostOffice();
        postOff.setIndex(index);
        postOff.setName(name);
        postOff.setAddress(address);

      return ResponseEntity.ok(service.save(postOff));
    }

    @Operation(
            summary = "Удалить почтовое отделение",
            tags = "Почтовое отделение"
    )
    @DeleteMapping
    public ResponseEntity<String> removePostOffice(@RequestParam(name = "идентификатор почтового отправления") Long id) {
        return ResponseEntity.ok(service.removePostOffice(id));
    }

    @Operation(
            summary = "Показать все почтовые отделения",
            tags = "Почтовое отделение"
    )
    @GetMapping
    public List<PostOfficeDTO> getAllPostOffice() {
        return service.findAll()
                .stream()
                .map(mappingPostalOffice::mapToDTO)
                .collect(Collectors.toList());
    }

}
