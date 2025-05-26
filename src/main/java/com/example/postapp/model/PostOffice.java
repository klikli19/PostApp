package com.example.postapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post_office")
public class PostOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int index;
    private String name;
    private String address;

    @OneToMany(mappedBy = "postOffice")
    @JsonIgnore
    private List<Transactions> transactions;

    private static long postOfficeId = 1;

}
