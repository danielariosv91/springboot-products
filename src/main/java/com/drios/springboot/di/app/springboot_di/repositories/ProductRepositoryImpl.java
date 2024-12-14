package com.drios.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;
import com.drios.springboot.di.app.springboot_di.models.Product;

public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "The Killing Joke", 9L),
                new Product(2L, "The Red Song", 12L));
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(item -> item.getId().equals(id)).findFirst().orElseThrow();
    }
}
