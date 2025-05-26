package com.example.postapp.model;

import com.example.postapp.enums.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "postal_items")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class PostalItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;
    private int indexRecipient ;
    private String addressRecipient;

   @OneToMany(mappedBy = "postalItems")
   @JsonIgnore
    private List<Transactions> transactions;

    private static long postalItemsId = 1;



}
