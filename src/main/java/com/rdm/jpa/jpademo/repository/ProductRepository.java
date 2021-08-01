package com.rdm.jpa.jpademo.repository;

import com.rdm.jpa.jpademo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}