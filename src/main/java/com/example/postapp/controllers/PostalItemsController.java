package com.example.postapp.controllers;

import com.example.postapp.dto.TransactionsDTO;
import com.example.postapp.model.PostalItems;
import com.example.postapp.model.Transactions;
import com.example.postapp.enums.Status;
import com.example.postapp.enums.Type;
import com.example.postapp.service.PostOfficeService;
import com.example.postapp.service.PostalItemsService;
import com.example.postapp.service.TransactionsService;
import com.example.postapp.mapper.TransactionDTOMapping;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("postalItems")
@RestController
public class PostalItemsController {

    private final PostalItemsService service;
    private final PostOfficeService officeService;
    private final TransactionsService transactionsService;
    private final TransactionDTOMapping mapping;

    public PostalItemsController(PostalItemsService service, PostOfficeService officeService, TransactionsService transactionsService, TransactionDTOMapping mapping) {
        this.service = service;
        this.officeService = officeService;
        this.transactionsService = transactionsService;
        this.mapping = mapping;
    }

    @Operation(
            summary = "Регистрация почтового отправлении",
            tags = "Операции с почтовым отправлением"
    )
    @PostMapping("/registration")
    public ResponseEntity<Transactions> registration(@RequestParam(name = "имя получателя") String name,
                                                     @RequestParam(name = "тип отправления") Type type,
                                                     @RequestParam(name = "индекс получателя") int indexRecipient,
                                                     @RequestParam(name = "адрес получателя") String addressRecipient,
                                                     @RequestParam(name = "id почтового отделения, которое принимает посылку") Long idPostOffice ){

        PostalItems postalItems = new PostalItems();
        postalItems.setName(name);
        postalItems.setType(type);
        postalItems.setIndexRecipient(indexRecipient);
        postalItems.setAddressRecipient(addressRecipient);

        service.save(postalItems);

        Transactions transactions = new Transactions();
        transactions.setPostalItems(postalItems);
        transactions.setStatus(Status.REGISTRATION);
        transactions.setPostOffice(officeService.findById(idPostOffice));
        transactionsService.save(transactions);

        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Прибытие в промежуточное почтовое отделение",
            tags = "Операции с почтовым отправлением"
    )
    @PutMapping
    public ResponseEntity<Transactions> arrivalIntermediatePostOffice(@RequestParam(name = "идентификатор почты") Long idPostOffice,
                                                                                      @RequestParam(name = "идентификатор почтового отправления") Long idPostalItems,
                                                                                      @RequestParam(name = "статус посылки") Status status) {

        Transactions transactions = new Transactions();
        transactions.setPostOffice(officeService.findById(idPostOffice));
        transactions.setPostalItems(service.findById(idPostalItems));
        transactions.setStatus(status);

        transactionsService.arrivalIntermediatePostOffice(transactions);

        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "просмотр статуса и полной истории движения почтового отправления",
            tags = "Операции с почтовым отправлением"
    )
    @GetMapping("/{id}")
    public ResponseEntity<List<TransactionsDTO>> viewingStatusAndMovementsPostalItem(@RequestParam("идентификатор почтового отправления") Long id) {

        viewingStatus(id);
        return ResponseEntity.ok(transactionsService.findAllById(id)
                .stream()
                .map(mapping::mapToDTO)
                .collect(Collectors.toList())
        );
    }
    @Operation(
            summary = "просмотр статуса",
            tags = "Операции с почтовым отправлением"
    )
    @GetMapping("/{id}/status")
    public Optional<TransactionsDTO> viewingStatus(@PathVariable Long id) {
        return transactionsService.findByIdStatus(id).stream()
                .map(mapping::mapToDTO)
                .findFirst();
    }
}

