package com.example.postapp.repository;

import com.example.postapp.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

 @Query(value = "SELECT * FROM transactions WHERE postal_items_id = :id ORDER BY time DESC", nativeQuery = true)
    List<Transactions> findAllById(@Param("id") Long id);

}
