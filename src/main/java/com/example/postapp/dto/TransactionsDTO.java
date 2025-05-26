package com.example.postapp.dto;

import com.example.postapp.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsDTO {
    private Instant time;
    private String postOfficeAddress;
    private Status status;
    private long postalItemsId;

}
