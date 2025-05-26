package com.example.postapp.dto;


import com.example.postapp.model.Transactions;
import com.example.postapp.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class PostalItemsDTO {
    private Long id;
    private String name;
    private Type type;
    private int indexRecipient ;
    private String addressRecipient;
    List<Transactions> transactions;

}
