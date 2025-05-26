package com.example.postapp.repository;

import com.example.postapp.model.PostalItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostalItemsRepository extends JpaRepository<PostalItems, Long> {

}
