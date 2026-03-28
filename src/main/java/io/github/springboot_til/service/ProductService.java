package io.github.springboot_til.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.github.springboot_til.domain.Product;
import io.github.springboot_til.repository.ProductRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService { 
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(@NonNull UUID id) {
        return productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product create(Product product) {
        if(productRepository.existsByProductName(product.getProductName())) {
            throw new RuntimeException("Product already exists");
        }
        
        return productRepository.save(product);

    }

    public Product update(UUID id, Product updateProduct) {
        Product product = findById(id);

        product.setProductName(updateProduct.getProductName());
        product.setPrice(updateProduct.getPrice());
        product.setCategory(updateProduct.getCategory());

        return productRepository.save(product);

    }

    public void delete(@NonNull UUID id) {
        productRepository.deleteById(id);
    }
}
