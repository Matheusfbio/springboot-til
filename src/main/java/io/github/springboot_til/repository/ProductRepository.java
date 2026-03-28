package io.github.springboot_til.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.springboot_til.domain.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    boolean existsByProductName(String productName);
}
