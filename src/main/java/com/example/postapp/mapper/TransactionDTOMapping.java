package com.example.postapp.mapper;


import com.example.postapp.dto.TransactionsDTO;
import com.example.postapp.model.Transactions;
import org.springframework.stereotype.Component;

@Component
public class TransactionDTOMapping {

    public TransactionsDTO mapToDTO(Transactions transactions) {
        TransactionsDTO transactionsDTO = new TransactionsDTO();
        transactionsDTO.setTime(transactions.getTime());
        transactionsDTO.setPostOfficeAddress(transactions.getPostOffice().getAddress());
        transactionsDTO.setStatus(transactions.getStatus());
        transactionsDTO.setPostalItemsId(transactions.getPostalItems().getId());
        return transactionsDTO;
    }
}
