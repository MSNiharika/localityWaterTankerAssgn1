package com.mams.login.repository;

import com.mams.login.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByIsAvailable(boolean isAvailable);
    List<Product> findByTitle(String title);
}
